package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
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
    private a arF;
    private j arG;
    private String arH;
    private String arI;
    private List<C0089b> arJ = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.arH = str;
        this.arI = str2;
    }

    public j eV(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.arH);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private j b(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.q(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        i dp = com.baidu.tbadk.core.util.c.dp(e);
        if (dp == null) {
            dp = new i();
            dp.eY(e);
            dp.dN(0);
            dp.Q(file.length());
        }
        this.arF = new a(str, dp, TbConfig.SERVER_ADDRESS + this.arH, e);
        this.arG = this.arF.xG();
        if (this.arG.isSuccess() && (a2 = a(e, dp)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dp.eY(audioInfoData.getVoiceId());
                this.arG.b(dp);
            } else {
                this.arG.setErrorCode(audioInfoData.getErrorCode());
                this.arG.setErrorString(audioInfoData.getErrorUserMsg());
                this.arG.az(false);
            }
        }
        return this.arG;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.arI);
        this.mNetwork.n("voice_md5", iVar.yw());
        if (v.v(this.arJ) != 0) {
            for (C0089b c0089b : this.arJ) {
                if (c0089b != null) {
                    this.mNetwork.n(c0089b.getKey(), c0089b.getValue());
                }
            }
        }
        String uL = this.mNetwork.uL();
        if (uL == null || !this.mNetwork.vj().wj().isRequestSuccess()) {
            iVar.dN((int) P(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.arG.setErrorCode(this.mNetwork.vn());
            this.arG.setErrorString(this.mNetwork.getErrorString());
            this.arG.az(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.m14do(str);
        return uL;
    }

    private long P(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i arK;
        private boolean arL = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.arK = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.arK = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j xG() throws IOException {
            j jVar = new j();
            long totalLength = this.arK.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int yx = this.arK.yx();
            if (yx < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(yx * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= yx * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = yx;
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
                                this.mNetWork.n("chunk_md5", this.arK.yw());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.arL) {
                                    z = true;
                                } else if (this.mNetWork.uO() == null || !this.mNetWork.vj().wj().isRequestSuccess()) {
                                    this.arK.dN(i);
                                    com.baidu.tbadk.core.util.c.a(this.arK);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.vn());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.arK);
                                    jVar.az(false);
                                    return jVar;
                                }
                            }
                            yx = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.az(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.az(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0089b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0089b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.arJ.add(new C0089b(str, String.valueOf(i)));
    }
}
