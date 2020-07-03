package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
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
    private m eiA;
    private String eiB;
    private String eiC;
    private List<C0486b> eiD = new ArrayList();
    private a eiz;
    private y mNetwork;

    public b(String str, String str2) {
        this.eiB = str;
        this.eiC = str2;
    }

    public m xv(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.eiB);
            return l(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private m l(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        l ws = com.baidu.tbadk.core.util.c.ws(md5);
        if (ws == null) {
            ws = new l();
            ws.setMd5(md5);
            ws.setChunkNo(0);
            ws.setTotalLength(file.length());
        }
        this.eiz = new a(str, ws, TbConfig.SERVER_ADDRESS + this.eiB, md5);
        this.eiA = this.eiz.aZA();
        if (this.eiA.isSuccess() && (a2 = a(md5, ws)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                ws.setMd5(audioInfoData.getVoiceId());
                this.eiA.b(ws);
            } else {
                this.eiA.setErrorCode(audioInfoData.getErrorCode());
                this.eiA.setErrorString(audioInfoData.getErrorUserMsg());
                this.eiA.setIsSuccess(false);
            }
        }
        return this.eiA;
    }

    private String a(String str, l lVar) {
        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.eiC);
        this.mNetwork.addPostData("voice_md5", lVar.getMd5());
        if (w.getCount(this.eiD) != 0) {
            for (C0486b c0486b : this.eiD) {
                if (c0486b != null) {
                    this.mNetwork.addPostData(c0486b.getKey(), c0486b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.aWu().aWW().isRequestSuccess()) {
            lVar.setChunkNo((int) cr(lVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(lVar);
            this.eiA.setErrorCode(this.mNetwork.getServerErrorCode());
            this.eiA.setErrorString(this.mNetwork.getErrorString());
            this.eiA.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.wr(str);
        return postNetData;
    }

    private long cr(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private y byb;
        private l eiE;
        private boolean eiF = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, l lVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.eiE = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.eiE = lVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public m aZA() throws IOException {
            m mVar = new m();
            long totalLength = this.eiE.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.eiE.getChunkNo();
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
                                this.byb = new y(this.mUrl);
                                this.byb.addPostData("voice_chunk", bArr);
                                this.byb.addPostData("chunk_md5", this.eiE.getMd5());
                                this.byb.addPostData("length", String.valueOf(read));
                                this.byb.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.byb.addPostData("total_length", String.valueOf(totalLength));
                                this.byb.addPostData("chunk_no", String.valueOf(i + 1));
                                this.byb.addPostData("total_num", String.valueOf(j));
                                this.byb.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.eiF) {
                                    z = true;
                                } else if (this.byb.postMultiNetData() == null || !this.byb.aWu().aWW().isRequestSuccess()) {
                                    this.eiE.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.eiE);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    mVar.setErrorCode(this.byb.getServerErrorCode());
                                    mVar.setErrorString(this.byb.getErrorString());
                                    mVar.b(this.eiE);
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
    public class C0486b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0486b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.eiD.add(new C0486b(str, String.valueOf(i)));
    }
}
