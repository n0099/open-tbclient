package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
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
    private a eoL;
    private m eoM;
    private String eoN;
    private String eoO;
    private List<C0499b> eoP = new ArrayList();
    private z mNetwork;

    public b(String str, String str2) {
        this.eoN = str;
        this.eoO = str2;
    }

    public m yA(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.eoN);
            return n(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private m n(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        l xz = com.baidu.tbadk.core.util.c.xz(md5);
        if (xz == null) {
            xz = new l();
            xz.setMd5(md5);
            xz.setChunkNo(0);
            xz.setTotalLength(file.length());
        }
        this.eoL = new a(str, xz, TbConfig.SERVER_ADDRESS + this.eoN, md5);
        this.eoM = this.eoL.bdx();
        if (this.eoM.isSuccess() && (a2 = a(md5, xz)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                xz.setMd5(audioInfoData.getVoiceId());
                this.eoM.b(xz);
            } else {
                this.eoM.setErrorCode(audioInfoData.getErrorCode());
                this.eoM.setErrorString(audioInfoData.getErrorUserMsg());
                this.eoM.setIsSuccess(false);
            }
        }
        return this.eoM;
    }

    private String a(String str, l lVar) {
        this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.eoO);
        this.mNetwork.addPostData("voice_md5", lVar.getMd5());
        if (x.getCount(this.eoP) != 0) {
            for (C0499b c0499b : this.eoP) {
                if (c0499b != null) {
                    this.mNetwork.addPostData(c0499b.getKey(), c0499b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bav().baX().isRequestSuccess()) {
            lVar.setChunkNo((int) cL(lVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(lVar);
            this.eoM.setErrorCode(this.mNetwork.getServerErrorCode());
            this.eoM.setErrorString(this.mNetwork.getErrorString());
            this.eoM.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.xy(str);
        return postNetData;
    }

    private long cL(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private z byq;
        private l eoQ;
        private boolean eoR = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, l lVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.eoQ = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.eoQ = lVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public m bdx() throws IOException {
            m mVar = new m();
            long totalLength = this.eoQ.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.eoQ.getChunkNo();
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
                                this.byq = new z(this.mUrl);
                                this.byq.addPostData("voice_chunk", bArr);
                                this.byq.addPostData("chunk_md5", this.eoQ.getMd5());
                                this.byq.addPostData("length", String.valueOf(read));
                                this.byq.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.byq.addPostData("total_length", String.valueOf(totalLength));
                                this.byq.addPostData("chunk_no", String.valueOf(i + 1));
                                this.byq.addPostData("total_num", String.valueOf(j));
                                this.byq.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.eoR) {
                                    z = true;
                                } else if (this.byq.postMultiNetData() == null || !this.byq.bav().baX().isRequestSuccess()) {
                                    this.eoQ.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.eoQ);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    mVar.setErrorCode(this.byq.getServerErrorCode());
                                    mVar.setErrorString(this.byq.getErrorString());
                                    mVar.b(this.eoQ);
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
    public class C0499b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0499b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.eoP.add(new C0499b(str, String.valueOf(i)));
    }
}
