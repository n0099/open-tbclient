package b.f.a0.c;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.f.a0.c.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.win.opensdk.PBError;
import com.win.opensdk.PBMediaView;
import com.win.opensdk.PBNative;
import com.win.opensdk.PBNativeListener;
import java.util.List;
/* loaded from: classes6.dex */
public class k extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PBNative f31844a;

    /* loaded from: classes6.dex */
    public class a implements PBNativeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f31845a;

        public a(k kVar, p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31845a = pVar;
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((v.a) this.f31845a).a();
            }
        }

        @Override // com.win.opensdk.PBNativeListener
        public void onDisplayed() {
            AdReporter adReporter;
            Ssp.Pid pid;
            Ssp.Pid pid2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v.a aVar = (v.a) this.f31845a;
                aVar.getClass();
                LogPrinter.d();
                adReporter = aVar.f31872d.mReporter;
                adReporter.recordShowSucceed(aVar.f31869a);
                aVar.f31869a = true;
                aVar.f31872d.onAdShow(aVar.f31871c);
                synchronized (aVar.f31872d.f31868h) {
                    v.b bVar = aVar.f31872d.f31868h.get(aVar.f31871c);
                    if (bVar != null) {
                        FunAdInteractionListener funAdInteractionListener = bVar.f31875c;
                        String str = bVar.f31873a;
                        pid = aVar.f31872d.mPid;
                        String str2 = pid.ssp.type;
                        pid2 = aVar.f31872d.mPid;
                        funAdInteractionListener.onAdShow(str, str2, pid2.pid);
                    }
                }
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pBError) == null) {
                ((v.a) this.f31845a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ((v.a) this.f31845a).c();
            }
        }
    }

    public k(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31844a = new PBNative(context.getApplicationContext(), str);
    }

    @Override // b.f.a0.c.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31844a.destroy();
        }
    }

    @Override // b.f.a0.c.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31844a.load();
        }
    }

    @Override // b.f.a0.c.f
    public void c(View view, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, obj) == null) {
            this.f31844a.registerViewForInteraction(view, (PBMediaView) obj);
        }
    }

    @Override // b.f.a0.c.f
    public void d(View view, Object obj, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, view, obj, list) == null) {
            this.f31844a.registerViewForInteraction(view, (PBMediaView) obj, list);
        }
    }

    @Override // b.f.a0.c.f
    public void e(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            this.f31844a.setNativeListener(new a(this, pVar));
        }
    }

    @Override // b.f.a0.c.f
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31844a.getBody() : (String) invokeV.objValue;
    }

    @Override // b.f.a0.c.f
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31844a.getCallToAction() : (String) invokeV.objValue;
    }

    @Override // b.f.a0.c.f
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31844a.getHeadline() : (String) invokeV.objValue;
    }

    @Override // b.f.a0.c.f
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31844a.getIM() : (String) invokeV.objValue;
    }

    @Override // b.f.a0.c.f
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31844a.getIcon() : (String) invokeV.objValue;
    }

    @Override // b.f.a0.c.f
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f31844a.getMediaViewHeight() : invokeV.intValue;
    }

    @Override // b.f.a0.c.f
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f31844a.getMediaViewWidth() : invokeV.intValue;
    }

    @Override // b.f.a0.c.f
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f31844a.isD() : invokeV.booleanValue;
    }

    @Override // b.f.a0.c.f
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f31844a.isReady() : invokeV.booleanValue;
    }

    @Override // b.f.a0.c.f
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String adType = this.f31844a.getAdType();
            adType.hashCode();
            return adType.equals("h5") || adType.equals("video");
        }
        return invokeV.booleanValue;
    }
}
