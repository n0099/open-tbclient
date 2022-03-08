package c.a.q0.r.h0;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.c1.k0;
import c.a.q0.c1.n0;
import c.a.q0.c1.s;
import c.a.q0.f0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f12899b;

    /* renamed from: c  reason: collision with root package name */
    public int f12900c;

    /* renamed from: d  reason: collision with root package name */
    public int f12901d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12902e;

    /* renamed from: f  reason: collision with root package name */
    public int f12903f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f12904g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f12905h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicLong f12906i;

    /* renamed from: j  reason: collision with root package name */
    public ScheduledExecutorService f12907j;
    public e k;
    public CustomMessageListener l;

    /* renamed from: c.a.q0.r.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0855a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0855a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f12909f;

        public b(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12909f = aVar;
            this.f12908e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f12909f.y(QueryResponse.Options.CANCEL);
                this.f12909f.l();
                dialogInterface.dismiss();
                this.f12908e.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f12910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f12911f;

        /* renamed from: c.a.q0.r.h0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0856a extends k0<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public C0856a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // c.a.q0.c1.k0
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.a.f12911f.k();
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.a.f12910e.deleteSharedPreferences("settings");
                    } else {
                        c.a.q0.r.j0.b.k().d();
                    }
                    c.a.q0.r.j0.b.k().u("key_is_jump_splash_ad", true);
                    c.a.q0.r.j0.b.k().H();
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public class b implements s<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // c.a.q0.c1.s
            public void onReturnDataInUI(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    c cVar = this.a;
                    cVar.f12911f.t(cVar.f12910e);
                    n.G(this.a.f12910e);
                }
            }
        }

        public c(a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12911f = aVar;
            this.f12910e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                this.f12911f.y("fix");
                this.f12911f.w(this.f12910e);
                n0.b(new C0856a(this), new b(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(553807354, "Lc/a/q0/r/h0/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(553807354, "Lc/a/q0/r/h0/a$d;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f12912e;

        /* renamed from: c.a.q0.r.h0.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0857a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f12913e;

            public RunnableC0857a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12913e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f12913e.f12912e.g();
                }
            }
        }

        public e(a aVar) {
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
            this.f12912e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12912e.f12906i.incrementAndGet();
                if (this.f12912e.f12906i.get() >= 10) {
                    c.a.d.f.m.e.a().post(new RunnableC0857a(this));
                }
            }
        }

        public /* synthetic */ e(a aVar, C0855a c0855a) {
            this(aVar);
        }
    }

    public /* synthetic */ a(C0855a c0855a) {
        this();
    }

    public static final a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? d.a : (a) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a && !this.f12905h && this.f12904g) {
            this.f12905h = true;
            ScheduledExecutorService scheduledExecutorService = this.f12907j;
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                this.f12907j.shutdownNow();
            }
            if (this.f12906i.get() <= 5) {
                return;
            }
            l();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a && !this.f12905h) {
            this.f12901d++;
            c.a.q0.r.j0.b.k().w("key_continupus_crash_times", this.f12901d);
            c.a.q0.r.j0.b.k().H();
        }
    }

    public int i(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (this.a && !this.f12902e) {
                this.f12902e = true;
                this.f12903f = 0;
                int i2 = this.f12901d;
                if (i2 >= this.f12900c) {
                    if (activity == null) {
                        return 0;
                    }
                    v(activity);
                    this.f12903f = 2;
                    z(2, this.f12901d);
                    return this.f12903f;
                } else if (i2 >= this.f12899b) {
                    j();
                    this.f12903f = 1;
                    z(1, this.f12901d);
                    return this.f12903f;
                } else {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n(new File(FileHelper.getCacheDir()));
            n(TbadkCoreApplication.getInst().getCacheDir());
            n(TbadkCoreApplication.getInst().getExternalCacheDir());
            c.a.q0.r.s.a.f();
            try {
                c.a.q0.r.s.a.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", null);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j();
            n(new File("/data/data/" + TbadkCoreApplication.getInst().getPackageName() + "/databases"));
            n(new File("/data/data/" + TbadkCoreApplication.getInst().getPackageName() + "/shared_prefs"));
            n(new File("/data/data/" + TbadkCoreApplication.getInst().getPackageName() + "/files"));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f12901d <= 0) {
            return;
        }
        this.f12901d = 0;
        c.a.q0.r.j0.b.k().w("key_continupus_crash_times", this.f12901d);
        c.a.q0.r.j0.b.k().H();
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12901d = 0;
            c.a.q0.r.j0.b.k().w("key_continupus_crash_times", this.f12901d);
            c.a.q0.r.j0.b.k().u("key_is_jump_splash_ad", false);
        }
    }

    public final void n(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, file) == null) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12901d : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f12899b : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f12900c : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f12903f : invokeV.intValue;
    }

    public final void t(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).hideLoadingView(activity.getWindow().findViewById(16908290));
            } else if (activity instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) activity).hideLoadingView(activity.getWindow().findViewById(16908290));
            }
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : invokeV.booleanValue;
    }

    public final void v(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, activity) == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(R.string.check_app_has_been_damaged);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.exit, new b(this, activity));
            builder.setNegativeButton(R.string.fix, new c(this, activity));
            builder.show();
        }
    }

    public final void w(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
            if (activity instanceof BaseActivity) {
                BaseActivity baseActivity = (BaseActivity) activity;
                baseActivity.showLoadingView(activity.getWindow().findViewById(16908290), true);
                g loadingView = baseActivity.getLoadingView();
                if (loadingView != null) {
                    loadingView.q(R.string.data_cleaning);
                }
            } else if (activity instanceof BaseFragmentActivity) {
                BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) activity;
                baseFragmentActivity.showLoadingView(activity.getWindow().findViewById(16908290), true);
                g loadingView2 = baseFragmentActivity.getLoadingView();
                if (loadingView2 != null) {
                    loadingView2.q(R.string.data_cleaning);
                }
            }
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || !this.a || this.f12904g || this.f12905h) {
            return;
        }
        this.f12904g = true;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f12907j = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this.k, 0L, 1L, TimeUnit.SECONDS);
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                uBCManager.onEvent("5087", jSONObject);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void z(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", i2 == 1 ? "first_level" : i2 == 2 ? "second_level" : "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("crash_times", i3);
                jSONObject.put("ext", jSONObject2);
                uBCManager.onEvent("5081", jSONObject);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public a() {
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
        this.f12902e = false;
        this.f12906i = new AtomicLong(0L);
        this.k = new e(this, null);
        this.l = new C0855a(this, 2001011);
        if (TbadkCoreApplication.getInst().isMainProcess(false)) {
            boolean z = c.a.q0.r.j0.b.k().l("key_is_start_safe_mode", 0) == 1;
            this.a = z;
            if (z) {
                this.f12899b = c.a.q0.r.j0.b.k().l("key_first_level_safe_mode_continuous_crash_time", 3);
                this.f12900c = c.a.q0.r.j0.b.k().l("key_second_level_safe_mode_continuous_crash_time", 6);
                this.f12901d = c.a.q0.r.j0.b.k().l("key_continupus_crash_times", 0);
                MessageManager.getInstance().registerListener(this.l);
            }
        }
    }
}
