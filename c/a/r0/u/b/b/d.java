package c.a.r0.u.b.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import c.a.p0.a.v2.x;
import c.a.p0.b.h;
import c.a.p0.b.l.a0;
import c.a.p0.b.l.b0;
import c.a.p0.b.l.l;
import c.a.p0.b.l.z;
import c.a.p0.b.m.a;
import c.a.p0.b.n.b;
import c.a.p0.b.q.a;
import c.a.p0.t.f;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.res.widget.dialog.BaseDialog;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes3.dex */
public class d implements c.a.p0.b.l.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseDialog f25139a;

    /* loaded from: classes3.dex */
    public class a extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f25140e;

        public a(d dVar, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25140e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f25140e) == null) {
                return;
            }
            aVar.onFinish();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f25140e) == null) {
                return;
            }
            aVar.onStart();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) || this.f25140e == null) {
                return;
            }
            l lVar = new l();
            if (getTplStokenResult != null) {
                lVar.f10121b = getTplStokenResult.tplStokenMap;
                lVar.f10120a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.f25140e.a(lVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, getTplStokenResult) == null) || this.f25140e == null) {
                return;
            }
            l lVar = new l();
            if (getTplStokenResult != null) {
                lVar.f10121b = getTplStokenResult.tplStokenMap;
                lVar.f10120a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.f25140e.b(lVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends SmsViewLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f25141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f25142f;

        /* loaded from: classes3.dex */
        public class a implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                }
            }
        }

        /* renamed from: c.a.r0.u.b.b.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class DialogInterface$OnClickListenerC1168b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f25143e;

            /* renamed from: c.a.r0.u.b.b.d$b$b$a */
            /* loaded from: classes3.dex */
            public class a implements c.a.p0.a.m.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DialogInterface$OnClickListenerC1168b f25144e;

                public a(DialogInterface$OnClickListenerC1168b dialogInterface$OnClickListenerC1168b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogInterface$OnClickListenerC1168b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25144e = dialogInterface$OnClickListenerC1168b;
                }

                @Override // c.a.p0.a.m.a
                public void onResult(int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                        if (i2 == 0) {
                            this.f25144e.f25143e.f25141e.onSuccess();
                        } else {
                            this.f25144e.f25143e.f25141e.onFailure();
                        }
                    }
                }
            }

            public DialogInterface$OnClickListenerC1168b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25143e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    c.a.p0.b.l.a.N((FragmentActivity) this.f25143e.f25142f, false, null, new a(this));
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements c.a.p0.a.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f25145e;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25145e = bVar;
            }

            @Override // c.a.p0.a.m.a
            public void onResult(int i2) {
                SwanAppPhoneLoginDialog.g gVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (gVar = this.f25145e.f25141e) == null) {
                    return;
                }
                if (i2 == 0) {
                    gVar.onSuccess();
                } else {
                    gVar.onFailure();
                }
            }
        }

        public b(d dVar, SwanAppPhoneLoginDialog.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25141e = gVar;
            this.f25142f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25141e.b();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f25141e.a();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                Context context = this.f25142f;
                x.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
                String string = this.f25142f.getResources().getString(h.account_login_dialog_needback_other);
                String string2 = this.f25142f.getResources().getString(h.account_login_dialog_needback_positive_btn_login);
                if (webAuthResult.getResultCode() == 12) {
                    string = this.f25142f.getResources().getString(h.account_login_dialog_needback_phone);
                    string2 = this.f25142f.getResources().getString(h.account_login_dialog_needback_positive_btn_register);
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f25142f);
                aVar.V(this.f25142f.getResources().getString(h.account_login_dialog_needback_title));
                aVar.x(string);
                aVar.P(string2, new DialogInterface$OnClickListenerC1168b(this));
                aVar.C(this.f25142f.getResources().getString(h.account_login_dialog_needback_negative_btn), new a(this));
                aVar.X();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.f25141e.onFailure();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, webAuthResult) == null) {
                c.a.r0.u.b.b.a.l().x(new c(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.b.p.g.e f25146a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f25147b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f25148c;

        /* loaded from: classes3.dex */
        public class a implements c.a.p0.a.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f25149e;

            public a(c cVar) {
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
                this.f25149e = cVar;
            }

            @Override // c.a.p0.a.m.a
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 0) {
                        this.f25149e.f25146a.onResult(0);
                    } else {
                        this.f25149e.f25146a.onResult(-1);
                    }
                    c cVar = this.f25149e;
                    cVar.f25148c.r(cVar.f25147b);
                }
            }
        }

        public c(d dVar, c.a.p0.b.p.g.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25148c = dVar;
            this.f25146a = eVar;
            this.f25147b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.f25146a.onResult(-1);
                this.f25148c.r(this.f25147b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.f25146a.onResult(-1);
                this.f25148c.r(this.f25147b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                c.a.r0.u.b.b.a.l().x(new a(this));
            }
        }
    }

    /* renamed from: c.a.r0.u.b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1169d extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f25150a;

        public C1169d(d dVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25150a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f25150a.onFailure(sapiResult.getResultMsg());
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                z zVar = new z();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    zVar.f10136a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    this.f25150a.a(zVar);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    zVar.f10136a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    this.f25150a.a(zVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f25151a;

        public e(d dVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25151a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    z zVar = new z();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        zVar.f10136a = accountRealNameResult.callbackkey;
                        this.f25151a.a(zVar);
                        return;
                    }
                }
                this.f25151a.onFailure(accountRealNameResult.getResultMsg());
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? CommonParam.getCUID(context) : (String) invokeL.objValue;
    }

    public static String s(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(context).toUpperCase();
            return substring + f.d((substring2 + f.d(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? c.a.p0.a.k2.g.h.a().getString("bd_box_ptoken", "") : (String) invokeL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? c.a.r0.u.b.b.a.l().p() : (String) invokeL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public void c(Context context, Bundle bundle, c.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, bundle, aVar) == null) {
            c.a.r0.u.b.b.a.l().t(context, bundle, aVar);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public a0 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            a0 a0Var = new a0();
            a0Var.f10116a = c.a.r0.u.b.b.a.l().k();
            a0Var.f10117b = c.a.r0.u.b.b.a.l().i();
            return a0Var;
        }
        return (a0) invokeL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? TbadkCoreApplication.getInst().getZid() : (String) invokeL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public void f(Activity activity, String str, String str2, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, activity, str, str2, b0Var) == null) {
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = str;
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public void g(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, dVar) == null) {
            c.a.r0.u.b.b.a.l().h(context, "1", dVar);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public String getBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? c.a.r0.u.b.b.a.l().j() : (String) invokeL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) ? c.a.r0.u.b.b.a.l().s() : invokeL.booleanValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public void i(c.a.p0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            c.a.r0.u.b.b.a.l().f(cVar);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public void j(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, dVar) == null) {
            c.a.r0.u.b.b.a.l().g(context, "1", dVar);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public void k(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, context, gVar, str) == null) {
            PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
            String string = sharedPreferences.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                String q = q(context);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("uid_v3", q);
                edit.apply();
                return q;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.p0.b.l.c0.a
    public void m(Activity activity, String str, String str2, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, activity, str, str2, b0Var) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str2;
            PassportSDK.getInstance().verifyUserFaceId(activity, new C1169d(this, b0Var), faceIDVerifyDTO);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public void n(Activity activity, String str, c.a.p0.b.p.g.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, activity, str, eVar) == null) {
            t(activity);
            PassportSDK.getInstance().loadOneKeyLogin(activity, s(activity, str), new c(this, eVar, activity));
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public void o(String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, arrayList, cVar) == null) {
            c.a.r0.u.b.b.a.l().n(str, arrayList, cVar);
        }
    }

    @Override // c.a.p0.b.l.c0.a
    public void p(l.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, aVar, str, list) == null) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
        }
    }

    public void r(Context context) {
        BaseDialog baseDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, context) == null) || !(context instanceof Activity) || ((Activity) context).isFinishing() || (baseDialog = this.f25139a) == null) {
            return;
        }
        baseDialog.dismiss();
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            BaseDialog baseDialog = new BaseDialog(context, 16973833);
            this.f25139a = baseDialog;
            Window window = baseDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
                attributes.width = -1;
                window.setAttributes(attributes);
            }
            this.f25139a.setCanceledOnTouchOutside(false);
            this.f25139a.setCancelable(false);
            this.f25139a.setEnableImmersion(true);
            this.f25139a.setContentView(R.layout.loading_layout);
            View findViewById = this.f25139a.findViewById(R.id.root_container);
            ProgressBar progressBar = (ProgressBar) this.f25139a.findViewById(R.id.loading_bar);
            TextView textView = (TextView) this.f25139a.findViewById(R.id.message);
            if (findViewById != null) {
                findViewById.setBackground(findViewById.getResources().getDrawable(R.drawable.novel_loading_bg));
            }
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(progressBar.getResources().getDrawable(R.drawable.loading_progress_animation));
            }
            if (textView != null) {
                textView.setTextColor(textView.getResources().getColor(R.color.loading_text_color));
                textView.setText(R.string.account_onekey_loading);
            }
            this.f25139a.show();
        }
    }
}
