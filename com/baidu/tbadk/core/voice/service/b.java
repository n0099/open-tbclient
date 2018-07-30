package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
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
    private List<C0104b> aAA = new ArrayList();
    private a aAw;
    private j aAx;
    private String aAy;
    private String aAz;
    private y mNetwork;

    public b(String str, String str2) {
        this.aAy = str;
        this.aAz = str2;
    }

    public j fv(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.aAy);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private j b(String str, File file) throws IOException {
        String a2;
        String g = s.g(l.q(file));
        if (g != null && g.length() > 0) {
            g = g.toLowerCase();
        }
        i dP = com.baidu.tbadk.core.util.c.dP(g);
        if (dP == null) {
            dP = new i();
            dP.fy(g);
            dP.dU(0);
            dP.W(file.length());
        }
        this.aAw = new a(str, dP, TbConfig.SERVER_ADDRESS + this.aAy, g);
        this.aAx = this.aAw.Bq();
        if (this.aAx.isSuccess() && (a2 = a(g, dP)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dP.fy(audioInfoData.getVoiceId());
                this.aAx.b(dP);
            } else {
                this.aAx.setErrorCode(audioInfoData.getErrorCode());
                this.aAx.setErrorString(audioInfoData.getErrorUserMsg());
                this.aAx.aD(false);
            }
        }
        return this.aAx;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.aAz);
        this.mNetwork.o("voice_md5", iVar.Cf());
        if (w.y(this.aAA) != 0) {
            for (C0104b c0104b : this.aAA) {
                if (c0104b != null) {
                    this.mNetwork.o(c0104b.getKey(), c0104b.getValue());
                }
            }
        }
        String yq = this.mNetwork.yq();
        if (yq == null || !this.mNetwork.yO().zN().isRequestSuccess()) {
            iVar.dU((int) V(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.aAx.setErrorCode(this.mNetwork.yS());
            this.aAx.setErrorString(this.mNetwork.getErrorString());
            this.aAx.aD(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dO(str);
        return yq;
    }

    private long V(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i aAB;
        private boolean aAC = false;
        private String mFileName;
        private y mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aAB = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aAB = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j Bq() throws IOException {
            j jVar = new j();
            long totalLength = this.aAB.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int Cg = this.aAB.Cg();
            if (Cg < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(Cg * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= Cg * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = Cg;
                        if (i < j) {
                            int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            if (i == j - 1) {
                                i2 = (int) (totalLength - (30720 * (j - 1)));
                            }
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile.read(bArr, 0, i2);
                            if (read != -1) {
                                this.mNetWork = new y(this.mUrl);
                                this.mNetWork.d("voice_chunk", bArr);
                                this.mNetWork.o("chunk_md5", this.aAB.Cf());
                                this.mNetWork.o("length", String.valueOf(read));
                                this.mNetWork.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.o("total_length", String.valueOf(totalLength));
                                this.mNetWork.o("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.o("total_num", String.valueOf(j));
                                this.mNetWork.o("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aAC) {
                                    z = true;
                                } else if (this.mNetWork.yt() == null || !this.mNetWork.yO().zN().isRequestSuccess()) {
                                    this.aAB.dU(i);
                                    com.baidu.tbadk.core.util.c.a(this.aAB);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.yS());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.aAB);
                                    jVar.aD(false);
                                    return jVar;
                                }
                            }
                            Cg = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.aD(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.aD(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0104b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0104b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.aAA.add(new C0104b(str, String.valueOf(i)));
    }
}
