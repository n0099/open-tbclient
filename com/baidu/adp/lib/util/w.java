package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Qx;
    private static Field Qy;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Qx = Toast.class.getDeclaredField("mTN");
                Qx.setAccessible(true);
                Qy = Qx.getType().getDeclaredField("mHandler");
                Qy.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Qx != null && Qy != null && (obj = Qx.get(toast)) != null && (handler = (Handler) Qy.get(obj)) != null) {
                Qy.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Qz;

        public a(Handler handler) {
            this.Qz = handler;
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
                if (this.Qz != null) {
                    this.Qz.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
