package com.baidu.android.ext.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import com.baidu.searchbox.widget.ImmersionHelper;
/* loaded from: classes11.dex */
public class BaseDialog extends Dialog {
    private boolean mImmersionEnabled;

    public BaseDialog(@NonNull Context context) {
        super(context);
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
    }

    public BaseDialog(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION;
    }

    public void setEnableImmersion(boolean z) {
        this.mImmersionEnabled = ImmersionHelper.SUPPORT_IMMERSION && z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.mImmersionEnabled) {
            ImmersionHelper.setDialogImmersion(this);
        }
        super.show();
    }
}
