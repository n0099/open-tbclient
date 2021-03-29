package com.baidu.searchbox.websocket;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, "", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class WebSocketRequest$Companion$fromJSON$1$2 extends Lambda implements Function1<Integer, String> {
    public final /* synthetic */ Ref.ObjectRef $protocolsArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketRequest$Companion$fromJSON$1$2(Ref.ObjectRef objectRef) {
        super(1);
        this.$protocolsArray = objectRef;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return ((JSONArray) this.$protocolsArray.element).getString(i);
    }
}
