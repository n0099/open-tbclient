package com.baidu.tbadk.core.view.viewpager;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Handler.Callback {
    final /* synthetic */ d ahy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ahy = dVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.ahy.wd();
                return false;
            default:
                return false;
        }
    }
}
