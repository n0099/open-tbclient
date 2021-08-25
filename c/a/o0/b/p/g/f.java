package c.a.o0.b.p.g;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.b.l.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.b.p.g.c f10232a;

        public a(c.a.o0.b.p.g.c cVar) {
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
            this.f10232a = cVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                if (oneKeyLoginResult == null) {
                    this.f10232a.a(null);
                    return;
                }
                boolean z = oneKeyLoginResult.enable;
                String str = oneKeyLoginResult.operator;
                String str2 = oneKeyLoginResult.encryptPhoneNum;
                boolean z2 = oneKeyLoginResult.hasHistory;
                c.a.o0.b.p.g.a aVar = new c.a.o0.b.p.g.a();
                aVar.j(z);
                aVar.k(str);
                aVar.g(str2);
                aVar.h(z2);
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 2154) {
                    if (hashCode != 2161) {
                        if (hashCode == 2162 && str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC)) {
                            c2 = 1;
                        }
                    } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                        c2 = 2;
                    }
                } else if (str.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    aVar.i(12);
                } else if (c2 == 1) {
                    aVar.i(13);
                } else if (c2 == 2) {
                    aVar.i(14);
                }
                this.f10232a.a(QuickLoginInfo.parseQuickLoginInfo(aVar));
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                super.unAvailable(oneKeyLoginResult);
                this.f10232a.a(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.o0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.b.p.g.c f10233c;

        public b(c.a.o0.b.p.g.c cVar) {
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
            this.f10233c = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v1.a.b.c.b, c.a.o0.a.v1.a.b.c.c, c.a.o0.a.v1.a.b.c.a
        public void onEvent(@NonNull c.a.o0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                Bundle a2 = bVar.a();
                if (a2 == null) {
                    this.f10233c.a(null);
                    return;
                }
                a2.setClassLoader(QuickLoginInfo.class.getClassLoader());
                QuickLoginInfo quickLoginInfo = (QuickLoginInfo) a2.getParcelable("quick_login_info_result");
                if (quickLoginInfo == null) {
                    this.f10233c.a(null);
                } else {
                    this.f10233c.a(quickLoginInfo);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f10234a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f10235b;

        public c(Activity activity, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10234a = activity;
            this.f10235b = eVar;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void available(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                v.a().n(this.f10234a, oneKeyLoginResult.sign, this.f10235b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.f10235b.onResult(-1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f10236a;

        public d(e eVar) {
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
            this.f10236a = eVar;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                Bundle bundle = delegateResult.mResult;
                if (this.f10236a != null) {
                    this.f10236a.onResult(c.a.o0.a.v2.v.f(bundle, "quick_login", -1));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-906061487, "Lc/a/o0/b/p/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-906061487, "Lc/a/o0/b/p/g/f;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    public static void a(c.a.o0.b.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cVar) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new a(cVar));
        }
    }

    public static void b(c.a.o0.b.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                a(cVar);
            } else {
                c(cVar);
            }
        }
    }

    public static void c(c.a.o0.b.p.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cVar) == null) {
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
            if (Q == null) {
                cVar.a(null);
                return;
            }
            c.a.o0.a.v1.c.e.a z = Q.z();
            if (z == null) {
                cVar.a(null);
            } else {
                z.L(null, c.a.o0.b.p.g.b.class, new b(cVar));
            }
        }
    }

    public static void d(Activity activity, int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, i2, eVar) == null) {
            SapiAccountManager.getInstance().getOneKeyLoginIsAvailable(new c(activity, eVar));
        }
    }

    public static void e(Activity activity, int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, activity, i2, eVar) == null) {
            if (ProcessUtils.isMainProcess()) {
                d(activity, i2, eVar);
            } else {
                f(activity, i2, eVar);
            }
        }
    }

    public static void f(Activity activity, int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, activity, i2, eVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("quick_login_mode", i2);
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, c.a.o0.b.p.g.d.class, bundle, new d(eVar));
        }
    }
}
