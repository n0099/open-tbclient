package com.baidu.swan.apps.media.a.b;

import android.telephony.PhoneStateListener;
import android.util.Log;
/* loaded from: classes3.dex */
public class a extends PhoneStateListener {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        switch (i) {
            case 0:
                com.baidu.swan.apps.media.a.c.a.auh().auj();
                if (DEBUG) {
                    Log.i("PhoneStateListener", "挂断");
                    return;
                }
                return;
            case 1:
                com.baidu.swan.apps.media.a.c.a.auh().aui();
                if (DEBUG) {
                    Log.i("PhoneStateListener", "响铃:" + str);
                    return;
                }
                return;
            case 2:
                com.baidu.swan.apps.media.a.c.a.auh().aui();
                if (DEBUG) {
                    Log.i("PhoneStateListener", "接听");
                    return;
                }
                return;
            default:
                if (DEBUG) {
                    Log.e("PhoneStateListener", "invalid state");
                    return;
                }
                return;
        }
    }
}
