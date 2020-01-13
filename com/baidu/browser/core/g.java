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
    private static g HR;
    private LongSparseArray<WeakReference<Bitmap>> HS = new LongSparseArray<>();
    private Context mContext;
    private static final String LOG_TAG = g.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> HU = new HashMap<>();

    private g() {
    }

    public static synchronized g mf() {
        g gVar;
        synchronized (g.class) {
            if (HR == null) {
                HR = new g();
            }
            gVar = HR;
        }
        return gVar;
    }

    private Context getContext() {
        if (this.mContext == null) {
            this.mContext = BdCore.lZ().getContext();
        }
        if (this.mContext == null) {
            throw new RuntimeException("context is null!");
        }
        return this.mContext;
    }

    @Deprecated
    public static int G(String str, String str2) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        H(str2, str);
        com.baidu.browser.core.util.e<String, Integer> eVar2 = HU.get(str);
        if (eVar2 == null) {
            com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
            HU.put(str, eVar3);
            eVar = eVar3;
        } else {
            eVar = eVar2;
        }
        Integer num = eVar.get(str2);
        if (num == null) {
            try {
                int identifier = mf().getContext().getResources().getIdentifier(str2, str, mf().getContext().getPackageName());
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

    public static void H(String str, String str2) {
    }
}
