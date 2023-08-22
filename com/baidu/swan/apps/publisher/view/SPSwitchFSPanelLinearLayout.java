package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.e93;
import com.baidu.tieba.g93;
import com.baidu.tieba.v83;
/* loaded from: classes4.dex */
public class SPSwitchFSPanelLinearLayout extends LinearLayout implements g93 {
    public v83 a;

    public SPSwitchFSPanelLinearLayout(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.g93
    public void onSoftInputShowing(boolean z) {
        this.a.a(z);
    }

    @Override // com.baidu.tieba.g93
    public void refreshHeight(int i) {
        e93.g(this, i);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SPSwitchFSPanelLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        this.a = new v83(this);
    }
}
