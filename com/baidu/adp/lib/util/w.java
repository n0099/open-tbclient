package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Oh;
    private static Field Oi;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Oh = Toast.class.getDeclaredField("mTN");
                Oh.setAccessible(true);
                Oi = Oh.getType().getDeclaredField("mHandler");
                Oi.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Oh != null && Oi != null && (obj = Oh.get(toast)) != null && (handler = (Handler) Oi.get(obj)) != null) {
                Oi.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Oj;

        public a(Handler handler) {
            this.Oj = handler;
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
                if (this.Oj != null) {
                    this.Oj.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
