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
    private ad CX;
    private com.baidu.tbadk.coreExtra.data.c OA;
    private String OB;
    private String OC;
    private d Oz;

    public c(String str, String str2) {
        this.OB = str;
        this.OC = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c cZ(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.CX = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.OB);
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
        com.baidu.tbadk.coreExtra.data.b cd = com.baidu.tbadk.core.util.i.cd(e);
        if (cd == null) {
            cd = new com.baidu.tbadk.coreExtra.data.b();
            cd.df(e);
            cd.cz(0);
            cd.r(file.length());
        }
        this.Oz = new d(this, str, cd, String.valueOf(TbConfig.SERVER_ADDRESS) + this.OB, e);
        this.OA = this.Oz.rb();
        if (this.OA.isSuccess() && (a = a(e, cd)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cd.df(audioInfoData.getVoiceId());
                this.OA.b(cd);
            } else {
                this.OA.setErrorCode(audioInfoData.getErrorCode());
                this.OA.setErrorString(audioInfoData.getErrorMsg());
                this.OA.au(false);
            }
        }
        return this.OA;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.CX = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + this.OC);
        this.CX.o("voice_md5", bVar.rG());
        String oy = this.CX.oy();
        if (oy == null || !this.CX.oZ().qh().ma()) {
            bVar.cz((int) q(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.i.a(bVar);
            this.OA.setErrorCode(this.CX.pd());
            this.OA.setErrorString(this.CX.getErrorString());
            this.OA.au(false);
            return null;
        }
        com.baidu.tbadk.core.util.i.cc(str);
        return oy;
    }

    private long q(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
