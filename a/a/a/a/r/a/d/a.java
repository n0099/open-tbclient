package a.a.a.a.r.a.d;

import a.a.a.a.s.h;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
public class a extends a.a.a.a.b<PBDrawVideo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<PBDrawVideo, String> n;

    /* renamed from: a.a.a.a.r.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0002a implements PBDrawVideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1223a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1224b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PBDrawVideo f1225c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1226d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1227e;

        public C0002a(a aVar, PBDrawVideo pBDrawVideo, FunAdSlot funAdSlot) {
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
            this.f1227e = aVar;
            this.f1225c = pBDrawVideo;
            this.f1226d = funAdSlot;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.a.a.a.v.d.a();
                this.f1227e.f1015h.a(this.f1224b);
                this.f1224b = true;
                this.f1227e.e();
            }
        }

        @Override // com.win.opensdk.PBDrawVideoListener
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a.a.a.a.v.d.a();
                this.f1227e.f1015h.b(this.f1223a);
                this.f1223a = true;
                a aVar = this.f1227e;
                PBDrawVideo pBDrawVideo = this.f1225c;
                aVar.a((a) pBDrawVideo, aVar.n.remove(pBDrawVideo));
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                a.a.a.a.v.d.b("onError code: " + pBError.getCode() + ", message: " + pBError.getMsg(), new Object[0]);
                this.f1227e.f1015h.a(Integer.valueOf(pBError.getCode()));
                this.f1227e.b(pBError.getCode(), pBError.getMsg());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                a.a.a.a.v.d.a();
                this.f1227e.f1015h.b();
                this.f1227e.l.b(this.f1225c, this.f1226d.getSid());
                a aVar = this.f1227e;
                aVar.a((a) this.f1225c);
                aVar.h();
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
        this.n = new HashMap<>();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // a.a.a.a.b
    public boolean a(Activity activity, ViewGroup viewGroup, String str, PBDrawVideo pBDrawVideo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, activity, viewGroup, str, pBDrawVideo)) == null) {
            PBDrawVideo pBDrawVideo2 = pBDrawVideo;
            this.f1015h.g();
            this.n.put(pBDrawVideo2, str);
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

    @Override // a.a.a.a.b
    public void b(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, funAdSlot) == null) {
            PBDrawVideo pBDrawVideo = new PBDrawVideo(context.getApplicationContext(), this.f1016i.f1361c);
            pBDrawVideo.setDrawVideoListener(new C0002a(this, pBDrawVideo, funAdSlot));
            this.f1015h.a(funAdSlot, this.f1016i);
            pBDrawVideo.load();
            g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // a.a.a.a.b
    public void b(PBDrawVideo pBDrawVideo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBDrawVideo) == null) {
            PBDrawVideo pBDrawVideo2 = pBDrawVideo;
            this.n.remove(pBDrawVideo2);
            if (pBDrawVideo2 != null) {
                pBDrawVideo2.destroy();
            }
        }
    }
}
