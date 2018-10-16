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
    private a aIc;
    private k aId;
    private String aIe;
    private String aIf;
    private List<C0127b> aIg = new ArrayList();
    private x mNetwork;

    public b(String str, String str2) {
        this.aIe = str;
        this.aIf = str2;
    }

    public k ge(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aIe);
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
        j ex = com.baidu.tbadk.core.util.c.ex(i);
        if (ex == null) {
            ex = new j();
            ex.gi(i);
            ex.eo(0);
            ex.ac(file.length());
        }
        this.aIc = new a(str, ex, TbConfig.SERVER_ADDRESS + this.aIe, i);
        this.aId = this.aIc.ED();
        if (this.aId.isSuccess() && (a2 = a(i, ex)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                ex.gi(audioInfoData.getVoiceId());
                this.aId.b(ex);
            } else {
                this.aId.setErrorCode(audioInfoData.getErrorCode());
                this.aId.setErrorString(audioInfoData.getErrorUserMsg());
                this.aId.aX(false);
            }
        }
        return this.aId;
    }

    private String a(String str, j jVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.aIf);
        this.mNetwork.x("voice_md5", jVar.Fq());
        if (v.I(this.aIg) != 0) {
            for (C0127b c0127b : this.aIg) {
                if (c0127b != null) {
                    this.mNetwork.x(c0127b.getKey(), c0127b.getValue());
                }
            }
        }
        String BA = this.mNetwork.BA();
        if (BA == null || !this.mNetwork.BY().CX().isRequestSuccess()) {
            jVar.eo((int) ab(jVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(jVar);
            this.aId.setErrorCode(this.mNetwork.Cc());
            this.aId.setErrorString(this.mNetwork.getErrorString());
            this.aId.aX(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.ew(str);
        return BA;
    }

    private long ab(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private j aIh;
        private boolean aIi = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, j jVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.aIh = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.aIh = jVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public k ED() throws IOException {
            k kVar = new k();
            long totalLength = this.aIh.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int Fr = this.aIh.Fr();
            if (Fr < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(Fr * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= Fr * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = Fr;
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
                                this.mNetWork.x("chunk_md5", this.aIh.Fq());
                                this.mNetWork.x("length", String.valueOf(read));
                                this.mNetWork.x("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.x("total_length", String.valueOf(totalLength));
                                this.mNetWork.x("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.x("total_num", String.valueOf(j));
                                this.mNetWork.x("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.aIi) {
                                    z = true;
                                } else if (this.mNetWork.BD() == null || !this.mNetWork.BY().CX().isRequestSuccess()) {
                                    this.aIh.eo(i);
                                    com.baidu.tbadk.core.util.c.a(this.aIh);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    kVar.setErrorCode(this.mNetWork.Cc());
                                    kVar.setErrorString(this.mNetWork.getErrorString());
                                    kVar.b(this.aIh);
                                    kVar.aX(false);
                                    return kVar;
                                }
                            }
                            Fr = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    kVar.aX(false);
                    randomAccessFile.close();
                    return kVar;
                }
            }
            kVar.aX(true);
            return kVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0127b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0127b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void D(String str, int i) {
        this.aIg.add(new C0127b(str, String.valueOf(i)));
    }
}
