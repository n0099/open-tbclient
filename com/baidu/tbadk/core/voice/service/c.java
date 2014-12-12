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
    private ad CV;
    private d NY;
    private com.baidu.tbadk.coreExtra.data.c NZ;
    private String Oa;
    private String Ob;

    public c(String str, String str2) {
        this.Oa = str;
        this.Ob = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c da(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.Oa);
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
        com.baidu.tbadk.coreExtra.data.b cf = com.baidu.tbadk.core.util.i.cf(e);
        if (cf == null) {
            cf = new com.baidu.tbadk.coreExtra.data.b();
            cf.dg(e);
            cf.cs(0);
            cf.r(file.length());
        }
        this.NY = new d(this, str, cf, String.valueOf(TbConfig.SERVER_ADDRESS) + this.Oa, e);
        this.NZ = this.NY.qQ();
        if (this.NZ.isSuccess() && (a = a(e, cf)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cf.dg(audioInfoData.getVoiceId());
                this.NZ.b(cf);
            } else {
                this.NZ.setErrorCode(audioInfoData.getErrorCode());
                this.NZ.setErrorString(audioInfoData.getErrorMsg());
                this.NZ.as(false);
            }
        }
        return this.NZ;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.CV = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.Ob);
        this.CV.o("voice_md5", bVar.ru());
        String ov = this.CV.ov();
        if (ov == null || !this.CV.oW().pW().ma()) {
            bVar.cs((int) q(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.i.a(bVar);
            this.NZ.setErrorCode(this.CV.pa());
            this.NZ.setErrorString(this.CV.getErrorString());
            this.NZ.as(false);
            return null;
        }
        com.baidu.tbadk.core.util.i.ce(str);
        return ov;
    }

    private long q(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
