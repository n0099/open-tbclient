package com.baidu.tbadk.c;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig anR;
    private IntentConfig anS;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.anR = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.anS = intentConfig;
    }

    public IntentConfig aX(boolean z) {
        return z ? this.anR : this.anS;
    }
}
