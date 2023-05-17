package com.baidu.searchbox.config.ext;

import android.widget.TextView;
import androidx.annotation.DimenRes;
import com.baidu.searchbox.config.FontSizeHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"setScaledSize", "", "Landroid/widget/TextView;", "type", "", "size", "", "numRoundPolicy", "unit", "setScaledSizeRes", "resId", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontSizeTextViewExtKt {
    @JvmOverloads
    public static final void setScaledSize(TextView textView, int i, float f) {
        setScaledSize$default(textView, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledSize(TextView textView, int i, int i2, float f) {
        setScaledSize$default(textView, i, i2, f, 0, 8, null);
    }

    @JvmOverloads
    public static final void setScaledSizeRes(TextView textView, int i, @DimenRes int i2) {
        setScaledSizeRes$default(textView, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledSize(TextView textView, int i, float f, int i2) {
        if (textView != null) {
            textView.setTextSize(FontSizeHelper.getScaledSize(i, f, i2));
        }
    }

    @JvmOverloads
    public static final void setScaledSizeRes(TextView textView, int i, @DimenRes int i2, int i3) {
        if (textView != null) {
            textView.setTextSize(0, FontSizeHelper.getScaledSizeRes(i, i2, i3));
        }
    }

    @JvmOverloads
    public static final void setScaledSize(TextView textView, int i, int i2, float f, int i3) {
        if (textView != null) {
            textView.setTextSize(i2, FontSizeHelper.getScaledSize(i, f, i3));
        }
    }

    public static /* synthetic */ void setScaledSize$default(TextView textView, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledSize(textView, i, f, i2);
    }

    public static /* synthetic */ void setScaledSizeRes$default(TextView textView, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledSizeRes(textView, i, i2, i3);
    }

    public static /* synthetic */ void setScaledSize$default(TextView textView, int i, int i2, float f, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        setScaledSize(textView, i, i2, f, i3);
    }
}
