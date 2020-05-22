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
    private a dZP;
    private m dZQ;
    private String dZR;
    private String dZS;
    private List<C0480b> dZT = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.dZR = str;
        this.dZS = str2;
    }

    public m xc(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dZR);
            return l(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private m l(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(com.baidu.tbadk.core.util.m.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        l wc = com.baidu.tbadk.core.util.c.wc(md5);
        if (wc == null) {
            wc = new l();
            wc.setMd5(md5);
            wc.setChunkNo(0);
            wc.setTotalLength(file.length());
        }
        this.dZP = new a(str, wc, TbConfig.SERVER_ADDRESS + this.dZR, md5);
        this.dZQ = this.dZP.aXt();
        if (this.dZQ.isSuccess() && (a2 = a(md5, wc)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                wc.setMd5(audioInfoData.getVoiceId());
                this.dZQ.b(wc);
            } else {
                this.dZQ.setErrorCode(audioInfoData.getErrorCode());
                this.dZQ.setErrorString(audioInfoData.getErrorUserMsg());
                this.dZQ.setIsSuccess(false);
            }
        }
        return this.dZQ;
    }

    private String a(String str, l lVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dZS);
        this.mNetwork.addPostData("voice_md5", lVar.getMd5());
        if (v.getCount(this.dZT) != 0) {
            for (C0480b c0480b : this.dZT) {
                if (c0480b != null) {
                    this.mNetwork.addPostData(c0480b.getKey(), c0480b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.aUA().aVb().isRequestSuccess()) {
            lVar.setChunkNo((int) cp(lVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(lVar);
            this.dZQ.setErrorCode(this.mNetwork.getServerErrorCode());
            this.dZQ.setErrorString(this.mNetwork.getErrorString());
            this.dZQ.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.wb(str);
        return postNetData;
    }

    private long cp(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private x bth;
        private l dZU;
        private boolean dZV = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, l lVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.dZU = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.dZU = lVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public m aXt() throws IOException {
            m mVar = new m();
            long totalLength = this.dZU.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.dZU.getChunkNo();
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
                                this.bth = new x(this.mUrl);
                                this.bth.addPostData("voice_chunk", bArr);
                                this.bth.addPostData("chunk_md5", this.dZU.getMd5());
                                this.bth.addPostData("length", String.valueOf(read));
                                this.bth.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bth.addPostData("total_length", String.valueOf(totalLength));
                                this.bth.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bth.addPostData("total_num", String.valueOf(j));
                                this.bth.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.dZV) {
                                    z = true;
                                } else if (this.bth.postMultiNetData() == null || !this.bth.aUA().aVb().isRequestSuccess()) {
                                    this.dZU.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.dZU);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    mVar.setErrorCode(this.bth.getServerErrorCode());
                                    mVar.setErrorString(this.bth.getErrorString());
                                    mVar.b(this.dZU);
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
    public class C0480b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0480b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.dZT.add(new C0480b(str, String.valueOf(i)));
    }
}
