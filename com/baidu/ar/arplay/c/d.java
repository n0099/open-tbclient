package com.baidu.ar.arplay.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.ar.arplay.c.e;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class d extends BroadcastReceiver {
    private static e.a fE;
    private static BroadcastReceiver fG;
    private static final String TAG = d.class.getSimpleName();
    private static boolean fD = false;
    private static ArrayList<a> fF = new ArrayList<>();

    public static void a(a aVar) {
        if (fF == null) {
            fF = new ArrayList<>();
        }
        fF.add(aVar);
    }

    public static void b(a aVar) {
        if (fF == null || !fF.contains(aVar)) {
            return;
        }
        fF.remove(aVar);
    }

    private static BroadcastReceiver bm() {
        if (fG == null) {
            synchronized (d.class) {
                if (fG == null) {
                    fG = new d();
                }
            }
        }
        return fG;
    }

    public static boolean bn() {
        return fD;
    }

    private void bo() {
        if (fF.isEmpty()) {
            return;
        }
        int size = fF.size();
        for (int i = 0; i < size; i++) {
            a aVar = fF.get(i);
            if (aVar != null) {
                if (bn()) {
                    aVar.a(fE);
                } else {
                    aVar.aL();
                }
            }
        }
    }

    public static void d(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(bm(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        fG = this;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) || "com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            if (e.e(context)) {
                Log.e(getClass().getName(), "<--- network connected --->");
                fD = true;
                fE = e.f(context);
            } else {
                Log.e(getClass().getName(), "<--- network disconnected --->");
                fD = false;
            }
            bo();
        }
    }
}
