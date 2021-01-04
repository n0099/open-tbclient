package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field QB;
    private static Field Qz;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Qz = Toast.class.getDeclaredField("mTN");
                Qz.setAccessible(true);
                QB = Qz.getType().getDeclaredField("mHandler");
                QB.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && Qz != null && QB != null && (obj = Qz.get(toast)) != null && (handler = (Handler) QB.get(obj)) != null) {
                QB.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler QC;

        public a(Handler handler) {
            this.QC = handler;
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
                if (this.QC != null) {
                    this.QC.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
