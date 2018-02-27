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
    private a bfV;
    private j bfW;
    private String bfX;
    private String bfY;
    private List<C0100b> bfZ = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.bfX = str;
        this.bfY = str2;
    }

    public j fd(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bfX);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private j b(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.r(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        i dx = com.baidu.tbadk.core.util.c.dx(e);
        if (dx == null) {
            dx = new i();
            dx.fg(e);
            dx.gP(0);
            dx.Y(file.length());
        }
        this.bfV = new a(str, dx, TbConfig.SERVER_ADDRESS + this.bfX, e);
        this.bfW = this.bfV.ES();
        if (this.bfW.isSuccess() && (a2 = a(e, dx)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dx.fg(audioInfoData.getVoiceId());
                this.bfW.b(dx);
            } else {
                this.bfW.setErrorCode(audioInfoData.getErrorCode());
                this.bfW.setErrorString(audioInfoData.getErrorUserMsg());
                this.bfW.bh(false);
            }
        }
        return this.bfW;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bfY);
        this.mNetwork.n("voice_md5", iVar.FI());
        if (v.D(this.bfZ) != 0) {
            for (C0100b c0100b : this.bfZ) {
                if (c0100b != null) {
                    this.mNetwork.n(c0100b.getKey(), c0100b.getValue());
                }
            }
        }
        String Ca = this.mNetwork.Ca();
        if (Ca == null || !this.mNetwork.Cy().Dw().isRequestSuccess()) {
            iVar.gP((int) X(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.bfW.setErrorCode(this.mNetwork.CC());
            this.bfW.setErrorString(this.mNetwork.getErrorString());
            this.bfW.bh(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dw(str);
        return Ca;
    }

    private long X(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i bga;
        private boolean bgb = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.bga = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.bga = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j ES() throws IOException {
            j jVar = new j();
            long totalLength = this.bga.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int FJ = this.bga.FJ();
            if (FJ < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(FJ * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= FJ * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = FJ;
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
                                this.mNetWork.n("chunk_md5", this.bga.FI());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.bgb) {
                                    z = true;
                                } else if (this.mNetWork.Cd() == null || !this.mNetWork.Cy().Dw().isRequestSuccess()) {
                                    this.bga.gP(i);
                                    com.baidu.tbadk.core.util.c.a(this.bga);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.CC());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.bga);
                                    jVar.bh(false);
                                    return jVar;
                                }
                            }
                            FJ = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.bh(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.bh(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0100b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0100b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.bfZ.add(new C0100b(str, String.valueOf(i)));
    }
}
