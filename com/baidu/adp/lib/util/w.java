package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field uh;
    private static Field uj;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                uh = Toast.class.getDeclaredField("mTN");
                uh.setAccessible(true);
                uj = uh.getType().getDeclaredField("mHandler");
                uj.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && uh != null && uj != null && (obj = uh.get(toast)) != null && (handler = (Handler) uj.get(obj)) != null) {
                uj.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler ul;

        public a(Handler handler) {
            this.ul = handler;
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
                if (this.ul != null) {
                    this.ul.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
