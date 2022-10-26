package com.baidu.sapi2.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BindVerifyActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 403;
    public static final int B = 404;
    public static final int C = 405;
    public static final int D = 406;
    public static final int E = 407;
    public static final String b = "cmd";
    public static final String c = "taskId";
    public static final String d = "resultCode";
    public static final String e = "login";
    public static final String f = "bindphone";
    public static final String g = "normalize";
    public static final int h = 101;
    public static final int i = 102;
    public static final int j = 200;
    public static final int k = 201;
    public static final int l = 202;
    public static final int m = 203;
    public static final int n = 204;
    public static final int o = 205;
    public static final int p = 206;
    public static final int q = 300;
    public static final int r = 301;
    public static final int s = 302;
    public static final int t = 303;
    public static final int u = 304;
    public static final int v = 305;
    public static final int w = 306;
    public static final int x = 400;
    public static final int y = 401;
    public static final int z = 402;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent a;

    public BindVerifyActivity() {
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

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                int intExtra = this.a.getIntExtra("taskId", -1);
                if (intExtra == -1) {
                    return;
                }
                ((ActivityManager) getSystemService("activity")).moveTaskToFront(intExtra, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            CoreViewRouter.getInstance().startLogin(this, new WebAuthListener(this) { // from class: com.baidu.sapi2.activity.BindVerifyActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindVerifyActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                        int resultCode = webAuthResult.getResultCode();
                        if (resultCode != -801) {
                            if (resultCode != -301) {
                                if (resultCode != -201) {
                                    if (resultCode != -204) {
                                        if (resultCode != -203) {
                                            this.a.a(206);
                                        } else {
                                            this.a.a(203);
                                        }
                                    } else {
                                        this.a.a(205);
                                    }
                                } else {
                                    this.a.a(202);
                                }
                            } else {
                                this.a.a(201);
                            }
                        } else {
                            this.a.a(204);
                        }
                        this.a.finish();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, webAuthResult) == null) {
                        try {
                            SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                        } catch (Exception unused) {
                            Log.e(Log.TAG, new Object[0]);
                        }
                        this.a.a(200);
                        this.a.finish();
                    }
                }
            }, new WebLoginDTO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            a();
            Bundle extras = this.a.getExtras();
            extras.putInt("resultCode", i2);
            this.a.putExtras(extras);
            setResult(-1, this.a);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            this.a = intent;
            if (intent == null) {
                finish();
            } else {
                a(intent.getStringExtra("cmd"));
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                a(101);
                finish();
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -914671791) {
                if (hashCode != 103149417) {
                    if (hashCode == 236609293 && str.equals(g)) {
                        c2 = 2;
                    }
                } else if (str.equals("login")) {
                    c2 = 0;
                }
            } else if (str.equals(f)) {
                c2 = 1;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        a(102);
                        finish();
                        return;
                    }
                    d();
                    return;
                }
                b();
                return;
            }
            c();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            WebBindWidgetDTO webBindWidgetDTO = new WebBindWidgetDTO();
            webBindWidgetDTO.bindWidgetAction = BindWidgetAction.BIND_MOBILE;
            SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
            if (sapiAccountManager == null) {
                a(305);
                finish();
                return;
            }
            SapiAccount session = sapiAccountManager.getSession();
            if (sapiAccountManager.getSession() == null) {
                a(305);
                finish();
                return;
            }
            webBindWidgetDTO.bduss = session.bduss;
            CoreViewRouter.getInstance().loadBindWidget(new WebBindWidgetCallback(this) { // from class: com.baidu.sapi2.activity.BindVerifyActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindVerifyActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.WebBindWidgetCallback
                public void onFinish(WebBindWidgetResult webBindWidgetResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, webBindWidgetResult) == null) {
                        int resultCode = webBindWidgetResult.getResultCode();
                        if (resultCode != -801) {
                            if (resultCode != -301) {
                                if (resultCode != -201) {
                                    if (resultCode != 0) {
                                        if (resultCode != -204) {
                                            if (resultCode != -203) {
                                                this.a.a(306);
                                            } else {
                                                this.a.a(303);
                                            }
                                        } else {
                                            this.a.a(305);
                                        }
                                    } else {
                                        this.a.a(300);
                                    }
                                } else {
                                    this.a.a(302);
                                }
                            } else {
                                this.a.a(301);
                            }
                        } else {
                            this.a.a(304);
                        }
                        this.a.finish();
                    }
                }
            }, webBindWidgetDTO);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            NormalizeGuestAccountDTO normalizeGuestAccountDTO = new NormalizeGuestAccountDTO();
            SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
            if (sapiAccountManager == null) {
                a(405);
                finish();
                return;
            }
            SapiAccount session = sapiAccountManager.getSession();
            if (sapiAccountManager.getSession() == null) {
                a(405);
                finish();
                return;
            }
            normalizeGuestAccountDTO.bduss = session.bduss;
            CoreViewRouter.getInstance().startNormalizeGuestAccount(this, new NormalizeGuestAccountCallback(this) { // from class: com.baidu.sapi2.activity.BindVerifyActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindVerifyActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.NormalizeGuestAccountCallback
                public void onSuccess(NormalizeGuestAccountResult normalizeGuestAccountResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, normalizeGuestAccountResult) != null) {
                        return;
                    }
                    this.a.a(400);
                    this.a.finish();
                }

                @Override // com.baidu.sapi2.callback.NormalizeGuestAccountCallback
                public void onFailure(NormalizeGuestAccountResult normalizeGuestAccountResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, normalizeGuestAccountResult) == null) {
                        int resultCode = normalizeGuestAccountResult.getResultCode();
                        if (resultCode != -801) {
                            if (resultCode != -601) {
                                if (resultCode != -301) {
                                    if (resultCode != -201) {
                                        if (resultCode != -204) {
                                            if (resultCode != -203) {
                                                this.a.a(407);
                                            } else {
                                                this.a.a(403);
                                            }
                                        } else {
                                            this.a.a(405);
                                        }
                                    } else {
                                        this.a.a(402);
                                    }
                                } else {
                                    this.a.a(401);
                                }
                            } else {
                                this.a.a(406);
                            }
                        } else {
                            this.a.a(404);
                        }
                        this.a.finish();
                    }
                }
            }, normalizeGuestAccountDTO);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            setResult(i3, intent);
        }
    }
}
