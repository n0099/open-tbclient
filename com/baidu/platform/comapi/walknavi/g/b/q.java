package com.baidu.platform.comapi.walknavi.g.b;

import android.content.Context;
import android.widget.Toast;
import com.baidu.platform.comapi.walknavi.g.b.c;
import java.io.File;
/* loaded from: classes2.dex */
public class q implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.b f10027a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10028b;

    public q(c cVar, c.b bVar) {
        this.f10028b = cVar;
        this.f10027a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i2) {
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i2, String str) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        String str2;
        com.baidu.platform.comapi.wnplatform.d.a.b("downloadnpc:responseCode = " + i2 + ", responseMessage = " + str);
        if (i2 == 0) {
            c cVar = this.f10028b;
            cVar.Q = str + File.separator + "ar";
            c.b bVar = this.f10027a;
            str2 = this.f10028b.Q;
            bVar.a(str2);
        } else if (i2 == 2 || i2 == 4 || i2 == 3) {
            context = this.f10028b.l;
            Toast.makeText(context, "您的手机暂不支持3D模型导航", 0).show();
            this.f10027a.a(i2);
        } else if (i2 == 7) {
            this.f10027a.a(i2);
        } else if (i2 == 8) {
            context5 = this.f10028b.l;
            Toast.makeText(context5, "正在为您切换至3D模型导航", 0).show();
            this.f10027a.a(i2);
        } else if (i2 == 1) {
            context4 = this.f10028b.l;
            Toast.makeText(context4, "当前网络异常，请稍候再试", 0).show();
            this.f10027a.a(i2);
        } else if (i2 == 6 || i2 == 5 || i2 == -1) {
            context2 = this.f10028b.l;
            Toast.makeText(context2, "下载失败，请稍候再试", 0).show();
            this.f10027a.a(i2);
        } else {
            this.f10027a.a(i2);
            context3 = this.f10028b.l;
            Toast.makeText(context3, str, 0).show();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f2) {
    }
}
