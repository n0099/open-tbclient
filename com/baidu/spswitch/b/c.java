package com.baidu.spswitch.b;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.baidu.spswitch.emotion.EmotionType;
/* loaded from: classes13.dex */
public class c {

    /* loaded from: classes13.dex */
    public interface a {
        void onClickSwitch(View view, boolean z);
    }

    public static void a(Window window, final View view, final View view2, final View view3, final a aVar) {
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.spswitch.b.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view4) {
                    if (com.baidu.spswitch.emotion.b.bb(view2.getContext()).a(EmotionType.EMOTION_CLASSIC_TYPE)) {
                        boolean c = c.c(view, view3);
                        if (aVar != null) {
                            aVar.onClickSwitch(view4, c);
                        }
                    }
                }
            });
        }
        if (bf(view.getContext())) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.spswitch.b.c.2
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

    public static boolean c(View view, View view2) {
        boolean z = view.getVisibility() != 0;
        if (!z) {
            d(view, view2);
        } else {
            e(view, view2);
        }
        return z;
    }

    public static void d(View view, View view2) {
        e.Z(view2);
        if (bf(view.getContext())) {
            view.setVisibility(4);
        }
    }

    public static void e(View view, View view2) {
        view.setVisibility(0);
        if (view2 != null) {
            e.aa(view2);
        }
    }

    public static void f(View view, View view2) {
        if (view2 != null) {
            e.aa(view2);
            view2.clearFocus();
        }
        view.setVisibility(8);
    }

    public static boolean bR(boolean z) {
        return z;
    }

    public static boolean bf(Context context) {
        if (context instanceof Activity) {
            return bR(g.isFullScreen((Activity) context));
        }
        return false;
    }
}
