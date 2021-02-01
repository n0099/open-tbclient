package com.baidu.minivideo.arface.b;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
/* loaded from: classes3.dex */
public class d {
    public File ckB;
    public String cky;
    public String ckz;
    public String mMd5;
    public String mUrl;
    public String mVersion = "5.1_v2";
    public File ckA = null;

    public static d aca() {
        d dVar = new d();
        dVar.cky = "so";
        dVar.ckz = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.ckA = dVar.acc();
        dVar.ckB = dVar.acf();
        return dVar;
    }

    public static d acb() {
        d dVar = new d();
        dVar.cky = "source";
        dVar.ckz = "so2";
        dVar.mVersion = "5.1_v2";
        dVar.mUrl = dVar.getUrl();
        dVar.mMd5 = g.toMd5(dVar.mUrl);
        dVar.ckA = dVar.acc();
        dVar.ckB = dVar.acf();
        return dVar;
    }

    private String getUrl() {
        String str;
        if (TextUtils.equals("so2", this.ckz)) {
            if (TextUtils.equals("source", this.cky)) {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-source-live-";
            } else {
                str = "https://pic.rmb.bdstatic.com/baidu-ar-so-live-";
            }
        } else if (TextUtils.equals("source", this.cky)) {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-source-";
        } else {
            str = "https://pic.rmb.bdstatic.com/baidu-ar-so-";
        }
        return str + "5.1_v2.zip";
    }

    public String getName() {
        return this.mVersion + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mMd5;
    }

    public File acc() {
        if (this.ckA == null && !TextUtils.isEmpty(this.mVersion)) {
            this.ckA = new File(ace(), getName());
        }
        return this.ckA;
    }

    public File acd() {
        return acc();
    }

    public String ace() {
        if (TextUtils.equals(this.cky, "so")) {
            if (TextUtils.equals(this.ckz, "so2")) {
                return e.ack().getAbsolutePath();
            }
            return e.acj().getAbsolutePath();
        }
        return e.acg().aci().getAbsolutePath();
    }

    public File acf() {
        if (this.ckB == null) {
            File acd = acd();
            String absolutePath = acd != null ? acd.getAbsolutePath() : null;
            if (absolutePath == null) {
                return null;
            }
            if (!absolutePath.endsWith(".zip")) {
                absolutePath = absolutePath + ".zip";
            }
            if (!absolutePath.endsWith(".loading")) {
                absolutePath = absolutePath + ".loading";
            }
            this.ckB = new File(absolutePath);
        }
        return this.ckB;
    }
}
