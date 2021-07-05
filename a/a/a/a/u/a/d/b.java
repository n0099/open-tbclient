package a.a.a.a.u.a.d;

import a.a.a.a.v.e;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class b extends a.a.a.a.c<PBNative> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<PBNative, C0002b> n;

    /* loaded from: classes.dex */
    public class a implements PBNativeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1230a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1231b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBNative f1232c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f1233d;

        public a(b bVar, PBNative pBNative) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pBNative};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1233d = bVar;
            this.f1232c = pBNative;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.y.d.a();
                this.f1233d.f1017h.a(this.f1231b);
                this.f1231b = true;
                this.f1233d.e();
                synchronized (this.f1233d.n) {
                    C0002b c0002b = this.f1233d.n.get(this.f1232c);
                    if (c0002b != null) {
                        c0002b.f1236c.onAdClicked(c0002b.f1234a);
                    }
                }
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.y.d.a();
                this.f1233d.f1017h.b(this.f1230a);
                this.f1230a = true;
                this.f1233d.a((b) null, (String) null);
                synchronized (this.f1233d.n) {
                    C0002b c0002b = this.f1233d.n.get(this.f1232c);
                    if (c0002b != null) {
                        c0002b.f1236c.onAdShow(c0002b.f1234a);
                    }
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                a.a.a.a.y.d.b("onFail code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1233d.f1017h.a(Integer.valueOf(pBError.getCode()));
                this.f1233d.b(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.y.d.a();
                this.f1233d.f1017h.b();
                b bVar = this.f1233d;
                bVar.a((b) this.f1232c);
                bVar.h();
            }
        }
    }

    /* renamed from: a.a.a.a.u.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0002b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f1234a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1235b;

        /* renamed from: c  reason: collision with root package name */
        public FunAdInteractionListener f1236c;

        public C0002b(String str) {
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
            this.f1234a = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e.a aVar) {
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
                super((e.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public FunNativeAd a(Context context, String str, PBNative pBNative) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, pBNative)) == null) ? new a.a.a.a.u.b.c.a(pBNative, str, this) : (FunNativeAd) invokeLLL.objValue;
    }

    @Override // a.a.a.a.c
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            PBNative pBNative = new PBNative(context.getApplicationContext(), this.f1018i.f1345c);
            pBNative.setNativeListener(new a(this, pBNative));
            this.f1017h.a(funAdSlot, this.f1018i);
            pBNative.load();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public void b(PBNative pBNative) {
        PBNative pBNative2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pBNative) == null) || (pBNative2 = pBNative) == null) {
            return;
        }
        pBNative2.destroy();
        synchronized (this.n) {
            this.n.remove(pBNative2);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean c(PBNative pBNative) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pBNative)) == null) {
            PBNative pBNative2 = pBNative;
            return pBNative2 != null && pBNative2.isReady();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBNative pBNative) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, pBNative)) == null) {
            PBNative pBNative2 = pBNative;
            this.f1017h.g();
            JYNativeAdView jYNativeAdView = (JYNativeAdView) LayoutInflater.from(activity).inflate(R.layout.jy_ad_native_view, viewGroup, false);
            viewGroup.removeAllViews();
            viewGroup.addView(jYNativeAdView);
            jYNativeAdView.f32601a.setText(pBNative2.getBody());
            jYNativeAdView.f32603c.setText(pBNative2.getHeadline());
            Context context = jYNativeAdView.getContext();
            String icon = pBNative2.getIcon();
            ImageView imageView = jYNativeAdView.f32604d;
            if (context == null) {
                a.a.a.a.y.d.b("GlideHelper: context is null when load: " + icon, new Object[0]);
            } else if (context instanceof Activity) {
                Activity activity2 = (Activity) context;
                if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                    a.a.a.a.y.d.b("GlideHelper: activity is destroyed when load: " + icon, new Object[0]);
                } else {
                    Glide.with(activity2).load(icon).into(imageView);
                }
            } else {
                Glide.with(context).load(icon).into(imageView);
            }
            jYNativeAdView.f32605e.setText(pBNative2.getCallToAction());
            jYNativeAdView.f32606f = (pBNative2.getMediaViewWidth() * 1.0f) / (pBNative2.getMediaViewHeight() * 1.0f);
            pBNative2.registerViewForInteraction(jYNativeAdView, jYNativeAdView.f32602b);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, java.lang.String, com.fun.ad.sdk.FunNativeAdInflater, java.lang.Object] */
    @Override // a.a.a.a.c
    public boolean a(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, PBNative pBNative) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, str, funNativeAdInflater, pBNative)) == null) {
            PBNative pBNative2 = pBNative;
            ViewGroup adContainer = funNativeAdInflater.getAdContainer(new a.a.a.a.u.b.c.a(pBNative2, str, this));
            List<View> clickViews = funNativeAdInflater.getClickViews();
            if (clickViews == null) {
                clickViews = new ArrayList<>();
            }
            pBNative2.registerViewForInteraction(adContainer, null, clickViews);
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
