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
    private l cfA;
    private String cfB;
    private String cfC;
    private List<C0254b> cfD = new ArrayList();
    private a cfz;
    private x mNetwork;

    public b(String str, String str2) {
        this.cfB = str;
        this.cfC = str2;
    }

    public l ph(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.cfB);
            return c(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private l c(String str, File file) throws IOException {
        String a2;
        String h = s.h(m.z(file));
        if (h != null && h.length() > 0) {
            h = h.toLowerCase();
        }
        k nh = com.baidu.tbadk.core.util.c.nh(h);
        if (nh == null) {
            nh = new k();
            nh.pl(h);
            nh.ju(0);
            nh.bh(file.length());
        }
        this.cfz = new a(str, nh, TbConfig.SERVER_ADDRESS + this.cfB, h);
        this.cfA = this.cfz.alP();
        if (this.cfA.isSuccess() && (a2 = a(h, nh)) != null && !a2.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a2);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                nh.pl(audioInfoData.getVoiceId());
                this.cfA.b(nh);
            } else {
                this.cfA.setErrorCode(audioInfoData.getErrorCode());
                this.cfA.setErrorString(audioInfoData.getErrorUserMsg());
                this.cfA.dY(false);
            }
        }
        return this.cfA;
    }

    private String a(String str, k kVar) {
        this.mNetwork = new x(TbConfig.SERVER_ADDRESS + this.cfC);
        this.mNetwork.o("voice_md5", kVar.amC());
        if (v.Z(this.cfD) != 0) {
            for (C0254b c0254b : this.cfD) {
                if (c0254b != null) {
                    this.mNetwork.o(c0254b.getKey(), c0254b.getValue());
                }
            }
        }
        String aim = this.mNetwork.aim();
        if (aim == null || !this.mNetwork.aiK().ajN().isRequestSuccess()) {
            kVar.ju((int) bg(kVar.getTotalLength()));
            com.baidu.tbadk.core.util.c.a(kVar);
            this.cfA.setErrorCode(this.mNetwork.aiO());
            this.cfA.setErrorString(this.mNetwork.getErrorString());
            this.cfA.dY(false);
            return null;
        }
        com.baidu.tbadk.core.util.c.ng(str);
        return aim;
    }

    private long bg(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private k cfE;
        private boolean cfF = false;
        private String mFileName;
        private x mNetWork;
        private String mUrl;
        private String mVoiceMd5;

        public a(String str, k kVar, String str2, String str3) {
            this.mFileName = null;
            this.mUrl = null;
            this.cfE = null;
            this.mVoiceMd5 = null;
            this.mFileName = str;
            this.cfE = kVar;
            this.mUrl = str2;
            this.mVoiceMd5 = str3;
        }

        public l alP() throws IOException {
            l lVar = new l();
            long totalLength = this.cfE.getTotalLength();
            long j = totalLength % 30720 == 0 ? totalLength / 30720 : (totalLength / 30720) + 1;
            int amD = this.cfE.amD();
            if (amD < j) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.mFileName), "r");
                if (randomAccessFile.skipBytes(amD * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) >= amD * TbConfig.VOICE_CHUNK_UPLOAD_SIZE) {
                    while (true) {
                        int i = amD;
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
                                this.mNetWork.o("chunk_md5", this.cfE.amC());
                                this.mNetWork.o("length", String.valueOf(read));
                                this.mNetWork.o("offset", String.valueOf(i * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                this.mNetWork.o("total_length", String.valueOf(totalLength));
                                this.mNetWork.o("chunk_no", String.valueOf(i + 1));
                                this.mNetWork.o("total_num", String.valueOf(j));
                                this.mNetWork.o("voice_md5", this.mVoiceMd5);
                                boolean z = false;
                                if (this.cfF) {
                                    z = true;
                                } else if (this.mNetWork.aip() == null || !this.mNetWork.aiK().ajN().isRequestSuccess()) {
                                    this.cfE.ju(i);
                                    com.baidu.tbadk.core.util.c.a(this.cfE);
                                    randomAccessFile.close();
                                    z = true;
                                }
                                if (z) {
                                    lVar.setErrorCode(this.mNetWork.aiO());
                                    lVar.setErrorString(this.mNetWork.getErrorString());
                                    lVar.b(this.cfE);
                                    lVar.dY(false);
                                    return lVar;
                                }
                            }
                            amD = i + 1;
                        } else {
                            randomAccessFile.close();
                            break;
                        }
                    }
                } else {
                    lVar.dY(false);
                    randomAccessFile.close();
                    return lVar;
                }
            }
            lVar.dY(true);
            return lVar;
        }
    }

    /* renamed from: com.baidu.tbadk.core.voice.service.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0254b {
        private String key;
        private String value;

        public String getValue() {
            return this.value;
        }

        public String getKey() {
            return this.key;
        }

        public C0254b(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public void addPostParam(String str, int i) {
        this.cfD.add(new C0254b(str, String.valueOf(i)));
    }
}
