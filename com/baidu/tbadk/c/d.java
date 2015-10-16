package com.baidu.tbadk.c;

import android.view.View;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class d extends b {
    private IntentConfig anM;
    private IntentConfig anN;
    private View.OnClickListener mClickListener;

    @Override // com.baidu.tbadk.c.b
    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void a(IntentConfig intentConfig) {
        this.anM = intentConfig;
    }

    public void b(IntentConfig intentConfig) {
        this.anN = intentConfig;
    }

    public IntentConfig aX(boolean z) {
        return z ? this.anM : this.anN;
    }
}
