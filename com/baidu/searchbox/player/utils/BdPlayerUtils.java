package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.config.PlayerOrientationConfigKt;
import com.baidu.searchbox.player.config.PlayerPropertyKt;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.gson.internal.bind.TypeAdapters;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
import org.webrtc.MediaStreamTrack;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\r\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u000f2\u000e\b\u0004\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0016\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u001b\u001a\u00020\u0000*\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u000f\u0018\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010!\u001a\u00020\u0000*\u0004\u0018\u00010\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0013\u0010#\u001a\u00020\u0000*\u0004\u0018\u00010\u0007¢\u0006\u0004\b#\u0010\"\u001a\u0013\u0010$\u001a\u00020\u0019*\u0004\u0018\u00010\u0007¢\u0006\u0004\b$\u0010%\u001a\u0019\u0010)\u001a\u00020(*\u00020&2\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010,\u001a\u00020(*\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0000¢\u0006\u0004\b,\u0010-\u001a\u001b\u0010/\u001a\u00020(*\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\u0019¢\u0006\u0004\b/\u00100\u001a\u0011\u00101\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b1\u00102\u001a\u001e\u00104\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u000f\u0018\u0001*\u000203H\u0086\b¢\u0006\u0004\b4\u00105\"\u0016\u00106\u001a\u00020\u00008\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u00107\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"", TypeAdapters.AnonymousClass27.SECOND, "", "hours", "", "getTextWithSecond", "(IZ)Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/view/KeyEvent;", "event", "Lkotlin/Function0;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "handleVolumeKeyDown", "(Landroid/content/Context;Landroid/view/KeyEvent;Lkotlin/Function0;)Z", "T", AppDownloadNetworkStateReceiver.KEY_OPERATION, "Lkotlin/Lazy;", "lazyNone", "(Lkotlin/Function0;)Lkotlin/Lazy;", "content", "fallback", "parseIntSafe", "(Ljava/lang/String;I)I", "Landroid/view/View;", "", "dpValue", "dp2px", "(Landroid/view/View;F)I", "Lcom/baidu/searchbox/player/event/VideoEvent;", "key", "getEventExtra", "(Lcom/baidu/searchbox/player/event/VideoEvent;I)Ljava/lang/Object;", "getMaxVolume", "(Landroid/content/Context;)I", "getVolume", "getVolumePercent", "(Landroid/content/Context;)F", "Lcom/baidu/searchbox/player/BDVideoPlayer;", "lock", "", "notifyGlobalOrientationLockEvent", "(Lcom/baidu/searchbox/player/BDVideoPlayer;Z)V", "size", "setVolume", "(Landroid/content/Context;I)V", SapiOptions.KEY_CACHE_PERCENT, "setVolumePercent", "(Landroid/content/Context;F)V", "toTextString", "(I)Ljava/lang/String;", "Lcom/baidu/searchbox/player/layer/LayerContainer;", AnimationProperty.TRANSFORM, "(Lcom/baidu/searchbox/player/layer/LayerContainer;)Ljava/lang/Object;", "MSG_CONTROL_AUTO_HIDE", "I", "bdvideoplayer-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "BdPlayerUtils")
/* loaded from: classes10.dex */
public final class BdPlayerUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_CONTROL_AUTO_HIDE = 100;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int dp2px(View view, float f2) {
        InterceptResult invokeLF;
        Context context;
        Resources resources;
        DisplayMetrics displayMetrics;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, view, f2)) == null) {
            return (int) ((f2 * ((view == null || (context = view.getContext()) == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1.0f : displayMetrics.density)) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public static final /* synthetic */ <T> T getEventExtra(VideoEvent getEventExtra, int i2) {
        Intrinsics.checkNotNullParameter(getEventExtra, "$this$getEventExtra");
        T t = (T) getEventExtra.getExtra(i2);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    public static final int getMaxVolume(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Object systemService = context != null ? context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : null;
            AudioManager audioManager = systemService instanceof AudioManager ? systemService : null;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static final String getTextWithSecond(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i2 < 0) {
                return "";
            }
            int i3 = i2 / 3600;
            int i4 = (i2 % 3600) / 60;
            int i5 = i2 % 60;
            if (i3 == 0 && !z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
            return format2;
        }
        return (String) invokeCommon.objValue;
    }

    public static final int getVolume(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            Object systemService = context != null ? context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : null;
            AudioManager audioManager = systemService instanceof AudioManager ? systemService : null;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static final float getVolumePercent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            Object systemService = context != null ? context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : null;
            if ((systemService instanceof AudioManager ? systemService : null) != null) {
                return MathKt__MathJVMKt.roundToInt((getVolume(context) / getMaxVolume(context)) * 10) / 10.0f;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static final boolean handleVolumeKeyDown(Context context, KeyEvent event, Function0<Boolean> block) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, event, block)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(block, "block");
            if (context != null) {
                try {
                    if (block.invoke().booleanValue()) {
                        Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                        if (!(systemService instanceof AudioManager)) {
                            systemService = null;
                        }
                        AudioManager audioManager = (AudioManager) systemService;
                        if (audioManager != null) {
                            if (event.getKeyCode() == 25) {
                                audioManager.adjustStreamVolume(3, -1, 0);
                            } else if (event.getKeyCode() != 24) {
                                return false;
                            } else {
                                audioManager.adjustStreamVolume(3, 1, 0);
                            }
                            return true;
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e2) {
                    BdVideoLog.d("handleVolumeKeyDown", e2.getMessage());
                    return false;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static final <T> Lazy<T> lazyNone(Function0<? extends T> operation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, operation)) == null) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new BdPlayerUtils$lazyNone$1(operation));
        }
        return (Lazy) invokeL.objValue;
    }

    public static final void notifyGlobalOrientationLockEvent(BDVideoPlayer notifyGlobalOrientationLockEvent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, notifyGlobalOrientationLockEvent, z) == null) {
            Intrinsics.checkNotNullParameter(notifyGlobalOrientationLockEvent, "$this$notifyGlobalOrientationLockEvent");
            if (PlayerOrientationConfigKt.needSyncLockState(notifyGlobalOrientationLockEvent.getConfig(), z)) {
                PlayerPropertyKt.globalOrientationLockState = z;
                VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_ORIENTATION_LOCK_SYNC_STATE);
                obtainEvent.setSender(notifyGlobalOrientationLockEvent);
                obtainEvent.putExtra(7, Boolean.valueOf(z));
                VideoSessionManager.getInstance().sendEventToAll(obtainEvent);
            }
        }
    }

    @JvmOverloads
    public static final int parseIntSafe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? parseIntSafe$default(str, 0, 2, null) : invokeL.intValue;
    }

    @JvmOverloads
    public static final int parseIntSafe(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i2)) == null) {
            if (str == null || str.length() == 0) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                BdVideoLog.e("parseInt catch exception:", e2);
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static /* synthetic */ int parseIntSafe$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return parseIntSafe(str, i2);
    }

    public static final void setVolume(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, context, i2) == null) {
            Object systemService = context != null ? context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND) : null;
            AudioManager audioManager = systemService instanceof AudioManager ? systemService : null;
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i2, 8);
            }
        }
    }

    public static final void setVolumePercent(Context context, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65549, null, context, f2) == null) {
            setVolume(context, MathKt__MathJVMKt.roundToInt(getMaxVolume(context) * f2));
        }
    }

    public static final String toTextString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? i2 <= 0 ? "" : String.valueOf(i2) : (String) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.searchbox.player.layer.LayerContainer */
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> T transform(LayerContainer transform) {
        Intrinsics.checkNotNullParameter(transform, "$this$transform");
        Intrinsics.reifiedOperationMarker(2, "T");
        return transform;
    }
}
