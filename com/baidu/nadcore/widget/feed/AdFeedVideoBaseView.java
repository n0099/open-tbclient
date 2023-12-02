package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.tieba.aq0;
import com.baidu.tieba.on0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public aq0 h;

    public AdFeedVideoBaseView(@NonNull Context context) {
        super(context);
    }

    public AdFeedVideoBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, on0 on0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void b() {
        super.b();
        aq0 aq0Var = this.h;
        if (aq0Var != null) {
            aq0Var.release();
            this.h = null;
        }
    }

    public long getVideoPosMs() {
        aq0 aq0Var = this.h;
        if (aq0Var == null) {
            return -1L;
        }
        return aq0Var.b();
    }
}
