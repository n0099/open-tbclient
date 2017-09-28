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
    private List<C0049b> apA = new ArrayList();
    private a apw;
    private h apx;
    private String apy;
    private String apz;
    private x mNetwork;

    public b(String str, String str2) {
        this.apy = str;
        this.apz = str2;
    }

    public h es(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apy);
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
        g cZ = com.baidu.tbadk.core.util.c.cZ(e);
        if (cZ == null) {
            cZ = new g();
            cZ.ev(e);
            cZ.dS(0);
            cZ.M(file.length());
        }
        this.apw = new a(str, cZ, TbConfig.SERVER_ADDRESS + this.apy, e);
        this.apx = this.apw.xg();
        if (this.apx.isSuccess() && (a2 = a(e, cZ)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cZ.ev(audioInfoData.getVoiceId());
                this.apx.b(cZ);
            } else {
                this.apx.setErrorCode(audioInfoData.getErrorCode());
                this.apx.setErrorString(audioInfoData.getErrorUserMsg());
                this.apx.ay(false);
            }
        }
        return this.apx;
    }

    private String a(String str, g gVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apz);
        this.mNetwork.n("voice_md5", gVar.xL());
        if (v.t(this.apA) != 0) {
            for (C0049b c0049b : this.apA) {
                if (c0049b != null) {
                    this.mNetwork.n(c0049b.getKey(), c0049b.getValue());
                }
            }
        }
        String up = this.mNetwork.up();
        if (up == null || !this.mNetwork.uN().vK().isRequestSuccess()) {
            gVar.dS((int) L(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.apx.setErrorCode(this.mNetwork.uR());
            this.apx.setErrorString(this.mNetwork.getErrorString());
            this.apx.ay(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cY(str);
        return up;
    }

    private long L(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private g apB;
        private boolean apC = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.apB = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.apB = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public h xg() throws IOException {
            h hVar = new h();
            long totalLength = this.apB.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xM = this.apB.xM();
            if (xM < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xM * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= xM * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = xM;
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
                                this.mNetWork.n("chunk_md5", this.apB.xL());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.apC) {
                                    z = true;
                                } else if (this.mNetWork.us() == null || !this.mNetWork.uN().vK().isRequestSuccess()) {
                                    this.apB.dS(i);
                                    com.baidu.tbadk.core.util.c.a(this.apB);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    hVar.setErrorCode(this.mNetWork.uR());
                                    hVar.setErrorString(this.mNetWork.getErrorString());
                                    hVar.b(this.apB);
                                    hVar.ay(false);
                                    return hVar;
                                }
                            }
                            xM = i + 1;
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
        this.apA.add(new C0049b(str, String.valueOf(i)));
    }
}
