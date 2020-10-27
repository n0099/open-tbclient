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
    private a eVI;
    private q eVJ;
    private String eVK;
    private String eVL;
    private List<C0571b> eVM = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.eVK = str;
        this.eVL = str2;
    }

    public q Cr(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eVK);
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
        p Bp = com.baidu.tbadk.core.util.c.Bp(md5);
        if (Bp == null) {
            Bp = new p();
            Bp.setMd5(md5);
            Bp.setChunkNo(0);
            Bp.setTotalLength(file.length());
        }
        this.eVI = new a(str, Bp, TbConfig.SERVER_ADDRESS + this.eVK, md5);
        this.eVJ = this.eVI.brA();
        if (this.eVJ.isSuccess() && (a2 = a(md5, Bp)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                Bp.setMd5(audioInfoData.getVoiceId());
                this.eVJ.b(Bp);
            } else {
                this.eVJ.setErrorCode(audioInfoData.getErrorCode());
                this.eVJ.setErrorString(audioInfoData.getErrorUserMsg());
                this.eVJ.setIsSuccess(false);
            }
        }
        return this.eVJ;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eVL);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (y.getCount(this.eVM) != 0) {
            for (C0571b c0571b : this.eVM) {
                if (c0571b != null) {
                    this.mNetwork.addPostData(c0571b.getKey(), c0571b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bon().boU().isRequestSuccess()) {
            pVar.setChunkNo((int) dh(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.eVJ.setErrorCode(this.mNetwork.getServerErrorCode());
            this.eVJ.setErrorString(this.mNetwork.getErrorString());
            this.eVJ.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.Bo(str);
        return postNetData;
    }

    private long dh(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa bVi;
        private p eVN;
        private boolean eVO = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.eVN = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.eVN = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q brA() throws IOException {
            q qVar = new q();
            long totalLength = this.eVN.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.eVN.getChunkNo();
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
                                this.bVi = new aa(this.mUrl);
                                this.bVi.addPostData("voice_chunk", bArr);
                                this.bVi.addPostData("chunk_md5", this.eVN.getMd5());
                                this.bVi.addPostData("length", String.valueOf(read));
                                this.bVi.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bVi.addPostData("total_length", String.valueOf(totalLength));
                                this.bVi.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bVi.addPostData("total_num", String.valueOf(j));
                                this.bVi.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.eVO) {
                                    z = true;
                                } else if (this.bVi.postMultiNetData() == null || !this.bVi.bon().boU().isRequestSuccess()) {
                                    this.eVN.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.eVN);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.bVi.getServerErrorCode());
                                    qVar.setErrorString(this.bVi.getErrorString());
                                    qVar.b(this.eVN);
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
    public class C0571b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0571b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.eVM.add(new C0571b(str, String.valueOf(i)));
    }
}
