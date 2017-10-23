package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
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
    private a apj;
    private h apk;
    private String apl;
    private String apm;
    private List<C0049b> apn = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.apl = str;
        this.apm = str2;
    }

    public h er(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apl);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private h c(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.r(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        g cY = com.baidu.tbadk.core.util.c.cY(e);
        if (cY == null) {
            cY = new g();
            cY.eu(e);
            cY.dR(0);
            cY.N(file.length());
        }
        this.apj = new a(str, cY, TbConfig.SERVER_ADDRESS + this.apl, e);
        this.apk = this.apj.wZ();
        if (this.apk.isSuccess() && (a2 = a(e, cY)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cY.eu(audioInfoData.getVoiceId());
                this.apk.b(cY);
            } else {
                this.apk.setErrorCode(audioInfoData.getErrorCode());
                this.apk.setErrorString(audioInfoData.getErrorUserMsg());
                this.apk.ax(false);
            }
        }
        return this.apk;
    }

    private String a(String str, g gVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apm);
        this.mNetwork.n("voice_md5", gVar.xE());
        if (v.t(this.apn) != 0) {
            for (C0049b c0049b : this.apn) {
                if (c0049b != null) {
                    this.mNetwork.n(c0049b.getKey(), c0049b.getValue());
                }
            }
        }
        String ui = this.mNetwork.ui();
        if (ui == null || !this.mNetwork.uG().vD().isRequestSuccess()) {
            gVar.dR((int) M(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.apk.setErrorCode(this.mNetwork.uK());
            this.apk.setErrorString(this.mNetwork.getErrorString());
            this.apk.ax(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cX(str);
        return ui;
    }

    private long M(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private g apo;
        private boolean apq = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.apo = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.apo = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public h wZ() throws IOException {
            h hVar = new h();
            long totalLength = this.apo.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xF = this.apo.xF();
            if (xF < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xF * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= xF * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = xF;
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
                                this.mNetWork.n("chunk_md5", this.apo.xE());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.apq) {
                                    z = true;
                                } else if (this.mNetWork.ul() == null || !this.mNetWork.uG().vD().isRequestSuccess()) {
                                    this.apo.dR(i);
                                    com.baidu.tbadk.core.util.c.a(this.apo);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    hVar.setErrorCode(this.mNetWork.uK());
                                    hVar.setErrorString(this.mNetWork.getErrorString());
                                    hVar.b(this.apo);
                                    hVar.ax(false);
                                    return hVar;
                                }
                            }
                            xF = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    hVar.ax(false);
                    randomAccessFile.close();
                    return hVar;
                }
            }
            hVar.ax(true);
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
        this.apn.add(new C0049b(str, String.valueOf(i)));
    }
}
