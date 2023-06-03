package com.baidu.searchbox.player.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.ubc.PlayerStatConstants;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.google.gson.internal.bind.TypeAdapters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a(\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007\u001a\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0012H\u0007\u001a\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0019H\u0007\u001a\u001c\u0010\u001c\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0001H\u0007\u001a\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007\u001a&\u0010!\u001a\u00020\u001e*\u0012\u0012\u0004\u0012\u00020\u00030\"j\b\u0012\u0004\u0012\u00020\u0003`#2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0018\u0010%\u001a\u00020\u000b*\u0004\u0018\u00010\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0016\u0010'\u001a\u00020\u0001*\u0004\u0018\u00010 2\u0006\u0010(\u001a\u00020\u0019H\u0007\u001a\u0018\u0010)\u001a\u00020\u0019*\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020\u0019H\u0007\u001a$\u0010,\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020-2\u0006\u0010.\u001a\u00020\u0001H\u0086\b¢\u0006\u0002\u0010/\u001a0\u00100\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u0001012\b\u0010.\u001a\u0004\u0018\u00010\u00032\u0006\u0010+\u001a\u0002H\u0016H\u0086\b¢\u0006\u0002\u00102\u001a\u000e\u00103\u001a\u00020\u0001*\u0004\u0018\u00010\u000eH\u0007\u001a(\u00104\u001a\u00020\u0003*\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`#2\u0006\u00105\u001a\u00020\u0001H\u0007\u001a\u000e\u00106\u001a\u00020\u0001*\u0004\u0018\u00010\u000eH\u0007\u001a\u000e\u00107\u001a\u00020\u0019*\u0004\u0018\u00010\u000eH\u0007\u001a\u0010\u00108\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u000101H\u0007\u001a\u0013\u00109\u001a\u00020\u000b*\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010:\u001a\u0013\u0010;\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010<\u001a/\u0010=\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0016*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00160>2\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010?\u001a/\u0010@\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0016*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00160>2\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010?\u001a\u0016\u0010A\u001a\u00020\u001e*\u0004\u0018\u00010*2\u0006\u0010B\u001a\u00020\u0019H\u0007\u001a\"\u0010C\u001a\u00020\u001e*\u0004\u0018\u0001012\b\u0010.\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010DH\u0007\u001a\u000e\u0010E\u001a\u00020\u001e*\u0004\u0018\u00010*H\u0007\u001a\u0016\u0010F\u001a\u00020\u001e*\u0004\u0018\u00010\u000e2\u0006\u0010G\u001a\u00020\u0001H\u0007\u001a\u0016\u0010H\u001a\u00020\u001e*\u0004\u0018\u00010\u000e2\u0006\u0010I\u001a\u00020\u0019H\u0007\u001a\f\u0010J\u001a\u00020\u0003*\u00020\u0001H\u0007\u001a$\u0010K\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u0002H\u0016H\u0086\b¢\u0006\u0002\u0010L\u001a\u001c\u0010M\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020NH\u0086\b¢\u0006\u0002\u0010O\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"MSG_CONTROL_AUTO_HIDE", "", "getStageType", "", DI.LIVE_PLAYER, "Lcom/baidu/searchbox/player/BDVideoPlayer;", "series", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "getTextWithSecond", TypeAdapters.AnonymousClass27.SECOND, "hours", "", "handleVolumeKeyDown", "context", "Landroid/content/Context;", "event", "Landroid/view/KeyEvent;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/Function0;", "isHeadsetConnect", "lazyNone", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, AppDownloadNetworkStateReceiver.KEY_OPERATION, "parseFloatSafe", "", "content", "fallback", "parseIntSafe", "removeViewFromParent", "", "view", "Landroid/view/View;", "addNoEmpty", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "value", "compareUrlTo", "targetUrl", "dp2px", "dpValue", "getCurrentBrightness", "Landroid/app/Activity;", "defaultValue", "getEventExtra", "Lcom/baidu/searchbox/player/event/VideoEvent;", "key", "(Lcom/baidu/searchbox/player/event/VideoEvent;I)Ljava/lang/Object;", "getExtra", "Lcom/baidu/searchbox/player/layer/BaseKernelLayer;", "(Lcom/baidu/searchbox/player/layer/BaseKernelLayer;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getMaxVolume", "getOrEmpty", "index", "getVolume", "getVolumePercent", PlayerStatConstants.STAT_KEY_KERNEL_TYPE, "orFalse", "(Ljava/lang/Boolean;)Z", "orZero", "(Ljava/lang/Integer;)I", "safeGet", "Ljava/util/concurrent/ConcurrentHashMap;", "(Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;)Ljava/lang/Object;", "safeRemove", "setBrightness", "screenBrightness", "setExtra", "", "setMaxBrightness", "setVolume", "size", "setVolumePercent", "percent", "toTextString", "toValueSafe", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "transform", "Lcom/baidu/searchbox/player/layer/LayerContainer;", "(Lcom/baidu/searchbox/player/layer/LayerContainer;)Ljava/lang/Object;", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "BdPlayerUtils")
/* loaded from: classes4.dex */
public final class BdPlayerUtils {
    public static final int MSG_CONTROL_AUTO_HIDE = 100;

    @JvmOverloads
    public static final float getCurrentBrightness(Activity activity) {
        return getCurrentBrightness$default(activity, 0.0f, 1, null);
    }

    @JvmOverloads
    public static final float parseFloatSafe(String str) {
        return parseFloatSafe$default(str, 0.0f, 2, null);
    }

    @JvmOverloads
    public static final int parseIntSafe(String str) {
        return parseIntSafe$default(str, 0, 2, null);
    }

    public static final void addNoEmpty(ArrayList<String> arrayList, String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        arrayList.add(str);
    }

    public static final boolean compareUrlTo(String str, String str2) {
        if (str != null && str2 != null) {
            return Intrinsics.areEqual(Uri.parse(str).getPath(), Uri.parse(str2).getPath());
        }
        return false;
    }

    public static final int dp2px(View view2, float f) {
        float f2;
        Context context;
        Resources resources;
        DisplayMetrics displayMetrics;
        if (view2 != null && (context = view2.getContext()) != null && (resources = context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            f2 = displayMetrics.density;
        } else {
            f2 = 1.0f;
        }
        return (int) ((f * f2) + 0.5f);
    }

    @JvmOverloads
    public static final float getCurrentBrightness(Activity activity, float f) {
        Window window;
        WindowManager.LayoutParams attributes;
        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            return attributes.screenBrightness;
        }
        return f;
    }

    public static final /* synthetic */ <T> T getEventExtra(VideoEvent videoEvent, int i) {
        Intrinsics.checkNotNullParameter(videoEvent, "<this>");
        T t = (T) videoEvent.getExtra(i);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final String getOrEmpty(ArrayList<String> arrayList, int i) {
        String str;
        if (arrayList == null || (str = (String) CollectionsKt___CollectionsKt.getOrNull(arrayList, i)) == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getStageType(BDVideoPlayer bDVideoPlayer, BasicVideoSeries basicVideoSeries) {
        Integer num;
        int playerStageType;
        if (bDVideoPlayer != null) {
            playerStageType = bDVideoPlayer.getPlayerStageType();
        } else if (basicVideoSeries != null) {
            playerStageType = basicVideoSeries.getPlayerStageType();
        } else {
            num = null;
            if (num == null) {
                num = -1;
            }
            return num.toString();
        }
        num = Integer.valueOf(playerStageType);
        if (num == null) {
        }
        return num.toString();
    }

    @JvmOverloads
    public static final int parseIntSafe(String str, int i) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                BdVideoLog.e("string to target value, catch exception:", e);
                return i;
            }
        }
        return i;
    }

    public static final <T> T safeGet(ConcurrentHashMap<String, T> concurrentHashMap, String str) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
        if (str == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public static final <T> T safeRemove(ConcurrentHashMap<String, T> concurrentHashMap, String str) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
        if (str != null) {
            try {
            } catch (IllegalStateException unused) {
                return null;
            }
        }
        return concurrentHashMap.remove(str);
    }

    public static final void setBrightness(Activity activity, float f) {
        Window window;
        if (activity != null && (window = activity.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = f;
            window.setAttributes(attributes);
        }
    }

    public static final void setVolume(Context context, int i) {
        Object obj;
        AudioManager audioManager = null;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            audioManager = (AudioManager) obj;
        }
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 8);
        }
    }

    public static final void setVolumePercent(Context context, float f) {
        setVolume(context, MathKt__MathJVMKt.roundToInt(getMaxVolume(context) * f));
    }

    public static /* synthetic */ float getCurrentBrightness$default(Activity activity, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return getCurrentBrightness(activity, f);
    }

    public static /* synthetic */ float parseFloatSafe$default(String str, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return parseFloatSafe(str, f);
    }

    public static /* synthetic */ int parseIntSafe$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return parseIntSafe(str, i);
    }

    public static final /* synthetic */ <T> T getExtra(BaseKernelLayer baseKernelLayer, String str, T t) {
        StringArrayBundle extraBundle;
        if (str == null) {
            return t;
        }
        if (baseKernelLayer != null && (extraBundle = baseKernelLayer.getExtraBundle()) != null) {
            T t2 = (T) extraBundle.get((Object) str);
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (t2 instanceof Object) {
                return t2;
            }
            return t;
        }
        return null;
    }

    public static final void setExtra(BaseKernelLayer baseKernelLayer, String str, Object obj) {
        StringArrayBundle extraBundle;
        if (str != null && baseKernelLayer != null && (extraBundle = baseKernelLayer.getExtraBundle()) != null) {
            extraBundle.putExtra(str, obj);
        }
    }

    public static final int getMaxVolume(Context context) {
        Object obj;
        AudioManager audioManager = null;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            audioManager = (AudioManager) obj;
        }
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return -1;
    }

    public static final int getVolume(Context context) {
        Object obj;
        AudioManager audioManager = null;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            audioManager = (AudioManager) obj;
        }
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    public static final float getVolumePercent(Context context) {
        Object obj;
        AudioManager audioManager = null;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            audioManager = (AudioManager) obj;
        }
        if (audioManager != null) {
            return MathKt__MathJVMKt.roundToInt((getVolume(context) / getMaxVolume(context)) * 10) / 10.0f;
        }
        return 0.0f;
    }

    @SuppressLint({"MissingPermission"})
    public static final boolean isHeadsetConnect(Context context) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            AudioManager audioManager = BdVolumeUtils.getAudioManager(context);
            if (audioManager != null) {
                z = audioManager.isWiredHeadsetOn();
            } else {
                z = false;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                if (defaultAdapter.getProfileConnectionState(1) == 2) {
                    z2 = true;
                    if (z && !z2) {
                        return false;
                    }
                    return true;
                }
            }
            z2 = false;
            if (z) {
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final String kernelType(BaseKernelLayer baseKernelLayer) {
        AbsVideoKernel videoKernel;
        if (baseKernelLayer != null && (videoKernel = baseKernelLayer.getVideoKernel()) != null) {
            return videoKernel.getKernelType();
        }
        return null;
    }

    public static final <T> Lazy<T> lazyNone(final Function0<? extends T> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<T>() { // from class: com.baidu.searchbox.player.utils.BdPlayerUtils$lazyNone$1
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function0<? extends T> */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return operation.invoke();
            }
        });
    }

    public static final boolean orFalse(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final int orZero(Integer num) {
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final void setMaxBrightness(Activity activity) {
        setBrightness(activity, 1.0f);
    }

    public static final String toTextString(int i) {
        if (i <= 0) {
            return "";
        }
        return String.valueOf(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.searchbox.player.layer.LayerContainer */
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> T transform(LayerContainer layerContainer) {
        Intrinsics.checkNotNullParameter(layerContainer, "<this>");
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return layerContainer;
    }

    public static final String getTextWithSecond(int i, boolean z) {
        if (i < 0) {
            return "";
        }
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        if (i2 == 0 && !z) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    @JvmOverloads
    public static final float parseFloatSafe(String str, float f) {
        boolean z;
        Float f2;
        Float valueOf = Float.valueOf(f);
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                if (valueOf instanceof Integer) {
                    f2 = (Float) Integer.valueOf(Integer.parseInt(str));
                } else if (valueOf instanceof Double) {
                    f2 = (Float) Double.valueOf(Double.parseDouble(str));
                } else if (valueOf instanceof Long) {
                    f2 = (Float) Long.valueOf(Long.parseLong(str));
                } else {
                    valueOf = Float.valueOf(Float.parseFloat(str));
                }
                valueOf = f2;
            } catch (NumberFormatException e) {
                BdVideoLog.e("string to target value, catch exception:", e);
            }
        }
        return valueOf.floatValue();
    }

    public static final boolean handleVolumeKeyDown(Context context, KeyEvent event, Function0<Boolean> block) {
        AudioManager audioManager;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(block, "block");
        if (context == null) {
            return false;
        }
        try {
            if (!block.invoke().booleanValue()) {
                return false;
            }
            Object systemService = context.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                audioManager = (AudioManager) systemService;
            } else {
                audioManager = null;
            }
            if (audioManager == null) {
                return false;
            }
            if (event.getKeyCode() == 25) {
                audioManager.adjustStreamVolume(3, -1, 0);
            } else if (event.getKeyCode() != 24) {
                return false;
            } else {
                audioManager.adjustStreamVolume(3, 1, 0);
            }
            return true;
        } catch (Exception e) {
            BdVideoLog.d("handleVolumeKeyDown", e.getMessage());
            return false;
        }
    }

    public static final void removeViewFromParent(View view2) {
        ViewParent viewParent;
        ViewGroup viewGroup = null;
        if (view2 != null) {
            viewParent = view2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            try {
                viewGroup.removeView(view2);
            } catch (Exception e) {
                BdVideoLog.e("removeView(" + System.identityHashCode(view2) + ')', e);
            }
        }
    }

    public static final /* synthetic */ <T> T toValueSafe(String str, T t) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return t;
        }
        try {
        } catch (NumberFormatException e) {
            BdVideoLog.e("string to target value, catch exception:", e);
        }
        if (t instanceof Integer) {
            T t2 = (T) Integer.valueOf(Integer.parseInt(str));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t2;
        } else if (t instanceof Double) {
            T t3 = (T) Double.valueOf(Double.parseDouble(str));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t3;
        } else if (t instanceof Long) {
            T t4 = (T) Long.valueOf(Long.parseLong(str));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t4;
        } else if (t instanceof Float) {
            T t5 = (T) Float.valueOf(Float.parseFloat(str));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t5;
        } else {
            if (t instanceof Boolean) {
                T t6 = (T) Boolean.valueOf(Boolean.parseBoolean(str));
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return t6;
            }
            return t;
        }
    }
}
