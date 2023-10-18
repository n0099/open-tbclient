package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.tieba.gp0;
import com.baidu.tieba.vm0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public gp0 h;

    public AdFeedVideoBaseView(@NonNull Context context) {
        super(context);
    }

    public AdFeedVideoBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, vm0 vm0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
        super.b();
        gp0 gp0Var = this.h;
        if (gp0Var != null) {
            gp0Var.release();
            this.h = null;
        }
    }

    public long getVideoPosMs() {
        gp0 gp0Var = this.h;
        if (gp0Var == null) {
            return -1L;
        }
        return gp0Var.b();
    }
}
