package com.baidu.ar.arplay.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.ar.arplay.c.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d extends BroadcastReceiver {
    private static e.a gd;
    private static BroadcastReceiver gf;
    private static final String TAG = d.class.getSimpleName();
    private static boolean gc = false;
    private static ArrayList<a> ge = new ArrayList<>();

    public static void a(a aVar) {
        if (ge == null) {
            ge = new ArrayList<>();
        }
        ge.add(aVar);
    }

    private static BroadcastReceiver aQ() {
        if (gf == null) {
            synchronized (d.class) {
                if (gf == null) {
                    gf = new d();
                }
            }
        }
        return gf;
    }

    public static boolean aR() {
        return gc;
    }

    private void aS() {
        if (ge.isEmpty()) {
            return;
        }
        int size = ge.size();
        for (int i = 0; i < size; i++) {
            a aVar = ge.get(i);
            if (aVar != null) {
                if (aR()) {
                    aVar.a(gd);
                } else {
                    aVar.az();
                }
            }
        }
    }

    public static void b(a aVar) {
        if (ge == null || !ge.contains(aVar)) {
            return;
        }
        ge.remove(aVar);
    }

    public static void d(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(aQ(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        gf = this;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) || "com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            if (e.e(context)) {
                Log.e(getClass().getName(), "<--- network connected --->");
                gc = true;
                gd = e.f(context);
            } else {
                Log.e(getClass().getName(), "<--- network disconnected --->");
                gc = false;
            }
            aS();
        }
    }
}
