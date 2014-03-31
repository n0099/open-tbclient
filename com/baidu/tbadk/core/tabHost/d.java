package com.baidu.tbadk.core.tabHost;

import android.view.View;
/* loaded from: classes.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ FragmentTabWidget a;
    private final int b;

    private d(FragmentTabWidget fragmentTabWidget, int i) {
        this.a = fragmentTabWidget;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(FragmentTabWidget fragmentTabWidget, int i, byte b) {
        this(fragmentTabWidget, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentTabWidget.a(this.a).a(this.b);
    }
}
