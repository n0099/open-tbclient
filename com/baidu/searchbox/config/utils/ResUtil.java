package com.baidu.searchbox.config.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\t\u0010\n\u001a\u00020\u000bH\u0087\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/config/utils/ResUtil;", "", "()V", "getDimenByResId", "", "resId", "", "getDimenPxByResId", "getDrawableByResId", "Landroid/graphics/drawable/Drawable;", "getGlobalContext", "Landroid/content/Context;", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResUtil {
    public static final ResUtil INSTANCE = new ResUtil();

    @JvmStatic
    public static final Context getGlobalContext() {
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        return appContext;
    }

    @JvmStatic
    public static final float getDimenByResId(@DimenRes int i) {
        return AppRuntime.getAppContext().getResources().getDimension(i);
    }

    @JvmStatic
    public static final int getDimenPxByResId(@DimenRes int i) {
        return AppRuntime.getAppContext().getResources().getDimensionPixelSize(i);
    }

    @JvmStatic
    public static final Drawable getDrawableByResId(@DrawableRes int i) {
        return AppRuntime.getAppContext().getResources().getDrawable(i);
    }
}
