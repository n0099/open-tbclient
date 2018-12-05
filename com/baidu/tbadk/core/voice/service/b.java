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
    private a aMs;
    private l aMt;
    private String aMu;
    private String aMv;
    private List<C0161b> aMw = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.aMu = str;
        this.aMv = str2;
    }

    public l gy(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aMu);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l b(String str, File file) throws IOException {
        String a2;
        String i = s.i(com.baidu.tbadk.core.util.l.x(file));
        if (i != null && i.length() > 0) {
            i = i.toLowerCase();
        }
        k eP = com.baidu.tbadk.core.util.c.eP(i);
        if (eP == null) {
            eP = new k();
            eP.gC(i);
            eP.eQ(0);
            eP.al(file.length());
        }
        this.aMs = new a(str, eP, TbConfig.SERVER_ADDRESS + this.aMu, i);
        this.aMt = this.aMs.FS();
        if (this.aMt.isSuccess() && (a2 = a(i, eP)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                eP.gC(audioInfoData.getVoiceId());
                this.aMt.b(eP);
            } else {
                this.aMt.setErrorCode(audioInfoData.getErrorCode());
                this.aMt.setErrorString(audioInfoData.getErrorUserMsg());
                this.aMt.bo(false);
            }
        }
        return this.aMt;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aMv);
        this.mNetwork.x("voice_md5", kVar.GG());
        if (v.H(this.aMw) != 0) {
            for (C0161b c0161b : this.aMw) {
                if (c0161b != null) {
                    this.mNetwork.x(c0161b.getKey(), c0161b.getValue());
                }
            }
        }
        String CL = this.mNetwork.CL();
        if (CL == null || !this.mNetwork.Dj().Ei().isRequestSuccess()) {
            kVar.eQ((int) ak(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.aMt.setErrorCode(this.mNetwork.Dn());
            this.aMt.setErrorString(this.mNetwork.getErrorString());
            this.aMt.bo(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.eO(str);
        return CL;
    }

    private long ak(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k aMx;
        private boolean aMy = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aMx = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aMx = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l FS() throws IOException {
            l lVar = new l();
            long totalLength = this.aMx.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int GH = this.aMx.GH();
            if (GH < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(GH * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= GH * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = GH;
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
                                this.mNetWork.x("chunk_md5", this.aMx.GG());
                                this.mNetWork.x("length", String.valueOf(read));
                                this.mNetWork.x("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.x("total_length", String.valueOf(totalLength));
                                this.mNetWork.x("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.x("total_num", String.valueOf(j));
                                this.mNetWork.x("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aMy) {
                                    z = true;
                                } else if (this.mNetWork.CO() == null || !this.mNetWork.Dj().Ei().isRequestSuccess()) {
                                    this.aMx.eQ(i);
                                    com.baidu.tbadk.core.util.c.a(this.aMx);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.Dn());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.aMx);
                                    lVar.bo(false);
                                    return lVar;
                                }
                            }
                            GH = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.bo(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.bo(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0161b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0161b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void D(String str, int i) {
        this.aMw.add(new C0161b(str, String.valueOf(i)));
    }
}
