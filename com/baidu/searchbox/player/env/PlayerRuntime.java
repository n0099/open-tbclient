package com.baidu.searchbox.player.env;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/player/env/PlayerRuntime;", "", "()V", "keyGenerator", "Lcom/baidu/searchbox/player/env/IKeyGenerator;", "setKeyGenerator", "", "generator", "Lcom/baidu/searchbox/player/env/KeyGenerator;", "toPlayerKey", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerRuntime {
    public static final PlayerRuntime INSTANCE = new PlayerRuntime();
    public static IKeyGenerator keyGenerator = new KeyGenerator();

    @JvmStatic
    public static final String toPlayerKey(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        return keyGenerator.toKey(str);
    }

    public final void setKeyGenerator(KeyGenerator generator) {
        Intrinsics.checkNotNullParameter(generator, "generator");
        keyGenerator = generator;
    }
}
