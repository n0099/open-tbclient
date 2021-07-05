package a.a.a.a.u.a.b;

import a.a.a.a.v.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.sdk.FunAdSlot;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.FeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f1161b;

        public a(s sVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1161b = sVar;
            this.f1160a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                a.a.a.a.y.d.b("CSJNative onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1161b.f1017h.a(Integer.valueOf(i2));
                this.f1161b.b(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
        public void onFeedAdLoad(List<TTFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                a.a.a.a.y.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1161b.f1017h.b();
                    ArrayList arrayList = new ArrayList();
                    for (TTFeedAd tTFeedAd : list) {
                        this.f1161b.l.b(tTFeedAd, this.f1160a.getSid());
                        arrayList.add(tTFeedAd);
                    }
                    this.f1161b.a((List) arrayList);
                    return;
                }
                this.f1161b.f1017h.a("NoFill");
                a.a.a.a.y.d.b("onFeedAdLoad error: adList is null or empty", new Object[0]);
                onError(0, "NoFill");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(e.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((e.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // a.a.a.a.u.a.b.d
    public void a(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, funAdSlot) == null) {
            AdSlot.Builder supportDeepLink = new AdSlot.Builder().setCodeId(this.f1018i.f1345c).setSupportDeepLink(true);
            e.a aVar = this.f1018i;
            this.n.loadFeedAd(supportDeepLink.setImageAcceptedSize(aVar.f1349g, aVar.f1350h).setAdCount(a.a.a.a.a.a(funAdSlot.getAdCount(), 1, 3)).build(), new a(this, funAdSlot));
        }
    }
}
