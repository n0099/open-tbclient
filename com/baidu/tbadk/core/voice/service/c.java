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
    private ab aiW;
    private a aiX;
    private com.baidu.tbadk.coreExtra.data.d aiY;
    private String aiZ;
    private String aja;
    private List<b> ajb = new ArrayList();

    public c(String str, String str2) {
        this.aiZ = str;
        this.aja = str2;
    }

    public com.baidu.tbadk.coreExtra.data.d dZ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aiW = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiZ);
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
        com.baidu.tbadk.coreExtra.data.c cQ = com.baidu.tbadk.core.util.d.cQ(d);
        if (cQ == null) {
            cQ = new com.baidu.tbadk.coreExtra.data.c();
            cQ.setMd5(d);
            cQ.dD(0);
            cQ.L(file.length());
        }
        this.aiX = new a(str, cQ, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiZ, d);
        this.aiY = this.aiX.yf();
        if (this.aiY.isSuccess() && (a2 = a(d, cQ)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cQ.setMd5(audioInfoData.getVoiceId());
                this.aiY.b(cQ);
            } else {
                this.aiY.setErrorCode(audioInfoData.getErrorCode());
                this.aiY.setErrorString(audioInfoData.getErrorUserMsg());
                this.aiY.as(false);
            }
        }
        return this.aiY;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.c cVar) {
        this.aiW = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aja);
        this.aiW.p("voice_md5", cVar.getMd5());
        if (y.p(this.ajb) != 0) {
            for (b bVar : this.ajb) {
                if (bVar != null) {
                    this.aiW.p(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String vw = this.aiW.vw();
        if (vw == null || !this.aiW.vU().wP().qC()) {
            cVar.dD((int) K(cVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(cVar);
            this.aiY.setErrorCode(this.aiW.vY());
            this.aiY.setErrorString(this.aiW.getErrorString());
            this.aiY.as(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cP(str);
        return vw;
    }

    private long K(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab QV;
        private com.baidu.tbadk.coreExtra.data.c ajc;
        private boolean ajd = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.c cVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.ajc = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.ajc = cVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.d yf() {
            com.baidu.tbadk.coreExtra.data.d dVar = new com.baidu.tbadk.coreExtra.data.d();
            long totalLength = this.ajc.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int yz = this.ajc.yz();
            if (yz < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(yz * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < yz * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    dVar.as(false);
                    randomAccessFile.close();
                    return dVar;
                }
                while (true) {
                    int i = yz;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.QV = new ab(this.mUrl);
                            this.QV.c("voice_chunk", bArr);
                            this.QV.p("chunk_md5", this.ajc.getMd5());
                            this.QV.p("length", String.valueOf(read));
                            this.QV.p("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.QV.p("total_length", String.valueOf(totalLength));
                            this.QV.p("chunk_no", String.valueOf(i + 1));
                            this.QV.p("total_num", String.valueOf(j));
                            this.QV.p("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.ajd) {
                                z = true;
                            } else if (this.QV.vz() == null || !this.QV.vU().wP().qC()) {
                                this.ajc.dD(i);
                                com.baidu.tbadk.core.util.d.a(this.ajc);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                dVar.setErrorCode(this.QV.vY());
                                dVar.setErrorString(this.QV.getErrorString());
                                dVar.b(this.ajc);
                                dVar.as(false);
                                return dVar;
                            }
                        }
                        yz = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            dVar.as(true);
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

    public void t(String str, int i) {
        this.ajb.add(new b(str, String.valueOf(i)));
    }
}
