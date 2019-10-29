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
    private a ctL;
    private l ctM;
    private String ctN;
    private String ctO;
    private List<C0286b> ctP = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.ctN = str;
        this.ctO = str2;
    }

    public l oG(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.ctN);
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
        this.ctL = new a(str, nD, TbConfig.SERVER_ADDRESS + this.ctN, md5);
        this.ctM = this.ctL.aoD();
        if (this.ctM.isSuccess() && (a2 = a(md5, nD)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                nD.setMd5(audioInfoData.getVoiceId());
                this.ctM.b(nD);
            } else {
                this.ctM.setErrorCode(audioInfoData.getErrorCode());
                this.ctM.setErrorString(audioInfoData.getErrorUserMsg());
                this.ctM.setIsSuccess(false);
            }
        }
        return this.ctM;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.ctO);
        this.mNetwork.addPostData("voice_md5", kVar.getMd5());
        if (v.getCount(this.ctP) != 0) {
            for (C0286b c0286b : this.ctP) {
                if (c0286b != null) {
                    this.mNetwork.addPostData(c0286b.getKey(), c0286b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.amr().amS().isRequestSuccess()) {
            kVar.setChunkNo((int) aY(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.ctM.setErrorCode(this.mNetwork.getServerErrorCode());
            this.ctM.setErrorString(this.mNetwork.getErrorString());
            this.ctM.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.nC(str);
        return postNetData;
    }

    private long aY(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private x bVP;
        private k ctQ;
        private boolean ctR = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.ctQ = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.ctQ = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l aoD() throws IOException {
            l lVar = new l();
            long totalLength = this.ctQ.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.ctQ.getChunkNo();
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
                                this.bVP = new x(this.mUrl);
                                this.bVP.addPostData("voice_chunk", bArr);
                                this.bVP.addPostData("chunk_md5", this.ctQ.getMd5());
                                this.bVP.addPostData("length", String.valueOf(read));
                                this.bVP.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bVP.addPostData("total_length", String.valueOf(totalLength));
                                this.bVP.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bVP.addPostData("total_num", String.valueOf(j));
                                this.bVP.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.ctR) {
                                    z = true;
                                } else if (this.bVP.postMultiNetData() == null || !this.bVP.amr().amS().isRequestSuccess()) {
                                    this.ctQ.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.ctQ);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.bVP.getServerErrorCode());
                                    lVar.setErrorString(this.bVP.getErrorString());
                                    lVar.b(this.ctQ);
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
    public class C0286b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0286b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.ctP.add(new C0286b(str, String.valueOf(i)));
    }
}
