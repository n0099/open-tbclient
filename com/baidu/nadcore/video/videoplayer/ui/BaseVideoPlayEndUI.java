package com.baidu.nadcore.video.videoplayer.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class BaseVideoPlayEndUI extends FrameLayout {
    public a a;

    /* loaded from: classes3.dex */
    public interface a {
        void onItemClick(View view2);
    }

    public abstract View b(Context context);

    public void setShowSharePanel(boolean z) {
    }

    public BaseVideoPlayEndUI(@NonNull Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        addView(b(context));
    }

    public void setOnItemClickListener(a aVar) {
        this.a = aVar;
    }

    public BaseVideoPlayEndUI(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BaseVideoPlayEndUI(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
