package com.baidu.searchbox.ui.floatbar;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/ui/floatbar/BottomFloatButtonTouchStateListener;", "Landroid/view/View$OnTouchListener;", "()V", MissionEvent.MESSAGE_TOUCH, "", "touchedView", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "Companion", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomFloatButtonTouchStateListener implements View.OnTouchListener {
    public static final Companion Companion = new Companion(null);
    public static final float PRESSED_ALPHA_IN_DAY_MODE = 0.6f;
    public static final float PRESSED_ALPHA_IN_NIGHT_MODE = 0.7f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/ui/floatbar/BottomFloatButtonTouchStateListener$Companion;", "", "()V", "PRESSED_ALPHA_IN_DAY_MODE", "", "PRESSED_ALPHA_IN_NIGHT_MODE", "customs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        Integer num;
        float f;
        try {
            Result.Companion companion = Result.Companion;
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                if (NightModeHelper.getNightModeSwitcherState()) {
                    f = 0.7f;
                } else {
                    f = 0.6f;
                }
                if (view2 != null) {
                    view2.setAlpha(f);
                }
                Result.m850constructorimpl(Unit.INSTANCE);
                return false;
            }
            view2.setAlpha(1.0f);
            Result.m850constructorimpl(Unit.INSTANCE);
            return false;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m850constructorimpl(ResultKt.createFailure(th));
            return false;
        }
    }
}
