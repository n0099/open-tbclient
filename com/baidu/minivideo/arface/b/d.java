package com.baidu.minivideo.arface.b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes5.dex */
public class d {
    public String clY;
    public String clZ;
    public File cmb;
    public String mMd5;
    public String mUrl;
    public String mVersion = "5.1_v2";
    public File cma = null;

    public static d acd() {
        d dVar = new d();
        dVar.clY = "so";
        dVar.clZ = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.cma = dVar.acf();
        dVar.cmb = dVar.aci();
        return dVar;
    }

    public static d ace() {
        d dVar = new d();
        dVar.clY = "source";
        dVar.clZ = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.cma = dVar.acf();
        dVar.cmb = dVar.aci();
        return dVar;
    }

    private String getUrl() {
        String str;
        if (TextUtils.equals("so2", this.clZ)) {
            if (TextUtils.equals("source", this.clY)) {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
            } else {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            }
        } else if (TextUtils.equals("source", this.clY)) {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-source-";
        } else {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
        }
        return str + "5.1_v2.zip";
    }

    public String getName() {
        return this.mVersion + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMd5;
    }

    public File acf() {
        if (this.cma == null && !TextUtils.isEmpty(this.mVersion)) {
            this.cma = new File(ach(), getName());
        }
        return this.cma;
    }

    public File acg() {
        return acf();
    }

    public String ach() {
        if (TextUtils.equals(this.clY, "so")) {
            if (TextUtils.equals(this.clZ, "so2")) {
                return e.acn().getAbsolutePath();
            }
            return e.acm().getAbsolutePath();
        }
        return e.acj().acl().getAbsolutePath();
    }

    public File aci() {
        if (this.cmb == null) {
            File acg = acg();
            String absolutePath = acg != null ? acg.getAbsolutePath() : null;
            if (absolutePath == null) {
                return null;
            }
            if (!absolutePath.endsWith(".zip")) {
                absolutePath = absolutePath + ".zip";
            }
            if (!absolutePath.endsWith(".loading")) {
                absolutePath = absolutePath + ".loading";
            }
            this.cmb = new File(absolutePath);
        }
        return this.cmb;
    }
}
