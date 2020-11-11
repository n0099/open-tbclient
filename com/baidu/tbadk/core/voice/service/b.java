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
    private String fbA;
    private List<C0583b> fbB = new ArrayList();
    private a fbx;
    private q fby;
    private String fbz;
    private aa mNetwork;

    public b(String str, String str2) {
        this.fbz = str;
        this.fbA = str2;
    }

    public q CF(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.fbz);
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
        p BD = com.baidu.tbadk.core.util.c.BD(md5);
        if (BD == null) {
            BD = new p();
            BD.setMd5(md5);
            BD.setChunkNo(0);
            BD.setTotalLength(file.length());
        }
        this.fbx = new a(str, BD, TbConfig.SERVER_ADDRESS + this.fbz, md5);
        this.fby = this.fbx.bua();
        if (this.fby.isSuccess() && (a2 = a(md5, BD)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                BD.setMd5(audioInfoData.getVoiceId());
                this.fby.b(BD);
            } else {
                this.fby.setErrorCode(audioInfoData.getErrorCode());
                this.fby.setErrorString(audioInfoData.getErrorUserMsg());
                this.fby.setIsSuccess(false);
            }
        }
        return this.fby;
    }

    private String a(String str, p pVar) {
        this.mNetwork = new aa(TbConfig.SERVER_ADDRESS + this.fbA);
        this.mNetwork.addPostData("voice_md5", pVar.getMd5());
        if (y.getCount(this.fbB) != 0) {
            for (C0583b c0583b : this.fbB) {
                if (c0583b != null) {
                    this.mNetwork.addPostData(c0583b.getKey(), c0583b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.bqN().bru().isRequestSuccess()) {
            pVar.setChunkNo((int) dD(pVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(pVar);
            this.fby.setErrorCode(this.mNetwork.getServerErrorCode());
            this.fby.setErrorString(this.mNetwork.getErrorString());
            this.fby.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.BC(str);
        return postNetData;
    }

    private long dD(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa caS;
        private p fbC;
        private boolean fbD = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, p pVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.fbC = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.fbC = pVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public q bua() throws IOException {
            q qVar = new q();
            long totalLength = this.fbC.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.fbC.getChunkNo();
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
                                this.caS = new aa(this.mUrl);
                                this.caS.addPostData("voice_chunk", bArr);
                                this.caS.addPostData("chunk_md5", this.fbC.getMd5());
                                this.caS.addPostData("length", String.valueOf(read));
                                this.caS.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.caS.addPostData("total_length", String.valueOf(totalLength));
                                this.caS.addPostData("chunk_no", String.valueOf(i + 1));
                                this.caS.addPostData("total_num", String.valueOf(j));
                                this.caS.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.fbD) {
                                    z = true;
                                } else if (this.caS.postMultiNetData() == null || !this.caS.bqN().bru().isRequestSuccess()) {
                                    this.fbC.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.fbC);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    qVar.setErrorCode(this.caS.getServerErrorCode());
                                    qVar.setErrorString(this.caS.getErrorString());
                                    qVar.b(this.fbC);
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
    public class C0583b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0583b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.fbB.add(new C0583b(str, String.valueOf(i)));
    }
}
