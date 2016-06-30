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
    private ab afj;
    private a afk;
    private com.baidu.tbadk.coreExtra.data.e afl;
    private String afm;
    private String afn;
    private List<b> afo = new ArrayList();

    public c(String str, String str2) {
        this.afm = str;
        this.afn = str2;
    }

    public com.baidu.tbadk.coreExtra.data.e dZ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afj = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afm);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.e a(String str, File file) {
        String a2;
        String d = t.d(m.m(file));
        if (d != null && d.length() > 0) {
            d = d.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.d cN = com.baidu.tbadk.core.util.d.cN(d);
        if (cN == null) {
            cN = new com.baidu.tbadk.coreExtra.data.d();
            cN.setMd5(d);
            cN.dk(0);
            cN.P(file.length());
        }
        this.afk = new a(str, cN, String.valueOf(TbConfig.SERVER_ADDRESS) + this.afm, d);
        this.afl = this.afk.wd();
        if (this.afl.isSuccess() && (a2 = a(d, cN)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cN.setMd5(audioInfoData.getVoiceId());
                this.afl.b(cN);
            } else {
                this.afl.setErrorCode(audioInfoData.getErrorCode());
                this.afl.setErrorString(audioInfoData.getErrorUserMsg());
                this.afl.at(false);
            }
        }
        return this.afl;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.d dVar) {
        this.afj = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.afn);
        this.afj.n("voice_md5", dVar.getMd5());
        if (y.s(this.afo) != 0) {
            for (b bVar : this.afo) {
                if (bVar != null) {
                    this.afj.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String ta = this.afj.ta();
        if (ta == null || !this.afj.ty().uv().nU()) {
            dVar.dk((int) O(dVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(dVar);
            this.afl.setErrorCode(this.afj.tC());
            this.afl.setErrorString(this.afj.getErrorString());
            this.afl.at(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cM(str);
        return ta;
    }

    private long O(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab LK;
        private com.baidu.tbadk.coreExtra.data.d afp;
        private boolean afq = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.d dVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.afp = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.afp = dVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.e wd() {
            com.baidu.tbadk.coreExtra.data.e eVar = new com.baidu.tbadk.coreExtra.data.e();
            long totalLength = this.afp.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int ww = this.afp.ww();
            if (ww < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(ww * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < ww * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    eVar.at(false);
                    randomAccessFile.close();
                    return eVar;
                }
                while (true) {
                    int i = ww;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.LK = new ab(this.mUrl);
                            this.LK.d("voice_chunk", bArr);
                            this.LK.n("chunk_md5", this.afp.getMd5());
                            this.LK.n("length", String.valueOf(read));
                            this.LK.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.LK.n("total_length", String.valueOf(totalLength));
                            this.LK.n("chunk_no", String.valueOf(i + 1));
                            this.LK.n("total_num", String.valueOf(j));
                            this.LK.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.afq) {
                                z = true;
                            } else if (this.LK.td() == null || !this.LK.ty().uv().nU()) {
                                this.afp.dk(i);
                                com.baidu.tbadk.core.util.d.a(this.afp);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                eVar.setErrorCode(this.LK.tC());
                                eVar.setErrorString(this.LK.getErrorString());
                                eVar.b(this.afp);
                                eVar.at(false);
                                return eVar;
                            }
                        }
                        ww = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            eVar.at(true);
            return eVar;
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

    public void w(String str, int i) {
        this.afo.add(new b(str, String.valueOf(i)));
    }
}
