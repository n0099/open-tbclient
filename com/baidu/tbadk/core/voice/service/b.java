package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a apW;
    private i apX;
    private String apY;
    private String apZ;
    private List<C0049b> aqa = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.apY = str;
        this.apZ = str2;
    }

    public i eD(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apY);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private i c(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.q(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        h df = com.baidu.tbadk.core.util.c.df(e);
        if (df == null) {
            df = new h();
            df.eG(e);
            df.dS(0);
            df.Q(file.length());
        }
        this.apW = new a(str, df, TbConfig.SERVER_ADDRESS + this.apY, e);
        this.apX = this.apW.xh();
        if (this.apX.isSuccess() && (a2 = a(e, df)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                df.eG(audioInfoData.getVoiceId());
                this.apX.b(df);
            } else {
                this.apX.setErrorCode(audioInfoData.getErrorCode());
                this.apX.setErrorString(audioInfoData.getErrorUserMsg());
                this.apX.av(false);
            }
        }
        return this.apX;
    }

    private String a(String str, h hVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.apZ);
        this.mNetwork.n("voice_md5", hVar.xU());
        if (v.v(this.aqa) != 0) {
            for (C0049b c0049b : this.aqa) {
                if (c0049b != null) {
                    this.mNetwork.n(c0049b.getKey(), c0049b.getValue());
                }
            }
        }
        String us = this.mNetwork.us();
        if (us == null || !this.mNetwork.uQ().vO().isRequestSuccess()) {
            hVar.dS((int) P(hVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(hVar);
            this.apX.setErrorCode(this.mNetwork.uU());
            this.apX.setErrorString(this.mNetwork.getErrorString());
            this.apX.av(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.de(str);
        return us;
    }

    private long P(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private h aqb;
        private boolean aqc = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, h hVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aqb = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aqb = hVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public i xh() throws IOException {
            i iVar = new i();
            long totalLength = this.aqb.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int xV = this.aqb.xV();
            if (xV < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(xV * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= xV * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = xV;
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
                                this.mNetWork.n("chunk_md5", this.aqb.xU());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aqc) {
                                    z = true;
                                } else if (this.mNetWork.uv() == null || !this.mNetWork.uQ().vO().isRequestSuccess()) {
                                    this.aqb.dS(i);
                                    com.baidu.tbadk.core.util.c.a(this.aqb);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    iVar.setErrorCode(this.mNetWork.uU());
                                    iVar.setErrorString(this.mNetWork.getErrorString());
                                    iVar.b(this.aqb);
                                    iVar.av(false);
                                    return iVar;
                                }
                            }
                            xV = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    iVar.av(false);
                    randomAccessFile.close();
                    return iVar;
                }
            }
            iVar.av(true);
            return iVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0049b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0049b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.aqa.add(new C0049b(str, String.valueOf(i)));
    }
}
