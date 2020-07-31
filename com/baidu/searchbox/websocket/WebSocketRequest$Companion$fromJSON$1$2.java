package com.baidu.searchbox.websocket;

import kotlin.h;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
@h
/* loaded from: classes7.dex */
final class WebSocketRequest$Companion$fromJSON$1$2 extends Lambda implements b<Integer, String> {
    final /* synthetic */ Ref.ObjectRef $protocolsArray;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketRequest$Companion$fromJSON$1$2(Ref.ObjectRef objectRef) {
        super(1);
        this.$protocolsArray = objectRef;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.a.b
    public /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return ((JSONArray) this.$protocolsArray.element).getString(i);
    }
}
