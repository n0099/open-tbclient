package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.b93;
/* loaded from: classes4.dex */
public class SPSwitchRootLinearLayout extends LinearLayout {
    public b93 a;

    public SPSwitchRootLinearLayout(Context context) {
        this(context, null);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.a.b(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public SPSwitchRootLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        this.a = new b93(this);
    }
}
