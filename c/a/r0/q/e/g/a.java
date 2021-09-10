package c.a.r0.q.e.g;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import c.a.r0.q.e.g.b;
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
/* loaded from: classes3.dex */
public abstract class a<VIEW extends b, MODEL extends IDownloadModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final VIEW f24125a;

    /* renamed from: b  reason: collision with root package name */
    public MODEL f24126b;

    /* renamed from: c.a.r0.q.e.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1122a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24127e;

        public View$OnClickListenerC1122a(a aVar) {
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
            this.f24127e = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: c.a.r0.q.e.g.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24127e.f24125a.onClickIntercept(view)) {
                return;
            }
            a aVar = this.f24127e;
            aVar.j(aVar.f24126b);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1944517835, "Lc/a/r0/q/e/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1944517835, "Lc/a/r0/q/e/g/a;");
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
        this.f24125a = view;
        k(model);
        this.f24126b = model;
        View actionBar = this.f24125a.getActionBar();
        if (actionBar != null) {
            actionBar.setOnClickListener(new View$OnClickListenerC1122a(this));
        }
    }

    public MODEL c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24126b : (MODEL) invokeV.objValue;
    }

    public VIEW d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24125a : (VIEW) invokeV.objValue;
    }

    @CallSuper
    public void e(@NonNull MODEL model) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, model) == null) {
            this.f24126b = model;
            if (this.f24125a == null) {
                return;
            }
            i();
            this.f24125a.onStateAndProgressChanged(model.getCurrentState(), model.getPercent());
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f24125a.onProgressChanged(Math.max(this.f24126b.getPercent(), i2));
        }
    }

    @CallSuper
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f24125a.onProgressChanged(Math.max(this.f24126b.getPercent(), i2));
            MODEL model = this.f24126b;
            if (model != null) {
                model.getCurrentState();
            }
            DownloadStatus downloadStatus = DownloadStatus.STATUS_NONE;
        }
    }

    @CallSuper
    public void h(@NonNull DownloadStatus downloadStatus) {
        MODEL model;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadStatus) == null) || (model = this.f24126b) == null) {
            return;
        }
        this.f24125a.onStatusChanged(downloadStatus);
        if (downloadStatus != DownloadStatus.STATUS_NONE) {
            i();
        }
        if (downloadStatus == DownloadStatus.STATUS_SUCCESS || downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c.a.r0.q.f.a.i().l(downloadStatus, model);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f24125a.getRealView().getVisibility() == 0) {
            return;
        }
        this.f24125a.getRealView().setVisibility(0);
    }

    public abstract void j(MODEL model);

    public abstract void k(MODEL model);
}
