package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.model.AuthStrategyModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"parseAuthStrategy", "Lcom/baidu/searchbox/player/model/AuthStrategyModel;", "auth", "", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "AuthParser")
/* loaded from: classes4.dex */
public final class AuthParser {
    public static final AuthStrategyModel parseAuthStrategy(String str) {
        int i;
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
        if (split$default.size() < 4) {
            return null;
        }
        int i4 = 0;
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(0));
        if (intOrNull != null) {
            i = intOrNull.intValue();
        } else {
            i = 0;
        }
        Integer intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(1));
        if (intOrNull2 != null) {
            i2 = intOrNull2.intValue();
        } else {
            i2 = 0;
        }
        Integer intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(2));
        if (intOrNull3 != null) {
            i3 = intOrNull3.intValue();
        } else {
            i3 = 0;
        }
        Integer intOrNull4 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(3));
        if (intOrNull4 != null) {
            i4 = intOrNull4.intValue();
        }
        return new AuthStrategyModel(i, i2, i3, i4);
    }
}
