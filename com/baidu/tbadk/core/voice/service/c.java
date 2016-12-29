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
    private z aiN;
    private a aiO;
    private com.baidu.tbadk.coreExtra.data.h aiP;
    private String aiQ;
    private String aiR;
    private List<b> aiS = new ArrayList();

    public c(String str, String str2) {
        this.aiQ = str;
        this.aiR = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h ed(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aiN = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiQ);
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
        com.baidu.tbadk.coreExtra.data.g cV = com.baidu.tbadk.core.util.d.cV(k);
        if (cV == null) {
            cV = new com.baidu.tbadk.coreExtra.data.g();
            cV.setMd5(k);
            cV.dC(0);
            cV.M(file.length());
        }
        this.aiO = new a(str, cV, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiQ, k);
        this.aiP = this.aiO.xb();
        if (this.aiP.isSuccess() && (a2 = a(k, cV)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cV.setMd5(audioInfoData.getVoiceId());
                this.aiP.b(cV);
            } else {
                this.aiP.setErrorCode(audioInfoData.getErrorCode());
                this.aiP.setErrorString(audioInfoData.getErrorUserMsg());
                this.aiP.aB(false);
            }
        }
        return this.aiP;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.aiN = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiR);
        this.aiN.n("voice_md5", gVar.getMd5());
        if (x.s(this.aiS) != 0) {
            for (b bVar : this.aiS) {
                if (bVar != null) {
                    this.aiN.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uk = this.aiN.uk();
        if (uk == null || !this.aiN.uI().vC().oH()) {
            gVar.dC((int) L(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(gVar);
            this.aiP.setErrorCode(this.aiN.uM());
            this.aiP.setErrorString(this.aiN.getErrorString());
            this.aiP.aB(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cU(str);
        return uk;
    }

    private long L(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private z NX;
        private com.baidu.tbadk.coreExtra.data.g aiT;
        private boolean aiU = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aiT = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aiT = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xb() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.aiT.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xD = this.aiT.xD();
            if (xD < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xD * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xD * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.aB(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xD;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.NX = new z(this.mUrl);
                            this.NX.d("voice_chunk", bArr);
                            this.NX.n("chunk_md5", this.aiT.getMd5());
                            this.NX.n("length", String.valueOf(read));
                            this.NX.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.NX.n("total_length", String.valueOf(totalLength));
                            this.NX.n("chunk_no", String.valueOf(i + 1));
                            this.NX.n("total_num", String.valueOf(j));
                            this.NX.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aiU) {
                                z = true;
                            } else if (this.NX.un() == null || !this.NX.uI().vC().oH()) {
                                this.aiT.dC(i);
                                com.baidu.tbadk.core.util.d.a(this.aiT);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.NX.uM());
                                hVar.setErrorString(this.NX.getErrorString());
                                hVar.b(this.aiT);
                                hVar.aB(false);
                                return hVar;
                            }
                        }
                        xD = i + 1;
                    } else {
                        randomAccessFile.close();
                        break;
                    }
                }
            }
            hVar.aB(true);
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
        this.aiS.add(new b(str, String.valueOf(i)));
    }
}
