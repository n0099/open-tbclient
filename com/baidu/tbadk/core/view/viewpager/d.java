package com.baidu.tbadk.core.view.viewpager;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class d implements Handler.Callback {
    final /* synthetic */ c ans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ans = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.ans.wM();
                return false;
            default:
                return false;
        }
    }
}
