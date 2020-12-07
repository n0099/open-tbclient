package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Qw;
    private static Field Qx;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Qw = Toast.class.getDeclaredField("mTN");
                Qw.setAccessible(true);
                Qx = Qw.getType().getDeclaredField("mHandler");
                Qx.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Qw != null && Qx != null && (obj = Qw.get(toast)) != null && (handler = (Handler) Qx.get(obj)) != null) {
                Qx.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Qy;

        public a(Handler handler) {
            this.Qy = handler;
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
                if (this.Qy != null) {
                    this.Qy.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
