package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
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
    private String dLA;
    private String dLB;
    private List<C0433b> dLC = new ArrayList();
    private a dLy;
    private m dLz;
    private x mNetwork;

    public b(String str, String str2) {
        this.dLA = str;
        this.dLB = str2;
    }

    public m vw(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dLA);
            return l(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private m l(String str, File file) throws IOException {
        String a2;
        String md5 = s.toMd5(com.baidu.tbadk.core.util.m.GetStreamFromFile(file));
        if (md5 != null && md5.length() > 0) {
            md5 = md5.toLowerCase();
        }
        l uw = com.baidu.tbadk.core.util.c.uw(md5);
        if (uw == null) {
            uw = new l();
            uw.setMd5(md5);
            uw.setChunkNo(0);
            uw.setTotalLength(file.length());
        }
        this.dLy = new a(str, uw, TbConfig.SERVER_ADDRESS + this.dLA, md5);
        this.dLz = this.dLy.aRm();
        if (this.dLz.isSuccess() && (a2 = a(md5, uw)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                uw.setMd5(audioInfoData.getVoiceId());
                this.dLz.b(uw);
            } else {
                this.dLz.setErrorCode(audioInfoData.getErrorCode());
                this.dLz.setErrorString(audioInfoData.getErrorUserMsg());
                this.dLz.setIsSuccess(false);
            }
        }
        return this.dLz;
    }

    private String a(String str, l lVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.dLB);
        this.mNetwork.addPostData("voice_md5", lVar.getMd5());
        if (v.getCount(this.dLC) != 0) {
            for (C0433b c0433b : this.dLC) {
                if (c0433b != null) {
                    this.mNetwork.addPostData(c0433b.getKey(), c0433b.getValue());
                }
            }
        }
        String postNetData = this.mNetwork.postNetData();
        if (postNetData == null || !this.mNetwork.aOw().aOX().isRequestSuccess()) {
            lVar.setChunkNo((int) cn(lVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(lVar);
            this.dLz.setErrorCode(this.mNetwork.getServerErrorCode());
            this.dLz.setErrorString(this.mNetwork.getErrorString());
            this.dLz.setIsSuccess(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.uv(str);
        return postNetData;
    }

    private long cn(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private x blK;
        private l dLD;
        private boolean dLE = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, l lVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.dLD = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.dLD = lVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public m aRm() throws IOException {
            m mVar = new m();
            long totalLength = this.dLD.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int chunkNo = this.dLD.getChunkNo();
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
                                this.blK = new x(this.mUrl);
                                this.blK.addPostData("voice_chunk", bArr);
                                this.blK.addPostData("chunk_md5", this.dLD.getMd5());
                                this.blK.addPostData("length", String.valueOf(read));
                                this.blK.addPostData("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.blK.addPostData("total_length", String.valueOf(totalLength));
                                this.blK.addPostData("chunk_no", String.valueOf(i + 1));
                                this.blK.addPostData("total_num", String.valueOf(j));
                                this.blK.addPostData("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.dLE) {
                                    z = true;
                                } else if (this.blK.postMultiNetData() == null || !this.blK.aOw().aOX().isRequestSuccess()) {
                                    this.dLD.setChunkNo(i);
                                    com.baidu.tbadk.core.util.c.a(this.dLD);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    mVar.setErrorCode(this.blK.getServerErrorCode());
                                    mVar.setErrorString(this.blK.getErrorString());
                                    mVar.b(this.dLD);
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
    public class C0433b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0433b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.dLC.add(new C0433b(str, String.valueOf(i)));
    }
}
