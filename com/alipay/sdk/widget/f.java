package com.alipay.sdk.widget;

import android.content.DialogInterface;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnKeyListener {
    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }
}
