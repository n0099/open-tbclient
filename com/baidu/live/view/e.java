package com.baidu.live.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
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
            ac(getWindow().getDecorView());
            getWindow().clearFlags(8);
            return;
        }
        super.show();
    }

    private void ac(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5894);
        }
    }
}
