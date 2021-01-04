package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.commonutils.a.d;
import com.baidu.mapsdkplatform.comapi.map.f;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class h implements d.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3180a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3181b;
    final /* synthetic */ f.a c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, Context context, String str, f.a aVar, String str2, String str3) {
        this.f = fVar;
        this.f3180a = context;
        this.f3181b = str;
        this.c = aVar;
        this.d = str2;
        this.e = str3;
    }

    @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.d.c
    public void a() {
        if (this.c != null) {
            this.c.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "loadStyleFile onFailed", null);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.commonutils.a.d.c
    public void a(File file) {
        boolean a2;
        boolean a3;
        a2 = this.f.a(this.f3180a, file, this.f3181b);
        if (!a2) {
            if (this.c != null) {
                this.c.a(HttpClient.HttpStateError.INNER_ERROR.ordinal(), "UnZipStyleFile onFailed", null);
                return;
            }
            return;
        }
        this.f.a(this.f3180a, this.f3181b, this.d);
        if (this.c != null) {
            a3 = this.f.a(this.e);
            this.c.a(true, a3 ? this.e : null);
        }
    }
}
