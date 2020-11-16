package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Py;
    private static Field Pz;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Py = Toast.class.getDeclaredField("mTN");
                Py.setAccessible(true);
                Pz = Py.getType().getDeclaredField("mHandler");
                Pz.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Py != null && Pz != null && (obj = Py.get(toast)) != null && (handler = (Handler) Pz.get(obj)) != null) {
                Pz.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler PD;

        public a(Handler handler) {
            this.PD = handler;
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
                if (this.PD != null) {
                    this.PD.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
