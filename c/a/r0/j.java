package c.a.r0;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f18224d = true;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public k f18225b;

    /* renamed from: c  reason: collision with root package name */
    public BaseFragmentActivity f18226c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349058332, "Lc/a/r0/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349058332, "Lc/a/r0/j;");
        }
    }

    public j(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1L;
        this.f18226c = baseFragmentActivity;
    }

    public final void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        if (intent.getBooleanExtra("from_short_cut", false)) {
            Intent intent2 = new Intent();
            intent2.putExtra(DealIntentService.KEY_CLASS, 2);
            intent2.putExtra("fname", intent.getStringExtra("fname"));
            intent2.putExtra("from_short_cut", true);
            intent2.putExtra("back_special", true);
            intent2.putExtra("from", "short_cut");
            intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
        }
        TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
    }

    public final void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            if (c.a.r0.s3.b.d.a(this.f18226c.getIntent())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            }
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18226c.setIsAddSwipeBackLayout(false);
            this.f18226c.setUseStyleImmersiveSticky(false);
            this.f18226c.getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                this.f18226c.getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            this.f18226c.setContentView(R.layout.logo_activity);
        }
    }

    public void d(Configuration configuration) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (kVar = this.f18225b) == null) {
            return;
        }
        kVar.d(configuration);
    }

    public void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(3007);
            this.a = System.currentTimeMillis();
            if ("MuMu".equals(Build.MODEL) && "6.0.1".equals(Build.VERSION.RELEASE)) {
                this.f18226c.finish();
                return;
            }
            c();
            b(bundle);
            if (!c.a.r0.s3.b.d.a(this.f18226c.getIntent()) && (c.a.r0.s3.b.d.b(this.f18226c.getIntent()) || this.f18226c.isTaskRoot())) {
                a(this.f18226c.getIntent());
            }
            c.a.r0.x3.c.g().i(this.f18226c.getUniqueId());
            k kVar = new k(this.f18226c);
            this.f18225b = kVar;
            kVar.i(f18224d);
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_CREATE_END_STAMP_KEY);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.x3.c.g().k(this.f18226c.getUniqueId());
            f18224d = false;
            k kVar = this.f18225b;
            if (kVar != null) {
                kVar.g();
            }
        }
    }

    public void g() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kVar = this.f18225b) == null) {
            return;
        }
        kVar.e();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (LogoActivityConfig.isFirst && this.a >= 0) {
                c.a.q0.r0.k.b().w(System.currentTimeMillis() - this.a);
            }
            k kVar = this.f18225b;
            if (kVar != null) {
                kVar.f();
            }
        }
    }
}
