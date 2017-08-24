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
    private a aqK;
    private h aqL;
    private String aqM;
    private String aqN;
    private List<C0045b> aqO = new ArrayList();
    private w mNetwork;

    public b(String str, String str2) {
        this.aqM = str;
        this.aqN = str2;
    }

    public h eF(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new w(TbConfig.SERVER_ADDRESS + this.aqM);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private h b(String str, File file) throws IOException {
        String a2;
        String q = r.q(k.q(file));
        if (q != null && q.length() > 0) {
            q = q.toLowerCase();
        }
        g dt = com.baidu.tbadk.core.util.c.dt(q);
        if (dt == null) {
            dt = new g();
            dt.setMd5(q);
            dt.dH(0);
            dt.O(file.length());
        }
        this.aqK = new a(str, dt, TbConfig.SERVER_ADDRESS + this.aqM, q);
        this.aqL = this.aqK.xF();
        if (this.aqL.isSuccess() && (a2 = a(q, dt)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dt.setMd5(audioInfoData.getVoiceId());
                this.aqL.b(dt);
            } else {
                this.aqL.setErrorCode(audioInfoData.getErrorCode());
                this.aqL.setErrorString(audioInfoData.getErrorUserMsg());
                this.aqL.ay(false);
            }
        }
        return this.aqL;
    }

    private String a(String str, g gVar) {
        this.mNetwork = new w(TbConfig.SERVER_ADDRESS + this.aqN);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (u.u(this.aqO) != 0) {
            for (C0045b c0045b : this.aqO) {
                if (c0045b != null) {
                    this.mNetwork.n(c0045b.getKey(), c0045b.getValue());
                }
            }
        }
        String uP = this.mNetwork.uP();
        if (uP == null || !this.mNetwork.vm().wj().isRequestSuccess()) {
            gVar.dH((int) N(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.aqL.setErrorCode(this.mNetwork.vq());
            this.aqL.setErrorString(this.mNetwork.getErrorString());
            this.aqL.ay(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.ds(str);
        return uP;
    }

    private long N(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private g aqP;
        private boolean aqQ = false;
        private String mFileName;
        private w mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aqP = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aqP = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public h xF() throws IOException {
            h hVar = new h();
            long totalLength = this.aqP.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int yk = this.aqP.yk();
            if (yk < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(yk * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= yk * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = yk;
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
                                this.mNetWork.n("chunk_md5", this.aqP.getMd5());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aqQ) {
                                    z = true;
                                } else if (this.mNetWork.uR() == null || !this.mNetWork.vm().wj().isRequestSuccess()) {
                                    this.aqP.dH(i);
                                    com.baidu.tbadk.core.util.c.a(this.aqP);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    hVar.setErrorCode(this.mNetWork.vq());
                                    hVar.setErrorString(this.mNetWork.getErrorString());
                                    hVar.b(this.aqP);
                                    hVar.ay(false);
                                    return hVar;
                                }
                            }
                            yk = i + 1;
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
        this.aqO.add(new C0045b(str, String.valueOf(i)));
    }
}
