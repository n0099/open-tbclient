package com.baidu.ar.arplay.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.ar.arplay.c.e;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class d extends BroadcastReceiver {
    private static e.a gp;
    private static BroadcastReceiver gr;
    private static final String TAG = d.class.getSimpleName();
    private static boolean go = false;
    private static ArrayList<a> gq = new ArrayList<>();

    public static void a(a aVar) {
        if (gq == null) {
            gq = new ArrayList<>();
        }
        gq.add(aVar);
    }

    public static void b(a aVar) {
        if (gq == null || !gq.contains(aVar)) {
            return;
        }
        gq.remove(aVar);
    }

    private static BroadcastReceiver be() {
        if (gr == null) {
            synchronized (d.class) {
                if (gr == null) {
                    gr = new d();
                }
            }
        }
        return gr;
    }

    public static boolean bf() {
        return go;
    }

    private void bg() {
        if (gq.isEmpty()) {
            return;
        }
        int size = gq.size();
        for (int i = 0; i < size; i++) {
            a aVar = gq.get(i);
            if (aVar != null) {
                if (bf()) {
                    aVar.a(gp);
                } else {
                    aVar.aN();
                }
            }
        }
    }

    public static void d(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(be(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        gr = this;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) || "com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            if (e.e(context)) {
                Log.e(getClass().getName(), "<--- network connected --->");
                go = true;
                gp = e.f(context);
            } else {
                Log.e(getClass().getName(), "<--- network disconnected --->");
                go = false;
            }
            bg();
        }
    }
}
