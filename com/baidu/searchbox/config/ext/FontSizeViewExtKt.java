package com.baidu.searchbox.config.ext;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.DimenRes;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.utils.ResUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u001c\u001a(\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\u0011\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010\u0012\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\u0014\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a@\u0010\u0016\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001aH\u0010\u0019\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0015\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a@\u0010\u001c\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010\u001d\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\u001e\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a0\u0010\u001f\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a4\u0010!\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\"\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010$\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010%\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a(\u0010&\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010'\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006("}, d2 = {"setScaledBackground", "", "Landroid/view/View;", "type", "", ResourceManager.DRAWABLE, "Landroid/graphics/drawable/Drawable;", "numRoundPolicy", "setScaledBackgroundResource", "resId", "setScaledBottomMargin", "bottom", "", "setScaledBottomMarginRes", "bottomResId", "setScaledHeight", "height", "setScaledHeightRes", "setScaledLeftMargin", "left", "setScaledLeftMarginRes", "leftResId", "setScaledMargin", "top", "right", "setScaledMarginRes", "topResId", "rightResId", "setScaledPadding", "setScaledRightMargin", "setScaledRightMarginRes", "setScaledSize", "width", "setScaledSizeRes", "widthResId", "heightResId", "setScaledTopMargin", "setScaledTopMarginRes", "setScaledWidth", "setScaledWidthRes", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontSizeViewExtKt {
    @JvmOverloads
    public static final void setScaledBackground(View view2, int i, Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        setScaledBackground$default(view2, i, drawable, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledBackgroundResource(View view2, int i, int i2) {
        setScaledBackgroundResource$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledBottomMargin(View view2, int i, float f) {
        setScaledBottomMargin$default(view2, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledBottomMarginRes(View view2, int i, @DimenRes int i2) {
        setScaledBottomMarginRes$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledHeight(View view2, int i, float f) {
        setScaledHeight$default(view2, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledHeightRes(View view2, int i, @DimenRes int i2) {
        setScaledHeightRes$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledLeftMargin(View view2, int i, float f) {
        setScaledLeftMargin$default(view2, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledLeftMarginRes(View view2, int i, @DimenRes int i2) {
        setScaledLeftMarginRes$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledMargin(View view2, int i, float f, float f2, float f3, float f4) {
        setScaledMargin$default(view2, i, f, f2, f3, f4, 0, 32, null);
    }

    @JvmOverloads
    public static final void setScaledMarginRes(View view2, int i, @DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        setScaledMarginRes$default(view2, i, i2, i3, i4, i5, 0, 32, null);
    }

    @JvmOverloads
    public static final void setScaledPadding(View view2, int i, float f, float f2, float f3, float f4) {
        setScaledPadding$default(view2, i, f, f2, f3, f4, 0, 32, null);
    }

    @JvmOverloads
    public static final void setScaledRightMargin(View view2, int i, float f) {
        setScaledRightMargin$default(view2, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledRightMarginRes(View view2, int i, @DimenRes int i2) {
        setScaledRightMarginRes$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledSize(View view2, int i, float f, float f2) {
        setScaledSize$default(view2, i, f, f2, 0, 8, null);
    }

    @JvmOverloads
    public static final void setScaledSizeRes(View view2, int i, @DimenRes int i2, @DimenRes int i3) {
        setScaledSizeRes$default(view2, i, i2, i3, 0, 8, null);
    }

    @JvmOverloads
    public static final void setScaledTopMargin(View view2, int i, float f) {
        setScaledTopMargin$default(view2, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledTopMarginRes(View view2, int i, @DimenRes int i2) {
        setScaledTopMarginRes$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledWidth(View view2, int i, float f) {
        setScaledWidth$default(view2, i, f, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledWidthRes(View view2, int i, @DimenRes int i2) {
        setScaledWidthRes$default(view2, i, i2, 0, 4, null);
    }

    @JvmOverloads
    public static final void setScaledBackground(View view2, int i, Drawable drawable, int i2) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (view2 != null) {
            view2.setBackground(FontSizeHelper.getScaledDrawable(i, drawable, i2));
        }
    }

    @JvmOverloads
    public static final void setScaledBackgroundResource(View view2, int i, int i2, int i3) {
        Drawable scaledDrawable;
        if (view2 != null) {
            if (i2 == 0) {
                scaledDrawable = null;
            } else {
                scaledDrawable = FontSizeHelper.getScaledDrawable(i, view2.getResources().getDrawable(i2), i3);
            }
            view2.setBackground(scaledDrawable);
        }
    }

    @JvmOverloads
    public static final void setScaledBottomMarginRes(View view2, int i, @DimenRes int i2, int i3) {
        setScaledBottomMargin(view2, i, ResUtil.getDimenByResId(i2), i3);
    }

    @JvmOverloads
    public static final void setScaledHeightRes(View view2, int i, @DimenRes int i2, int i3) {
        setScaledHeight(view2, i, ResUtil.getDimenByResId(i2), i3);
    }

    @JvmOverloads
    public static final void setScaledLeftMarginRes(View view2, int i, @DimenRes int i2, int i3) {
        setScaledLeftMargin(view2, i, ResUtil.getDimenByResId(i2), i3);
    }

    @JvmOverloads
    public static final void setScaledRightMarginRes(View view2, int i, @DimenRes int i2, int i3) {
        setScaledRightMargin(view2, i, ResUtil.getDimenByResId(i2), i3);
    }

    @JvmOverloads
    public static final void setScaledTopMarginRes(View view2, int i, @DimenRes int i2, int i3) {
        setScaledTopMargin(view2, i, ResUtil.getDimenByResId(i2), i3);
    }

    @JvmOverloads
    public static final void setScaledWidthRes(View view2, int i, @DimenRes int i2, int i3) {
        setScaledWidth(view2, i, ResUtil.getDimenByResId(i2), i3);
    }

    public static /* synthetic */ void setScaledBackground$default(View view2, int i, Drawable drawable, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledBackground(view2, i, drawable, i2);
    }

    public static /* synthetic */ void setScaledBackgroundResource$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledBackgroundResource(view2, i, i2, i3);
    }

    public static /* synthetic */ void setScaledBottomMargin$default(View view2, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledBottomMargin(view2, i, f, i2);
    }

    public static /* synthetic */ void setScaledBottomMarginRes$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledBottomMarginRes(view2, i, i2, i3);
    }

    public static /* synthetic */ void setScaledHeight$default(View view2, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledHeight(view2, i, f, i2);
    }

    public static /* synthetic */ void setScaledHeightRes$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledHeightRes(view2, i, i2, i3);
    }

    public static /* synthetic */ void setScaledLeftMargin$default(View view2, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledLeftMargin(view2, i, f, i2);
    }

    public static /* synthetic */ void setScaledLeftMarginRes$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledLeftMarginRes(view2, i, i2, i3);
    }

    public static /* synthetic */ void setScaledRightMargin$default(View view2, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledRightMargin(view2, i, f, i2);
    }

    public static /* synthetic */ void setScaledRightMarginRes$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledRightMarginRes(view2, i, i2, i3);
    }

    public static /* synthetic */ void setScaledTopMargin$default(View view2, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledTopMargin(view2, i, f, i2);
    }

    public static /* synthetic */ void setScaledTopMarginRes$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledTopMarginRes(view2, i, i2, i3);
    }

    public static /* synthetic */ void setScaledWidth$default(View view2, int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        setScaledWidth(view2, i, f, i2);
    }

    public static /* synthetic */ void setScaledWidthRes$default(View view2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledWidthRes(view2, i, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledBottomMargin(View view2, int i, float f, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        double ceil;
        int i3;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                float scaledSize = FontSizeHelper.getScaledSize(i, f);
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        } else {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        }
                        marginLayoutParams.bottomMargin = i3;
                        if (marginLayoutParams == null) {
                            view2.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        return;
                    }
                    ceil = Math.floor(scaledSize);
                } else {
                    ceil = Math.ceil(scaledSize);
                }
                i3 = (int) ceil;
                marginLayoutParams.bottomMargin = i3;
                if (marginLayoutParams == null) {
                }
            }
        }
    }

    @JvmOverloads
    public static final void setScaledHeight(View view2, int i, float f, int i2) {
        ViewGroup.LayoutParams layoutParams;
        double ceil;
        int i3;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
            float scaledSize = FontSizeHelper.getScaledSize(i, f);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    } else {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    }
                    layoutParams.height = i3;
                    view2.setLayoutParams(layoutParams);
                }
                ceil = Math.floor(scaledSize);
            } else {
                ceil = Math.ceil(scaledSize);
            }
            i3 = (int) ceil;
            layoutParams.height = i3;
            view2.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledLeftMargin(View view2, int i, float f, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        double ceil;
        int i3;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                float scaledSize = FontSizeHelper.getScaledSize(i, f);
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        } else {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        }
                        marginLayoutParams.leftMargin = i3;
                        if (marginLayoutParams == null) {
                            view2.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        return;
                    }
                    ceil = Math.floor(scaledSize);
                } else {
                    ceil = Math.ceil(scaledSize);
                }
                i3 = (int) ceil;
                marginLayoutParams.leftMargin = i3;
                if (marginLayoutParams == null) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledRightMargin(View view2, int i, float f, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        double ceil;
        int i3;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                float scaledSize = FontSizeHelper.getScaledSize(i, f);
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        } else {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        }
                        marginLayoutParams.rightMargin = i3;
                        if (marginLayoutParams == null) {
                            view2.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        return;
                    }
                    ceil = Math.floor(scaledSize);
                } else {
                    ceil = Math.ceil(scaledSize);
                }
                i3 = (int) ceil;
                marginLayoutParams.rightMargin = i3;
                if (marginLayoutParams == null) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledTopMargin(View view2, int i, float f, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        double ceil;
        int i3;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                float scaledSize = FontSizeHelper.getScaledSize(i, f);
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        } else {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        }
                        marginLayoutParams.topMargin = i3;
                        if (marginLayoutParams == null) {
                            view2.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        return;
                    }
                    ceil = Math.floor(scaledSize);
                } else {
                    ceil = Math.ceil(scaledSize);
                }
                i3 = (int) ceil;
                marginLayoutParams.topMargin = i3;
                if (marginLayoutParams == null) {
                }
            }
        }
    }

    @JvmOverloads
    public static final void setScaledWidth(View view2, int i, float f, int i2) {
        ViewGroup.LayoutParams layoutParams;
        double ceil;
        int i3;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
            float scaledSize = FontSizeHelper.getScaledSize(i, f);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    } else {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    }
                    layoutParams.width = i3;
                    view2.setLayoutParams(layoutParams);
                }
                ceil = Math.floor(scaledSize);
            } else {
                ceil = Math.ceil(scaledSize);
            }
            i3 = (int) ceil;
            layoutParams.width = i3;
            view2.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledMargin(View view2, int i, float f, float f2, float f3, float f4, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        double ceil;
        int i3;
        double ceil2;
        int i4;
        double ceil3;
        int i5;
        double ceil4;
        int i6;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                float scaledSize = FontSizeHelper.getScaledSize(i, f);
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        } else {
                            i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                        }
                        marginLayoutParams.leftMargin = i3;
                        float scaledSize2 = FontSizeHelper.getScaledSize(i, f2);
                        if (i2 == 0) {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    i4 = MathKt__MathJVMKt.roundToInt(scaledSize2);
                                } else {
                                    i4 = MathKt__MathJVMKt.roundToInt(scaledSize2);
                                }
                                marginLayoutParams.topMargin = i4;
                                float scaledSize3 = FontSizeHelper.getScaledSize(i, f3);
                                if (i2 != 0) {
                                    if (i2 != 1) {
                                        if (i2 != 2) {
                                            i5 = MathKt__MathJVMKt.roundToInt(scaledSize3);
                                        } else {
                                            i5 = MathKt__MathJVMKt.roundToInt(scaledSize3);
                                        }
                                        marginLayoutParams.rightMargin = i5;
                                        float scaledSize4 = FontSizeHelper.getScaledSize(i, f4);
                                        if (i2 == 0) {
                                            if (i2 != 1) {
                                                if (i2 != 2) {
                                                    i6 = MathKt__MathJVMKt.roundToInt(scaledSize4);
                                                } else {
                                                    i6 = MathKt__MathJVMKt.roundToInt(scaledSize4);
                                                }
                                                marginLayoutParams.bottomMargin = i6;
                                                if (marginLayoutParams != null) {
                                                    view2.setLayoutParams(marginLayoutParams);
                                                    return;
                                                }
                                                return;
                                            }
                                            ceil4 = Math.floor(scaledSize4);
                                        } else {
                                            ceil4 = Math.ceil(scaledSize4);
                                        }
                                        i6 = (int) ceil4;
                                        marginLayoutParams.bottomMargin = i6;
                                        if (marginLayoutParams != null) {
                                        }
                                    } else {
                                        ceil3 = Math.floor(scaledSize3);
                                    }
                                } else {
                                    ceil3 = Math.ceil(scaledSize3);
                                }
                                i5 = (int) ceil3;
                                marginLayoutParams.rightMargin = i5;
                                float scaledSize42 = FontSizeHelper.getScaledSize(i, f4);
                                if (i2 == 0) {
                                }
                                i6 = (int) ceil4;
                                marginLayoutParams.bottomMargin = i6;
                                if (marginLayoutParams != null) {
                                }
                            } else {
                                ceil2 = Math.floor(scaledSize2);
                            }
                        } else {
                            ceil2 = Math.ceil(scaledSize2);
                        }
                        i4 = (int) ceil2;
                        marginLayoutParams.topMargin = i4;
                        float scaledSize32 = FontSizeHelper.getScaledSize(i, f3);
                        if (i2 != 0) {
                        }
                        i5 = (int) ceil3;
                        marginLayoutParams.rightMargin = i5;
                        float scaledSize422 = FontSizeHelper.getScaledSize(i, f4);
                        if (i2 == 0) {
                        }
                        i6 = (int) ceil4;
                        marginLayoutParams.bottomMargin = i6;
                        if (marginLayoutParams != null) {
                        }
                    } else {
                        ceil = Math.floor(scaledSize);
                    }
                } else {
                    ceil = Math.ceil(scaledSize);
                }
                i3 = (int) ceil;
                marginLayoutParams.leftMargin = i3;
                float scaledSize22 = FontSizeHelper.getScaledSize(i, f2);
                if (i2 == 0) {
                }
                i4 = (int) ceil2;
                marginLayoutParams.topMargin = i4;
                float scaledSize322 = FontSizeHelper.getScaledSize(i, f3);
                if (i2 != 0) {
                }
                i5 = (int) ceil3;
                marginLayoutParams.rightMargin = i5;
                float scaledSize4222 = FontSizeHelper.getScaledSize(i, f4);
                if (i2 == 0) {
                }
                i6 = (int) ceil4;
                marginLayoutParams.bottomMargin = i6;
                if (marginLayoutParams != null) {
                }
            }
        }
    }

    public static /* synthetic */ void setScaledMargin$default(View view2, int i, float f, float f2, float f3, float f4, int i2, int i3, Object obj) {
        int i4;
        if ((i3 & 32) != 0) {
            i4 = 2;
        } else {
            i4 = i2;
        }
        setScaledMargin(view2, i, f, f2, f3, f4, i4);
    }

    public static /* synthetic */ void setScaledMarginRes$default(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        int i8;
        if ((i7 & 32) != 0) {
            i8 = 2;
        } else {
            i8 = i6;
        }
        setScaledMarginRes(view2, i, i2, i3, i4, i5, i8);
    }

    public static /* synthetic */ void setScaledPadding$default(View view2, int i, float f, float f2, float f3, float f4, int i2, int i3, Object obj) {
        int i4;
        if ((i3 & 32) != 0) {
            i4 = 2;
        } else {
            i4 = i2;
        }
        setScaledPadding(view2, i, f, f2, f3, f4, i4);
    }

    @JvmOverloads
    public static final void setScaledMarginRes(View view2, int i, @DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5, int i6) {
        setScaledMargin(view2, i, ResUtil.getDimenByResId(i2), ResUtil.getDimenByResId(i3), ResUtil.getDimenByResId(i4), ResUtil.getDimenByResId(i5), i6);
    }

    public static /* synthetic */ void setScaledSize$default(View view2, int i, float f, float f2, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        setScaledSize(view2, i, f, f2, i2);
    }

    public static /* synthetic */ void setScaledSizeRes$default(View view2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 2;
        }
        setScaledSizeRes(view2, i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledPadding(View view2, int i, float f, float f2, float f3, float f4, int i2) {
        double ceil;
        int i3;
        double ceil2;
        int i4;
        double ceil3;
        int i5;
        double ceil4;
        int i6;
        if (view2 != null) {
            float scaledSize = FontSizeHelper.getScaledSize(i, f);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    } else {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    }
                    float scaledSize2 = FontSizeHelper.getScaledSize(i, f2);
                    if (i2 == 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                i4 = MathKt__MathJVMKt.roundToInt(scaledSize2);
                            } else {
                                i4 = MathKt__MathJVMKt.roundToInt(scaledSize2);
                            }
                            float scaledSize3 = FontSizeHelper.getScaledSize(i, f3);
                            if (i2 != 0) {
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        i5 = MathKt__MathJVMKt.roundToInt(scaledSize3);
                                    } else {
                                        i5 = MathKt__MathJVMKt.roundToInt(scaledSize3);
                                    }
                                    float scaledSize4 = FontSizeHelper.getScaledSize(i, f4);
                                    if (i2 == 0) {
                                        if (i2 != 1) {
                                            if (i2 != 2) {
                                                i6 = MathKt__MathJVMKt.roundToInt(scaledSize4);
                                            } else {
                                                i6 = MathKt__MathJVMKt.roundToInt(scaledSize4);
                                            }
                                            view2.setPadding(i3, i4, i5, i6);
                                        }
                                        ceil4 = Math.floor(scaledSize4);
                                    } else {
                                        ceil4 = Math.ceil(scaledSize4);
                                    }
                                    i6 = (int) ceil4;
                                    view2.setPadding(i3, i4, i5, i6);
                                }
                                ceil3 = Math.floor(scaledSize3);
                            } else {
                                ceil3 = Math.ceil(scaledSize3);
                            }
                            i5 = (int) ceil3;
                            float scaledSize42 = FontSizeHelper.getScaledSize(i, f4);
                            if (i2 == 0) {
                            }
                            i6 = (int) ceil4;
                            view2.setPadding(i3, i4, i5, i6);
                        }
                        ceil2 = Math.floor(scaledSize2);
                    } else {
                        ceil2 = Math.ceil(scaledSize2);
                    }
                    i4 = (int) ceil2;
                    float scaledSize32 = FontSizeHelper.getScaledSize(i, f3);
                    if (i2 != 0) {
                    }
                    i5 = (int) ceil3;
                    float scaledSize422 = FontSizeHelper.getScaledSize(i, f4);
                    if (i2 == 0) {
                    }
                    i6 = (int) ceil4;
                    view2.setPadding(i3, i4, i5, i6);
                }
                ceil = Math.floor(scaledSize);
            } else {
                ceil = Math.ceil(scaledSize);
            }
            i3 = (int) ceil;
            float scaledSize22 = FontSizeHelper.getScaledSize(i, f2);
            if (i2 == 0) {
            }
            i4 = (int) ceil2;
            float scaledSize322 = FontSizeHelper.getScaledSize(i, f3);
            if (i2 != 0) {
            }
            i5 = (int) ceil3;
            float scaledSize4222 = FontSizeHelper.getScaledSize(i, f4);
            if (i2 == 0) {
            }
            i6 = (int) ceil4;
            view2.setPadding(i3, i4, i5, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void setScaledSize(View view2, int i, float f, float f2, int i2) {
        ViewGroup.LayoutParams layoutParams;
        double ceil;
        int i3;
        double ceil2;
        int i4;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
            float scaledSize = FontSizeHelper.getScaledSize(i, f);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    } else {
                        i3 = MathKt__MathJVMKt.roundToInt(scaledSize);
                    }
                    layoutParams.width = i3;
                    float scaledSize2 = FontSizeHelper.getScaledSize(i, f2);
                    if (i2 == 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                i4 = MathKt__MathJVMKt.roundToInt(scaledSize2);
                            } else {
                                i4 = MathKt__MathJVMKt.roundToInt(scaledSize2);
                            }
                            layoutParams.height = i4;
                            view2.setLayoutParams(layoutParams);
                        }
                        ceil2 = Math.floor(scaledSize2);
                    } else {
                        ceil2 = Math.ceil(scaledSize2);
                    }
                    i4 = (int) ceil2;
                    layoutParams.height = i4;
                    view2.setLayoutParams(layoutParams);
                }
                ceil = Math.floor(scaledSize);
            } else {
                ceil = Math.ceil(scaledSize);
            }
            i3 = (int) ceil;
            layoutParams.width = i3;
            float scaledSize22 = FontSizeHelper.getScaledSize(i, f2);
            if (i2 == 0) {
            }
            i4 = (int) ceil2;
            layoutParams.height = i4;
            view2.setLayoutParams(layoutParams);
        }
    }

    @JvmOverloads
    public static final void setScaledSizeRes(View view2, int i, @DimenRes int i2, @DimenRes int i3, int i4) {
        setScaledSize(view2, i, ResUtil.getDimenByResId(i2), ResUtil.getDimenByResId(i3), i4);
    }
}
