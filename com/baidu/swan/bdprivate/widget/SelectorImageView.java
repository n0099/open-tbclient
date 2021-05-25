package com.baidu.swan.bdprivate.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
/* loaded from: classes3.dex */
public class SelectorImageView extends BdBaseImageView {

    /* renamed from: g  reason: collision with root package name */
    public static int f11444g = 255;

    /* loaded from: classes3.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                Log.d("ACTION_DOWN", "ACTION_DOWN");
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageAlpha(76);
                    return false;
                }
                return false;
            } else if (action == 1 || action == 3) {
                Log.d("ACTION_UP", "ACTION_UP");
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageAlpha(255);
                    return false;
                }
                return false;
            } else {
                return false;
            }
        }
    }

    public SelectorImageView(Context context) {
        super(context);
    }

    public static View.OnTouchListener getStaticOnTouchListener() {
        return new a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                Log.d("ACTION_DOWN", "ACTION_DOWN");
                setImageAlpha(76);
            } else if (action == 1 || action == 3) {
                Log.d("ACTION_UP", "ACTION_UP");
                setImageAlpha(f11444g);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @Deprecated
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            setImageAlpha(255);
        } else {
            setImageAlpha(f11444g);
        }
    }

    public SelectorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelectorImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
