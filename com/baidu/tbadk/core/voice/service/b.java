package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a aMW;
    private l aMX;
    private String aMY;
    private String aMZ;
    private List<C0161b> aNa = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.aMY = str;
        this.aMZ = str2;
    }

    public l gM(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aMY);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l b(String str, File file) throws IOException {
        String a2;
        String i = s.i(com.baidu.tbadk.core.util.l.x(file));
        if (i != null && i.length() > 0) {
            i = i.toLowerCase();
        }
        k eY = com.baidu.tbadk.core.util.c.eY(i);
        if (eY == null) {
            eY = new k();
            eY.gQ(i);
            eY.eR(0);
            eY.am(file.length());
        }
        this.aMW = new a(str, eY, TbConfig.SERVER_ADDRESS + this.aMY, i);
        this.aMX = this.aMW.Gg();
        if (this.aMX.isSuccess() && (a2 = a(i, eY)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                eY.gQ(audioInfoData.getVoiceId());
                this.aMX.b(eY);
            } else {
                this.aMX.setErrorCode(audioInfoData.getErrorCode());
                this.aMX.setErrorString(audioInfoData.getErrorUserMsg());
                this.aMX.bp(false);
            }
        }
        return this.aMX;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aMZ);
        this.mNetwork.x("voice_md5", kVar.GU());
        if (v.H(this.aNa) != 0) {
            for (C0161b c0161b : this.aNa) {
                if (c0161b != null) {
                    this.mNetwork.x(c0161b.getKey(), c0161b.getValue());
                }
            }
        }
        String CY = this.mNetwork.CY();
        if (CY == null || !this.mNetwork.Dw().Ev().isRequestSuccess()) {
            kVar.eR((int) al(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.aMX.setErrorCode(this.mNetwork.DA());
            this.aMX.setErrorString(this.mNetwork.getErrorString());
            this.aMX.bp(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.eX(str);
        return CY;
    }

    private long al(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k aNb;
        private boolean aNc = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aNb = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aNb = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l Gg() throws IOException {
            l lVar = new l();
            long totalLength = this.aNb.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int GV = this.aNb.GV();
            if (GV < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(GV * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= GV * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = GV;
                        if (i < j) {
                            int i2 = TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                            if (i == j - 1) {
                                i2 = (int) (totalLength - (30720 * (j - 1)));
                            }
                            byte[] bArr = new byte[i2];
                            int read = randomAccessFile.read(bArr, 0, i2);
                            if (read != -1) {
                                this.mNetWork = new x(this.mUrl);
                                this.mNetWork.d("voice_chunk", bArr);
                                this.mNetWork.x("chunk_md5", this.aNb.GU());
                                this.mNetWork.x("length", String.valueOf(read));
                                this.mNetWork.x("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.x("total_length", String.valueOf(totalLength));
                                this.mNetWork.x("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.x("total_num", String.valueOf(j));
                                this.mNetWork.x("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aNc) {
                                    z = true;
                                } else if (this.mNetWork.Db() == null || !this.mNetWork.Dw().Ev().isRequestSuccess()) {
                                    this.aNb.eR(i);
                                    com.baidu.tbadk.core.util.c.a(this.aNb);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.DA());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.aNb);
                                    lVar.bp(false);
                                    return lVar;
                                }
                            }
                            GV = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.bp(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.bp(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0161b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0161b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.aNa.add(new C0161b(str, String.valueOf(i)));
    }
}
