package com.baidu.searchbox.floating.utils;

import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import kotlin.e;
import kotlin.jvm.a.a;
import kotlin.jvm.internal.Lambda;
@e
/* loaded from: classes16.dex */
final class FloatPrefs$Companion$prefs$2 extends Lambda implements a<SharedPrefsWrapper> {
    public static final FloatPrefs$Companion$prefs$2 INSTANCE = new FloatPrefs$Companion$prefs$2();

    FloatPrefs$Companion$prefs$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.a.a
    public final SharedPrefsWrapper invoke() {
        return new SharedPrefsWrapper("player_floating_sp");
    }
}
