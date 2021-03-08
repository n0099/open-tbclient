package com.baidu.mobads.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* loaded from: classes4.dex */
public class c {
    private static c b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mobads.nativecpu.a.c f2481a;

    private c(Context context) {
        this.f2481a = com.baidu.mobads.nativecpu.a.c.a(context, "com.component.interfaces.RemoteReflectInterface");
    }

    public static c a(Context context) {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c(context);
                }
            }
        }
        return b;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f2481a.a(null, "pauseDlByPk", str);
        }
    }

    public boolean a(Context context, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2) {
        if (context != null && iXAdInstanceInfo != null) {
            Object b2 = this.f2481a.b(null, "resumeDownload", context, iXAdInstanceInfo, str, str2);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(context, str)) {
                return 103;
            }
            Object b2 = this.f2481a.b(null, "getDownloadStatus", str);
            if (b2 instanceof Integer) {
                return ((Integer) b2).intValue();
            }
        }
        return -1;
    }
}
