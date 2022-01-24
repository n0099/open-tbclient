package c.a.t0.v.g.g;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.v.g.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final VIEW f24200e;

    /* renamed from: f  reason: collision with root package name */
    public MODEL f24201f;

    /* renamed from: c.a.t0.v.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1468a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24202e;

        public View$OnClickListenerC1468a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24202e = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: c.a.t0.v.g.g.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24202e.f24200e.onClickIntercept(view)) {
                return;
            }
            a aVar = this.f24202e;
            aVar.k(aVar.f24201f);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1062077872, "Lc/a/t0/v/g/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1062077872, "Lc/a/t0/v/g/g/a;");
        }
    }

    public a(@NonNull VIEW view, @NonNull MODEL model) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, model};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24200e = view;
        l(model);
        this.f24201f = model;
        View actionBar = this.f24200e.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1468a(this));
        }
    }

    @CallSuper
    public void c(@NonNull DownloadStatus downloadStatus) {
        MODEL model;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadStatus) == null) || (model = this.f24201f) == null) {
            return;
        }
        this.f24200e.onStatusChanged(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            j();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c.a.t0.v.h.a.i().l(downloadStatus, model);
        }
    }

    public MODEL f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24201f : (MODEL) invokeV.objValue;
    }

    public VIEW g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24200e : (VIEW) invokeV.objValue;
    }

    @CallSuper
    public void h(@NonNull MODEL model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, model) == null) {
            this.f24201f = model;
            if (this.f24200e == null) {
                return;
            }
            j();
            this.f24200e.onStateAndProgressChanged(model.getCurrentState(), model.getPercent());
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f24200e.onProgressChanged(Math.max(this.f24201f.getPercent(), i2));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f24200e.getRealView().getVisibility() == 0) {
            return;
        }
        this.f24200e.getRealView().setVisibility(0);
    }

    public abstract void k(MODEL model);

    public abstract void l(MODEL model);

    @CallSuper
    public void onProgressChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f24200e.onProgressChanged(Math.max(this.f24201f.getPercent(), i2));
            MODEL model = this.f24201f;
            if (model != null) {
                model.getCurrentState();
            }
            DownloadStatus downloadStatus = DownloadStatus.STATUS_NONE;
        }
    }
}
