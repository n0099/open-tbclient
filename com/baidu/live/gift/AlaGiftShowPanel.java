package com.baidu.live.gift;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class AlaGiftShowPanel extends RelativeLayout {
    private a aFb;

    /* loaded from: classes3.dex */
    public interface a {
        void onConfigurationChanged(Configuration configuration);
    }

    public AlaGiftShowPanel(Context context) {
        super(context);
    }

    public AlaGiftShowPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlaGiftShowPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.aFb != null) {
            this.aFb.onConfigurationChanged(configuration);
        }
    }

    public void setConfigurationChangedListener(a aVar) {
        this.aFb = aVar;
    }
}
