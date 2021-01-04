package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4221a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4221a.g.a(false, R.drawable.res_0x7f080001_avd_hide_password__1);
    }
}
