package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
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
    private a faF;
    private q faG;
    private String faH;
    private String faI;
    private List<C0582b> faJ = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.faH = str;
        this.faI = str2;
    }

    public q Ce(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.faH);
            return m(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private q m(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        p Bc = com.baidu.tbadk.core.util.c.Bc(md5);
        if (Bc == null) {
            Bc = new p();
            Bc.setMd5(md5);
            Bc.setChunkNo(0);
            Bc.setTotalLength(file.length());
        }
        this.faF = new a(str, Bc, TbConfig.SERVER_ADDRESS + this.faH, md5);
        this.faG = this.faF.btq();
        if (this.faG.isSuccess() && (a2 = a(md5, Bc)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                Bc.setMd5(audioInfoData.getVoiceId());
                this.faG.b(Bc);
            } else {
                this.faG.setErrorCode(audioInfoData.getErrorCode());
                this.faG.setErrorString(audioInfoData.getErrorUserMsg());
                this.faG.setIsSuccess(false);
            }
        }
        return this.faG;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.faI);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (y.getCount(this.faJ) != 0) {
            for (C0582b c0582b : this.faJ) {
                if (c0582b != null) {
                    this.mNetwork.addPostData(c0582b.getKey(), c0582b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bqa().bqI().isRequestSuccess()) {
            pVar.setChunkNo((int) dD(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.faG.setErrorCode(this.mNetwork.getServerErrorCode());
            this.faG.setErrorString(this.mNetwork.getErrorString());
            this.faG.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.Bb(str);
        return postNetData;
    }

    private long dD(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa bZh;
        private p faK;
        private boolean faL = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.faK = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.faK = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q btq() throws IOException {
            q qVar = new q();
            long totalLength = this.faK.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.faK.getChunkNo();
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
                                this.bZh = new aa(this.mUrl);
                                this.bZh.addPostData("voice_chunk", bArr);
                                this.bZh.addPostData("chunk_md5", this.faK.getMd5());
                                this.bZh.addPostData("length", String.valueOf(read));
                                this.bZh.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bZh.addPostData("total_length", String.valueOf(totalLength));
                                this.bZh.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bZh.addPostData("total_num", String.valueOf(j));
                                this.bZh.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.faL) {
                                    z = true;
                                } else if (this.bZh.postMultiNetData() == null || !this.bZh.bqa().bqI().isRequestSuccess()) {
                                    this.faK.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.faK);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.bZh.getServerErrorCode());
                                    qVar.setErrorString(this.bZh.getErrorString());
                                    qVar.b(this.faK);
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
    public class C0582b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0582b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.faJ.add(new C0582b(str, String.valueOf(i)));
    }
}
