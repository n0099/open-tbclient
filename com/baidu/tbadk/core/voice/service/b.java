package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private String aDA;
    private List<C0103b> aDB = new ArrayList();
    private a aDx;
    private k aDy;
    private String aDz;
    private x mNetwork;

    public b(String str, String str2) {
        this.aDz = str;
        this.aDA = str2;
    }

    public k fQ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aDz);
            return b(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private k b(String str, File file) throws IOException {
        String a2;
        String i = s.i(l.w(file));
        if (i != null && i.length() > 0) {
            i = i.toLowerCase();
        }
        j eh = com.baidu.tbadk.core.util.c.eh(i);
        if (eh == null) {
            eh = new j();
            eh.fU(i);
            eh.ef(0);
            eh.aa(file.length());
        }
        this.aDx = new a(str, eh, TbConfig.SERVER_ADDRESS + this.aDz, i);
        this.aDy = this.aDx.Cz();
        if (this.aDy.isSuccess() && (a2 = a(i, eh)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                eh.fU(audioInfoData.getVoiceId());
                this.aDy.b(eh);
            } else {
                this.aDy.setErrorCode(audioInfoData.getErrorCode());
                this.aDy.setErrorString(audioInfoData.getErrorUserMsg());
                this.aDy.aN(false);
            }
        }
        return this.aDy;
    }

    private String a(String str, j jVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aDA);
        this.mNetwork.u("voice_md5", jVar.Dp());
        if (v.y(this.aDB) != 0) {
            for (C0103b c0103b : this.aDB) {
                if (c0103b != null) {
                    this.mNetwork.u(c0103b.getKey(), c0103b.getValue());
                }
            }
        }
        String zt = this.mNetwork.zt();
        if (zt == null || !this.mNetwork.zR().AQ().isRequestSuccess()) {
            jVar.ef((int) Z(jVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(jVar);
            this.aDy.setErrorCode(this.mNetwork.zV());
            this.aDy.setErrorString(this.mNetwork.getErrorString());
            this.aDy.aN(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.eg(str);
        return zt;
    }

    private long Z(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private j aDC;
        private boolean aDD = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, j jVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aDC = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aDC = jVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public k Cz() throws IOException {
            k kVar = new k();
            long totalLength = this.aDC.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int Dq = this.aDC.Dq();
            if (Dq < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(Dq * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= Dq * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = Dq;
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
                                this.mNetWork.u("chunk_md5", this.aDC.Dp());
                                this.mNetWork.u("length", String.valueOf(read));
                                this.mNetWork.u("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.u("total_length", String.valueOf(totalLength));
                                this.mNetWork.u("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.u("total_num", String.valueOf(j));
                                this.mNetWork.u("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aDD) {
                                    z = true;
                                } else if (this.mNetWork.zw() == null || !this.mNetWork.zR().AQ().isRequestSuccess()) {
                                    this.aDC.ef(i);
                                    com.baidu.tbadk.core.util.c.a(this.aDC);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    kVar.setErrorCode(this.mNetWork.zV());
                                    kVar.setErrorString(this.mNetWork.getErrorString());
                                    kVar.b(this.aDC);
                                    kVar.aN(false);
                                    return kVar;
                                }
                            }
                            Dq = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    kVar.aN(false);
                    randomAccessFile.close();
                    return kVar;
                }
            }
            kVar.aN(true);
            return kVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0103b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0103b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void C(String str, int i) {
        this.aDB.add(new C0103b(str, String.valueOf(i)));
    }
}
