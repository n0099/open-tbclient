package com.baidu.live.framework.net;

import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.searchbox.live.interfaces.net.NetResponse;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ed0;
import com.baidu.tieba.gd0;
import com.baidu.tieba.id0;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJI\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0003J#\u0010\u0013\u001a\u00020\u00012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010$\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010&¨\u0006)"}, d2 = {"Lcom/baidu/live/framework/net/LiveNetwork;", "", "cancel", "()V", "ResponseDataT", "", "", "params", "Lcom/baidu/live/framework/net/LiveNetCallback;", WebChromeClient.KEY_ARG_CALLBACK, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "(Ljava/util/Map;Lcom/baidu/live/framework/net/LiveNetCallback;)V", "", "grFeedList", CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, "(Ljava/util/Map;Lcom/baidu/live/framework/net/LiveNetCallback;Ljava/util/List;)V", "release", "", "extra", "setExtra", "(Ljava/util/Map;)V", "", "retryCount", "setRetryCount", "(I)V", "url", "setUrl", "(Ljava/lang/String;)V", "Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "kotlin.jvm.PlatformType", "netImpl", "Lcom/baidu/searchbox/live/interfaces/net/INetWork;", "Ljava/lang/String;", "<init>", "Response", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveNetwork {
    public static final /* synthetic */ KProperty[] d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LiveNetwork.class), "mainHandler", "getMainHandler()Landroid/os/Handler;"))};
    public String b;
    public final Lazy a = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.baidu.live.framework.net.LiveNetwork$mainHandler$2
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    public INetWork c = gd0.a();

    public final Handler c() {
        Lazy lazy = this.a;
        KProperty kProperty = d[0];
        return (Handler) lazy.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public final /* synthetic */ Map b;
        public final /* synthetic */ ed0 c;
        public final /* synthetic */ List d;

        public b(Map map, ed0 ed0Var, List list) {
            LiveNetwork.this = r1;
            this.b = map;
            this.c = ed0Var;
            this.d = list;
        }

        /* loaded from: classes3.dex */
        public static final class a implements Runnable {
            public final /* synthetic */ a b;

            public a(a aVar) {
                b.this = r1;
                this.b = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NetResponse netResponse;
                ed0 ed0Var = b.this.c;
                if (ed0Var != null) {
                    a aVar = this.b;
                    Object obj = null;
                    if (aVar != null) {
                        netResponse = aVar.b();
                    } else {
                        netResponse = null;
                    }
                    a aVar2 = this.b;
                    if (aVar2 != null) {
                        obj = aVar2.a();
                    }
                    b bVar = b.this;
                    ed0Var.onNetResponse(netResponse, obj, bVar.b, bVar.d);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            INetWork iNetWork = LiveNetwork.this.c;
            if (iNetWork == null) {
                Intrinsics.throwNpe();
            }
            NetResponse res = iNetWork.postSync(this.b);
            Object obj = null;
            try {
                ed0 ed0Var = this.c;
                if (ed0Var != null) {
                    obj = ed0Var.onParseResponseInBackground(res);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intrinsics.checkExpressionValueIsNotNull(res, "res");
            LiveNetwork.this.c().post(new a(new a(res, obj)));
        }
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

    public final void f(Map<String, ? extends Object> map) {
        INetWork iNetWork = this.c;
        if (iNetWork != null) {
            iNetWork.setExtra(map);
        }
    }

    public final void g(String str) {
        this.b = str;
        INetWork iNetWork = this.c;
        if (iNetWork != null) {
            iNetWork.setUrl(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.live.framework.net.LiveNetwork */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(LiveNetwork liveNetwork, Map map, ed0 ed0Var, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        liveNetwork.d(map, ed0Var, list);
    }

    public final <ResponseDataT> void d(Map<String, String> map, ed0<ResponseDataT> ed0Var, List<String> list) {
        String str = this.b;
        if (str != null && (!StringsKt__StringsJVMKt.isBlank(str)) && this.c != null) {
            id0.b(new b(map, ed0Var, list), "live-feedpage-net", 0);
        }
    }
}
