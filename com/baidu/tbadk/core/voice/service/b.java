package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.p;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a ezb;
    private p ezc;
    private String ezd;
    private String eze;
    private List<C0545b> ezf = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.ezd = str;
        this.eze = str2;
    }

    public p AQ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.ezd);
            return n(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private p n(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(n.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        o zO = com.baidu.tbadk.core.util.c.zO(md5);
        if (zO == null) {
            zO = new o();
            zO.setMd5(md5);
            zO.setChunkNo(0);
            zO.setTotalLength(file.length());
        }
        this.ezb = new a(str, zO, TbConfig.SERVER_ADDRESS + this.ezd, md5);
        this.ezc = this.ezb.bmd();
        if (this.ezc.isSuccess() && (a2 = a(md5, zO)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                zO.setMd5(audioInfoData.getVoiceId());
                this.ezc.b(zO);
            } else {
                this.ezc.setErrorCode(audioInfoData.getErrorCode());
                this.ezc.setErrorString(audioInfoData.getErrorUserMsg());
                this.ezc.setIsSuccess(false);
            }
        }
        return this.ezc;
    }

    private String a(String str, o oVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eze);
        this.mNetwork.addPostData("voice_md5", oVar.getMd5());
        if (y.getCount(this.ezf) != 0) {
            for (C0545b c0545b : this.ezf) {
                if (c0545b != null) {
                    this.mNetwork.addPostData(c0545b.getKey(), c0545b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.biQ().bjw().isRequestSuccess()) {
            oVar.setChunkNo((int) cW(oVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(oVar);
            this.ezc.setErrorCode(this.mNetwork.getServerErrorCode());
            this.ezc.setErrorString(this.mNetwork.getErrorString());
            this.ezc.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.zN(str);
        return postNetData;
    }

    private long cW(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa bEb;
        private o ezg;
        private boolean ezh = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, o oVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.ezg = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.ezg = oVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public p bmd() throws IOException {
            p pVar = new p();
            long totalLength = this.ezg.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.ezg.getChunkNo();
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
                                this.bEb = new aa(this.mUrl);
                                this.bEb.addPostData("voice_chunk", bArr);
                                this.bEb.addPostData("chunk_md5", this.ezg.getMd5());
                                this.bEb.addPostData("length", String.valueOf(read));
                                this.bEb.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bEb.addPostData("total_length", String.valueOf(totalLength));
                                this.bEb.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bEb.addPostData("total_num", String.valueOf(j));
                                this.bEb.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.ezh) {
                                    z = true;
                                } else if (this.bEb.postMultiNetData() == null || !this.bEb.biQ().bjw().isRequestSuccess()) {
                                    this.ezg.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.ezg);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    pVar.setErrorCode(this.bEb.getServerErrorCode());
                                    pVar.setErrorString(this.bEb.getErrorString());
                                    pVar.b(this.ezg);
                                    pVar.setIsSuccess(false);
                                    return pVar;
                                }
                            }
                            chunkNo = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    pVar.setIsSuccess(false);
                    randomAccessFile.close();
                    return pVar;
                }
            }
            pVar.setIsSuccess(true);
            return pVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0545b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0545b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.ezf.add(new C0545b(str, String.valueOf(i)));
    }
}
