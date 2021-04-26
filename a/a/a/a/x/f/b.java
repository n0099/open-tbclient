package a.a.a.a.x.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a.a.a.a.x.d.a("onReceive:" + intent, new Object[0]);
        c.a(context, intent);
    }
}
