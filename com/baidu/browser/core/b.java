package com.baidu.browser.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LongSparseArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class b {
    private static b UH;
    private LongSparseArray<WeakReference<Bitmap>> UI = new LongSparseArray<>();
    private Context mContext;
    private static final String LOG_TAG = b.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.c<String, Integer>> UJ = new HashMap<>();

    private b() {
    }

    public static synchronized b qi() {
        b bVar;
        synchronized (b.class) {
            if (UH == null) {
                UH = new b();
            }
            bVar = UH;
        }
        return bVar;
    }

    private Context getContext() {
        if (this.mContext == null) {
            this.mContext = BdCore.qh().getContext();
        }
        if (this.mContext == null) {
            throw new RuntimeException("context is null!");
        }
        return this.mContext;
    }

    @Deprecated
    public static int R(String str, String str2) {
        com.baidu.browser.core.util.c<String, Integer> cVar;
        S(str2, str);
        com.baidu.browser.core.util.c<String, Integer> cVar2 = UJ.get(str);
        if (cVar2 == null) {
            com.baidu.browser.core.util.c<String, Integer> cVar3 = new com.baidu.browser.core.util.c<>(100);
            UJ.put(str, cVar3);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        Integer num = cVar.get(str2);
        if (num == null) {
            try {
                int identifier = qi().getContext().getResources().getIdentifier(str2, str, qi().getContext().getPackageName());
                cVar.put(str2, Integer.valueOf(identifier));
                return identifier;
            } catch (Error e) {
                e.printStackTrace();
                return 0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return num.intValue();
    }

    public static void S(String str, String str2) {
        String[] strArr = {"com.baidu.browser.sailor", "com.baidu.browser.blink"};
        boolean z = false;
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (className.startsWith(strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (!z) {
            throw new RuntimeException("Resource can not found! Don't use getIdentifier to get resource!!!");
        }
    }
}
