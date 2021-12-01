package c.a.r0.z.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.z2.o0;
import c.a.p0.b.m.a;
import c.a.p0.b.n.b;
import c.a.p0.b.q.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f25766d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f25767e;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.z.b.b.b a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.a.m.c> f25768b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f25769c;

    /* renamed from: c.a.r0.z.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1474a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1474a(a aVar, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 1) {
                    this.a.r(TbadkCoreApplication.getInst());
                } else if (num.intValue() == 2) {
                    this.a.v(SapiAccountManager.getInstance().isLogin());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25770e;

        public b(a aVar) {
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
            this.f25770e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.f25770e.v(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                if (getUserInfoResult != null) {
                    this.f25770e.a.f25786f = getUserInfoResult.portraitHttps;
                }
                this.f25770e.v(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.m.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f25771b;

        /* renamed from: c.a.r0.z.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1475a extends GetUserInfoCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f25772e;

            public C1475a(c cVar) {
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
                this.f25772e = cVar;
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                    this.f25772e.a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                    this.f25772e.a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                    this.f25772e.f25771b.a.f25782b = SapiAccountManager.getInstance().getSession().bduss;
                    this.f25772e.f25771b.a.f25788h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.f25772e.f25771b.a.a = getUserInfoResult.displayname;
                    this.f25772e.f25771b.a.f25787g = getUserInfoResult.uid;
                    this.f25772e.f25771b.a.f25786f = getUserInfoResult.portraitHttps;
                    c.a.p0.a.o2.g.h.a().putString("bd_box_display_name", this.f25772e.f25771b.a.a);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_uid", this.f25772e.f25771b.a.f25787g);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_avatar_url", this.f25772e.f25771b.a.f25786f);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_bduss", this.f25772e.f25771b.a.f25782b);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_ptoken", this.f25772e.f25771b.a.f25788h);
                    this.f25772e.a.onResult(0);
                    this.f25772e.f25771b.v(true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2, c.a.p0.a.m.a aVar2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), aVar2};
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
            this.f25771b = aVar;
            this.a = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1475a(this), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.m.a f25773e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25774f;

        public d(a aVar, c.a.p0.a.m.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25774f = aVar;
            this.f25773e = aVar2;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
                this.f25773e.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.f25773e.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.f25774f.a.f25782b = SapiAccountManager.getInstance().getSession().bduss;
                this.f25774f.a.f25788h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f25774f.a.a = getUserInfoResult.displayname;
                this.f25774f.a.f25787g = getUserInfoResult.uid;
                this.f25774f.a.f25786f = getUserInfoResult.portraitHttps;
                c.a.p0.a.o2.g.h.a().putString("bd_box_display_name", this.f25774f.a.a);
                c.a.p0.a.o2.g.h.a().putString("bd_box_uid", this.f25774f.a.f25787g);
                c.a.p0.a.o2.g.h.a().putString("bd_box_avatar_url", this.f25774f.a.f25786f);
                c.a.p0.a.o2.g.h.a().putString("bd_box_bduss", this.f25774f.a.f25782b);
                c.a.p0.a.o2.g.h.a().putString("bd_box_ptoken", this.f25774f.a.f25788h);
                this.f25774f.m();
                this.f25773e.onResult(0);
                this.f25774f.v(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f25775e;

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
            this.f25775e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.LoginStatusAware
        public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, getUserInfoResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.f25775e.a.f25782b = SapiAccountManager.getInstance().getSession().bduss;
                this.f25775e.a.f25788h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f25775e.a.a = getUserInfoResult.displayname;
                this.f25775e.a.f25787g = getUserInfoResult.uid;
                this.f25775e.a.f25786f = getUserInfoResult.portraitHttps;
                c.a.p0.a.o2.g.h.a().putString("bd_box_display_name", this.f25775e.a.a);
                c.a.p0.a.o2.g.h.a().putString("bd_box_uid", this.f25775e.a.f25787g);
                c.a.p0.a.o2.g.h.a().putString("bd_box_avatar_url", this.f25775e.a.f25786f);
                c.a.p0.a.o2.g.h.a().putString("bd_box_bduss", this.f25775e.a.f25782b);
                c.a.p0.a.o2.g.h.a().putString("bd_box_ptoken", this.f25775e.a.f25788h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends AddressManageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f25777f;

        public f(a aVar, String str, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25776e = str;
            this.f25777f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, addressManageResult) == null) {
                if ("0".equals(this.f25776e) || this.f25777f == null) {
                    if (a.f25767e) {
                        String str = a.f25766d;
                        String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg());
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.f25767e) {
                        String str2 = a.f25766d;
                        String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg());
                    }
                    this.f25777f.b();
                } else {
                    this.f25777f.a(addressManageResult.map.get("addrId"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends InvoiceBuildCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f25778e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f25779f;

        public g(a aVar, String str, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25778e = str;
            this.f25779f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, invoiceBuildResult) == null) {
                if ("0".equals(this.f25778e) || this.f25779f == null) {
                    if (a.f25767e) {
                        String str = a.f25766d;
                        String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg());
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.f25767e) {
                        String str2 = a.f25766d;
                        String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg());
                    }
                    this.f25779f.b();
                } else {
                    this.f25779f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f25778e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f25780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25781f;

        public h(a aVar, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25781f = aVar;
            this.f25780e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: c */
        public void onFailure(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, openBdussResult) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: d */
        public void onSuccess(OpenBdussResult openBdussResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, openBdussResult) == null) {
                this.f25781f.a.f25783c = openBdussResult.openBduss;
                this.f25781f.a.f25784d = openBdussResult.unionid;
                this.f25781f.a.f25785e = openBdussResult.tplStokenMap;
                c.a.p0.a.o2.g.h.a().putString("bd_box_open_bduss", this.f25781f.a.f25783c);
                c.a.p0.a.o2.g.h.a().putString("bd_box_union_id", this.f25781f.a.f25784d);
                c.a.p0.a.o2.g.h.a().putString("bd_box_stoken", o0.s(this.f25781f.a.f25785e));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, this.f25781f.a.f25783c);
                    jSONObject.put("unionid", this.f25781f.a.f25784d);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.f25781f.a.f25785e.keySet()) {
                        jSONObject2.put(str, this.f25781f.a.f25785e.get(str));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", this.f25781f.a.f25787g);
                    jSONObject.put("bduss", this.f25781f.a.f25782b);
                    jSONObject.put("displayname", this.f25781f.a.a);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f25780e.a(jSONObject.toString());
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1078851823, "Lc/a/r0/z/b/b/a$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1078851823, "Lc/a/r0/z/b/b/a$i;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(769836884, "Lc/a/r0/z/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(769836884, "Lc/a/r0/z/b/b/a;");
                return;
            }
        }
        f25767e = k.a;
    }

    public /* synthetic */ a(C1474a c1474a) {
        this();
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? i.a : (a) invokeV.objValue;
    }

    public void f(c.a.p0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f25768b.add(cVar);
        }
    }

    public void g(Context context, String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, dVar) == null) {
            AddressManageDTO addressManageDTO = new AddressManageDTO();
            addressManageDTO.type = str;
            addressManageDTO.sweepLightLoading = true;
            PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new f(this, str, dVar));
        }
    }

    public void h(Context context, String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, dVar) == null) {
            InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
            invoiceBuildDTO.TYPE = str;
            PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new g(this, str, dVar));
        }
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.z.b.b.b bVar = this.a;
            if (bVar == null) {
                if (f25767e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f25786f)) {
                o();
            }
            return this.a.f25786f;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.z.b.b.b bVar = this.a;
            if (bVar == null) {
                if (f25767e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f25782b)) {
                o();
            }
            return this.a.f25782b;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.z.b.b.b bVar = this.a;
            if (bVar == null) {
                if (f25767e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.a)) {
                o();
            }
            return this.a.a;
        }
        return (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, arrayList, cVar) == null) {
            if (this.a == null) {
                if (f25767e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return;
            }
            GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
            getOpenBdussDTO.clientId = str;
            getOpenBdussDTO.targetTplList.addAll(arrayList);
            SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new h(this, cVar));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                SapiAccountManager.getInstance().getConfignation();
            } catch (Exception unused) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921328, TbadkCoreApplication.getInst().getApp()));
            }
            try {
                SapiAccountManager.getInstance().isLogin();
                if (SapiAccountManager.getInstance().isLogin()) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new e(this), SapiAccountManager.getInstance().getSession().bduss);
                }
            } catch (NullPointerException unused2) {
            }
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.r0.z.b.b.b bVar = this.a;
            if (bVar == null) {
                if (f25767e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f25787g)) {
                o();
            }
            return this.a.f25787g;
        }
        return (String) invokeV.objValue;
    }

    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            w();
            r(context);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && this.a == null) {
            c.a.r0.z.b.b.b bVar = new c.a.r0.z.b.b.b();
            this.a = bVar;
            bVar.f25786f = c.a.p0.a.o2.g.h.a().getString("bd_box_avatar_url", "");
            this.a.f25782b = c.a.p0.a.o2.g.h.a().getString("bd_box_bduss", "");
            this.a.f25788h = c.a.p0.a.o2.g.h.a().getString("bd_box_ptoken", "");
            this.a.f25787g = c.a.p0.a.o2.g.h.a().getString("bd_box_uid", "");
            this.a.f25783c = c.a.p0.a.o2.g.h.a().getString("bd_box_open_bduss", "");
            this.a.f25784d = c.a.p0.a.o2.g.h.a().getString("bd_box_union_id", "");
            this.a.f25785e = o0.t(c.a.p0.a.o2.g.h.a().getString("bd_box_stoken", ""));
            this.a.a = c.a.p0.a.o2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.r0.z.b.b.b bVar = this.a;
            if (bVar != null && TextUtils.isEmpty(bVar.f25782b)) {
                o();
            }
            return SapiAccountManager.getInstance().isLogin();
        }
        return invokeV.booleanValue;
    }

    public void t(Context context, Bundle bundle, c.a.p0.a.m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, bundle, aVar) == null) {
            if (this.a == null) {
                this.a = new c.a.r0.z.b.b.b();
            }
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true, -1);
            loginActivityConfig.getIntent().putExtra(IntentConfig.CLOSE, true);
            if (bundle != null && (i2 = bundle.getInt("key_login_mode", 1)) > 1) {
                if (i2 == 4) {
                    i2 = 1;
                }
                loginActivityConfig.setIsFromAiapp(true);
                loginActivityConfig.setThirdPartyLoginForResult(i2, "");
            }
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
            MessageManager.getInstance().registerListener(new c(this, 2921362, aVar));
        }
    }

    public void u(c.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            SapiAccountManager.getInstance().logout();
            v(false);
            this.a = new c.a.r0.z.b.b.b();
            c.a.p0.a.o2.g.h.a().putString("bd_box_display_name", "");
            c.a.p0.a.o2.g.h.a().putString("bd_box_uid", "");
            c.a.p0.a.o2.g.h.a().putString("bd_box_avatar_url", "");
            c.a.p0.a.o2.g.h.a().putString("bd_box_bduss", "");
            c.a.p0.a.o2.g.h.a().putString("bd_box_ptoken", "");
            if (aVar != null) {
                aVar.onResult(0);
            }
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            for (c.a.p0.a.m.c cVar : this.f25768b) {
                if (cVar != null) {
                    cVar.a(z);
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(this.f25769c);
        }
    }

    public void x(c.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new d(this, aVar), SapiAccountManager.getInstance().getSession().bduss);
        }
    }

    public void y(GetUserInfoResult getUserInfoResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, getUserInfoResult) == null) {
            if (getUserInfoResult != null) {
                try {
                    c.a.p0.a.o2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                    if (this.a == null) {
                        this.a = new c.a.r0.z.b.b.b();
                    }
                    this.a.f25782b = SapiAccountManager.getInstance().getSession().bduss;
                    this.a.f25788h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.a.a = getUserInfoResult.displayname;
                    this.a.f25787g = getUserInfoResult.uid;
                    this.a.f25786f = getUserInfoResult.portraitHttps;
                    c.a.p0.a.o2.g.h.a().putString("bd_box_display_name", this.a.a);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_uid", this.a.f25787g);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_avatar_url", this.a.f25786f);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_bduss", this.a.f25782b);
                    c.a.p0.a.o2.g.h.a().putString("bd_box_ptoken", this.a.f25788h);
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(this), this.a.f25782b);
                    return;
                } catch (Exception e2) {
                    if (f25767e) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            u(null);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25769c = new C1474a(this, 2921537);
        this.f25768b = new ArrayList();
    }
}
