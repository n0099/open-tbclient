package com.baidu.tbadk.core.util;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bm implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
