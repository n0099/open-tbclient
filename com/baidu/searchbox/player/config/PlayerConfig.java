package com.baidu.searchbox.player.config;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.property.GlobalScope;
import com.baidu.searchbox.player.property.Property;
import com.baidu.searchbox.player.property.Scope;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ+\u0010\r\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u0002H\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/player/config/PlayerConfig;", "", "()V", "extBundle", "Lcom/baidu/searchbox/player/model/StringArrayBundle;", "getExtBundle", "()Lcom/baidu/searchbox/player/model/StringArrayBundle;", "extBundle$delegate", "Lkotlin/Lazy;", "getPropertyConfig", "Lcom/baidu/searchbox/player/property/Property;", "key", "", "setPropertyConfig", ExifInterface.GPS_DIRECTION_TRUE, "state", "scope", "Lcom/baidu/searchbox/player/property/Scope;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/baidu/searchbox/player/property/Scope;)Lcom/baidu/searchbox/player/config/PlayerConfig;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerConfig {
    public final Lazy extBundle$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StringArrayBundle>() { // from class: com.baidu.searchbox.player.config.PlayerConfig$extBundle$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StringArrayBundle invoke() {
            return new StringArrayBundle(0, 1, null);
        }
    });

    public final StringArrayBundle getExtBundle() {
        return (StringArrayBundle) this.extBundle$delegate.getValue();
    }

    public static /* synthetic */ PlayerConfig setPropertyConfig$default(PlayerConfig playerConfig, String str, Object obj, Scope scope, int i, Object obj2) {
        if ((i & 4) != 0) {
            scope = GlobalScope.INSTANCE;
        }
        return playerConfig.setPropertyConfig(str, obj, scope);
    }

    public final Property<?> getPropertyConfig(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = getExtBundle().get((Object) key);
        if (obj instanceof Property) {
            return (Property) obj;
        }
        return null;
    }

    public final <T> PlayerConfig setPropertyConfig(String key, T t, Scope scope) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scope, "scope");
        getExtBundle().put(key, new Property(t, scope));
        return this;
    }
}
