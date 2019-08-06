package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
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
    private a ceG;
    private l ceH;
    private String ceI;
    private String ceJ;
    private List<C0245b> ceK = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.ceI = str;
        this.ceJ = str2;
    }

    public l oZ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.ceI);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l c(String str, File file) throws IOException {
        String a2;
        String h = s.h(m.z(file));
        if (h != null && h.length() > 0) {
            h = h.toLowerCase();
        }
        k nf = com.baidu.tbadk.core.util.c.nf(h);
        if (nf == null) {
            nf = new k();
            nf.pd(h);
            nf.jr(0);
            nf.be(file.length());
        }
        this.ceG = new a(str, nf, TbConfig.SERVER_ADDRESS + this.ceI, h);
        this.ceH = this.ceG.alD();
        if (this.ceH.isSuccess() && (a2 = a(h, nf)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                nf.pd(audioInfoData.getVoiceId());
                this.ceH.b(nf);
            } else {
                this.ceH.setErrorCode(audioInfoData.getErrorCode());
                this.ceH.setErrorString(audioInfoData.getErrorUserMsg());
                this.ceH.dY(false);
            }
        }
        return this.ceH;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.ceJ);
        this.mNetwork.o("voice_md5", kVar.amq());
        if (v.Z(this.ceK) != 0) {
            for (C0245b c0245b : this.ceK) {
                if (c0245b != null) {
                    this.mNetwork.o(c0245b.getKey(), c0245b.getValue());
                }
            }
        }
        String aii = this.mNetwork.aii();
        if (aii == null || !this.mNetwork.aiG().ajH().isRequestSuccess()) {
            kVar.jr((int) bd(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.ceH.setErrorCode(this.mNetwork.aiK());
            this.ceH.setErrorString(this.mNetwork.getErrorString());
            this.ceH.dY(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.ne(str);
        return aii;
    }

    private long bd(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k ceL;
        private boolean ceM = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.ceL = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.ceL = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l alD() throws IOException {
            l lVar = new l();
            long totalLength = this.ceL.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int amr = this.ceL.amr();
            if (amr < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(amr * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= amr * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = amr;
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
                                this.mNetWork.o("chunk_md5", this.ceL.amq());
                                this.mNetWork.o("length", String.valueOf(read));
                                this.mNetWork.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.o("total_length", String.valueOf(totalLength));
                                this.mNetWork.o("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.o("total_num", String.valueOf(j));
                                this.mNetWork.o("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.ceM) {
                                    z = true;
                                } else if (this.mNetWork.ail() == null || !this.mNetWork.aiG().ajH().isRequestSuccess()) {
                                    this.ceL.jr(i);
                                    com.baidu.tbadk.core.util.c.a(this.ceL);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.aiK());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.ceL);
                                    lVar.dY(false);
                                    return lVar;
                                }
                            }
                            amr = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.dY(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.dY(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0245b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0245b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.ceK.add(new C0245b(str, String.valueOf(i)));
    }
}
