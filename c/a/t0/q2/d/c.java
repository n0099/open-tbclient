package c.a.t0.q2.d;

import android.app.Activity;
import android.text.TextUtils;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f22324c;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public e f22325b;

    /* loaded from: classes8.dex */
    public class a implements SapiCallback<CheckUserFaceIdResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SapiAccount f22326e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f22327f;

        public a(c cVar, SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, sapiAccount};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22327f = cVar;
            this.f22326e = sapiAccount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, checkUserFaceIdResult) == null) {
                if (checkUserFaceIdResult != null) {
                    n.M(TbadkCoreApplication.getInst(), checkUserFaceIdResult.getResultMsg());
                }
                if (this.f22327f.f22325b != null) {
                    this.f22327f.f22325b.onFail();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(CheckUserFaceIdResult checkUserFaceIdResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, checkUserFaceIdResult) == null) {
                int i2 = checkUserFaceIdResult.status;
                if (i2 == 1) {
                    if (!TextUtils.isEmpty(checkUserFaceIdResult.livingUname)) {
                        BdLog.e("非实名人脸验证流程");
                        this.f22327f.e(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.livingUname, this.f22326e.bduss);
                        return;
                    }
                    BdLog.e("实名人脸验证流程");
                    this.f22327f.e(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, "", this.f22326e.bduss);
                } else if (i2 == 2) {
                    BdLog.e("人脸注册流程");
                    this.f22327f.j(false, false, FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE, checkUserFaceIdResult.authsid, checkUserFaceIdResult.livingUname, checkUserFaceIdResult.authWidgetURL);
                } else if (i2 == 3) {
                    BdLog.e("人脸验证不可用");
                    n.M(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                    if (this.f22327f.f22325b != null) {
                        this.f22327f.f22325b.c();
                    }
                } else {
                    BdLog.e("人脸验证不可用");
                    n.M(TbadkCoreApplication.getInst(), "刷脸功能暂不可用，请您稍后再试");
                    if (this.f22327f.f22325b != null) {
                        this.f22327f.f22325b.c();
                    }
                }
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

    /* loaded from: classes8.dex */
    public class b extends VerifyUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f22328b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f22329c;

        public b(c cVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22329c = cVar;
            this.a = z;
            this.f22328b = z2;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                if (sapiResult != null && sapiResult.getResultCode() != -204 && !StringHelper.equals("用户取消操作", sapiResult.getResultMsg())) {
                    n.M(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
                }
                if (this.f22329c.f22325b != null) {
                    this.f22329c.f22325b.b(sapiResult instanceof RealNameFaceIDResult, false, null);
                }
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) {
                if (sapiResult instanceof RealNameFaceIDResult) {
                    RealNameFaceIDResult realNameFaceIDResult = (RealNameFaceIDResult) sapiResult;
                    BdLog.d("实名人脸验证成功,callBackKey:" + realNameFaceIDResult.callBackKey + ",authSid:" + realNameFaceIDResult.authSid);
                    n.M(TbadkCoreApplication.getInst(), "刷脸验证成功");
                    if (this.f22329c.f22325b != null) {
                        this.f22329c.f22325b.b(true, true, realNameFaceIDResult.callBackKey);
                    }
                    if (this.a) {
                        this.f22329c.h(this.f22328b, realNameFaceIDResult.callBackKey);
                    }
                } else if (sapiResult instanceof UnRealNameFaceIDResult) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("非实名人脸验证成功 callBackKey");
                    UnRealNameFaceIDResult unRealNameFaceIDResult = (UnRealNameFaceIDResult) sapiResult;
                    sb.append(unRealNameFaceIDResult.registerResult);
                    BdLog.d(sb.toString());
                    n.M(TbadkCoreApplication.getInst(), "刷脸验证成功");
                    if (this.f22329c.f22325b != null) {
                        this.f22329c.f22325b.b(false, true, unRealNameFaceIDResult.callBackKey);
                    }
                    if (this.a) {
                        this.f22329c.h(this.f22328b, unRealNameFaceIDResult.callBackKey);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.t0.q2.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1336c extends RegisterUserFaceIDCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f22330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f22331c;

        public C1336c(c cVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22331c = cVar;
            this.a = z;
            this.f22330b = z2;
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
                if (sapiResult != null && sapiResult.getResultCode() != -204 && !StringHelper.equals("用户取消操作", sapiResult.getResultMsg())) {
                    n.M(TbadkCoreApplication.getInst(), sapiResult.getResultMsg());
                }
                if (this.f22331c.f22325b != null) {
                    this.f22331c.f22325b.a(false, null);
                }
            }
        }

        @Override // com.baidu.sapi2.callback.FaceIDCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiResult) == null) && (sapiResult instanceof UnRealNameFaceIDResult)) {
                StringBuilder sb = new StringBuilder();
                sb.append("人脸注册结果");
                UnRealNameFaceIDResult unRealNameFaceIDResult = (UnRealNameFaceIDResult) sapiResult;
                sb.append(unRealNameFaceIDResult.registerResult);
                BdLog.d(sb.toString());
                n.M(TbadkCoreApplication.getInst(), "刷脸注册成功");
                if (this.f22331c.f22325b != null) {
                    this.f22331c.f22325b.a(true, unRealNameFaceIDResult.callBackKey);
                }
                if (this.a) {
                    this.f22331c.h(this.f22330b, unRealNameFaceIDResult.callBackKey);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements SapiCallback<SapiResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f22332e;

        public d(c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22332e = z;
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(SapiResult sapiResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sapiResult) == null) {
                BdLog.d("faceLginSwitch onSuccess()" + sapiResult.getResultCode());
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(boolean z, String str);

        void b(boolean z, boolean z2, String str);

        void c();

        void onFail();
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

    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f22324c == null) {
                synchronized (c.class) {
                    if (f22324c == null) {
                        f22324c = new c();
                    }
                }
            }
            return f22324c;
        }
        return (c) invokeV.objValue;
    }

    public final void e(boolean z, boolean z2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3}) == null) {
            FaceIDVerifyDTO faceIDVerifyDTO = new FaceIDVerifyDTO();
            faceIDVerifyDTO.livingUname = str2;
            faceIDVerifyDTO.businessSence = str;
            faceIDVerifyDTO.bduss = str3;
            faceIDVerifyDTO.showGuidePage = false;
            PassportSDK.getInstance().verifyUserFaceId(this.a, new b(this, z, z2), faceIDVerifyDTO);
        }
    }

    public final void f() {
        SapiAccount session;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (session = SapiAccountManager.getInstance().getSession()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scene", FaceBaseDTO.BUSINESS_SENCE_REALNAME_FACE);
        SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new a(this, session), session.bduss, hashMap);
    }

    public void g(Activity activity, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, eVar) == null) {
            this.a = activity;
            this.f22325b = eVar;
            f();
        }
    }

    public final void h(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            SapiAccountManager.getInstance().getAccountService().faceLoginSwitch(new d(this, z), SapiAccountManager.getInstance().getSession().bduss, !z, str);
        }
    }

    public final void j(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4}) == null) {
            FaceIDRegDTO faceIDRegDTO = new FaceIDRegDTO();
            faceIDRegDTO.authsid = str2;
            faceIDRegDTO.livingUname = str3;
            faceIDRegDTO.businessSence = str;
            faceIDRegDTO.authWidgetURL = str4;
            faceIDRegDTO.showGuidePage = true;
            PassportSDK.getInstance().registerUserFaceID(this.a, new C1336c(this, z, z2), faceIDRegDTO);
        }
    }

    public void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.f22325b = eVar;
        }
    }
}
