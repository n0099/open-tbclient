package com.baidu.tbadk.b;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig anA;
    private IntentConfig anB;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.b.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.anA = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.anB = intentConfig;
    }

    public IntentConfig aV(boolean z) {
        return z ? this.anA : this.anB;
    }
}
