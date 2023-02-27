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
    public static int c = 255;

    public SelectorImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    Log.d("ACTION_UP", "ACTION_UP");
                    setImageAlpha(c);
                }
            } else {
                Log.d("ACTION_DOWN", "ACTION_DOWN");
                setImageAlpha(76);
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
            setImageAlpha(c);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    Log.d("ACTION_UP", "ACTION_UP");
                    if (view2 instanceof ImageView) {
                        ((ImageView) view2).setImageAlpha(255);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            Log.d("ACTION_DOWN", "ACTION_DOWN");
            if (view2 instanceof ImageView) {
                ((ImageView) view2).setImageAlpha(76);
                return false;
            }
            return false;
        }
    }

    public SelectorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SelectorImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static View.OnTouchListener getStaticOnTouchListener() {
        return new a();
    }
}
