package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {
    final /* synthetic */ d this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.this$0 = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            this.this$0.bM.a((KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        } catch (ClassCastException e) {
            Log.w("TransportController", e);
        }
    }
}
