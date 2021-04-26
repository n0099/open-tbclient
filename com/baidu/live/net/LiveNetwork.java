package com.baidu.live.net;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000bJ7\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0003J\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001f\u001a\u00020\u00012&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\u0018J\u0015\u0010#\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010\u0018J\u0015\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00100¨\u00063"}, d2 = {"Lcom/baidu/live/net/LiveNetwork;", "", QueryResponse.Options.CANCEL, "()V", "", "key", "", "localPath", "Lcom/baidu/live/net/LiveNetDownloadCallback;", "callback", "download", "(Ljava/lang/Object;Ljava/lang/String;Lcom/baidu/live/net/LiveNetDownloadCallback;)V", "downloadSync", "ResponseDataT", "", "params", "Lcom/baidu/live/net/LiveNetCallback;", "get", "(Ljava/util/Map;Lcom/baidu/live/net/LiveNetCallback;)V", "post", "release", "", "timeout", "setConnectTimeout", "(I)V", "extra", "setExtra", "(Ljava/util/Map;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "setHeaderData", "(Ljava/util/HashMap;)V", "setReadTimeout", "retryCount", "setRetryCount", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Ljava/lang/String;", "<init>", "Response", "lib-live-net_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveNetwork {

    /* renamed from: a  reason: collision with root package name */
    public String f6662a;

    /* renamed from: b  reason: collision with root package name */
    public INetWork f6663b;

    /* loaded from: classes2.dex */
    public static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final NetResponse f6664a;

        /* renamed from: b  reason: collision with root package name */
        public final T f6665b;

        public a(NetResponse netResponse, T t) {
            this.f6664a = netResponse;
            this.f6665b = t;
        }

        public final T a() {
            return this.f6665b;
        }

        public final NetResponse b() {
            return this.f6664a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.f6664a, aVar.f6664a) && Intrinsics.areEqual(this.f6665b, aVar.f6665b);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            NetResponse netResponse = this.f6664a;
            int hashCode = (netResponse != null ? netResponse.hashCode() : 0) * 31;
            T t = this.f6665b;
            return hashCode + (t != null ? t.hashCode() : 0);
        }

        public String toString() {
            return "Response(response=" + this.f6664a + ", data=" + this.f6665b + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements d.a.t.d.b<a<ResponseDataT>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f6667b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.t.b.a f6668c;

        public b(Map map, d.a.t.b.a aVar) {
            this.f6667b = map;
            this.f6668c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.t.d.b
        /* renamed from: b */
        public final a<ResponseDataT> a() {
            INetWork iNetWork = LiveNetwork.this.f6663b;
            if (iNetWork == null) {
                Intrinsics.throwNpe();
            }
            NetResponse res = iNetWork.postSync(this.f6667b);
            Object obj = null;
            try {
                d.a.t.b.a aVar = this.f6668c;
                if (aVar != null) {
                    obj = aVar.onParseResponseInBackground(res);
                }
            } catch (Exception e2) {
                d.a.t.e.a.e(e2);
            }
            Intrinsics.checkExpressionValueIsNotNull(res, "res");
            return new a<>(res, obj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<T> implements d.a.t.d.c<a<ResponseDataT>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.t.b.a f6669a;

        public c(d.a.t.b.a aVar) {
            this.f6669a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: d.a.t.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.a.t.d.c
        /* renamed from: a */
        public final void onReturnDataInUI(a<ResponseDataT> aVar) {
            d.a.t.b.a aVar2 = this.f6669a;
            if (aVar2 != 0) {
                aVar2.onNetResponse(aVar != 0 ? aVar.b() : null, aVar != 0 ? aVar.a() : null);
            }
        }
    }

    static {
        Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveNetwork.class), "handler", "getHandler()Landroid/os/Handler;"));
    }

    public LiveNetwork() {
        LazyKt__LazyJVMKt.lazy(LiveNetwork$handler$2.INSTANCE);
        NetworkAgentService networkAgentService = (NetworkAgentService) ServiceManager.getService(NetworkAgentService.SERVICE_REFERENCE);
        this.f6663b = networkAgentService != null ? networkAgentService.buildNetworkInstance() : null;
    }

    public final <ResponseDataT> void b(Map<String, ? extends Object> map, d.a.t.b.a<ResponseDataT> aVar) {
        String str = this.f6662a;
        if (str == null || !(!StringsKt__StringsJVMKt.isBlank(str)) || this.f6663b == null) {
            return;
        }
        d.a.t.d.a.a(new b(map, aVar), new c(aVar));
    }

    public final void c(Map<String, ? extends Object> map) {
        INetWork iNetWork = this.f6663b;
        if (iNetWork != null) {
            iNetWork.setExtra(map);
        }
    }

    public final void d(int i2) {
        INetWork iNetWork = this.f6663b;
        if (iNetWork != null) {
            iNetWork.setRetryCount(i2);
        }
    }

    public final void e(String str) {
        this.f6662a = str;
        INetWork iNetWork = this.f6663b;
        if (iNetWork != null) {
            iNetWork.setUrl(str);
        }
    }
}
