package com.baidu.searchbox.floating.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.floating.config.Config;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u0000B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bC\u0010DJ'\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010.R\u0016\u00102\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u001d\u0010<\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010;R\u001d\u0010?\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010)\u001a\u0004\b>\u0010;R\u001d\u0010B\u001a\u00020\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010)\u001a\u0004\bA\u0010;¨\u0006E"}, d2 = {"Lcom/baidu/searchbox/floating/utils/TouchHelper;", "", "originX", "width", "dx", "calculateX", "(III)I", "originY", "dy", "calculateY", "(II)I", "", "hasStatusBar", "()Z", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/MotionEvent;", "event", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager$LayoutParams;", "params", "", MissionEvent.MESSAGE_TOUCH, "(Landroid/view/View;Landroid/view/MotionEvent;Landroid/view/WindowManager;Landroid/view/WindowManager$LayoutParams;)V", "recordLocation", "(Landroid/view/MotionEvent;)V", "updateDisplayInfo", "(Landroid/view/WindowManager;)V", "Lcom/baidu/searchbox/floating/config/Config;", "config", "Lcom/baidu/searchbox/floating/config/Config;", "getConfig", "()Lcom/baidu/searchbox/floating/config/Config;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/graphics/Rect;", "mBlockOffset$delegate", "Lkotlin/Lazy;", "getMBlockOffset", "()Landroid/graphics/Rect;", "mBlockOffset", "mDisplayHeight", "I", "mDisplayRect", "Landroid/graphics/Rect;", "mDisplayWidth", "mEmptyHeight", "mHasStatusBar", "Z", "", "mLastX", "F", "mLastY", "mScreenHeight$delegate", "getMScreenHeight", "()I", "mScreenHeight", "mTouchSlop$delegate", "getMTouchSlop", "mTouchSlop", "navigationBarHeight$delegate", "getNavigationBarHeight", "navigationBarHeight", "<init>", "(Landroid/content/Context;Lcom/baidu/searchbox/floating/config/Config;)V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class TouchHelper {
    public final Config config;
    public final Context context;
    public final Lazy mBlockOffset$delegate;
    public int mDisplayHeight;
    public Rect mDisplayRect;
    public int mDisplayWidth;
    public int mEmptyHeight;
    public boolean mHasStatusBar;
    public float mLastX;
    public float mLastY;
    public final Lazy mScreenHeight$delegate;
    public final Lazy mTouchSlop$delegate;
    public final Lazy navigationBarHeight$delegate;

    private final Rect getMBlockOffset() {
        return (Rect) this.mBlockOffset$delegate.getValue();
    }

    private final int getMScreenHeight() {
        return ((Number) this.mScreenHeight$delegate.getValue()).intValue();
    }

    private final int getMTouchSlop() {
        return ((Number) this.mTouchSlop$delegate.getValue()).intValue();
    }

    private final int getNavigationBarHeight() {
        return ((Number) this.navigationBarHeight$delegate.getValue()).intValue();
    }

    public TouchHelper(Context context, Config config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.context = context;
        this.config = config;
        this.mDisplayRect = new Rect();
        this.mScreenHeight$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$mScreenHeight$2
            {
                super(0);
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return UtilsKt.getScreenHeight(TouchHelper.this.getContext());
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }
        });
        this.navigationBarHeight$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$navigationBarHeight$2
            {
                super(0);
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return UtilsKt.getNavBarHeight(TouchHelper.this.getContext());
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }
        });
        this.mTouchSlop$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$mTouchSlop$2
            {
                super(0);
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(TouchHelper.this.getContext());
                Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
                return viewConfiguration.getScaledTouchSlop();
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }
        });
        this.mHasStatusBar = true;
        this.mBlockOffset$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Rect>() { // from class: com.baidu.searchbox.floating.utils.TouchHelper$mBlockOffset$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                return new Rect(UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().left), UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().top), UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().right), UtilsKt.dpToPxByScale(TouchHelper.this.getContext(), TouchHelper.this.getConfig().getBlockOffset().bottom));
            }
        });
    }

    private final int calculateX(int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = getMBlockOffset().left;
        int i6 = (this.mDisplayWidth - i2) - getMBlockOffset().right;
        if (i4 < i5) {
            return i5;
        }
        if (i4 > i6) {
            return i6;
        }
        return i4;
    }

    private final int calculateY(int i, int i2) {
        int i3 = i + i2;
        int i4 = getMBlockOffset().top;
        int i5 = this.mEmptyHeight - getMBlockOffset().bottom;
        if (i3 < i4) {
            return i4;
        }
        if (i3 > i5) {
            return i5;
        }
        return i3;
    }

    private final boolean hasStatusBar() {
        if (this.mDisplayHeight != getMScreenHeight() && this.mDisplayHeight + getNavigationBarHeight() != getMScreenHeight()) {
            return false;
        }
        return true;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final Context getContext() {
        return this.context;
    }

    private final void recordLocation(MotionEvent motionEvent) {
        this.mLastX = motionEvent.getRawX();
        this.mLastY = motionEvent.getRawY();
    }

    private final void updateDisplayInfo(WindowManager windowManager) {
        windowManager.getDefaultDisplay().getRectSize(this.mDisplayRect);
        this.mDisplayWidth = this.mDisplayRect.width();
        this.mDisplayHeight = this.mDisplayRect.height();
    }

    public final void onTouch(View view2, MotionEvent event, WindowManager windowManager, WindowManager.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.config.getCanDrag() && !this.config.isAnimating()) {
            int action = event.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        return;
                    }
                    float rawX = event.getRawX() - this.mLastX;
                    float rawY = event.getRawY() - this.mLastY;
                    if (!this.config.isDragging() && (rawX * rawX) + (rawY * rawY) < getMTouchSlop()) {
                        return;
                    }
                    this.config.setDragging(true);
                    params.x = calculateX(params.x, view2.getWidth(), (int) rawX);
                    params.y = calculateY(params.y, (int) rawY);
                    windowManager.updateViewLayout(view2, params);
                    recordLocation(event);
                    return;
                }
                this.config.setDragging(false);
                return;
            }
            this.config.setDragging(false);
            recordLocation(event);
            updateDisplayInfo(windowManager);
            this.mHasStatusBar = hasStatusBar();
            this.mEmptyHeight = this.mDisplayHeight - view2.getHeight();
            return;
        }
        this.config.setDragging(false);
    }
}
