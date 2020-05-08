package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field Nv;
    private static Field Nw;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Nv = Toast.class.getDeclaredField("mTN");
                Nv.setAccessible(true);
                Nw = Nv.getType().getDeclaredField("mHandler");
                Nw.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Nv != null && Nw != null && (obj = Nv.get(toast)) != null && (handler = (Handler) Nw.get(obj)) != null) {
                Nw.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler Nx;

        public a(Handler handler) {
            this.Nx = handler;
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
                if (this.Nx != null) {
                    this.Nx.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
