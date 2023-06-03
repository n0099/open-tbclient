package com.baidu.searchbox.floating.utils;

import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/floating/utils/FloatPrefs;", "", "()V", "Companion", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatPrefs {
    public static final String FILE_NAME = "player_floating_sp";
    public static final String FLOATING_LOCATION_X = "floating_location_x";
    public static final String FLOATING_LOCATION_Y = "floating_location_y";
    public static final String FLOATING_SCALE_HEIGHT = "floating_scale_height";
    public static final String FLOATING_SCALE_MODE = "floating_scale_mode";
    public static final String FLOATING_SCALE_WIDTH = "floating_scale_width";
    public static final Companion Companion = new Companion(null);
    public static final Lazy<SharedPrefsWrapper> prefs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPrefsWrapper>() { // from class: com.baidu.searchbox.floating.utils.FloatPrefs$Companion$prefs$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPrefsWrapper invoke() {
            return new SharedPrefsWrapper(FloatPrefs.FILE_NAME);
        }
    });

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R<\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R<\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R<\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/floating/utils/FloatPrefs$Companion;", "", "()V", "FILE_NAME", "", "FLOATING_LOCATION_X", "FLOATING_LOCATION_Y", "FLOATING_SCALE_HEIGHT", "FLOATING_SCALE_MODE", "FLOATING_SCALE_WIDTH", "value", "Lkotlin/Pair;", "", "location", GameAssistConstKt.METHOD_GET_LOCATION, "()Lkotlin/Pair;", "setLocation", "(Lkotlin/Pair;)V", "prefs", "Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "getPrefs", "()Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "prefs$delegate", "Lkotlin/Lazy;", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "scaleMode", "getScaleMode", "setScaleMode", "size", "getSize", "setSize", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        private final SharedPrefsWrapper getPrefs() {
            return (SharedPrefsWrapper) FloatPrefs.prefs$delegate.getValue();
        }

        public final Pair<Integer, Integer> getLocation() {
            return new Pair<>(Integer.valueOf(getPrefs().getInt(FloatPrefs.FLOATING_LOCATION_X, 0)), Integer.valueOf(getPrefs().getInt(FloatPrefs.FLOATING_LOCATION_Y, 0)));
        }

        public final Pair<Integer, Integer> getSize() {
            return new Pair<>(Integer.valueOf(getPrefs().getInt(FloatPrefs.FLOATING_SCALE_WIDTH, 0)), Integer.valueOf(getPrefs().getInt(FloatPrefs.FLOATING_SCALE_HEIGHT, 0)));
        }

        public final Pair<ScaleMode, ScaleMode> getScaleMode() {
            int i = getPrefs().getInt(FloatPrefs.FLOATING_SCALE_MODE, ScaleMode.S.ordinal());
            if (i == ScaleMode.S.ordinal()) {
                ScaleMode scaleMode = ScaleMode.S;
                return new Pair<>(scaleMode, scaleMode);
            } else if (i == ScaleMode.M.ordinal()) {
                return new Pair<>(ScaleMode.S, ScaleMode.M);
            } else {
                if (i == ScaleMode.L.ordinal()) {
                    return new Pair<>(ScaleMode.M, ScaleMode.L);
                }
                ScaleMode scaleMode2 = ScaleMode.S;
                return new Pair<>(scaleMode2, scaleMode2);
            }
        }

        public final void setLocation(Pair<Integer, Integer> value) {
            int intValue;
            Intrinsics.checkNotNullParameter(value, "value");
            SharedPrefsWrapper prefs = getPrefs();
            int i = 0;
            if (value.getFirst().intValue() < 0) {
                intValue = 0;
            } else {
                intValue = value.getFirst().intValue();
            }
            prefs.putInt(FloatPrefs.FLOATING_LOCATION_X, intValue);
            SharedPrefsWrapper prefs2 = getPrefs();
            if (value.getSecond().intValue() >= 0) {
                i = value.getSecond().intValue();
            }
            prefs2.putInt(FloatPrefs.FLOATING_LOCATION_Y, i);
        }

        public final void setSize(Pair<Integer, Integer> value) {
            int intValue;
            Intrinsics.checkNotNullParameter(value, "value");
            SharedPrefsWrapper prefs = getPrefs();
            int i = 0;
            if (value.getFirst().intValue() < 0) {
                intValue = 0;
            } else {
                intValue = value.getFirst().intValue();
            }
            prefs.putInt(FloatPrefs.FLOATING_SCALE_WIDTH, intValue);
            SharedPrefsWrapper prefs2 = getPrefs();
            if (value.getSecond().intValue() >= 0) {
                i = value.getSecond().intValue();
            }
            prefs2.putInt(FloatPrefs.FLOATING_SCALE_HEIGHT, i);
        }

        public final void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            getPrefs().putInt(FloatPrefs.FLOATING_SCALE_MODE, value.getSecond().ordinal());
        }
    }
}
