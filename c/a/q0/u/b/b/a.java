package c.a.q0.u.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import c.a.o0.a.v2.o0;
import c.a.o0.b.m.a;
import c.a.o0.b.n.b;
import c.a.o0.b.q.a;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f24772d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f24773e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.u.b.b.b f24774a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.o0.a.m.c> f24775b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f24776c;

    /* renamed from: c.a.q0.u.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1146a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24777a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1146a(a aVar, int i2) {
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
            this.f24777a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 1) {
                    this.f24777a.r(TbadkCoreApplication.getInst());
                } else if (num.intValue() == 2) {
                    this.f24777a.v(SapiAccountManager.getInstance().isLogin());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24778e;

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
            this.f24778e = aVar;
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
                this.f24778e.v(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                if (getUserInfoResult != null) {
                    this.f24778e.f24774a.f24797f = getUserInfoResult.portraitHttps;
                }
                this.f24778e.v(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.m.a f24779a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f24780b;

        /* renamed from: c.a.q0.u.b.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1147a extends GetUserInfoCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f24781e;

            public C1147a(c cVar) {
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
                this.f24781e = cVar;
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
                    this.f24781e.f24779a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                    this.f24781e.f24779a.onResult(-1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(GetUserInfoResult getUserInfoResult) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                    this.f24781e.f24780b.f24774a.f24793b = SapiAccountManager.getInstance().getSession().bduss;
                    this.f24781e.f24780b.f24774a.f24799h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.f24781e.f24780b.f24774a.f24792a = getUserInfoResult.displayname;
                    this.f24781e.f24780b.f24774a.f24798g = getUserInfoResult.uid;
                    this.f24781e.f24780b.f24774a.f24797f = getUserInfoResult.portraitHttps;
                    c.a.o0.a.k2.g.h.a().putString("bd_box_display_name", this.f24781e.f24780b.f24774a.f24792a);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_uid", this.f24781e.f24780b.f24774a.f24798g);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f24781e.f24780b.f24774a.f24797f);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_bduss", this.f24781e.f24780b.f24774a.f24793b);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_ptoken", this.f24781e.f24780b.f24774a.f24799h);
                    this.f24781e.f24779a.onResult(0);
                    this.f24781e.f24780b.v(true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2, c.a.o0.a.m.a aVar2) {
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
            this.f24780b = aVar;
            this.f24779a = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 0) {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new C1147a(this), SapiAccountManager.getInstance().getSession().bduss);
                }
                this.f24779a.onResult(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.m.a f24782e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f24783f;

        public d(a aVar, c.a.o0.a.m.a aVar2) {
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
            this.f24783f = aVar;
            this.f24782e = aVar2;
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
                this.f24782e.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                this.f24782e.onResult(-1);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetUserInfoResult getUserInfoResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, getUserInfoResult) == null) {
                this.f24783f.f24774a.f24793b = SapiAccountManager.getInstance().getSession().bduss;
                this.f24783f.f24774a.f24799h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f24783f.f24774a.f24792a = getUserInfoResult.displayname;
                this.f24783f.f24774a.f24798g = getUserInfoResult.uid;
                this.f24783f.f24774a.f24797f = getUserInfoResult.portraitHttps;
                c.a.o0.a.k2.g.h.a().putString("bd_box_display_name", this.f24783f.f24774a.f24792a);
                c.a.o0.a.k2.g.h.a().putString("bd_box_uid", this.f24783f.f24774a.f24798g);
                c.a.o0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f24783f.f24774a.f24797f);
                c.a.o0.a.k2.g.h.a().putString("bd_box_bduss", this.f24783f.f24774a.f24793b);
                c.a.o0.a.k2.g.h.a().putString("bd_box_ptoken", this.f24783f.f24774a.f24799h);
                this.f24783f.m();
                this.f24782e.onResult(0);
                this.f24783f.v(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends GetUserInfoCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24784e;

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
            this.f24784e = aVar;
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
                this.f24784e.f24774a.f24793b = SapiAccountManager.getInstance().getSession().bduss;
                this.f24784e.f24774a.f24799h = SapiAccountManager.getInstance().getSession().getPtoken();
                this.f24784e.f24774a.f24792a = getUserInfoResult.displayname;
                this.f24784e.f24774a.f24798g = getUserInfoResult.uid;
                this.f24784e.f24774a.f24797f = getUserInfoResult.portraitHttps;
                c.a.o0.a.k2.g.h.a().putString("bd_box_display_name", this.f24784e.f24774a.f24792a);
                c.a.o0.a.k2.g.h.a().putString("bd_box_uid", this.f24784e.f24774a.f24798g);
                c.a.o0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f24784e.f24774a.f24797f);
                c.a.o0.a.k2.g.h.a().putString("bd_box_bduss", this.f24784e.f24774a.f24793b);
                c.a.o0.a.k2.g.h.a().putString("bd_box_ptoken", this.f24784e.f24774a.f24799h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AddressManageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f24785e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f24786f;

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
            this.f24785e = str;
            this.f24786f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.AddressManageCallback
        public void onFinish(AddressManageResult addressManageResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, addressManageResult) == null) {
                if ("0".equals(this.f24785e) || this.f24786f == null) {
                    if (a.f24773e) {
                        String str = a.f24772d;
                        String.format("管理收货地址流程结束（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg());
                    }
                } else if (addressManageResult.getResultCode() != 0) {
                    if (a.f24773e) {
                        String str2 = a.f24772d;
                        String.format("选择收货地址错误（%d:%s", Integer.valueOf(addressManageResult.getResultCode()), addressManageResult.getResultMsg());
                    }
                    this.f24786f.b();
                } else {
                    this.f24786f.a(addressManageResult.map.get("addrId"));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends InvoiceBuildCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f24787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f24788f;

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
            this.f24787e = str;
            this.f24788f = dVar;
        }

        @Override // com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback
        public void onFinish(InvoiceBuildResult invoiceBuildResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, invoiceBuildResult) == null) {
                if ("0".equals(this.f24787e) || this.f24788f == null) {
                    if (a.f24773e) {
                        String str = a.f24772d;
                        String.format("发票管理流程结束（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg());
                    }
                } else if (invoiceBuildResult.getResultCode() != 0) {
                    if (a.f24773e) {
                        String str2 = a.f24772d;
                        String.format("获取发票错误（%d:%s）", Integer.valueOf(invoiceBuildResult.getResultCode()), invoiceBuildResult.getResultMsg());
                    }
                    this.f24788f.b();
                } else {
                    this.f24788f.a(invoiceBuildResult.map.get(InvoiceBuildResult.KEY_INVOICE_ID), this.f24787e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends GetOpenBdussCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f24789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f24790f;

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
            this.f24790f = aVar;
            this.f24789e = cVar;
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
                this.f24790f.f24774a.f24794c = openBdussResult.openBduss;
                this.f24790f.f24774a.f24795d = openBdussResult.unionid;
                this.f24790f.f24774a.f24796e = openBdussResult.tplStokenMap;
                c.a.o0.a.k2.g.h.a().putString("bd_box_open_bduss", this.f24790f.f24774a.f24794c);
                c.a.o0.a.k2.g.h.a().putString("bd_box_union_id", this.f24790f.f24774a.f24795d);
                c.a.o0.a.k2.g.h.a().putString("bd_box_stoken", o0.s(this.f24790f.f24774a.f24796e));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(OpenBdussResult.PARAMS_OPEN_BDUSS, this.f24790f.f24774a.f24794c);
                    jSONObject.put("unionid", this.f24790f.f24774a.f24795d);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.f24790f.f24774a.f24796e.keySet()) {
                        jSONObject2.put(str, this.f24790f.f24774a.f24796e.get(str));
                    }
                    jSONObject.put("stokenmap", jSONObject2);
                    jSONObject.put("uid", this.f24790f.f24774a.f24798g);
                    jSONObject.put("bduss", this.f24790f.f24774a.f24793b);
                    jSONObject.put("displayname", this.f24790f.f24774a.f24792a);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.f24789e.a(jSONObject.toString());
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

    /* loaded from: classes3.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f24791a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1940144941, "Lc/a/q0/u/b/b/a$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1940144941, "Lc/a/q0/u/b/b/a$i;");
                    return;
                }
            }
            f24791a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1852296136, "Lc/a/q0/u/b/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1852296136, "Lc/a/q0/u/b/b/a;");
                return;
            }
        }
        f24773e = k.f7049a;
    }

    public /* synthetic */ a(C1146a c1146a) {
        this();
    }

    public static a l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? i.f24791a : (a) invokeV.objValue;
    }

    public void f(c.a.o0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f24775b.add(cVar);
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
            c.a.q0.u.b.b.b bVar = this.f24774a;
            if (bVar == null) {
                if (f24773e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f24797f)) {
                o();
            }
            return this.f24774a.f24797f;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.u.b.b.b bVar = this.f24774a;
            if (bVar == null) {
                if (f24773e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f24793b)) {
                o();
            }
            return this.f24774a.f24793b;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.q0.u.b.b.b bVar = this.f24774a;
            if (bVar == null) {
                if (f24773e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f24792a)) {
                o();
            }
            return this.f24774a.f24792a;
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
            if (this.f24774a == null) {
                if (f24773e) {
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
            c.a.q0.u.b.b.b bVar = this.f24774a;
            if (bVar == null) {
                if (f24773e) {
                    throw new NullPointerException("AccountInfo is null");
                }
                return "";
            }
            if (TextUtils.isEmpty(bVar.f24798g)) {
                o();
            }
            return this.f24774a.f24798g;
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
        if ((interceptable == null || interceptable.invokeL(1048587, this, context) == null) && this.f24774a == null) {
            c.a.q0.u.b.b.b bVar = new c.a.q0.u.b.b.b();
            this.f24774a = bVar;
            bVar.f24797f = c.a.o0.a.k2.g.h.a().getString("bd_box_avatar_url", "");
            this.f24774a.f24793b = c.a.o0.a.k2.g.h.a().getString("bd_box_bduss", "");
            this.f24774a.f24799h = c.a.o0.a.k2.g.h.a().getString("bd_box_ptoken", "");
            this.f24774a.f24798g = c.a.o0.a.k2.g.h.a().getString("bd_box_uid", "");
            this.f24774a.f24794c = c.a.o0.a.k2.g.h.a().getString("bd_box_open_bduss", "");
            this.f24774a.f24795d = c.a.o0.a.k2.g.h.a().getString("bd_box_union_id", "");
            this.f24774a.f24796e = o0.t(c.a.o0.a.k2.g.h.a().getString("bd_box_stoken", ""));
            this.f24774a.f24792a = c.a.o0.a.k2.g.h.a().getString("bd_box_display_name", "");
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.q0.u.b.b.b bVar = this.f24774a;
            if (bVar != null && TextUtils.isEmpty(bVar.f24793b)) {
                o();
            }
            return SapiAccountManager.getInstance().isLogin();
        }
        return invokeV.booleanValue;
    }

    public void t(Context context, Bundle bundle, c.a.o0.a.m.a aVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, context, bundle, aVar) == null) {
            if (this.f24774a == null) {
                this.f24774a = new c.a.q0.u.b.b.b();
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

    public void u(c.a.o0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            SapiAccountManager.getInstance().logout();
            v(false);
            this.f24774a = new c.a.q0.u.b.b.b();
            c.a.o0.a.k2.g.h.a().putString("bd_box_display_name", "");
            c.a.o0.a.k2.g.h.a().putString("bd_box_uid", "");
            c.a.o0.a.k2.g.h.a().putString("bd_box_avatar_url", "");
            c.a.o0.a.k2.g.h.a().putString("bd_box_bduss", "");
            c.a.o0.a.k2.g.h.a().putString("bd_box_ptoken", "");
            if (aVar != null) {
                aVar.onResult(0);
            }
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            for (c.a.o0.a.m.c cVar : this.f24775b) {
                cVar.a(z);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            MessageManager.getInstance().registerListener(this.f24776c);
        }
    }

    public void x(c.a.o0.a.m.a aVar) {
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
                    c.a.o0.a.k2.g.h.a().putString("host_account_info_string", getUserInfoResult.toString());
                    if (this.f24774a == null) {
                        this.f24774a = new c.a.q0.u.b.b.b();
                    }
                    this.f24774a.f24793b = SapiAccountManager.getInstance().getSession().bduss;
                    this.f24774a.f24799h = SapiAccountManager.getInstance().getSession().getPtoken();
                    this.f24774a.f24792a = getUserInfoResult.displayname;
                    this.f24774a.f24798g = getUserInfoResult.uid;
                    this.f24774a.f24797f = getUserInfoResult.portraitHttps;
                    c.a.o0.a.k2.g.h.a().putString("bd_box_display_name", this.f24774a.f24792a);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_uid", this.f24774a.f24798g);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_avatar_url", this.f24774a.f24797f);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_bduss", this.f24774a.f24793b);
                    c.a.o0.a.k2.g.h.a().putString("bd_box_ptoken", this.f24774a.f24799h);
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new b(this), this.f24774a.f24793b);
                    return;
                } catch (Exception e2) {
                    if (f24773e) {
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
        this.f24776c = new C1146a(this, 2921537);
        this.f24775b = new ArrayList();
    }
}
