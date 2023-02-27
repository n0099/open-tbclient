package com.baidu.searchbox.crius.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class LinkUtil {
    public static boolean dealLink(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
