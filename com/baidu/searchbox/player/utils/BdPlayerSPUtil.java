package com.baidu.searchbox.player.utils;

import android.content.SharedPreferences;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.searchbox.player.BDPlayerConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\tH\u0007\u001a\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\rH\u0007\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\tH\u0007\u001a\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\rH\u0007\u001a\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"THEME_PREF_NAME", "", ShareLoginStat.GetShareListStat.VALUE_FROM_SP, "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "getBoolean", "", "key", "defaultValue", "getInt", "", "getLong", "", "getString", "putBoolean", "", "value", "putInt", "putLong", "putString", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "BdPlayerSPUtil")
/* loaded from: classes4.dex */
public final class BdPlayerSPUtil {
    public static final String THEME_PREF_NAME = "com.baidu.searchbox.player.pref";
    public static final Lazy sp$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences>() { // from class: com.baidu.searchbox.player.utils.BdPlayerSPUtil$sp$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return BDPlayerConfig.getAppContext().getSharedPreferences("com.baidu.searchbox.player.pref", 0);
        }
    });

    public static final SharedPreferences getSp() {
        Object value = sp$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sp>(...)");
        return (SharedPreferences) value;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final boolean getBoolean(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getSp().getBoolean(key, z);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final int getInt(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getSp().getInt(key, i);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final long getLong(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getSp().getLong(key, j);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final String getString(String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String string = getSp().getString(key, defaultValue);
        if (string != null) {
            return string;
        }
        return defaultValue;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final void putBoolean(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        getSp().edit().putBoolean(key, z).apply();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final void putInt(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        getSp().edit().putInt(key, i).apply();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final void putLong(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        getSp().edit().putLong(key, j).apply();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "此接口已经已废弃", replaceWith = @ReplaceWith(expression = "请使用 SPData", imports = {}))
    public static final void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getSp().edit().putString(key, value).apply();
    }

    public static /* synthetic */ int getInt$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return getInt(str, i);
    }

    public static /* synthetic */ long getLong$default(String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLong(str, j);
    }
}
