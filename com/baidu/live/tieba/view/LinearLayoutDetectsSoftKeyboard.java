package com.baidu.live.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes4.dex */
public class LinearLayoutDetectsSoftKeyboard extends LinearLayout {
    private a brx;
    Rect bry;

    /* loaded from: classes4.dex */
    public interface a {
        void cv(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bry = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.brx = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.bry);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.bry.top) - size;
        if (this.brx != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > BdUtilHelper.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.brx.cv(z);
                }
                z = false;
                this.brx.cv(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.brx.cv(z);
                }
                z = false;
                this.brx.cv(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
