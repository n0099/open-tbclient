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
    private a dgT;
    private l dgU;
    private String dgV;
    private String dgW;
    private List<C0371b> dgX = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.dgV = str;
        this.dgW = str2;
    }

    public l tO(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dgV);
            return m(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l m(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(m.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        k sQ = com.baidu.tbadk.core.util.c.sQ(md5);
        if (sQ == null) {
            sQ = new k();
            sQ.setMd5(md5);
            sQ.setChunkNo(0);
            sQ.setTotalLength(file.length());
        }
        this.dgT = new a(str, sQ, TbConfig.SERVER_ADDRESS + this.dgV, md5);
        this.dgU = this.dgT.aGw();
        if (this.dgU.isSuccess() && (a2 = a(md5, sQ)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                sQ.setMd5(audioInfoData.getVoiceId());
                this.dgU.b(sQ);
            } else {
                this.dgU.setErrorCode(audioInfoData.getErrorCode());
                this.dgU.setErrorString(audioInfoData.getErrorUserMsg());
                this.dgU.setIsSuccess(false);
            }
        }
        return this.dgU;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dgW);
        this.mNetwork.addPostData("voice_md5", kVar.getMd5());
        if (v.getCount(this.dgX) != 0) {
            for (C0371b c0371b : this.dgX) {
                if (c0371b != null) {
                    this.mNetwork.addPostData(c0371b.getKey(), c0371b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.aDU().aEv().isRequestSuccess()) {
            kVar.setChunkNo((int) bC(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.dgU.setErrorCode(this.mNetwork.getServerErrorCode());
            this.dgU.setErrorString(this.mNetwork.getErrorString());
            this.dgU.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.sP(str);
        return postNetData;
    }

    private long bC(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean Tq = false;
        private x cHA;
        private k dgY;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.dgY = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.dgY = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l aGw() throws IOException {
            l lVar = new l();
            long totalLength = this.dgY.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.dgY.getChunkNo();
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
                                this.cHA = new x(this.mUrl);
                                this.cHA.addPostData("voice_chunk", bArr);
                                this.cHA.addPostData("chunk_md5", this.dgY.getMd5());
                                this.cHA.addPostData("length", String.valueOf(read));
                                this.cHA.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.cHA.addPostData("total_length", String.valueOf(totalLength));
                                this.cHA.addPostData("chunk_no", String.valueOf(i + 1));
                                this.cHA.addPostData("total_num", String.valueOf(j));
                                this.cHA.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.Tq) {
                                    z = true;
                                } else if (this.cHA.postMultiNetData() == null || !this.cHA.aDU().aEv().isRequestSuccess()) {
                                    this.dgY.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.dgY);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.cHA.getServerErrorCode());
                                    lVar.setErrorString(this.cHA.getErrorString());
                                    lVar.b(this.dgY);
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
    public class C0371b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0371b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.dgX.add(new C0371b(str, String.valueOf(i)));
    }
}
