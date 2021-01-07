package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.q;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a frO;
    private q frP;
    private String frQ;
    private String frR;
    private List<C0586b> frS = new ArrayList();
    private z mNetwork;

    public b(String str, String str2) {
        this.frQ = str;
        this.frR = str2;
    }

    public q CJ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.frQ);
            return p(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private q p(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        p BH = com.baidu.tbadk.core.util.c.BH(md5);
        if (BH == null) {
            BH = new p();
            BH.setMd5(md5);
            BH.setChunkNo(0);
            BH.setTotalLength(file.length());
        }
        this.frO = new a(str, BH, TbConfig.SERVER_ADDRESS + this.frQ, md5);
        this.frP = this.frO.bzk();
        if (this.frP.isSuccess() && (a2 = a(md5, BH)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                BH.setMd5(audioInfoData.getVoiceId());
                this.frP.b(BH);
            } else {
                this.frP.setErrorCode(audioInfoData.getErrorCode());
                this.frP.setErrorString(audioInfoData.getErrorUserMsg());
                this.frP.setIsSuccess(false);
            }
        }
        return this.frP;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.frR);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (x.getCount(this.frS) != 0) {
            for (C0586b c0586b : this.frS) {
                if (c0586b != null) {
                    this.mNetwork.addPostData(c0586b.getKey(), c0586b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bvR().bwB().isRequestSuccess()) {
            pVar.setChunkNo((int) ec(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.frP.setErrorCode(this.mNetwork.getServerErrorCode());
            this.frP.setErrorString(this.mNetwork.getErrorString());
            this.frP.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.BG(str);
        return postNetData;
    }

    private long ec(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private z cmJ;
        private p frT;
        private boolean frU = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.frT = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.frT = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q bzk() throws IOException {
            q qVar = new q();
            long totalLength = this.frT.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.frT.getChunkNo();
            if (chunkNo < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(chunkNo * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= chunkNo * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = chunkNo;
                        if (i < j) {
                            int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            if (i == j - 1) {
                                i2 = (int) (totalLength - (30720 * (j - 1)));
                            }
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile.read(bArr, 0, i2);
                            if (read != -1) {
                                this.cmJ = new z(this.mUrl);
                                this.cmJ.addPostData("voice_chunk", bArr);
                                this.cmJ.addPostData("chunk_md5", this.frT.getMd5());
                                this.cmJ.addPostData("length", String.valueOf(read));
                                this.cmJ.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.cmJ.addPostData("total_length", String.valueOf(totalLength));
                                this.cmJ.addPostData("chunk_no", String.valueOf(i + 1));
                                this.cmJ.addPostData("total_num", String.valueOf(j));
                                this.cmJ.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.frU) {
                                    z = true;
                                } else if (this.cmJ.postMultiNetData() == null || !this.cmJ.bvR().bwB().isRequestSuccess()) {
                                    this.frT.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.frT);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.cmJ.getServerErrorCode());
                                    qVar.setErrorString(this.cmJ.getErrorString());
                                    qVar.b(this.frT);
                                    qVar.setIsSuccess(false);
                                    return qVar;
                                }
                            }
                            chunkNo = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    qVar.setIsSuccess(false);
                    randomAccessFile.close();
                    return qVar;
                }
            }
            qVar.setIsSuccess(true);
            return qVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0586b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0586b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.frS.add(new C0586b(str, String.valueOf(i)));
    }
}
