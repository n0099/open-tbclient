package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
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
    private a fnd;
    private q fne;
    private String fnf;
    private String fng;
    private List<C0569b> fnh = new ArrayList();
    private z mNetwork;

    public b(String str, String str2) {
        this.fnf = str;
        this.fng = str2;
    }

    public q By(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.fnf);
            return p(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private q p(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        p Aw = com.baidu.tbadk.core.util.c.Aw(md5);
        if (Aw == null) {
            Aw = new p();
            Aw.setMd5(md5);
            Aw.setChunkNo(0);
            Aw.setTotalLength(file.length());
        }
        this.fnd = new a(str, Aw, TbConfig.SERVER_ADDRESS + this.fnf, md5);
        this.fne = this.fnd.bvq();
        if (this.fne.isSuccess() && (a2 = a(md5, Aw)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                Aw.setMd5(audioInfoData.getVoiceId());
                this.fne.b(Aw);
            } else {
                this.fne.setErrorCode(audioInfoData.getErrorCode());
                this.fne.setErrorString(audioInfoData.getErrorUserMsg());
                this.fne.setIsSuccess(false);
            }
        }
        return this.fne;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new z(TbConfig.SERVER_ADDRESS + this.fng);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (x.getCount(this.fnh) != 0) {
            for (C0569b c0569b : this.fnh) {
                if (c0569b != null) {
                    this.mNetwork.addPostData(c0569b.getKey(), c0569b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.brX().bsH().isRequestSuccess()) {
            pVar.setChunkNo((int) ec(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.fne.setErrorCode(this.mNetwork.getServerErrorCode());
            this.fne.setErrorString(this.mNetwork.getErrorString());
            this.fne.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.Av(str);
        return postNetData;
    }

    private long ec(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private z chV;
        private p fni;
        private boolean fnj = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.fni = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.fni = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q bvq() throws IOException {
            q qVar = new q();
            long totalLength = this.fni.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.fni.getChunkNo();
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
                                this.chV = new z(this.mUrl);
                                this.chV.addPostData("voice_chunk", bArr);
                                this.chV.addPostData("chunk_md5", this.fni.getMd5());
                                this.chV.addPostData("length", String.valueOf(read));
                                this.chV.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.chV.addPostData("total_length", String.valueOf(totalLength));
                                this.chV.addPostData("chunk_no", String.valueOf(i + 1));
                                this.chV.addPostData("total_num", String.valueOf(j));
                                this.chV.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.fnj) {
                                    z = true;
                                } else if (this.chV.postMultiNetData() == null || !this.chV.brX().bsH().isRequestSuccess()) {
                                    this.fni.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.fni);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.chV.getServerErrorCode());
                                    qVar.setErrorString(this.chV.getErrorString());
                                    qVar.b(this.fni);
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
    public class C0569b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0569b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.fnh.add(new C0569b(str, String.valueOf(i)));
    }
}
