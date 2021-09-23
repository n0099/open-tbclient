package c.a.r0.v.f.d;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes4.dex */
public class b implements c.a.w.d.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AccountManagerService f25751a;

    /* renamed from: b  reason: collision with root package name */
    public AppInfoService f25752b;

    /* renamed from: c  reason: collision with root package name */
    public ToastService f25753c;

    /* renamed from: d  reason: collision with root package name */
    public RouterService f25754d;

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
        this.f25751a = (AccountManagerService) ServiceManager.getService(AccountManagerService.Companion.getSERVICE_REFERENCE());
        this.f25752b = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.f25753c = (ToastService) ServiceManager.getService(ToastService.Companion.getSERVICE_REFERENCE());
        this.f25754d = (RouterService) ServiceManager.getService(RouterService.Companion.getSERVICE_REFERENCE());
    }

    @Override // c.a.w.d.b.b
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AccountManagerService accountManagerService = this.f25751a;
            return accountManagerService != null ? accountManagerService.getAccount().getUk() : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.w.d.b.b
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            return skinType == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : skinType == 4 ? SkinManager.SKIN_TYPE_STR_DARK : "day";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.w.d.b.b
    public void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) || this.f25753c == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f25753c.showNormal(context, str, 0);
    }

    @Override // c.a.w.d.b.b
    public String getCuid() {
        InterceptResult invokeV;
        AppInfoService appInfoService;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.f25751a == null || (appInfoService = this.f25752b) == null) ? "" : this.f25751a.getSocialEncryption(appInfoService.getCuid(), "baiduuid_") : (String) invokeV.objValue;
    }

    @Override // c.a.w.d.b.b
    public void invokeScheme(Context context, String str) {
        RouterService routerService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, context, str) == null) || context == null || TextUtils.isEmpty(str) || (routerService = this.f25754d) == null) {
            return;
        }
        routerService.invokeScheme(context, str);
    }
}
