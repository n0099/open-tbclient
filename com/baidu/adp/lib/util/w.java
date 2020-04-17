package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Nr;
    private static Field Ns;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Nr = Toast.class.getDeclaredField("mTN");
                Nr.setAccessible(true);
                Ns = Nr.getType().getDeclaredField("mHandler");
                Ns.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Nr != null && Ns != null && (obj = Nr.get(toast)) != null && (handler = (Handler) Ns.get(obj)) != null) {
                Ns.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Nt;

        public a(Handler handler) {
            this.Nt = handler;
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
                if (this.Nt != null) {
                    this.Nt.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
