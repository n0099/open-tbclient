package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class i implements a.InterfaceC0127a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9846a;

    public i(b bVar) {
        this.f9846a = bVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0127a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity3 = this.f9846a.f9834f;
            activity3.startActivity(intent);
        } catch (Exception unused) {
            activity = this.f9846a.f9834f;
            activity2 = this.f9846a.f9834f;
            com.baidu.platform.comapi.walknavi.g.c.c.a(activity, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity2, R.drawable.res_0x7f080009_ic_icon_mask_first24__1));
        }
    }
}
