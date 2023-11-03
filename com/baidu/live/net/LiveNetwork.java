package com.baidu.live.net;

import android.os.Handler;
import android.os.Looper;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.live.interfaces.service.NetworkAgentService;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.l80;
import com.baidu.tieba.m80;
import com.baidu.tieba.n80;
import com.baidu.tieba.o80;
import com.baidu.tieba.x80;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0003J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\u000bJ7\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0003J\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001a\u001a\u00020\u00012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001f\u001a\u00020\u00012&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\u0018J\u0015\u0010#\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010\u0018J\u0015\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&R\u001d\u0010,\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u00100¨\u00063"}, d2 = {"Lcom/baidu/live/net/LiveNetwork;", "", "cancel", "()V", "", "key", "", "localPath", "Lcom/baidu/live/net/LiveNetDownloadCallback;", WebChromeClient.KEY_ARG_CALLBACK, "download", "(Ljava/lang/Object;Ljava/lang/String;Lcom/baidu/live/net/LiveNetDownloadCallback;)V", "downloadSync", "ResponseDataT", "", "params", "Lcom/baidu/live/net/LiveNetCallback;", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/util/Map;Lcom/baidu/live/net/LiveNetCallback;)V", CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, "release", "", "timeout", "setConnectTimeout", "(I)V", "extra", "setExtra", "(Ljava/util/Map;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Downloads.Impl.RequestHeaders.URI_SEGMENT, "setHeaderData", "(Ljava/util/HashMap;)V", "setReadTimeout", "retryCount", "setRetryCount", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Ljava/lang/String;", "<init>", "Response", "lib-live-net_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveNetwork {
    public String a;
    public INetWork b;

    static {
        Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveNetwork.class), "handler", "getHandler()Landroid/os/Handler;"));
    }

    /* loaded from: classes3.dex */
    public static final class a<T> {
        public final NetResponse a;
        public final T b;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            NetResponse netResponse = this.a;
            int hashCode = (netResponse != null ? netResponse.hashCode() : 0) * 31;
            T t = this.b;
            return hashCode + (t != null ? t.hashCode() : 0);
        }

        public String toString() {
            return "Response(response=" + this.a + ", data=" + this.b + SmallTailInfo.EMOTION_SUFFIX;
        }

        public a(NetResponse netResponse, T t) {
            this.a = netResponse;
            this.b = t;
        }

        public final T a() {
            return this.b;
        }

        public final NetResponse b() {
            return this.a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ResponseDataT] */
    /* loaded from: classes3.dex */
    public static final class b<T, ResponseDataT> implements n80<a<ResponseDataT>> {
        public final /* synthetic */ Map b;
        public final /* synthetic */ l80 c;

        public b(Map map, l80 l80Var) {
            this.b = map;
            this.c = l80Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n80
        /* renamed from: b */
        public final a<ResponseDataT> a() {
            INetWork iNetWork = LiveNetwork.this.b;
            if (iNetWork == null) {
                Intrinsics.throwNpe();
            }
            NetResponse res = iNetWork.postSync(this.b);
            Object obj = null;
            try {
                l80 l80Var = this.c;
                if (l80Var != null) {
                    obj = l80Var.onParseResponseInBackground(res);
                }
            } catch (Exception e) {
                x80.e(e);
            }
            Intrinsics.checkExpressionValueIsNotNull(res, "res");
            return new a<>(res, obj);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [ResponseDataT] */
    /* loaded from: classes3.dex */
    public static final class c<T, ResponseDataT> implements o80<a<ResponseDataT>> {
        public final /* synthetic */ l80 a;

        public c(l80 l80Var) {
            this.a = l80Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.o80
        /* renamed from: a */
        public final void onReturnDataInUI(a<ResponseDataT> aVar) {
            NetResponse netResponse;
            l80 l80Var = this.a;
            if (l80Var != null) {
                ResponseDataT responsedatat = null;
                if (aVar != null) {
                    netResponse = aVar.b();
                } else {
                    netResponse = null;
                }
                if (aVar != null) {
                    responsedatat = aVar.a();
                }
                l80Var.onNetResponse(netResponse, responsedatat);
            }
        }
    }

    public LiveNetwork() {
        INetWork iNetWork;
        LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.live.net.LiveNetwork$handler$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        NetworkAgentService networkAgentService = (NetworkAgentService) ServiceManager.getService(NetworkAgentService.SERVICE_REFERENCE);
        if (networkAgentService != null) {
            iNetWork = networkAgentService.buildNetworkInstance();
        } else {
            iNetWork = null;
        }
        this.b = iNetWork;
    }

    public final void c(Map<String, ? extends Object> map) {
        INetWork iNetWork = this.b;
        if (iNetWork != null) {
            iNetWork.setExtra(map);
        }
    }

    public final void d(int i) {
        INetWork iNetWork = this.b;
        if (iNetWork != null) {
            iNetWork.setRetryCount(i);
        }
    }

    public final void e(String str) {
        this.a = str;
        INetWork iNetWork = this.b;
        if (iNetWork != null) {
            iNetWork.setUrl(str);
        }
    }

    public final <ResponseDataT> void b(Map<String, ? extends Object> map, l80<ResponseDataT> l80Var) {
        String str = this.a;
        if (str != null && (!StringsKt__StringsJVMKt.isBlank(str)) && this.b != null) {
            m80.a(new b(map, l80Var), new c(l80Var));
        }
    }
}
