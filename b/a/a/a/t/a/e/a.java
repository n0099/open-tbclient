package b.a.a.a.t.a.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.win.opensdk.PBDrawVideo;
import com.win.opensdk.PBDrawVideoListener;
import com.win.opensdk.PBError;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends b.a.a.a.c<PBDrawVideo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<PBDrawVideo, String> o;

    /* renamed from: b.a.a.a.t.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0006a implements PBDrawVideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1302a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1303b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBDrawVideo f1304c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1305d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1306e;

        public C0006a(a aVar, PBDrawVideo pBDrawVideo, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pBDrawVideo, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1306e = aVar;
            this.f1304c = pBDrawVideo;
            this.f1305d = funAdSlot;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.a.a.x.d.a();
                this.f1306e.f1057h.f(this.f1303b);
                this.f1303b = true;
                this.f1306e.r();
            }
        }

        @Override // com.win.opensdk.PBDrawVideoListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.a.a.x.d.a();
                this.f1306e.f1057h.k(this.f1302a);
                this.f1302a = true;
                a aVar = this.f1306e;
                PBDrawVideo pBDrawVideo = this.f1304c;
                aVar.i(pBDrawVideo, aVar.o.remove(pBDrawVideo));
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                b.a.a.a.x.d.f("onError code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1306e.f1057h.e(Integer.valueOf(pBError.getCode()));
                this.f1306e.n(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.a.a.x.d.a();
                this.f1306e.f1057h.h();
                this.f1306e.m.c(this.f1304c, this.f1305d.getSid());
                a aVar = this.f1306e;
                aVar.h(this.f1304c);
                aVar.u();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(h.a aVar) {
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
        this.o = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, PBDrawVideo pBDrawVideo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBDrawVideo)) == null) {
            PBDrawVideo pBDrawVideo2 = pBDrawVideo;
            this.f1057h.p();
            this.o.put(pBDrawVideo2, str);
            View drawVideoView = pBDrawVideo2.getDrawVideoView();
            if (drawVideoView.getParent() != null) {
                ((ViewGroup) drawVideoView.getParent()).removeView(drawVideoView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(drawVideoView);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            PBDrawVideo pBDrawVideo = new PBDrawVideo(context.getApplicationContext(), this.f1058i.f1448c);
            pBDrawVideo.setDrawVideoListener(new C0006a(this, pBDrawVideo, funAdSlot));
            this.f1057h.d(funAdSlot, this.f1058i);
            pBDrawVideo.load();
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(PBDrawVideo pBDrawVideo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBDrawVideo) == null) {
            PBDrawVideo pBDrawVideo2 = pBDrawVideo;
            this.o.remove(pBDrawVideo2);
            if (pBDrawVideo2 != null) {
                pBDrawVideo2.destroy();
            }
        }
    }
}
