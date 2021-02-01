package b.a.a.a.a;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class r extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private long f1073a = 0;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ p f1074b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.f1074b = pVar;
    }

    @Override // android.content.BroadcastReceiver
    @SuppressLint({"MissingPermission"})
    public final void onReceive(Context context, Intent intent) {
        w wVar;
        s sVar;
        if (intent == null) {
            return;
        }
        try {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            StringBuilder sb = new StringBuilder("Network:");
            wVar = this.f1074b.AA;
            String sb2 = sb.append(wVar.d()).toString();
            if (booleanExtra) {
                new StringBuilder().append(sb2).append(" not found");
                return;
            }
            if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
                new StringBuilder().append(sb2).append(" disconnected");
                return;
            }
            new StringBuilder().append(sb2).append(" connected");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f1073a > 1000) {
                sVar = this.f1074b.Ay;
                p.a(sVar, 2001, null, 1000L);
                this.f1073a = currentTimeMillis;
            }
        } catch (Throwable th) {
        }
    }
}
