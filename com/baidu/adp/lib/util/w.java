package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Px;
    private static Field Py;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Px = Toast.class.getDeclaredField("mTN");
                Px.setAccessible(true);
                Py = Px.getType().getDeclaredField("mHandler");
                Py.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Px != null && Py != null && (obj = Px.get(toast)) != null && (handler = (Handler) Py.get(obj)) != null) {
                Py.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Pz;

        public a(Handler handler) {
            this.Pz = handler;
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
                if (this.Pz != null) {
                    this.Pz.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
