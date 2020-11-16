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
    private a bBZ;
    Rect bCa;

    /* loaded from: classes4.dex */
    public interface a {
        void cN(boolean z);
    }

    public LinearLayoutDetectsSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCa = new Rect();
    }

    public void setOnSoftKeyBoardShownListener(a aVar) {
        this.bBZ = aVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.bCa);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.bCa.top) - size;
        if (this.bBZ != null) {
            if (MenuKeyUtils.hasSmartBar()) {
                if (height > BdUtilHelper.dip2px(activity, 48.0f) + 128) {
                    z = true;
                    this.bBZ.cN(z);
                }
                z = false;
                this.bBZ.cN(z);
            } else {
                if (height > 128) {
                    z = true;
                    this.bBZ.cN(z);
                }
                z = false;
                this.bBZ.cN(z);
            }
        }
        super.onMeasure(i, i2);
    }
}
