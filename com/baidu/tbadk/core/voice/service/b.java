package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a aIS;
    private l aIT;
    private String aIU;
    private String aIV;
    private List<C0151b> aIW = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.aIU = str;
        this.aIV = str2;
    }

    public l gf(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aIU);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l b(String str, File file) throws IOException {
        String a2;
        String i = s.i(com.baidu.tbadk.core.util.l.w(file));
        if (i != null && i.length() > 0) {
            i = i.toLowerCase();
        }
        k ex = com.baidu.tbadk.core.util.c.ex(i);
        if (ex == null) {
            ex = new k();
            ex.gj(i);
            ex.eC(0);
            ex.ae(file.length());
        }
        this.aIS = new a(str, ex, TbConfig.SERVER_ADDRESS + this.aIU, i);
        this.aIT = this.aIS.EO();
        if (this.aIT.isSuccess() && (a2 = a(i, ex)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                ex.gj(audioInfoData.getVoiceId());
                this.aIT.b(ex);
            } else {
                this.aIT.setErrorCode(audioInfoData.getErrorCode());
                this.aIT.setErrorString(audioInfoData.getErrorUserMsg());
                this.aIT.bn(false);
            }
        }
        return this.aIT;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aIV);
        this.mNetwork.x("voice_md5", kVar.FC());
        if (v.H(this.aIW) != 0) {
            for (C0151b c0151b : this.aIW) {
                if (c0151b != null) {
                    this.mNetwork.x(c0151b.getKey(), c0151b.getValue());
                }
            }
        }
        String BH = this.mNetwork.BH();
        if (BH == null || !this.mNetwork.Cf().De().isRequestSuccess()) {
            kVar.eC((int) ad(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.aIT.setErrorCode(this.mNetwork.Cj());
            this.aIT.setErrorString(this.mNetwork.getErrorString());
            this.aIT.bn(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.ew(str);
        return BH;
    }

    private long ad(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k aIX;
        private boolean aIY = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aIX = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aIX = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l EO() throws IOException {
            l lVar = new l();
            long totalLength = this.aIX.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int FD = this.aIX.FD();
            if (FD < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(FD * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= FD * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = FD;
                        if (i < j) {
                            int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            if (i == j - 1) {
                                i2 = (int) (totalLength - (30720 * (j - 1)));
                            }
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile.read(bArr, 0, i2);
                            if (read != -1) {
                                this.mNetWork = new x(this.mUrl);
                                this.mNetWork.d("voice_chunk", bArr);
                                this.mNetWork.x("chunk_md5", this.aIX.FC());
                                this.mNetWork.x("length", String.valueOf(read));
                                this.mNetWork.x("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.x("total_length", String.valueOf(totalLength));
                                this.mNetWork.x("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.x("total_num", String.valueOf(j));
                                this.mNetWork.x("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aIY) {
                                    z = true;
                                } else if (this.mNetWork.BK() == null || !this.mNetWork.Cf().De().isRequestSuccess()) {
                                    this.aIX.eC(i);
                                    com.baidu.tbadk.core.util.c.a(this.aIX);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.Cj());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.aIX);
                                    lVar.bn(false);
                                    return lVar;
                                }
                            }
                            FD = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.bn(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.bn(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0151b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0151b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void D(String str, int i) {
        this.aIW.add(new C0151b(str, String.valueOf(i)));
    }
}
