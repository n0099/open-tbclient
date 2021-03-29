package com.baidu.mobads.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static c f8527b;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mobads.nativecpu.a.c f8528a;

    public c(Context context) {
        this.f8528a = com.baidu.mobads.nativecpu.a.c.a(context, "com.component.interfaces.RemoteReflectInterface");
    }

    public static c a(Context context) {
        if (f8527b == null) {
            synchronized (c.class) {
                if (f8527b == null) {
                    f8527b = new c(context);
                }
            }
        }
        return f8527b;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8528a.a(null, "pauseDlByPk", str);
    }

    public boolean a(Context context, IXAdInstanceInfo iXAdInstanceInfo, String str, String str2) {
        if (context != null && iXAdInstanceInfo != null) {
            Object b2 = this.f8528a.b(null, "resumeDownload", context, iXAdInstanceInfo, str, str2);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(context, str)) {
            return 103;
        }
        Object b2 = this.f8528a.b(null, "getDownloadStatus", str);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return -1;
    }
}
