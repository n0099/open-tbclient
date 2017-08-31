package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
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
    private a aqq;
    private h aqr;
    private String aqs;
    private String aqt;
    private List<C0049b> aqu = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.aqs = str;
        this.aqt = str2;
    }

    public h ey(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aqs);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private h c(String str, File file) throws IOException {
        String a2;
        String e = r.e(k.s(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        g dj = com.baidu.tbadk.core.util.c.dj(e);
        if (dj == null) {
            dj = new g();
            dj.eB(e);
            dj.dI(0);
            dj.N(file.length());
        }
        this.aqq = new a(str, dj, TbConfig.SERVER_ADDRESS + this.aqs, e);
        this.aqr = this.aqq.xH();
        if (this.aqr.isSuccess() && (a2 = a(e, dj)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dj.eB(audioInfoData.getVoiceId());
                this.aqr.b(dj);
            } else {
                this.aqr.setErrorCode(audioInfoData.getErrorCode());
                this.aqr.setErrorString(audioInfoData.getErrorUserMsg());
                this.aqr.ay(false);
            }
        }
        return this.aqr;
    }

    private String a(String str, g gVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aqt);
        this.mNetwork.n("voice_md5", gVar.ym());
        if (v.u(this.aqu) != 0) {
            for (C0049b c0049b : this.aqu) {
                if (c0049b != null) {
                    this.mNetwork.n(c0049b.getKey(), c0049b.getValue());
                }
            }
        }
        String uM = this.mNetwork.uM();
        if (uM == null || !this.mNetwork.vj().wg().isRequestSuccess()) {
            gVar.dI((int) M(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.aqr.setErrorCode(this.mNetwork.vn());
            this.aqr.setErrorString(this.mNetwork.getErrorString());
            this.aqr.ay(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.di(str);
        return uM;
    }

    private long M(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private g aqv;
        private boolean aqw = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aqv = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aqv = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public h xH() throws IOException {
            h hVar = new h();
            long totalLength = this.aqv.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int yn = this.aqv.yn();
            if (yn < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(yn * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= yn * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = yn;
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
                                this.mNetWork.n("chunk_md5", this.aqv.ym());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aqw) {
                                    z = true;
                                } else if (this.mNetWork.uO() == null || !this.mNetWork.vj().wg().isRequestSuccess()) {
                                    this.aqv.dI(i);
                                    com.baidu.tbadk.core.util.c.a(this.aqv);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    hVar.setErrorCode(this.mNetWork.vn());
                                    hVar.setErrorString(this.mNetWork.getErrorString());
                                    hVar.b(this.aqv);
                                    hVar.ay(false);
                                    return hVar;
                                }
                            }
                            yn = i + 1;
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
    public class C0049b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0049b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void v(String str, int i) {
        this.aqu.add(new C0049b(str, String.valueOf(i)));
    }
}
