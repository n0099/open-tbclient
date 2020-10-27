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
    Rect bxA;
    private a bxz;

    /* loaded from: classes4.dex */
    public interface a {
        void cE(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bxA = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.bxz = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.bxA);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.bxA.top) - size;
        if (this.bxz != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > BdUtilHelper.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.bxz.cE(z);
                }
                z = false;
                this.bxz.cE(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.bxz.cE(z);
                }
                z = false;
                this.bxz.cE(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
