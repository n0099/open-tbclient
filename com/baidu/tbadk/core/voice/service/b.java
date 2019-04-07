package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.m;
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
    private l bVA;
    private String bVB;
    private String bVC;
    private List<C0229b> bVD = new ArrayList();
    private a bVz;
    private x mNetwork;

    public b(String str, String str2) {
        this.bVB = str;
        this.bVC = str2;
    }

    public l nz(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bVB);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l c(String str, File file) throws IOException {
        String a2;
        String j = s.j(m.F(file));
        if (j != null && j.length() > 0) {
            j = j.toLowerCase();
        }
        k lM = com.baidu.tbadk.core.util.c.lM(j);
        if (lM == null) {
            lM = new k();
            lM.nD(j);
            lM.iw(0);
            lM.aO(file.length());
        }
        this.bVz = new a(str, lM, TbConfig.SERVER_ADDRESS + this.bVB, j);
        this.bVA = this.bVz.afx();
        if (this.bVA.isSuccess() && (a2 = a(j, lM)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                lM.nD(audioInfoData.getVoiceId());
                this.bVA.b(lM);
            } else {
                this.bVA.setErrorCode(audioInfoData.getErrorCode());
                this.bVA.setErrorString(audioInfoData.getErrorUserMsg());
                this.bVA.dy(false);
            }
        }
        return this.bVA;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bVC);
        this.mNetwork.x("voice_md5", kVar.agk());
        if (v.S(this.bVD) != 0) {
            for (C0229b c0229b : this.bVD) {
                if (c0229b != null) {
                    this.mNetwork.x(c0229b.getKey(), c0229b.getValue());
                }
            }
        }
        String acg = this.mNetwork.acg();
        if (acg == null || !this.mNetwork.acE().adD().isRequestSuccess()) {
            kVar.iw((int) aN(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.bVA.setErrorCode(this.mNetwork.acI());
            this.bVA.setErrorString(this.mNetwork.getErrorString());
            this.bVA.dy(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.lL(str);
        return acg;
    }

    private long aN(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k bVE;
        private boolean bVF = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.bVE = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.bVE = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l afx() throws IOException {
            l lVar = new l();
            long totalLength = this.bVE.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int agl = this.bVE.agl();
            if (agl < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(agl * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= agl * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = agl;
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
                                this.mNetWork.x("chunk_md5", this.bVE.agk());
                                this.mNetWork.x("length", String.valueOf(read));
                                this.mNetWork.x("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.x("total_length", String.valueOf(totalLength));
                                this.mNetWork.x("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.x("total_num", String.valueOf(j));
                                this.mNetWork.x("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.bVF) {
                                    z = true;
                                } else if (this.mNetWork.acj() == null || !this.mNetWork.acE().adD().isRequestSuccess()) {
                                    this.bVE.iw(i);
                                    com.baidu.tbadk.core.util.c.a(this.bVE);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.acI());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.bVE);
                                    lVar.dy(false);
                                    return lVar;
                                }
                            }
                            agl = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.dy(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.dy(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0229b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0229b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.bVD.add(new C0229b(str, String.valueOf(i)));
    }
}
