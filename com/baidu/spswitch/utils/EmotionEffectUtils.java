package com.baidu.spswitch.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.view.EmotionEffectView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007JE\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/baidu/spswitch/utils/EmotionEffectUtils;", "", "()V", "TAG", "", "emotionEffectView", "Lcom/baidu/spswitch/emotion/view/EmotionEffectView;", "viewTag", "createEmotionDynamicView", "parentView", "Landroid/view/ViewGroup;", "path", NotificationCompat.WearableExtender.KEY_GRAVITY, "", "topMargin", "(Landroid/view/ViewGroup;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/baidu/spswitch/emotion/view/EmotionEffectView;", "getGravityType", "alignment", "play", "", "parent", "emoName", "nightMode", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/spswitch/emotion/view/EmotionEffectView$OnEmotionEffectListener;", "(Landroid/view/ViewGroup;Ljava/lang/String;ZLjava/lang/Integer;ILcom/baidu/spswitch/emotion/view/EmotionEffectView$OnEmotionEffectListener;)Z", "releaseRetriever", "", "lib_spswitch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmotionEffectUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final EmotionEffectUtils INSTANCE;
    public static final String TAG = "EmotionEffect";
    public static EmotionEffectView emotionEffectView = null;
    public static final String viewTag = "emotion_dynamic_view_tag";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1974790888, "Lcom/baidu/spswitch/utils/EmotionEffectUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1974790888, "Lcom/baidu/spswitch/utils/EmotionEffectUtils;");
                return;
            }
        }
        INSTANCE = new EmotionEffectUtils();
    }

    public EmotionEffectUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void releaseRetriever() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EmotionEffectView emotionEffectView2 = emotionEffectView;
            if (emotionEffectView2 != null) {
                emotionEffectView2.releaseRetriever();
            }
            emotionEffectView = null;
        }
    }

    private final EmotionEffectView createEmotionDynamicView(ViewGroup viewGroup, String str, Integer num, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, this, viewGroup, str, num, i)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                Object tag = childAt.getTag();
                if ((tag instanceof String) && (childAt instanceof EmotionEffectView) && TextUtils.equals(tag.toString(), viewTag)) {
                    if (SPConfig.isDebug()) {
                        Log.d(TAG, "emotion effect create view: reuse");
                    }
                    return (EmotionEffectView) childAt;
                }
            }
            if (SPConfig.isDebug()) {
                Log.d(TAG, "emotion effect create view: new");
            }
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
            EmotionEffectView emotionEffectView2 = new EmotionEffectView(context, null, num, i);
            emotionEffectView = emotionEffectView2;
            emotionEffectView2.setTag(viewTag);
            viewGroup.addView(emotionEffectView2);
            return emotionEffectView2;
        }
        return (EmotionEffectView) invokeLLLI.objValue;
    }

    @JvmStatic
    public static final int getGravityType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (Intrinsics.areEqual(str, "1")) {
                return 48;
            }
            if (Intrinsics.areEqual(str, "2")) {
                return 80;
            }
            return 17;
        }
        return invokeL.intValue;
    }

    @JvmStatic
    public static final boolean play(ViewGroup viewGroup, String str, boolean z, Integer num, int i, EmotionEffectView.OnEmotionEffectListener onEmotionEffectListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{viewGroup, str, Boolean.valueOf(z), num, Integer.valueOf(i), onEmotionEffectListener})) == null) {
            if (viewGroup != null && !TextUtils.isEmpty(str)) {
                String emotionEffectPathByName = EmotionUtils.getInstance().getEmotionEffectPathByName(str);
                if (emotionEffectPathByName == null) {
                    return false;
                }
                EmotionEffectView createEmotionDynamicView = INSTANCE.createEmotionDynamicView(viewGroup, emotionEffectPathByName, num, i);
                if (createEmotionDynamicView.isPlaying()) {
                    if (SPConfig.isDebug()) {
                        Log.d(TAG, "emotion effect is playing: return");
                    }
                    return true;
                }
                createEmotionDynamicView.playAfx(emotionEffectPathByName, z, onEmotionEffectListener);
                return true;
            }
            if (SPConfig.isDebug()) {
                Log.d(TAG, "emotion effect emoName is empty");
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
