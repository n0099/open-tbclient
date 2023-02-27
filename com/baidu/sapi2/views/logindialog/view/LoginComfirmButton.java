package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class LoginComfirmButton extends TextView {
    public Context a;

    public LoginComfirmButton(Context context) {
        this(context, null);
    }

    public LoginComfirmButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoginComfirmButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        a();
    }

    private void a() {
        setBackground(this.a.getResources().getDrawable(R.drawable.selector_pass_quick_login_dialog_btn_bg));
    }
}
