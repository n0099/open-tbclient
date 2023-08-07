package com.baidu.searchbox.live.host2live.publish;

import android.app.Activity;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterInterface;", "Lkotlin/Any;", "Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterInterfaceCallBack;", "loadCallBack", "", "checkLiveMasterPluginAndLoad", "(Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterInterfaceCallBack;)V", "Landroid/app/Activity;", "activity", "Lcom/baidu/searchbox/live/host2live/publish/ILive2PublishHostInterface;", "live2LivePublish", "Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "getILiveMasterActInterfaceProxy", "(Landroid/app/Activity;Lcom/baidu/searchbox/live/host2live/publish/ILive2PublishHostInterface;)Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterActInterface;", "", "isLiveMasterPluginLoaded", "()Z", "isLiveMasterSupportPublish", "releaseLiveMaster", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ILiveMasterInterface {
    public static final Companion Companion = Companion.$$INSTANCE;

    void checkLiveMasterPluginAndLoad(ILiveMasterInterfaceCallBack iLiveMasterInterfaceCallBack);

    ILiveMasterActInterface getILiveMasterActInterfaceProxy(Activity activity, ILive2PublishHostInterface iLive2PublishHostInterface);

    boolean isLiveMasterPluginLoaded();

    boolean isLiveMasterSupportPublish();

    boolean releaseLiveMaster();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/host2live/publish/ILiveMasterInterface$Companion;", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "<init>", "()V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_TO_PUBLISH);

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
