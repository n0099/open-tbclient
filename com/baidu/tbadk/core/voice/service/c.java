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
    private ab aiu;
    private a aiv;
    private com.baidu.tbadk.coreExtra.data.h aiw;
    private String aix;
    private String aiy;
    private List<b> aiz = new ArrayList();

    public c(String str, String str2) {
        this.aix = str;
        this.aiy = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h ee(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aiu = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aix);
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
        com.baidu.tbadk.coreExtra.data.g cS = com.baidu.tbadk.core.util.d.cS(k);
        if (cS == null) {
            cS = new com.baidu.tbadk.coreExtra.data.g();
            cS.setMd5(k);
            cS.dy(0);
            cS.O(file.length());
        }
        this.aiv = new a(str, cS, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aix, k);
        this.aiw = this.aiv.xj();
        if (this.aiw.isSuccess() && (a2 = a(k, cS)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cS.setMd5(audioInfoData.getVoiceId());
                this.aiw.b(cS);
            } else {
                this.aiw.setErrorCode(audioInfoData.getErrorCode());
                this.aiw.setErrorString(audioInfoData.getErrorUserMsg());
                this.aiw.ax(false);
            }
        }
        return this.aiw;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.aiu = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aiy);
        this.aiu.n("voice_md5", gVar.getMd5());
        if (y.s(this.aiz) != 0) {
            for (b bVar : this.aiz) {
                if (bVar != null) {
                    this.aiu.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String uu = this.aiu.uu();
        if (uu == null || !this.aiu.uS().vO().oF()) {
            gVar.dy((int) N(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.d.a(gVar);
            this.aiw.setErrorCode(this.aiu.uW());
            this.aiw.setErrorString(this.aiu.getErrorString());
            this.aiw.ax(false);
            return null;
        }
        com.baidu.tbadk.core.util.d.cR(str);
        return uu;
    }

    private long N(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private ab NY;
        private com.baidu.tbadk.coreExtra.data.g aiA;
        private boolean aiB = false;
        private String mFileName;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aiA = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aiA = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h xj() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.aiA.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xJ = this.aiA.xJ();
            if (xJ < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xJ * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xJ * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.ax(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xJ;
                    if (i < j) {
                        int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                        if (i == j - 1) {
                            i2 = (int) (totalLength - (30720 * (j - 1)));
                        }
                        byte[] bArr = new byte[i2];
                        int read = randomAccessFile.read(bArr, 0, i2);
                        if (read != -1) {
                            this.NY = new ab(this.mUrl);
                            this.NY.d("voice_chunk", bArr);
                            this.NY.n("chunk_md5", this.aiA.getMd5());
                            this.NY.n("length", String.valueOf(read));
                            this.NY.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.NY.n("total_length", String.valueOf(totalLength));
                            this.NY.n("chunk_no", String.valueOf(i + 1));
                            this.NY.n("total_num", String.valueOf(j));
                            this.NY.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aiB) {
                                z = true;
                            } else if (this.NY.ux() == null || !this.NY.uS().vO().oF()) {
                                this.aiA.dy(i);
                                com.baidu.tbadk.core.util.d.a(this.aiA);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.NY.uW());
                                hVar.setErrorString(this.NY.getErrorString());
                                hVar.b(this.aiA);
                                hVar.ax(false);
                                return hVar;
                            }
                        }
                        xJ = i + 1;
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

    public void u(String str, int i) {
        this.aiz.add(new b(str, String.valueOf(i)));
    }
}
