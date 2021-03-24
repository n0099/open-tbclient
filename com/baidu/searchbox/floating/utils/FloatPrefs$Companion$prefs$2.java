package com.baidu.searchbox.floating.utils;

import com.baidu.searchbox.player.utils.SharedPrefsWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/player/utils/SharedPrefsWrapper;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class FloatPrefs$Companion$prefs$2 extends Lambda implements Function0<SharedPrefsWrapper> {
    public static final FloatPrefs$Companion$prefs$2 INSTANCE = new FloatPrefs$Companion$prefs$2();

    public FloatPrefs$Companion$prefs$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SharedPrefsWrapper invoke() {
        return new SharedPrefsWrapper(FloatPrefs.FILE_NAME);
    }
}
