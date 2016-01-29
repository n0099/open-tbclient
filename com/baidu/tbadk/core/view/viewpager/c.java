package com.baidu.tbadk.core.view.viewpager;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Handler.Callback {
    final /* synthetic */ b aij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aij = bVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.aij.xr();
                return false;
            default:
                return false;
        }
    }
}
