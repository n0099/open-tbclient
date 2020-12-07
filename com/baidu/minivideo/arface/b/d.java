package com.baidu.minivideo.arface.b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes8.dex */
public class d {
    public String cer;
    public String ces;
    public File ceu;
    public String mMd5;
    public String mUrl;
    public String mVersion = "5.1_v2";
    public File cet = null;

    public static d acp() {
        d dVar = new d();
        dVar.cer = "so";
        dVar.ces = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = f.toMd5(dVar.mUrl);
        dVar.cet = dVar.acr();
        dVar.ceu = dVar.acu();
        return dVar;
    }

    public static d acq() {
        d dVar = new d();
        dVar.cer = "source";
        dVar.ces = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = f.toMd5(dVar.mUrl);
        dVar.cet = dVar.acr();
        dVar.ceu = dVar.acu();
        return dVar;
    }

    private String getUrl() {
        String str;
        if (TextUtils.equals("so2", this.ces)) {
            if (TextUtils.equals("source", this.cer)) {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
            } else {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            }
        } else if (TextUtils.equals("source", this.cer)) {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-source-";
        } else {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
        }
        return str + "5.1_v2.zip";
    }

    public String getName() {
        return this.mVersion + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMd5;
    }

    public File acr() {
        if (this.cet == null && !TextUtils.isEmpty(this.mVersion)) {
            this.cet = new File(act(), getName());
        }
        return this.cet;
    }

    public File acs() {
        return acr();
    }

    public String act() {
        if (TextUtils.equals(this.cer, "so")) {
            if (TextUtils.equals(this.ces, "so2")) {
                return e.acz().getAbsolutePath();
            }
            return e.acy().getAbsolutePath();
        }
        return e.acv().acx().getAbsolutePath();
    }

    public File acu() {
        if (this.ceu == null) {
            File acs = acs();
            String absolutePath = acs != null ? acs.getAbsolutePath() : null;
            if (absolutePath == null) {
                return null;
            }
            if (!absolutePath.endsWith(".zip")) {
                absolutePath = absolutePath + ".zip";
            }
            if (!absolutePath.endsWith(".loading")) {
                absolutePath = absolutePath + ".loading";
            }
            this.ceu = new File(absolutePath);
        }
        return this.ceu;
    }
}
