package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private aa aiG;
    private a aiH;
    private com.baidu.tbadk.coreExtra.data.d aiI;
    private String aiJ;
    private String aiK;
    private List<b> aiL = new ArrayList();

    public c(String str, String str2) {
        this.aiJ = str;
        this.aiK = str2;
    }

    public com.baidu.tbadk.coreExtra.data.d dS(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aiG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiJ);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.d a(String str, File file) {
        String a2;
        String f = t.f(m.o(file));
        if (f != null && f.length() > 0) {
            f = f.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.c cN = com.baidu.tbadk.core.util.d.cN(f);
        if (cN == null) {
            cN = new com.baidu.tbadk.coreExtra.data.c();
            cN.setMd5(f);
            cN.dA(0);
            cN.J(file.length());
        }
        this.aiH = new a(str, cN, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiJ, f);
        this.aiI = this.aiH.xE();
        if (this.aiI.isSuccess() && (a2 = a(f, cN)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cN.setMd5(audioInfoData.getVoiceId());
                this.aiI.b(cN);
            } else {
                this.aiI.setErrorCode(audioInfoData.getErrorCode());
                this.aiI.setErrorString(audioInfoData.getErrorUserMsg());
                this.aiI.aq(false);
            }
        }
        return this.aiI;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        this.aiG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiK);
        this.aiG.p("voice_md5", cVar.getMd5());
        if (x.o(this.aiL) != 0) {
            for (b bVar : this.aiL) {
                if (bVar != null) {
                    this.aiG.p(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uZ = this.aiG.uZ();
        if (uZ == null || !this.aiG.vB().ww().rl()) {
            cVar.dA((int) I(cVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(cVar);
            this.aiI.setErrorCode(this.aiG.vF());
            this.aiI.setErrorString(this.aiG.getErrorString());
            this.aiI.aq(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cM(str);
        return uZ;
    }

    private long I(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private aa Ty;
        private com.baidu.tbadk.coreExtra.data.c aiM;
        private boolean aiN = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.c cVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aiM = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aiM = cVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.d xE() {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            long totalLength = this.aiM.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xY = this.aiM.xY();
            if (xY < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xY * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xY * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    dVar.aq(false);
                    randomAccessFile.close();
                    return dVar;
                }
                while (true) {
                    int i = xY;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Ty = new aa(this.mUrl);
                            this.Ty.d("voice_chunk", bArr);
                            this.Ty.p("chunk_md5", this.aiM.getMd5());
                            this.Ty.p("length", String.valueOf(read));
                            this.Ty.p("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Ty.p("total_length", String.valueOf(totalLength));
                            this.Ty.p("chunk_no", String.valueOf(i + 1));
                            this.Ty.p("total_num", String.valueOf(j));
                            this.Ty.p("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aiN) {
                                z = true;
                            } else if (this.Ty.vc() == null || !this.Ty.vB().ww().rl()) {
                                this.aiM.dA(i);
                                com.baidu.tbadk.core.util.d.a(this.aiM);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                dVar.setErrorCode(this.Ty.vF());
                                dVar.setErrorString(this.Ty.getErrorString());
                                dVar.b(this.aiM);
                                dVar.aq(false);
                                return dVar;
                            }
                        }
                        xY = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            dVar.aq(true);
            return dVar;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void s(String str, int i) {
        this.aiL.add(new b(str, String.valueOf(i)));
    }
}
