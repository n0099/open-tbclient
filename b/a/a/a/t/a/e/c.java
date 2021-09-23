package b.a.a.a.t.a.e;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.R;
import com.fun.ad.sdk.channel.model.jy.JYNativeAdView;
import com.win.opensdk.PBError;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c extends b.a.a.a.c<PBNative> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<PBNative, b> o;

    /* loaded from: classes.dex */
    public class a implements PBNativeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1311a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1312b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBNative f1313c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f1314d;

        public a(c cVar, PBNative pBNative) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, pBNative};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1314d = cVar;
            this.f1313c = pBNative;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.a.a.x.d.a();
                this.f1314d.f1057h.f(this.f1312b);
                this.f1312b = true;
                this.f1314d.r();
                synchronized (this.f1314d.o) {
                    b bVar = this.f1314d.o.get(this.f1313c);
                    if (bVar != null) {
                        bVar.f1317c.onAdClicked(bVar.f1315a, this.f1314d.f1058i.l.f1445c, this.f1314d.f1058i.f1448c);
                    }
                }
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.a.a.x.d.a();
                this.f1314d.f1057h.k(this.f1311a);
                this.f1311a = true;
                this.f1314d.i(null, null);
                synchronized (this.f1314d.o) {
                    b bVar = this.f1314d.o.get(this.f1313c);
                    if (bVar != null) {
                        bVar.f1317c.onAdShow(bVar.f1315a, this.f1314d.f1058i.l.f1445c, this.f1314d.f1058i.f1448c);
                    }
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                b.a.a.a.x.d.f("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1314d.f1057h.e(Integer.valueOf(pBError.getCode()));
                this.f1314d.n(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.a.a.x.d.a();
                this.f1314d.f1057h.h();
                c cVar = this.f1314d;
                cVar.h(this.f1313c);
                cVar.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1315a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1316b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdInteractionListener f1317c;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1315a = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h.a aVar) {
        super(aVar, true, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public FunNativeAd f(Context context, String str, PBNative pBNative) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, pBNative)) == null) ? new b.a.a.a.t.b.c.a(pBNative, str, this.f1058i, this) : (FunNativeAd) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, PBNative pBNative) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, pBNative)) == null) {
            PBNative pBNative2 = pBNative;
            this.f1057h.p();
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(jYNativeAdView);
            jYNativeAdView.f70288a.setText(pBNative2.getBody());
            jYNativeAdView.f70290c.setText(pBNative2.getHeadline());
            Context context = jYNativeAdView.getContext();
            String icon = pBNative2.getIcon();
            ImageView imageView = jYNativeAdView.f70291d;
            if (context == null) {
                b.a.a.a.x.d.f("GlideHelper: context is null when load: " + icon, new Object[0]);
            } else if (context instanceof Activity) {
                Activity activity2 = (Activity) context;
                if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                    b.a.a.a.x.d.f("GlideHelper: activity is destroyed when load: " + icon, new Object[0]);
                } else {
                    Glide.with(activity2).load(icon).into(imageView);
                }
            } else {
                Glide.with(context).load(icon).into(imageView);
            }
            jYNativeAdView.f70292e.setText(pBNative2.getCallToAction());
            jYNativeAdView.f70293f = (pBNative2.getMediaViewWidth() * 1.0f) / (pBNative2.getMediaViewHeight() * 1.0f);
            pBNative2.registerViewForInteraction(jYNativeAdView, jYNativeAdView.f70289b);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean l(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, PBNative pBNative) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, funNativeAdInflater, pBNative)) == null) {
            PBNative pBNative2 = pBNative;
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new b.a.a.a.t.b.c.a(pBNative2, str, this.f1058i, this));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            pBNative2.registerViewForInteraction(adContainer, null, clickViews);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            PBNative pBNative = new PBNative(context.getApplicationContext(), this.f1058i.f1448c);
            pBNative.setNativeListener(new a(this, pBNative));
            this.f1057h.d(funAdSlot, this.f1058i);
            pBNative.load();
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(PBNative pBNative) {
        PBNative pBNative2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pBNative) == null) || (pBNative2 = pBNative) == null) {
            return;
        }
        pBNative2.destroy();
        synchronized (this.o) {
            this.o.remove(pBNative2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean q(PBNative pBNative) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pBNative)) == null) {
            PBNative pBNative2 = pBNative;
            return pBNative2 != null && pBNative2.isReady();
        }
        return invokeL.booleanValue;
    }
}
