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
    private a bea;
    private j beb;
    private String bec;
    private String bed;
    private List<C0076b> bee = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.bec = str;
        this.bed = str2;
    }

    public j eK(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bec);
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
            dm.eN(e);
            dm.gQ(0);
            dm.Y(file.length());
        }
        this.bea = new a(str, dm, TbConfig.SERVER_ADDRESS + this.bec, e);
        this.beb = this.bea.EF();
        if (this.beb.isSuccess() && (a2 = a(e, dm)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                dm.eN(audioInfoData.getVoiceId());
                this.beb.b(dm);
            } else {
                this.beb.setErrorCode(audioInfoData.getErrorCode());
                this.beb.setErrorString(audioInfoData.getErrorUserMsg());
                this.beb.bd(false);
            }
        }
        return this.beb;
    }

    private String a(String str, i iVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.bed);
        this.mNetwork.n("voice_md5", iVar.Fu());
        if (v.F(this.bee) != 0) {
            for (C0076b c0076b : this.bee) {
                if (c0076b != null) {
                    this.mNetwork.n(c0076b.getKey(), c0076b.getValue());
                }
            }
        }
        String BP = this.mNetwork.BP();
        if (BP == null || !this.mNetwork.Cn().Dl().isRequestSuccess()) {
            iVar.gQ((int) X(iVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(iVar);
            this.beb.setErrorCode(this.mNetwork.Cr());
            this.beb.setErrorString(this.mNetwork.getErrorString());
            this.beb.bd(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.dl(str);
        return BP;
    }

    private long X(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private i bef;
        private boolean beg = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, i iVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.bef = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.bef = iVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public j EF() throws IOException {
            j jVar = new j();
            long totalLength = this.bef.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int Fv = this.bef.Fv();
            if (Fv < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(Fv * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= Fv * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = Fv;
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
                                this.mNetWork.n("chunk_md5", this.bef.Fu());
                                this.mNetWork.n("length", String.valueOf(read));
                                this.mNetWork.n("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.n("total_length", String.valueOf(totalLength));
                                this.mNetWork.n("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.n("total_num", String.valueOf(j));
                                this.mNetWork.n("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.beg) {
                                    z = true;
                                } else if (this.mNetWork.BS() == null || !this.mNetWork.Cn().Dl().isRequestSuccess()) {
                                    this.bef.gQ(i);
                                    com.baidu.tbadk.core.util.c.a(this.bef);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    jVar.setErrorCode(this.mNetWork.Cr());
                                    jVar.setErrorString(this.mNetWork.getErrorString());
                                    jVar.b(this.bef);
                                    jVar.bd(false);
                                    return jVar;
                                }
                            }
                            Fv = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    jVar.bd(false);
                    randomAccessFile.close();
                    return jVar;
                }
            }
            jVar.bd(true);
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
        this.bee.add(new C0076b(str, String.valueOf(i)));
    }
}
