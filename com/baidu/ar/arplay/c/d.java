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
    private static e.a fR;
    private static volatile BroadcastReceiver fT;
    private static final String TAG = d.class.getSimpleName();
    private static boolean fQ = false;
    private static ArrayList<a> fS = new ArrayList<>();

    public static void a(a aVar) {
        if (fS == null) {
            fS = new ArrayList<>();
        }
        fS.add(aVar);
    }

    public static void b(a aVar) {
        if (fS == null || !fS.contains(aVar)) {
            return;
        }
        fS.remove(aVar);
    }

    private static BroadcastReceiver bj() {
        if (fT == null) {
            synchronized (d.class) {
                if (fT == null) {
                    fT = new d();
                }
            }
        }
        return fT;
    }

    public static boolean bk() {
        return fQ;
    }

    private void bl() {
        if (fS.isEmpty()) {
            return;
        }
        int size = fS.size();
        for (int i = 0; i < size; i++) {
            a aVar = fS.get(i);
            if (aVar != null) {
                if (bk()) {
                    aVar.a(fR);
                } else {
                    aVar.aM();
                }
            }
        }
    }

    public static void e(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(bj(), intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        fT = this;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction()) || "com.baidu.ar.baiduarsdk.CONNECTIVITY_CHANGE".equalsIgnoreCase(intent.getAction())) {
            if (e.f(context)) {
                Log.e(getClass().getName(), "<--- network connected --->");
                fQ = true;
                fR = e.g(context);
            } else {
                Log.e(getClass().getName(), "<--- network disconnected --->");
                fQ = false;
            }
            bl();
        }
    }
}
