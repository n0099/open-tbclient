package com.baidu.nadcore.utils;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.tieba.hf0;
import com.baidu.tieba.u11;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a3\u0010\b\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0004*\u00028\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001aG\u0010\u0015\u001a\u00020\u0012*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0014\b\u0004\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u000e\b\u0006\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010\u0018\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u001b\u001a\u001b\u0010\u001e\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010 \u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b \u0010!\u001a*\u0010\"\u001a\u00020\u0012\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0004*\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0086\b¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010%\u001a\u00020\u001c*\u00020\n2\b\b\u0001\u0010$\u001a\u00020\u001cH\u0007¢\u0006\u0004\b%\u0010&\"*\u0010(\u001a\u00020\u0006*\u00020\u00042\u0006\u0010'\u001a\u00020\u00068Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "noOpDelegate", "()Ljava/lang/Object;", "Landroid/view/View;", "Lkotlin/Function0;", "", "predicate", "checkVisible", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)Landroid/view/View;", "", "Lorg/json/JSONObject;", "cmdToJsonObj", "(Ljava/lang/String;)Lorg/json/JSONObject;", "Landroid/content/Context;", "url", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "", "success", "loadFail", "loadDrawableFromUrl", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/Function1;Lkotlin/Function0;)V", "key", "optStringCheckNonNull", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "fallback", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "context", "px", "(ILandroid/content/Context;)I", "removeFromParent", "(Landroid/view/View;)Landroid/view/View;", "setBgFromUrl", "(Landroid/view/View;Ljava/lang/String;)V", "defaultColor", "toColor", "(Ljava/lang/String;I)I", "value", "isVisible", "(Landroid/view/View;)Z", "setVisible", "(Landroid/view/View;Z)V", "nadcore-lib-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ExtensionsKt {
    public static final JSONObject a(final String cmdToJsonObj) {
        Intrinsics.checkNotNullParameter(cmdToJsonObj, "$this$cmdToJsonObj");
        JSONObject jSONObject = new JSONObject();
        final Uri uri = Uri.parse(cmdToJsonObj);
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
        for (String str : SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(queryParameterNames), new Function1<String, Boolean>() { // from class: com.baidu.nadcore.utils.ExtensionsKt$cmdToJsonObj$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str2) {
                return Boolean.valueOf(invoke2(str2));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(String str2) {
                boolean z;
                boolean z2;
                if (cmdToJsonObj.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    String queryParameter = uri.getQueryParameter(str2);
                    if (queryParameter != null && queryParameter.length() != 0) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        return true;
                    }
                }
                return false;
            }
        })) {
            String queryParameter = uri.getQueryParameter(str);
            try {
                jSONObject.put(str, new JSONObject(queryParameter));
            } catch (Exception unused) {
                jSONObject.put(str, queryParameter);
            }
        }
        return jSONObject;
    }

    public static final String b(JSONObject optStringCheckNonNull, String key) {
        Intrinsics.checkNotNullParameter(optStringCheckNonNull, "$this$optStringCheckNonNull");
        Intrinsics.checkNotNullParameter(key, "key");
        return c(optStringCheckNonNull, key, "");
    }

    @Px
    public static final int d(int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return u11.c.a(context, i);
    }

    public static final void f(View isVisible, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(isVisible, "$this$isVisible");
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        isVisible.setVisibility(i);
    }

    public static final String c(JSONObject optStringCheckNonNull, String key, String fallback) {
        Intrinsics.checkNotNullParameter(optStringCheckNonNull, "$this$optStringCheckNonNull");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        if (!optStringCheckNonNull.isNull(key)) {
            String optString = optStringCheckNonNull.optString(key, fallback);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(key, fallback)");
            return optString;
        }
        return fallback;
    }

    public static final View e(View removeFromParent) {
        Intrinsics.checkNotNullParameter(removeFromParent, "$this$removeFromParent");
        ViewParent parent = removeFromParent.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(removeFromParent);
        }
        return removeFromParent;
    }

    @ColorInt
    public static final int g(String toColor, @ColorRes int i) {
        Integer m859constructorimpl;
        Intrinsics.checkNotNullParameter(toColor, "$this$toColor");
        try {
            Result.Companion companion = Result.Companion;
            m859constructorimpl = Result.m859constructorimpl(Integer.valueOf(Color.parseColor(toColor)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m859constructorimpl = Result.m859constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(ContextCompat.getColor(hf0.b(), i));
        if (Result.m865isFailureimpl(m859constructorimpl)) {
            m859constructorimpl = valueOf;
        }
        return ((Number) m859constructorimpl).intValue();
    }
}
