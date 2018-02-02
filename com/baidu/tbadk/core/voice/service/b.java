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
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private a beo;
    private j bep;
    private String beq;
    private String ber;
    private List<C0076b> bes = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.beq = str;
        this.ber = str2;
    }

    public j eS(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.beq);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private j c(String str, File file) throws IOException {
        String a2;
        String e = s.e(k.r(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        i dm = com.baidu.tbadk.core.util.c.dm(e);
        if (dm == null) {
            dm = new i();
            dm.eV(e);
            dm.gN(0);
            dm.Y(file.length());
        }
        this.beo = new a(str, dm, TbConfig.SERVER_ADDRESS + this.beq, e);
        this.bep = this.beo.Ey();
        if (this.bep.isSuccess() && (a2 = a(e, dm)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dm.eV(audioInfoData.getVoiceId());
                this.bep.b(dm);
            } else {
                this.bep.setErrorCode(audioInfoData.getErrorCode());
                this.bep.setErrorString(audioInfoData.getErrorUserMsg());
                this.bep.be(false);
            }
        }
        return this.bep;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.ber);
        this.mNetwork.n("voice_md5", iVar.Fn());
        if (v.D(this.bes) != 0) {
            for (C0076b c0076b : this.bes) {
                if (c0076b != null) {
                    this.mNetwork.n(c0076b.getKey(), c0076b.getValue());
                }
            }
        }
        String BI = this.mNetwork.BI();
        if (BI == null || !this.mNetwork.Cg().Dd().isRequestSuccess()) {
            iVar.gN((int) X(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.bep.setErrorCode(this.mNetwork.Ck());
            this.bep.setErrorString(this.mNetwork.getErrorString());
            this.bep.be(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dl(str);
        return BI;
    }

    private long X(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i beu;
        private boolean bev = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.beu = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.beu = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j Ey() throws IOException {
            j jVar = new j();
            long totalLength = this.beu.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int Fo = this.beu.Fo();
            if (Fo < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(Fo * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= Fo * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = Fo;
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
                                this.mNetWork.n("chunk_md5", this.beu.Fn());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.bev) {
                                    z = true;
                                } else if (this.mNetWork.BL() == null || !this.mNetWork.Cg().Dd().isRequestSuccess()) {
                                    this.beu.gN(i);
                                    com.baidu.tbadk.core.util.c.a(this.beu);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.Ck());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.beu);
                                    jVar.be(false);
                                    return jVar;
                                }
                            }
                            Fo = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.be(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.be(true);
            return jVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0076b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void x(String str, int i) {
        this.bes.add(new C0076b(str, String.valueOf(i)));
    }
}
