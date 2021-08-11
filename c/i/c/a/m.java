package c.i.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f33921a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f33922b;

    public m(InstallActivity installActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {installActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33922b = installActivity;
        this.f33921a = false;
    }

    public void a(com.google.ar.core.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            synchronized (this.f33922b) {
                if (this.f33921a) {
                    return;
                }
                InstallActivity.access$402(this.f33922b, pVar);
                int ordinal = pVar.ordinal();
                if (ordinal != 0) {
                    if (ordinal == 1) {
                        InstallActivity.access$000(this.f33922b, new UnavailableUserDeclinedInstallationException());
                    } else if (ordinal == 2) {
                        if (!InstallActivity.access$500(this.f33922b)) {
                            InstallActivity.access$600(this.f33922b);
                        }
                        InstallActivity.access$000(this.f33922b, null);
                    }
                    this.f33921a = true;
                }
            }
        }
    }

    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.f33922b) {
                if (this.f33921a) {
                    return;
                }
                this.f33921a = true;
                InstallActivity.access$402(this.f33922b, com.google.ar.core.p.f69884b);
                boolean z = exc instanceof UnavailableException;
                InstallActivity.access$000(this.f33922b, exc);
            }
        }
    }
}
