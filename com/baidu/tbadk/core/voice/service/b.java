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
    private a cdv;
    private l cdw;
    private String cdx;
    private String cdy;
    private List<C0243b> cdz = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.cdx = str;
        this.cdy = str2;
    }

    public l oJ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.cdx);
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
        k mU = com.baidu.tbadk.core.util.c.mU(h);
        if (mU == null) {
            mU = new k();
            mU.oN(h);
            mU.jk(0);
            mU.bd(file.length());
        }
        this.cdv = new a(str, mU, TbConfig.SERVER_ADDRESS + this.cdx, h);
        this.cdw = this.cdv.akw();
        if (this.cdw.isSuccess() && (a2 = a(h, mU)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                mU.oN(audioInfoData.getVoiceId());
                this.cdw.b(mU);
            } else {
                this.cdw.setErrorCode(audioInfoData.getErrorCode());
                this.cdw.setErrorString(audioInfoData.getErrorUserMsg());
                this.cdw.dU(false);
            }
        }
        return this.cdw;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.cdy);
        this.mNetwork.o("voice_md5", kVar.alj());
        if (v.Z(this.cdz) != 0) {
            for (C0243b c0243b : this.cdz) {
                if (c0243b != null) {
                    this.mNetwork.o(c0243b.getKey(), c0243b.getValue());
                }
            }
        }
        String ahe = this.mNetwork.ahe();
        if (ahe == null || !this.mNetwork.ahC().aiC().isRequestSuccess()) {
            kVar.jk((int) bc(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.cdw.setErrorCode(this.mNetwork.ahG());
            this.cdw.setErrorString(this.mNetwork.getErrorString());
            this.cdw.dU(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.mT(str);
        return ahe;
    }

    private long bc(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k cdA;
        private boolean cdB = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.cdA = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.cdA = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l akw() throws IOException {
            l lVar = new l();
            long totalLength = this.cdA.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int alk = this.cdA.alk();
            if (alk < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(alk * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= alk * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = alk;
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
                                this.mNetWork.o("chunk_md5", this.cdA.alj());
                                this.mNetWork.o("length", String.valueOf(read));
                                this.mNetWork.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.o("total_length", String.valueOf(totalLength));
                                this.mNetWork.o("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.o("total_num", String.valueOf(j));
                                this.mNetWork.o("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.cdB) {
                                    z = true;
                                } else if (this.mNetWork.ahh() == null || !this.mNetWork.ahC().aiC().isRequestSuccess()) {
                                    this.cdA.jk(i);
                                    com.baidu.tbadk.core.util.c.a(this.cdA);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.ahG());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.cdA);
                                    lVar.dU(false);
                                    return lVar;
                                }
                            }
                            alk = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.dU(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.dU(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0243b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0243b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.cdz.add(new C0243b(str, String.valueOf(i)));
    }
}
