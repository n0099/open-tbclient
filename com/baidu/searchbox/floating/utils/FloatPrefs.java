package com.baidu.searchbox.floating.utils;

import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import kotlin.Pair;
import kotlin.c;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.s;
import kotlin.reflect.j;
@e
/* loaded from: classes16.dex */
public final class FloatPrefs {
    private static final String FILE_NAME = "player_floating_sp";
    private static final String FLOATING_LOCATION_X = "floating_location_x";
    private static final String FLOATING_LOCATION_Y = "floating_location_y";
    private static final String FLOATING_SCALE_MODE = "floating_scale_mode";
    public static final Companion Companion = new Companion(null);
    private static final c prefs$delegate = d.b(FloatPrefs$Companion$prefs$2.INSTANCE);

    @e
    /* loaded from: classes16.dex */
    public static final class Companion {
        static final /* synthetic */ j[] $$delegatedProperties = {s.a(new PropertyReference1Impl(s.M(Companion.class), "prefs", "getPrefs()Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;"))};

        private final SharedPrefsWrapper getPrefs() {
            c cVar = FloatPrefs.prefs$delegate;
            j jVar = $$delegatedProperties[0];
            return (SharedPrefsWrapper) cVar.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final Pair<Integer, Integer> getLocation() {
            return new Pair<>(Integer.valueOf(FloatPrefs.Companion.getPrefs().getInt(FloatPrefs.FLOATING_LOCATION_X, 0)), Integer.valueOf(FloatPrefs.Companion.getPrefs().getInt(FloatPrefs.FLOATING_LOCATION_Y, 0)));
        }

        public final void setLocation(Pair<Integer, Integer> pair) {
            p.o(pair, "value");
            FloatPrefs.Companion.getPrefs().putInt(FloatPrefs.FLOATING_LOCATION_X, pair.getFirst().intValue() < 0 ? 0 : pair.getFirst().intValue());
            FloatPrefs.Companion.getPrefs().putInt(FloatPrefs.FLOATING_LOCATION_Y, pair.getSecond().intValue() >= 0 ? pair.getSecond().intValue() : 0);
        }

        public final Pair<ScaleMode, ScaleMode> getScaleMode() {
            int i = FloatPrefs.Companion.getPrefs().getInt(FloatPrefs.FLOATING_SCALE_MODE, ScaleMode.S.ordinal());
            return i == ScaleMode.S.ordinal() ? new Pair<>(ScaleMode.S, ScaleMode.S) : i == ScaleMode.M.ordinal() ? new Pair<>(ScaleMode.S, ScaleMode.M) : i == ScaleMode.L.ordinal() ? new Pair<>(ScaleMode.M, ScaleMode.L) : new Pair<>(ScaleMode.S, ScaleMode.S);
        }

        public final void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair) {
            p.o(pair, "value");
            FloatPrefs.Companion.getPrefs().putInt(FloatPrefs.FLOATING_SCALE_MODE, pair.getSecond().ordinal());
        }
    }
}
