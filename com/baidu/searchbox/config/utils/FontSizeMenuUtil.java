package com.baidu.searchbox.config.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/config/utils/FontSizeMenuUtil;", "", "()V", "showFontSizeMenu", "", "activity", "Landroid/app/Activity;", "showFontSizeToastMenu", "context", "Landroid/content/Context;", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontSizeMenuUtil {
    public static final FontSizeMenuUtil INSTANCE = new FontSizeMenuUtil();

    @JvmStatic
    public static final void showFontSizeMenu(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            FontSizeRuntime.getFontSizeBusiness().showFontSizeMenu(activity);
        }
    }

    public final void showFontSizeToastMenu(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FontSizeRuntime.getFontSizeBusiness().showFontMenu(context);
    }
}
