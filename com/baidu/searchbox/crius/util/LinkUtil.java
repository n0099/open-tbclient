package com.baidu.searchbox.crius.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.IntentConstants;
/* loaded from: classes3.dex */
public class LinkUtil {
    public static boolean dealLink(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.startActivity(new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str)));
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
