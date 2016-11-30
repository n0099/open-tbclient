package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private z ajm;
    private a ajn;
    private com.baidu.tbadk.coreExtra.data.h ajo;
    private String ajp;
    private String ajq;
    private List<b> ajr = new ArrayList();

    public c(String str, String str2) {
        this.ajp = str;
        this.ajq = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h eg(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.ajm = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ajp);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.h b(String str, File file) throws IOException {
        String a2;
        String k = t.k(m.n(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.g cU = com.baidu.tbadk.core.util.d.cU(k);
        if (cU == null) {
            cU = new com.baidu.tbadk.coreExtra.data.g();
            cU.setMd5(k);
            cU.dA(0);
            cU.N(file.length());
        }
        this.ajn = new a(str, cU, String.valueOf(TbConfig.SERVER_ADDRESS) + this.ajp, k);
        this.ajo = this.ajn.xo();
        if (this.ajo.isSuccess() && (a2 = a(k, cU)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cU.setMd5(audioInfoData.getVoiceId());
                this.ajo.b(cU);
            } else {
                this.ajo.setErrorCode(audioInfoData.getErrorCode());
                this.ajo.setErrorString(audioInfoData.getErrorUserMsg());
                this.ajo.aA(false);
            }
        }
        return this.ajo;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.ajm = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ajq);
        this.ajm.n("voice_md5", gVar.getMd5());
        if (x.s(this.ajr) != 0) {
            for (b bVar : this.ajr) {
                if (bVar != null) {
                    this.ajm.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uy = this.ajm.uy();
        if (uy == null || !this.ajm.uW().vS().oH()) {
            gVar.dA((int) M(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(gVar);
            this.ajo.setErrorCode(this.ajm.va());
            this.ajo.setErrorString(this.ajm.getErrorString());
            this.ajo.aA(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cT(str);
        return uy;
    }

    private long M(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private z Ob;
        private com.baidu.tbadk.coreExtra.data.g ajs;
        private boolean ajt = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.ajs = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.ajs = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xo() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.ajs.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xP = this.ajs.xP();
            if (xP < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xP * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xP * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.aA(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xP;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.Ob = new z(this.mUrl);
                            this.Ob.d("voice_chunk", bArr);
                            this.Ob.n("chunk_md5", this.ajs.getMd5());
                            this.Ob.n("length", String.valueOf(read));
                            this.Ob.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.Ob.n("total_length", String.valueOf(totalLength));
                            this.Ob.n("chunk_no", String.valueOf(i + 1));
                            this.Ob.n("total_num", String.valueOf(j));
                            this.Ob.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.ajt) {
                                z = true;
                            } else if (this.Ob.uB() == null || !this.Ob.uW().vS().oH()) {
                                this.ajs.dA(i);
                                com.baidu.tbadk.core.util.d.a(this.ajs);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.Ob.va());
                                hVar.setErrorString(this.Ob.getErrorString());
                                hVar.b(this.ajs);
                                hVar.aA(false);
                                return hVar;
                            }
                        }
                        xP = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.aA(true);
            return hVar;
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
        this.ajr.add(new b(str, String.valueOf(i)));
    }
}
