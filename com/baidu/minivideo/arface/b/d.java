package com.baidu.minivideo.arface.b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes6.dex */
public class d {
    public String clb;
    public String clc;
    public File cle;
    public String mMd5;
    public String mUrl;
    public String mVersion = "5.1_v2";
    public File cld = null;

    public static d aee() {
        d dVar = new d();
        dVar.clb = "so";
        dVar.clc = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.cld = dVar.aeg();
        dVar.cle = dVar.aej();
        return dVar;
    }

    public static d aef() {
        d dVar = new d();
        dVar.clb = "source";
        dVar.clc = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.cld = dVar.aeg();
        dVar.cle = dVar.aej();
        return dVar;
    }

    private String getUrl() {
        String str;
        if (TextUtils.equals("so2", this.clc)) {
            if (TextUtils.equals("source", this.clb)) {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
            } else {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            }
        } else if (TextUtils.equals("source", this.clb)) {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-source-";
        } else {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
        }
        return str + "5.1_v2.zip";
    }

    public String getName() {
        return this.mVersion + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMd5;
    }

    public File aeg() {
        if (this.cld == null && !TextUtils.isEmpty(this.mVersion)) {
            this.cld = new File(aei(), getName());
        }
        return this.cld;
    }

    public File aeh() {
        return aeg();
    }

    public String aei() {
        if (TextUtils.equals(this.clb, "so")) {
            if (TextUtils.equals(this.clc, "so2")) {
                return e.aeo().getAbsolutePath();
            }
            return e.aen().getAbsolutePath();
        }
        return e.aek().aem().getAbsolutePath();
    }

    public File aej() {
        if (this.cle == null) {
            File aeh = aeh();
            String absolutePath = aeh != null ? aeh.getAbsolutePath() : null;
            if (absolutePath == null) {
                return null;
            }
            if (!absolutePath.endsWith(".zip")) {
                absolutePath = absolutePath + ".zip";
            }
            if (!absolutePath.endsWith(".loading")) {
                absolutePath = absolutePath + ".loading";
            }
            this.cle = new File(absolutePath);
        }
        return this.cle;
    }
}
