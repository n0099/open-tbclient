package com.baidu.adp.widget.BdSwitchView;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdSwitchView f550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdSwitchView bdSwitchView) {
        this.f550a = bdSwitchView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f550a.a(true);
    }
}
