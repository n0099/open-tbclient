package com.baidu.swan.apps.aj.h.b;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private Vibrator aXs;
    private long aXt;
    private final a.InterfaceC0109a aXu;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0117a {
        public static final a aXw = new a();
    }

    private a() {
        this.aXt = 0L;
        this.aXu = new a.InterfaceC0109a() { // from class: com.baidu.swan.apps.aj.h.b.a.1
            @Override // com.baidu.swan.apps.ab.a.InterfaceC0109a
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && a.this.aXs != null) {
                    a.this.aXs.vibrate(a.this.aXt);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.aXs = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static a NR() {
        return C0117a.aXw;
    }

    public void vibrate(long j) {
        this.aXt = j;
        if (NS()) {
            this.aXs.vibrate(this.aXt);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        e FV = e.FV();
        if (FV != null) {
            FV.a(700, strArr, this.aXu);
        }
    }

    private boolean NS() {
        if (com.baidu.swan.apps.an.a.Os()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void NT() {
        vibrate(15L);
    }

    public void NU() {
        vibrate(400L);
    }
}
