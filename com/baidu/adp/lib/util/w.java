package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field uC;
    private static Field uD;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                uC = Toast.class.getDeclaredField("mTN");
                uC.setAccessible(true);
                uD = uC.getType().getDeclaredField("mHandler");
                uD.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && uC != null && uD != null && (obj = uC.get(toast)) != null && (handler = (Handler) uD.get(obj)) != null) {
                uD.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler uE;

        public a(Handler handler) {
            this.uE = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.uE != null) {
                    this.uE.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
