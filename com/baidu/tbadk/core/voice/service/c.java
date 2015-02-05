package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private ad CU;
    private d Ow;
    private com.baidu.tbadk.coreExtra.data.c Ox;
    private String Oy;
    private String Oz;

    public c(String str, String str2) {
        this.Oy = str;
        this.Oz = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c cW(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.CU = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.Oy);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c a(String str, File file) {
        String a;
        String e = z.e(s.l(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b ca = com.baidu.tbadk.core.util.i.ca(e);
        if (ca == null) {
            ca = new com.baidu.tbadk.coreExtra.data.b();
            ca.dc(e);
            ca.cz(0);
            ca.r(file.length());
        }
        this.Ow = new d(this, str, ca, String.valueOf(TbConfig.SERVER_ADDRESS) + this.Oy, e);
        this.Ox = this.Ow.qV();
        if (this.Ox.isSuccess() && (a = a(e, ca)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                ca.dc(audioInfoData.getVoiceId());
                this.Ox.b(ca);
            } else {
                this.Ox.setErrorCode(audioInfoData.getErrorCode());
                this.Ox.setErrorString(audioInfoData.getErrorMsg());
                this.Ox.au(false);
            }
        }
        return this.Ox;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.CU = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.Oz);
        this.CU.o("voice_md5", bVar.rA());
        String or = this.CU.or();
        if (or == null || !this.CU.oS().qa().lT()) {
            bVar.cz((int) q(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.i.a(bVar);
            this.Ox.setErrorCode(this.CU.oW());
            this.Ox.setErrorString(this.CU.getErrorString());
            this.Ox.au(false);
            return null;
        }
        com.baidu.tbadk.core.util.i.bZ(str);
        return or;
    }

    private long q(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
