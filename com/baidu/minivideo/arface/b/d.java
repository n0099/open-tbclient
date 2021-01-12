package com.baidu.minivideo.arface.b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes5.dex */
public class d {
    public String cgo;
    public String cgp;
    public File cgr;
    public String mMd5;
    public String mUrl;
    public String mVersion = "5.1_v2";
    public File cgq = null;

    public static d aam() {
        d dVar = new d();
        dVar.cgo = "so";
        dVar.cgp = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.cgq = dVar.aao();
        dVar.cgr = dVar.aar();
        return dVar;
    }

    public static d aan() {
        d dVar = new d();
        dVar.cgo = "source";
        dVar.cgp = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.cgq = dVar.aao();
        dVar.cgr = dVar.aar();
        return dVar;
    }

    private String getUrl() {
        String str;
        if (TextUtils.equals("so2", this.cgp)) {
            if (TextUtils.equals("source", this.cgo)) {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
            } else {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            }
        } else if (TextUtils.equals("source", this.cgo)) {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-source-";
        } else {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
        }
        return str + "5.1_v2.zip";
    }

    public String getName() {
        return this.mVersion + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMd5;
    }

    public File aao() {
        if (this.cgq == null && !TextUtils.isEmpty(this.mVersion)) {
            this.cgq = new File(aaq(), getName());
        }
        return this.cgq;
    }

    public File aap() {
        return aao();
    }

    public String aaq() {
        if (TextUtils.equals(this.cgo, "so")) {
            if (TextUtils.equals(this.cgp, "so2")) {
                return e.aaw().getAbsolutePath();
            }
            return e.aav().getAbsolutePath();
        }
        return e.aas().aau().getAbsolutePath();
    }

    public File aar() {
        if (this.cgr == null) {
            File aap = aap();
            String absolutePath = aap != null ? aap.getAbsolutePath() : null;
            if (absolutePath == null) {
                return null;
            }
            if (!absolutePath.endsWith(".zip")) {
                absolutePath = absolutePath + ".zip";
            }
            if (!absolutePath.endsWith(".loading")) {
                absolutePath = absolutePath + ".loading";
            }
            this.cgr = new File(absolutePath);
        }
        return this.cgr;
    }
}
