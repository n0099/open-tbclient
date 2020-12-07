package com.baidu.platform.comapi.bikenavi.widget;

import android.view.View;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2849a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2849a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2849a.g.a(false, R.raw.aiapp_guide);
    }
}
