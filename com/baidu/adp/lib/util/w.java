package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Pw;
    private static Field Px;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Pw = Toast.class.getDeclaredField("mTN");
                Pw.setAccessible(true);
                Px = Pw.getType().getDeclaredField("mHandler");
                Px.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Pw != null && Px != null && (obj = Pw.get(toast)) != null && (handler = (Handler) Px.get(obj)) != null) {
                Px.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Py;

        public a(Handler handler) {
            this.Py = handler;
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
                if (this.Py != null) {
                    this.Py.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
