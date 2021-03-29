package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h implements a.InterfaceC0128a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10135a;

    public h(a aVar) {
        this.f10135a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0128a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.f10135a.i;
            activity4.startActivity(intent);
        } catch (Exception unused) {
            activity = this.f10135a.i;
            if (activity != null) {
                activity2 = this.f10135a.i;
                activity3 = this.f10135a.i;
                com.baidu.platform.comapi.walknavi.g.c.c.a(activity2, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity3, R.drawable.res_0x7f080009_ic_icon_mask_first24__1));
            }
        }
    }
}
