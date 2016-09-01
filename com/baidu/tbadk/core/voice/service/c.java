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
    private ab aiS;
    private a aiT;
    private com.baidu.tbadk.coreExtra.data.h aiU;
    private String aiV;
    private String aiW;
    private List<b> aiX = new ArrayList();

    public c(String str, String str2) {
        this.aiV = str;
        this.aiW = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h eb(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aiS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiV);
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
        com.baidu.tbadk.coreExtra.data.g cQ = com.baidu.tbadk.core.util.d.cQ(k);
        if (cQ == null) {
            cQ = new com.baidu.tbadk.coreExtra.data.g();
            cQ.setMd5(k);
            cQ.dy(0);
            cQ.N(file.length());
        }
        this.aiT = new a(str, cQ, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiV, k);
        this.aiU = this.aiT.xh();
        if (this.aiU.isSuccess() && (a2 = a(k, cQ)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cQ.setMd5(audioInfoData.getVoiceId());
                this.aiU.b(cQ);
            } else {
                this.aiU.setErrorCode(audioInfoData.getErrorCode());
                this.aiU.setErrorString(audioInfoData.getErrorUserMsg());
                this.aiU.ax(false);
            }
        }
        return this.aiU;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.aiS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiW);
        this.aiS.n("voice_md5", gVar.getMd5());
        if (y.s(this.aiX) != 0) {
            for (b bVar : this.aiX) {
                if (bVar != null) {
                    this.aiS.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String ue = this.aiS.ue();
        if (ue == null || !this.aiS.uD().vA().oE()) {
            gVar.dy((int) M(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(gVar);
            this.aiU.setErrorCode(this.aiS.uH());
            this.aiU.setErrorString(this.aiS.getErrorString());
            this.aiU.ax(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cP(str);
        return ue;
    }

    private long M(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab NX;
        private com.baidu.tbadk.coreExtra.data.g aiY;
        private boolean aiZ = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aiY = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aiY = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xh() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.aiY.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xG = this.aiY.xG();
            if (xG < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xG * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xG * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.ax(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xG;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.NX = new ab(this.mUrl);
                            this.NX.d("voice_chunk", bArr);
                            this.NX.n("chunk_md5", this.aiY.getMd5());
                            this.NX.n("length", String.valueOf(read));
                            this.NX.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.NX.n("total_length", String.valueOf(totalLength));
                            this.NX.n("chunk_no", String.valueOf(i + 1));
                            this.NX.n("total_num", String.valueOf(j));
                            this.NX.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aiZ) {
                                z = true;
                            } else if (this.NX.uh() == null || !this.NX.uD().vA().oE()) {
                                this.aiY.dy(i);
                                com.baidu.tbadk.core.util.d.a(this.aiY);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.NX.uH());
                                hVar.setErrorString(this.NX.getErrorString());
                                hVar.b(this.aiY);
                                hVar.ax(false);
                                return hVar;
                            }
                        }
                        xG = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.ax(true);
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

    public void v(String str, int i) {
        this.aiX.add(new b(str, String.valueOf(i)));
    }
}
