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
    private a fic;
    private q fie;
    private String fif;
    private String fig;
    private List<C0595b> fih = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.fif = str;
        this.fig = str2;
    }

    public q CM(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.fif);
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
        p BJ = com.baidu.tbadk.core.util.c.BJ(md5);
        if (BJ == null) {
            BJ = new p();
            BJ.setMd5(md5);
            BJ.setChunkNo(0);
            BJ.setTotalLength(file.length());
        }
        this.fic = new a(str, BJ, TbConfig.SERVER_ADDRESS + this.fif, md5);
        this.fie = this.fic.bwQ();
        if (this.fie.isSuccess() && (a2 = a(md5, BJ)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                BJ.setMd5(audioInfoData.getVoiceId());
                this.fie.b(BJ);
            } else {
                this.fie.setErrorCode(audioInfoData.getErrorCode());
                this.fie.setErrorString(audioInfoData.getErrorUserMsg());
                this.fie.setIsSuccess(false);
            }
        }
        return this.fie;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.fig);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (y.getCount(this.fih) != 0) {
            for (C0595b c0595b : this.fih) {
                if (c0595b != null) {
                    this.mNetwork.addPostData(c0595b.getKey(), c0595b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.btv().buf().isRequestSuccess()) {
            pVar.setChunkNo((int) ec(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.fie.setErrorCode(this.mNetwork.getServerErrorCode());
            this.fie.setErrorString(this.mNetwork.getErrorString());
            this.fie.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.BI(str);
        return postNetData;
    }

    private long ec(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa cfI;
        private p fii;
        private boolean fij = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.fii = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.fii = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q bwQ() throws IOException {
            q qVar = new q();
            long totalLength = this.fii.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.fii.getChunkNo();
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
                                this.cfI = new aa(this.mUrl);
                                this.cfI.addPostData("voice_chunk", bArr);
                                this.cfI.addPostData("chunk_md5", this.fii.getMd5());
                                this.cfI.addPostData("length", String.valueOf(read));
                                this.cfI.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.cfI.addPostData("total_length", String.valueOf(totalLength));
                                this.cfI.addPostData("chunk_no", String.valueOf(i + 1));
                                this.cfI.addPostData("total_num", String.valueOf(j));
                                this.cfI.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.fij) {
                                    z = true;
                                } else if (this.cfI.postMultiNetData() == null || !this.cfI.btv().buf().isRequestSuccess()) {
                                    this.fii.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.fii);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.cfI.getServerErrorCode());
                                    qVar.setErrorString(this.cfI.getErrorString());
                                    qVar.b(this.fii);
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
    public class C0595b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0595b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.fih.add(new C0595b(str, String.valueOf(i)));
    }
}
