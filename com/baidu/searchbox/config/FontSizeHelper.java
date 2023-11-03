package com.baidu.searchbox.config;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import com.baidu.searchbox.config.utils.DisplayUtilsKt;
import com.baidu.searchbox.config.utils.FontSizeSharedPrefs;
import com.baidu.searchbox.config.utils.ReflectionUtil;
import com.baidu.searchbox.config.utils.ResUtil;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002lmB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u0004H\u0007J\\\u0010 \u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u0001H!2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u001e\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H!0$H\u0082\b¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0004H\u0007J\b\u0010'\u001a\u00020\u0004H\u0007J8\u0010(\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020\u001e2\u0006\u0010\"\u001a\u0002H!2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0004H\u0082\b¢\u0006\u0002\u0010,J)\u0010-\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ1\u00100\u001a\u0002012\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ&\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J5\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0082\bJ.\u0010:\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J7\u0010;\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0082\bJ.\u0010<\u001a\u0004\u0018\u0001052\u0006\u0010\u001a\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J&\u0010=\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J.\u0010>\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J7\u0010?\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0082\bJ5\u0010@\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0082\bJ&\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010B\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J$\u0010C\u001a\u00020D2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J.\u0010E\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J-\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ\u0010\u0010I\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0019\u0010I\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ\u001b\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0007H\u0007J\"\u0010L\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J\"\u0010M\u001a\u00020N2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J \u0010Q\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\b\u0010R\u001a\u00020\u0007H\u0007J)\u0010S\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ\u001a\u0010T\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u0004H\u0007J$\u0010T\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J \u0010U\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0004H\u0007JD\u0010V\u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u0001H!2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0082\b¢\u0006\u0002\u0010WJ\t\u0010X\u001a\u00020\u0004H\u0082\bJ%\u0010Y\u001a\u0004\u0018\u0001052\b\u00109\u001a\u0004\u0018\u0001052\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050[H\u0082\bJ%\u0010Y\u001a\u0004\u0018\u00010\u001e2\b\u00109\u001a\u0004\u0018\u00010\u001e2\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0[H\u0082\bJ)\u0010\\\u001a\u00020D2\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0014\u0010Z\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0004\u0012\u00020D0]H\u0082\bJ\t\u0010^\u001a\u00020\u0019H\u0082\bJ\b\u0010_\u001a\u00020\u0019H\u0007J\u0011\u0010`\u001a\u0002052\u0006\u00109\u001a\u00020\u001eH\u0082\bJ\b\u0010a\u001a\u00020NH\u0007J)\u0010b\u001a\u00020N2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010c\u001a\u00020d2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\bJ6\u0010e\u001a\u00020f2\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u001e0h2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020P0h2\b\b\u0002\u0010+\u001a\u00020\u0004H\u0007J\u000e\u0010j\u001a\u00020N2\u0006\u0010k\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0012j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/baidu/searchbox/config/FontSizeHelper;", "", "()V", "FONT_SIZE_TYPE_OFFSET", "", "SCALED_RATIO_CONTENT", "", "", "[Ljava/lang/Float;", "SCALED_RATIO_DEFAULT", "SCALED_RATIO_FRAMEWORK", "SCALED_RATIO_H", "SCALED_RATIO_NONE", "SCALED_RATIO_T", "TAG", "", "mCustomerRatioIndex", "mCustomerRatios", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTargetLevel", "addCustomerRatio", "array", "([Ljava/lang/Float;)I", "checkScaledRequired", "", "type", "baseFontSize", "targetFontSize", "getDrawableByResId", "Landroid/graphics/drawable/Drawable;", "resId", "getDrawableWithScaledOperation", ExifInterface.GPS_DIRECTION_TRUE, "srcDrawable", "scaledOperation", "Lkotlin/Function3;", "(ILandroid/graphics/drawable/Drawable;IILkotlin/jvm/functions/Function3;)Landroid/graphics/drawable/Drawable;", "getFontSizeType", "getIOSFontSizeType", "getMListDrawable", "dstWidth", "dstHeight", "numRoundPolicy", "(Landroid/graphics/drawable/Drawable;FFI)Landroid/graphics/drawable/Drawable;", "getScaled1DSizeInfo", "Lcom/baidu/searchbox/config/FontSizeHelper$Scaled1DSizeInfo;", "size", "getScaled2DSizeInfo", "Lcom/baidu/searchbox/config/FontSizeHelper$Scaled2DSizeInfo;", "width", "height", "getScaledBitmap", "Landroid/graphics/Bitmap;", "bitmap", "getScaledBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", ResourceManager.DRAWABLE, "getScaledBitmapForTargetFontSize", "getScaledBitmapInner", "getScaledBitmapWithBaseFontSize", "getScaledDrawable", "getScaledDrawableForTargetFontSize", "getScaledDrawableInner", "getScaledDrawableNotSafe", "getScaledDrawableRes", "drawableId", "getScaledDrawableSize", "Lcom/baidu/searchbox/config/FontScaledSize;", "getScaledDrawableWithBaseFontSize", "getScaledNinePatchDrawable", "Landroid/graphics/drawable/NinePatchDrawable;", "ninePatchDrawable", "getScaledRatio", "getScaledRatioArray", "(I)[Ljava/lang/Float;", "getScaledSize", "getScaledSizeArray", "", "sizeArray", "", "getScaledSizeForTargetFontSize", "getScaledSizeH", "getScaledSizeInner", "getScaledSizeRes", "getScaledSizeWithBaseFontSize", "getScaledStateListDrawable", "(ILandroid/graphics/drawable/Drawable;III)Landroid/graphics/drawable/Drawable;", "getTargetLevel", "handleErrorException", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function0;", "handleException", "Lkotlin/Function1;", "isDebug", "isFontSizeBigger", "parseDrawableToBitmap", "reloadTargetLevelFromSp", "scaledGradientDrawable", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "setScaledStateListDrawable", "Landroid/graphics/drawable/StateListDrawable;", "drawableList", "", "statesList", "setTargetLevel", "level", "Scaled1DSizeInfo", "Scaled2DSizeInfo", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FontSizeHelper {
    public static final int FONT_SIZE_TYPE_OFFSET = 1;
    public static final FontSizeHelper INSTANCE = new FontSizeHelper();
    public static final Float[] SCALED_RATIO_CONTENT;
    public static final float SCALED_RATIO_DEFAULT = 1.0f;
    public static final Float[] SCALED_RATIO_FRAMEWORK;
    public static final Float[] SCALED_RATIO_H;
    public static final Float[] SCALED_RATIO_NONE;
    public static final Float[] SCALED_RATIO_T;
    public static final String TAG = "FontSizeHelper";
    public static int mCustomerRatioIndex;
    public static final HashMap<Integer, Float[]> mCustomerRatios;
    public static int mTargetLevel;

    @JvmStatic
    @JvmOverloads
    public static final Bitmap getScaledBitmap(int i, Bitmap bitmap) {
        return getScaledBitmap$default(i, bitmap, 0, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final Bitmap getScaledBitmapForTargetFontSize(int i, Bitmap bitmap, int i2) {
        return getScaledBitmapForTargetFontSize$default(i, bitmap, i2, 0, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final Bitmap getScaledBitmapWithBaseFontSize(int i, Bitmap bitmap, int i2) {
        return getScaledBitmapWithBaseFontSize$default(i, bitmap, i2, 0, 8, null);
    }

    @Deprecated(message = "此方法为耗时方法，使用时务必确保该场景对性能要求不高，可能耗时数毫秒")
    @JvmStatic
    @JvmOverloads
    public static final Drawable getScaledDrawable(int i, Drawable drawable) {
        return getScaledDrawable$default(i, drawable, 0, 4, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v85, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f2 A[Catch: Exception -> 0x04c6, Error -> 0x04cb, TRY_LEAVE, TryCatch #3 {Error -> 0x04cb, blocks: (B:73:0x013f, B:111:0x01ea, B:114:0x01f2, B:164:0x02ce, B:166:0x02d4, B:168:0x02ed, B:171:0x02f3, B:173:0x02f7, B:175:0x02fd, B:181:0x030e, B:192:0x033c, B:198:0x035c, B:265:0x04a0, B:194:0x0347, B:195:0x034c, B:197:0x0359, B:196:0x0353, B:183:0x031a, B:184:0x031f, B:186:0x0332, B:185:0x0328, B:199:0x036d, B:201:0x0376, B:202:0x0378, B:204:0x037e, B:206:0x038f, B:208:0x0399, B:209:0x03b3, B:211:0x03b7, B:213:0x03c2, B:235:0x03f5, B:254:0x0469, B:258:0x0476, B:257:0x0472, B:243:0x040b, B:245:0x0419, B:247:0x0429, B:253:0x045e, B:249:0x0433, B:250:0x043e, B:251:0x0449, B:252:0x0454, B:230:0x03e3, B:205:0x0387, B:262:0x047c, B:264:0x0486, B:266:0x04aa, B:273:0x04bc, B:274:0x04c0, B:270:0x04af, B:272:0x04b9, B:110:0x01e0, B:109:0x01d6, B:87:0x016a), top: B:499:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0298 A[Catch: all -> 0x02b9, TryCatch #4 {all -> 0x02b9, blocks: (B:121:0x0211, B:123:0x022b, B:126:0x0231, B:128:0x0236, B:130:0x023e, B:135:0x0262, B:140:0x0279, B:146:0x0287, B:152:0x02a0, B:148:0x028d, B:149:0x0292, B:151:0x029d, B:150:0x0298, B:136:0x0267, B:137:0x026c, B:139:0x0277, B:138:0x0272, B:153:0x02ac, B:154:0x02b1, B:156:0x02b5), top: B:501:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0353 A[Catch: Exception -> 0x04ad, Error -> 0x04cb, TryCatch #0 {Exception -> 0x04ad, blocks: (B:166:0x02d4, B:168:0x02ed, B:171:0x02f3, B:173:0x02f7, B:175:0x02fd, B:181:0x030e, B:192:0x033c, B:198:0x035c, B:265:0x04a0, B:194:0x0347, B:195:0x034c, B:197:0x0359, B:196:0x0353, B:183:0x031a, B:184:0x031f, B:186:0x0332, B:185:0x0328, B:199:0x036d, B:201:0x0376, B:262:0x047c, B:264:0x0486, B:266:0x04aa), top: B:493:0x02d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03f5 A[Catch: Exception -> 0x047a, Error -> 0x04cb, TryCatch #1 {Exception -> 0x047a, blocks: (B:202:0x0378, B:204:0x037e, B:206:0x038f, B:208:0x0399, B:209:0x03b3, B:211:0x03b7, B:213:0x03c2, B:235:0x03f5, B:254:0x0469, B:258:0x0476, B:257:0x0472, B:243:0x040b, B:245:0x0419, B:247:0x0429, B:253:0x045e, B:249:0x0433, B:250:0x043e, B:251:0x0449, B:252:0x0454, B:230:0x03e3, B:205:0x0387), top: B:495:0x0378 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0472 A[Catch: Exception -> 0x047a, Error -> 0x04cb, TryCatch #1 {Exception -> 0x047a, blocks: (B:202:0x0378, B:204:0x037e, B:206:0x038f, B:208:0x0399, B:209:0x03b3, B:211:0x03b7, B:213:0x03c2, B:235:0x03f5, B:254:0x0469, B:258:0x0476, B:257:0x0472, B:243:0x040b, B:245:0x0419, B:247:0x0429, B:253:0x045e, B:249:0x0433, B:250:0x043e, B:251:0x0449, B:252:0x0454, B:230:0x03e3, B:205:0x0387), top: B:495:0x0378 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055 A[Catch: Exception -> 0x0856, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x055b A[Catch: Exception -> 0x05d9, Error -> 0x0866, TryCatch #2 {Exception -> 0x05d9, blocks: (B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:287:0x04ed), top: B:497:0x04de }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05d1 A[Catch: Exception -> 0x05d9, Error -> 0x0866, TryCatch #2 {Exception -> 0x05d9, blocks: (B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:287:0x04ed), top: B:497:0x04de }] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0639 A[Catch: Exception -> 0x0645, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06b7  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06ba A[Catch: Exception -> 0x0645, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06dd A[Catch: Exception -> 0x0645, Error -> 0x0866, TRY_LEAVE, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0759 A[Catch: Exception -> 0x0856, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x07d0 A[Catch: Exception -> 0x0856, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0824  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[Catch: Exception -> 0x0856, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:477:0x083b A[Catch: Exception -> 0x0856, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106 A[Catch: Exception -> 0x0856, Error -> 0x0866, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017c A[Catch: Exception -> 0x0856, Error -> 0x0866, TRY_ENTER, TryCatch #6 {Error -> 0x0866, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:281:0x04d4, B:283:0x04d8, B:284:0x04de, B:286:0x04e4, B:288:0x04f5, B:290:0x04ff, B:291:0x0519, B:293:0x051d, B:295:0x0528, B:317:0x055b, B:336:0x05ca, B:340:0x05d5, B:339:0x05d1, B:325:0x056f, B:327:0x057d, B:329:0x058d, B:335:0x05c2, B:331:0x0597, B:332:0x05a2, B:333:0x05ad, B:334:0x05b8, B:312:0x0549, B:347:0x05ff, B:287:0x04ed, B:344:0x05db, B:346:0x05e5, B:348:0x0603, B:350:0x0607, B:374:0x0639, B:395:0x06b1, B:399:0x06be, B:401:0x06dd, B:406:0x0710, B:398:0x06ba, B:384:0x0654, B:386:0x0662, B:388:0x0672, B:394:0x06a7, B:390:0x067c, B:391:0x0687, B:392:0x0692, B:393:0x069d, B:369:0x0627, B:403:0x0703, B:405:0x070d, B:409:0x071a, B:431:0x0759, B:450:0x07c8, B:453:0x07d0, B:455:0x07e7, B:457:0x07ec, B:463:0x080b, B:473:0x082a, B:479:0x0843, B:475:0x0830, B:476:0x0835, B:478:0x0840, B:477:0x083b, B:464:0x0810, B:465:0x0815, B:467:0x0820, B:466:0x081b, B:456:0x07ea, B:439:0x076b, B:441:0x0779, B:443:0x0789, B:449:0x07be, B:445:0x0793, B:446:0x079e, B:447:0x07a9, B:448:0x07b4, B:426:0x0747, B:69:0x012d), top: B:503:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0183  */
    /* JADX WARN: Type inference failed for: r3v84 */
    /* JADX WARN: Type inference failed for: r3v87 */
    @Deprecated(message = "此方法为耗时方法，使用时务必确保该场景对性能要求不高，可能耗时数毫秒")
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Drawable getScaledDrawable(int i, Drawable drawable, int i2) {
        BitmapDrawable bitmapDrawable;
        Drawable drawable2;
        int i3;
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        Bitmap.Config config;
        double ceil;
        int i4;
        double ceil2;
        int i5;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr2;
        Object fieldValue;
        boolean z3;
        Scaled1DSizeInfo scaled1DSizeInfo2;
        Float[] fArr3;
        boolean z4;
        Scaled2DSizeInfo scaled2DSizeInfo2;
        Float[] fArr4;
        Object[] objArr;
        int i6;
        int i7;
        Object fieldValue2;
        boolean z5;
        float f;
        Scaled1DSizeInfo scaled1DSizeInfo3;
        Float[] fArr5;
        int i8;
        double ceil3;
        int i9;
        double ceil4;
        int i10;
        int i11;
        int roundToInt;
        int roundToInt2;
        Unit unit;
        double ceil5;
        int i12;
        double ceil6;
        int i13;
        BitmapDrawable bitmapDrawable2;
        boolean z6;
        Scaled2DSizeInfo scaled2DSizeInfo3;
        Float[] fArr6;
        double ceil7;
        int i14;
        double ceil8;
        int i15;
        Drawable drawable3 = drawable;
        int i16 = i2;
        int i17 = mTargetLevel;
        if (drawable3 != null) {
            try {
                try {
                    i3 = 1;
                } catch (Error e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (drawable3 instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable3 = (BitmapDrawable) drawable3;
                if (bitmapDrawable3 != null) {
                    float standardScreen = DisplayUtilsKt.toStandardScreen(bitmapDrawable3.getIntrinsicWidth());
                    float standardScreen2 = DisplayUtilsKt.toStandardScreen(bitmapDrawable3.getIntrinsicHeight());
                    if (i17 != 1 && (i != 0 || i17 != 0)) {
                        if ((i17 >= 0 && i17 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                            z6 = true;
                            if (z6) {
                                scaled2DSizeInfo3 = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                            } else {
                                float floatValue = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr6 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr6[i17].floatValue() : SCALED_RATIO_T[i17].floatValue() : SCALED_RATIO_H[i17].floatValue() : SCALED_RATIO_CONTENT[i17].floatValue() : SCALED_RATIO_FRAMEWORK[i17].floatValue();
                                scaled2DSizeInfo3 = new Scaled2DSizeInfo(true, standardScreen * floatValue, standardScreen2 * floatValue);
                            }
                            if (scaled2DSizeInfo3.isScaledRequired()) {
                                bitmapDrawable2 = bitmapDrawable3;
                            } else {
                                float scaledWidth = scaled2DSizeInfo3.getScaledWidth();
                                float scaledHeight = scaled2DSizeInfo3.getScaledHeight();
                                Bitmap bitmap = bitmapDrawable3.getBitmap();
                                if (i16 == 0) {
                                    ceil7 = Math.ceil(scaledWidth);
                                } else if (i16 == 1) {
                                    ceil7 = Math.floor(scaledWidth);
                                } else {
                                    if (i16 != 2) {
                                        i14 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i14 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    if (i16 != 0) {
                                        ceil8 = Math.ceil(scaledHeight);
                                    } else if (i16 == 1) {
                                        ceil8 = Math.floor(scaledHeight);
                                    } else {
                                        if (i16 != 2) {
                                            i15 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        } else {
                                            i15 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        }
                                        bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                    }
                                    i15 = (int) ceil8;
                                    bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                }
                                i14 = (int) ceil7;
                                if (i16 != 0) {
                                }
                                i15 = (int) ceil8;
                                bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                            }
                        }
                    }
                    z6 = false;
                    if (z6) {
                    }
                    if (scaled2DSizeInfo3.isScaledRequired()) {
                    }
                } else {
                    bitmapDrawable2 = null;
                }
                drawable2 = bitmapDrawable2;
            } else {
                if (drawable3 instanceof StateListDrawable ? true : drawable3 instanceof LevelListDrawable) {
                    if (drawable3 != null) {
                        try {
                            try {
                                float standardScreen3 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                                float standardScreen4 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                                if (i17 != 1 && (i != 0 || i17 != 0)) {
                                    if ((i17 >= 0 && i17 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                        z4 = true;
                                        if (z4) {
                                            scaled2DSizeInfo2 = new Scaled2DSizeInfo(false, standardScreen3, standardScreen4);
                                        } else {
                                            float floatValue2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr4 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr4[i17].floatValue() : SCALED_RATIO_T[i17].floatValue() : SCALED_RATIO_H[i17].floatValue() : SCALED_RATIO_CONTENT[i17].floatValue() : SCALED_RATIO_FRAMEWORK[i17].floatValue();
                                            scaled2DSizeInfo2 = new Scaled2DSizeInfo(true, standardScreen3 * floatValue2, standardScreen4 * floatValue2);
                                        }
                                        if (!scaled2DSizeInfo2.isScaledRequired()) {
                                            float scaledWidth2 = scaled2DSizeInfo2.getScaledWidth();
                                            float scaledHeight2 = scaled2DSizeInfo2.getScaledHeight();
                                            if (Build.VERSION.SDK_INT <= 23 && (drawable3 instanceof LevelListDrawable)) {
                                                LevelListDrawable levelListDrawable = new LevelListDrawable();
                                                Drawable.ConstantState constantState = drawable.getConstantState();
                                                if (constantState != null) {
                                                    try {
                                                        Result.Companion companion = Result.Companion;
                                                        Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                                                        method.setAccessible(true);
                                                        Object invoke = method.invoke(constantState, new Object[0]);
                                                        Object[] objArr2 = invoke instanceof Object[] ? (Object[]) invoke : null;
                                                        if (objArr2 != null) {
                                                            int length = objArr2.length;
                                                            int i18 = 0;
                                                            int i19 = 0;
                                                            while (i19 < length) {
                                                                Object obj = objArr2[i19];
                                                                int i20 = i18 + 1;
                                                                if (obj instanceof BitmapDrawable) {
                                                                    Bitmap bitmap2 = ((BitmapDrawable) obj).getBitmap();
                                                                    float f2 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                                                                    float standardScreen5 = DisplayUtilsKt.toStandardScreen(scaledWidth2 * f2);
                                                                    if (i16 == 0) {
                                                                        ceil5 = Math.ceil(standardScreen5);
                                                                    } else if (i16 == i3) {
                                                                        ceil5 = Math.floor(standardScreen5);
                                                                    } else {
                                                                        if (i16 != 2) {
                                                                            i12 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                        } else {
                                                                            i12 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                        }
                                                                        float standardScreen6 = DisplayUtilsKt.toStandardScreen(f2 * scaledHeight2);
                                                                        if (i16 != 0) {
                                                                            ceil6 = Math.ceil(standardScreen6);
                                                                        } else if (i16 == 1) {
                                                                            ceil6 = Math.floor(standardScreen6);
                                                                        } else {
                                                                            if (i16 != 2) {
                                                                                i13 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                            } else {
                                                                                i13 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                            }
                                                                            levelListDrawable.addLevel(i18, i18, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                        }
                                                                        i13 = (int) ceil6;
                                                                        levelListDrawable.addLevel(i18, i18, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                    }
                                                                    i12 = (int) ceil5;
                                                                    float standardScreen62 = DisplayUtilsKt.toStandardScreen(f2 * scaledHeight2);
                                                                    if (i16 != 0) {
                                                                    }
                                                                    i13 = (int) ceil6;
                                                                    levelListDrawable.addLevel(i18, i18, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                }
                                                                i19++;
                                                                i18 = i20;
                                                                i3 = 1;
                                                            }
                                                            unit = Unit.INSTANCE;
                                                        } else {
                                                            unit = null;
                                                        }
                                                        Result.m855constructorimpl(unit);
                                                    } catch (Throwable th) {
                                                        Result.Companion companion2 = Result.Companion;
                                                        Result.m855constructorimpl(ResultKt.createFailure(th));
                                                    }
                                                    Unit unit2 = Unit.INSTANCE;
                                                    Unit unit3 = Unit.INSTANCE;
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                                drawable2 = levelListDrawable;
                                            } else {
                                                Drawable.ConstantState constantState2 = drawable.getConstantState();
                                                if (constantState2 != null) {
                                                    try {
                                                        Method method2 = constantState2.getClass().getMethod("getChildren", new Class[0]);
                                                        method2.setAccessible(true);
                                                        Object invoke2 = method2.invoke(constantState2, new Object[0]);
                                                        Object[] objArr3 = invoke2 instanceof Object[] ? (Object[]) invoke2 : null;
                                                        if (objArr3 != null) {
                                                            int length2 = objArr3.length;
                                                            int i21 = 0;
                                                            while (i21 < length2) {
                                                                Object obj2 = objArr3[i21];
                                                                if (obj2 instanceof BitmapDrawable) {
                                                                    Bitmap bitmap3 = ((BitmapDrawable) obj2).getBitmap();
                                                                    if (i16 != 0) {
                                                                        objArr = objArr3;
                                                                        if (i16 == 1) {
                                                                            i8 = length2;
                                                                            i6 = i21;
                                                                            ceil3 = Math.floor(scaledWidth2);
                                                                        } else {
                                                                            if (i16 != 2) {
                                                                                roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                            } else {
                                                                                roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                            }
                                                                            i6 = i21;
                                                                            int i22 = length2;
                                                                            i9 = roundToInt2;
                                                                            i8 = i22;
                                                                            if (i16 != 0) {
                                                                                i7 = i8;
                                                                                ceil4 = Math.ceil(scaledHeight2);
                                                                            } else if (i16 == 1) {
                                                                                i7 = i8;
                                                                                ceil4 = Math.floor(scaledHeight2);
                                                                            } else {
                                                                                if (i16 != 2) {
                                                                                    roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                } else {
                                                                                    roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                }
                                                                                i11 = 1;
                                                                                int i23 = roundToInt;
                                                                                i7 = i8;
                                                                                i10 = i23;
                                                                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, i9, i10, i11);
                                                                                Object[] objArr4 = new Object[i11];
                                                                                objArr4[0] = createScaledBitmap;
                                                                                ReflectionUtil.invokeMethod(obj2, "setBitmap", objArr4);
                                                                            }
                                                                            i10 = (int) ceil4;
                                                                            i11 = 1;
                                                                            Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap3, i9, i10, i11);
                                                                            Object[] objArr42 = new Object[i11];
                                                                            objArr42[0] = createScaledBitmap2;
                                                                            ReflectionUtil.invokeMethod(obj2, "setBitmap", objArr42);
                                                                        }
                                                                    } else {
                                                                        objArr = objArr3;
                                                                        i8 = length2;
                                                                        i6 = i21;
                                                                        ceil3 = Math.ceil(scaledWidth2);
                                                                    }
                                                                    i9 = (int) ceil3;
                                                                    if (i16 != 0) {
                                                                    }
                                                                    i10 = (int) ceil4;
                                                                    i11 = 1;
                                                                    Bitmap createScaledBitmap22 = Bitmap.createScaledBitmap(bitmap3, i9, i10, i11);
                                                                    Object[] objArr422 = new Object[i11];
                                                                    objArr422[0] = createScaledBitmap22;
                                                                    ReflectionUtil.invokeMethod(obj2, "setBitmap", objArr422);
                                                                } else {
                                                                    objArr = objArr3;
                                                                    i6 = i21;
                                                                    i7 = length2;
                                                                    if (obj2 instanceof GradientDrawable) {
                                                                        GradientDrawable gradientDrawable = (GradientDrawable) obj2;
                                                                        try {
                                                                            if (Build.VERSION.SDK_INT >= 24) {
                                                                                fieldValue2 = Float.valueOf(gradientDrawable.getCornerRadius());
                                                                            } else {
                                                                                fieldValue2 = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
                                                                            }
                                                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue2);
                                                                            }
                                                                            if ((fieldValue2 instanceof Float) && ((Number) fieldValue2).floatValue() > 0.0f) {
                                                                                float floatValue3 = ((Number) fieldValue2).floatValue();
                                                                                if (i17 != 1 && (i != 0 || i17 != 0)) {
                                                                                    if ((i17 >= 0 && i17 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                                                                        z5 = true;
                                                                                        if (z5) {
                                                                                            scaled1DSizeInfo3 = new Scaled1DSizeInfo(false, 1.0f, floatValue3);
                                                                                            f = floatValue3;
                                                                                        } else {
                                                                                            float floatValue4 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr5 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr5[i17].floatValue() : SCALED_RATIO_T[i17].floatValue() : SCALED_RATIO_H[i17].floatValue() : SCALED_RATIO_CONTENT[i17].floatValue() : SCALED_RATIO_FRAMEWORK[i17].floatValue();
                                                                                            f = floatValue3;
                                                                                            scaled1DSizeInfo3 = new Scaled1DSizeInfo(true, floatValue4, floatValue3 * floatValue4);
                                                                                        }
                                                                                        gradientDrawable.setCornerRadius(scaled1DSizeInfo3.isScaledRequired() ? f : scaled1DSizeInfo3.getScaledSize());
                                                                                    }
                                                                                }
                                                                                z5 = false;
                                                                                if (z5) {
                                                                                }
                                                                                gradientDrawable.setCornerRadius(scaled1DSizeInfo3.isScaledRequired() ? f : scaled1DSizeInfo3.getScaledSize());
                                                                            }
                                                                        } catch (Exception e3) {
                                                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                                                                e3.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                i16 = i2;
                                                                length2 = i7;
                                                                i21 = i6 + 1;
                                                                objArr3 = objArr;
                                                            }
                                                            Unit unit5 = Unit.INSTANCE;
                                                        }
                                                    } catch (Exception e4) {
                                                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                            e4.printStackTrace();
                                                        }
                                                    }
                                                    Unit unit6 = Unit.INSTANCE;
                                                    Unit unit7 = Unit.INSTANCE;
                                                }
                                                Unit unit8 = Unit.INSTANCE;
                                            }
                                        }
                                        drawable2 = drawable;
                                    }
                                }
                                z4 = false;
                                if (z4) {
                                }
                                if (!scaled2DSizeInfo2.isScaledRequired()) {
                                }
                                drawable2 = drawable;
                            } catch (Error e5) {
                                e = e5;
                                drawable3 = drawable;
                                Error error = e;
                                bitmapDrawable = drawable3;
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    error.printStackTrace();
                                    bitmapDrawable = drawable3;
                                }
                                drawable2 = bitmapDrawable;
                                return drawable2;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            drawable3 = drawable;
                            Exception exc = e;
                            bitmapDrawable = drawable3;
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                exc.printStackTrace();
                                bitmapDrawable = drawable3;
                            }
                            drawable2 = bitmapDrawable;
                            return drawable2;
                        }
                    }
                    drawable2 = null;
                } else {
                    if (drawable3 instanceof GradientDrawable) {
                        GradientDrawable gradientDrawable2 = (GradientDrawable) drawable3;
                        GradientDrawable gradientDrawable3 = (GradientDrawable) drawable3;
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                fieldValue = Float.valueOf(gradientDrawable3.getCornerRadius());
                            } else {
                                fieldValue = ReflectionUtil.getFieldValue(gradientDrawable3.getConstantState(), "mRadius");
                            }
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
                            }
                            if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                                float floatValue5 = ((Number) fieldValue).floatValue();
                                if (i17 != 1 && (i != 0 || i17 != 0)) {
                                    if ((i17 >= 0 && i17 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                        z3 = true;
                                        if (z3) {
                                            scaled1DSizeInfo2 = new Scaled1DSizeInfo(false, 1.0f, floatValue5);
                                        } else {
                                            float floatValue6 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr3 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr3[i17].floatValue() : SCALED_RATIO_T[i17].floatValue() : SCALED_RATIO_H[i17].floatValue() : SCALED_RATIO_CONTENT[i17].floatValue() : SCALED_RATIO_FRAMEWORK[i17].floatValue();
                                            scaled1DSizeInfo2 = new Scaled1DSizeInfo(true, floatValue6, floatValue5 * floatValue6);
                                        }
                                        if (!scaled1DSizeInfo2.isScaledRequired()) {
                                            floatValue5 = scaled1DSizeInfo2.getScaledSize();
                                        }
                                        gradientDrawable3.setCornerRadius(floatValue5);
                                    }
                                }
                                z3 = false;
                                if (z3) {
                                }
                                if (!scaled1DSizeInfo2.isScaledRequired()) {
                                }
                                gradientDrawable3.setCornerRadius(floatValue5);
                            }
                        } catch (Exception e7) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                e7.printStackTrace();
                            }
                        }
                        Unit unit9 = Unit.INSTANCE;
                        bitmapDrawable = drawable3;
                    } else {
                        if (drawable3 instanceof NinePatchDrawable) {
                            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable3;
                            if (ninePatchDrawable != null) {
                                if (i17 != 1 && (i != 0 || i17 != 0)) {
                                    if (i17 >= 0 && i17 < 5) {
                                        if (i <= -1 || i >= 4) {
                                            try {
                                                if (!mCustomerRatios.containsKey(Integer.valueOf(i))) {
                                                }
                                            } catch (Exception e8) {
                                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                    e8.printStackTrace();
                                                }
                                            }
                                        }
                                        z2 = true;
                                        if (z2) {
                                            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
                                        } else {
                                            float floatValue7 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr2[i17].floatValue() : SCALED_RATIO_T[i17].floatValue() : SCALED_RATIO_H[i17].floatValue() : SCALED_RATIO_CONTENT[i17].floatValue() : SCALED_RATIO_FRAMEWORK[i17].floatValue();
                                            scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue7, 1.0f * floatValue7);
                                        }
                                        float scaledSize = scaled1DSizeInfo.isScaledRequired() ? 1.0f : scaled1DSizeInfo.getScaledSize();
                                        int i24 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                        float f3 = i24 * scaledSize;
                                        ninePatchDrawable.setTargetDensity((int) f3);
                                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                            Log.d(TAG, "scaled: " + scaledSize + ", displayMetrics: " + i24 + ", result: " + f3);
                                        }
                                        Unit unit10 = Unit.INSTANCE;
                                        drawable2 = ninePatchDrawable;
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                }
                                if (scaled1DSizeInfo.isScaledRequired()) {
                                }
                                int i242 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                float f32 = i242 * scaledSize;
                                ninePatchDrawable.setTargetDensity((int) f32);
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                }
                                Unit unit102 = Unit.INSTANCE;
                                drawable2 = ninePatchDrawable;
                            }
                        } else if (drawable3 != null) {
                            float standardScreen7 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                            float standardScreen8 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                            if (i17 != 1 && (i != 0 || i17 != 0)) {
                                if ((i17 >= 0 && i17 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                    z = true;
                                    if (z) {
                                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen7, standardScreen8);
                                    } else {
                                        float floatValue8 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr[i17].floatValue() : SCALED_RATIO_T[i17].floatValue() : SCALED_RATIO_H[i17].floatValue() : SCALED_RATIO_CONTENT[i17].floatValue() : SCALED_RATIO_FRAMEWORK[i17].floatValue();
                                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen7 * floatValue8, standardScreen8 * floatValue8);
                                    }
                                    if (scaled2DSizeInfo.isScaledRequired()) {
                                        bitmapDrawable = drawable3;
                                    } else {
                                        float scaledWidth3 = scaled2DSizeInfo.getScaledWidth();
                                        float scaledHeight3 = scaled2DSizeInfo.getScaledHeight();
                                        int intrinsicWidth = drawable.getIntrinsicWidth();
                                        int intrinsicHeight = drawable.getIntrinsicHeight();
                                        if (drawable.getOpacity() != -1) {
                                            config = Bitmap.Config.ARGB_8888;
                                        } else {
                                            config = Bitmap.Config.RGB_565;
                                        }
                                        Bitmap bitmap4 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                                        Canvas canvas = new Canvas(bitmap4);
                                        drawable3.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                                        drawable3.draw(canvas);
                                        Intrinsics.checkNotNullExpressionValue(bitmap4, "bitmap");
                                        if (i2 == 0) {
                                            ceil = Math.ceil(scaledWidth3);
                                        } else if (i2 == 1) {
                                            ceil = Math.floor(scaledWidth3);
                                        } else {
                                            if (i2 != 2) {
                                                i4 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            } else {
                                                i4 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            }
                                            if (i2 != 0) {
                                                ceil2 = Math.ceil(scaledHeight3);
                                            } else if (i2 == 1) {
                                                ceil2 = Math.floor(scaledHeight3);
                                            } else {
                                                if (i2 != 2) {
                                                    i5 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                } else {
                                                    i5 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                }
                                                bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i4, i5, true));
                                            }
                                            i5 = (int) ceil2;
                                            bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i4, i5, true));
                                        }
                                        i4 = (int) ceil;
                                        if (i2 != 0) {
                                        }
                                        i5 = (int) ceil2;
                                        bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i4, i5, true));
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                            if (scaled2DSizeInfo.isScaledRequired()) {
                            }
                        }
                        drawable2 = null;
                    }
                    drawable2 = bitmapDrawable;
                }
            }
            return drawable2;
        }
        return null;
    }

    @JvmStatic
    @JvmOverloads
    public static final Drawable getScaledDrawableForTargetFontSize(int i, Drawable drawable, int i2) {
        return getScaledDrawableForTargetFontSize$default(i, drawable, i2, 0, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f2 A[Catch: Exception -> 0x04cb, Error -> 0x04d0, TRY_LEAVE, TryCatch #0 {Error -> 0x04d0, blocks: (B:73:0x013f, B:111:0x01ea, B:114:0x01f2, B:164:0x02ce, B:166:0x02d4, B:168:0x02ed, B:171:0x02f3, B:173:0x02f7, B:175:0x02fd, B:181:0x030e, B:192:0x033c, B:199:0x0359, B:272:0x04a3, B:195:0x0344, B:196:0x0349, B:198:0x0356, B:197:0x0350, B:183:0x031a, B:184:0x031f, B:186:0x0332, B:185:0x0328, B:200:0x036a, B:202:0x0374, B:203:0x0376, B:205:0x037c, B:207:0x038d, B:209:0x0397, B:210:0x03b1, B:212:0x03b5, B:214:0x03c0, B:236:0x03f3, B:257:0x0467, B:261:0x0472, B:260:0x046e, B:244:0x0409, B:246:0x0417, B:248:0x0427, B:254:0x045c, B:256:0x0463, B:268:0x047c, B:270:0x0486, B:250:0x0431, B:251:0x043c, B:252:0x0447, B:253:0x0452, B:231:0x03e1, B:206:0x0385, B:273:0x04af, B:280:0x04c1, B:281:0x04c5, B:277:0x04b4, B:279:0x04be, B:110:0x01e0, B:109:0x01d6, B:87:0x016a), top: B:501:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0298 A[Catch: all -> 0x02b9, TryCatch #7 {all -> 0x02b9, blocks: (B:121:0x0211, B:123:0x022b, B:126:0x0231, B:128:0x0236, B:130:0x023e, B:135:0x0262, B:140:0x0279, B:146:0x0287, B:152:0x02a0, B:148:0x028d, B:149:0x0292, B:151:0x029d, B:150:0x0298, B:136:0x0267, B:137:0x026c, B:139:0x0277, B:138:0x0272, B:153:0x02ac, B:154:0x02b1, B:156:0x02b5), top: B:510:0x0211 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0350 A[Catch: Exception -> 0x04b2, Error -> 0x04d0, TryCatch #0 {Error -> 0x04d0, blocks: (B:73:0x013f, B:111:0x01ea, B:114:0x01f2, B:164:0x02ce, B:166:0x02d4, B:168:0x02ed, B:171:0x02f3, B:173:0x02f7, B:175:0x02fd, B:181:0x030e, B:192:0x033c, B:199:0x0359, B:272:0x04a3, B:195:0x0344, B:196:0x0349, B:198:0x0356, B:197:0x0350, B:183:0x031a, B:184:0x031f, B:186:0x0332, B:185:0x0328, B:200:0x036a, B:202:0x0374, B:203:0x0376, B:205:0x037c, B:207:0x038d, B:209:0x0397, B:210:0x03b1, B:212:0x03b5, B:214:0x03c0, B:236:0x03f3, B:257:0x0467, B:261:0x0472, B:260:0x046e, B:244:0x0409, B:246:0x0417, B:248:0x0427, B:254:0x045c, B:256:0x0463, B:268:0x047c, B:270:0x0486, B:250:0x0431, B:251:0x043c, B:252:0x0447, B:253:0x0452, B:231:0x03e1, B:206:0x0385, B:273:0x04af, B:280:0x04c1, B:281:0x04c5, B:277:0x04b4, B:279:0x04be, B:110:0x01e0, B:109:0x01d6, B:87:0x016a), top: B:501:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03f3 A[Catch: Exception -> 0x0478, Error -> 0x04d0, TryCatch #0 {Error -> 0x04d0, blocks: (B:73:0x013f, B:111:0x01ea, B:114:0x01f2, B:164:0x02ce, B:166:0x02d4, B:168:0x02ed, B:171:0x02f3, B:173:0x02f7, B:175:0x02fd, B:181:0x030e, B:192:0x033c, B:199:0x0359, B:272:0x04a3, B:195:0x0344, B:196:0x0349, B:198:0x0356, B:197:0x0350, B:183:0x031a, B:184:0x031f, B:186:0x0332, B:185:0x0328, B:200:0x036a, B:202:0x0374, B:203:0x0376, B:205:0x037c, B:207:0x038d, B:209:0x0397, B:210:0x03b1, B:212:0x03b5, B:214:0x03c0, B:236:0x03f3, B:257:0x0467, B:261:0x0472, B:260:0x046e, B:244:0x0409, B:246:0x0417, B:248:0x0427, B:254:0x045c, B:256:0x0463, B:268:0x047c, B:270:0x0486, B:250:0x0431, B:251:0x043c, B:252:0x0447, B:253:0x0452, B:231:0x03e1, B:206:0x0385, B:273:0x04af, B:280:0x04c1, B:281:0x04c5, B:277:0x04b4, B:279:0x04be, B:110:0x01e0, B:109:0x01d6, B:87:0x016a), top: B:501:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055 A[Catch: Exception -> 0x085c, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0561 A[Catch: Exception -> 0x05df, Error -> 0x086c, TryCatch #1 {Exception -> 0x05df, blocks: (B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:295:0x04f3), top: B:503:0x04e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05d7 A[Catch: Exception -> 0x05df, Error -> 0x086c, TryCatch #1 {Exception -> 0x05df, blocks: (B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:295:0x04f3), top: B:503:0x04e4 }] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x063f A[Catch: Exception -> 0x064b, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06c0 A[Catch: Exception -> 0x064b, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06e3 A[Catch: Exception -> 0x064b, Error -> 0x086c, TRY_LEAVE, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:439:0x075f A[Catch: Exception -> 0x085c, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x07d6 A[Catch: Exception -> 0x085c, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[Catch: Exception -> 0x085c, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:477:0x082a  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0841 A[Catch: Exception -> 0x085c, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:512:0x046e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106 A[Catch: Exception -> 0x085c, Error -> 0x086c, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017c A[Catch: Exception -> 0x085c, Error -> 0x086c, TRY_ENTER, TryCatch #2 {Error -> 0x086c, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0127, B:92:0x017c, B:117:0x0202, B:119:0x0206, B:161:0x02c4, B:162:0x02c8, B:160:0x02bb, B:99:0x018d, B:101:0x019b, B:103:0x01ab, B:105:0x01b5, B:106:0x01c0, B:107:0x01cb, B:289:0x04da, B:291:0x04de, B:292:0x04e4, B:294:0x04ea, B:296:0x04fb, B:298:0x0505, B:299:0x051f, B:301:0x0523, B:303:0x052e, B:325:0x0561, B:344:0x05d0, B:348:0x05db, B:347:0x05d7, B:333:0x0575, B:335:0x0583, B:337:0x0593, B:343:0x05c8, B:339:0x059d, B:340:0x05a8, B:341:0x05b3, B:342:0x05be, B:320:0x054f, B:355:0x0605, B:295:0x04f3, B:352:0x05e1, B:354:0x05eb, B:356:0x0609, B:358:0x060d, B:382:0x063f, B:403:0x06b7, B:407:0x06c4, B:409:0x06e3, B:414:0x0716, B:406:0x06c0, B:392:0x065a, B:394:0x0668, B:396:0x0678, B:402:0x06ad, B:398:0x0682, B:399:0x068d, B:400:0x0698, B:401:0x06a3, B:377:0x062d, B:411:0x0709, B:413:0x0713, B:417:0x0720, B:439:0x075f, B:458:0x07ce, B:461:0x07d6, B:463:0x07ed, B:465:0x07f2, B:471:0x0811, B:481:0x0830, B:487:0x0849, B:483:0x0836, B:484:0x083b, B:486:0x0846, B:485:0x0841, B:472:0x0816, B:473:0x081b, B:475:0x0826, B:474:0x0821, B:464:0x07f0, B:447:0x0771, B:449:0x077f, B:451:0x078f, B:457:0x07c4, B:453:0x0799, B:454:0x07a4, B:455:0x07af, B:456:0x07ba, B:434:0x074d, B:69:0x012d), top: B:505:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0183  */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Drawable getScaledDrawableForTargetFontSize(int i, Drawable drawable, int i2, int i3) {
        BitmapDrawable bitmapDrawable;
        int i4;
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        Bitmap.Config config;
        double ceil;
        int i5;
        double ceil2;
        int i6;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr2;
        Object fieldValue;
        boolean z3;
        Scaled1DSizeInfo scaled1DSizeInfo2;
        Float[] fArr3;
        boolean z4;
        Scaled2DSizeInfo scaled2DSizeInfo2;
        Float[] fArr4;
        Object[] objArr;
        int i7;
        int i8;
        String str;
        int i9;
        Object fieldValue2;
        boolean z5;
        Scaled1DSizeInfo scaled1DSizeInfo3;
        Float[] fArr5;
        double ceil3;
        int i10;
        double ceil4;
        int i11;
        int roundToInt;
        int roundToInt2;
        Unit unit;
        double ceil5;
        int i12;
        double ceil6;
        int i13;
        BitmapDrawable bitmapDrawable2;
        boolean z6;
        Scaled2DSizeInfo scaled2DSizeInfo3;
        Float[] fArr6;
        double ceil7;
        int i14;
        double ceil8;
        int i15;
        BitmapDrawable bitmapDrawable3 = drawable;
        int i16 = i3;
        if (bitmapDrawable3 != null) {
            try {
                try {
                    i4 = 1;
                } catch (Error e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (bitmapDrawable3 instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable4 = (BitmapDrawable) bitmapDrawable3;
                if (bitmapDrawable4 != null) {
                    float standardScreen = DisplayUtilsKt.toStandardScreen(bitmapDrawable4.getIntrinsicWidth());
                    float standardScreen2 = DisplayUtilsKt.toStandardScreen(bitmapDrawable4.getIntrinsicHeight());
                    if (i2 != 1 && (i != 0 || i2 != 0)) {
                        if ((i2 >= 0 && i2 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                            z6 = true;
                            if (z6) {
                                scaled2DSizeInfo3 = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                            } else {
                                float floatValue = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr6 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr6[i2].floatValue() : SCALED_RATIO_T[i2].floatValue() : SCALED_RATIO_H[i2].floatValue() : SCALED_RATIO_CONTENT[i2].floatValue() : SCALED_RATIO_FRAMEWORK[i2].floatValue();
                                scaled2DSizeInfo3 = new Scaled2DSizeInfo(true, standardScreen * floatValue, standardScreen2 * floatValue);
                            }
                            if (scaled2DSizeInfo3.isScaledRequired()) {
                                bitmapDrawable2 = bitmapDrawable4;
                            } else {
                                float scaledWidth = scaled2DSizeInfo3.getScaledWidth();
                                float scaledHeight = scaled2DSizeInfo3.getScaledHeight();
                                Bitmap bitmap = bitmapDrawable4.getBitmap();
                                if (i16 == 0) {
                                    ceil7 = Math.ceil(scaledWidth);
                                } else if (i16 == 1) {
                                    ceil7 = Math.floor(scaledWidth);
                                } else {
                                    if (i16 != 2) {
                                        i14 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i14 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    if (i16 != 0) {
                                        ceil8 = Math.ceil(scaledHeight);
                                    } else if (i16 == 1) {
                                        ceil8 = Math.floor(scaledHeight);
                                    } else {
                                        if (i16 != 2) {
                                            i15 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        } else {
                                            i15 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        }
                                        bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                    }
                                    i15 = (int) ceil8;
                                    bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                }
                                i14 = (int) ceil7;
                                if (i16 != 0) {
                                }
                                i15 = (int) ceil8;
                                bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                            }
                        }
                    }
                    z6 = false;
                    if (z6) {
                    }
                    if (scaled2DSizeInfo3.isScaledRequired()) {
                    }
                } else {
                    bitmapDrawable2 = null;
                }
                bitmapDrawable = bitmapDrawable2;
            } else {
                String str2 = ", GradientDrawable ReflectionUtil Error";
                if (bitmapDrawable3 instanceof StateListDrawable ? true : bitmapDrawable3 instanceof LevelListDrawable) {
                    if (bitmapDrawable3 != null) {
                        try {
                            try {
                                float standardScreen3 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                                float standardScreen4 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                                if (i2 != 1 && (i != 0 || i2 != 0)) {
                                    if ((i2 >= 0 && i2 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                        z4 = true;
                                        if (z4) {
                                            scaled2DSizeInfo2 = new Scaled2DSizeInfo(false, standardScreen3, standardScreen4);
                                        } else {
                                            float floatValue2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr4 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr4[i2].floatValue() : SCALED_RATIO_T[i2].floatValue() : SCALED_RATIO_H[i2].floatValue() : SCALED_RATIO_CONTENT[i2].floatValue() : SCALED_RATIO_FRAMEWORK[i2].floatValue();
                                            scaled2DSizeInfo2 = new Scaled2DSizeInfo(true, standardScreen3 * floatValue2, standardScreen4 * floatValue2);
                                        }
                                        if (!scaled2DSizeInfo2.isScaledRequired()) {
                                            float scaledWidth2 = scaled2DSizeInfo2.getScaledWidth();
                                            float scaledHeight2 = scaled2DSizeInfo2.getScaledHeight();
                                            if (Build.VERSION.SDK_INT <= 23 && (bitmapDrawable3 instanceof LevelListDrawable)) {
                                                LevelListDrawable levelListDrawable = new LevelListDrawable();
                                                Drawable.ConstantState constantState = drawable.getConstantState();
                                                if (constantState != null) {
                                                    try {
                                                        Result.Companion companion = Result.Companion;
                                                        Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                                                        method.setAccessible(true);
                                                        Object invoke = method.invoke(constantState, new Object[0]);
                                                        Object[] objArr2 = invoke instanceof Object[] ? (Object[]) invoke : null;
                                                        if (objArr2 != null) {
                                                            int length = objArr2.length;
                                                            int i17 = 0;
                                                            int i18 = 0;
                                                            while (i18 < length) {
                                                                Object obj = objArr2[i18];
                                                                int i19 = i17 + 1;
                                                                if (obj instanceof BitmapDrawable) {
                                                                    Bitmap bitmap2 = ((BitmapDrawable) obj).getBitmap();
                                                                    float f = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                                                                    float standardScreen5 = DisplayUtilsKt.toStandardScreen(scaledWidth2 * f);
                                                                    if (i16 == 0) {
                                                                        ceil5 = Math.ceil(standardScreen5);
                                                                    } else if (i16 == i4) {
                                                                        ceil5 = Math.floor(standardScreen5);
                                                                    } else {
                                                                        if (i16 != 2) {
                                                                            i12 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                        } else {
                                                                            i12 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                        }
                                                                        float standardScreen6 = DisplayUtilsKt.toStandardScreen(f * scaledHeight2);
                                                                        if (i16 != 0) {
                                                                            ceil6 = Math.ceil(standardScreen6);
                                                                        } else if (i16 == 1) {
                                                                            ceil6 = Math.floor(standardScreen6);
                                                                        } else {
                                                                            if (i16 != 2) {
                                                                                i13 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                            } else {
                                                                                i13 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                            }
                                                                            levelListDrawable.addLevel(i17, i17, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                        }
                                                                        i13 = (int) ceil6;
                                                                        levelListDrawable.addLevel(i17, i17, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                    }
                                                                    i12 = (int) ceil5;
                                                                    float standardScreen62 = DisplayUtilsKt.toStandardScreen(f * scaledHeight2);
                                                                    if (i16 != 0) {
                                                                    }
                                                                    i13 = (int) ceil6;
                                                                    levelListDrawable.addLevel(i17, i17, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                }
                                                                i18++;
                                                                i17 = i19;
                                                                i4 = 1;
                                                            }
                                                            unit = Unit.INSTANCE;
                                                        } else {
                                                            unit = null;
                                                        }
                                                        Result.m855constructorimpl(unit);
                                                    } catch (Throwable th) {
                                                        Result.Companion companion2 = Result.Companion;
                                                        Result.m855constructorimpl(ResultKt.createFailure(th));
                                                    }
                                                    Unit unit2 = Unit.INSTANCE;
                                                    Unit unit3 = Unit.INSTANCE;
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                                bitmapDrawable = levelListDrawable;
                                            } else {
                                                Drawable.ConstantState constantState2 = drawable.getConstantState();
                                                if (constantState2 != null) {
                                                    try {
                                                        Method method2 = constantState2.getClass().getMethod("getChildren", new Class[0]);
                                                        method2.setAccessible(true);
                                                        Object invoke2 = method2.invoke(constantState2, new Object[0]);
                                                        Object[] objArr3 = invoke2 instanceof Object[] ? (Object[]) invoke2 : null;
                                                        if (objArr3 != null) {
                                                            int length2 = objArr3.length;
                                                            int i20 = 0;
                                                            while (i20 < length2) {
                                                                Object obj2 = objArr3[i20];
                                                                if (obj2 instanceof BitmapDrawable) {
                                                                    Bitmap bitmap3 = ((BitmapDrawable) obj2).getBitmap();
                                                                    if (i16 != 0) {
                                                                        objArr = objArr3;
                                                                        if (i16 == 1) {
                                                                            i7 = length2;
                                                                            i8 = i20;
                                                                            ceil3 = Math.floor(scaledWidth2);
                                                                        } else {
                                                                            if (i16 != 2) {
                                                                                roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                            } else {
                                                                                roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                            }
                                                                            i8 = i20;
                                                                            int i21 = length2;
                                                                            i10 = roundToInt2;
                                                                            i7 = i21;
                                                                            if (i16 != 0) {
                                                                                str = str2;
                                                                                ceil4 = Math.ceil(scaledHeight2);
                                                                            } else if (i16 == 1) {
                                                                                str = str2;
                                                                                ceil4 = Math.floor(scaledHeight2);
                                                                            } else {
                                                                                if (i16 != 2) {
                                                                                    roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                } else {
                                                                                    roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                }
                                                                                i11 = roundToInt;
                                                                                str = str2;
                                                                                ReflectionUtil.invokeMethod(obj2, "setBitmap", Bitmap.createScaledBitmap(bitmap3, i10, i11, true));
                                                                            }
                                                                            i11 = (int) ceil4;
                                                                            ReflectionUtil.invokeMethod(obj2, "setBitmap", Bitmap.createScaledBitmap(bitmap3, i10, i11, true));
                                                                        }
                                                                    } else {
                                                                        objArr = objArr3;
                                                                        i7 = length2;
                                                                        i8 = i20;
                                                                        ceil3 = Math.ceil(scaledWidth2);
                                                                    }
                                                                    i10 = (int) ceil3;
                                                                    if (i16 != 0) {
                                                                    }
                                                                    i11 = (int) ceil4;
                                                                    ReflectionUtil.invokeMethod(obj2, "setBitmap", Bitmap.createScaledBitmap(bitmap3, i10, i11, true));
                                                                } else {
                                                                    objArr = objArr3;
                                                                    i7 = length2;
                                                                    i8 = i20;
                                                                    str = str2;
                                                                    if (obj2 instanceof GradientDrawable) {
                                                                        GradientDrawable gradientDrawable = (GradientDrawable) obj2;
                                                                        try {
                                                                            if (Build.VERSION.SDK_INT >= 24) {
                                                                                fieldValue2 = Float.valueOf(gradientDrawable.getCornerRadius());
                                                                            } else {
                                                                                fieldValue2 = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
                                                                            }
                                                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue2);
                                                                            }
                                                                        } catch (Exception e3) {
                                                                            e = e3;
                                                                            i9 = i7;
                                                                        }
                                                                        if ((fieldValue2 instanceof Float) && ((Number) fieldValue2).floatValue() > 0.0f) {
                                                                            float floatValue3 = ((Number) fieldValue2).floatValue();
                                                                            if (i2 != 1 && (i != 0 || i2 != 0)) {
                                                                                if ((i2 >= 0 && i2 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                                                                    z5 = true;
                                                                                    if (z5) {
                                                                                        scaled1DSizeInfo3 = new Scaled1DSizeInfo(false, 1.0f, floatValue3);
                                                                                        i9 = i7;
                                                                                    } else {
                                                                                        float floatValue4 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr5 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr5[i2].floatValue() : SCALED_RATIO_T[i2].floatValue() : SCALED_RATIO_H[i2].floatValue() : SCALED_RATIO_CONTENT[i2].floatValue() : SCALED_RATIO_FRAMEWORK[i2].floatValue();
                                                                                        i9 = i7;
                                                                                        scaled1DSizeInfo3 = new Scaled1DSizeInfo(true, floatValue4, floatValue3 * floatValue4);
                                                                                    }
                                                                                    if (!scaled1DSizeInfo3.isScaledRequired()) {
                                                                                        try {
                                                                                            floatValue3 = scaled1DSizeInfo3.getScaledSize();
                                                                                        } catch (Exception e4) {
                                                                                            e = e4;
                                                                                            Exception exc = e;
                                                                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + str);
                                                                                                exc.printStackTrace();
                                                                                            }
                                                                                            i16 = i3;
                                                                                            str2 = str;
                                                                                            length2 = i9;
                                                                                            i20 = i8 + 1;
                                                                                            objArr3 = objArr;
                                                                                        }
                                                                                    }
                                                                                    gradientDrawable.setCornerRadius(floatValue3);
                                                                                    i16 = i3;
                                                                                    str2 = str;
                                                                                    length2 = i9;
                                                                                    i20 = i8 + 1;
                                                                                    objArr3 = objArr;
                                                                                }
                                                                            }
                                                                            z5 = false;
                                                                            if (z5) {
                                                                            }
                                                                            if (!scaled1DSizeInfo3.isScaledRequired()) {
                                                                            }
                                                                            gradientDrawable.setCornerRadius(floatValue3);
                                                                            i16 = i3;
                                                                            str2 = str;
                                                                            length2 = i9;
                                                                            i20 = i8 + 1;
                                                                            objArr3 = objArr;
                                                                        }
                                                                    }
                                                                }
                                                                i9 = i7;
                                                                i16 = i3;
                                                                str2 = str;
                                                                length2 = i9;
                                                                i20 = i8 + 1;
                                                                objArr3 = objArr;
                                                            }
                                                            Unit unit5 = Unit.INSTANCE;
                                                        }
                                                    } catch (Exception e5) {
                                                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                            e5.printStackTrace();
                                                        }
                                                    }
                                                    Unit unit6 = Unit.INSTANCE;
                                                    Unit unit7 = Unit.INSTANCE;
                                                }
                                                Unit unit8 = Unit.INSTANCE;
                                            }
                                        }
                                        bitmapDrawable = drawable;
                                    }
                                }
                                z4 = false;
                                if (z4) {
                                }
                                if (!scaled2DSizeInfo2.isScaledRequired()) {
                                }
                                bitmapDrawable = drawable;
                            } catch (Error e6) {
                                e = e6;
                                bitmapDrawable3 = drawable;
                                Error error = e;
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    error.printStackTrace();
                                }
                                bitmapDrawable = bitmapDrawable3;
                                return bitmapDrawable;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            bitmapDrawable3 = drawable;
                            Exception exc2 = e;
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                exc2.printStackTrace();
                            }
                            bitmapDrawable = bitmapDrawable3;
                            return bitmapDrawable;
                        }
                    }
                    bitmapDrawable = null;
                } else {
                    if (bitmapDrawable3 instanceof GradientDrawable) {
                        GradientDrawable gradientDrawable2 = (GradientDrawable) bitmapDrawable3;
                        GradientDrawable gradientDrawable3 = (GradientDrawable) bitmapDrawable3;
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                fieldValue = Float.valueOf(gradientDrawable3.getCornerRadius());
                            } else {
                                fieldValue = ReflectionUtil.getFieldValue(gradientDrawable3.getConstantState(), "mRadius");
                            }
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
                            }
                            if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                                float floatValue5 = ((Number) fieldValue).floatValue();
                                if (i2 != 1 && (i != 0 || i2 != 0)) {
                                    if ((i2 >= 0 && i2 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                        z3 = true;
                                        if (z3) {
                                            scaled1DSizeInfo2 = new Scaled1DSizeInfo(false, 1.0f, floatValue5);
                                        } else {
                                            float floatValue6 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr3 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr3[i2].floatValue() : SCALED_RATIO_T[i2].floatValue() : SCALED_RATIO_H[i2].floatValue() : SCALED_RATIO_CONTENT[i2].floatValue() : SCALED_RATIO_FRAMEWORK[i2].floatValue();
                                            scaled1DSizeInfo2 = new Scaled1DSizeInfo(true, floatValue6, floatValue5 * floatValue6);
                                        }
                                        if (!scaled1DSizeInfo2.isScaledRequired()) {
                                            floatValue5 = scaled1DSizeInfo2.getScaledSize();
                                        }
                                        gradientDrawable3.setCornerRadius(floatValue5);
                                    }
                                }
                                z3 = false;
                                if (z3) {
                                }
                                if (!scaled1DSizeInfo2.isScaledRequired()) {
                                }
                                gradientDrawable3.setCornerRadius(floatValue5);
                            }
                        } catch (Exception e8) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                e8.printStackTrace();
                            }
                        }
                        Unit unit9 = Unit.INSTANCE;
                    } else {
                        if (bitmapDrawable3 instanceof NinePatchDrawable) {
                            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) bitmapDrawable3;
                            if (ninePatchDrawable != null) {
                                if (i2 != 1 && (i != 0 || i2 != 0)) {
                                    if (i2 >= 0 && i2 < 5) {
                                        if (i <= -1 || i >= 4) {
                                            try {
                                                if (!mCustomerRatios.containsKey(Integer.valueOf(i))) {
                                                }
                                            } catch (Exception e9) {
                                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                    e9.printStackTrace();
                                                }
                                            }
                                        }
                                        z2 = true;
                                        if (z2) {
                                            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
                                        } else {
                                            float floatValue7 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr2[i2].floatValue() : SCALED_RATIO_T[i2].floatValue() : SCALED_RATIO_H[i2].floatValue() : SCALED_RATIO_CONTENT[i2].floatValue() : SCALED_RATIO_FRAMEWORK[i2].floatValue();
                                            scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue7, 1.0f * floatValue7);
                                        }
                                        float scaledSize = scaled1DSizeInfo.isScaledRequired() ? 1.0f : scaled1DSizeInfo.getScaledSize();
                                        int i22 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                        float f2 = i22 * scaledSize;
                                        ninePatchDrawable.setTargetDensity((int) f2);
                                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                            Log.d(TAG, "scaled: " + scaledSize + ", displayMetrics: " + i22 + ", result: " + f2);
                                        }
                                        Unit unit10 = Unit.INSTANCE;
                                        bitmapDrawable = ninePatchDrawable;
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                }
                                if (scaled1DSizeInfo.isScaledRequired()) {
                                }
                                int i222 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                float f22 = i222 * scaledSize;
                                ninePatchDrawable.setTargetDensity((int) f22);
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                }
                                Unit unit102 = Unit.INSTANCE;
                                bitmapDrawable = ninePatchDrawable;
                            }
                        } else if (bitmapDrawable3 != null) {
                            float standardScreen7 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                            float standardScreen8 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                            if (i2 != 1 && (i != 0 || i2 != 0)) {
                                if ((i2 >= 0 && i2 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                    z = true;
                                    if (z) {
                                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen7, standardScreen8);
                                    } else {
                                        float floatValue8 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr[i2].floatValue() : SCALED_RATIO_T[i2].floatValue() : SCALED_RATIO_H[i2].floatValue() : SCALED_RATIO_CONTENT[i2].floatValue() : SCALED_RATIO_FRAMEWORK[i2].floatValue();
                                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen7 * floatValue8, standardScreen8 * floatValue8);
                                    }
                                    if (!scaled2DSizeInfo.isScaledRequired()) {
                                        float scaledWidth3 = scaled2DSizeInfo.getScaledWidth();
                                        float scaledHeight3 = scaled2DSizeInfo.getScaledHeight();
                                        int intrinsicWidth = drawable.getIntrinsicWidth();
                                        int intrinsicHeight = drawable.getIntrinsicHeight();
                                        if (drawable.getOpacity() != -1) {
                                            config = Bitmap.Config.ARGB_8888;
                                        } else {
                                            config = Bitmap.Config.RGB_565;
                                        }
                                        Bitmap bitmap4 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                                        Canvas canvas = new Canvas(bitmap4);
                                        bitmapDrawable3.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                                        bitmapDrawable3.draw(canvas);
                                        Intrinsics.checkNotNullExpressionValue(bitmap4, "bitmap");
                                        if (i3 == 0) {
                                            ceil = Math.ceil(scaledWidth3);
                                        } else if (i3 == 1) {
                                            ceil = Math.floor(scaledWidth3);
                                        } else {
                                            if (i3 != 2) {
                                                i5 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            } else {
                                                i5 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            }
                                            if (i3 != 0) {
                                                ceil2 = Math.ceil(scaledHeight3);
                                            } else if (i3 == 1) {
                                                ceil2 = Math.floor(scaledHeight3);
                                            } else {
                                                if (i3 != 2) {
                                                    i6 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                } else {
                                                    i6 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                }
                                                bitmapDrawable3 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i5, i6, true));
                                            }
                                            i6 = (int) ceil2;
                                            bitmapDrawable3 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i5, i6, true));
                                        }
                                        i5 = (int) ceil;
                                        if (i3 != 0) {
                                        }
                                        i6 = (int) ceil2;
                                        bitmapDrawable3 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i5, i6, true));
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                            if (!scaled2DSizeInfo.isScaledRequired()) {
                            }
                        }
                        bitmapDrawable = null;
                    }
                    bitmapDrawable = bitmapDrawable3;
                }
            }
            return bitmapDrawable;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e9 A[Catch: Exception -> 0x04c1, Error -> 0x04c6, TRY_LEAVE, TryCatch #8 {Error -> 0x04c6, blocks: (B:69:0x0136, B:107:0x01e1, B:110:0x01e9, B:160:0x02c4, B:162:0x02ca, B:164:0x02e3, B:167:0x02e9, B:169:0x02ed, B:171:0x02f3, B:177:0x0304, B:188:0x0332, B:195:0x034f, B:269:0x049b, B:191:0x033a, B:192:0x033f, B:194:0x034c, B:193:0x0346, B:179:0x0310, B:180:0x0315, B:182:0x0328, B:181:0x031e, B:196:0x0360, B:198:0x036a, B:199:0x036c, B:201:0x0372, B:203:0x0383, B:205:0x038d, B:206:0x03a7, B:208:0x03ab, B:210:0x03b6, B:232:0x03e9, B:253:0x045d, B:257:0x0468, B:256:0x0464, B:240:0x03ff, B:242:0x040d, B:244:0x041d, B:250:0x0452, B:252:0x0459, B:264:0x0472, B:266:0x047c, B:246:0x0427, B:247:0x0432, B:248:0x043d, B:249:0x0448, B:227:0x03d7, B:202:0x037b, B:270:0x04a5, B:277:0x04b7, B:278:0x04bb, B:274:0x04aa, B:276:0x04b4, B:106:0x01d7, B:105:0x01cd, B:83:0x0161), top: B:505:0x0136 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x028f A[Catch: all -> 0x02b0, TryCatch #1 {all -> 0x02b0, blocks: (B:117:0x0208, B:119:0x0222, B:122:0x0228, B:124:0x022d, B:126:0x0235, B:131:0x0259, B:136:0x0270, B:142:0x027e, B:148:0x0297, B:144:0x0284, B:145:0x0289, B:147:0x0294, B:146:0x028f, B:132:0x025e, B:133:0x0263, B:135:0x026e, B:134:0x0269, B:149:0x02a3, B:150:0x02a8, B:152:0x02ac), top: B:494:0x0208 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0346 A[Catch: Exception -> 0x04a8, Error -> 0x04c6, TryCatch #5 {Exception -> 0x04a8, blocks: (B:162:0x02ca, B:164:0x02e3, B:167:0x02e9, B:169:0x02ed, B:171:0x02f3, B:177:0x0304, B:188:0x0332, B:195:0x034f, B:269:0x049b, B:191:0x033a, B:192:0x033f, B:194:0x034c, B:193:0x0346, B:179:0x0310, B:180:0x0315, B:182:0x0328, B:181:0x031e, B:196:0x0360, B:198:0x036a, B:264:0x0472, B:266:0x047c, B:270:0x04a5), top: B:502:0x02ca }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03e9 A[Catch: Exception -> 0x046e, Error -> 0x04c6, TryCatch #2 {Exception -> 0x046e, blocks: (B:199:0x036c, B:201:0x0372, B:203:0x0383, B:205:0x038d, B:206:0x03a7, B:208:0x03ab, B:210:0x03b6, B:232:0x03e9, B:240:0x03ff, B:242:0x040d, B:244:0x041d, B:250:0x0452, B:246:0x0427, B:247:0x0432, B:248:0x043d, B:249:0x0448, B:227:0x03d7, B:202:0x037b), top: B:496:0x036c }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[Catch: Exception -> 0x0848, Error -> 0x0858, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0552 A[Catch: Exception -> 0x05d0, Error -> 0x0858, TryCatch #0 {Exception -> 0x05d0, blocks: (B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:290:0x04e4), top: B:492:0x04d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x05c8 A[Catch: Exception -> 0x05d0, Error -> 0x0858, TryCatch #0 {Exception -> 0x05d0, blocks: (B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:290:0x04e4), top: B:492:0x04d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x062e A[Catch: Exception -> 0x063a, Error -> 0x0858, TryCatch #4 {Exception -> 0x063a, blocks: (B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c), top: B:500:0x061c }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06af A[Catch: Exception -> 0x063a, Error -> 0x0858, TryCatch #4 {Exception -> 0x063a, blocks: (B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c), top: B:500:0x061c }] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x06d2 A[Catch: Exception -> 0x063a, Error -> 0x0858, TRY_LEAVE, TryCatch #4 {Exception -> 0x063a, blocks: (B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c), top: B:500:0x061c }] */
    /* JADX WARN: Removed duplicated region for block: B:431:0x074b A[Catch: Exception -> 0x0848, Error -> 0x0858, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4 A[Catch: Exception -> 0x0848, Error -> 0x0858, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x07c2 A[Catch: Exception -> 0x0848, Error -> 0x0858, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x082d A[Catch: Exception -> 0x0848, Error -> 0x0858, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0464 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0103 A[Catch: Exception -> 0x0848, Error -> 0x0858, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0173 A[Catch: Exception -> 0x0848, Error -> 0x0858, TRY_ENTER, TryCatch #6 {Error -> 0x0858, blocks: (B:4:0x000a, B:6:0x0015, B:25:0x0053, B:41:0x00bd, B:62:0x011b, B:44:0x00c4, B:48:0x00d6, B:56:0x00f3, B:61:0x010a, B:57:0x00f8, B:58:0x00fd, B:60:0x0108, B:59:0x0103, B:49:0x00db, B:50:0x00e0, B:52:0x00eb, B:51:0x00e6, B:30:0x0061, B:32:0x006f, B:34:0x007f, B:40:0x00b4, B:36:0x0089, B:37:0x0094, B:38:0x009f, B:39:0x00aa, B:20:0x0041, B:63:0x0120, B:88:0x0173, B:113:0x01f9, B:115:0x01fd, B:157:0x02bb, B:158:0x02bf, B:156:0x02b2, B:95:0x0184, B:97:0x0192, B:99:0x01a2, B:101:0x01ac, B:102:0x01b7, B:103:0x01c2, B:284:0x04cb, B:286:0x04cf, B:287:0x04d5, B:289:0x04db, B:291:0x04ec, B:293:0x04f6, B:294:0x0510, B:296:0x0514, B:298:0x051f, B:320:0x0552, B:339:0x05c1, B:343:0x05cc, B:342:0x05c8, B:328:0x0566, B:330:0x0574, B:332:0x0584, B:338:0x05b9, B:334:0x058e, B:335:0x0599, B:336:0x05a4, B:337:0x05af, B:315:0x0540, B:350:0x05f6, B:290:0x04e4, B:347:0x05d2, B:349:0x05dc, B:351:0x05fa, B:353:0x05fe, B:376:0x062e, B:397:0x06a6, B:401:0x06b3, B:403:0x06d2, B:408:0x0705, B:400:0x06af, B:386:0x0649, B:388:0x0657, B:390:0x0667, B:396:0x069c, B:392:0x0671, B:393:0x067c, B:394:0x0687, B:395:0x0692, B:371:0x061c, B:405:0x06f8, B:407:0x0702, B:409:0x070a, B:431:0x074b, B:450:0x07ba, B:453:0x07c2, B:455:0x07d9, B:457:0x07de, B:463:0x07fd, B:473:0x081c, B:479:0x0835, B:475:0x0822, B:476:0x0827, B:478:0x0832, B:477:0x082d, B:464:0x0802, B:465:0x0807, B:467:0x0812, B:466:0x080d, B:456:0x07dc, B:439:0x075d, B:441:0x076b, B:443:0x077b, B:449:0x07b0, B:445:0x0785, B:446:0x0790, B:447:0x079b, B:448:0x07a6, B:426:0x0739, B:66:0x0126), top: B:504:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Drawable getScaledDrawableInner(int i, Drawable drawable, int i2, int i3, int i4) {
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        Object[] objArr;
        int i5;
        int i6;
        String str;
        int i7;
        Object fieldValue;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr2;
        double ceil;
        int i8;
        double ceil2;
        int i9;
        int roundToInt;
        int roundToInt2;
        Unit unit;
        double ceil3;
        int i10;
        double ceil4;
        int i11;
        boolean z3;
        Scaled2DSizeInfo scaled2DSizeInfo2;
        Float[] fArr3;
        Bitmap.Config config;
        double ceil5;
        int i12;
        double ceil6;
        int i13;
        boolean z4;
        Scaled1DSizeInfo scaled1DSizeInfo2;
        Float[] fArr4;
        Object fieldValue2;
        boolean z5;
        Scaled1DSizeInfo scaled1DSizeInfo3;
        Float[] fArr5;
        boolean z6;
        Scaled2DSizeInfo scaled2DSizeInfo3;
        Float[] fArr6;
        double ceil7;
        int i14;
        double ceil8;
        int i15;
        BitmapDrawable bitmapDrawable = drawable;
        int i16 = i4;
        if (bitmapDrawable != null) {
            try {
                try {
                    int i17 = 1;
                    if (bitmapDrawable instanceof BitmapDrawable) {
                        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) bitmapDrawable;
                        float standardScreen = DisplayUtilsKt.toStandardScreen(bitmapDrawable2.getIntrinsicWidth());
                        float standardScreen2 = DisplayUtilsKt.toStandardScreen(bitmapDrawable2.getIntrinsicHeight());
                        if (i3 != 1 && (i != 0 || i3 != 0)) {
                            if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                z6 = true;
                                if (z6) {
                                    scaled2DSizeInfo3 = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                                } else {
                                    float floatValue = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr6 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr6[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                    scaled2DSizeInfo3 = new Scaled2DSizeInfo(true, standardScreen * floatValue, standardScreen2 * floatValue);
                                }
                                if (!scaled2DSizeInfo3.isScaledRequired()) {
                                    float scaledWidth = scaled2DSizeInfo3.getScaledWidth();
                                    float scaledHeight = scaled2DSizeInfo3.getScaledHeight();
                                    Bitmap bitmap = bitmapDrawable2.getBitmap();
                                    if (i16 == 0) {
                                        ceil7 = Math.ceil(scaledWidth);
                                    } else if (i16 == 1) {
                                        ceil7 = Math.floor(scaledWidth);
                                    } else {
                                        if (i16 != 2) {
                                            i14 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                        } else {
                                            i14 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                        }
                                        if (i16 != 0) {
                                            ceil8 = Math.ceil(scaledHeight);
                                        } else if (i16 == 1) {
                                            ceil8 = Math.floor(scaledHeight);
                                        } else {
                                            if (i16 != 2) {
                                                i15 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i15 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                        }
                                        i15 = (int) ceil8;
                                        bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                    }
                                    i14 = (int) ceil7;
                                    if (i16 != 0) {
                                    }
                                    i15 = (int) ceil8;
                                    bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i14, i15, true));
                                }
                                bitmapDrawable = bitmapDrawable2;
                            }
                        }
                        z6 = false;
                        if (z6) {
                        }
                        if (!scaled2DSizeInfo3.isScaledRequired()) {
                        }
                        bitmapDrawable = bitmapDrawable2;
                    } else {
                        String str2 = ", GradientDrawable ReflectionUtil Error";
                        if (bitmapDrawable instanceof StateListDrawable ? true : bitmapDrawable instanceof LevelListDrawable) {
                            try {
                                try {
                                    float standardScreen3 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                                    float standardScreen4 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                                    if (i3 != 1 && (i != 0 || i3 != 0)) {
                                        if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                            z = true;
                                            if (z) {
                                                scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen3, standardScreen4);
                                            } else {
                                                float floatValue2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen3 * floatValue2, standardScreen4 * floatValue2);
                                            }
                                            if (!scaled2DSizeInfo.isScaledRequired()) {
                                                float scaledWidth2 = scaled2DSizeInfo.getScaledWidth();
                                                float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                                                if (Build.VERSION.SDK_INT <= 23 && (bitmapDrawable instanceof LevelListDrawable)) {
                                                    LevelListDrawable levelListDrawable = new LevelListDrawable();
                                                    Drawable.ConstantState constantState = drawable.getConstantState();
                                                    if (constantState != null) {
                                                        try {
                                                            Result.Companion companion = Result.Companion;
                                                            Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                                                            method.setAccessible(true);
                                                            Object invoke = method.invoke(constantState, new Object[0]);
                                                            Object[] objArr2 = invoke instanceof Object[] ? (Object[]) invoke : null;
                                                            if (objArr2 != null) {
                                                                int length = objArr2.length;
                                                                int i18 = 0;
                                                                int i19 = 0;
                                                                while (i19 < length) {
                                                                    Object obj = objArr2[i19];
                                                                    int i20 = i18 + 1;
                                                                    if (obj instanceof BitmapDrawable) {
                                                                        Bitmap bitmap2 = ((BitmapDrawable) obj).getBitmap();
                                                                        float f = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                                                                        float standardScreen5 = DisplayUtilsKt.toStandardScreen(scaledWidth2 * f);
                                                                        if (i16 == 0) {
                                                                            ceil3 = Math.ceil(standardScreen5);
                                                                        } else if (i16 == i17) {
                                                                            ceil3 = Math.floor(standardScreen5);
                                                                        } else {
                                                                            if (i16 != 2) {
                                                                                i10 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                            } else {
                                                                                i10 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                            }
                                                                            float standardScreen6 = DisplayUtilsKt.toStandardScreen(f * scaledHeight2);
                                                                            if (i16 != 0) {
                                                                                ceil4 = Math.ceil(standardScreen6);
                                                                            } else if (i16 == 1) {
                                                                                ceil4 = Math.floor(standardScreen6);
                                                                            } else {
                                                                                if (i16 != 2) {
                                                                                    i11 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                                } else {
                                                                                    i11 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                                }
                                                                                levelListDrawable.addLevel(i18, i18, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i10, i11, true)));
                                                                            }
                                                                            i11 = (int) ceil4;
                                                                            levelListDrawable.addLevel(i18, i18, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i10, i11, true)));
                                                                        }
                                                                        i10 = (int) ceil3;
                                                                        float standardScreen62 = DisplayUtilsKt.toStandardScreen(f * scaledHeight2);
                                                                        if (i16 != 0) {
                                                                        }
                                                                        i11 = (int) ceil4;
                                                                        levelListDrawable.addLevel(i18, i18, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i10, i11, true)));
                                                                    }
                                                                    i19++;
                                                                    i18 = i20;
                                                                    i17 = 1;
                                                                }
                                                                unit = Unit.INSTANCE;
                                                            } else {
                                                                unit = null;
                                                            }
                                                            Result.m855constructorimpl(unit);
                                                        } catch (Throwable th) {
                                                            Result.Companion companion2 = Result.Companion;
                                                            Result.m855constructorimpl(ResultKt.createFailure(th));
                                                        }
                                                        Unit unit2 = Unit.INSTANCE;
                                                        Unit unit3 = Unit.INSTANCE;
                                                    }
                                                    Unit unit4 = Unit.INSTANCE;
                                                    bitmapDrawable = levelListDrawable;
                                                } else {
                                                    Drawable.ConstantState constantState2 = drawable.getConstantState();
                                                    if (constantState2 != null) {
                                                        try {
                                                            Method method2 = constantState2.getClass().getMethod("getChildren", new Class[0]);
                                                            method2.setAccessible(true);
                                                            Object invoke2 = method2.invoke(constantState2, new Object[0]);
                                                            Object[] objArr3 = invoke2 instanceof Object[] ? (Object[]) invoke2 : null;
                                                            if (objArr3 != null) {
                                                                int i21 = 0;
                                                                for (int length2 = objArr3.length; i21 < length2; length2 = i7) {
                                                                    Object obj2 = objArr3[i21];
                                                                    if (obj2 instanceof BitmapDrawable) {
                                                                        Bitmap bitmap3 = ((BitmapDrawable) obj2).getBitmap();
                                                                        if (i16 != 0) {
                                                                            objArr = objArr3;
                                                                            if (i16 == 1) {
                                                                                i5 = length2;
                                                                                i6 = i21;
                                                                                ceil = Math.floor(scaledWidth2);
                                                                            } else {
                                                                                if (i16 != 2) {
                                                                                    roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                                } else {
                                                                                    roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                                }
                                                                                i6 = i21;
                                                                                int i22 = length2;
                                                                                i8 = roundToInt2;
                                                                                i5 = i22;
                                                                                if (i16 != 0) {
                                                                                    str = str2;
                                                                                    ceil2 = Math.ceil(scaledHeight2);
                                                                                } else if (i16 == 1) {
                                                                                    str = str2;
                                                                                    ceil2 = Math.floor(scaledHeight2);
                                                                                } else {
                                                                                    if (i16 != 2) {
                                                                                        roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                    } else {
                                                                                        roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                    }
                                                                                    i9 = roundToInt;
                                                                                    str = str2;
                                                                                    ReflectionUtil.invokeMethod(obj2, "setBitmap", Bitmap.createScaledBitmap(bitmap3, i8, i9, true));
                                                                                }
                                                                                i9 = (int) ceil2;
                                                                                ReflectionUtil.invokeMethod(obj2, "setBitmap", Bitmap.createScaledBitmap(bitmap3, i8, i9, true));
                                                                            }
                                                                        } else {
                                                                            objArr = objArr3;
                                                                            i5 = length2;
                                                                            i6 = i21;
                                                                            ceil = Math.ceil(scaledWidth2);
                                                                        }
                                                                        i8 = (int) ceil;
                                                                        if (i16 != 0) {
                                                                        }
                                                                        i9 = (int) ceil2;
                                                                        ReflectionUtil.invokeMethod(obj2, "setBitmap", Bitmap.createScaledBitmap(bitmap3, i8, i9, true));
                                                                    } else {
                                                                        objArr = objArr3;
                                                                        i5 = length2;
                                                                        i6 = i21;
                                                                        str = str2;
                                                                        if (obj2 instanceof GradientDrawable) {
                                                                            GradientDrawable gradientDrawable = (GradientDrawable) obj2;
                                                                            try {
                                                                                if (Build.VERSION.SDK_INT >= 24) {
                                                                                    fieldValue = Float.valueOf(gradientDrawable.getCornerRadius());
                                                                                } else {
                                                                                    fieldValue = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
                                                                                }
                                                                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                    Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
                                                                                }
                                                                            } catch (Exception e) {
                                                                                e = e;
                                                                                i7 = i5;
                                                                            }
                                                                            if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                                                                                float floatValue3 = ((Number) fieldValue).floatValue();
                                                                                if (i3 != 1 && (i != 0 || i3 != 0)) {
                                                                                    if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                                                                        z2 = true;
                                                                                        if (z2) {
                                                                                            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, floatValue3);
                                                                                            i7 = i5;
                                                                                        } else {
                                                                                            float floatValue4 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr2[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                                                            i7 = i5;
                                                                                            scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue4, floatValue3 * floatValue4);
                                                                                        }
                                                                                        if (!scaled1DSizeInfo.isScaledRequired()) {
                                                                                            try {
                                                                                                floatValue3 = scaled1DSizeInfo.getScaledSize();
                                                                                            } catch (Exception e2) {
                                                                                                e = e2;
                                                                                                Exception exc = e;
                                                                                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                                    StringBuilder sb = new StringBuilder();
                                                                                                    sb.append("Version: ");
                                                                                                    sb.append(Build.VERSION.SDK_INT);
                                                                                                    str2 = str;
                                                                                                    sb.append(str2);
                                                                                                    Log.d(TAG, sb.toString());
                                                                                                    exc.printStackTrace();
                                                                                                    i21 = i6 + 1;
                                                                                                    objArr3 = objArr;
                                                                                                    i16 = i4;
                                                                                                }
                                                                                                str2 = str;
                                                                                                i21 = i6 + 1;
                                                                                                objArr3 = objArr;
                                                                                                i16 = i4;
                                                                                            }
                                                                                        }
                                                                                        gradientDrawable.setCornerRadius(floatValue3);
                                                                                        str2 = str;
                                                                                        i21 = i6 + 1;
                                                                                        objArr3 = objArr;
                                                                                        i16 = i4;
                                                                                    }
                                                                                }
                                                                                z2 = false;
                                                                                if (z2) {
                                                                                }
                                                                                if (!scaled1DSizeInfo.isScaledRequired()) {
                                                                                }
                                                                                gradientDrawable.setCornerRadius(floatValue3);
                                                                                str2 = str;
                                                                                i21 = i6 + 1;
                                                                                objArr3 = objArr;
                                                                                i16 = i4;
                                                                            }
                                                                        }
                                                                    }
                                                                    i7 = i5;
                                                                    str2 = str;
                                                                    i21 = i6 + 1;
                                                                    objArr3 = objArr;
                                                                    i16 = i4;
                                                                }
                                                                Unit unit5 = Unit.INSTANCE;
                                                            }
                                                        } catch (Exception e3) {
                                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                e3.printStackTrace();
                                                            }
                                                        }
                                                        Unit unit6 = Unit.INSTANCE;
                                                        Unit unit7 = Unit.INSTANCE;
                                                    }
                                                    Unit unit8 = Unit.INSTANCE;
                                                }
                                            }
                                            bitmapDrawable = drawable;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                    if (!scaled2DSizeInfo.isScaledRequired()) {
                                    }
                                    bitmapDrawable = drawable;
                                } catch (Error e4) {
                                    e = e4;
                                    bitmapDrawable = drawable;
                                    Error error = e;
                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                        error.printStackTrace();
                                    }
                                    return bitmapDrawable;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                bitmapDrawable = drawable;
                                Exception exc2 = e;
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    exc2.printStackTrace();
                                }
                                return bitmapDrawable;
                            }
                        } else if (bitmapDrawable instanceof GradientDrawable) {
                            GradientDrawable gradientDrawable2 = (GradientDrawable) bitmapDrawable;
                            GradientDrawable gradientDrawable3 = (GradientDrawable) bitmapDrawable;
                            try {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    fieldValue2 = Float.valueOf(gradientDrawable3.getCornerRadius());
                                } else {
                                    fieldValue2 = ReflectionUtil.getFieldValue(gradientDrawable3.getConstantState(), "mRadius");
                                }
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue2);
                                }
                                if ((fieldValue2 instanceof Float) && ((Number) fieldValue2).floatValue() > 0.0f) {
                                    float floatValue5 = ((Number) fieldValue2).floatValue();
                                    if (i3 != 1 && (i != 0 || i3 != 0)) {
                                        if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                            z5 = true;
                                            if (z5) {
                                                scaled1DSizeInfo3 = new Scaled1DSizeInfo(false, 1.0f, floatValue5);
                                            } else {
                                                float floatValue6 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr5 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr5[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                scaled1DSizeInfo3 = new Scaled1DSizeInfo(true, floatValue6, floatValue5 * floatValue6);
                                            }
                                            if (!scaled1DSizeInfo3.isScaledRequired()) {
                                                floatValue5 = scaled1DSizeInfo3.getScaledSize();
                                            }
                                            gradientDrawable3.setCornerRadius(floatValue5);
                                        }
                                    }
                                    z5 = false;
                                    if (z5) {
                                    }
                                    if (!scaled1DSizeInfo3.isScaledRequired()) {
                                    }
                                    gradientDrawable3.setCornerRadius(floatValue5);
                                }
                            } catch (Exception e6) {
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                    e6.printStackTrace();
                                }
                            }
                            Unit unit9 = Unit.INSTANCE;
                        } else if (bitmapDrawable instanceof NinePatchDrawable) {
                            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) bitmapDrawable;
                            if (i3 != 1 && (i != 0 || i3 != 0)) {
                                if (i3 >= 0 && i3 < 5) {
                                    if (i <= -1 || i >= 4) {
                                        try {
                                            if (!mCustomerRatios.containsKey(Integer.valueOf(i))) {
                                            }
                                        } catch (Exception e7) {
                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                e7.printStackTrace();
                                            }
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                        scaled1DSizeInfo2 = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
                                    } else {
                                        float floatValue7 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr4 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr4[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                        scaled1DSizeInfo2 = new Scaled1DSizeInfo(true, floatValue7, 1.0f * floatValue7);
                                    }
                                    float scaledSize = scaled1DSizeInfo2.isScaledRequired() ? 1.0f : scaled1DSizeInfo2.getScaledSize();
                                    int i23 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                    float f2 = i23 * scaledSize;
                                    ninePatchDrawable.setTargetDensity((int) f2);
                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                        Log.d(TAG, "scaled: " + scaledSize + ", displayMetrics: " + i23 + ", result: " + f2);
                                    }
                                    Unit unit10 = Unit.INSTANCE;
                                    bitmapDrawable = ninePatchDrawable;
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                            if (scaled1DSizeInfo2.isScaledRequired()) {
                            }
                            int i232 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                            float f22 = i232 * scaledSize;
                            ninePatchDrawable.setTargetDensity((int) f22);
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                            }
                            Unit unit102 = Unit.INSTANCE;
                            bitmapDrawable = ninePatchDrawable;
                        } else {
                            float standardScreen7 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                            float standardScreen8 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                            if (i3 != 1 && (i != 0 || i3 != 0)) {
                                if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                    z3 = true;
                                    if (z3) {
                                        scaled2DSizeInfo2 = new Scaled2DSizeInfo(false, standardScreen7, standardScreen8);
                                    } else {
                                        float floatValue8 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr3 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr3[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                        scaled2DSizeInfo2 = new Scaled2DSizeInfo(true, standardScreen7 * floatValue8, standardScreen8 * floatValue8);
                                    }
                                    if (!scaled2DSizeInfo2.isScaledRequired()) {
                                        float scaledWidth3 = scaled2DSizeInfo2.getScaledWidth();
                                        float scaledHeight3 = scaled2DSizeInfo2.getScaledHeight();
                                        int intrinsicWidth = drawable.getIntrinsicWidth();
                                        int intrinsicHeight = drawable.getIntrinsicHeight();
                                        if (drawable.getOpacity() != -1) {
                                            config = Bitmap.Config.ARGB_8888;
                                        } else {
                                            config = Bitmap.Config.RGB_565;
                                        }
                                        Bitmap bitmap4 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                                        Canvas canvas = new Canvas(bitmap4);
                                        bitmapDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                                        bitmapDrawable.draw(canvas);
                                        Intrinsics.checkNotNullExpressionValue(bitmap4, "bitmap");
                                        if (i4 == 0) {
                                            ceil5 = Math.ceil(scaledWidth3);
                                        } else if (i4 == 1) {
                                            ceil5 = Math.floor(scaledWidth3);
                                        } else {
                                            if (i4 != 2) {
                                                i12 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            } else {
                                                i12 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            }
                                            if (i4 != 0) {
                                                ceil6 = Math.ceil(scaledHeight3);
                                            } else if (i4 == 1) {
                                                ceil6 = Math.floor(scaledHeight3);
                                            } else {
                                                if (i4 != 2) {
                                                    i13 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                } else {
                                                    i13 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                }
                                                bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i12, i13, true));
                                            }
                                            i13 = (int) ceil6;
                                            bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i12, i13, true));
                                        }
                                        i12 = (int) ceil5;
                                        if (i4 != 0) {
                                        }
                                        i13 = (int) ceil6;
                                        bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i12, i13, true));
                                    }
                                }
                            }
                            z3 = false;
                            if (z3) {
                            }
                            if (!scaled2DSizeInfo2.isScaledRequired()) {
                            }
                        }
                    }
                } catch (Error e8) {
                    e = e8;
                }
            } catch (Exception e9) {
                e = e9;
            }
            return bitmapDrawable;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v66, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ef A[Catch: Exception -> 0x04d3, Error -> 0x04d8, TRY_LEAVE, TryCatch #6 {Error -> 0x04d8, blocks: (B:72:0x013c, B:110:0x01e7, B:113:0x01ef, B:163:0x02ca, B:165:0x02d0, B:167:0x02e9, B:170:0x02ef, B:172:0x02f3, B:174:0x02f9, B:180:0x030a, B:191:0x0338, B:197:0x035e, B:271:0x04ac, B:193:0x0345, B:194:0x034a, B:196:0x035b, B:195:0x0353, B:182:0x0316, B:183:0x031b, B:185:0x032e, B:184:0x0324, B:198:0x036f, B:200:0x037b, B:201:0x037d, B:203:0x0383, B:205:0x0394, B:207:0x039e, B:208:0x03b8, B:210:0x03bc, B:212:0x03c7, B:234:0x03fa, B:255:0x046e, B:259:0x0479, B:258:0x0475, B:242:0x0410, B:244:0x041e, B:246:0x042e, B:252:0x0463, B:254:0x046a, B:266:0x0483, B:268:0x048d, B:248:0x0438, B:249:0x0443, B:250:0x044e, B:251:0x0459, B:229:0x03e8, B:204:0x038c, B:272:0x04b7, B:279:0x04c9, B:280:0x04cd, B:276:0x04bc, B:278:0x04c6, B:109:0x01dd, B:108:0x01d3, B:86:0x0167), top: B:506:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0295 A[Catch: all -> 0x02b6, TryCatch #4 {all -> 0x02b6, blocks: (B:120:0x020e, B:122:0x0228, B:125:0x022e, B:127:0x0233, B:129:0x023b, B:134:0x025f, B:139:0x0276, B:145:0x0284, B:151:0x029d, B:147:0x028a, B:148:0x028f, B:150:0x029a, B:149:0x0295, B:135:0x0264, B:136:0x0269, B:138:0x0274, B:137:0x026f, B:152:0x02a9, B:153:0x02ae, B:155:0x02b2), top: B:503:0x020e }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0353 A[Catch: Exception -> 0x04ba, Error -> 0x04d8, TryCatch #3 {Exception -> 0x04ba, blocks: (B:165:0x02d0, B:167:0x02e9, B:170:0x02ef, B:172:0x02f3, B:174:0x02f9, B:180:0x030a, B:191:0x0338, B:197:0x035e, B:271:0x04ac, B:193:0x0345, B:194:0x034a, B:196:0x035b, B:195:0x0353, B:182:0x0316, B:183:0x031b, B:185:0x032e, B:184:0x0324, B:198:0x036f, B:200:0x037b, B:266:0x0483, B:268:0x048d, B:272:0x04b7), top: B:501:0x02d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03fa A[Catch: Exception -> 0x047f, Error -> 0x04d8, TryCatch #0 {Exception -> 0x047f, blocks: (B:201:0x037d, B:203:0x0383, B:205:0x0394, B:207:0x039e, B:208:0x03b8, B:210:0x03bc, B:212:0x03c7, B:234:0x03fa, B:242:0x0410, B:244:0x041e, B:246:0x042e, B:252:0x0463, B:248:0x0438, B:249:0x0443, B:250:0x044e, B:251:0x0459, B:229:0x03e8, B:204:0x038c), top: B:495:0x037d }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059 A[Catch: Exception -> 0x0859, Error -> 0x0869, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0565 A[Catch: Exception -> 0x05e3, Error -> 0x0869, TryCatch #7 {Error -> 0x0869, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:290:0x04e8, B:292:0x04ee, B:294:0x04ff, B:296:0x0509, B:297:0x0523, B:299:0x0527, B:301:0x0532, B:323:0x0565, B:342:0x05d4, B:346:0x05df, B:345:0x05db, B:331:0x0579, B:333:0x0587, B:335:0x0597, B:341:0x05cc, B:337:0x05a1, B:338:0x05ac, B:339:0x05b7, B:340:0x05c2, B:318:0x0553, B:353:0x0609, B:293:0x04f7, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:379:0x0641, B:400:0x06b9, B:404:0x06c6, B:406:0x06e5, B:411:0x0718, B:403:0x06c2, B:389:0x065c, B:391:0x066a, B:393:0x067a, B:399:0x06af, B:395:0x0684, B:396:0x068f, B:397:0x069a, B:398:0x06a5, B:374:0x062f, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x05db A[Catch: Exception -> 0x05e3, Error -> 0x0869, TryCatch #7 {Error -> 0x0869, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:290:0x04e8, B:292:0x04ee, B:294:0x04ff, B:296:0x0509, B:297:0x0523, B:299:0x0527, B:301:0x0532, B:323:0x0565, B:342:0x05d4, B:346:0x05df, B:345:0x05db, B:331:0x0579, B:333:0x0587, B:335:0x0597, B:341:0x05cc, B:337:0x05a1, B:338:0x05ac, B:339:0x05b7, B:340:0x05c2, B:318:0x0553, B:353:0x0609, B:293:0x04f7, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:379:0x0641, B:400:0x06b9, B:404:0x06c6, B:406:0x06e5, B:411:0x0718, B:403:0x06c2, B:389:0x065c, B:391:0x066a, B:393:0x067a, B:399:0x06af, B:395:0x0684, B:396:0x068f, B:397:0x069a, B:398:0x06a5, B:374:0x062f, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0641 A[Catch: Exception -> 0x064d, Error -> 0x0869, TryCatch #1 {Exception -> 0x064d, blocks: (B:379:0x0641, B:400:0x06b9, B:404:0x06c6, B:406:0x06e5, B:403:0x06c2, B:389:0x065c, B:391:0x066a, B:393:0x067a, B:399:0x06af, B:395:0x0684, B:396:0x068f, B:397:0x069a, B:398:0x06a5, B:374:0x062f), top: B:497:0x062f }] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x06c2 A[Catch: Exception -> 0x064d, Error -> 0x0869, TryCatch #1 {Exception -> 0x064d, blocks: (B:379:0x0641, B:400:0x06b9, B:404:0x06c6, B:406:0x06e5, B:403:0x06c2, B:389:0x065c, B:391:0x066a, B:393:0x067a, B:399:0x06af, B:395:0x0684, B:396:0x068f, B:397:0x069a, B:398:0x06a5, B:374:0x062f), top: B:497:0x062f }] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06e5 A[Catch: Exception -> 0x064d, Error -> 0x0869, TRY_LEAVE, TryCatch #1 {Exception -> 0x064d, blocks: (B:379:0x0641, B:400:0x06b9, B:404:0x06c6, B:406:0x06e5, B:403:0x06c2, B:389:0x065c, B:391:0x066a, B:393:0x067a, B:399:0x06af, B:395:0x0684, B:396:0x068f, B:397:0x069a, B:398:0x06a5, B:374:0x062f), top: B:497:0x062f }] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x075e A[Catch: Exception -> 0x0859, Error -> 0x0869, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x07d5 A[Catch: Exception -> 0x0859, Error -> 0x0869, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ca A[Catch: Exception -> 0x0859, Error -> 0x0869, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:480:0x083e A[Catch: Exception -> 0x0859, Error -> 0x0869, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0475 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0109 A[Catch: Exception -> 0x0859, Error -> 0x0869, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0179 A[Catch: Exception -> 0x0859, Error -> 0x0869, TRY_ENTER, TryCatch #5 {Exception -> 0x0859, blocks: (B:7:0x0011, B:9:0x001b, B:28:0x0059, B:44:0x00c3, B:65:0x0121, B:47:0x00ca, B:51:0x00dc, B:59:0x00f9, B:64:0x0110, B:60:0x00fe, B:61:0x0103, B:63:0x010e, B:62:0x0109, B:52:0x00e1, B:53:0x00e6, B:55:0x00f1, B:54:0x00ec, B:33:0x0067, B:35:0x0075, B:37:0x0085, B:43:0x00ba, B:39:0x008f, B:40:0x009a, B:41:0x00a5, B:42:0x00b0, B:23:0x0047, B:66:0x0126, B:91:0x0179, B:116:0x01ff, B:118:0x0203, B:160:0x02c1, B:161:0x02c5, B:159:0x02b8, B:98:0x018a, B:100:0x0198, B:102:0x01a8, B:104:0x01b2, B:105:0x01bd, B:106:0x01c8, B:287:0x04de, B:289:0x04e2, B:353:0x0609, B:350:0x05e5, B:352:0x05ef, B:354:0x060d, B:356:0x0611, B:411:0x0718, B:408:0x070b, B:410:0x0715, B:412:0x071d, B:434:0x075e, B:453:0x07cd, B:456:0x07d5, B:458:0x07ec, B:460:0x07f1, B:466:0x080e, B:476:0x082d, B:482:0x0846, B:478:0x0833, B:479:0x0838, B:481:0x0843, B:480:0x083e, B:467:0x0813, B:468:0x0818, B:470:0x0823, B:469:0x081e, B:459:0x07ef, B:442:0x0770, B:444:0x077e, B:446:0x078e, B:452:0x07c3, B:448:0x0798, B:449:0x07a3, B:450:0x07ae, B:451:0x07b9, B:429:0x074c, B:69:0x012c), top: B:505:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0180  */
    /* JADX WARN: Type inference failed for: r7v65 */
    /* JADX WARN: Type inference failed for: r7v68 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Drawable getScaledDrawableInner$default(FontSizeHelper fontSizeHelper, int i, Drawable drawable, int i2, int i3, int i4, int i5, Object obj) {
        BitmapDrawable bitmapDrawable;
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        Object[] objArr;
        float f;
        int i6;
        int i7;
        String str;
        int i8;
        String str2;
        Object fieldValue;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr2;
        double ceil;
        int i9;
        double ceil2;
        int i10;
        int i11;
        int roundToInt;
        int roundToInt2;
        Unit unit;
        double ceil3;
        int i12;
        double ceil4;
        int i13;
        boolean z3;
        Scaled2DSizeInfo scaled2DSizeInfo2;
        Float[] fArr3;
        Bitmap.Config config;
        double ceil5;
        int i14;
        double ceil6;
        int i15;
        boolean z4;
        Scaled1DSizeInfo scaled1DSizeInfo2;
        Float[] fArr4;
        Object fieldValue2;
        boolean z5;
        Scaled1DSizeInfo scaled1DSizeInfo3;
        Float[] fArr5;
        boolean z6;
        Scaled2DSizeInfo scaled2DSizeInfo3;
        Float[] fArr6;
        double ceil7;
        int i16;
        double ceil8;
        int i17;
        Drawable drawable2 = drawable;
        int i18 = (i5 & 16) != 0 ? 2 : i4;
        if (drawable2 != null) {
            try {
                try {
                    int i19 = 1;
                    if (drawable2 instanceof BitmapDrawable) {
                        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) drawable2;
                        float standardScreen = DisplayUtilsKt.toStandardScreen(bitmapDrawable2.getIntrinsicWidth());
                        float standardScreen2 = DisplayUtilsKt.toStandardScreen(bitmapDrawable2.getIntrinsicHeight());
                        if (i3 != 1 && (i != 0 || i3 != 0)) {
                            if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                z6 = true;
                                if (z6) {
                                    scaled2DSizeInfo3 = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                                } else {
                                    float floatValue = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr6 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr6[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                    scaled2DSizeInfo3 = new Scaled2DSizeInfo(true, standardScreen * floatValue, standardScreen2 * floatValue);
                                }
                                if (!scaled2DSizeInfo3.isScaledRequired()) {
                                    float scaledWidth = scaled2DSizeInfo3.getScaledWidth();
                                    float scaledHeight = scaled2DSizeInfo3.getScaledHeight();
                                    Bitmap bitmap = bitmapDrawable2.getBitmap();
                                    if (i18 == 0) {
                                        ceil7 = Math.ceil(scaledWidth);
                                    } else if (i18 == 1) {
                                        ceil7 = Math.floor(scaledWidth);
                                    } else {
                                        if (i18 != 2) {
                                            i16 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                        } else {
                                            i16 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                        }
                                        if (i18 != 0) {
                                            ceil8 = Math.ceil(scaledHeight);
                                        } else if (i18 == 1) {
                                            ceil8 = Math.floor(scaledHeight);
                                        } else {
                                            if (i18 != 2) {
                                                i17 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i17 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i16, i17, true));
                                        }
                                        i17 = (int) ceil8;
                                        bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i16, i17, true));
                                    }
                                    i16 = (int) ceil7;
                                    if (i18 != 0) {
                                    }
                                    i17 = (int) ceil8;
                                    bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i16, i17, true));
                                }
                                bitmapDrawable = bitmapDrawable2;
                            }
                        }
                        z6 = false;
                        if (z6) {
                        }
                        if (!scaled2DSizeInfo3.isScaledRequired()) {
                        }
                        bitmapDrawable = bitmapDrawable2;
                    } else {
                        String str3 = ", GradientDrawable ReflectionUtil Error";
                        if (drawable2 instanceof StateListDrawable ? true : drawable2 instanceof LevelListDrawable) {
                            try {
                                try {
                                    float standardScreen3 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                                    float standardScreen4 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                                    if (i3 != 1 && (i != 0 || i3 != 0)) {
                                        if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                            z = true;
                                            if (z) {
                                                scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen3, standardScreen4);
                                            } else {
                                                float floatValue2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen3 * floatValue2, standardScreen4 * floatValue2);
                                            }
                                            if (!scaled2DSizeInfo.isScaledRequired()) {
                                                float scaledWidth2 = scaled2DSizeInfo.getScaledWidth();
                                                float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                                                if (Build.VERSION.SDK_INT <= 23 && (drawable2 instanceof LevelListDrawable)) {
                                                    LevelListDrawable levelListDrawable = new LevelListDrawable();
                                                    Drawable.ConstantState constantState = drawable.getConstantState();
                                                    if (constantState != null) {
                                                        try {
                                                            Result.Companion companion = Result.Companion;
                                                            Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                                                            method.setAccessible(true);
                                                            Object invoke = method.invoke(constantState, new Object[0]);
                                                            Object[] objArr2 = invoke instanceof Object[] ? (Object[]) invoke : null;
                                                            if (objArr2 != null) {
                                                                int length = objArr2.length;
                                                                int i20 = 0;
                                                                int i21 = 0;
                                                                while (i21 < length) {
                                                                    Object obj2 = objArr2[i21];
                                                                    int i22 = i20 + 1;
                                                                    if (obj2 instanceof BitmapDrawable) {
                                                                        Bitmap bitmap2 = ((BitmapDrawable) obj2).getBitmap();
                                                                        float f2 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                                                                        float standardScreen5 = DisplayUtilsKt.toStandardScreen(scaledWidth2 * f2);
                                                                        if (i18 == 0) {
                                                                            ceil3 = Math.ceil(standardScreen5);
                                                                        } else if (i18 == i19) {
                                                                            ceil3 = Math.floor(standardScreen5);
                                                                        } else {
                                                                            if (i18 != 2) {
                                                                                i12 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                            } else {
                                                                                i12 = MathKt__MathJVMKt.roundToInt(standardScreen5);
                                                                            }
                                                                            float standardScreen6 = DisplayUtilsKt.toStandardScreen(f2 * scaledHeight2);
                                                                            if (i18 != 0) {
                                                                                ceil4 = Math.ceil(standardScreen6);
                                                                            } else if (i18 == 1) {
                                                                                ceil4 = Math.floor(standardScreen6);
                                                                            } else {
                                                                                if (i18 != 2) {
                                                                                    i13 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                                } else {
                                                                                    i13 = MathKt__MathJVMKt.roundToInt(standardScreen6);
                                                                                }
                                                                                levelListDrawable.addLevel(i20, i20, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                            }
                                                                            i13 = (int) ceil4;
                                                                            levelListDrawable.addLevel(i20, i20, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                        }
                                                                        i12 = (int) ceil3;
                                                                        float standardScreen62 = DisplayUtilsKt.toStandardScreen(f2 * scaledHeight2);
                                                                        if (i18 != 0) {
                                                                        }
                                                                        i13 = (int) ceil4;
                                                                        levelListDrawable.addLevel(i20, i20, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap2, i12, i13, true)));
                                                                    }
                                                                    i21++;
                                                                    i20 = i22;
                                                                    i19 = 1;
                                                                }
                                                                unit = Unit.INSTANCE;
                                                            } else {
                                                                unit = null;
                                                            }
                                                            Result.m855constructorimpl(unit);
                                                        } catch (Throwable th) {
                                                            Result.Companion companion2 = Result.Companion;
                                                            Result.m855constructorimpl(ResultKt.createFailure(th));
                                                        }
                                                        Unit unit2 = Unit.INSTANCE;
                                                        Unit unit3 = Unit.INSTANCE;
                                                    }
                                                    Unit unit4 = Unit.INSTANCE;
                                                    bitmapDrawable = levelListDrawable;
                                                } else {
                                                    Drawable.ConstantState constantState2 = drawable.getConstantState();
                                                    if (constantState2 != null) {
                                                        try {
                                                            Method method2 = constantState2.getClass().getMethod("getChildren", new Class[0]);
                                                            method2.setAccessible(true);
                                                            Object invoke2 = method2.invoke(constantState2, new Object[0]);
                                                            Object[] objArr3 = invoke2 instanceof Object[] ? (Object[]) invoke2 : null;
                                                            if (objArr3 != null) {
                                                                int i23 = 0;
                                                                for (int length2 = objArr3.length; i23 < length2; length2 = i8) {
                                                                    Object obj3 = objArr3[i23];
                                                                    if (obj3 instanceof BitmapDrawable) {
                                                                        Bitmap bitmap3 = ((BitmapDrawable) obj3).getBitmap();
                                                                        if (i18 != 0) {
                                                                            objArr = objArr3;
                                                                            if (i18 == 1) {
                                                                                i6 = length2;
                                                                                i7 = i23;
                                                                                ceil = Math.floor(scaledWidth2);
                                                                            } else {
                                                                                if (i18 != 2) {
                                                                                    roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                                } else {
                                                                                    roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                                                                }
                                                                                i7 = i23;
                                                                                int i24 = length2;
                                                                                i9 = roundToInt2;
                                                                                i6 = i24;
                                                                                if (i18 != 0) {
                                                                                    str = str3;
                                                                                    f = scaledWidth2;
                                                                                    ceil2 = Math.ceil(scaledHeight2);
                                                                                } else if (i18 == 1) {
                                                                                    str = str3;
                                                                                    f = scaledWidth2;
                                                                                    ceil2 = Math.floor(scaledHeight2);
                                                                                } else {
                                                                                    if (i18 != 2) {
                                                                                        roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                    } else {
                                                                                        roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                                                                    }
                                                                                    f = scaledWidth2;
                                                                                    i11 = 1;
                                                                                    int i25 = roundToInt;
                                                                                    str = str3;
                                                                                    i10 = i25;
                                                                                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap3, i9, i10, i11);
                                                                                    Object[] objArr4 = new Object[i11];
                                                                                    objArr4[0] = createScaledBitmap;
                                                                                    ReflectionUtil.invokeMethod(obj3, "setBitmap", objArr4);
                                                                                }
                                                                                i10 = (int) ceil2;
                                                                                i11 = 1;
                                                                                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap3, i9, i10, i11);
                                                                                Object[] objArr42 = new Object[i11];
                                                                                objArr42[0] = createScaledBitmap2;
                                                                                ReflectionUtil.invokeMethod(obj3, "setBitmap", objArr42);
                                                                            }
                                                                        } else {
                                                                            objArr = objArr3;
                                                                            i6 = length2;
                                                                            i7 = i23;
                                                                            ceil = Math.ceil(scaledWidth2);
                                                                        }
                                                                        i9 = (int) ceil;
                                                                        if (i18 != 0) {
                                                                        }
                                                                        i10 = (int) ceil2;
                                                                        i11 = 1;
                                                                        Bitmap createScaledBitmap22 = Bitmap.createScaledBitmap(bitmap3, i9, i10, i11);
                                                                        Object[] objArr422 = new Object[i11];
                                                                        objArr422[0] = createScaledBitmap22;
                                                                        ReflectionUtil.invokeMethod(obj3, "setBitmap", objArr422);
                                                                    } else {
                                                                        objArr = objArr3;
                                                                        f = scaledWidth2;
                                                                        i6 = length2;
                                                                        i7 = i23;
                                                                        str = str3;
                                                                        if (obj3 instanceof GradientDrawable) {
                                                                            GradientDrawable gradientDrawable = (GradientDrawable) obj3;
                                                                            try {
                                                                                if (Build.VERSION.SDK_INT >= 24) {
                                                                                    fieldValue = Float.valueOf(gradientDrawable.getCornerRadius());
                                                                                } else {
                                                                                    fieldValue = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
                                                                                }
                                                                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                    Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
                                                                                }
                                                                            } catch (Exception e) {
                                                                                e = e;
                                                                                i8 = i6;
                                                                            }
                                                                            if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                                                                                float floatValue3 = ((Number) fieldValue).floatValue();
                                                                                if (i3 != 1 && (i != 0 || i3 != 0)) {
                                                                                    if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                                                                        z2 = true;
                                                                                        if (z2) {
                                                                                            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, floatValue3);
                                                                                            i8 = i6;
                                                                                        } else {
                                                                                            float floatValue4 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr2[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                                                            i8 = i6;
                                                                                            scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue4, floatValue3 * floatValue4);
                                                                                        }
                                                                                        if (!scaled1DSizeInfo.isScaledRequired()) {
                                                                                            try {
                                                                                                floatValue3 = scaled1DSizeInfo.getScaledSize();
                                                                                            } catch (Exception e2) {
                                                                                                e = e2;
                                                                                                Exception exc = e;
                                                                                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                                                    StringBuilder sb = new StringBuilder();
                                                                                                    sb.append("Version: ");
                                                                                                    sb.append(Build.VERSION.SDK_INT);
                                                                                                    str2 = str;
                                                                                                    sb.append(str2);
                                                                                                    Log.d(TAG, sb.toString());
                                                                                                    exc.printStackTrace();
                                                                                                    i23 = i7 + 1;
                                                                                                    objArr3 = objArr;
                                                                                                    str3 = str2;
                                                                                                    scaledWidth2 = f;
                                                                                                }
                                                                                                str2 = str;
                                                                                                i23 = i7 + 1;
                                                                                                objArr3 = objArr;
                                                                                                str3 = str2;
                                                                                                scaledWidth2 = f;
                                                                                            }
                                                                                        }
                                                                                        gradientDrawable.setCornerRadius(floatValue3);
                                                                                        str2 = str;
                                                                                        i23 = i7 + 1;
                                                                                        objArr3 = objArr;
                                                                                        str3 = str2;
                                                                                        scaledWidth2 = f;
                                                                                    }
                                                                                }
                                                                                z2 = false;
                                                                                if (z2) {
                                                                                }
                                                                                if (!scaled1DSizeInfo.isScaledRequired()) {
                                                                                }
                                                                                gradientDrawable.setCornerRadius(floatValue3);
                                                                                str2 = str;
                                                                                i23 = i7 + 1;
                                                                                objArr3 = objArr;
                                                                                str3 = str2;
                                                                                scaledWidth2 = f;
                                                                            }
                                                                        }
                                                                    }
                                                                    i8 = i6;
                                                                    str2 = str;
                                                                    i23 = i7 + 1;
                                                                    objArr3 = objArr;
                                                                    str3 = str2;
                                                                    scaledWidth2 = f;
                                                                }
                                                                Unit unit5 = Unit.INSTANCE;
                                                            }
                                                        } catch (Exception e3) {
                                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                e3.printStackTrace();
                                                            }
                                                        }
                                                        Unit unit6 = Unit.INSTANCE;
                                                        Unit unit7 = Unit.INSTANCE;
                                                    }
                                                    Unit unit8 = Unit.INSTANCE;
                                                }
                                            }
                                            bitmapDrawable = drawable;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                    if (!scaled2DSizeInfo.isScaledRequired()) {
                                    }
                                    bitmapDrawable = drawable;
                                } catch (Error e4) {
                                    e = e4;
                                    drawable2 = drawable;
                                    Error error = e;
                                    bitmapDrawable = drawable2;
                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                        error.printStackTrace();
                                        bitmapDrawable = drawable2;
                                    }
                                    return bitmapDrawable;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                drawable2 = drawable;
                                Exception exc2 = e;
                                bitmapDrawable = drawable2;
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    exc2.printStackTrace();
                                    bitmapDrawable = drawable2;
                                }
                                return bitmapDrawable;
                            }
                        } else if (drawable2 instanceof GradientDrawable) {
                            GradientDrawable gradientDrawable2 = (GradientDrawable) drawable2;
                            GradientDrawable gradientDrawable3 = (GradientDrawable) drawable2;
                            try {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    fieldValue2 = Float.valueOf(gradientDrawable3.getCornerRadius());
                                } else {
                                    fieldValue2 = ReflectionUtil.getFieldValue(gradientDrawable3.getConstantState(), "mRadius");
                                }
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue2);
                                }
                                if ((fieldValue2 instanceof Float) && ((Number) fieldValue2).floatValue() > 0.0f) {
                                    float floatValue5 = ((Number) fieldValue2).floatValue();
                                    if (i3 != 1 && (i != 0 || i3 != 0)) {
                                        if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                            z5 = true;
                                            if (z5) {
                                                scaled1DSizeInfo3 = new Scaled1DSizeInfo(false, 1.0f, floatValue5);
                                            } else {
                                                float floatValue6 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr5 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr5[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                scaled1DSizeInfo3 = new Scaled1DSizeInfo(true, floatValue6, floatValue5 * floatValue6);
                                            }
                                            if (!scaled1DSizeInfo3.isScaledRequired()) {
                                                floatValue5 = scaled1DSizeInfo3.getScaledSize();
                                            }
                                            gradientDrawable3.setCornerRadius(floatValue5);
                                        }
                                    }
                                    z5 = false;
                                    if (z5) {
                                    }
                                    if (!scaled1DSizeInfo3.isScaledRequired()) {
                                    }
                                    gradientDrawable3.setCornerRadius(floatValue5);
                                }
                            } catch (Exception e6) {
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                    e6.printStackTrace();
                                }
                            }
                            Unit unit9 = Unit.INSTANCE;
                            bitmapDrawable = drawable2;
                        } else if (drawable2 instanceof NinePatchDrawable) {
                            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable2;
                            if (i3 != 1 && (i != 0 || i3 != 0)) {
                                if (i3 >= 0 && i3 < 5) {
                                    if (i <= -1 || i >= 4) {
                                        try {
                                            if (!mCustomerRatios.containsKey(Integer.valueOf(i))) {
                                            }
                                        } catch (Exception e7) {
                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                e7.printStackTrace();
                                            }
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                        scaled1DSizeInfo2 = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
                                    } else {
                                        float floatValue7 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr4 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr4[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                        scaled1DSizeInfo2 = new Scaled1DSizeInfo(true, floatValue7, 1.0f * floatValue7);
                                    }
                                    float scaledSize = scaled1DSizeInfo2.isScaledRequired() ? 1.0f : scaled1DSizeInfo2.getScaledSize();
                                    int i26 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                    float f3 = i26 * scaledSize;
                                    ninePatchDrawable.setTargetDensity((int) f3);
                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                        Log.d(TAG, "scaled: " + scaledSize + ", displayMetrics: " + i26 + ", result: " + f3);
                                    }
                                    Unit unit10 = Unit.INSTANCE;
                                    bitmapDrawable = ninePatchDrawable;
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                            if (scaled1DSizeInfo2.isScaledRequired()) {
                            }
                            int i262 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                            float f32 = i262 * scaledSize;
                            ninePatchDrawable.setTargetDensity((int) f32);
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                            }
                            Unit unit102 = Unit.INSTANCE;
                            bitmapDrawable = ninePatchDrawable;
                        } else {
                            float standardScreen7 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                            float standardScreen8 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                            if (i3 != 1 && (i != 0 || i3 != 0)) {
                                if ((i3 >= 0 && i3 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                    z3 = true;
                                    if (z3) {
                                        scaled2DSizeInfo2 = new Scaled2DSizeInfo(false, standardScreen7, standardScreen8);
                                    } else {
                                        float floatValue8 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr3 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr3[i3].floatValue() : SCALED_RATIO_T[i3].floatValue() : SCALED_RATIO_H[i3].floatValue() : SCALED_RATIO_CONTENT[i3].floatValue() : SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                        scaled2DSizeInfo2 = new Scaled2DSizeInfo(true, standardScreen7 * floatValue8, standardScreen8 * floatValue8);
                                    }
                                    if (scaled2DSizeInfo2.isScaledRequired()) {
                                        bitmapDrawable = drawable2;
                                    } else {
                                        float scaledWidth3 = scaled2DSizeInfo2.getScaledWidth();
                                        float scaledHeight3 = scaled2DSizeInfo2.getScaledHeight();
                                        int intrinsicWidth = drawable.getIntrinsicWidth();
                                        int intrinsicHeight = drawable.getIntrinsicHeight();
                                        if (drawable.getOpacity() != -1) {
                                            config = Bitmap.Config.ARGB_8888;
                                        } else {
                                            config = Bitmap.Config.RGB_565;
                                        }
                                        Bitmap bitmap4 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                                        Canvas canvas = new Canvas(bitmap4);
                                        drawable2.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                                        drawable2.draw(canvas);
                                        Intrinsics.checkNotNullExpressionValue(bitmap4, "bitmap");
                                        if (i18 == 0) {
                                            ceil5 = Math.ceil(scaledWidth3);
                                        } else if (i18 == 1) {
                                            ceil5 = Math.floor(scaledWidth3);
                                        } else {
                                            if (i18 != 2) {
                                                i14 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            } else {
                                                i14 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                            }
                                            if (i18 != 0) {
                                                ceil6 = Math.ceil(scaledHeight3);
                                            } else if (i18 == 1) {
                                                ceil6 = Math.floor(scaledHeight3);
                                            } else {
                                                if (i18 != 2) {
                                                    i15 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                } else {
                                                    i15 = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                }
                                                bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i14, i15, true));
                                            }
                                            i15 = (int) ceil6;
                                            bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i14, i15, true));
                                        }
                                        i14 = (int) ceil5;
                                        if (i18 != 0) {
                                        }
                                        i15 = (int) ceil6;
                                        bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap4, i14, i15, true));
                                    }
                                }
                            }
                            z3 = false;
                            if (z3) {
                            }
                            if (scaled2DSizeInfo2.isScaledRequired()) {
                            }
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Error e9) {
                e = e9;
            }
            return bitmapDrawable;
        }
        return null;
    }

    @JvmStatic
    @JvmOverloads
    public static final Drawable getScaledDrawableRes(int i, @DrawableRes int i2) {
        return getScaledDrawableRes$default(i, i2, 0, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final FontScaledSize getScaledDrawableSize(int i, Drawable drawable) {
        return getScaledDrawableSize$default(i, drawable, 0, 4, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final Drawable getScaledDrawableWithBaseFontSize(int i, Drawable drawable, int i2) {
        return getScaledDrawableWithBaseFontSize$default(i, drawable, i2, 0, 8, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v87, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f1 A[Catch: Exception -> 0x04c3, Error -> 0x04c8, TRY_LEAVE, TryCatch #2 {Error -> 0x04c8, blocks: (B:73:0x013e, B:111:0x01e9, B:114:0x01f1, B:164:0x02cb, B:166:0x02d1, B:168:0x02ea, B:171:0x02f0, B:173:0x02f4, B:175:0x02fa, B:181:0x030b, B:192:0x0339, B:198:0x0359, B:265:0x049d, B:194:0x0344, B:195:0x0349, B:197:0x0356, B:196:0x0350, B:183:0x0317, B:184:0x031c, B:186:0x032f, B:185:0x0325, B:199:0x036a, B:201:0x0373, B:202:0x0375, B:204:0x037b, B:206:0x038c, B:208:0x0396, B:209:0x03b0, B:211:0x03b4, B:213:0x03bf, B:235:0x03f2, B:254:0x0466, B:258:0x0473, B:257:0x046f, B:243:0x0408, B:245:0x0416, B:247:0x0426, B:253:0x045b, B:249:0x0430, B:250:0x043b, B:251:0x0446, B:252:0x0451, B:230:0x03e0, B:205:0x0384, B:262:0x0479, B:264:0x0483, B:266:0x04a7, B:273:0x04b9, B:274:0x04bd, B:270:0x04ac, B:272:0x04b6, B:110:0x01df, B:109:0x01d5, B:87:0x0169), top: B:500:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0297 A[Catch: all -> 0x02b8, TryCatch #1 {all -> 0x02b8, blocks: (B:121:0x0210, B:123:0x022a, B:126:0x0230, B:128:0x0235, B:130:0x023d, B:135:0x0261, B:140:0x0278, B:146:0x0286, B:152:0x029f, B:148:0x028c, B:149:0x0291, B:151:0x029c, B:150:0x0297, B:136:0x0266, B:137:0x026b, B:139:0x0276, B:138:0x0271, B:153:0x02ab, B:154:0x02b0, B:156:0x02b4), top: B:498:0x0210 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0350 A[Catch: Exception -> 0x04aa, Error -> 0x04c8, TryCatch #0 {Exception -> 0x04aa, blocks: (B:166:0x02d1, B:168:0x02ea, B:171:0x02f0, B:173:0x02f4, B:175:0x02fa, B:181:0x030b, B:192:0x0339, B:198:0x0359, B:265:0x049d, B:194:0x0344, B:195:0x0349, B:197:0x0356, B:196:0x0350, B:183:0x0317, B:184:0x031c, B:186:0x032f, B:185:0x0325, B:199:0x036a, B:201:0x0373, B:262:0x0479, B:264:0x0483, B:266:0x04a7), top: B:496:0x02d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03f2 A[Catch: Exception -> 0x0477, Error -> 0x04c8, TryCatch #2 {Error -> 0x04c8, blocks: (B:73:0x013e, B:111:0x01e9, B:114:0x01f1, B:164:0x02cb, B:166:0x02d1, B:168:0x02ea, B:171:0x02f0, B:173:0x02f4, B:175:0x02fa, B:181:0x030b, B:192:0x0339, B:198:0x0359, B:265:0x049d, B:194:0x0344, B:195:0x0349, B:197:0x0356, B:196:0x0350, B:183:0x0317, B:184:0x031c, B:186:0x032f, B:185:0x0325, B:199:0x036a, B:201:0x0373, B:202:0x0375, B:204:0x037b, B:206:0x038c, B:208:0x0396, B:209:0x03b0, B:211:0x03b4, B:213:0x03bf, B:235:0x03f2, B:254:0x0466, B:258:0x0473, B:257:0x046f, B:243:0x0408, B:245:0x0416, B:247:0x0426, B:253:0x045b, B:249:0x0430, B:250:0x043b, B:251:0x0446, B:252:0x0451, B:230:0x03e0, B:205:0x0384, B:262:0x0479, B:264:0x0483, B:266:0x04a7, B:273:0x04b9, B:274:0x04bd, B:270:0x04ac, B:272:0x04b6, B:110:0x01df, B:109:0x01d5, B:87:0x0169), top: B:500:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x046f A[Catch: Exception -> 0x0477, Error -> 0x04c8, TryCatch #2 {Error -> 0x04c8, blocks: (B:73:0x013e, B:111:0x01e9, B:114:0x01f1, B:164:0x02cb, B:166:0x02d1, B:168:0x02ea, B:171:0x02f0, B:173:0x02f4, B:175:0x02fa, B:181:0x030b, B:192:0x0339, B:198:0x0359, B:265:0x049d, B:194:0x0344, B:195:0x0349, B:197:0x0356, B:196:0x0350, B:183:0x0317, B:184:0x031c, B:186:0x032f, B:185:0x0325, B:199:0x036a, B:201:0x0373, B:202:0x0375, B:204:0x037b, B:206:0x038c, B:208:0x0396, B:209:0x03b0, B:211:0x03b4, B:213:0x03bf, B:235:0x03f2, B:254:0x0466, B:258:0x0473, B:257:0x046f, B:243:0x0408, B:245:0x0416, B:247:0x0426, B:253:0x045b, B:249:0x0430, B:250:0x043b, B:251:0x0446, B:252:0x0451, B:230:0x03e0, B:205:0x0384, B:262:0x0479, B:264:0x0483, B:266:0x04a7, B:273:0x04b9, B:274:0x04bd, B:270:0x04ac, B:272:0x04b6, B:110:0x01df, B:109:0x01d5, B:87:0x0169), top: B:500:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055 A[Catch: Exception -> 0x0855, Error -> 0x0865, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0557 A[Catch: Exception -> 0x05d5, Error -> 0x0865, TryCatch #4 {Exception -> 0x05d5, blocks: (B:284:0x04da, B:286:0x04e0, B:288:0x04f1, B:290:0x04fb, B:291:0x0515, B:293:0x0519, B:295:0x0524, B:317:0x0557, B:336:0x05c6, B:340:0x05d1, B:339:0x05cd, B:325:0x056b, B:327:0x0579, B:329:0x0589, B:335:0x05be, B:331:0x0593, B:332:0x059e, B:333:0x05a9, B:334:0x05b4, B:312:0x0545, B:287:0x04e9), top: B:504:0x04da }] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05cd A[Catch: Exception -> 0x05d5, Error -> 0x0865, TryCatch #4 {Exception -> 0x05d5, blocks: (B:284:0x04da, B:286:0x04e0, B:288:0x04f1, B:290:0x04fb, B:291:0x0515, B:293:0x0519, B:295:0x0524, B:317:0x0557, B:336:0x05c6, B:340:0x05d1, B:339:0x05cd, B:325:0x056b, B:327:0x0579, B:329:0x0589, B:335:0x05be, B:331:0x0593, B:332:0x059e, B:333:0x05a9, B:334:0x05b4, B:312:0x0545, B:287:0x04e9), top: B:504:0x04da }] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0635 A[Catch: Exception -> 0x0641, Error -> 0x0865, TryCatch #7 {Error -> 0x0865, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:284:0x04da, B:286:0x04e0, B:288:0x04f1, B:290:0x04fb, B:291:0x0515, B:293:0x0519, B:295:0x0524, B:317:0x0557, B:336:0x05c6, B:340:0x05d1, B:339:0x05cd, B:325:0x056b, B:327:0x0579, B:329:0x0589, B:335:0x05be, B:331:0x0593, B:332:0x059e, B:333:0x05a9, B:334:0x05b4, B:312:0x0545, B:347:0x05fb, B:287:0x04e9, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:374:0x0635, B:395:0x06ad, B:399:0x06ba, B:401:0x06d9, B:406:0x070c, B:398:0x06b6, B:384:0x0650, B:386:0x065e, B:388:0x066e, B:394:0x06a3, B:390:0x0678, B:391:0x0683, B:392:0x068e, B:393:0x0699, B:369:0x0623, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x06b6 A[Catch: Exception -> 0x0641, Error -> 0x0865, TryCatch #7 {Error -> 0x0865, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:284:0x04da, B:286:0x04e0, B:288:0x04f1, B:290:0x04fb, B:291:0x0515, B:293:0x0519, B:295:0x0524, B:317:0x0557, B:336:0x05c6, B:340:0x05d1, B:339:0x05cd, B:325:0x056b, B:327:0x0579, B:329:0x0589, B:335:0x05be, B:331:0x0593, B:332:0x059e, B:333:0x05a9, B:334:0x05b4, B:312:0x0545, B:347:0x05fb, B:287:0x04e9, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:374:0x0635, B:395:0x06ad, B:399:0x06ba, B:401:0x06d9, B:406:0x070c, B:398:0x06b6, B:384:0x0650, B:386:0x065e, B:388:0x066e, B:394:0x06a3, B:390:0x0678, B:391:0x0683, B:392:0x068e, B:393:0x0699, B:369:0x0623, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x06d9 A[Catch: Exception -> 0x0641, Error -> 0x0865, TRY_LEAVE, TryCatch #7 {Error -> 0x0865, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:284:0x04da, B:286:0x04e0, B:288:0x04f1, B:290:0x04fb, B:291:0x0515, B:293:0x0519, B:295:0x0524, B:317:0x0557, B:336:0x05c6, B:340:0x05d1, B:339:0x05cd, B:325:0x056b, B:327:0x0579, B:329:0x0589, B:335:0x05be, B:331:0x0593, B:332:0x059e, B:333:0x05a9, B:334:0x05b4, B:312:0x0545, B:347:0x05fb, B:287:0x04e9, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:374:0x0635, B:395:0x06ad, B:399:0x06ba, B:401:0x06d9, B:406:0x070c, B:398:0x06b6, B:384:0x0650, B:386:0x065e, B:388:0x066e, B:394:0x06a3, B:390:0x0678, B:391:0x0683, B:392:0x068e, B:393:0x0699, B:369:0x0623, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0756 A[Catch: Exception -> 0x0855, Error -> 0x0865, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x07cd A[Catch: Exception -> 0x0855, Error -> 0x0865, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c7 A[Catch: Exception -> 0x0855, Error -> 0x0865, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0838 A[Catch: Exception -> 0x0855, Error -> 0x0865, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0106 A[Catch: Exception -> 0x0855, Error -> 0x0865, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x017b A[Catch: Exception -> 0x0855, Error -> 0x0865, TRY_ENTER, TryCatch #5 {Exception -> 0x0855, blocks: (B:4:0x000a, B:6:0x0015, B:8:0x001a, B:27:0x0055, B:43:0x00bf, B:65:0x0121, B:46:0x00c7, B:50:0x00d9, B:58:0x00f6, B:63:0x010d, B:59:0x00fb, B:60:0x0100, B:62:0x010b, B:61:0x0106, B:51:0x00de, B:52:0x00e3, B:54:0x00ee, B:53:0x00e9, B:32:0x0063, B:34:0x0071, B:36:0x0081, B:42:0x00b6, B:38:0x008b, B:39:0x0096, B:40:0x00a1, B:41:0x00ac, B:22:0x0043, B:66:0x0126, B:92:0x017b, B:117:0x0201, B:119:0x0205, B:161:0x02c3, B:162:0x02c7, B:160:0x02ba, B:99:0x018c, B:101:0x019a, B:103:0x01aa, B:105:0x01b4, B:106:0x01bf, B:107:0x01ca, B:281:0x04d0, B:283:0x04d4, B:347:0x05fb, B:344:0x05d7, B:346:0x05e1, B:348:0x05ff, B:350:0x0603, B:406:0x070c, B:403:0x06ff, B:405:0x0709, B:411:0x0717, B:433:0x0756, B:452:0x07c5, B:455:0x07cd, B:457:0x07e4, B:459:0x07e9, B:465:0x0808, B:475:0x0827, B:481:0x0840, B:477:0x082d, B:478:0x0832, B:480:0x083d, B:479:0x0838, B:466:0x080d, B:467:0x0812, B:469:0x081d, B:468:0x0818, B:458:0x07e7, B:441:0x0768, B:443:0x0776, B:445:0x0786, B:451:0x07bb, B:447:0x0790, B:448:0x079b, B:449:0x07a6, B:450:0x07b1, B:428:0x0744, B:69:0x012c), top: B:506:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0182  */
    /* JADX WARN: Type inference failed for: r3v86 */
    /* JADX WARN: Type inference failed for: r3v89 */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Drawable getScaledDrawableWithBaseFontSize(int i, Drawable drawable, int i2, int i3) {
        Drawable drawable2;
        BitmapDrawable bitmapDrawable;
        int i4;
        boolean z;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        Bitmap.Config config;
        double ceil;
        int i5;
        double ceil2;
        int i6;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr2;
        Object fieldValue;
        boolean z3;
        Scaled1DSizeInfo scaled1DSizeInfo2;
        Float[] fArr3;
        boolean z4;
        Scaled2DSizeInfo scaled2DSizeInfo2;
        Float[] fArr4;
        Object[] objArr;
        int i7;
        int i8;
        Object fieldValue2;
        boolean z5;
        float f;
        Scaled1DSizeInfo scaled1DSizeInfo3;
        Float[] fArr5;
        int i9;
        double ceil3;
        int i10;
        double ceil4;
        int i11;
        int i12;
        int roundToInt;
        int roundToInt2;
        Unit unit;
        double ceil5;
        int i13;
        double ceil6;
        int i14;
        BitmapDrawable bitmapDrawable2;
        boolean z6;
        Scaled2DSizeInfo scaled2DSizeInfo3;
        Float[] fArr6;
        double ceil7;
        int i15;
        double ceil8;
        int i16;
        Drawable drawable3 = drawable;
        int i17 = i3;
        int i18 = mTargetLevel;
        if (drawable3 != null) {
            try {
                try {
                    i4 = 1;
                } catch (Exception e) {
                    e = e;
                }
            } catch (Error e2) {
                e = e2;
            }
            if (drawable3 instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable3 = (BitmapDrawable) drawable3;
                if (bitmapDrawable3 != null) {
                    float standardScreen = DisplayUtilsKt.toStandardScreen(bitmapDrawable3.getIntrinsicWidth());
                    float standardScreen2 = DisplayUtilsKt.toStandardScreen(bitmapDrawable3.getIntrinsicHeight());
                    if (i18 != 1 && (i != 0 || i18 != 0)) {
                        if ((i18 >= 0 && i18 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                            z6 = true;
                            if (z6) {
                                scaled2DSizeInfo3 = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                            } else {
                                float floatValue = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr6 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr6[i18].floatValue() : SCALED_RATIO_T[i18].floatValue() : SCALED_RATIO_H[i18].floatValue() : SCALED_RATIO_CONTENT[i18].floatValue() : SCALED_RATIO_FRAMEWORK[i18].floatValue();
                                scaled2DSizeInfo3 = new Scaled2DSizeInfo(true, standardScreen * floatValue, standardScreen2 * floatValue);
                            }
                            if (scaled2DSizeInfo3.isScaledRequired()) {
                                bitmapDrawable2 = bitmapDrawable3;
                            } else {
                                float scaledWidth = scaled2DSizeInfo3.getScaledWidth();
                                float scaledHeight = scaled2DSizeInfo3.getScaledHeight();
                                Bitmap bitmap = bitmapDrawable3.getBitmap();
                                if (i17 == 0) {
                                    ceil7 = Math.ceil(scaledWidth);
                                } else if (i17 == 1) {
                                    ceil7 = Math.floor(scaledWidth);
                                } else {
                                    if (i17 != 2) {
                                        i15 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i15 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    if (i17 != 0) {
                                        ceil8 = Math.ceil(scaledHeight);
                                    } else if (i17 == 1) {
                                        ceil8 = Math.floor(scaledHeight);
                                    } else {
                                        if (i17 != 2) {
                                            i16 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        } else {
                                            i16 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        }
                                        bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i15, i16, true));
                                    }
                                    i16 = (int) ceil8;
                                    bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i15, i16, true));
                                }
                                i15 = (int) ceil7;
                                if (i17 != 0) {
                                }
                                i16 = (int) ceil8;
                                bitmapDrawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i15, i16, true));
                            }
                        }
                    }
                    z6 = false;
                    if (z6) {
                    }
                    if (scaled2DSizeInfo3.isScaledRequired()) {
                    }
                } else {
                    bitmapDrawable2 = null;
                }
                bitmapDrawable = bitmapDrawable2;
            } else {
                if (!(drawable3 instanceof StateListDrawable ? true : drawable3 instanceof LevelListDrawable)) {
                    if (drawable3 instanceof GradientDrawable) {
                        GradientDrawable gradientDrawable = (GradientDrawable) drawable3;
                        GradientDrawable gradientDrawable2 = (GradientDrawable) drawable3;
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                fieldValue = Float.valueOf(gradientDrawable2.getCornerRadius());
                            } else {
                                fieldValue = ReflectionUtil.getFieldValue(gradientDrawable2.getConstantState(), "mRadius");
                            }
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
                            }
                            if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                                float floatValue2 = ((Number) fieldValue).floatValue();
                                if (i18 != 1 && (i != 0 || i18 != 0)) {
                                    if ((i18 >= 0 && i18 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                        z3 = true;
                                        if (z3) {
                                            scaled1DSizeInfo2 = new Scaled1DSizeInfo(false, 1.0f, floatValue2);
                                        } else {
                                            float floatValue3 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr3 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr3[i18].floatValue() : SCALED_RATIO_T[i18].floatValue() : SCALED_RATIO_H[i18].floatValue() : SCALED_RATIO_CONTENT[i18].floatValue() : SCALED_RATIO_FRAMEWORK[i18].floatValue();
                                            scaled1DSizeInfo2 = new Scaled1DSizeInfo(true, floatValue3, floatValue2 * floatValue3);
                                        }
                                        if (!scaled1DSizeInfo2.isScaledRequired()) {
                                            floatValue2 = scaled1DSizeInfo2.getScaledSize();
                                        }
                                        gradientDrawable2.setCornerRadius(floatValue2);
                                    }
                                }
                                z3 = false;
                                if (z3) {
                                }
                                if (!scaled1DSizeInfo2.isScaledRequired()) {
                                }
                                gradientDrawable2.setCornerRadius(floatValue2);
                            }
                        } catch (Exception e3) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                e3.printStackTrace();
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        drawable2 = drawable3;
                    } else if (drawable3 instanceof NinePatchDrawable) {
                        NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable3;
                        if (ninePatchDrawable != null) {
                            if (i18 != 1 && (i != 0 || i18 != 0)) {
                                if (i18 >= 0 && i18 < 5) {
                                    if (i <= -1 || i >= 4) {
                                        try {
                                            if (!mCustomerRatios.containsKey(Integer.valueOf(i))) {
                                            }
                                        } catch (Exception e4) {
                                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                e4.printStackTrace();
                                            }
                                        }
                                    }
                                    z2 = true;
                                    if (z2) {
                                        scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
                                    } else {
                                        float floatValue4 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr2[i18].floatValue() : SCALED_RATIO_T[i18].floatValue() : SCALED_RATIO_H[i18].floatValue() : SCALED_RATIO_CONTENT[i18].floatValue() : SCALED_RATIO_FRAMEWORK[i18].floatValue();
                                        scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue4, 1.0f * floatValue4);
                                    }
                                    float scaledSize = scaled1DSizeInfo.isScaledRequired() ? 1.0f : scaled1DSizeInfo.getScaledSize();
                                    int i19 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                                    float f2 = i19 * scaledSize;
                                    ninePatchDrawable.setTargetDensity((int) f2);
                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                        Log.d(TAG, "scaled: " + scaledSize + ", displayMetrics: " + i19 + ", result: " + f2);
                                    }
                                    Unit unit3 = Unit.INSTANCE;
                                }
                            }
                            z2 = false;
                            if (z2) {
                            }
                            if (scaled1DSizeInfo.isScaledRequired()) {
                            }
                            int i192 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                            float f22 = i192 * scaledSize;
                            ninePatchDrawable.setTargetDensity((int) f22);
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                            }
                            Unit unit32 = Unit.INSTANCE;
                        } else {
                            ninePatchDrawable = null;
                        }
                        bitmapDrawable = ninePatchDrawable;
                    } else if (drawable3 != null) {
                        float standardScreen3 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                        float standardScreen4 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                        if (i18 != 1 && (i != 0 || i18 != 0)) {
                            if ((i18 >= 0 && i18 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                z = true;
                                if (z) {
                                    scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen3, standardScreen4);
                                } else {
                                    float floatValue5 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr[i18].floatValue() : SCALED_RATIO_T[i18].floatValue() : SCALED_RATIO_H[i18].floatValue() : SCALED_RATIO_CONTENT[i18].floatValue() : SCALED_RATIO_FRAMEWORK[i18].floatValue();
                                    scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen3 * floatValue5, standardScreen4 * floatValue5);
                                }
                                if (scaled2DSizeInfo.isScaledRequired()) {
                                    drawable2 = drawable3;
                                } else {
                                    float scaledWidth2 = scaled2DSizeInfo.getScaledWidth();
                                    float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                                    int intrinsicWidth = drawable.getIntrinsicWidth();
                                    int intrinsicHeight = drawable.getIntrinsicHeight();
                                    if (drawable.getOpacity() != -1) {
                                        config = Bitmap.Config.ARGB_8888;
                                    } else {
                                        config = Bitmap.Config.RGB_565;
                                    }
                                    Bitmap bitmap2 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                                    Canvas canvas = new Canvas(bitmap2);
                                    drawable3.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                                    drawable3.draw(canvas);
                                    Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
                                    if (i3 == 0) {
                                        ceil = Math.ceil(scaledWidth2);
                                    } else if (i3 == 1) {
                                        ceil = Math.floor(scaledWidth2);
                                    } else {
                                        if (i3 != 2) {
                                            i5 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                        } else {
                                            i5 = MathKt__MathJVMKt.roundToInt(scaledWidth2);
                                        }
                                        if (i3 != 0) {
                                            ceil2 = Math.ceil(scaledHeight2);
                                        } else if (i3 == 1) {
                                            ceil2 = Math.floor(scaledHeight2);
                                        } else {
                                            if (i3 != 2) {
                                                i6 = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                            } else {
                                                i6 = MathKt__MathJVMKt.roundToInt(scaledHeight2);
                                            }
                                            drawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap2, i5, i6, true));
                                        }
                                        i6 = (int) ceil2;
                                        drawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap2, i5, i6, true));
                                    }
                                    i5 = (int) ceil;
                                    if (i3 != 0) {
                                    }
                                    i6 = (int) ceil2;
                                    drawable2 = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap2, i5, i6, true));
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                        if (scaled2DSizeInfo.isScaledRequired()) {
                        }
                    } else {
                        drawable2 = null;
                    }
                    bitmapDrawable = drawable2;
                } else if (drawable3 != null) {
                    try {
                        try {
                            float standardScreen5 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                            float standardScreen6 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                            if (i18 != 1 && (i != 0 || i18 != 0)) {
                                if ((i18 >= 0 && i18 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                    z4 = true;
                                    if (z4) {
                                        scaled2DSizeInfo2 = new Scaled2DSizeInfo(false, standardScreen5, standardScreen6);
                                    } else {
                                        float floatValue6 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr4 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr4[i18].floatValue() : SCALED_RATIO_T[i18].floatValue() : SCALED_RATIO_H[i18].floatValue() : SCALED_RATIO_CONTENT[i18].floatValue() : SCALED_RATIO_FRAMEWORK[i18].floatValue();
                                        scaled2DSizeInfo2 = new Scaled2DSizeInfo(true, standardScreen5 * floatValue6, standardScreen6 * floatValue6);
                                    }
                                    if (!scaled2DSizeInfo2.isScaledRequired()) {
                                        float scaledWidth3 = scaled2DSizeInfo2.getScaledWidth();
                                        float scaledHeight3 = scaled2DSizeInfo2.getScaledHeight();
                                        if (Build.VERSION.SDK_INT <= 23 && (drawable3 instanceof LevelListDrawable)) {
                                            LevelListDrawable levelListDrawable = new LevelListDrawable();
                                            Drawable.ConstantState constantState = drawable.getConstantState();
                                            if (constantState != null) {
                                                try {
                                                    Result.Companion companion = Result.Companion;
                                                    Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                                                    method.setAccessible(true);
                                                    Object invoke = method.invoke(constantState, new Object[0]);
                                                    Object[] objArr2 = invoke instanceof Object[] ? (Object[]) invoke : null;
                                                    if (objArr2 != null) {
                                                        int length = objArr2.length;
                                                        int i20 = 0;
                                                        int i21 = 0;
                                                        while (i21 < length) {
                                                            Object obj = objArr2[i21];
                                                            int i22 = i20 + 1;
                                                            if (obj instanceof BitmapDrawable) {
                                                                Bitmap bitmap3 = ((BitmapDrawable) obj).getBitmap();
                                                                float f3 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                                                                float standardScreen7 = DisplayUtilsKt.toStandardScreen(scaledWidth3 * f3);
                                                                if (i17 == 0) {
                                                                    ceil5 = Math.ceil(standardScreen7);
                                                                } else if (i17 == i4) {
                                                                    ceil5 = Math.floor(standardScreen7);
                                                                } else {
                                                                    if (i17 != 2) {
                                                                        i13 = MathKt__MathJVMKt.roundToInt(standardScreen7);
                                                                    } else {
                                                                        i13 = MathKt__MathJVMKt.roundToInt(standardScreen7);
                                                                    }
                                                                    float standardScreen8 = DisplayUtilsKt.toStandardScreen(f3 * scaledHeight3);
                                                                    if (i17 != 0) {
                                                                        ceil6 = Math.ceil(standardScreen8);
                                                                    } else if (i17 == 1) {
                                                                        ceil6 = Math.floor(standardScreen8);
                                                                    } else {
                                                                        if (i17 != 2) {
                                                                            i14 = MathKt__MathJVMKt.roundToInt(standardScreen8);
                                                                        } else {
                                                                            i14 = MathKt__MathJVMKt.roundToInt(standardScreen8);
                                                                        }
                                                                        levelListDrawable.addLevel(i20, i20, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap3, i13, i14, true)));
                                                                    }
                                                                    i14 = (int) ceil6;
                                                                    levelListDrawable.addLevel(i20, i20, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap3, i13, i14, true)));
                                                                }
                                                                i13 = (int) ceil5;
                                                                float standardScreen82 = DisplayUtilsKt.toStandardScreen(f3 * scaledHeight3);
                                                                if (i17 != 0) {
                                                                }
                                                                i14 = (int) ceil6;
                                                                levelListDrawable.addLevel(i20, i20, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap3, i13, i14, true)));
                                                            }
                                                            i21++;
                                                            i20 = i22;
                                                            i4 = 1;
                                                        }
                                                        unit = Unit.INSTANCE;
                                                    } else {
                                                        unit = null;
                                                    }
                                                    Result.m855constructorimpl(unit);
                                                } catch (Throwable th) {
                                                    Result.Companion companion2 = Result.Companion;
                                                    Result.m855constructorimpl(ResultKt.createFailure(th));
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                                Unit unit5 = Unit.INSTANCE;
                                            }
                                            Unit unit6 = Unit.INSTANCE;
                                            bitmapDrawable = levelListDrawable;
                                        } else {
                                            Drawable.ConstantState constantState2 = drawable.getConstantState();
                                            if (constantState2 != null) {
                                                try {
                                                    Method method2 = constantState2.getClass().getMethod("getChildren", new Class[0]);
                                                    method2.setAccessible(true);
                                                    Object invoke2 = method2.invoke(constantState2, new Object[0]);
                                                    Object[] objArr3 = invoke2 instanceof Object[] ? (Object[]) invoke2 : null;
                                                    if (objArr3 != null) {
                                                        int length2 = objArr3.length;
                                                        int i23 = 0;
                                                        while (i23 < length2) {
                                                            Object obj2 = objArr3[i23];
                                                            if (obj2 instanceof BitmapDrawable) {
                                                                Bitmap bitmap4 = ((BitmapDrawable) obj2).getBitmap();
                                                                if (i17 != 0) {
                                                                    objArr = objArr3;
                                                                    if (i17 == 1) {
                                                                        i9 = length2;
                                                                        i7 = i23;
                                                                        ceil3 = Math.floor(scaledWidth3);
                                                                    } else {
                                                                        if (i17 != 2) {
                                                                            roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                                                        } else {
                                                                            roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth3);
                                                                        }
                                                                        i7 = i23;
                                                                        int i24 = length2;
                                                                        i10 = roundToInt2;
                                                                        i9 = i24;
                                                                        if (i17 != 0) {
                                                                            i8 = i9;
                                                                            ceil4 = Math.ceil(scaledHeight3);
                                                                        } else if (i17 == 1) {
                                                                            i8 = i9;
                                                                            ceil4 = Math.floor(scaledHeight3);
                                                                        } else {
                                                                            if (i17 != 2) {
                                                                                roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                                            } else {
                                                                                roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight3);
                                                                            }
                                                                            i12 = 1;
                                                                            int i25 = roundToInt;
                                                                            i8 = i9;
                                                                            i11 = i25;
                                                                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap4, i10, i11, i12);
                                                                            Object[] objArr4 = new Object[i12];
                                                                            objArr4[0] = createScaledBitmap;
                                                                            ReflectionUtil.invokeMethod(obj2, "setBitmap", objArr4);
                                                                        }
                                                                        i11 = (int) ceil4;
                                                                        i12 = 1;
                                                                        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap4, i10, i11, i12);
                                                                        Object[] objArr42 = new Object[i12];
                                                                        objArr42[0] = createScaledBitmap2;
                                                                        ReflectionUtil.invokeMethod(obj2, "setBitmap", objArr42);
                                                                    }
                                                                } else {
                                                                    objArr = objArr3;
                                                                    i9 = length2;
                                                                    i7 = i23;
                                                                    ceil3 = Math.ceil(scaledWidth3);
                                                                }
                                                                i10 = (int) ceil3;
                                                                if (i17 != 0) {
                                                                }
                                                                i11 = (int) ceil4;
                                                                i12 = 1;
                                                                Bitmap createScaledBitmap22 = Bitmap.createScaledBitmap(bitmap4, i10, i11, i12);
                                                                Object[] objArr422 = new Object[i12];
                                                                objArr422[0] = createScaledBitmap22;
                                                                ReflectionUtil.invokeMethod(obj2, "setBitmap", objArr422);
                                                            } else {
                                                                objArr = objArr3;
                                                                i7 = i23;
                                                                i8 = length2;
                                                                if (obj2 instanceof GradientDrawable) {
                                                                    GradientDrawable gradientDrawable3 = (GradientDrawable) obj2;
                                                                    try {
                                                                        if (Build.VERSION.SDK_INT >= 24) {
                                                                            fieldValue2 = Float.valueOf(gradientDrawable3.getCornerRadius());
                                                                        } else {
                                                                            fieldValue2 = ReflectionUtil.getFieldValue(gradientDrawable3.getConstantState(), "mRadius");
                                                                        }
                                                                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                            Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue2);
                                                                        }
                                                                        if ((fieldValue2 instanceof Float) && ((Number) fieldValue2).floatValue() > 0.0f) {
                                                                            float floatValue7 = ((Number) fieldValue2).floatValue();
                                                                            if (i18 != 1 && (i != 0 || i18 != 0)) {
                                                                                if ((i18 >= 0 && i18 < 5) && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                                                                                    z5 = true;
                                                                                    if (z5) {
                                                                                        scaled1DSizeInfo3 = new Scaled1DSizeInfo(false, 1.0f, floatValue7);
                                                                                        f = floatValue7;
                                                                                    } else {
                                                                                        float floatValue8 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr5 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) ? 1.0f : fArr5[i18].floatValue() : SCALED_RATIO_T[i18].floatValue() : SCALED_RATIO_H[i18].floatValue() : SCALED_RATIO_CONTENT[i18].floatValue() : SCALED_RATIO_FRAMEWORK[i18].floatValue();
                                                                                        f = floatValue7;
                                                                                        scaled1DSizeInfo3 = new Scaled1DSizeInfo(true, floatValue8, floatValue7 * floatValue8);
                                                                                    }
                                                                                    gradientDrawable3.setCornerRadius(scaled1DSizeInfo3.isScaledRequired() ? f : scaled1DSizeInfo3.getScaledSize());
                                                                                }
                                                                            }
                                                                            z5 = false;
                                                                            if (z5) {
                                                                            }
                                                                            gradientDrawable3.setCornerRadius(scaled1DSizeInfo3.isScaledRequired() ? f : scaled1DSizeInfo3.getScaledSize());
                                                                        }
                                                                    } catch (Exception e5) {
                                                                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                            Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                                                            e5.printStackTrace();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            i17 = i3;
                                                            length2 = i8;
                                                            i23 = i7 + 1;
                                                            objArr3 = objArr;
                                                        }
                                                        Unit unit7 = Unit.INSTANCE;
                                                    }
                                                } catch (Exception e6) {
                                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                        e6.printStackTrace();
                                                    }
                                                }
                                                Unit unit8 = Unit.INSTANCE;
                                                Unit unit9 = Unit.INSTANCE;
                                            }
                                            Unit unit10 = Unit.INSTANCE;
                                        }
                                    }
                                    bitmapDrawable = drawable;
                                }
                            }
                            z4 = false;
                            if (z4) {
                            }
                            if (!scaled2DSizeInfo2.isScaledRequired()) {
                            }
                            bitmapDrawable = drawable;
                        } catch (Error e7) {
                            e = e7;
                            drawable3 = drawable;
                            Error error = e;
                            drawable2 = drawable3;
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                error.printStackTrace();
                                drawable2 = drawable3;
                            }
                            bitmapDrawable = drawable2;
                            return bitmapDrawable;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        drawable3 = drawable;
                        Exception exc = e;
                        drawable2 = drawable3;
                        if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                            exc.printStackTrace();
                            drawable2 = drawable3;
                        }
                        bitmapDrawable = drawable2;
                        return bitmapDrawable;
                    }
                } else {
                    bitmapDrawable = null;
                }
            }
            return bitmapDrawable;
        }
        return null;
    }

    @JvmStatic
    @JvmOverloads
    public static final StateListDrawable setScaledStateListDrawable(int i, List<? extends Drawable> drawableList, List<int[]> statesList) {
        Intrinsics.checkNotNullParameter(drawableList, "drawableList");
        Intrinsics.checkNotNullParameter(statesList, "statesList");
        return setScaledStateListDrawable$default(i, drawableList, statesList, 0, 8, null);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/config/FontSizeHelper$Scaled1DSizeInfo;", "", "isScaledRequired", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "scaledSize", "(ZFF)V", "()Z", "getRatio", "()F", "getScaledSize", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "hashCode", "", "toString", "", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Scaled1DSizeInfo {
        public final boolean isScaledRequired;
        public final float ratio;
        public final float scaledSize;

        public static /* synthetic */ Scaled1DSizeInfo copy$default(Scaled1DSizeInfo scaled1DSizeInfo, boolean z, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = scaled1DSizeInfo.isScaledRequired;
            }
            if ((i & 2) != 0) {
                f = scaled1DSizeInfo.ratio;
            }
            if ((i & 4) != 0) {
                f2 = scaled1DSizeInfo.scaledSize;
            }
            return scaled1DSizeInfo.copy(z, f, f2);
        }

        public final boolean component1() {
            return this.isScaledRequired;
        }

        public final float component2() {
            return this.ratio;
        }

        public final float component3() {
            return this.scaledSize;
        }

        public final Scaled1DSizeInfo copy(boolean z, float f, float f2) {
            return new Scaled1DSizeInfo(z, f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Scaled1DSizeInfo) {
                Scaled1DSizeInfo scaled1DSizeInfo = (Scaled1DSizeInfo) obj;
                return this.isScaledRequired == scaled1DSizeInfo.isScaledRequired && Intrinsics.areEqual((Object) Float.valueOf(this.ratio), (Object) Float.valueOf(scaled1DSizeInfo.ratio)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaledSize), (Object) Float.valueOf(scaled1DSizeInfo.scaledSize));
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z = this.isScaledRequired;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (((r0 * 31) + Float.floatToIntBits(this.ratio)) * 31) + Float.floatToIntBits(this.scaledSize);
        }

        public String toString() {
            return "Scaled1DSizeInfo(isScaledRequired=" + this.isScaledRequired + ", ratio=" + this.ratio + ", scaledSize=" + this.scaledSize + ')';
        }

        public Scaled1DSizeInfo(boolean z, float f, float f2) {
            this.isScaledRequired = z;
            this.ratio = f;
            this.scaledSize = f2;
        }

        public final float getRatio() {
            return this.ratio;
        }

        public final float getScaledSize() {
            return this.scaledSize;
        }

        public final boolean isScaledRequired() {
            return this.isScaledRequired;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/config/FontSizeHelper$Scaled2DSizeInfo;", "", "isScaledRequired", "", "scaledWidth", "", "scaledHeight", "(ZFF)V", "()Z", "getScaledHeight", "()F", "getScaledWidth", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "hashCode", "", "toString", "", "lib-fontsize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Scaled2DSizeInfo {
        public final boolean isScaledRequired;
        public final float scaledHeight;
        public final float scaledWidth;

        public static /* synthetic */ Scaled2DSizeInfo copy$default(Scaled2DSizeInfo scaled2DSizeInfo, boolean z, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = scaled2DSizeInfo.isScaledRequired;
            }
            if ((i & 2) != 0) {
                f = scaled2DSizeInfo.scaledWidth;
            }
            if ((i & 4) != 0) {
                f2 = scaled2DSizeInfo.scaledHeight;
            }
            return scaled2DSizeInfo.copy(z, f, f2);
        }

        public final boolean component1() {
            return this.isScaledRequired;
        }

        public final float component2() {
            return this.scaledWidth;
        }

        public final float component3() {
            return this.scaledHeight;
        }

        public final Scaled2DSizeInfo copy(boolean z, float f, float f2) {
            return new Scaled2DSizeInfo(z, f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Scaled2DSizeInfo) {
                Scaled2DSizeInfo scaled2DSizeInfo = (Scaled2DSizeInfo) obj;
                return this.isScaledRequired == scaled2DSizeInfo.isScaledRequired && Intrinsics.areEqual((Object) Float.valueOf(this.scaledWidth), (Object) Float.valueOf(scaled2DSizeInfo.scaledWidth)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaledHeight), (Object) Float.valueOf(scaled2DSizeInfo.scaledHeight));
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z = this.isScaledRequired;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (((r0 * 31) + Float.floatToIntBits(this.scaledWidth)) * 31) + Float.floatToIntBits(this.scaledHeight);
        }

        public String toString() {
            return "Scaled2DSizeInfo(isScaledRequired=" + this.isScaledRequired + ", scaledWidth=" + this.scaledWidth + ", scaledHeight=" + this.scaledHeight + ')';
        }

        public Scaled2DSizeInfo(boolean z, float f, float f2) {
            this.isScaledRequired = z;
            this.scaledWidth = f;
            this.scaledHeight = f2;
        }

        public final float getScaledHeight() {
            return this.scaledHeight;
        }

        public final float getScaledWidth() {
            return this.scaledWidth;
        }

        public final boolean isScaledRequired() {
            return this.isScaledRequired;
        }
    }

    static {
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(1.16f);
        Float valueOf3 = Float.valueOf(1.41f);
        SCALED_RATIO_FRAMEWORK = new Float[]{valueOf, valueOf, valueOf2, valueOf3, valueOf3};
        Float valueOf4 = Float.valueOf(0.88f);
        SCALED_RATIO_CONTENT = new Float[]{valueOf4, valueOf, valueOf2, valueOf3, Float.valueOf(1.66f)};
        Float valueOf5 = Float.valueOf(1.21f);
        SCALED_RATIO_H = new Float[]{Float.valueOf(0.86f), valueOf, Float.valueOf(1.06f), valueOf5, valueOf5};
        SCALED_RATIO_T = new Float[]{valueOf4, valueOf, valueOf2, valueOf3, valueOf3};
        SCALED_RATIO_NONE = new Float[]{valueOf, valueOf, valueOf, valueOf, valueOf};
        mCustomerRatios = new HashMap<>();
        mCustomerRatioIndex = 10;
        mTargetLevel = 1;
        mTargetLevel = FontSizeSharedPrefs.INSTANCE.getInt("key_text_size", 1);
    }

    @JvmStatic
    public static final int getFontSizeType() {
        boolean z;
        int i = mTargetLevel;
        if (i >= 0 && i < 5) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return 1;
        }
        return i;
    }

    @JvmStatic
    public static final int getIOSFontSizeType() {
        return getFontSizeType() + 1;
    }

    @JvmStatic
    public static final float getScaledSizeH() {
        return SCALED_RATIO_H[getFontSizeType()].floatValue();
    }

    private final int getTargetLevel() {
        return mTargetLevel;
    }

    private final boolean isDebug() {
        return FontSizeRuntime.getFontSizeBusiness().isDebug();
    }

    @JvmStatic
    public static final boolean isFontSizeBigger() {
        if (getFontSizeType() > 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void reloadTargetLevelFromSp() {
        mTargetLevel = FontSizeSharedPrefs.INSTANCE.getInt("key_text_size", 1);
    }

    @JvmStatic
    public static final int addCustomerRatio(Float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length >= 5) {
            HashMap<Integer, Float[]> hashMap = mCustomerRatios;
            int i = mCustomerRatioIndex + 1;
            mCustomerRatioIndex = i;
            hashMap.put(Integer.valueOf(i), array);
            return mCustomerRatioIndex;
        }
        return -1;
    }

    @JvmStatic
    public static final Drawable getDrawableByResId(@DrawableRes int i) {
        return ResUtil.getDrawableByResId(i);
    }

    private final Bitmap parseDrawableToBitmap(Drawable drawable) throws Exception {
        Bitmap.Config config;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public final void setTargetLevel(int i) {
        mTargetLevel = i;
    }

    private final boolean checkScaledRequired(int i, int i2, int i3) {
        boolean z;
        if (i3 == 1) {
            return false;
        }
        if (i == 0 && i3 == 0) {
            return false;
        }
        if (i3 >= 0 && i3 < 5) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i))) {
            return true;
        }
        return false;
    }

    @JvmStatic
    @JvmOverloads
    public static final Drawable getScaledDrawableRes(int i, @DrawableRes int i2, int i3) {
        return getScaledDrawable(i, ResUtil.getDrawableByResId(i2), i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T extends Drawable> T getDrawableWithScaledOperation(int i, T t, int i2, int i3, Function3<? super Float, ? super Float, ? super T, ? extends T> function3) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        if (t != null) {
            float standardScreen = DisplayUtilsKt.toStandardScreen(t.getIntrinsicWidth());
            float standardScreen2 = DisplayUtilsKt.toStandardScreen(t.getIntrinsicHeight());
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen * f, standardScreen2 * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        return function3.invoke(Float.valueOf(scaled2DSizeInfo.getScaledWidth()), Float.valueOf(scaled2DSizeInfo.getScaledHeight()), t);
                    }
                    return t;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BitmapDrawable getScaledBitmapDrawable(int i, BitmapDrawable bitmapDrawable, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        double ceil;
        int i5;
        double ceil2;
        int i6;
        if (bitmapDrawable != null) {
            float standardScreen = DisplayUtilsKt.toStandardScreen(bitmapDrawable.getIntrinsicWidth());
            float standardScreen2 = DisplayUtilsKt.toStandardScreen(bitmapDrawable.getIntrinsicHeight());
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen * f, standardScreen2 * f);
                    }
                    if (scaled2DSizeInfo.isScaledRequired()) {
                        float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                        float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                        Bitmap bitmap = bitmapDrawable.getBitmap();
                        if (i4 != 0) {
                            if (i4 != 1) {
                                if (i4 != 2) {
                                    i5 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                } else {
                                    i5 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                }
                                if (i4 == 0) {
                                    if (i4 != 1) {
                                        if (i4 != 2) {
                                            i6 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        } else {
                                            i6 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        }
                                        bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i5, i6, true));
                                    } else {
                                        ceil2 = Math.floor(scaledHeight);
                                    }
                                } else {
                                    ceil2 = Math.ceil(scaledHeight);
                                }
                                i6 = (int) ceil2;
                                bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i5, i6, true));
                            } else {
                                ceil = Math.floor(scaledWidth);
                            }
                        } else {
                            ceil = Math.ceil(scaledWidth);
                        }
                        i5 = (int) ceil;
                        if (i4 == 0) {
                        }
                        i6 = (int) ceil2;
                        bitmapDrawable = new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i5, i6, true));
                    }
                }
            }
            z2 = false;
            if (z2) {
            }
            if (scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            bitmapDrawable = null;
        }
        return bitmapDrawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8 A[Catch: Exception -> 0x00f5, Error -> 0x0104, TryCatch #2 {Error -> 0x0104, Exception -> 0x00f5, blocks: (B:46:0x00ad, B:50:0x00b7, B:55:0x00ce, B:59:0x00d8, B:64:0x00ef, B:60:0x00dd, B:61:0x00e2, B:63:0x00ed, B:62:0x00e8, B:51:0x00bc, B:52:0x00c1, B:54:0x00cc, B:53:0x00c7), top: B:76:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap getScaledBitmapInner(int i, Bitmap bitmap, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        double ceil;
        int i5;
        double ceil2;
        int i6;
        if (bitmap != null) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, width, height);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, width * f, height * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        try {
                            float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                            if (i4 != 0) {
                                if (i4 != 1) {
                                    if (i4 != 2) {
                                        i5 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i5 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                                    if (i4 == 0) {
                                        if (i4 != 1) {
                                            if (i4 != 2) {
                                                i6 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i6 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            return Bitmap.createScaledBitmap(bitmap, i5, i6, true);
                                        }
                                        ceil2 = Math.floor(scaledHeight);
                                    } else {
                                        ceil2 = Math.ceil(scaledHeight);
                                    }
                                    i6 = (int) ceil2;
                                    return Bitmap.createScaledBitmap(bitmap, i5, i6, true);
                                }
                                ceil = Math.floor(scaledWidth);
                            } else {
                                ceil = Math.ceil(scaledWidth);
                            }
                            i5 = (int) ceil;
                            float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                            if (i4 == 0) {
                            }
                            i6 = (int) ceil2;
                            return Bitmap.createScaledBitmap(bitmap, i5, i6, true);
                        } catch (Error e) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        } catch (Exception e2) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e2.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        }
                    }
                    return bitmap;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094 A[Catch: all -> 0x00b1, TryCatch #0 {all -> 0x00b1, blocks: (B:4:0x000d, B:6:0x002b, B:9:0x0031, B:11:0x0035, B:13:0x003d, B:17:0x0061, B:22:0x0078, B:26:0x0084, B:31:0x009b, B:27:0x0089, B:28:0x008e, B:30:0x0099, B:29:0x0094, B:18:0x0066, B:19:0x006b, B:21:0x0076, B:20:0x0071, B:32:0x00a7, B:33:0x00ab, B:34:0x00ad), top: B:39:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T extends Drawable> T getMListDrawable(T t, float f, float f2, int i) {
        Object[] objArr;
        double ceil;
        int i2;
        double ceil2;
        int i3;
        LevelListDrawable levelListDrawable = new LevelListDrawable();
        Drawable.ConstantState constantState = t.getConstantState();
        if (constantState != null) {
            try {
                Result.Companion companion = Result.Companion;
                int i4 = 0;
                Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                method.setAccessible(true);
                Object invoke = method.invoke(constantState, new Object[0]);
                Unit unit = null;
                if (invoke instanceof Object[]) {
                    objArr = (Object[]) invoke;
                } else {
                    objArr = null;
                }
                if (objArr != null) {
                    int length = objArr.length;
                    int i5 = 0;
                    while (i4 < length) {
                        Object obj = objArr[i4];
                        int i6 = i5 + 1;
                        if (obj instanceof BitmapDrawable) {
                            Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
                            float f3 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                            float standardScreen = DisplayUtilsKt.toStandardScreen(f * f3);
                            if (i != 0) {
                                if (i != 1) {
                                    if (i != 2) {
                                        i2 = MathKt__MathJVMKt.roundToInt(standardScreen);
                                    } else {
                                        i2 = MathKt__MathJVMKt.roundToInt(standardScreen);
                                    }
                                    float standardScreen2 = DisplayUtilsKt.toStandardScreen(f3 * f2);
                                    if (i == 0) {
                                        if (i != 1) {
                                            if (i != 2) {
                                                i3 = MathKt__MathJVMKt.roundToInt(standardScreen2);
                                            } else {
                                                i3 = MathKt__MathJVMKt.roundToInt(standardScreen2);
                                            }
                                            levelListDrawable.addLevel(i5, i5, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, i2, i3, true)));
                                        } else {
                                            ceil2 = Math.floor(standardScreen2);
                                        }
                                    } else {
                                        ceil2 = Math.ceil(standardScreen2);
                                    }
                                    i3 = (int) ceil2;
                                    levelListDrawable.addLevel(i5, i5, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, i2, i3, true)));
                                } else {
                                    ceil = Math.floor(standardScreen);
                                }
                            } else {
                                ceil = Math.ceil(standardScreen);
                            }
                            i2 = (int) ceil;
                            float standardScreen22 = DisplayUtilsKt.toStandardScreen(f3 * f2);
                            if (i == 0) {
                            }
                            i3 = (int) ceil2;
                            levelListDrawable.addLevel(i5, i5, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, i2, i3, true)));
                        }
                        i4++;
                        i5 = i6;
                    }
                    unit = Unit.INSTANCE;
                }
                Result.m855constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m855constructorimpl(ResultKt.createFailure(th));
            }
        }
        return levelListDrawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Scaled1DSizeInfo getScaled1DSizeInfo(int i, float f, int i2, int i3) {
        boolean z;
        boolean z2;
        Float[] fArr;
        if (i3 != 1 && (i != 0 || i3 != 0)) {
            if (i3 >= 0 && i3 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f2 = 1.0f;
                if (z2) {
                    return new Scaled1DSizeInfo(false, 1.0f, f);
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                    f2 = fArr[i3].floatValue();
                                }
                            } else {
                                f2 = SCALED_RATIO_T[i3].floatValue();
                            }
                        } else {
                            f2 = SCALED_RATIO_H[i3].floatValue();
                        }
                    } else {
                        f2 = SCALED_RATIO_CONTENT[i3].floatValue();
                    }
                } else {
                    f2 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                }
                return new Scaled1DSizeInfo(true, f2, f * f2);
            }
        }
        z2 = false;
        float f22 = 1.0f;
        if (z2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float getScaledSizeInner(int i, float f, int i2, int i3) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        if (i3 != 1 && (i != 0 || i3 != 0)) {
            if (i3 >= 0 && i3 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f2 = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, f);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f2 = fArr[i3].floatValue();
                                    }
                                } else {
                                    f2 = SCALED_RATIO_T[i3].floatValue();
                                }
                            } else {
                                f2 = SCALED_RATIO_H[i3].floatValue();
                            }
                        } else {
                            f2 = SCALED_RATIO_CONTENT[i3].floatValue();
                        }
                    } else {
                        f2 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f2, f * f2);
                }
                if (!scaled1DSizeInfo.isScaledRequired()) {
                    return scaled1DSizeInfo.getScaledSize();
                }
                return f;
            }
        }
        z2 = false;
        float f22 = 1.0f;
        if (z2) {
        }
        if (!scaled1DSizeInfo.isScaledRequired()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Scaled2DSizeInfo getScaled2DSizeInfo(int i, float f, float f2, int i2, int i3) {
        boolean z;
        boolean z2;
        Float[] fArr;
        if (i3 != 1 && (i != 0 || i3 != 0)) {
            if (i3 >= 0 && i3 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                if (z2) {
                    return new Scaled2DSizeInfo(false, f, f2);
                }
                float f3 = 1.0f;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                    f3 = fArr[i3].floatValue();
                                }
                            } else {
                                f3 = SCALED_RATIO_T[i3].floatValue();
                            }
                        } else {
                            f3 = SCALED_RATIO_H[i3].floatValue();
                        }
                    } else {
                        f3 = SCALED_RATIO_CONTENT[i3].floatValue();
                    }
                } else {
                    f3 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                }
                return new Scaled2DSizeInfo(true, f * f3, f2 * f3);
            }
        }
        z2 = false;
        if (z2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ea A[Catch: Exception -> 0x00f7, Error -> 0x0106, TryCatch #2 {Error -> 0x0106, Exception -> 0x00f7, blocks: (B:47:0x00af, B:51:0x00b9, B:56:0x00d0, B:60:0x00da, B:65:0x00f1, B:61:0x00df, B:62:0x00e4, B:64:0x00ef, B:63:0x00ea, B:52:0x00be, B:53:0x00c3, B:55:0x00ce, B:54:0x00c9), top: B:77:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getScaledBitmap(int i, Bitmap bitmap, int i2) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        double ceil;
        int i3;
        double ceil2;
        int i4;
        int i5 = mTargetLevel;
        if (bitmap != null) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (i5 != 1 && (i != 0 || i5 != 0)) {
                if (i5 >= 0 && i5 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, width, height);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i5].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i5].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i5].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i5].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i5].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, width * f, height * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        try {
                            float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                            if (i2 != 0) {
                                if (i2 != 1) {
                                    if (i2 != 2) {
                                        i3 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i3 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                                    if (i2 == 0) {
                                        if (i2 != 1) {
                                            if (i2 != 2) {
                                                i4 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i4 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            return Bitmap.createScaledBitmap(bitmap, i3, i4, true);
                                        }
                                        ceil2 = Math.floor(scaledHeight);
                                    } else {
                                        ceil2 = Math.ceil(scaledHeight);
                                    }
                                    i4 = (int) ceil2;
                                    return Bitmap.createScaledBitmap(bitmap, i3, i4, true);
                                }
                                ceil = Math.floor(scaledWidth);
                            } else {
                                ceil = Math.ceil(scaledWidth);
                            }
                            i3 = (int) ceil;
                            float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                            if (i2 == 0) {
                            }
                            i4 = (int) ceil2;
                            return Bitmap.createScaledBitmap(bitmap, i3, i4, true);
                        } catch (Error e) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        } catch (Exception e2) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e2.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        }
                    }
                    return bitmap;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[Catch: Exception -> 0x00d2, TryCatch #0 {Exception -> 0x00d2, blocks: (B:4:0x0004, B:6:0x0008, B:9:0x000d, B:10:0x0014, B:32:0x0055, B:50:0x00c0, B:40:0x0067, B:42:0x0075, B:44:0x0085, B:49:0x00b7, B:45:0x008c, B:46:0x0097, B:47:0x00a2, B:48:0x00ad, B:27:0x0043), top: B:56:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005b  */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FontScaledSize getScaledDrawableSize(int i, Drawable drawable, int i2) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        if (drawable != null) {
            try {
                if (!(drawable instanceof BitmapDrawable) && !(drawable instanceof StateListDrawable)) {
                    return new FontScaledSize(false, 0.0f, 0.0f);
                }
                float standardScreen = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
                float standardScreen2 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
                int i3 = mTargetLevel;
                if (i3 != 1 && (i != 0 || i3 != 0)) {
                    if (i3 >= 0 && i3 < 5) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                        z2 = true;
                        if (z2) {
                            scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                        } else {
                            float f = 1.0f;
                            if (i != 0) {
                                if (i != 1) {
                                    if (i != 2) {
                                        if (i != 3) {
                                            if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                                f = fArr[i3].floatValue();
                                            }
                                        } else {
                                            f = SCALED_RATIO_T[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_H[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_CONTENT[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                            }
                            scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen * f, standardScreen2 * f);
                        }
                        return new FontScaledSize(scaled2DSizeInfo.isScaledRequired(), scaled2DSizeInfo.getScaledWidth(), scaled2DSizeInfo.getScaledHeight());
                    }
                }
                z2 = false;
                if (z2) {
                }
                return new FontScaledSize(scaled2DSizeInfo.isScaledRequired(), scaled2DSizeInfo.getScaledWidth(), scaled2DSizeInfo.getScaledHeight());
            } catch (Exception unused) {
                return new FontScaledSize(false, 0.0f, 0.0f);
            }
        }
        return new FontScaledSize(false, 0.0f, 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    @Deprecated(message = "使用此方法仅适用于矩阵产品")
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float getScaledSizeWithBaseFontSize(int i, float f, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        float floatValue;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        Float[] fArr2;
        if (i2 >= 0 && i2 < 5) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return f;
        }
        int i3 = mTargetLevel;
        if (i3 != 1 && (i != 0 || i3 != 0)) {
            if (i3 >= 0 && i3 < 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z3 = true;
                float f2 = 1.0f;
                if (z3) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, f);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        floatValue = fArr[i3].floatValue();
                                    } else {
                                        floatValue = 1.0f;
                                    }
                                } else {
                                    floatValue = SCALED_RATIO_T[i3].floatValue();
                                }
                            } else {
                                floatValue = SCALED_RATIO_H[i3].floatValue();
                            }
                        } else {
                            floatValue = SCALED_RATIO_CONTENT[i3].floatValue();
                        }
                    } else {
                        floatValue = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue, f * floatValue);
                }
                if (scaled1DSizeInfo.isScaledRequired()) {
                    f = scaled1DSizeInfo.getScaledSize();
                }
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                    f2 = fArr2[i2].floatValue();
                                }
                            } else {
                                f2 = SCALED_RATIO_T[i2].floatValue();
                            }
                        } else {
                            f2 = SCALED_RATIO_H[i2].floatValue();
                        }
                    } else {
                        f2 = SCALED_RATIO_CONTENT[i2].floatValue();
                    }
                } else {
                    f2 = SCALED_RATIO_FRAMEWORK[i2].floatValue();
                }
                return f / f2;
            }
        }
        z3 = false;
        float f22 = 1.0f;
        if (z3) {
        }
        if (scaled1DSizeInfo.isScaledRequired()) {
        }
        if (i == 0) {
        }
        return f / f22;
    }

    public static /* synthetic */ Bitmap getScaledBitmap$default(int i, Bitmap bitmap, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        return getScaledBitmap(i, bitmap, i2);
    }

    public static /* synthetic */ Drawable getScaledDrawable$default(int i, Drawable drawable, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        return getScaledDrawable(i, drawable, i2);
    }

    public static /* synthetic */ Drawable getScaledDrawableRes$default(int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return getScaledDrawableRes(i, i2, i3);
    }

    public static /* synthetic */ FontScaledSize getScaledDrawableSize$default(int i, Drawable drawable, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        return getScaledDrawableSize(i, drawable, i2);
    }

    public static /* synthetic */ int getScaledSize$default(int i, float f, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        return getScaledSize(i, f, i2);
    }

    public static /* synthetic */ void getScaledSizeArray$default(int i, int[] iArr, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        getScaledSizeArray(i, iArr, i2);
    }

    public static /* synthetic */ int getScaledSizeRes$default(int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return getScaledSizeRes(i, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8 A[Catch: Exception -> 0x00f5, Error -> 0x0104, TryCatch #2 {Error -> 0x0104, Exception -> 0x00f5, blocks: (B:46:0x00ad, B:50:0x00b7, B:55:0x00ce, B:59:0x00d8, B:64:0x00ef, B:60:0x00dd, B:61:0x00e2, B:63:0x00ed, B:62:0x00e8, B:51:0x00bc, B:52:0x00c1, B:54:0x00cc, B:53:0x00c7), top: B:76:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getScaledBitmapForTargetFontSize(int i, Bitmap bitmap, int i2, int i3) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        double ceil;
        int i4;
        double ceil2;
        int i5;
        if (bitmap != null) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (i2 != 1 && (i != 0 || i2 != 0)) {
                if (i2 >= 0 && i2 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, width, height);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i2].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i2].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i2].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i2].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i2].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, width * f, height * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        try {
                            float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                            if (i3 != 0) {
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        i4 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i4 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                                    if (i3 == 0) {
                                        if (i3 != 1) {
                                            if (i3 != 2) {
                                                i5 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i5 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            return Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                                        }
                                        ceil2 = Math.floor(scaledHeight);
                                    } else {
                                        ceil2 = Math.ceil(scaledHeight);
                                    }
                                    i5 = (int) ceil2;
                                    return Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                                }
                                ceil = Math.floor(scaledWidth);
                            } else {
                                ceil = Math.ceil(scaledWidth);
                            }
                            i4 = (int) ceil;
                            float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                            if (i3 == 0) {
                            }
                            i5 = (int) ceil2;
                            return Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                        } catch (Error e) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        } catch (Exception e2) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e2.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        }
                    }
                    return bitmap;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ea A[Catch: Exception -> 0x00f7, Error -> 0x0106, TryCatch #2 {Error -> 0x0106, Exception -> 0x00f7, blocks: (B:47:0x00af, B:51:0x00b9, B:56:0x00d0, B:60:0x00da, B:65:0x00f1, B:61:0x00df, B:62:0x00e4, B:64:0x00ef, B:63:0x00ea, B:52:0x00be, B:53:0x00c3, B:55:0x00ce, B:54:0x00c9), top: B:77:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Bitmap getScaledBitmapWithBaseFontSize(int i, Bitmap bitmap, int i2, int i3) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        double ceil;
        int i4;
        double ceil2;
        int i5;
        int i6 = mTargetLevel;
        if (bitmap != null) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (i6 != 1 && (i != 0 || i6 != 0)) {
                if (i6 >= 0 && i6 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, width, height);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i6].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i6].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i6].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i6].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i6].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, width * f, height * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        try {
                            float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                            if (i3 != 0) {
                                if (i3 != 1) {
                                    if (i3 != 2) {
                                        i4 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i4 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                                    if (i3 == 0) {
                                        if (i3 != 1) {
                                            if (i3 != 2) {
                                                i5 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i5 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            return Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                                        }
                                        ceil2 = Math.floor(scaledHeight);
                                    } else {
                                        ceil2 = Math.ceil(scaledHeight);
                                    }
                                    i5 = (int) ceil2;
                                    return Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                                }
                                ceil = Math.floor(scaledWidth);
                            } else {
                                ceil = Math.ceil(scaledWidth);
                            }
                            i4 = (int) ceil;
                            float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                            if (i3 == 0) {
                            }
                            i5 = (int) ceil2;
                            return Bitmap.createScaledBitmap(bitmap, i4, i5, true);
                        } catch (Error e) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        } catch (Exception e2) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e2.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        }
                    }
                    return bitmap;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0032 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:26:0x0032, B:46:0x00a0, B:50:0x00ab, B:52:0x00ca, B:49:0x00a7, B:35:0x0045, B:37:0x0053, B:39:0x0063, B:45:0x0098, B:41:0x006d, B:42:0x0078, B:43:0x0083, B:44:0x008e, B:20:0x001e), top: B:59:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7 A[Catch: Exception -> 0x0038, TryCatch #0 {Exception -> 0x0038, blocks: (B:26:0x0032, B:46:0x00a0, B:50:0x00ab, B:52:0x00ca, B:49:0x00a7, B:35:0x0045, B:37:0x0053, B:39:0x0063, B:45:0x0098, B:41:0x006d, B:42:0x0078, B:43:0x0083, B:44:0x008e, B:20:0x001e), top: B:59:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:26:0x0032, B:46:0x00a0, B:50:0x00ab, B:52:0x00ca, B:49:0x00a7, B:35:0x0045, B:37:0x0053, B:39:0x0063, B:45:0x0098, B:41:0x006d, B:42:0x0078, B:43:0x0083, B:44:0x008e, B:20:0x001e), top: B:59:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NinePatchDrawable getScaledNinePatchDrawable(int i, NinePatchDrawable ninePatchDrawable, int i2, int i3) {
        boolean z;
        boolean z2;
        float floatValue;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        if (ninePatchDrawable != null) {
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (i <= -1 || i >= 4) {
                        try {
                            if (!mCustomerRatios.containsKey(Integer.valueOf(i))) {
                            }
                        } catch (Exception e) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e.printStackTrace();
                                return ninePatchDrawable;
                            }
                            return ninePatchDrawable;
                        }
                    }
                    z2 = true;
                    float f = 1.0f;
                    if (z2) {
                        scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, 1.0f);
                    } else {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            floatValue = fArr[i3].floatValue();
                                        } else {
                                            floatValue = 1.0f;
                                        }
                                    } else {
                                        floatValue = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    floatValue = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                floatValue = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            floatValue = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue, 1.0f * floatValue);
                    }
                    if (!scaled1DSizeInfo.isScaledRequired()) {
                        f = scaled1DSizeInfo.getScaledSize();
                    }
                    int i4 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
                    float f2 = i4 * f;
                    ninePatchDrawable.setTargetDensity((int) f2);
                    if (!FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                        Log.d(TAG, "scaled: " + f + ", displayMetrics: " + i4 + ", result: " + f2);
                        return ninePatchDrawable;
                    }
                    return ninePatchDrawable;
                }
            }
            z2 = false;
            float f3 = 1.0f;
            if (z2) {
            }
            if (!scaled1DSizeInfo.isScaledRequired()) {
            }
            int i42 = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi;
            float f22 = i42 * f3;
            ninePatchDrawable.setTargetDensity((int) f22);
            if (!FontSizeRuntime.getFontSizeBusiness().isDebug()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0089 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x001d, B:9:0x0027, B:10:0x0043, B:12:0x0047, B:14:0x0053, B:37:0x0089, B:54:0x00f0, B:58:0x00fb, B:57:0x00f7, B:44:0x0099, B:46:0x00a7, B:48:0x00b7, B:53:0x00e9, B:49:0x00be, B:50:0x00c9, B:51:0x00d4, B:52:0x00df, B:31:0x0075, B:6:0x0013), top: B:65:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f7 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:3:0x0004, B:5:0x000a, B:7:0x001d, B:9:0x0027, B:10:0x0043, B:12:0x0047, B:14:0x0053, B:37:0x0089, B:54:0x00f0, B:58:0x00fb, B:57:0x00f7, B:44:0x0099, B:46:0x00a7, B:48:0x00b7, B:53:0x00e9, B:49:0x00be, B:50:0x00c9, B:51:0x00d4, B:52:0x00df, B:31:0x0075, B:6:0x0013), top: B:65:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void scaledGradientDrawable(int i, GradientDrawable gradientDrawable, int i2, int i3) {
        Object fieldValue;
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                fieldValue = Float.valueOf(gradientDrawable.getCornerRadius());
            } else {
                fieldValue = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
            }
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
            }
            if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                float floatValue = ((Number) fieldValue).floatValue();
                if (i3 != 1 && (i != 0 || i3 != 0)) {
                    if (i3 >= 0 && i3 < 5) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                        z2 = true;
                        float f = 1.0f;
                        if (z2) {
                            scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, floatValue);
                        } else {
                            if (i != 0) {
                                if (i != 1) {
                                    if (i != 2) {
                                        if (i != 3) {
                                            if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                                f = fArr[i3].floatValue();
                                            }
                                        } else {
                                            f = SCALED_RATIO_T[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_H[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_CONTENT[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                            }
                            scaled1DSizeInfo = new Scaled1DSizeInfo(true, f, floatValue * f);
                        }
                        if (!scaled1DSizeInfo.isScaledRequired()) {
                            floatValue = scaled1DSizeInfo.getScaledSize();
                        }
                        gradientDrawable.setCornerRadius(floatValue);
                    }
                }
                z2 = false;
                float f2 = 1.0f;
                if (z2) {
                }
                if (!scaled1DSizeInfo.isScaledRequired()) {
                }
                gradientDrawable.setCornerRadius(floatValue);
            }
        } catch (Exception e) {
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ Bitmap getScaledBitmapForTargetFontSize$default(int i, Bitmap bitmap, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        return getScaledBitmapForTargetFontSize(i, bitmap, i2, i3);
    }

    public static /* synthetic */ Bitmap getScaledBitmapWithBaseFontSize$default(int i, Bitmap bitmap, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        return getScaledBitmapWithBaseFontSize(i, bitmap, i2, i3);
    }

    public static /* synthetic */ Drawable getScaledDrawableForTargetFontSize$default(int i, Drawable drawable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        return getScaledDrawableForTargetFontSize(i, drawable, i2, i3);
    }

    public static /* synthetic */ Drawable getScaledDrawableWithBaseFontSize$default(int i, Drawable drawable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        return getScaledDrawableWithBaseFontSize(i, drawable, i2, i3);
    }

    public static /* synthetic */ StateListDrawable setScaledStateListDrawable$default(int i, List list, List list2, int i2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        return setScaledStateListDrawable(i, list, list2, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ed A[Catch: Exception -> 0x00fa, Error -> 0x0109, TryCatch #2 {Error -> 0x0109, Exception -> 0x00fa, blocks: (B:48:0x00b2, B:52:0x00bc, B:57:0x00d3, B:61:0x00dd, B:66:0x00f4, B:62:0x00e2, B:63:0x00e7, B:65:0x00f2, B:64:0x00ed, B:53:0x00c1, B:54:0x00c6, B:56:0x00d1, B:55:0x00cc), top: B:78:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Bitmap getScaledBitmapInner$default(FontSizeHelper fontSizeHelper, int i, Bitmap bitmap, int i2, int i3, int i4, int i5, Object obj) {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        double ceil;
        int i6;
        double ceil2;
        int i7;
        if ((i5 & 16) != 0) {
            i4 = 2;
        }
        if (bitmap != null) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, width, height);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, width * f, height * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        try {
                            float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                            if (i4 != 0) {
                                if (i4 != 1) {
                                    if (i4 != 2) {
                                        i6 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    } else {
                                        i6 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                    }
                                    float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                                    if (i4 == 0) {
                                        if (i4 != 1) {
                                            if (i4 != 2) {
                                                i7 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            } else {
                                                i7 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                            }
                                            return Bitmap.createScaledBitmap(bitmap, i6, i7, true);
                                        }
                                        ceil2 = Math.floor(scaledHeight);
                                    } else {
                                        ceil2 = Math.ceil(scaledHeight);
                                    }
                                    i7 = (int) ceil2;
                                    return Bitmap.createScaledBitmap(bitmap, i6, i7, true);
                                }
                                ceil = Math.floor(scaledWidth);
                            } else {
                                ceil = Math.ceil(scaledWidth);
                            }
                            i6 = (int) ceil;
                            float scaledHeight2 = scaled2DSizeInfo.getScaledHeight();
                            if (i4 == 0) {
                            }
                            i7 = (int) ceil2;
                            return Bitmap.createScaledBitmap(bitmap, i6, i7, true);
                        } catch (Error e) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        } catch (Exception e2) {
                            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                e2.printStackTrace();
                                return bitmap;
                            }
                            return bitmap;
                        }
                    }
                    return bitmap;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Drawable getScaledDrawableNotSafe(int i, Drawable drawable, int i2, int i3, int i4) throws Exception {
        boolean z;
        boolean z2;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        Bitmap.Config config;
        double ceil;
        int i5;
        double ceil2;
        int i6;
        if (drawable != null) {
            float standardScreen = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicWidth());
            float standardScreen2 = DisplayUtilsKt.toStandardScreen(drawable.getIntrinsicHeight());
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                    } else {
                        float f = 1.0f;
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            f = fArr[i3].floatValue();
                                        }
                                    } else {
                                        f = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen * f, standardScreen2 * f);
                    }
                    if (!scaled2DSizeInfo.isScaledRequired()) {
                        float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                        float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = drawable.getIntrinsicHeight();
                        if (drawable.getOpacity() != -1) {
                            config = Bitmap.Config.ARGB_8888;
                        } else {
                            config = Bitmap.Config.RGB_565;
                        }
                        Bitmap bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                        drawable.draw(canvas);
                        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                        if (i4 != 0) {
                            if (i4 != 1) {
                                if (i4 != 2) {
                                    i5 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                } else {
                                    i5 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                }
                                if (i4 == 0) {
                                    if (i4 != 1) {
                                        if (i4 != 2) {
                                            i6 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        } else {
                                            i6 = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                        }
                                        return new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i5, i6, true));
                                    }
                                    ceil2 = Math.floor(scaledHeight);
                                } else {
                                    ceil2 = Math.ceil(scaledHeight);
                                }
                                i6 = (int) ceil2;
                                return new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i5, i6, true));
                            }
                            ceil = Math.floor(scaledWidth);
                        } else {
                            ceil = Math.ceil(scaledWidth);
                        }
                        i5 = (int) ceil;
                        if (i4 == 0) {
                        }
                        i6 = (int) ceil2;
                        return new BitmapDrawable(AppRuntime.getAppContext().getResources(), Bitmap.createScaledBitmap(bitmap, i5, i6, true));
                    }
                    return drawable;
                }
            }
            z2 = false;
            if (z2) {
            }
            if (!scaled2DSizeInfo.isScaledRequired()) {
            }
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0039  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float getScaledRatio(int i) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        int i2 = mTargetLevel;
        if (i2 != 1 && (i != 0 || i2 != 0)) {
            if (i2 >= 0 && i2 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, 0.0f);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f = fArr[i2].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_T[i2].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_H[i2].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_CONTENT[i2].floatValue();
                        }
                    } else {
                        f = SCALED_RATIO_FRAMEWORK[i2].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f, 0.0f * f);
                }
                return scaled1DSizeInfo.getRatio();
            }
        }
        z2 = false;
        float f2 = 1.0f;
        if (z2) {
        }
        return scaled1DSizeInfo.getRatio();
    }

    private final float getScaledRatio(int i, int i2) {
        Float[] fArr;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (!mCustomerRatios.containsKey(Integer.valueOf(i)) || (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) == null) {
                            return 1.0f;
                        }
                        return fArr[i2].floatValue();
                    }
                    return SCALED_RATIO_T[i2].floatValue();
                }
                return SCALED_RATIO_H[i2].floatValue();
            }
            return SCALED_RATIO_CONTENT[i2].floatValue();
        }
        return SCALED_RATIO_FRAMEWORK[i2].floatValue();
    }

    @JvmStatic
    public static final Float[] getScaledRatioArray(int i) {
        Float[] fArr;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (mCustomerRatios.containsKey(Integer.valueOf(i))) {
                            fArr = mCustomerRatios.get(Integer.valueOf(i));
                            if (fArr == null) {
                                fArr = SCALED_RATIO_NONE;
                            }
                        } else {
                            fArr = SCALED_RATIO_NONE;
                        }
                        Intrinsics.checkNotNullExpressionValue(fArr, "{\n                if (mC…          }\n            }");
                        return fArr;
                    }
                    return SCALED_RATIO_T;
                }
                return SCALED_RATIO_H;
            }
            return SCALED_RATIO_CONTENT;
        }
        return SCALED_RATIO_FRAMEWORK;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float getScaledSize(int i, float f) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        int i2 = mTargetLevel;
        if (i2 != 1 && (i != 0 || i2 != 0)) {
            if (i2 >= 0 && i2 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f2 = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, f);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f2 = fArr[i2].floatValue();
                                    }
                                } else {
                                    f2 = SCALED_RATIO_T[i2].floatValue();
                                }
                            } else {
                                f2 = SCALED_RATIO_H[i2].floatValue();
                            }
                        } else {
                            f2 = SCALED_RATIO_CONTENT[i2].floatValue();
                        }
                    } else {
                        f2 = SCALED_RATIO_FRAMEWORK[i2].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f2, f * f2);
                }
                if (!scaled1DSizeInfo.isScaledRequired()) {
                    return scaled1DSizeInfo.getScaledSize();
                }
                return f;
            }
        }
        z2 = false;
        float f22 = 1.0f;
        if (z2) {
        }
        if (!scaled1DSizeInfo.isScaledRequired()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float getScaledSizeRes(int i, @DimenRes int i2) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        float dimenByResId = ResUtil.getDimenByResId(i2);
        int i3 = mTargetLevel;
        if (i3 != 1 && (i != 0 || i3 != 0)) {
            if (i3 >= 0 && i3 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, dimenByResId);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f = fArr[i3].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_T[i3].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_H[i3].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_CONTENT[i3].floatValue();
                        }
                    } else {
                        f = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f, dimenByResId * f);
                }
                if (!scaled1DSizeInfo.isScaledRequired()) {
                    return scaled1DSizeInfo.getScaledSize();
                }
                return dimenByResId;
            }
        }
        z2 = false;
        float f2 = 1.0f;
        if (z2) {
        }
        if (!scaled1DSizeInfo.isScaledRequired()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ba  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getScaledSize(int i, float f, int i2) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        double ceil;
        int i3 = mTargetLevel;
        if (i3 != 1 && (i != 0 || i3 != 0)) {
            if (i3 >= 0 && i3 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f2 = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, f);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f2 = fArr[i3].floatValue();
                                    }
                                } else {
                                    f2 = SCALED_RATIO_T[i3].floatValue();
                                }
                            } else {
                                f2 = SCALED_RATIO_H[i3].floatValue();
                            }
                        } else {
                            f2 = SCALED_RATIO_CONTENT[i3].floatValue();
                        }
                    } else {
                        f2 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f2, f * f2);
                }
                if (scaled1DSizeInfo.isScaledRequired()) {
                    f = scaled1DSizeInfo.getScaledSize();
                }
                if (i2 == 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return MathKt__MathJVMKt.roundToInt(f);
                        }
                        return MathKt__MathJVMKt.roundToInt(f);
                    }
                    ceil = Math.floor(f);
                } else {
                    ceil = Math.ceil(f);
                }
                return (int) ceil;
            }
        }
        z2 = false;
        float f22 = 1.0f;
        if (z2) {
        }
        if (scaled1DSizeInfo.isScaledRequired()) {
        }
        if (i2 == 0) {
        }
        return (int) ceil;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final float getScaledSizeForTargetFontSize(int i, float f, int i2) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        if (i2 != 1 && (i != 0 || i2 != 0)) {
            if (i2 >= 0 && i2 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f2 = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, f);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f2 = fArr[i2].floatValue();
                                    }
                                } else {
                                    f2 = SCALED_RATIO_T[i2].floatValue();
                                }
                            } else {
                                f2 = SCALED_RATIO_H[i2].floatValue();
                            }
                        } else {
                            f2 = SCALED_RATIO_CONTENT[i2].floatValue();
                        }
                    } else {
                        f2 = SCALED_RATIO_FRAMEWORK[i2].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f2, f * f2);
                }
                if (!scaled1DSizeInfo.isScaledRequired()) {
                    return scaled1DSizeInfo.getScaledSize();
                }
                return f;
            }
        }
        z2 = false;
        float f22 = 1.0f;
        if (z2) {
        }
        if (!scaled1DSizeInfo.isScaledRequired()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final int getScaledSizeRes(int i, @DimenRes int i2, int i3) {
        boolean z;
        boolean z2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr;
        double ceil;
        float dimenByResId = ResUtil.getDimenByResId(i2);
        int i4 = mTargetLevel;
        if (i4 != 1 && (i != 0 || i4 != 0)) {
            if (i4 >= 0 && i4 < 5) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                z2 = true;
                float f = 1.0f;
                if (z2) {
                    scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, dimenByResId);
                } else {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                        f = fArr[i4].floatValue();
                                    }
                                } else {
                                    f = SCALED_RATIO_T[i4].floatValue();
                                }
                            } else {
                                f = SCALED_RATIO_H[i4].floatValue();
                            }
                        } else {
                            f = SCALED_RATIO_CONTENT[i4].floatValue();
                        }
                    } else {
                        f = SCALED_RATIO_FRAMEWORK[i4].floatValue();
                    }
                    scaled1DSizeInfo = new Scaled1DSizeInfo(true, f, dimenByResId * f);
                }
                if (scaled1DSizeInfo.isScaledRequired()) {
                    dimenByResId = scaled1DSizeInfo.getScaledSize();
                }
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return MathKt__MathJVMKt.roundToInt(dimenByResId);
                        }
                        return MathKt__MathJVMKt.roundToInt(dimenByResId);
                    }
                    ceil = Math.floor(dimenByResId);
                } else {
                    ceil = Math.ceil(dimenByResId);
                }
                return (int) ceil;
            }
        }
        z2 = false;
        float f2 = 1.0f;
        if (z2) {
        }
        if (scaled1DSizeInfo.isScaledRequired()) {
        }
        if (i3 == 0) {
        }
        return (int) ceil;
    }

    @JvmStatic
    public static final void getScaledSizeArray(int i, int[] sizeArray, int i2) {
        boolean z;
        double ceil;
        int i3;
        Intrinsics.checkNotNullParameter(sizeArray, "sizeArray");
        float scaledRatio = getScaledRatio(i);
        int i4 = 0;
        if (scaledRatio == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        int length = sizeArray.length;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i5 + 1;
            float f = sizeArray[i4] * scaledRatio;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        i3 = MathKt__MathJVMKt.roundToInt(f);
                    } else {
                        i3 = MathKt__MathJVMKt.roundToInt(f);
                    }
                    sizeArray[i5] = i3;
                    i4++;
                    i5 = i6;
                } else {
                    ceil = Math.floor(f);
                }
            } else {
                ceil = Math.ceil(f);
            }
            i3 = (int) ceil;
            sizeArray[i5] = i3;
            i4++;
            i5 = i6;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:182:0x032b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:215:0x0357 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0202 A[Catch: Exception -> 0x0363, TryCatch #3 {Exception -> 0x0363, blocks: (B:89:0x0196, B:91:0x01ad, B:94:0x01b4, B:96:0x01b8, B:98:0x01be, B:102:0x01cb, B:112:0x01f1, B:118:0x020a, B:190:0x0357, B:114:0x01f7, B:115:0x01fc, B:117:0x0207, B:116:0x0202, B:104:0x01d4, B:105:0x01d9, B:107:0x01e8, B:106:0x01e1, B:119:0x021b, B:121:0x0221, B:186:0x032f, B:188:0x0339, B:191:0x0360), top: B:208:0x0196 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a8 A[Catch: Exception -> 0x032d, TryCatch #1 {Exception -> 0x032d, blocks: (B:122:0x0223, B:124:0x0229, B:126:0x023c, B:128:0x0246, B:129:0x0262, B:131:0x0266, B:133:0x0272, B:154:0x02a8, B:163:0x02c0, B:165:0x02ce, B:167:0x02de, B:173:0x0313, B:169:0x02e8, B:170:0x02f3, B:171:0x02fe, B:172:0x0309, B:149:0x0295, B:125:0x0232), top: B:204:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0323 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0162 A[Catch: all -> 0x0181, TryCatch #0 {all -> 0x0181, blocks: (B:49:0x00e1, B:51:0x00fa, B:54:0x0100, B:56:0x0104, B:58:0x010c, B:62:0x012f, B:67:0x0146, B:71:0x0152, B:76:0x0169, B:72:0x0157, B:73:0x015c, B:75:0x0167, B:74:0x0162, B:63:0x0134, B:64:0x0139, B:66:0x0144, B:65:0x013f, B:77:0x0175, B:78:0x0179, B:80:0x017d), top: B:202:0x00e1 }] */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T extends Drawable> T getScaledStateListDrawable(int i, T t, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        float floatValue;
        Scaled2DSizeInfo scaled2DSizeInfo;
        Float[] fArr;
        BitmapDrawable[] bitmapDrawableArr;
        BitmapDrawable[] bitmapDrawableArr2;
        int i5;
        Object fieldValue;
        boolean z3;
        boolean z4;
        float floatValue2;
        Scaled1DSizeInfo scaled1DSizeInfo;
        Float[] fArr2;
        double ceil;
        int i6;
        double ceil2;
        int i7;
        int i8;
        int roundToInt;
        int roundToInt2;
        Object[] objArr;
        Unit unit;
        double ceil3;
        int i9;
        double ceil4;
        int i10;
        if (t != null) {
            float standardScreen = DisplayUtilsKt.toStandardScreen(t.getIntrinsicWidth());
            float standardScreen2 = DisplayUtilsKt.toStandardScreen(t.getIntrinsicHeight());
            int i11 = 0;
            int i12 = 1;
            if (i3 != 1 && (i != 0 || i3 != 0)) {
                if (i3 >= 0 && i3 < 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && ((i > -1 && i < 4) || mCustomerRatios.containsKey(Integer.valueOf(i)))) {
                    z2 = true;
                    int i13 = 2;
                    if (z2) {
                        scaled2DSizeInfo = new Scaled2DSizeInfo(false, standardScreen, standardScreen2);
                    } else {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                            floatValue = fArr[i3].floatValue();
                                        } else {
                                            floatValue = 1.0f;
                                        }
                                    } else {
                                        floatValue = SCALED_RATIO_T[i3].floatValue();
                                    }
                                } else {
                                    floatValue = SCALED_RATIO_H[i3].floatValue();
                                }
                            } else {
                                floatValue = SCALED_RATIO_CONTENT[i3].floatValue();
                            }
                        } else {
                            floatValue = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                        }
                        scaled2DSizeInfo = new Scaled2DSizeInfo(true, standardScreen * floatValue, standardScreen2 * floatValue);
                    }
                    if (scaled2DSizeInfo.isScaledRequired()) {
                        float scaledWidth = scaled2DSizeInfo.getScaledWidth();
                        float scaledHeight = scaled2DSizeInfo.getScaledHeight();
                        if (Build.VERSION.SDK_INT <= 23 && (t instanceof LevelListDrawable)) {
                            LevelListDrawable levelListDrawable = new LevelListDrawable();
                            Drawable.ConstantState constantState = t.getConstantState();
                            if (constantState != null) {
                                try {
                                    Result.Companion companion = Result.Companion;
                                    Method method = constantState.getClass().getMethod("getChildren", new Class[0]);
                                    method.setAccessible(true);
                                    Object invoke = method.invoke(constantState, new Object[0]);
                                    if (invoke instanceof Object[]) {
                                        objArr = (Object[]) invoke;
                                    } else {
                                        objArr = null;
                                    }
                                    if (objArr != null) {
                                        int length = objArr.length;
                                        int i14 = 0;
                                        while (i11 < length) {
                                            Object obj = objArr[i11];
                                            int i15 = i14 + 1;
                                            if (obj instanceof BitmapDrawable) {
                                                Bitmap bitmap = ((BitmapDrawable) obj).getBitmap();
                                                float f = AppRuntime.getAppContext().getResources().getDisplayMetrics().densityDpi / 160;
                                                float standardScreen3 = DisplayUtilsKt.toStandardScreen(scaledWidth * f);
                                                if (i4 != 0) {
                                                    if (i4 != 1) {
                                                        if (i4 != 2) {
                                                            i9 = MathKt__MathJVMKt.roundToInt(standardScreen3);
                                                        } else {
                                                            i9 = MathKt__MathJVMKt.roundToInt(standardScreen3);
                                                        }
                                                        float standardScreen4 = DisplayUtilsKt.toStandardScreen(f * scaledHeight);
                                                        if (i4 == 0) {
                                                            if (i4 != 1) {
                                                                if (i4 != 2) {
                                                                    i10 = MathKt__MathJVMKt.roundToInt(standardScreen4);
                                                                } else {
                                                                    i10 = MathKt__MathJVMKt.roundToInt(standardScreen4);
                                                                }
                                                                levelListDrawable.addLevel(i14, i14, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, i9, i10, true)));
                                                            } else {
                                                                ceil4 = Math.floor(standardScreen4);
                                                            }
                                                        } else {
                                                            ceil4 = Math.ceil(standardScreen4);
                                                        }
                                                        i10 = (int) ceil4;
                                                        levelListDrawable.addLevel(i14, i14, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, i9, i10, true)));
                                                    } else {
                                                        ceil3 = Math.floor(standardScreen3);
                                                    }
                                                } else {
                                                    ceil3 = Math.ceil(standardScreen3);
                                                }
                                                i9 = (int) ceil3;
                                                float standardScreen42 = DisplayUtilsKt.toStandardScreen(f * scaledHeight);
                                                if (i4 == 0) {
                                                }
                                                i10 = (int) ceil4;
                                                levelListDrawable.addLevel(i14, i14, new BitmapDrawable(Bitmap.createScaledBitmap(bitmap, i9, i10, true)));
                                            }
                                            i11++;
                                            i14 = i15;
                                        }
                                        unit = Unit.INSTANCE;
                                    } else {
                                        unit = null;
                                    }
                                    Result.m855constructorimpl(unit);
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    Result.m855constructorimpl(ResultKt.createFailure(th));
                                }
                                Unit unit2 = Unit.INSTANCE;
                            }
                            Unit unit3 = Unit.INSTANCE;
                            return levelListDrawable;
                        }
                        Drawable.ConstantState constantState2 = t.getConstantState();
                        if (constantState2 != null) {
                            try {
                                Method method2 = constantState2.getClass().getMethod("getChildren", new Class[0]);
                                method2.setAccessible(true);
                                Object invoke2 = method2.invoke(constantState2, new Object[0]);
                                if (invoke2 instanceof Object[]) {
                                    bitmapDrawableArr = (Object[]) invoke2;
                                } else {
                                    bitmapDrawableArr = null;
                                }
                                if (bitmapDrawableArr != null) {
                                    int length2 = bitmapDrawableArr.length;
                                    int i16 = 0;
                                    while (i16 < length2) {
                                        BitmapDrawable bitmapDrawable = bitmapDrawableArr[i16];
                                        if (bitmapDrawable instanceof BitmapDrawable) {
                                            Bitmap bitmap2 = bitmapDrawable.getBitmap();
                                            if (i4 != 0) {
                                                if (i4 != i12) {
                                                    if (i4 != i13) {
                                                        roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                                    } else {
                                                        roundToInt2 = MathKt__MathJVMKt.roundToInt(scaledWidth);
                                                    }
                                                    i6 = roundToInt2;
                                                    bitmapDrawableArr2 = bitmapDrawableArr;
                                                    if (i4 == 0) {
                                                        if (i4 != i12) {
                                                            if (i4 != 2) {
                                                                roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                                            } else {
                                                                roundToInt = MathKt__MathJVMKt.roundToInt(scaledHeight);
                                                            }
                                                            i7 = roundToInt;
                                                            i8 = i12;
                                                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, i6, i7, i8);
                                                            Object[] objArr2 = new Object[i8];
                                                            objArr2[0] = createScaledBitmap;
                                                            ReflectionUtil.invokeMethod(bitmapDrawable, "setBitmap", objArr2);
                                                        } else {
                                                            ceil2 = Math.floor(scaledHeight);
                                                        }
                                                    } else {
                                                        ceil2 = Math.ceil(scaledHeight);
                                                    }
                                                    i7 = (int) ceil2;
                                                    i8 = 1;
                                                    Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap2, i6, i7, i8);
                                                    Object[] objArr22 = new Object[i8];
                                                    objArr22[0] = createScaledBitmap2;
                                                    ReflectionUtil.invokeMethod(bitmapDrawable, "setBitmap", objArr22);
                                                } else {
                                                    bitmapDrawableArr2 = bitmapDrawableArr;
                                                    ceil = Math.floor(scaledWidth);
                                                }
                                            } else {
                                                bitmapDrawableArr2 = bitmapDrawableArr;
                                                ceil = Math.ceil(scaledWidth);
                                            }
                                            i6 = (int) ceil;
                                            if (i4 == 0) {
                                            }
                                            i7 = (int) ceil2;
                                            i8 = 1;
                                            Bitmap createScaledBitmap22 = Bitmap.createScaledBitmap(bitmap2, i6, i7, i8);
                                            Object[] objArr222 = new Object[i8];
                                            objArr222[0] = createScaledBitmap22;
                                            ReflectionUtil.invokeMethod(bitmapDrawable, "setBitmap", objArr222);
                                        } else {
                                            bitmapDrawableArr2 = bitmapDrawableArr;
                                            if (bitmapDrawable instanceof GradientDrawable) {
                                                GradientDrawable gradientDrawable = (GradientDrawable) bitmapDrawable;
                                                try {
                                                    if (Build.VERSION.SDK_INT >= 24) {
                                                        fieldValue = Float.valueOf(gradientDrawable.getCornerRadius());
                                                    } else {
                                                        fieldValue = ReflectionUtil.getFieldValue(gradientDrawable.getConstantState(), "mRadius");
                                                    }
                                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                        Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", OriginalRadius is :" + fieldValue);
                                                    }
                                                } catch (Exception e) {
                                                    e = e;
                                                    i5 = 1;
                                                }
                                                if ((fieldValue instanceof Float) && ((Number) fieldValue).floatValue() > 0.0f) {
                                                    float floatValue3 = ((Number) fieldValue).floatValue();
                                                    if (i3 != 1 && (i != 0 || i3 != 0)) {
                                                        if (i3 >= 0 && i3 < 5) {
                                                            z3 = true;
                                                        } else {
                                                            z3 = false;
                                                        }
                                                        if (z3) {
                                                            if ((i <= -1 || i >= 4) && !mCustomerRatios.containsKey(Integer.valueOf(i))) {
                                                                z4 = false;
                                                            } else {
                                                                z4 = true;
                                                            }
                                                            if (z4) {
                                                                scaled1DSizeInfo = new Scaled1DSizeInfo(false, 1.0f, floatValue3);
                                                                i5 = 1;
                                                            } else {
                                                                if (i != 0) {
                                                                    if (i != 1) {
                                                                        if (i != 2) {
                                                                            if (i != 3) {
                                                                                if (mCustomerRatios.containsKey(Integer.valueOf(i)) && (fArr2 = (Float[]) mCustomerRatios.get(Integer.valueOf(i))) != null) {
                                                                                    floatValue2 = fArr2[i3].floatValue();
                                                                                } else {
                                                                                    floatValue2 = 1.0f;
                                                                                }
                                                                            } else {
                                                                                floatValue2 = SCALED_RATIO_T[i3].floatValue();
                                                                            }
                                                                        } else {
                                                                            floatValue2 = SCALED_RATIO_H[i3].floatValue();
                                                                        }
                                                                    } else {
                                                                        floatValue2 = SCALED_RATIO_CONTENT[i3].floatValue();
                                                                    }
                                                                } else {
                                                                    floatValue2 = SCALED_RATIO_FRAMEWORK[i3].floatValue();
                                                                }
                                                                i5 = 1;
                                                                scaled1DSizeInfo = new Scaled1DSizeInfo(true, floatValue2, floatValue3 * floatValue2);
                                                            }
                                                            if (!scaled1DSizeInfo.isScaledRequired()) {
                                                                try {
                                                                    floatValue3 = scaled1DSizeInfo.getScaledSize();
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                                                        Log.d(TAG, "Version: " + Build.VERSION.SDK_INT + ", GradientDrawable ReflectionUtil Error");
                                                                        e.printStackTrace();
                                                                    }
                                                                    i16++;
                                                                    bitmapDrawableArr = bitmapDrawableArr2;
                                                                    i13 = 2;
                                                                    i12 = i5;
                                                                }
                                                            }
                                                            gradientDrawable.setCornerRadius(floatValue3);
                                                            i16++;
                                                            bitmapDrawableArr = bitmapDrawableArr2;
                                                            i13 = 2;
                                                            i12 = i5;
                                                        }
                                                    }
                                                    z4 = false;
                                                    if (z4) {
                                                    }
                                                    if (!scaled1DSizeInfo.isScaledRequired()) {
                                                    }
                                                    gradientDrawable.setCornerRadius(floatValue3);
                                                    i16++;
                                                    bitmapDrawableArr = bitmapDrawableArr2;
                                                    i13 = 2;
                                                    i12 = i5;
                                                }
                                            }
                                        }
                                        i5 = 1;
                                        i16++;
                                        bitmapDrawableArr = bitmapDrawableArr2;
                                        i13 = 2;
                                        i12 = i5;
                                    }
                                    Unit unit4 = Unit.INSTANCE;
                                }
                            } catch (Exception e3) {
                                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                                    e3.printStackTrace();
                                }
                            }
                            Unit unit5 = Unit.INSTANCE;
                        }
                        Unit unit6 = Unit.INSTANCE;
                    }
                    return t;
                }
            }
            z2 = false;
            int i132 = 2;
            if (z2) {
            }
            if (scaled2DSizeInfo.isScaledRequired()) {
            }
            return t;
        }
        return null;
    }

    private final Bitmap handleErrorException(Bitmap bitmap, Function0<Bitmap> function0) {
        try {
            return function0.invoke();
        } catch (Error e) {
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e.printStackTrace();
                return bitmap;
            }
            return bitmap;
        } catch (Exception e2) {
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e2.printStackTrace();
                return bitmap;
            }
            return bitmap;
        }
    }

    private final FontScaledSize handleException(Drawable drawable, Function1<? super Drawable, FontScaledSize> function1) {
        try {
            return function1.invoke(drawable);
        } catch (Exception unused) {
            return new FontScaledSize(false, 0.0f, 0.0f);
        }
    }

    private final Drawable handleErrorException(Drawable drawable, Function0<? extends Drawable> function0) {
        try {
            return function0.invoke();
        } catch (Error e) {
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e.printStackTrace();
                return drawable;
            }
            return drawable;
        } catch (Exception e2) {
            if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                e2.printStackTrace();
                return drawable;
            }
            return drawable;
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final StateListDrawable setScaledStateListDrawable(int i, List<? extends Drawable> drawableList, List<int[]> statesList, int i2) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(drawableList, "drawableList");
        Intrinsics.checkNotNullParameter(statesList, "statesList");
        StateListDrawable stateListDrawable = new StateListDrawable();
        int size = drawableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 < statesList.size()) {
                iArr = statesList.get(i3);
            } else {
                iArr = new int[0];
            }
            stateListDrawable.addState(iArr, getScaledDrawable(i, drawableList.get(i3), i2));
        }
        return stateListDrawable;
    }
}
