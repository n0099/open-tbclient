package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field OM;
    private static Field OO;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                OM = Toast.class.getDeclaredField("mTN");
                OM.setAccessible(true);
                OO = OM.getType().getDeclaredField("mHandler");
                OO.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && OM != null && OO != null && (obj = OM.get(toast)) != null && (handler = (Handler) OO.get(obj)) != null) {
                OO.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler OP;

        public a(Handler handler) {
            this.OP = handler;
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
                if (this.OP != null) {
                    this.OP.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
