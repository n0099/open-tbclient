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
    private aa ZF;
    private d ZG;
    private com.baidu.tbadk.coreExtra.data.c ZH;
    private String ZI;
    private String ZJ;

    public c(String str, String str2) {
        this.ZI = str;
        this.ZJ = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c df(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ZI);
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
        this.ZG = new d(this, str, ci, String.valueOf(TbConfig.SERVER_ADDRESS) + this.ZI, e);
        this.ZH = this.ZG.ue();
        if (this.ZH.isSuccess() && (a = a(e, ci)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                ci.di(audioInfoData.getVoiceId());
                this.ZH.b(ci);
            } else {
                this.ZH.setErrorCode(audioInfoData.getErrorCode());
                this.ZH.setErrorString(audioInfoData.getErrorMsg());
                this.ZH.af(false);
            }
        }
        return this.ZH;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.ZF = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.ZJ);
        this.ZF.o("voice_md5", bVar.ux());
        String rO = this.ZF.rO();
        if (rO == null || !this.ZF.sp().tq().pv()) {
            bVar.cy((int) r(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.ZH.setErrorCode(this.ZF.st());
            this.ZH.setErrorString(this.ZF.getErrorString());
            this.ZH.af(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.ch(str);
        return rO;
    }

    private long r(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
