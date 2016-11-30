package com.baidu.tbadk.core.view.viewpager;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class c implements Handler.Callback {
    final /* synthetic */ b aiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aiP = bVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.aiP.wY();
                return false;
            default:
                return false;
        }
    }
}
