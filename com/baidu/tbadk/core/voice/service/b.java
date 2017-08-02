package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a apq;
    private h apr;
    private String aps;
    private String apt;
    private List<C0045b> apu = new ArrayList();
    private w mNetwork;

    public b(String str, String str2) {
        this.aps = str;
        this.apt = str2;
    }

    public h ev(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new w(TbConfig.SERVER_ADDRESS + this.aps);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private h b(String str, File file) throws IOException {
        String a2;
        String k = r.k(k.q(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        g dk = com.baidu.tbadk.core.util.c.dk(k);
        if (dk == null) {
            dk = new g();
            dk.setMd5(k);
            dk.dF(0);
            dk.O(file.length());
        }
        this.apq = new a(str, dk, TbConfig.SERVER_ADDRESS + this.aps, k);
        this.apr = this.apq.xx();
        if (this.apr.isSuccess() && (a2 = a(k, dk)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dk.setMd5(audioInfoData.getVoiceId());
                this.apr.b(dk);
            } else {
                this.apr.setErrorCode(audioInfoData.getErrorCode());
                this.apr.setErrorString(audioInfoData.getErrorUserMsg());
                this.apr.ay(false);
            }
        }
        return this.apr;
    }

    private String a(String str, g gVar) {
        this.mNetwork = new w(TbConfig.SERVER_ADDRESS + this.apt);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (u.u(this.apu) != 0) {
            for (C0045b c0045b : this.apu) {
                if (c0045b != null) {
                    this.mNetwork.n(c0045b.getKey(), c0045b.getValue());
                }
            }
        }
        String uE = this.mNetwork.uE();
        if (uE == null || !this.mNetwork.vb().vY().isRequestSuccess()) {
            gVar.dF((int) N(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.apr.setErrorCode(this.mNetwork.vf());
            this.apr.setErrorString(this.mNetwork.getErrorString());
            this.apr.ay(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dj(str);
        return uE;
    }

    private long N(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private g apv;
        private boolean apw = false;
        private String mFileName;
        private w mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.apv = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.apv = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public h xx() throws IOException {
            h hVar = new h();
            long totalLength = this.apv.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int yc = this.apv.yc();
            if (yc < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(yc * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= yc * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = yc;
                        if (i < j) {
                            int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            if (i == j - 1) {
                                i2 = (int) (totalLength - (30720 * (j - 1)));
                            }
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile.read(bArr, 0, i2);
                            if (read != -1) {
                                this.mNetWork = new w(this.mUrl);
                                this.mNetWork.d("voice_chunk", bArr);
                                this.mNetWork.n("chunk_md5", this.apv.getMd5());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.apw) {
                                    z = true;
                                } else if (this.mNetWork.uG() == null || !this.mNetWork.vb().vY().isRequestSuccess()) {
                                    this.apv.dF(i);
                                    com.baidu.tbadk.core.util.c.a(this.apv);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    hVar.setErrorCode(this.mNetWork.vf());
                                    hVar.setErrorString(this.mNetWork.getErrorString());
                                    hVar.b(this.apv);
                                    hVar.ay(false);
                                    return hVar;
                                }
                            }
                            yc = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    hVar.ay(false);
                    randomAccessFile.close();
                    return hVar;
                }
            }
            hVar.ay(true);
            return hVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0045b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void v(String str, int i) {
        this.apu.add(new C0045b(str, String.valueOf(i)));
    }
}
