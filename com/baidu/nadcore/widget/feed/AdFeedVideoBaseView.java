package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.tieba.mn0;
import com.baidu.tieba.xp0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public xp0 h;

    public AdFeedVideoBaseView(@NonNull Context context) {
        super(context);
    }

    public AdFeedVideoBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, mn0 mn0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
        super.b();
        xp0 xp0Var = this.h;
        if (xp0Var != null) {
            xp0Var.release();
            this.h = null;
        }
    }

    public long getVideoPosMs() {
        xp0 xp0Var = this.h;
        if (xp0Var == null) {
            return -1L;
        }
        return xp0Var.b();
    }
}
