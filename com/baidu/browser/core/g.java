package com.baidu.browser.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LongSparseArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class g {
    private static g acp;
    private LongSparseArray<WeakReference<Bitmap>> acq = new LongSparseArray<>();
    private Context mContext;
    private static final String LOG_TAG = g.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> acr = new HashMap<>();

    private g() {
    }

    public static synchronized g rw() {
        g gVar;
        synchronized (g.class) {
            if (acp == null) {
                acp = new g();
            }
            gVar = acp;
        }
        return gVar;
    }

    private Context getContext() {
        if (this.mContext == null) {
            this.mContext = BdCore.rp().getContext();
        }
        if (this.mContext == null) {
            throw new RuntimeException("context is null!");
        }
        return this.mContext;
    }

    @Deprecated
    public static int M(String str, String str2) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        N(str2, str);
        com.baidu.browser.core.util.e<String, Integer> eVar2 = acr.get(str);
        if (eVar2 == null) {
            com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
            acr.put(str, eVar3);
            eVar = eVar3;
        } else {
            eVar = eVar2;
        }
        Integer num = eVar.get(str2);
        if (num == null) {
            try {
                int identifier = rw().getContext().getResources().getIdentifier(str2, str, rw().getContext().getPackageName());
                eVar.put(str2, Integer.valueOf(identifier));
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

    public static void N(String str, String str2) {
    }
}
