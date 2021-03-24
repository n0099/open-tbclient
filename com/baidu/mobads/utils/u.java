package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes2.dex */
public class u extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8571a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8572c;

    public u(t tVar, Context context) {
        this.f8572c = tVar;
        this.f8571a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        r7.f8572c.n = "2";
     */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        String str;
        boolean e2;
        try {
            this.f8572c.m = "1";
            String string = Settings.System.getString(this.f8571a.getContentResolver(), "bd_setting_i");
            e2 = this.f8572c.e(string);
            if (e2) {
                this.f8572c.m = "2";
                string = "";
            }
            try {
                String[] strArr = this.f8571a.getPackageManager().getPackageInfo(this.f8571a.getPackageName(), 4096).requestedPermissions;
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        break;
                    } else if (strArr[i].contains("android.permission.READ_PHONE_STATE")) {
                        break;
                    } else {
                        this.f8572c.n = "0";
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
            String unused2 = t.f8567f = string;
        } catch (Throwable unused3) {
            String unused4 = t.f8567f = "";
        }
        str = t.f8567f;
        return str;
    }
}
