package b.a.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import com.baidu.android.imsdk.mcast.McastConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class k extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ j f1063a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1063a = jVar;
    }

    private static void a(List list) {
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = ((ScanResult) it.next()).BSSID;
            if (str == null || str.equals("000000000000") || str.equals("00-00-00-00-00-00") || str.equals("00:00:00:00:00:00")) {
                it.remove();
            } else if (hashSet.contains(str)) {
                it.remove();
            } else {
                hashSet.add(str);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if (McastConfig.ACTION_WIFI_STATE_CHANGED.equals(action)) {
                this.f1063a.f();
            }
            if (McastConfig.ACTION_WIFI_STATE_CHANGED.equals(action) || "android.net.wifi.SCAN_RESULTS".equals(action)) {
                List b2 = j.b(this.f1063a.Bk.AX);
                if (b2 == null || b2.size() <= 0) {
                    this.f1063a.a(af.Bj);
                    return;
                }
                ArrayList arrayList = new ArrayList(b2);
                a(arrayList);
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList, this.f1063a);
                    j.a(this.f1063a, arrayList);
                }
            }
        } catch (Throwable th) {
        }
    }
}
