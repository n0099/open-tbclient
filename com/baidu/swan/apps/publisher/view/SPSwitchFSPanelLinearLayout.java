package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.i93;
import com.baidu.tieba.k93;
import com.baidu.tieba.z83;
/* loaded from: classes4.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout implements k93 {
    public z83 a;

    public SPSwitchFSPanelLinearLayout(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.k93
    public void onSoftInputShowing(boolean z) {
        this.a.a(z);
    }

    @Override // com.baidu.tieba.k93
    public void refreshHeight(int i) {
        i93.g(this, i);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        this.a = new z83(this);
    }
}
