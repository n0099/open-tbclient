package com.baidu.searchbox.discovery.nav;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class DiscoveryNavView extends FrameLayout {
    public DiscoveryNavView(Context context) {
        super(context);
        init();
    }

    public DiscoveryNavView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DiscoveryNavView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
    }

    private void refreshUi() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        refreshUi();
    }

    public void requestUpdate() {
    }
}
