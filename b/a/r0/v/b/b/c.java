package b.a.r0.v.b.b;

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
import b.a.p0.a.z2.x;
import b.a.p0.b.h;
import b.a.p0.b.l.a0;
import b.a.p0.b.l.b0;
import b.a.p0.b.l.l;
import b.a.p0.b.l.z;
import b.a.p0.b.m.a;
import b.a.p0.b.n.b;
import b.a.p0.b.q.a;
import b.a.p0.w.f;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@Service
/* loaded from: classes5.dex */
public class c implements b.a.p0.b.l.c0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseDialog f25615a;

    /* loaded from: classes5.dex */
    public class a extends GetTplStokenCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l.a f25616e;

        public a(c cVar, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25616e = aVar;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f25616e) == null) {
                return;
            }
            aVar.onFinish();
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            l.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.f25616e) == null) {
                return;
            }
            aVar.onStart();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, getTplStokenResult) == null) || this.f25616e == null) {
                return;
            }
            l lVar = new l();
            if (getTplStokenResult != null) {
                lVar.f9929b = getTplStokenResult.tplStokenMap;
                lVar.f9928a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.f25616e.a(lVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, getTplStokenResult) == null) || this.f25616e == null) {
                return;
            }
            l lVar = new l();
            if (getTplStokenResult != null) {
                lVar.f9929b = getTplStokenResult.tplStokenMap;
                lVar.f9928a = getTplStokenResult.getResultCode();
                getTplStokenResult.getResultMsg();
                GetTplStokenResult.FailureType failureType = getTplStokenResult.failureType;
                if (failureType != null) {
                    failureType.name();
                }
            }
            this.f25616e.b(lVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends SmsViewLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppPhoneLoginDialog.g f25617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f25618f;

        /* loaded from: classes5.dex */
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

        /* renamed from: b.a.r0.v.b.b.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class DialogInterface$OnClickListenerC1242b implements DialogInterface.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f25619e;

            /* renamed from: b.a.r0.v.b.b.c$b$b$a */
            /* loaded from: classes5.dex */
            public class a implements b.a.p0.a.m.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DialogInterface$OnClickListenerC1242b f25620e;

                public a(DialogInterface$OnClickListenerC1242b dialogInterface$OnClickListenerC1242b) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dialogInterface$OnClickListenerC1242b};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f25620e = dialogInterface$OnClickListenerC1242b;
                }

                @Override // b.a.p0.a.m.a
                public void onResult(int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                        if (i2 == 0) {
                            this.f25620e.f25619e.f25617e.onSuccess();
                        } else {
                            this.f25620e.f25619e.f25617e.onFailure();
                        }
                    }
                }
            }

            public DialogInterface$OnClickListenerC1242b(b bVar) {
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
                this.f25619e = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                    b.a.p0.b.l.a.M((FragmentActivity) this.f25619e.f25618f, false, null, new a(this));
                }
            }
        }

        /* renamed from: b.a.r0.v.b.b.c$b$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1243c implements b.a.p0.a.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f25621e;

            public C1243c(b bVar) {
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
                this.f25621e = bVar;
            }

            @Override // b.a.p0.a.m.a
            public void onResult(int i2) {
                SwanAppPhoneLoginDialog.g gVar;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (gVar = this.f25621e.f25617e) == null) {
                    return;
                }
                if (i2 == 0) {
                    gVar.onSuccess();
                } else {
                    gVar.onFailure();
                }
            }
        }

        public b(c cVar, SwanAppPhoneLoginDialog.g gVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, gVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25617e = gVar;
            this.f25618f = context;
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewHide() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25617e.b();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onCheckCodeViewShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f25617e.a();
            }
        }

        @Override // com.baidu.sapi2.callback.SmsViewLoginCallback
        public void onNeedBack(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                Context context = this.f25618f;
                x.a(context, ((FragmentActivity) context).getWindow().getDecorView().getWindowToken());
                String string = this.f25618f.getResources().getString(h.account_login_dialog_needback_other);
                String string2 = this.f25618f.getResources().getString(h.account_login_dialog_needback_positive_btn_login);
                if (webAuthResult.getResultCode() == 12) {
                    string = this.f25618f.getResources().getString(h.account_login_dialog_needback_phone);
                    string2 = this.f25618f.getResources().getString(h.account_login_dialog_needback_positive_btn_register);
                }
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(this.f25618f);
                aVar.V(this.f25618f.getResources().getString(h.account_login_dialog_needback_title));
                aVar.x(string);
                aVar.P(string2, new DialogInterface$OnClickListenerC1242b(this));
                aVar.C(this.f25618f.getResources().getString(h.account_login_dialog_needback_negative_btn), new a(this));
                aVar.X();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.f25617e.onFailure();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, webAuthResult) == null) {
                b.a.r0.v.b.b.a.l().x(new C1243c(this));
            }
        }
    }

    /* renamed from: b.a.r0.v.b.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1244c extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.b.p.d.e f25622a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f25623b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f25624c;

        /* renamed from: b.a.r0.v.b.b.c$c$a */
        /* loaded from: classes5.dex */
        public class a implements b.a.p0.a.m.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1244c f25625e;

            public a(C1244c c1244c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1244c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25625e = c1244c;
            }

            @Override // b.a.p0.a.m.a
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 0) {
                        this.f25625e.f25622a.onResult(0);
                    } else {
                        this.f25625e.f25622a.onResult(-1);
                    }
                    C1244c c1244c = this.f25625e;
                    c1244c.f25624c.q(c1244c.f25623b);
                }
            }
        }

        public C1244c(c cVar, b.a.p0.b.p.d.e eVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25624c = cVar;
            this.f25622a = eVar;
            this.f25623b = activity;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.f25622a.onResult(-1);
                this.f25624c.q(this.f25623b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
                this.f25622a.onResult(-1);
                this.f25624c.q(this.f25623b);
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                b.a.r0.v.b.b.a.l().x(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f25626a;

        public d(c cVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25626a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                this.f25626a.onFailure(sapiResult.getResultMsg());
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                z zVar = new z();
                if (sapiResult instanceof RealNameFaceIDResult) {
                    zVar.f9944a = ((RealNameFaceIDResult) sapiResult).callBackKey;
                    this.f25626a.a(zVar);
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    zVar.f9944a = ((UnRealNameFaceIDResult) sapiResult).registerResult;
                    this.f25626a.a(zVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends AccountRealNameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b0 f25627a;

        public e(c cVar, b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25627a = b0Var;
        }

        @Override // com.baidu.sapi2.callback.AccountRealNameCallback
        public void onFinish(AccountRealNameResult accountRealNameResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountRealNameResult) == null) {
                super.onFinish(accountRealNameResult);
                if (accountRealNameResult.getResultCode() == 0) {
                    z zVar = new z();
                    if (accountRealNameResult.seniorRealNameSuc) {
                        zVar.f9944a = accountRealNameResult.callbackkey;
                        this.f25627a.a(zVar);
                        return;
                    }
                }
                this.f25627a.onFailure(accountRealNameResult.getResultMsg());
            }
        }
    }

    public c() {
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

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? CommonParam.getCUID(context) : (String) invokeL.objValue;
    }

    public static String r(Context context, String str) {
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

    @Override // b.a.p0.b.l.c0.a
    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? b.a.p0.a.o2.g.h.a().getString("bd_box_ptoken", "") : (String) invokeL.objValue;
    }

    @Override // b.a.p0.b.l.c0.a
    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? b.a.r0.v.b.b.a.l().p() : (String) invokeL.objValue;
    }

    @Override // b.a.p0.b.l.c0.a
    public void c(Context context, Bundle bundle, b.a.p0.a.m.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, bundle, aVar) == null) {
            b.a.r0.v.b.b.a.l().t(context, bundle, aVar);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public a0 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            a0 a0Var = new a0();
            a0Var.f9924a = b.a.r0.v.b.b.a.l().k();
            a0Var.f9925b = b.a.r0.v.b.b.a.l().i();
            return a0Var;
        }
        return (a0) invokeL.objValue;
    }

    @Override // b.a.p0.b.l.c0.a
    public void e(Activity activity, String str, String str2, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, activity, str, str2, b0Var) == null) {
            RealNameDTO realNameDTO = new RealNameDTO();
            realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            realNameDTO.scene = str;
            realNameDTO.needCbKey = true;
            PassportSDK.getInstance().loadAccountRealName(activity, new e(this, b0Var), realNameDTO);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public void f(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, dVar) == null) {
            b.a.r0.v.b.b.a.l().h(context, "1", dVar);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) ? b.a.r0.v.b.b.a.l().s() : invokeL.booleanValue;
    }

    @Override // b.a.p0.b.l.c0.a
    public String getBduss(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) ? b.a.r0.v.b.b.a.l().j() : (String) invokeL.objValue;
    }

    @Override // b.a.p0.b.l.c0.a
    public void h(b.a.p0.a.m.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            b.a.r0.v.b.b.a.l().f(cVar);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public void i(Context context, a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, dVar) == null) {
            b.a.r0.v.b.b.a.l().g(context, "1", dVar);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public void j(Context context, SwanAppPhoneLoginDialog.g gVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, gVar, str) == null) {
            PassportSDK.getInstance().startSmsViewLogin(new b(this, gVar, context), str);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("aps_identity", 0);
            String string = sharedPreferences.getString("uid_v3", "");
            if (TextUtils.isEmpty(string)) {
                String p = p(context);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("uid_v3", p);
                edit.apply();
                return p;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @Override // b.a.p0.b.l.c0.a
    public void l(Activity activity, String str, String str2, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, activity, str, str2, b0Var) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str2;
            PassportSDK.getInstance().verifyUserFaceId(activity, new d(this, b0Var), faceIDVerifyDTO);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public void m(Activity activity, String str, b.a.p0.b.p.d.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, str, eVar) == null) {
            s(activity);
            PassportSDK.getInstance().loadOneKeyLogin(activity, r(activity, str), new C1244c(this, eVar, activity));
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public void n(String str, ArrayList<String> arrayList, b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, arrayList, cVar) == null) {
            b.a.r0.v.b.b.a.l().n(str, arrayList, cVar);
        }
    }

    @Override // b.a.p0.b.l.c0.a
    public void o(l.a aVar, String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, aVar, str, list) == null) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(this, aVar), str, list);
        }
    }

    public void q(Context context) {
        BaseDialog baseDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, context) == null) || !(context instanceof Activity) || ((Activity) context).isFinishing() || (baseDialog = this.f25615a) == null) {
            return;
        }
        baseDialog.dismiss();
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            BaseDialog baseDialog = new BaseDialog(context, 16973833);
            this.f25615a = baseDialog;
            Window window = baseDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(17170445);
                window.setDimAmount(0.0f);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = context.getResources().getDimensionPixelSize(R.dimen.account_loading_height);
                attributes.width = -1;
                window.setAttributes(attributes);
            }
            this.f25615a.setCanceledOnTouchOutside(false);
            this.f25615a.setCancelable(false);
            this.f25615a.setEnableImmersion(true);
            this.f25615a.setContentView(R.layout.loading_layout);
            View findViewById = this.f25615a.findViewById(R.id.root_container);
            ProgressBar progressBar = (ProgressBar) this.f25615a.findViewById(R.id.loading_bar);
            TextView textView = (TextView) this.f25615a.findViewById(R.id.message);
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
            this.f25615a.show();
        }
    }
}
