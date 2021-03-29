package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
/* loaded from: classes2.dex */
public class u extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8572a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8573c;

    public u(t tVar, Context context) {
        this.f8573c = tVar;
        this.f8572a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        r7.f8573c.n = "2";
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
            this.f8573c.m = "1";
            String string = Settings.System.getString(this.f8572a.getContentResolver(), "bd_setting_i");
            e2 = this.f8573c.e(string);
            if (e2) {
                this.f8573c.m = "2";
                string = "";
            }
            try {
                String[] strArr = this.f8572a.getPackageManager().getPackageInfo(this.f8572a.getPackageName(), 4096).requestedPermissions;
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        break;
                    } else if (strArr[i].contains("android.permission.READ_PHONE_STATE")) {
                        break;
                    } else {
                        this.f8573c.n = "0";
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
            String unused2 = t.f8568f = string;
        } catch (Throwable unused3) {
            String unused4 = t.f8568f = "";
        }
        str = t.f8568f;
        return str;
    }
}
