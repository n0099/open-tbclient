package com.baidu.live.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends Dialog {
    public e(@NonNull Context context) {
        super(context, a.j.sdk_Transparent);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            getWindow().setFlags(8, 8);
            super.show();
            U(getWindow().getDecorView());
            getWindow().clearFlags(8);
            return;
        }
        super.show();
    }

    private void U(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5894);
        }
    }
}
