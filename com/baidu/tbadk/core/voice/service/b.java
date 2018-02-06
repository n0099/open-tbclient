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
    private a bgh;
    private j bgi;
    private String bgj;
    private String bgk;
    private List<C0099b> bgl = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.bgj = str;
        this.bgk = str2;
    }

    public j fd(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bgj);
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
        this.bgh = new a(str, dx, TbConfig.SERVER_ADDRESS + this.bgj, e);
        this.bgi = this.bgh.ET();
        if (this.bgi.isSuccess() && (a2 = a(e, dx)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dx.fg(audioInfoData.getVoiceId());
                this.bgi.b(dx);
            } else {
                this.bgi.setErrorCode(audioInfoData.getErrorCode());
                this.bgi.setErrorString(audioInfoData.getErrorUserMsg());
                this.bgi.bh(false);
            }
        }
        return this.bgi;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bgk);
        this.mNetwork.n("voice_md5", iVar.FJ());
        if (v.D(this.bgl) != 0) {
            for (C0099b c0099b : this.bgl) {
                if (c0099b != null) {
                    this.mNetwork.n(c0099b.getKey(), c0099b.getValue());
                }
            }
        }
        String Cb = this.mNetwork.Cb();
        if (Cb == null || !this.mNetwork.Cz().Dx().isRequestSuccess()) {
            iVar.gP((int) X(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.bgi.setErrorCode(this.mNetwork.CD());
            this.bgi.setErrorString(this.mNetwork.getErrorString());
            this.bgi.bh(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dw(str);
        return Cb;
    }

    private long X(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i bgm;
        private boolean bgn = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.bgm = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.bgm = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j ET() throws IOException {
            j jVar = new j();
            long totalLength = this.bgm.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int FK = this.bgm.FK();
            if (FK < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(FK * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= FK * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = FK;
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
                                this.mNetWork.n("chunk_md5", this.bgm.FJ());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n(WBPageConstants.ParamKey.OFFSET, String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.bgn) {
                                    z = true;
                                } else if (this.mNetWork.Ce() == null || !this.mNetWork.Cz().Dx().isRequestSuccess()) {
                                    this.bgm.gP(i);
                                    com.baidu.tbadk.core.util.c.a(this.bgm);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.CD());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.bgm);
                                    jVar.bh(false);
                                    return jVar;
                                }
                            }
                            FK = i + 1;
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
    public class C0099b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0099b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.bgl.add(new C0099b(str, String.valueOf(i)));
    }
}
