package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a azK;
    private j azL;
    private String azM;
    private String azN;
    private List<C0106b> azO = new ArrayList();
    private y mNetwork;

    public b(String str, String str2) {
        this.azM = str;
        this.azN = str2;
    }

    public j ft(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.azM);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private j b(String str, File file) throws IOException {
        String a2;
        String g = s.g(l.q(file));
        if (g != null && g.length() > 0) {
            g = g.toLowerCase();
        }
        i dP = com.baidu.tbadk.core.util.c.dP(g);
        if (dP == null) {
            dP = new i();
            dP.fw(g);
            dP.dQ(0);
            dP.T(file.length());
        }
        this.azK = new a(str, dP, TbConfig.SERVER_ADDRESS + this.azM, g);
        this.azL = this.azK.Bg();
        if (this.azL.isSuccess() && (a2 = a(g, dP)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dP.fw(audioInfoData.getVoiceId());
                this.azL.b(dP);
            } else {
                this.azL.setErrorCode(audioInfoData.getErrorCode());
                this.azL.setErrorString(audioInfoData.getErrorUserMsg());
                this.azL.aD(false);
            }
        }
        return this.azL;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new y(TbConfig.SERVER_ADDRESS + this.azN);
        this.mNetwork.o("voice_md5", iVar.BV());
        if (w.y(this.azO) != 0) {
            for (C0106b c0106b : this.azO) {
                if (c0106b != null) {
                    this.mNetwork.o(c0106b.getKey(), c0106b.getValue());
                }
            }
        }
        String yl = this.mNetwork.yl();
        if (yl == null || !this.mNetwork.yJ().zJ().isRequestSuccess()) {
            iVar.dQ((int) S(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.azL.setErrorCode(this.mNetwork.yN());
            this.azL.setErrorString(this.mNetwork.getErrorString());
            this.azL.aD(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dO(str);
        return yl;
    }

    private long S(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i azP;
        private boolean azQ = false;
        private String mFileName;
        private y mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.azP = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.azP = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j Bg() throws IOException {
            j jVar = new j();
            long totalLength = this.azP.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int BW = this.azP.BW();
            if (BW < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(BW * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= BW * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = BW;
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
                                this.mNetWork.o("chunk_md5", this.azP.BV());
                                this.mNetWork.o("length", String.valueOf(read));
                                this.mNetWork.o(WBPageConstants.ParamKey.OFFSET, String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.o("total_length", String.valueOf(totalLength));
                                this.mNetWork.o("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.o("total_num", String.valueOf(j));
                                this.mNetWork.o("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.azQ) {
                                    z = true;
                                } else if (this.mNetWork.yo() == null || !this.mNetWork.yJ().zJ().isRequestSuccess()) {
                                    this.azP.dQ(i);
                                    com.baidu.tbadk.core.util.c.a(this.azP);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.yN());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.azP);
                                    jVar.aD(false);
                                    return jVar;
                                }
                            }
                            BW = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.aD(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.aD(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0106b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0106b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.azO.add(new C0106b(str, String.valueOf(i)));
    }
}
