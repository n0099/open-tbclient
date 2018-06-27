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
    private a aAC;
    private j aAD;
    private String aAE;
    private String aAF;
    private List<C0107b> aAG = new ArrayList();
    private y mNetwork;

    public b(String str, String str2) {
        this.aAE = str;
        this.aAF = str2;
    }

    public j fx(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.aAE);
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
        i dS = com.baidu.tbadk.core.util.c.dS(g);
        if (dS == null) {
            dS = new i();
            dS.fA(g);
            dS.dR(0);
            dS.U(file.length());
        }
        this.aAC = new a(str, dS, TbConfig.SERVER_ADDRESS + this.aAE, g);
        this.aAD = this.aAC.By();
        if (this.aAD.isSuccess() && (a2 = a(g, dS)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dS.fA(audioInfoData.getVoiceId());
                this.aAD.b(dS);
            } else {
                this.aAD.setErrorCode(audioInfoData.getErrorCode());
                this.aAD.setErrorString(audioInfoData.getErrorUserMsg());
                this.aAD.aF(false);
            }
        }
        return this.aAD;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.aAF);
        this.mNetwork.o("voice_md5", iVar.Cn());
        if (w.z(this.aAG) != 0) {
            for (C0107b c0107b : this.aAG) {
                if (c0107b != null) {
                    this.mNetwork.o(c0107b.getKey(), c0107b.getValue());
                }
            }
        }
        String yz = this.mNetwork.yz();
        if (yz == null || !this.mNetwork.yX().zY().isRequestSuccess()) {
            iVar.dR((int) T(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.aAD.setErrorCode(this.mNetwork.zb());
            this.aAD.setErrorString(this.mNetwork.getErrorString());
            this.aAD.aF(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dR(str);
        return yz;
    }

    private long T(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i aAH;
        private boolean aAI = false;
        private String mFileName;
        private y mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aAH = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aAH = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j By() throws IOException {
            j jVar = new j();
            long totalLength = this.aAH.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int Co = this.aAH.Co();
            if (Co < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(Co * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= Co * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = Co;
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
                                this.mNetWork.o("chunk_md5", this.aAH.Cn());
                                this.mNetWork.o("length", String.valueOf(read));
                                this.mNetWork.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.o("total_length", String.valueOf(totalLength));
                                this.mNetWork.o("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.o("total_num", String.valueOf(j));
                                this.mNetWork.o("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aAI) {
                                    z = true;
                                } else if (this.mNetWork.yC() == null || !this.mNetWork.yX().zY().isRequestSuccess()) {
                                    this.aAH.dR(i);
                                    com.baidu.tbadk.core.util.c.a(this.aAH);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.zb());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.aAH);
                                    jVar.aF(false);
                                    return jVar;
                                }
                            }
                            Co = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.aF(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.aF(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0107b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0107b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.aAG.add(new C0107b(str, String.valueOf(i)));
    }
}
