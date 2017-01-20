package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private a ahZ;
    private com.baidu.tbadk.coreExtra.data.h aia;
    private String aib;
    private String aic;
    private List<b> aid = new ArrayList();
    private y mNetwork;

    public c(String str, String str2) {
        this.aib = str;
        this.aic = str2;
    }

    public com.baidu.tbadk.coreExtra.data.h eb(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aib);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.h b(String str, File file) throws IOException {
        String a2;
        String k = t.k(l.n(file));
        if (k != null && k.length() > 0) {
            k = k.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.g cT = com.baidu.tbadk.core.util.c.cT(k);
        if (cT == null) {
            cT = new com.baidu.tbadk.coreExtra.data.g();
            cT.setMd5(k);
            cT.dD(0);
            cT.L(file.length());
        }
        this.ahZ = new a(str, cT, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aib, k);
        this.aia = this.ahZ.wV();
        if (this.aia.isSuccess() && (a2 = a(k, cT)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cT.setMd5(audioInfoData.getVoiceId());
                this.aia.b(cT);
            } else {
                this.aia.setErrorCode(audioInfoData.getErrorCode());
                this.aia.setErrorString(audioInfoData.getErrorUserMsg());
                this.aia.aB(false);
            }
        }
        return this.aia;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.g gVar) {
        this.mNetwork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aic);
        this.mNetwork.n("voice_md5", gVar.getMd5());
        if (w.r(this.aid) != 0) {
            for (b bVar : this.aid) {
                if (bVar != null) {
                    this.mNetwork.n(bVar.getKey(), bVar.getValue());
                }
            }
        }
        String ud = this.mNetwork.ud();
        if (ud == null || !this.mNetwork.uC().vw().isRequestSuccess()) {
            gVar.dD((int) K(gVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(gVar);
            this.aia.setErrorCode(this.mNetwork.uG());
            this.aia.setErrorString(this.mNetwork.getErrorString());
            this.aia.aB(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.cS(str);
        return ud;
    }

    private long K(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private com.baidu.tbadk.coreExtra.data.g aie;
        private boolean aif = false;
        private String mFileName;
        private y mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, com.baidu.tbadk.coreExtra.data.g gVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aie = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aie = gVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public com.baidu.tbadk.coreExtra.data.h wV() throws IOException {
            com.baidu.tbadk.coreExtra.data.h hVar = new com.baidu.tbadk.coreExtra.data.h();
            long totalLength = this.aie.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xz = this.aie.xz();
            if (xz < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xz * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) < xz * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    hVar.aB(false);
                    randomAccessFile.close();
                    return hVar;
                }
                while (true) {
                    int i = xz;
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
                            this.mNetWork.n("chunk_md5", this.aie.getMd5());
                            this.mNetWork.n("length", String.valueOf(read));
                            this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                            this.mNetWork.n("total_length", String.valueOf(totalLength));
                            this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                            this.mNetWork.n("total_num", String.valueOf(j));
                            this.mNetWork.n("voice_md5", this.mVoiceMd5);
                            boolean z = false;
                            if (this.aif) {
                                z = true;
                            } else if (this.mNetWork.ug() == null || !this.mNetWork.uC().vw().isRequestSuccess()) {
                                this.aie.dD(i);
                                com.baidu.tbadk.core.util.c.a(this.aie);
                                randomAccessFile.close();
                                z = true;
                            }
                            if (z) {
                                hVar.setErrorCode(this.mNetWork.uG());
                                hVar.setErrorString(this.mNetWork.getErrorString());
                                hVar.b(this.aie);
                                hVar.aB(false);
                                return hVar;
                            }
                        }
                        xz = i + 1;
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
        this.aid.add(new b(str, String.valueOf(i)));
    }
}
