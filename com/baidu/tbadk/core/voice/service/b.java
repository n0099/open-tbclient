package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a csU;
    private l csV;
    private String csW;
    private String csX;
    private List<C0281b> csY = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.csW = str;
        this.csX = str2;
    }

    public l oG(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.csW);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l c(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(m.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        k nD = com.baidu.tbadk.core.util.c.nD(md5);
        if (nD == null) {
            nD = new k();
            nD.setMd5(md5);
            nD.setChunkNo(0);
            nD.setTotalLength(file.length());
        }
        this.csU = new a(str, nD, TbConfig.SERVER_ADDRESS + this.csW, md5);
        this.csV = this.csU.aoB();
        if (this.csV.isSuccess() && (a2 = a(md5, nD)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                nD.setMd5(audioInfoData.getVoiceId());
                this.csV.b(nD);
            } else {
                this.csV.setErrorCode(audioInfoData.getErrorCode());
                this.csV.setErrorString(audioInfoData.getErrorUserMsg());
                this.csV.setIsSuccess(false);
            }
        }
        return this.csV;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.csX);
        this.mNetwork.addPostData("voice_md5", kVar.getMd5());
        if (v.getCount(this.csY) != 0) {
            for (C0281b c0281b : this.csY) {
                if (c0281b != null) {
                    this.mNetwork.addPostData(c0281b.getKey(), c0281b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.amp().amQ().isRequestSuccess()) {
            kVar.setChunkNo((int) aX(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.csV.setErrorCode(this.mNetwork.getServerErrorCode());
            this.csV.setErrorString(this.mNetwork.getErrorString());
            this.csV.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.nC(str);
        return postNetData;
    }

    private long aX(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private x bUY;
        private k csZ;
        private boolean cta = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.csZ = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.csZ = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l aoB() throws IOException {
            l lVar = new l();
            long totalLength = this.csZ.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.csZ.getChunkNo();
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
                                this.bUY = new x(this.mUrl);
                                this.bUY.addPostData("voice_chunk", bArr);
                                this.bUY.addPostData("chunk_md5", this.csZ.getMd5());
                                this.bUY.addPostData("length", String.valueOf(read));
                                this.bUY.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bUY.addPostData("total_length", String.valueOf(totalLength));
                                this.bUY.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bUY.addPostData("total_num", String.valueOf(j));
                                this.bUY.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.cta) {
                                    z = true;
                                } else if (this.bUY.postMultiNetData() == null || !this.bUY.amp().amQ().isRequestSuccess()) {
                                    this.csZ.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.csZ);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.bUY.getServerErrorCode());
                                    lVar.setErrorString(this.bUY.getErrorString());
                                    lVar.b(this.csZ);
                                    lVar.setIsSuccess(false);
                                    return lVar;
                                }
                            }
                            chunkNo = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.setIsSuccess(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.setIsSuccess(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0281b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0281b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.csY.add(new C0281b(str, String.valueOf(i)));
    }
}
