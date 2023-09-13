package com.baidu.nadcore.crius.uiwidget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class JumpButton extends AppCompatTextView {
    public JumpButton(Context context) {
        super(context);
        d();
    }

    public JumpButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d();
    }

    public JumpButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d();
    }

    public final void d() {
        setGravity(17);
        setTextSize(getResources().getDimensionPixelSize(R.dimen.nad_dimens_12dp));
    }
}
