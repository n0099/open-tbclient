package com.baidu.lightapp.plugin.videoplayer.coreplayer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageButton;
/* loaded from: classes.dex */
class DrawableStyle extends ImageButton {
    public DrawableStyle(Context context) {
        super(context);
    }

    public StateListDrawable getStateListDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawable3);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawable2);
        stateListDrawable.addState(View.ENABLED_STATE_SET, drawable);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, drawable2);
        stateListDrawable.addState(View.EMPTY_STATE_SET, drawable);
        return stateListDrawable;
    }

    public StateListDrawable getStateListDrawable(Integer[] numArr) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getResources().getDrawable(numArr[0].intValue());
        Drawable drawable2 = getResources().getDrawable(numArr[1].intValue());
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, getResources().getDrawable(numArr[2].intValue()));
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawable2);
        stateListDrawable.addState(View.ENABLED_STATE_SET, drawable);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, drawable2);
        stateListDrawable.addState(View.EMPTY_STATE_SET, drawable);
        return stateListDrawable;
    }
}
