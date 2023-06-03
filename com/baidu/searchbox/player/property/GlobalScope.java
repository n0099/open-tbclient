package com.baidu.searchbox.player.property;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/player/property/GlobalScope;", "Lcom/baidu/searchbox/player/property/Scope;", "()V", "name", "", "getName", "()Ljava/lang/String;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlobalScope implements Scope {
    public static final GlobalScope INSTANCE = new GlobalScope();

    @Override // com.baidu.searchbox.player.property.Scope
    public String getName() {
        return PlayerPropertyKit.SCOPE_GLOBAL;
    }
}
