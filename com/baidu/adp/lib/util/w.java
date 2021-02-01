package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Qv;
    private static Field Qw;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Qv = Toast.class.getDeclaredField("mTN");
                Qv.setAccessible(true);
                Qw = Qv.getType().getDeclaredField("mHandler");
                Qw.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Qv != null && Qw != null && (obj = Qv.get(toast)) != null && (handler = (Handler) Qw.get(obj)) != null) {
                Qw.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Qx;

        public a(Handler handler) {
            this.Qx = handler;
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
                if (this.Qx != null) {
                    this.Qx.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
