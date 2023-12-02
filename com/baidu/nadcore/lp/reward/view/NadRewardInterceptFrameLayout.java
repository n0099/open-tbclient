package com.baidu.nadcore.lp.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.tieba.w11;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006!"}, d2 = {"Lcom/baidu/nadcore/lp/reward/view/NadRewardInterceptFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", Config.EVENT_PART, "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "enable", "", "setEnableIntercept", "(Z)V", "Lkotlin/Function0;", "action", "setInterceptCallback", "(Lkotlin/Function0;)V", "enableIntercept", "Z", "intercept", "interceptCallback", "Lkotlin/Function0;", "", "scrollThreshold", "F", "startX", "startY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadRewardInterceptFrameLayout extends FrameLayout {
    public float a;
    public float b;
    public boolean c;
    public Function0<Unit> d;
    public boolean e;
    public final float f;

    @JvmOverloads
    public NadRewardInterceptFrameLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadRewardInterceptFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadRewardInterceptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = w11.c.f(context) / 4.0f;
    }

    public /* synthetic */ NadRewardInterceptFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer num;
        Function0<Unit> function0;
        if (this.e && this.d != null) {
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                this.c = false;
                this.a = motionEvent.getRawX();
                this.b = motionEvent.getRawY();
            } else if (num != null && num.intValue() == 2) {
                float rawX = motionEvent.getRawX() - this.a;
                float rawY = motionEvent.getRawY() - this.b;
                if (rawY < 0 && Math.abs(rawY) > Math.abs(rawX) && Math.abs(rawY) >= this.f) {
                    this.c = true;
                }
            } else if (num != null && num.intValue() == 1 && this.c && (function0 = this.d) != null && function0 != null) {
                function0.invoke();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setEnableIntercept(boolean z) {
        this.e = z;
    }

    public final void setInterceptCallback(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.d = action;
    }
}
