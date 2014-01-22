package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
/* loaded from: classes.dex */
class i {
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.a = intentFilter;
        this.b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.b);
        sb.append(" filter=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}
