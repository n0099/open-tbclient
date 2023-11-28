package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.tieba.nn0;
import com.baidu.tieba.yp0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public yp0 h;

    public AdFeedVideoBaseView(@NonNull Context context) {
        super(context);
    }

    public AdFeedVideoBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, nn0 nn0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
        super.b();
        yp0 yp0Var = this.h;
        if (yp0Var != null) {
            yp0Var.release();
            this.h = null;
        }
    }

    public long getVideoPosMs() {
        yp0 yp0Var = this.h;
        if (yp0Var == null) {
            return -1L;
        }
        return yp0Var.b();
    }
}
