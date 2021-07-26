package a.a.a.a.r.a.b;

import a.a.a.a.s.h;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.channel.model.csj.CSJDrawVideoNativeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements TTAdNative.DrawFeedAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1114a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f1115b;

        public a(h hVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1115b = hVar;
            this.f1114a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                a.a.a.a.v.d.a();
                if (list != null && !list.isEmpty()) {
                    this.f1115b.f1015h.b();
                    ArrayList arrayList = new ArrayList();
                    for (TTDrawFeedAd tTDrawFeedAd : list) {
                        this.f1115b.l.b(tTDrawFeedAd, this.f1114a.getSid());
                        arrayList.add(tTDrawFeedAd);
                    }
                    this.f1115b.a((List) arrayList);
                    return;
                }
                this.f1115b.f1015h.a("NoFill");
                a.a.a.a.v.d.b("onFeedAdLoad error: adList is null or empty", new Object[0]);
                onError(0, "NoFill");
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener, com.bytedance.sdk.openadsdk.c.b
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                a.a.a.a.v.d.b("CSJNative onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f1115b.f1015h.a(Integer.valueOf(i2));
                this.f1115b.b(i2, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(h.a aVar) {
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
                super((h.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // a.a.a.a.r.a.b.d
    public void a(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, funAdSlot) == null) {
            this.n.loadDrawFeedAd(new AdSlot.Builder().setCodeId(this.f1016i.f1361c).setAdCount(a.a.a.a.q.a(funAdSlot.getAdCount(), 1, 3)).build(), new a(this, funAdSlot));
        }
    }

    @Override // a.a.a.a.r.a.b.d
    public boolean a(Activity activity, ViewGroup viewGroup, String str, TTNativeAd tTNativeAd) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, tTNativeAd)) == null) {
            CSJDrawVideoNativeView cSJDrawVideoNativeView = (CSJDrawVideoNativeView) LayoutInflater.from(activity).inflate(R.layout.csj_ad_draw_video_native, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(cSJDrawVideoNativeView);
            tTNativeAd.setActivityForDownloadApp(activity);
            cSJDrawVideoNativeView.a(activity, tTNativeAd, new i(this, tTNativeAd, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // a.a.a.a.r.a.b.d, a.a.a.a.b
    public /* bridge */ /* synthetic */ boolean a(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        a(activity, viewGroup, str, (TTNativeAd) obj);
        return true;
    }
}
