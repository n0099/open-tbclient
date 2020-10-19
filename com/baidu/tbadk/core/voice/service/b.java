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
    private a eNm;
    private q eNn;
    private String eNo;
    private String eNp;
    private List<C0557b> eNq = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.eNo = str;
        this.eNp = str2;
    }

    public q BY(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eNo);
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
        p AW = com.baidu.tbadk.core.util.c.AW(md5);
        if (AW == null) {
            AW = new p();
            AW.setMd5(md5);
            AW.setChunkNo(0);
            AW.setTotalLength(file.length());
        }
        this.eNm = new a(str, AW, TbConfig.SERVER_ADDRESS + this.eNo, md5);
        this.eNn = this.eNm.bpH();
        if (this.eNn.isSuccess() && (a2 = a(md5, AW)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                AW.setMd5(audioInfoData.getVoiceId());
                this.eNn.b(AW);
            } else {
                this.eNn.setErrorCode(audioInfoData.getErrorCode());
                this.eNn.setErrorString(audioInfoData.getErrorUserMsg());
                this.eNn.setIsSuccess(false);
            }
        }
        return this.eNn;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eNp);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (y.getCount(this.eNq) != 0) {
            for (C0557b c0557b : this.eNq) {
                if (c0557b != null) {
                    this.mNetwork.addPostData(c0557b.getKey(), c0557b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bmu().bnb().isRequestSuccess()) {
            pVar.setChunkNo((int) df(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.eNn.setErrorCode(this.mNetwork.getServerErrorCode());
            this.eNn.setErrorString(this.mNetwork.getErrorString());
            this.eNn.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.AV(str);
        return postNetData;
    }

    private long df(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa bML;
        private p eNr;
        private boolean eNs = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.eNr = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.eNr = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q bpH() throws IOException {
            q qVar = new q();
            long totalLength = this.eNr.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.eNr.getChunkNo();
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
                                this.bML = new aa(this.mUrl);
                                this.bML.addPostData("voice_chunk", bArr);
                                this.bML.addPostData("chunk_md5", this.eNr.getMd5());
                                this.bML.addPostData("length", String.valueOf(read));
                                this.bML.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bML.addPostData("total_length", String.valueOf(totalLength));
                                this.bML.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bML.addPostData("total_num", String.valueOf(j));
                                this.bML.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.eNs) {
                                    z = true;
                                } else if (this.bML.postMultiNetData() == null || !this.bML.bmu().bnb().isRequestSuccess()) {
                                    this.eNr.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.eNr);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.bML.getServerErrorCode());
                                    qVar.setErrorString(this.bML.getErrorString());
                                    qVar.b(this.eNr);
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
    public class C0557b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0557b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.eNq.add(new C0557b(str, String.valueOf(i)));
    }
}
