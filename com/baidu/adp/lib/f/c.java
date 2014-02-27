package com.baidu.adp.lib.f;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.e;
/* loaded from: classes.dex */
public final class c {
    public static boolean a(Context context, Intent intent) {
        try {
            context.startService(intent);
            return true;
        } catch (Exception e) {
            e.b(e.getMessage());
            return false;
        }
    }
}
