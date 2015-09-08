package com.baidu.tbadk.c;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig apl;
    private IntentConfig apm;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.apl = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.apm = intentConfig;
    }

    public IntentConfig bc(boolean z) {
        return z ? this.apl : this.apm;
    }
}
