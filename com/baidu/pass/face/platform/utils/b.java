package com.baidu.pass.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;
/* loaded from: classes3.dex */
public final class b {
    public static long a = 0;
    public static final String b = "b";
    public static b e;
    public SoundPool c = new SoundPool(5, 3, 0);
    public SparseIntArray d = new SparseIntArray();

    public b() {
        a = 0L;
    }

    public static void a() {
        try {
            if (e != null) {
                int size = e.d.size();
                for (int i = 0; i < size; i++) {
                    e.c.unload(e.d.valueAt(i));
                }
                e.c.release();
                e.c = null;
                e.d.clear();
                e.d = null;
                e = null;
            }
            a = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, int i) {
        if (e == null) {
            e = new b();
        }
        try {
            int i2 = e.d.get(i);
            if (i2 == 0) {
                final int load = e.c.load(context, i, 1);
                e.d.put(i, load);
                e.c.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.baidu.pass.face.platform.utils.b.1
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public void onLoadComplete(SoundPool soundPool, int i3, int i4) {
                        if (i4 == 0 && load == i3) {
                            try {
                                b.a = System.currentTimeMillis();
                                b.e.c.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            try {
                e.c.play(i2, 1.0f, 1.0f, 5, 0, 1.0f);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
