package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private ab afX;
    private a afY;
    private com.baidu.tbadk.coreExtra.data.e afZ;
    private String aga;
    private String agb;
    private List<b> agc = new ArrayList();

    public c(String str, String str2) {
        this.aga = str;
        this.agb = str2;
    }

    public com.baidu.tbadk.coreExtra.data.e dY(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.afX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aga);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.e b(String str, File file) throws IOException {
        String a2;
        String k = t.k(m.n(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.d cN = com.baidu.tbadk.core.util.d.cN(k);
        if (cN == null) {
            cN = new com.baidu.tbadk.coreExtra.data.d();
            cN.setMd5(k);
            cN.dk(0);
            cN.K(file.length());
        }
        this.afY = new a(str, cN, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aga, k);
        this.afZ = this.afY.wd();
        if (this.afZ.isSuccess() && (a2 = a(k, cN)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cN.setMd5(audioInfoData.getVoiceId());
                this.afZ.b(cN);
            } else {
                this.afZ.setErrorCode(audioInfoData.getErrorCode());
                this.afZ.setErrorString(audioInfoData.getErrorUserMsg());
                this.afZ.aw(false);
            }
        }
        return this.afZ;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.d dVar) {
        this.afX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.agb);
        this.afX.n("voice_md5", dVar.getMd5());
        if (y.s(this.agc) != 0) {
            for (b bVar : this.agc) {
                if (bVar != null) {
                    this.afX.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String sZ = this.afX.sZ();
        if (sZ == null || !this.afX.tx().uv().nJ()) {
            dVar.dk((int) J(dVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(dVar);
            this.afZ.setErrorCode(this.afX.tB());
            this.afZ.setErrorString(this.afX.getErrorString());
            this.afZ.aw(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cM(str);
        return sZ;
    }

    private long J(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab LI;
        private com.baidu.tbadk.coreExtra.data.d agd;
        private boolean agf = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.d dVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.agd = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.agd = dVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.e wd() throws IOException {
            com.baidu.tbadk.coreExtra.data.e eVar = new com.baidu.tbadk.coreExtra.data.e();
            long totalLength = this.agd.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int ww = this.agd.ww();
            if (ww < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(ww * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < ww * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    eVar.aw(false);
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
                            this.LI = new ab(this.mUrl);
                            this.LI.d("voice_chunk", bArr);
                            this.LI.n("chunk_md5", this.agd.getMd5());
                            this.LI.n("length", String.valueOf(read));
                            this.LI.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.LI.n("total_length", String.valueOf(totalLength));
                            this.LI.n("chunk_no", String.valueOf(i + 1));
                            this.LI.n("total_num", String.valueOf(j));
                            this.LI.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.agf) {
                                z = true;
                            } else if (this.LI.tc() == null || !this.LI.tx().uv().nJ()) {
                                this.agd.dk(i);
                                com.baidu.tbadk.core.util.d.a(this.agd);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                eVar.setErrorCode(this.LI.tB());
                                eVar.setErrorString(this.LI.getErrorString());
                                eVar.b(this.agd);
                                eVar.aw(false);
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
            eVar.aw(true);
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
        this.agc.add(new b(str, String.valueOf(i)));
    }
}
