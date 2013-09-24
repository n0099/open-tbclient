package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    final IntentFilter f305a;
    final BroadcastReceiver b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f305a = intentFilter;
        this.b = broadcastReceiver;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
        sb.append("Receiver{");
        sb.append(this.b);
        sb.append(" filter=");
        sb.append(this.f305a);
        sb.append("}");
        return sb.toString();
    }
}
