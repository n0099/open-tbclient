package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a dlA;
    private m dlB;
    private String dlC;
    private String dlD;
    private List<C0381b> dlE = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.dlC = str;
        this.dlD = str2;
    }

    public m uf(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dlC);
            return m(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private m m(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(com.baidu.tbadk.core.util.m.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        l tg = com.baidu.tbadk.core.util.c.tg(md5);
        if (tg == null) {
            tg = new l();
            tg.setMd5(md5);
            tg.setChunkNo(0);
            tg.setTotalLength(file.length());
        }
        this.dlA = new a(str, tg, TbConfig.SERVER_ADDRESS + this.dlC, md5);
        this.dlB = this.dlA.aIS();
        if (this.dlB.isSuccess() && (a2 = a(md5, tg)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                tg.setMd5(audioInfoData.getVoiceId());
                this.dlB.b(tg);
            } else {
                this.dlB.setErrorCode(audioInfoData.getErrorCode());
                this.dlB.setErrorString(audioInfoData.getErrorUserMsg());
                this.dlB.setIsSuccess(false);
            }
        }
        return this.dlB;
    }

    private String a(String str, l lVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dlD);
        this.mNetwork.addPostData("voice_md5", lVar.getMd5());
        if (v.getCount(this.dlE) != 0) {
            for (C0381b c0381b : this.dlE) {
                if (c0381b != null) {
                    this.mNetwork.addPostData(c0381b.getKey(), c0381b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.aGk().aGM().isRequestSuccess()) {
            lVar.setChunkNo((int) bG(lVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(lVar);
            this.dlB.setErrorCode(this.mNetwork.getServerErrorCode());
            this.dlB.setErrorString(this.mNetwork.getErrorString());
            this.dlB.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.tf(str);
        return postNetData;
    }

    private long bG(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean Vh = false;
        private x cLQ;
        private l dlF;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, l lVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.dlF = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.dlF = lVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public m aIS() throws IOException {
            m mVar = new m();
            long totalLength = this.dlF.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.dlF.getChunkNo();
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
                                this.cLQ = new x(this.mUrl);
                                this.cLQ.addPostData("voice_chunk", bArr);
                                this.cLQ.addPostData("chunk_md5", this.dlF.getMd5());
                                this.cLQ.addPostData("length", String.valueOf(read));
                                this.cLQ.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.cLQ.addPostData("total_length", String.valueOf(totalLength));
                                this.cLQ.addPostData("chunk_no", String.valueOf(i + 1));
                                this.cLQ.addPostData("total_num", String.valueOf(j));
                                this.cLQ.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.Vh) {
                                    z = true;
                                } else if (this.cLQ.postMultiNetData() == null || !this.cLQ.aGk().aGM().isRequestSuccess()) {
                                    this.dlF.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.dlF);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    mVar.setErrorCode(this.cLQ.getServerErrorCode());
                                    mVar.setErrorString(this.cLQ.getErrorString());
                                    mVar.b(this.dlF);
                                    mVar.setIsSuccess(false);
                                    return mVar;
                                }
                            }
                            chunkNo = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    mVar.setIsSuccess(false);
                    randomAccessFile.close();
                    return mVar;
                }
            }
            mVar.setIsSuccess(true);
            return mVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0381b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0381b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.dlE.add(new C0381b(str, String.valueOf(i)));
    }
}
