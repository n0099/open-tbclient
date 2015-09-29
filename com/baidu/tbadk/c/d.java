package com.baidu.tbadk.c;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig anL;
    private IntentConfig anM;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.anL = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.anM = intentConfig;
    }

    public IntentConfig aX(boolean z) {
        return z ? this.anL : this.anM;
    }
}
