package c.a.q0.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MissionCustomDialogActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ActiveCenterData f12646a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12647b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12648c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12649d;

    /* renamed from: e  reason: collision with root package name */
    public final f f12650e;

    /* renamed from: f  reason: collision with root package name */
    public final g f12651f;

    /* renamed from: g  reason: collision with root package name */
    public final i f12652g;

    /* renamed from: h  reason: collision with root package name */
    public final b f12653h;

    /* renamed from: i  reason: collision with root package name */
    public final h f12654i;

    /* renamed from: j  reason: collision with root package name */
    public final d f12655j;
    public final c k;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r f12656c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12656c = rVar;
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) || this.f12656c.f12646a == null || this.f12656c.f12646a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f12656c.f12646a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r f12657c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12657c = rVar;
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) || this.f12657c.f12646a == null || this.f12657c.f12646a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f12657c.f12646a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f12658e;

            public a(d dVar, TbPageContext tbPageContext) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, tbPageContext};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12658e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.s.a0.b.e(this.f12658e.getPageActivity(), 1);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
                c.a.e.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public abstract class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f12659a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f12660b;

        public e(r rVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12660b = rVar;
            this.f12659a = i2;
        }

        public abstract void a();

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && c()) {
                a();
            }
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.f12660b.f12646a == null || this.f12660b.f12646a.mission == null || this.f12660b.f12646a.getCurTaskType() != this.f12659a) ? false : true : invokeV.booleanValue;
        }

        public abstract void d(TbPageContext<?> tbPageContext);

        public void e(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) && c()) {
                d(tbPageContext);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public t f12661c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ r f12662d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12662d = rVar;
            this.f12661c = new t();
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12661c == null || this.f12662d.f12646a == null) {
                return;
            }
            this.f12661c.a();
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) || this.f12661c == null || this.f12662d.f12646a == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f12662d.f12646a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public boolean f12663c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ r f12664d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12664d = rVar;
            this.f12663c = false;
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && f() && !this.f12663c) {
                this.f12664d.t();
                this.f12663c = true;
            }
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
                Activity pageActivity = tbPageContext.getPageActivity();
                try {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    if (Build.VERSION.SDK_INT >= 9) {
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, pageActivity.getPackageName(), null));
                    }
                    pageActivity.startActivity(intent);
                } catch (Exception unused) {
                }
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r f12665c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12665c = rVar;
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) || this.f12665c.f12646a == null || this.f12665c.f12646a.mission == null) {
                return;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.f12665c.f12646a.mission.final_reward_url});
        }
    }

    /* loaded from: classes3.dex */
    public class i extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ r f12666c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f12667e;

            public a(i iVar, TbPageContext tbPageContext) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, tbPageContext};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12667e = tbPageContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.s.a0.b.e(this.f12667e.getPageActivity(), 1);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(r rVar, int i2) {
            super(rVar, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((r) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12666c = rVar;
        }

        @Override // c.a.q0.a.r.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12666c.t();
            }
        }

        @Override // c.a.q0.a.r.e
        public void d(TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
                c.a.e.e.m.e.a().postDelayed(new a(this, tbPageContext), 100L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static r f12668a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1128747259, "Lc/a/q0/a/r$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1128747259, "Lc/a/q0/a/r$j;");
                    return;
                }
            }
            f12668a = new r(null);
        }
    }

    public /* synthetic */ r(a aVar) {
        this();
    }

    public static r g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? j.f12668a : (r) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.s.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, c.a.q0.s.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) + 1);
        }
    }

    public ActiveCenterData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12646a : (ActiveCenterData) invokeV.objValue;
    }

    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12653h : (b) invokeV.objValue;
    }

    public c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (c) invokeV.objValue;
    }

    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12655j : (d) invokeV.objValue;
    }

    public f h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f12650e : (f) invokeV.objValue;
    }

    public g i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12651f : (g) invokeV.objValue;
    }

    public h j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12654i : (h) invokeV.objValue;
    }

    public i k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f12652g : (i) invokeV.objValue;
    }

    public void l(TbPageContext<?> tbPageContext) {
        ActiveCenterData activeCenterData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) || (activeCenterData = this.f12646a) == null) {
            return;
        }
        int curTaskType = activeCenterData.getCurTaskType();
        if (curTaskType == 12) {
            h().e(tbPageContext);
            h().b();
        } else if (curTaskType == 6) {
            i().e(tbPageContext);
        } else if (curTaskType == 10) {
            k().e(tbPageContext);
            k().b();
        } else if (curTaskType == 7) {
            d().e(tbPageContext);
        } else if (curTaskType == 5) {
            j().e(tbPageContext);
        } else if (curTaskType == 9) {
            f().e(tbPageContext);
        } else if (curTaskType == 13) {
            e().e(tbPageContext);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ActiveCenterData activeCenterData = this.f12646a;
            return activeCenterData != null && activeCenterData.is_new_window;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (c() != null && (i2 = c().win_jump_time) > 0) {
                if (c.a.q0.a.d.y().u()) {
                    return c.a.q0.s.d0.b.j().l(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L) >= ((long) i2);
                }
                c.a.q0.s.d0.b.j().w(ActiveCenterData.PREF_KEY_ACTIVE_DIALOG_DAY_NUM, 0L);
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f12648c : invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ActiveCenterData activeCenterData = this.f12646a;
            return (activeCenterData == null || activeCenterData.mission == null || !m() || n() || this.f12647b) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void q(ActiveCenterData activeCenterData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, activeCenterData) == null) || activeCenterData == null) {
            return;
        }
        this.f12646a = activeCenterData;
        Activity b2 = c.a.e.a.b.f().b();
        if (b2 == null || !"MainTabActivity".equals(b2.getClass().getSimpleName())) {
            return;
        }
        r(b2);
    }

    public void r(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, context) == null) && p()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MissionCustomDialogActivityConfig(context)));
            b();
            c.a.q0.s.d0.b.j().w("pref_key_last_popup_time", System.currentTimeMillis());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MULTI_TASK_DIALOG_SHOW_AND_CLICK).param("obj_source", c.a.q0.a.d.y().D() ? 2 : 1).param("obj_type", 1));
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !this.f12649d && c.a.q0.a.d.y().I()) {
            this.f12649d = true;
        }
    }

    public void t() {
        ActiveCenterData activeCenterData;
        ActiveCenterData.ActiveCenterMissionData activeCenterMissionData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (activeCenterData = this.f12646a) == null || (activeCenterMissionData = activeCenterData.mission) == null) {
            return;
        }
        int i2 = activeCenterMissionData.active_id;
        int i3 = activeCenterMissionData.mission_id;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(String.valueOf(i2), String.valueOf(i3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
        completeTaskReqMsg.completeId = jSONObject2;
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f12647b = z;
        }
    }

    public r() {
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
        this.f12647b = false;
        this.f12648c = true;
        this.f12649d = false;
        this.f12650e = new f(this, 12);
        this.f12651f = new g(this, 6);
        this.f12652g = new i(this, 10);
        this.f12653h = new b(this, 7);
        this.f12654i = new h(this, 5);
        this.f12655j = new d(this, 9);
        this.k = new c(this, 13);
        if (c.a.q0.a.d.y().s()) {
            this.f12648c = c.a.q0.s.d0.b.j().g("key_delete_mission_home_entrance", true);
            return;
        }
        this.f12648c = true;
        c.a.q0.s.d0.b.j().t("key_delete_mission_home_entrance", true);
    }
}
