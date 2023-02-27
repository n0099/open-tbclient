package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.crius.constants.NativeConstants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0017\u001a9\u0010\u0007\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\u0007\u0010\b\u001a9\u0010\t\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\n\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\n\u0010\b\u001a9\u0010\u000b\u001a\u00020\u0005*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\u000b\u0010\b\u001a9\u0010\r\u001a\u00020\f*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a,\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a,\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001e\u0010\u001d\u001a\u00020\u0005*\u00020\u00002\b\b\u0001\u0010\u001c\u001a\u00020\u001bH\u0086\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a9\u0010$\u001a\u00020\u0005\"\n\b\u0000\u0010 \u0018\u0001*\u00020\u001f*\u00020\u00002\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b!H\u0087\b¢\u0006\u0004\b#\u0010\b\u001a-\u0010$\u001a\u00020\u0005*\u00020\u00002\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00050\u0001¢\u0006\u0002\b!H\u0086\b¢\u0006\u0004\b$\u0010\b\u001a<\u0010)\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010%\u001a\u00020\u001b2\b\b\u0003\u0010&\u001a\u00020\u001b2\b\b\u0003\u0010'\u001a\u00020\u001b2\b\b\u0003\u0010(\u001a\u00020\u001bH\u0086\b¢\u0006\u0004\b)\u0010*\u001a<\u0010-\u001a\u00020\u0005*\u00020\u00002\b\b\u0003\u0010+\u001a\u00020\u001b2\b\b\u0003\u0010&\u001a\u00020\u001b2\b\b\u0003\u0010,\u001a\u00020\u001b2\b\b\u0003\u0010(\u001a\u00020\u001bH\u0087\b¢\u0006\u0004\b-\u0010*\"*\u00100\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103\"*\u00104\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00101\"\u0004\b5\u00103\"*\u00106\u001a\u00020.*\u00020\u00002\u0006\u0010/\u001a\u00020.8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00101\"\u0004\b7\u00103\"\u0018\u0010:\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b8\u00109\"\u0018\u0010<\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b;\u00109\"\u0018\u0010>\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b=\u00109\"\u0018\u0010@\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b?\u00109\"\u0018\u0010B\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bA\u00109\"\u0018\u0010D\u001a\u00020\u001b*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\bC\u00109¨\u0006E"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NativeConstants.TYPE_VIEW, "", "action", "doOnAttach", "(Landroid/view/View;Lkotlin/Function1;)V", "doOnDetach", "doOnLayout", "doOnNextLayout", "Landroidx/core/view/OneShotPreDrawListener;", "doOnPreDraw", "(Landroid/view/View;Lkotlin/Function1;)Landroidx/core/view/OneShotPreDrawListener;", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "drawToBitmap", "(Landroid/view/View;Landroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "", "delayInMillis", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "postDelayed", "(Landroid/view/View;JLkotlin/Function0;)Ljava/lang/Runnable;", "postOnAnimationDelayed", "", "size", "setPadding", "(Landroid/view/View;I)V", "Landroid/view/ViewGroup$LayoutParams;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "updateLayoutParamsTyped", "updateLayoutParams", "left", "top", "right", "bottom", "updatePadding", "(Landroid/view/View;IIII)V", "start", "end", "updatePaddingRelative", "", "value", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "getMarginBottom", "(Landroid/view/View;)I", "marginBottom", "getMarginEnd", "marginEnd", "getMarginLeft", "marginLeft", "getMarginRight", "marginRight", "getMarginStart", "marginStart", "getMarginTop", "marginTop", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ViewKt {
    public static final void doOnAttach(final View view2, final Function1<? super View, Unit> function1) {
        if (ViewCompat.isAttachedToWindow(view2)) {
            function1.invoke(view2);
        } else {
            view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view3) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view3) {
                    view2.removeOnAttachStateChangeListener(this);
                    function1.invoke(view3);
                }
            });
        }
    }

    public static final void doOnDetach(final View view2, final Function1<? super View, Unit> function1) {
        if (!ViewCompat.isAttachedToWindow(view2)) {
            function1.invoke(view2);
        } else {
            view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view3) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view3) {
                    view2.removeOnAttachStateChangeListener(this);
                    function1.invoke(view3);
                }
            });
        }
    }

    public static final void doOnLayout(View view2, final Function1<? super View, Unit> function1) {
        if (ViewCompat.isLaidOut(view2) && !view2.isLayoutRequested()) {
            function1.invoke(view2);
        } else {
            view2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view3.removeOnLayoutChangeListener(this);
                    Function1.this.invoke(view3);
                }
            });
        }
    }

    public static final void doOnNextLayout(View view2, final Function1<? super View, Unit> function1) {
        view2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view3.removeOnLayoutChangeListener(this);
                Function1.this.invoke(view3);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view2, final Function1<? super View, Unit> function1) {
        OneShotPreDrawListener add = OneShotPreDrawListener.add(view2, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(view2);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(add, "OneShotPreDrawListener.add(this) { action(this) }");
        return add;
    }

    public static final void setGone(View view2, boolean z) {
        int i;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view2.setVisibility(i);
    }

    public static final void setInvisible(View view2, boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        view2.setVisibility(i);
    }

    public static final void setPadding(View view2, @Px int i) {
        view2.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view2, boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view2.setVisibility(i);
    }

    public static final void updateLayoutParams(View view2, Function1<? super ViewGroup.LayoutParams, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            function1.invoke(layoutParams);
            view2.setLayoutParams(layoutParams);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @JvmName(name = "updateLayoutParamsTyped")
    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view2, Function1<? super T, Unit> function1) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        function1.invoke(layoutParams);
        view2.setLayoutParams(layoutParams);
    }

    public static final Bitmap drawToBitmap(View view2, Bitmap.Config config) {
        if (ViewCompat.isLaidOut(view2)) {
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), config);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-view2.getScrollX(), -view2.getScrollY());
            view2.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view2, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view2, config);
    }

    public static final int getMarginBottom(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginLeft(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return 0;
    }

    public static final int getMarginTop(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view2) {
        if (view2.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(View view2) {
        if (view2.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(View view2) {
        if (view2.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final Runnable postDelayed(View view2, long j, final Function0<Unit> function0) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        view2.postDelayed(runnable, j);
        return runnable;
    }

    @RequiresApi(16)
    public static final Runnable postOnAnimationDelayed(View view2, long j, final Function0<Unit> function0) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postOnAnimationDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        };
        view2.postOnAnimationDelayed(runnable, j);
        return runnable;
    }

    public static final void updatePadding(View view2, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        view2.setPadding(i, i2, i3, i4);
    }

    @RequiresApi(17)
    public static final void updatePaddingRelative(View view2, @Px int i, @Px int i2, @Px int i3, @Px int i4) {
        view2.setPaddingRelative(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePadding$default(View view2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view2.getPaddingLeft();
        }
        if ((i5 & 2) != 0) {
            i2 = view2.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view2.getPaddingRight();
        }
        if ((i5 & 8) != 0) {
            i4 = view2.getPaddingBottom();
        }
        view2.setPadding(i, i2, i3, i4);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view2, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view2.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view2.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view2.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view2.getPaddingBottom();
        }
        view2.setPaddingRelative(i, i2, i3, i4);
    }
}
