package com.baidu.tbadk.core.voice.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ac;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import java.io.File;
/* loaded from: classes.dex */
public class c {
    private aa aaG;
    private d aaH;
    private com.baidu.tbadk.coreExtra.data.c aaI;
    private String aaJ;
    private String aaK;

    public c(String str, String str2) {
        this.aaJ = str;
        this.aaK = str2;
    }

    public com.baidu.tbadk.coreExtra.data.c dw(String str) {
        try {
            File file = new File(str);
            if (file == null || !file.exists()) {
                return null;
            }
            this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aaJ);
            return a(str, file);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private com.baidu.tbadk.coreExtra.data.c a(String str, File file) {
        String a;
        String e = ac.e(o.n(file));
        if (e != null && e.length() > 0) {
            e = e.toLowerCase();
        }
        com.baidu.tbadk.coreExtra.data.b cx = com.baidu.tbadk.core.util.e.cx(e);
        if (cx == null) {
            cx = new com.baidu.tbadk.coreExtra.data.b();
            cx.dz(e);
            cx.cD(0);
            cx.u(file.length());
        }
        this.aaH = new d(this, str, cx, String.valueOf(TbConfig.SERVER_ADDRESS) + this.aaJ, e);
        this.aaI = this.aaH.uN();
        if (this.aaI.isSuccess() && (a = a(e, cx)) != null && !a.equals("")) {
            AudioInfoData audioInfoData = new AudioInfoData();
            audioInfoData.parserJson(a);
            if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                cx.dz(audioInfoData.getVoiceId());
                this.aaI.b(cx);
            } else {
                this.aaI.setErrorCode(audioInfoData.getErrorCode());
                this.aaI.setErrorString(audioInfoData.getErrorUserMsg());
                this.aaI.al(false);
            }
        }
        return this.aaI;
    }

    private String a(String str, com.baidu.tbadk.coreExtra.data.b bVar) {
        this.aaG = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + this.aaK);
        this.aaG.o("voice_md5", bVar.vg());
        String sw = this.aaG.sw();
        if (sw == null || !this.aaG.sX().tT().qa()) {
            bVar.cD((int) t(bVar.getTotalLength()));
            com.baidu.tbadk.core.util.e.a(bVar);
            this.aaI.setErrorCode(this.aaG.tb());
            this.aaI.setErrorString(this.aaG.getErrorString());
            this.aaI.al(false);
            return null;
        }
        com.baidu.tbadk.core.util.e.cw(str);
        return sw;
    }

    private long t(long j) {
        return j % 30720 == 0 ? j / 30720 : (j / 30720) + 1;
    }
}
