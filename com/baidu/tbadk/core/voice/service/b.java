package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a apE;
    private i apF;
    private String apG;
    private String apH;
    private List<C0049b> apI = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.apG = str;
        this.apH = str2;
    }

    public i ey(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apG);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private i c(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.q(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        h df = com.baidu.tbadk.core.util.c.df(e);
        if (df == null) {
            df = new h();
            df.eB(e);
            df.dR(0);
            df.N(file.length());
        }
        this.apE = new a(str, df, TbConfig.SERVER_ADDRESS + this.apG, e);
        this.apF = this.apE.xg();
        if (this.apF.isSuccess() && (a2 = a(e, df)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                df.eB(audioInfoData.getVoiceId());
                this.apF.b(df);
            } else {
                this.apF.setErrorCode(audioInfoData.getErrorCode());
                this.apF.setErrorString(audioInfoData.getErrorUserMsg());
                this.apF.av(false);
            }
        }
        return this.apF;
    }

    private String a(String str, h hVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apH);
        this.mNetwork.n("voice_md5", hVar.xT());
        if (v.u(this.apI) != 0) {
            for (C0049b c0049b : this.apI) {
                if (c0049b != null) {
                    this.mNetwork.n(c0049b.getKey(), c0049b.getValue());
                }
            }
        }
        String up = this.mNetwork.up();
        if (up == null || !this.mNetwork.uN().vL().isRequestSuccess()) {
            hVar.dR((int) M(hVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(hVar);
            this.apF.setErrorCode(this.mNetwork.uR());
            this.apF.setErrorString(this.mNetwork.getErrorString());
            this.apF.av(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.de(str);
        return up;
    }

    private long M(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private h apJ;
        private boolean apK = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, h hVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.apJ = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.apJ = hVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public i xg() throws IOException {
            i iVar = new i();
            long totalLength = this.apJ.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xU = this.apJ.xU();
            if (xU < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xU * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= xU * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = xU;
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
                                this.mNetWork.n("chunk_md5", this.apJ.xT());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.apK) {
                                    z = true;
                                } else if (this.mNetWork.us() == null || !this.mNetWork.uN().vL().isRequestSuccess()) {
                                    this.apJ.dR(i);
                                    com.baidu.tbadk.core.util.c.a(this.apJ);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    iVar.setErrorCode(this.mNetWork.uR());
                                    iVar.setErrorString(this.mNetWork.getErrorString());
                                    iVar.b(this.apJ);
                                    iVar.av(false);
                                    return iVar;
                                }
                            }
                            xU = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    iVar.av(false);
                    randomAccessFile.close();
                    return iVar;
                }
            }
            iVar.av(true);
            return iVar;
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

    public void x(String str, int i) {
        this.apI.add(new C0049b(str, String.valueOf(i)));
    }
}
