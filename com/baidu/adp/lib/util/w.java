package com.baidu.adp.lib.util;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class w {
    private static Field RR;
    private static Field RT;

    static {
        try {
            if (Build.VERSION.SDK_INT < 28) {
                RR = Toast.class.getDeclaredField("mTN");
                RR.setAccessible(true);
                RT = RR.getType().getDeclaredField("mHandler");
                RT.setAccessible(true);
            }
        } catch (Exception e) {
        }
    }

    public static void b(Toast toast) {
        Object obj;
        Handler handler;
        try {
            if (Build.VERSION.SDK_INT < 28 && RR != null && RT != null && (obj = RR.get(toast)) != null && (handler = (Handler) RT.get(obj)) != null) {
                RT.set(obj, new a(handler));
            }
        } catch (Exception e) {
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Handler {
        private Handler RU;

        public a(Handler handler) {
            this.RU = handler;
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
                if (this.RU != null) {
                    this.RU.handleMessage(message);
                }
            } catch (Exception e) {
            }
        }
    }
}
