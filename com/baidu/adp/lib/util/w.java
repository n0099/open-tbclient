package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field ND;
    private static Field NF;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                ND = Toast.class.getDeclaredField("mTN");
                ND.setAccessible(true);
                NF = ND.getType().getDeclaredField("mHandler");
                NF.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && ND != null && NF != null && (obj = ND.get(toast)) != null && (handler = (Handler) NF.get(obj)) != null) {
                NF.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler NG;

        public a(Handler handler) {
            this.NG = handler;
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
                if (this.NG != null) {
                    this.NG.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
