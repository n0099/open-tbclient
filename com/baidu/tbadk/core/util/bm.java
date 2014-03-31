package com.baidu.tbadk.core.util;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bm implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
