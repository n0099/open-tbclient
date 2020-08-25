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
/* loaded from: classes2.dex */
public class b {
    private a eyX;
    private p eyY;
    private String eyZ;
    private String eza;
    private List<C0545b> ezb = new ArrayList();
    private aa mNetwork;

    public b(String str, String str2) {
        this.eyZ = str;
        this.eza = str2;
    }

    public p AP(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eyZ);
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
        o zN = com.baidu.tbadk.core.util.c.zN(md5);
        if (zN == null) {
            zN = new o();
            zN.setMd5(md5);
            zN.setChunkNo(0);
            zN.setTotalLength(file.length());
        }
        this.eyX = new a(str, zN, TbConfig.SERVER_ADDRESS + this.eyZ, md5);
        this.eyY = this.eyX.bmd();
        if (this.eyY.isSuccess() && (a2 = a(md5, zN)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                zN.setMd5(audioInfoData.getVoiceId());
                this.eyY.b(zN);
            } else {
                this.eyY.setErrorCode(audioInfoData.getErrorCode());
                this.eyY.setErrorString(audioInfoData.getErrorUserMsg());
                this.eyY.setIsSuccess(false);
            }
        }
        return this.eyY;
    }

    private String a(String str, o oVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.eza);
        this.mNetwork.addPostData("voice_md5", oVar.getMd5());
        if (y.getCount(this.ezb) != 0) {
            for (C0545b c0545b : this.ezb) {
                if (c0545b != null) {
                    this.mNetwork.addPostData(c0545b.getKey(), c0545b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.biQ().bjw().isRequestSuccess()) {
            oVar.setChunkNo((int) cW(oVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(oVar);
            this.eyY.setErrorCode(this.mNetwork.getServerErrorCode());
            this.eyY.setErrorString(this.mNetwork.getErrorString());
            this.eyY.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.zM(str);
        return postNetData;
    }

    private long cW(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        private aa bDY;
        private o ezc;
        private boolean ezd = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, o oVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.ezc = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.ezc = oVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public p bmd() throws IOException {
            p pVar = new p();
            long totalLength = this.ezc.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.ezc.getChunkNo();
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
                                this.bDY = new aa(this.mUrl);
                                this.bDY.addPostData("voice_chunk", bArr);
                                this.bDY.addPostData("chunk_md5", this.ezc.getMd5());
                                this.bDY.addPostData("length", String.valueOf(read));
                                this.bDY.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.bDY.addPostData("total_length", String.valueOf(totalLength));
                                this.bDY.addPostData("chunk_no", String.valueOf(i + 1));
                                this.bDY.addPostData("total_num", String.valueOf(j));
                                this.bDY.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.ezd) {
                                    z = true;
                                } else if (this.bDY.postMultiNetData() == null || !this.bDY.biQ().bjw().isRequestSuccess()) {
                                    this.ezc.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.ezc);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    pVar.setErrorCode(this.bDY.getServerErrorCode());
                                    pVar.setErrorString(this.bDY.getErrorString());
                                    pVar.b(this.ezc);
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
    /* loaded from: classes2.dex */
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
        this.ezb.add(new C0545b(str, String.valueOf(i)));
    }
}
