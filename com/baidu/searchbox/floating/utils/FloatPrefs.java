package com.baidu.searchbox.floating.utils;

import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0003:\u0001\u0003B\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/floating/utils/FloatPrefs;", "<init>", "()V", "Companion", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FloatPrefs {
    public static final String FILE_NAME = "player_floating_sp";
    public static final String FLOATING_LOCATION_X = "floating_location_x";
    public static final String FLOATING_LOCATION_Y = "floating_location_y";
    public static final String FLOATING_SCALE_MODE = "floating_scale_mode";
    public static final Companion Companion = new Companion(null);
    public static final Lazy prefs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPrefsWrapper>() { // from class: com.baidu.searchbox.floating.utils.FloatPrefs$Companion$prefs$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPrefsWrapper invoke() {
            return new SharedPrefsWrapper(FloatPrefs.FILE_NAME);
        }
    });

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R<\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R<\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/floating/utils/FloatPrefs$Companion;", "", "FILE_NAME", "Ljava/lang/String;", "FLOATING_LOCATION_X", "FLOATING_LOCATION_Y", "FLOATING_SCALE_MODE", "Lkotlin/Pair;", "", "value", "getLocation", "()Lkotlin/Pair;", "setLocation", "(Lkotlin/Pair;)V", "location", "Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "prefs$delegate", "Lkotlin/Lazy;", "getPrefs", "()Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "prefs", "Lcom/baidu/searchbox/floating/config/ScaleMode;", "getScaleMode", "setScaleMode", "scaleMode", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        private final SharedPrefsWrapper getPrefs() {
            Lazy lazy = FloatPrefs.prefs$delegate;
            Companion companion = FloatPrefs.Companion;
            return (SharedPrefsWrapper) lazy.getValue();
        }

        public Companion() {
        }

        public final Pair<Integer, Integer> getLocation() {
            return new Pair<>(Integer.valueOf(FloatPrefs.Companion.getPrefs().getInt(FloatPrefs.FLOATING_LOCATION_X, 0)), Integer.valueOf(FloatPrefs.Companion.getPrefs().getInt(FloatPrefs.FLOATING_LOCATION_Y, 0)));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            FloatPrefs.Companion.getPrefs().putInt(FloatPrefs.FLOATING_SCALE_MODE, value.getSecond().ordinal());
        }

        public final Pair<ScaleMode, ScaleMode> getScaleMode() {
            int i = FloatPrefs.Companion.getPrefs().getInt(FloatPrefs.FLOATING_SCALE_MODE, ScaleMode.S.ordinal());
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
            SharedPrefsWrapper prefs = FloatPrefs.Companion.getPrefs();
            int i = 0;
            if (value.getFirst().intValue() < 0) {
                intValue = 0;
            } else {
                intValue = value.getFirst().intValue();
            }
            prefs.putInt(FloatPrefs.FLOATING_LOCATION_X, intValue);
            SharedPrefsWrapper prefs2 = FloatPrefs.Companion.getPrefs();
            if (value.getSecond().intValue() >= 0) {
                i = value.getSecond().intValue();
            }
            prefs2.putInt(FloatPrefs.FLOATING_LOCATION_Y, i);
        }
    }
}
