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
    private String bVA;
    private List<C0229b> bVB = new ArrayList();
    private a bVx;
    private l bVy;
    private String bVz;
    private x mNetwork;

    public b(String str, String str2) {
        this.bVz = str;
        this.bVA = str2;
    }

    public l ny(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bVz);
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
        k lL = com.baidu.tbadk.core.util.c.lL(j);
        if (lL == null) {
            lL = new k();
            lL.nC(j);
            lL.ix(0);
            lL.aO(file.length());
        }
        this.bVx = new a(str, lL, TbConfig.SERVER_ADDRESS + this.bVz, j);
        this.bVy = this.bVx.afA();
        if (this.bVy.isSuccess() && (a2 = a(j, lL)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                lL.nC(audioInfoData.getVoiceId());
                this.bVy.b(lL);
            } else {
                this.bVy.setErrorCode(audioInfoData.getErrorCode());
                this.bVy.setErrorString(audioInfoData.getErrorUserMsg());
                this.bVy.dy(false);
            }
        }
        return this.bVy;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bVA);
        this.mNetwork.x("voice_md5", kVar.agn());
        if (v.S(this.bVB) != 0) {
            for (C0229b c0229b : this.bVB) {
                if (c0229b != null) {
                    this.mNetwork.x(c0229b.getKey(), c0229b.getValue());
                }
            }
        }
        String acj = this.mNetwork.acj();
        if (acj == null || !this.mNetwork.acH().adG().isRequestSuccess()) {
            kVar.ix((int) aN(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.bVy.setErrorCode(this.mNetwork.acL());
            this.bVy.setErrorString(this.mNetwork.getErrorString());
            this.bVy.dy(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.lK(str);
        return acj;
    }

    private long aN(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k bVC;
        private boolean bVD = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.bVC = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.bVC = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l afA() throws IOException {
            l lVar = new l();
            long totalLength = this.bVC.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int ago = this.bVC.ago();
            if (ago < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(ago * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= ago * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = ago;
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
                                this.mNetWork.x("chunk_md5", this.bVC.agn());
                                this.mNetWork.x("length", String.valueOf(read));
                                this.mNetWork.x("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.x("total_length", String.valueOf(totalLength));
                                this.mNetWork.x("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.x("total_num", String.valueOf(j));
                                this.mNetWork.x("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.bVD) {
                                    z = true;
                                } else if (this.mNetWork.acm() == null || !this.mNetWork.acH().adG().isRequestSuccess()) {
                                    this.bVC.ix(i);
                                    com.baidu.tbadk.core.util.c.a(this.bVC);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.acL());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.bVC);
                                    lVar.dy(false);
                                    return lVar;
                                }
                            }
                            ago = i + 1;
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
        this.bVB.add(new C0229b(str, String.valueOf(i)));
    }
}
