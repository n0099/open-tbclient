package com.baidu.searchbox.live.interfaces.service.bd;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u001f\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/YanzhiTabGuideService;", "Lkotlin/Any;", "", "var1", "", "addTab", "(Ljava/util/Map;)V", "", "", "isAddedTab", "(Ljava/lang/String;)Z", "var2", "moveToTab", "(Ljava/lang/String;Ljava/util/Map;)V", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public interface YanzhiTabGuideService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void addTab(Map<?, ?> map);

    boolean isAddedTab(String str);

    void moveToTab(String str, Map<?, ?> map);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/YanzhiTabGuideService$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.BD.YANHI_TAB_GUIDE);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
