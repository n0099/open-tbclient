package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Pg;
    private static Field Ph;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Pg = Toast.class.getDeclaredField("mTN");
                Pg.setAccessible(true);
                Ph = Pg.getType().getDeclaredField("mHandler");
                Ph.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Pg != null && Ph != null && (obj = Pg.get(toast)) != null && (handler = (Handler) Ph.get(obj)) != null) {
                Ph.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Pi;

        public a(Handler handler) {
            this.Pi = handler;
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
                if (this.Pi != null) {
                    this.Pi.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
