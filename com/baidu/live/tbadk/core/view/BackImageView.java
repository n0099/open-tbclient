package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class BackImageView extends ImageView {
    public BackImageView(Context context) {
        super(context);
    }

    public BackImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BackImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
