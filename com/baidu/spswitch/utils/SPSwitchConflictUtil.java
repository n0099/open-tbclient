package com.baidu.spswitch.utils;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
/* loaded from: classes2.dex */
public class SPSwitchConflictUtil {

    /* loaded from: classes2.dex */
    public interface SwitchClickListener {
        void onClickSwitch(View view, boolean z);
    }

    public static void attach(Window window, final View view, View view2, final View view3, final SwitchClickListener switchClickListener) {
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.spswitch.utils.SPSwitchConflictUtil.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    boolean switchPanelAndSoftInput = SPSwitchConflictUtil.switchPanelAndSoftInput(view, view3);
                    SwitchClickListener switchClickListener2 = switchClickListener;
                    if (switchClickListener2 != null) {
                        switchClickListener2.onClickSwitch(view4, switchPanelAndSoftInput);
                    }
                }
            });
        }
        if (isHandleByPlaceholder(view.getContext())) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.spswitch.utils.SPSwitchConflictUtil.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view4, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        view.setVisibility(4);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    public static void hidePanelAndSoftInput(View view, View view2) {
        if (view2 != null) {
            SoftInputUtil.hideSoftInput(view2);
            view2.clearFocus();
        }
        view.setVisibility(8);
    }

    public static boolean isHandleByPlaceholder(Context context) {
        if (context instanceof Activity) {
            return isHandleByPlaceholder(ViewUtil.isFullScreen((Activity) context));
        }
        return false;
    }

    public static boolean isHandleByPlaceholder(boolean z) {
        return z;
    }

    public static boolean showPanel(View view, View view2) {
        if (EmotionUtils.getInstance().isEmotionLoaded(EmotionType.EMOTION_CLASSIC_TYPE)) {
            view.setVisibility(0);
            if (view2 != null) {
                SoftInputUtil.hideSoftInput(view2);
                return true;
            }
            return true;
        }
        return false;
    }

    public static void showSoftInput(View view, View view2) {
        SoftInputUtil.showSoftInput(view2);
        if (isHandleByPlaceholder(view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static boolean switchPanelAndSoftInput(View view, View view2) {
        boolean z = view.getVisibility() != 0;
        if (z) {
            return showPanel(view, view2) ? z : !z;
        }
        showSoftInput(view, view2);
        return z;
    }
}
