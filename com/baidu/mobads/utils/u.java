package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class u extends com.baidu.mobads.f.a<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3510a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, Context context) {
        this.c = tVar;
        this.f3510a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004c, code lost:
        r5.c.n = "2";
     */
    @Override // com.baidu.mobads.f.a
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a() {
        String str;
        boolean e;
        String str2;
        try {
            this.c.m = "1";
            String string = Settings.System.getString(this.f3510a.getContentResolver(), "bd_setting_i");
            e = this.c.e(string);
            if (e) {
                this.c.m = "2";
                str2 = "";
            } else {
                str2 = string;
            }
            try {
                String[] strArr = this.f3510a.getPackageManager().getPackageInfo(this.f3510a.getPackageName(), 4096).requestedPermissions;
                int i = 0;
                while (true) {
                    if (i >= strArr.length) {
                        break;
                    } else if (strArr[i].contains("android.permission.READ_PHONE_STATE")) {
                        break;
                    } else {
                        this.c.n = "0";
                        i++;
                    }
                }
            } catch (Throwable th) {
            }
            String unused = t.f = str2;
        } catch (Throwable th2) {
            String unused2 = t.f = "";
        }
        str = t.f;
        return str;
    }
}
