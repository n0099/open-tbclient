package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Intent;
import com.baidu.platform.comapi.walknavi.widget.a;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h implements a.InterfaceC0295a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.f3006a = aVar;
    }

    @Override // com.baidu.platform.comapi.walknavi.widget.a.InterfaceC0295a
    public void a() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            activity4 = this.f3006a.i;
            activity4.startActivity(intent);
        } catch (Exception e) {
            activity = this.f3006a.i;
            if (activity != null) {
                activity2 = this.f3006a.i;
                activity3 = this.f3006a.i;
                com.baidu.platform.comapi.walknavi.g.c.c.a(activity2, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity3, R.drawable.res_0x7f080009_ic_icon_mask_first24__1));
            }
        }
    }
}
