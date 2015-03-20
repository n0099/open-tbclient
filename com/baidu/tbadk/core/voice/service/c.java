package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ab;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private aa ZD;
    private d ZE;
    private com.baidu.tbadk.coreExtra.data.c ZF;
    private String ZG;
    private String ZH;

    public c(String str, String str2) {
        this.ZG = str;
        this.ZH = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c df(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ZG);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c a(String str, File file) {
        String a;
        String e = ab.e(o.l(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b ci = com.baidu.tbadk.core.util.e.ci(e);
        if (ci == null) {
            ci = new com.baidu.tbadk.coreExtra.data.b();
            ci.di(e);
            ci.cy(0);
            ci.s(file.length());
        }
        this.ZE = new d(this, str, ci, String.valueOf(TbConfig.SERVER_ADDRESS) + this.ZG, e);
        this.ZF = this.ZE.ue();
        if (this.ZF.isSuccess() && (a = a(e, ci)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                ci.di(audioInfoData.getVoiceId());
                this.ZF.b(ci);
            } else {
                this.ZF.setErrorCode(audioInfoData.getErrorCode());
                this.ZF.setErrorString(audioInfoData.getErrorMsg());
                this.ZF.af(false);
            }
        }
        return this.ZF;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.ZD = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ZH);
        this.ZD.o("voice_md5", bVar.ux());
        String rO = this.ZD.rO();
        if (rO == null || !this.ZD.sp().tq().pv()) {
            bVar.cy((int) r(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.ZF.setErrorCode(this.ZD.st());
            this.ZF.setErrorString(this.ZD.getErrorString());
            this.ZF.af(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.ch(str);
        return rO;
    }

    private long r(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
