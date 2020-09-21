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
    private a eBf;
    private q eBg;
    private String eBh;
    private String eBi;
    private List<C0540b> eBj = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.eBh = str;
        this.eBi = str2;
    }

    public q Bm(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eBh);
            return n(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private q n(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        p Ak = com.baidu.tbadk.core.util.c.Ak(md5);
        if (Ak == null) {
            Ak = new p();
            Ak.setMd5(md5);
            Ak.setChunkNo(0);
            Ak.setTotalLength(file.length());
        }
        this.eBf = new a(str, Ak, TbConfig.SERVER_ADDRESS + this.eBh, md5);
        this.eBg = this.eBf.bmX();
        if (this.eBg.isSuccess() && (a2 = a(md5, Ak)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                Ak.setMd5(audioInfoData.getVoiceId());
                this.eBg.b(Ak);
            } else {
                this.eBg.setErrorCode(audioInfoData.getErrorCode());
                this.eBg.setErrorString(audioInfoData.getErrorUserMsg());
                this.eBg.setIsSuccess(false);
            }
        }
        return this.eBg;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eBi);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (y.getCount(this.eBj) != 0) {
            for (C0540b c0540b : this.eBj) {
                if (c0540b != null) {
                    this.mNetwork.addPostData(c0540b.getKey(), c0540b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bjL().bkr().isRequestSuccess()) {
            pVar.setChunkNo((int) cX(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.eBg.setErrorCode(this.mNetwork.getServerErrorCode());
            this.eBg.setErrorString(this.mNetwork.getErrorString());
            this.eBg.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.Aj(str);
        return postNetData;
    }

    private long cX(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa bGb;
        private p eBk;
        private boolean eBl = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.eBk = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.eBk = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q bmX() throws IOException {
            q qVar = new q();
            long totalLength = this.eBk.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.eBk.getChunkNo();
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
                                this.bGb = new aa(this.mUrl);
                                this.bGb.addPostData("voice_chunk", bArr);
                                this.bGb.addPostData("chunk_md5", this.eBk.getMd5());
                                this.bGb.addPostData("length", String.valueOf(read));
                                this.bGb.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bGb.addPostData("total_length", String.valueOf(totalLength));
                                this.bGb.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bGb.addPostData("total_num", String.valueOf(j));
                                this.bGb.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.eBl) {
                                    z = true;
                                } else if (this.bGb.postMultiNetData() == null || !this.bGb.bjL().bkr().isRequestSuccess()) {
                                    this.eBk.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.eBk);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.bGb.getServerErrorCode());
                                    qVar.setErrorString(this.bGb.getErrorString());
                                    qVar.b(this.eBk);
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
    public class C0540b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0540b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.eBj.add(new C0540b(str, String.valueOf(i)));
    }
}
