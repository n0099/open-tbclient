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
    private a dgH;
    private l dgI;
    private String dgJ;
    private String dgK;
    private List<C0369b> dgL = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.dgJ = str;
        this.dgK = str2;
    }

    public l tK(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dgJ);
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
        k sN = com.baidu.tbadk.core.util.c.sN(md5);
        if (sN == null) {
            sN = new k();
            sN.setMd5(md5);
            sN.setChunkNo(0);
            sN.setTotalLength(file.length());
        }
        this.dgH = new a(str, sN, TbConfig.SERVER_ADDRESS + this.dgJ, md5);
        this.dgI = this.dgH.aGd();
        if (this.dgI.isSuccess() && (a2 = a(md5, sN)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                sN.setMd5(audioInfoData.getVoiceId());
                this.dgI.b(sN);
            } else {
                this.dgI.setErrorCode(audioInfoData.getErrorCode());
                this.dgI.setErrorString(audioInfoData.getErrorUserMsg());
                this.dgI.setIsSuccess(false);
            }
        }
        return this.dgI;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dgK);
        this.mNetwork.addPostData("voice_md5", kVar.getMd5());
        if (v.getCount(this.dgL) != 0) {
            for (C0369b c0369b : this.dgL) {
                if (c0369b != null) {
                    this.mNetwork.addPostData(c0369b.getKey(), c0369b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.aDB().aEc().isRequestSuccess()) {
            kVar.setChunkNo((int) bz(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.dgI.setErrorCode(this.mNetwork.getServerErrorCode());
            this.dgI.setErrorString(this.mNetwork.getErrorString());
            this.dgI.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.sM(str);
        return postNetData;
    }

    private long bz(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private boolean Tn = false;
        private x cHo;
        private k dgM;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.dgM = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.dgM = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l aGd() throws IOException {
            l lVar = new l();
            long totalLength = this.dgM.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.dgM.getChunkNo();
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
                                this.cHo = new x(this.mUrl);
                                this.cHo.addPostData("voice_chunk", bArr);
                                this.cHo.addPostData("chunk_md5", this.dgM.getMd5());
                                this.cHo.addPostData("length", String.valueOf(read));
                                this.cHo.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.cHo.addPostData("total_length", String.valueOf(totalLength));
                                this.cHo.addPostData("chunk_no", String.valueOf(i + 1));
                                this.cHo.addPostData("total_num", String.valueOf(j));
                                this.cHo.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.Tn) {
                                    z = true;
                                } else if (this.cHo.postMultiNetData() == null || !this.cHo.aDB().aEc().isRequestSuccess()) {
                                    this.dgM.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.dgM);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.cHo.getServerErrorCode());
                                    lVar.setErrorString(this.cHo.getErrorString());
                                    lVar.b(this.dgM);
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
    public class C0369b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0369b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.dgL.add(new C0369b(str, String.valueOf(i)));
    }
}
