package c.a.u0.a0.f.d;

import android.content.Context;
import android.text.TextUtils;
import c.a.y.d.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AccountManagerService;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.RouterService;
import com.baidu.searchbox.live.interfaces.service.ToastService;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AccountManagerService a;

    /* renamed from: b  reason: collision with root package name */
    public AppInfoService f14973b;

    /* renamed from: c  reason: collision with root package name */
    public ToastService f14974c;

    /* renamed from: d  reason: collision with root package name */
    public RouterService f14975d;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
        this.f14973b = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.f14974c = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.f14975d = (RouterService) ServiceManager.getService(RouterService.Companion.getSERVICE_REFERENCE());
    }

    @Override // c.a.y.d.b.c
    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) || this.f14974c == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f14974c.showNormal(context, str, 0);
    }

    @Override // c.a.y.d.b.c
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AccountManagerService accountManagerService = this.a;
            return accountManagerService != null ? accountManagerService.getAccount().getUk() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.y.d.b.c
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            return skinType == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : skinType == 4 ? SkinManager.SKIN_TYPE_STR_DARK : "day";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.y.d.b.c
    public String getCuid() {
        InterceptResult invokeV;
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.a == null || (appInfoService = this.f14973b) == null) ? "" : this.a.getSocialEncryption(appInfoService.getCuid(), "baiduuid_") : (String) invokeV.objValue;
    }

    @Override // c.a.y.d.b.c
    public String getIID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // c.a.y.d.b.c
    public void invokeScheme(Context context, String str) {
        RouterService routerService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) || context == null || TextUtils.isEmpty(str) || (routerService = this.f14975d) == null) {
            return;
        }
        routerService.invokeScheme(context, str);
    }
}
