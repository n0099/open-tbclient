package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a aqc;
    private j aqd;
    private String aqe;
    private String aqf;
    private List<C0062b> aqg = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.aqe = str;
        this.aqf = str2;
    }

    public j eD(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aqe);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private j c(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.q(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        i df = com.baidu.tbadk.core.util.c.df(e);
        if (df == null) {
            df = new i();
            df.eG(e);
            df.dS(0);
            df.Q(file.length());
        }
        this.aqc = new a(str, df, TbConfig.SERVER_ADDRESS + this.aqe, e);
        this.aqd = this.aqc.xg();
        if (this.aqd.isSuccess() && (a2 = a(e, df)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                df.eG(audioInfoData.getVoiceId());
                this.aqd.b(df);
            } else {
                this.aqd.setErrorCode(audioInfoData.getErrorCode());
                this.aqd.setErrorString(audioInfoData.getErrorUserMsg());
                this.aqd.av(false);
            }
        }
        return this.aqd;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aqf);
        this.mNetwork.n("voice_md5", iVar.xV());
        if (v.v(this.aqg) != 0) {
            for (C0062b c0062b : this.aqg) {
                if (c0062b != null) {
                    this.mNetwork.n(c0062b.getKey(), c0062b.getValue());
                }
            }
        }
        String up = this.mNetwork.up();
        if (up == null || !this.mNetwork.uN().vL().isRequestSuccess()) {
            iVar.dS((int) P(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.aqd.setErrorCode(this.mNetwork.uR());
            this.aqd.setErrorString(this.mNetwork.getErrorString());
            this.aqd.av(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.de(str);
        return up;
    }

    private long P(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i aqh;
        private boolean aqi = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aqh = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aqh = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j xg() throws IOException {
            j jVar = new j();
            long totalLength = this.aqh.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xW = this.aqh.xW();
            if (xW < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xW * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= xW * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = xW;
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
                                this.mNetWork.n("chunk_md5", this.aqh.xV());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aqi) {
                                    z = true;
                                } else if (this.mNetWork.us() == null || !this.mNetWork.uN().vL().isRequestSuccess()) {
                                    this.aqh.dS(i);
                                    com.baidu.tbadk.core.util.c.a(this.aqh);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.uR());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.aqh);
                                    jVar.av(false);
                                    return jVar;
                                }
                            }
                            xW = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.av(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.av(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0062b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0062b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.aqg.add(new C0062b(str, String.valueOf(i)));
    }
}
