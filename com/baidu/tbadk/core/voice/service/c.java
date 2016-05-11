package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private ab aeI;
    private a aeJ;
    private com.baidu.tbadk.coreExtra.data.d aeK;
    private String aeL;
    private String aeM;
    private List<b> aeN = new ArrayList();

    public c(String str, String str2) {
        this.aeL = str;
        this.aeM = str2;
    }

    public com.baidu.tbadk.coreExtra.data.d dV(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aeI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aeL);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.d a(String str, File file) {
        String a2;
        String d = t.d(m.m(file));
        if (d != null && d.length() > 0) {
            d = d.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.c cO = com.baidu.tbadk.core.util.d.cO(d);
        if (cO == null) {
            cO = new com.baidu.tbadk.coreExtra.data.c();
            cO.setMd5(d);
            cO.dj(0);
            cO.M(file.length());
        }
        this.aeJ = new a(str, cO, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aeL, d);
        this.aeK = this.aeJ.vZ();
        if (this.aeK.isSuccess() && (a2 = a(d, cO)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cO.setMd5(audioInfoData.getVoiceId());
                this.aeK.b(cO);
            } else {
                this.aeK.setErrorCode(audioInfoData.getErrorCode());
                this.aeK.setErrorString(audioInfoData.getErrorUserMsg());
                this.aeK.av(false);
            }
        }
        return this.aeK;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        this.aeI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aeM);
        this.aeI.n("voice_md5", cVar.getMd5());
        if (y.r(this.aeN) != 0) {
            for (b bVar : this.aeN) {
                if (bVar != null) {
                    this.aeI.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String tc = this.aeI.tc();
        if (tc == null || !this.aeI.tA().uv().nZ()) {
            cVar.dj((int) L(cVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(cVar);
            this.aeK.setErrorCode(this.aeI.tE());
            this.aeK.setErrorString(this.aeI.getErrorString());
            this.aeK.av(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cN(str);
        return tc;
    }

    private long L(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab LL;
        private com.baidu.tbadk.coreExtra.data.c aeO;
        private boolean aeP = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.c cVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aeO = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aeO = cVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.d vZ() {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            long totalLength = this.aeO.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int ws = this.aeO.ws();
            if (ws < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(ws * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < ws * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    dVar.av(false);
                    randomAccessFile.close();
                    return dVar;
                }
                while (true) {
                    int i = ws;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.LL = new ab(this.mUrl);
                            this.LL.c("voice_chunk", bArr);
                            this.LL.n("chunk_md5", this.aeO.getMd5());
                            this.LL.n("length", String.valueOf(read));
                            this.LL.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.LL.n("total_length", String.valueOf(totalLength));
                            this.LL.n("chunk_no", String.valueOf(i + 1));
                            this.LL.n("total_num", String.valueOf(j));
                            this.LL.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aeP) {
                                z = true;
                            } else if (this.LL.tf() == null || !this.LL.tA().uv().nZ()) {
                                this.aeO.dj(i);
                                com.baidu.tbadk.core.util.d.a(this.aeO);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                dVar.setErrorCode(this.LL.tE());
                                dVar.setErrorString(this.LL.getErrorString());
                                dVar.b(this.aeO);
                                dVar.av(false);
                                return dVar;
                            }
                        }
                        ws = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            dVar.av(true);
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

    public void u(String str, int i) {
        this.aeN.add(new b(str, String.valueOf(i)));
    }
}
