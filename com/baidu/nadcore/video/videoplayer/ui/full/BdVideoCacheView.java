package com.baidu.nadcore.video.videoplayer.ui.full;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.video.videoplayer.ui.loading.BdVideoLoadingView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.u71;
import com.baidu.tieba.y11;
import java.util.Locale;
/* loaded from: classes3.dex */
public class BdVideoCacheView extends FrameLayout {
    public static final int e;
    public static final int f;
    public final Context a;
    public BdVideoLoadingView b;
    public TextView c;
    public TextView d;

    static {
        u71.c(18.0f);
        u71.c(22.0f);
        e = u71.d(200.0f);
        f = u71.d(200.0f);
        u71.d(10.0f);
        u71.d(25.0f);
        u71.d(6.0f);
        u71.d(8.0f);
    }

    public final void b() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        BdVideoLoadingView bdVideoLoadingView = new BdVideoLoadingView(this.a);
        this.b = bdVideoLoadingView;
        addView(bdVideoLoadingView, layoutParams);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    public BdVideoCacheView(@NonNull Context context) {
        this(context, null);
    }

    public void c(int i) {
        if (i != 0) {
            this.b.clearAnimation();
            this.b.d();
        } else if (!this.b.b()) {
            this.b.c();
        }
        setVisibility(i);
        this.b.setVisibility(i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (i != 0) {
            y11.a("onWindowVisibilityChanged(" + i + SmallTailInfo.EMOTION_SUFFIX);
            setVisibility(4);
        }
        super.onWindowVisibilityChanged(i);
    }

    public void setLoadingAnimListener(BdVideoLoadingView.a aVar) {
        BdVideoLoadingView bdVideoLoadingView = this.b;
        if (bdVideoLoadingView != null) {
            bdVideoLoadingView.setLoadingAnimListener(aVar);
        }
    }

    public void setSpeedHint(int i) {
        this.d.setText(a(i));
    }

    public BdVideoCacheView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        b();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(e, f);
    }

    public final String a(int i) {
        float f2 = i;
        String str = " KB/s";
        if (f2 >= 1024.0f) {
            f2 /= 1024.0f;
            if (f2 >= 1024.0f) {
                f2 /= 1024.0f;
                str = " MB/s";
            }
        }
        return String.format(Locale.getDefault(), "%.2f", Float.valueOf(f2)) + str;
    }

    @SuppressLint({"SetTextI18n"})
    public void setCacheHint(int i) {
        String str;
        if (this.c.getVisibility() == 0) {
            if (i < 10) {
                str = "   " + i;
            } else if (i < 100) {
                str = " " + i;
            } else {
                str = "";
            }
            this.c.setText(str + "%");
        }
    }
}
