package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.widget.DatePicker;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.IdcardOcrImageRusult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.stat.TouchidLoginStat;
import com.baidu.sapi2.touchid.FingerprintUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import com.tachikoma.core.component.input.InputType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SapiJsInterpreters {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SapiJsInterpreters";
    public transient /* synthetic */ FieldHolder $fh;
    public SapiConfiguration configuration;
    public Context context;
    public HashMap<String, AbstractInterpreter> interpreterHashMap;
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public long preShareClickTime;
    public SapiWebView sapiWebView;

    /* loaded from: classes4.dex */
    public abstract class AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        public AbstractInterpreter(SapiJsInterpreters sapiJsInterpreters) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        public abstract String interpret(SapiWebView.Command command);
    }

    /* loaded from: classes4.dex */
    public class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionBindWidgetPhoneNumberExist(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String str = command.getActionParams().get(0);
                if (this.this$0.jsCallBacks.bindWidgetCallback != null) {
                    this.this$0.jsCallBacks.bindWidgetCallback.onPhoneNumberExist(str);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionFaceLoginSwitch extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionFaceLoginSwitch(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    String optString = new JSONObject(command.getActionParams().get(0)).optString("livinguname");
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    new FaceLoginService().syncFaceLoginUID(this.this$0.context, optString);
                    return null;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionForgetPwd extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionForgetPwd(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                return this.this$0.jsCallBacks.authorizationListener != null ? this.this$0.jsCallBacks.authorizationListener.onForgetPwd() : false ? "1" : "0";
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionGenerateSign extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionGenerateSign(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String str = command.getActionParams().get(0);
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.optString(next));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return SapiUtils.calculateSig(hashMap, this.this$0.configuration.appSignKey);
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionGetLoadtime extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionGetLoadtime(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiWebView unused = this.this$0.sapiWebView;
                if (SapiWebView.statLoadLogin != null) {
                    SapiWebView unused2 = this.this$0.sapiWebView;
                    return SapiWebView.statLoadLogin.toJSON().toString();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionGetSmsCheckCodeFromClip(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String str = "";
                try {
                    ClipboardManager clipboardManager = (ClipboardManager) this.this$0.context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                    if (clipboardManager.hasPrimaryClip()) {
                        str = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
                SapiStatUtil.statSmsCodeClip(this.this$0.context, TextUtils.isEmpty(str) ? "0" : "1");
                return str;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionGloryLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionGloryLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.GLORY;
                    Message message = new Message();
                    message.what = SocialType.GLORY.getType();
                    message.obj = SocialType.GLORY;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionHuaweiLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionHuaweiLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
                    Message message = new Message();
                    message.what = SocialType.HUAWEI.getType();
                    message.obj = SocialType.HUAWEI;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionJoinLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionJoinLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    Object[] pkgIconAndName = SapiUtils.getPkgIconAndName(this.this$0.context, this.this$0.context.getPackageName());
                    jSONObject.put("icon", pkgIconAndName[0]);
                    jSONObject.put("name", pkgIconAndName[1]);
                    List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
                    Object obj = "false";
                    if (this.this$0.jsCallBacks.shareAccountClickCallback != null && shareStorageModel != null && shareStorageModel.size() > 0) {
                        jSONObject.put("openShareLogin", "true");
                    } else {
                        jSONObject.put("openShareLogin", "false");
                    }
                    if (this.this$0.jsCallBacks.joinLoginParams != null) {
                        obj = this.this$0.jsCallBacks.joinLoginParams.hasThirdAccount + "";
                    }
                    jSONObject.put("hasThirdAccount", obj);
                    jSONObject.put("supportFaceLogin", new FaceLoginService().isSupFaceLogin());
                    if (this.this$0.jsCallBacks.joinLoginParams != null && this.this$0.jsCallBacks.joinLoginParams.agreement != null) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.this$0.jsCallBacks.joinLoginParams.agreement.keySet()) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str);
                            jSONObject2.put("url", this.this$0.jsCallBacks.joinLoginParams.agreement.get(str));
                            jSONArray.put(jSONObject2);
                        }
                        jSONObject.put("agreement", jSONArray);
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionLoadExternalWebview extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionLoadExternalWebview(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.loadExternalWebViewCallback != null) {
                    SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
                    loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
                    loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
                    this.this$0.jsCallBacks.loadExternalWebViewCallback.loadExternalWebview(loadExternalWebViewResult);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionLoadSlideWebview extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionLoadSlideWebview(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.loadSlideWebViewCallback != null) {
                    SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult = new SapiWebView.LoadSlideWebViewResult();
                    try {
                        JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                        loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                        loadSlideWebViewResult.url = jSONObject.optString("url");
                        loadSlideWebViewResult.page = jSONObject.optString("page");
                        loadSlideWebViewResult.adapter = jSONObject.optString("adapter");
                        this.this$0.jsCallBacks.loadSlideWebViewCallback.loadSlideWebview(loadSlideWebViewResult);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("errno", "0");
                        return jSONObject2.toString();
                    } catch (JSONException e2) {
                        Log.e(e2);
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionRemoveShareAccount extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionRemoveShareAccount(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionSetTitle extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSetTitle(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String str = command.getActionParams().get(0);
                if (this.this$0.jsCallBacks.webViewTitleCallback != null) {
                    this.this$0.jsCallBacks.webViewTitleCallback.onTitleChange(str);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionShareAccountsViewBtnClicked(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.quickLoginHandler != null) {
                    this.this$0.jsCallBacks.quickLoginHandler.handleOtherLogin();
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionShareClickOther extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionShareClickOther(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiStatUtil.statShareClickOther(command.getActionParams().get(0), this.this$0.sapiWebView.extras);
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionShareV2Login extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionShareV2Login(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) ? this.this$0.jsCallBacks.shareV2LoginParams.pageParams.toString() : (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionShareV2LoginClick extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionShareV2LoginClick(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                this.this$0.jsCallBacks.shareV2LoginParams.onSuccess();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionShareV2LoginFail extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionShareV2LoginFail(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                this.this$0.jsCallBacks.shareV2LoginParams.onError();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionSocialMeizuSso extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSocialMeizuSso(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
                    Message message = new Message();
                    message.what = SocialType.MEIZU.getType();
                    message.obj = SocialType.MEIZU;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionSocialQqSso extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSocialQqSso(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                    Message message = new Message();
                    message.what = SocialType.QQ_SSO.getType();
                    message.obj = SocialType.QQ_SSO;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionSocialSinaSso extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSocialSinaSso(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
                    Message message = new Message();
                    message.what = SocialType.SINA_WEIBO_SSO.getType();
                    message.obj = SocialType.SINA_WEIBO_SSO;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionSocialSso extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSocialSso(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
            if (r5.equals(com.baidu.sapi2.utils.enums.FastLoginFeature.SSOLoginType.WEIXIN) != false) goto L10;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            SocialType socialType;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    char c2 = 0;
                    String str = command.getActionParams().get(0);
                    switch (str.hashCode()) {
                        case -1519161818:
                            break;
                        case -1506464740:
                            if (str.equals(FastLoginFeature.SSOLoginType.MEIZU)) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -952571024:
                            if (str.equals(FastLoginFeature.SSOLoginType.QQ)) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -19158255:
                            if (str.equals(FastLoginFeature.SSOLoginType.HUAWEI)) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3872:
                            if (str.equals("yy")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 110658813:
                            if (str.equals("tsina")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 738596251:
                            if (str.equals(FastLoginFeature.SSOLoginType.HONOR)) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1288743885:
                            if (str.equals(FastLoginFeature.SSOLoginType.SINA_SSO)) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1587088523:
                            if (str.equals(FastLoginFeature.SSOLoginType.XIAOMI)) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                            socialType = SocialType.WEIXIN;
                            break;
                        case 1:
                        case 2:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
                            socialType = SocialType.SINA_WEIBO_SSO;
                            break;
                        case 3:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                            socialType = SocialType.QQ_SSO;
                            break;
                        case 4:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
                            socialType = SocialType.HUAWEI;
                            break;
                        case 5:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.GLORY;
                            socialType = SocialType.GLORY;
                            break;
                        case 6:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
                            socialType = SocialType.XIAOMI;
                            break;
                        case 7:
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
                            socialType = SocialType.MEIZU;
                            break;
                        case '\b':
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.YY;
                            socialType = SocialType.YY;
                            break;
                        default:
                            socialType = null;
                            break;
                    }
                    if (socialType != null) {
                        Message message = new Message();
                        message.what = socialType.getType();
                        message.obj = socialType;
                        this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionSocialWeixinSso extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionSocialWeixinSso(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                    Message message = new Message();
                    message.what = SocialType.WEIXIN.getType();
                    message.obj = SocialType.WEIXIN;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionStopSlideWebview extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionStopSlideWebview(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.stopSlideWebviewCallback != null) {
                    boolean z = false;
                    try {
                        z = new JSONObject(command.getActionParams().get(0)).optBoolean("isStop");
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                    this.this$0.jsCallBacks.stopSlideWebviewCallback.onStopSlide(z);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ActionXiaoMiSso extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActionXiaoMiSso(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialLoginHandler != null) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
                    Message message = new Message();
                    message.what = SocialType.XIAOMI.getType();
                    message.obj = SocialType.XIAOMI;
                    this.this$0.jsCallBacks.socialLoginHandler.sendMessage(message);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class AddressManageGetPasteboard extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddressManageGetPasteboard(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    ClipboardManager clipboardManager = (ClipboardManager) this.this$0.context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                    if (clipboardManager.hasPrimaryClip()) {
                        jSONObject.put("paste", clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class AuthorizedResponse extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthorizedResponse(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String str = command.getActionParams().get(0);
                int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
                String str2 = command.getActionParams().size() >= 3 ? command.getActionParams().get(2) : null;
                if (parseInt == 1) {
                    SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str, this.this$0.context);
                    if (parseOpenApiAuthorizedResult == null) {
                        if (this.this$0.jsCallBacks.authorizationListener != null) {
                            this.this$0.sapiWebView.post(new Runnable(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AuthorizedResponse this$1;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.this$0.jsCallBacks.authorizationListener == null) {
                                        return;
                                    }
                                    this.this$1.this$0.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                }
                            });
                        }
                    } else if (parseOpenApiAuthorizedResult.offlineNotice || parseOpenApiAuthorizedResult.bindGuide || parseOpenApiAuthorizedResult.errorCode == 21 || parseOpenApiAuthorizedResult.bindConflict) {
                        this.this$0.jsCallBacks.rrLoginResponse = parseOpenApiAuthorizedResult;
                    } else {
                        this.this$0.sapiWebView.handleOpenApiAuthorizeResponse(parseOpenApiAuthorizedResult);
                    }
                }
                if (parseInt == 0) {
                    SapiAccountResponse parseAuthorizedResult = this.this$0.sapiWebView.parseAuthorizedResult(str, this.this$0.context);
                    if (parseAuthorizedResult == null) {
                        if (this.this$0.jsCallBacks.authorizationListener != null) {
                            this.this$0.sapiWebView.post(new Runnable(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AuthorizedResponse this$1;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.this$0.jsCallBacks.authorizationListener == null) {
                                        return;
                                    }
                                    this.this$1.this$0.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                }
                            });
                        }
                    } else {
                        int i = parseAuthorizedResult.errorCode;
                        if (i == 0 || i == 110000) {
                            this.this$0.sapiWebView.handleAuthorizeResponse(parseAuthorizedResult);
                            if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(str2)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("errno", 0);
                                } catch (JSONException e2) {
                                    Log.e(e2);
                                }
                                return jSONObject.toString();
                            }
                        } else if (this.this$0.jsCallBacks.authorizationListener != null) {
                            this.this$0.sapiWebView.post(new Runnable(this, parseAuthorizedResult) { // from class: com.baidu.sapi2.SapiJsInterpreters.AuthorizedResponse.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AuthorizedResponse this$1;
                                public final /* synthetic */ SapiAccountResponse val$response;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, parseAuthorizedResult};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$response = parseAuthorizedResult;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$1.this$0.jsCallBacks.authorizationListener == null) {
                                        return;
                                    }
                                    AuthorizationListener authorizationListener = this.this$1.this$0.jsCallBacks.authorizationListener;
                                    SapiAccountResponse sapiAccountResponse = this.val$response;
                                    authorizationListener.onFailed(sapiAccountResponse.errorCode, sapiAccountResponse.errorMsg);
                                }
                            });
                        }
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class Back extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Back(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                this.this$0.sapiWebView.back();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ConfigFastloginFeatures extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigFastloginFeatures(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                List<FastLoginFeature> fastLoginFeatureList = this.this$0.jsCallBacks.localConfigCallback != null ? this.this$0.jsCallBacks.localConfigCallback.getFastLoginFeatureList() : null;
                if (fastLoginFeatureList == null) {
                    fastLoginFeatureList = this.this$0.configuration.fastLoginFeatureList;
                }
                if (fastLoginFeatureList == null) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                if (SapiContext.getInstance().isHostsHijacked()) {
                    return sb.toString();
                }
                for (int i = 0; i < fastLoginFeatureList.size(); i++) {
                    FastLoginFeature fastLoginFeature = fastLoginFeatureList.get(i);
                    if (i == 0) {
                        sb.append(fastLoginFeature.getStrValue());
                    } else {
                        sb.append(",");
                        sb.append(fastLoginFeature.getStrValue());
                    }
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class ConfigLoginShareStrategy extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigLoginShareStrategy(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) ? this.this$0.configuration.loginShareStrategy().getStrValue() : (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class CurrentAccountBdussExpired extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CurrentAccountBdussExpired(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.currentAccountBdussExpiredCallback != null) {
                    this.this$0.jsCallBacks.currentAccountBdussExpiredCallback.onBdussExpired();
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class CurrentPageName extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CurrentPageName(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.getCurrentPageNameCallback != null) {
                    try {
                        this.this$0.jsCallBacks.getCurrentPageNameCallback.getCurrentPageName(new JSONObject(command.getActionParams().get(0)).optString("name"));
                        return null;
                    } catch (Exception e2) {
                        Log.e(e2);
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class Finish extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Finish(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                this.this$0.sapiWebView.handleOpenApiAuthorizeResponse(this.this$0.jsCallBacks.rrLoginResponse);
                if (command.getActionParams().size() > 0) {
                    try {
                        this.this$0.sapiWebView.finish(new JSONObject(command.getActionParams().get(0)).optString("page"));
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                } else {
                    this.this$0.sapiWebView.finish();
                }
                if (this.this$0.jsCallBacks.webviewPageFinishCallback != null) {
                    this.this$0.jsCallBacks.webviewPageFinishCallback.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class FocusEdittextCoordinateY extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FocusEdittextCoordinateY(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.focusEdittextCoordinateYCallBack != null) {
                    try {
                        this.this$0.jsCallBacks.focusEdittextCoordinateYCallBack.onCallback(new JSONObject(command.getActionParams().get(0)).optInt("coordinateY"));
                        return null;
                    } catch (Exception e2) {
                        Log.e(e2);
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class GetAllClientAccounts extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAllClientAccounts(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        private boolean isShareEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
                if (sapiConfiguration == null || sapiConfiguration.loginShareStrategy() != LoginShareStrategy.CHOICE) {
                    return false;
                }
                String packageName = sapiConfiguration.context.getPackageName();
                for (String str : SapiContext.getInstance().getAuthorizedPackages().keySet()) {
                    if (packageName.matches(str)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                Log.d(ShareUtils.TAG, "GetAllClientAccounts ----- start --------");
                SapiContext sapiContext = SapiContext.getInstance();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                List<SapiAccount> touchidAccounts = sapiContext.getTouchidAccounts();
                try {
                    JSONArray jSONArray = new JSONArray();
                    boolean z = FingerprintUtil.getFingerPrintState(this.this$0.configuration) == 0;
                    for (SapiAccount sapiAccount : touchidAccounts) {
                        JSONObject jSONObject2 = sapiAccount.toJSONObject();
                        if (!TextUtils.isEmpty(sapiAccount.phone) && sapiAccount.phone.contains("http://")) {
                            sapiAccount.phone = sapiAccount.phone.replace("http://", "https://");
                        }
                        jSONObject2.put("portrait", sapiAccount.phone);
                        String str = "1";
                        if (!z) {
                            jSONObject2.put("touchCode", "1");
                        } else {
                            if (!TextUtils.isEmpty(sapiAccount.email)) {
                                str = "0";
                            }
                            jSONObject2.put("touchCode", str);
                        }
                        jSONObject2.remove("phone");
                        jSONObject2.remove("extra");
                        jSONObject2.remove("app");
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("fingerAccounts", jSONArray);
                } catch (Exception e3) {
                    Log.e(e3);
                }
                try {
                    jSONObject.put("onekeyAccounts", new OneKeyLoginSdkCall().getEncryptPhone());
                } catch (Exception e4) {
                    Log.e(e4);
                }
                try {
                    jSONObject.put("faceAccounts", sapiContext.getV2FaceLoginCheckResults());
                } catch (Exception e5) {
                    Log.e(e5);
                }
                try {
                    Object jSONArray2 = LoginHistoryItem.toJSONArray(LoginHistoryLoginModel.getAvailableLoginHistoryItems());
                    if (jSONArray2 != null) {
                        jSONObject.put("history", jSONArray2);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                try {
                    jSONObject.put("recentLoginUid", sapiContext.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
                    if (this.this$0.sapiWebView != null && this.this$0.sapiWebView.mExcludeTypes != null) {
                        jSONObject.put("excludeTypes", this.this$0.sapiWebView.mExcludeTypes.getName());
                    }
                } catch (JSONException e7) {
                    Log.e(e7);
                }
                try {
                    if (!isShareEnable()) {
                        this.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        Log.d(ShareUtils.TAG, "GetAllClientAccounts share login is disable");
                        return null;
                    }
                    Log.d(ShareUtils.TAG, "GetAllClientAccounts share login is enable");
                    ShareLoginStat.GetShareListStat.sValueSence = "in";
                    SapiAccountManager.getInstance().getShareModels(2000L, new ShareModelCallback(this, jSONObject) { // from class: com.baidu.sapi2.SapiJsInterpreters.GetAllClientAccounts.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ GetAllClientAccounts this$1;
                        public final /* synthetic */ JSONObject val$result;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, jSONObject};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$result = jSONObject;
                        }

                        @Override // com.baidu.sapi2.callback.ShareModelCallback
                        public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, list) == null) {
                                if (list == null || list.size() == 0) {
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(this.val$result.toString());
                                }
                                try {
                                    JSONArray jSONArray3 = ShareStorage.StorageModel.toJSONArray(list);
                                    this.val$result.put("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                                    this.val$result.put("canshare2Accounts", jSONArray3);
                                    Log.d(ShareUtils.TAG, "shareV2 value=" + this.val$result.toString());
                                    SapiStatUtil.statShareV2Open(list, null, this.this$1.this$0.sapiWebView.extras);
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(this.val$result.toString());
                                } catch (JSONException e8) {
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(this.val$result.toString());
                                    e8.printStackTrace();
                                }
                            }
                        }
                    });
                    return null;
                } catch (Exception e8) {
                    this.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    Log.e(e8);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class GetCurrentAccountInfo extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCurrentAccountInfo(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                JSONObject jSONObject = new JSONObject();
                if (currentAccount != null) {
                    try {
                        currentAccount.portrait = currentAccount.getCompletePortrait();
                        jSONObject.put("currentAccount", currentAccount.toJSONObject());
                        jSONObject.put("errno", 0);
                        return jSONObject.toString();
                    } catch (JSONException e2) {
                        Log.e(e2);
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class GetPresetPhoneNumber extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetPresetPhoneNumber(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.configuration.forbidPresetPhoneNumber) {
                    return "";
                }
                if (SapiUtils.isValidPhoneNumber(this.this$0.configuration.presetPhoneNumber)) {
                    return this.this$0.configuration.presetPhoneNumber;
                }
                String localPhoneNumber = this.this$0.sapiWebView.getLocalPhoneNumber();
                return SapiUtils.isValidPhoneNumber(localPhoneNumber) ? localPhoneNumber : "";
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class GrantWebLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GrantWebLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    int optInt = new JSONObject(command.getActionParams().get(0)).optInt("type");
                    if (this.this$0.jsCallBacks.grantWebCallback != null) {
                        this.this$0.jsCallBacks.grantWebCallback.onGrant(optInt);
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class InvoiceBuildSelectedInvoice extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvoiceBuildSelectedInvoice(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.invoiceBuildCallback != null && command.getActionParams().size() > 0) {
                    this.this$0.jsCallBacks.invoiceBuildCallback.onCallback(command.getActionParams().get(0));
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                } catch (JSONException unused) {
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class NormalizeGuestAccount extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalizeGuestAccount(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    int optInt = jSONObject.optInt("errno");
                    String optString = jSONObject.optString("msg");
                    if (optInt != 0) {
                        if (this.this$0.jsCallBacks.normalizeGuestAccountCallback != null) {
                            this.this$0.jsCallBacks.normalizeGuestAccountCallback.onFailure(optInt, optString);
                        }
                    } else {
                        boolean z = jSONObject.optInt("merge") == 1;
                        String optString2 = jSONObject.optString("normalizeWay");
                        SapiAccountResponse parseAuthorizedResult = this.this$0.sapiWebView.parseAuthorizedResult(jSONObject.optString("xml"), this.this$0.context);
                        if (parseAuthorizedResult == null) {
                            if (this.this$0.jsCallBacks.normalizeGuestAccountCallback != null) {
                                this.this$0.jsCallBacks.normalizeGuestAccountCallback.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                            }
                        } else {
                            SapiAccount sapiAccountResponseToAccount = this.this$0.sapiWebView.sapiAccountResponseToAccount(parseAuthorizedResult);
                            if (!SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                                this.this$0.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, "网络连接失败，请检查网络设置");
                                return null;
                            }
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            if (currentAccount != null) {
                                sapiAccountResponseToAccount.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait(), currentAccount.getSocialNickname());
                            }
                            SapiAccountManager.getInstance().removeLoginAccount(currentAccount);
                            SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                            if (this.this$0.jsCallBacks.normalizeGuestAccountCallback != null) {
                                this.this$0.jsCallBacks.normalizeGuestAccountCallback.onSuccess(z, optString2);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                    if (this.this$0.jsCallBacks.normalizeGuestAccountCallback != null) {
                        this.this$0.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, "网络连接失败，请检查网络设置");
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class NormalizeGuestDescription extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NormalizeGuestDescription(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    if (!TextUtils.isEmpty(this.this$0.jsCallBacks.normalizeGuestAccountDesc)) {
                        jSONObject.put("description", new JSONObject(this.this$0.jsCallBacks.normalizeGuestAccountDesc));
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class OauthCallBaidu extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OauthCallBaidu(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.bdOauthLoginParams != null) {
                    this.this$0.jsCallBacks.bdOauthLoginParams.callback.onCallback(command.getActionParams().get(0));
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class OauthSsoHash extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OauthSsoHash(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.OauthSsoHash.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OauthSsoHash this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(SsoHashResult ssoHashResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ssoHashResult) == null) {
                            this.this$1.this$0.jsCallBacks.promptResult.confirm(ssoHashResult.ssoHash);
                        }
                    }
                }, this.this$0.jsCallBacks.bdOauthLoginParams.callingPkg, this.this$0.jsCallBacks.bdOauthLoginParams.callingAppId);
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class RealNameVerifySucceed extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RealNameVerifySucceed(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.realnameAuthenticateCallback != null) {
                    this.this$0.jsCallBacks.realnameAuthenticateCallback.onSuccess();
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionAccountCenterFastloginFeatures extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionAccountCenterFastloginFeatures(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                ArrayList arrayList = new ArrayList();
                if (this.this$0.configuration.fastLoginFeatureList == null || this.this$0.configuration.fastLoginFeatureList.isEmpty()) {
                    return null;
                }
                arrayList.addAll(this.this$0.configuration.fastLoginFeatureList);
                if (arrayList.isEmpty()) {
                    return null;
                }
                arrayList.remove(FastLoginFeature.MEIZU_SSO);
                arrayList.remove(FastLoginFeature.SINA_WEIBO_SSO);
                arrayList.remove(FastLoginFeature.TX_QQ_SSO);
                arrayList.remove(FastLoginFeature.HUAWEI_LOGIN);
                arrayList.remove(FastLoginFeature.TX_WEIXIN_SSO);
                StringBuilder sb = new StringBuilder();
                if (SapiContext.getInstance().isHostsHijacked()) {
                    return sb.toString();
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    FastLoginFeature fastLoginFeature = (FastLoginFeature) arrayList.get(i);
                    if (i == 0) {
                        sb.append(fastLoginFeature.getStrValue());
                    } else {
                        sb.append(",");
                        sb.append(fastLoginFeature.getStrValue());
                    }
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionAccountDestroy extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionAccountDestroy(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.accountDestoryCallback != null) {
                    this.this$0.jsCallBacks.accountDestoryCallback.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
                }
                this.this$0.sapiWebView.finish();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionAccountFreeze extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionAccountFreeze(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.accountFreezeCallback != null) {
                    this.this$0.jsCallBacks.accountFreezeCallback.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionBdussChanged extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionBdussChanged(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.bdussChangeCallback != null) {
                    this.this$0.jsCallBacks.bdussChangeCallback.onBdussChange();
                } else {
                    SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionBdussChanged.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiActionBdussChanged this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
                        public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, web2NativeLoginResult) == null) {
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.LoginStatusAware
                        public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, web2NativeLoginResult) == null) {
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048580, this, web2NativeLoginResult) == null) {
                            }
                        }

                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onFinish() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                            }
                        }

                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onStart() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, web2NativeLoginResult) == null) {
                            }
                        }
                    }, true);
                }
                new PtokenStat().onEvent(PtokenStat.SAPI_ACTION_BDUSS_CHANGED);
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionCheckLoginStatus extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionCheckLoginStatus(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (this.this$0.jsCallBacks.loginStatusChangeCallback != null) {
                        jSONObject.put("sup", true);
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionCheckMethodSupport extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionCheckMethodSupport(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
            if (r4.this$0.configuration.supportFaceLogin != false) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
            if (r4.this$0.jsCallBacks.invokeScAppCallback != null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
            if (r4.this$0.configuration.supportFaceLogin != false) goto L13;
         */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                boolean z2 = false;
                String str = command.getActionParams().get(0);
                try {
                    Class.forName(this.this$0.interpreterNameToClassFullName(str));
                    z = true;
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (str.equals("sapi_biometrics_identification_with_uid")) {
                    if (this.this$0.jsCallBacks.bioScanFaceCallback != null) {
                    }
                    z = z2;
                } else if (str.equals("sapi_biometrics_identification") || str.equals("sapi_biometrics_identification_no_bduss") || str.equals("sapi_biometrics_identification_with_authtoken")) {
                    if (this.this$0.jsCallBacks.biometricsIdentifyCallback != null) {
                    }
                    z = z2;
                } else if (str.equals("sapi_action_sc_app_check")) {
                }
                return z ? "1" : "0";
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionChinaMobileOauth extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionChinaMobileOauth(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                new OneKeyLoginSdkCall().getToken(this.this$0.configuration, new OneKeyLoginSdkCall.TokenListener(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionChinaMobileOauth.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiActionChinaMobileOauth this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                    public void onGetTokenComplete(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            Log.d(OneKeyLoginSdkCall.TAG, "SapiActionChinaMobileOauth onGetTokenComplete result=" + jSONObject);
                            String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                            if (OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC.equals(operatorType)) {
                                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
                            } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
                            } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC.equals(operatorType)) {
                                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
                            }
                            this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        }
                    }
                });
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionCoverWebBduss extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionCoverWebBduss(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String cookieBduss = SapiUtils.getCookieBduss();
                if (this.this$0.jsCallBacks.coverWebBdussCallback != null) {
                    this.this$0.jsCallBacks.coverWebBdussCallback.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionCoverWebBduss.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiActionCoverWebBduss this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussResult
                        public void setWebBduss(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                this.this$1.this$0.sapiWebView.webLogin(this.this$1.this$0.context, str);
                                this.this$1.this$0.sapiWebView.reload();
                            }
                        }
                    });
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionCurrentLoginType extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionCurrentLoginType(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (command != null && command.getActionParams() != null && !command.getActionParams().isEmpty()) {
                    String str = command.getActionParams().get(0);
                    if (InputType.PASSWORD.equals(str)) {
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.PWD;
                    } else if (LoginConstants.SMS_LOGIN.equals(str)) {
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.SMS;
                    } else if ("face".equals(str)) {
                        SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.FACE;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionDeliverParams extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionDeliverParams(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString = jSONObject.optString("username");
                    boolean equals = jSONObject.optString(IntentConfig.CLOSE, "0").equals("1");
                    SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult = new SapiWebView.PreFillUserNameCallback.PreFillUserNameResult();
                    preFillUserNameResult.userName = optString;
                    if (this.this$0.jsCallBacks.prefillUserNameCallback != null) {
                        this.this$0.jsCallBacks.prefillUserNameCallback.onPreFillUserName(preFillUserNameResult);
                    }
                    if (equals) {
                        this.this$0.sapiWebView.finish();
                        return null;
                    }
                    return null;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionDirectedLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionDirectedLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("encryptedId", this.this$0.jsCallBacks.directedLoginParams.encryptedId);
                    jSONObject.put("displayname", this.this$0.jsCallBacks.directedLoginParams.displayname);
                    jSONObject.put("errno", 0);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionGetAppTpl extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionGetAppTpl(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) ? this.this$0.configuration.getTpl() : (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionGetNaUiConfig extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String TAG;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionGetNaUiConfig(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
            this.TAG = "sapi_action_get_na_ui_config";
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errno", "0");
                    if (this.this$0.configuration != null) {
                        jSONObject.put("textZoom", this.this$0.configuration.textZoom);
                        jSONObject.put("browseModeState", this.this$0.configuration.browseModeState);
                    } else {
                        jSONObject.put("textZoom", 100);
                        jSONObject.put("browseModeState", 1);
                    }
                    return jSONObject.toString();
                } catch (Exception unused) {
                    Log.e(this.TAG, "get na ui config error");
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionGetSecurityZid extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionGetSecurityZid(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    int optInt = new JSONObject(command.getActionParams().get(0)).optInt(TbEnum.SystemMessage.KEY_EVENT_ID);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errno", "0");
                    jSONObject.put("zid", Security.getZid(ServiceManager.getInstance().getIsAccountManager().getConfignation().context, optInt));
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionHandleBackButton extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionHandleBackButton(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                this.this$0.jsCallBacks.leftBtnIsVisible = Integer.parseInt(command.getActionParams().get(0));
                if (this.this$0.jsCallBacks.leftBtnVisibleCallback != null) {
                    this.this$0.jsCallBacks.leftBtnVisibleCallback.onLeftBtnVisible(this.this$0.jsCallBacks.leftBtnIsVisible);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionHideSuccessTip extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionHideSuccessTip(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("hideTip", this.this$0.jsCallBacks.hideSuccessTip ? "1" : "0");
                    jSONObject.put("errno", 0);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionJumpToUri extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionJumpToUri(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks == null) {
                    return null;
                }
                if (this.this$0.jsCallBacks.jumpToUriCallBack != null) {
                    try {
                        this.this$0.jsCallBacks.jumpToUriCallBack.onJumpTo(new JSONObject(command.getActionParams().get(0)).optString("url"));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errno", 0);
                        if (this.this$0.jsCallBacks.promptResult != null) {
                            this.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        if (this.this$0.jsCallBacks.promptResult != null) {
                            this.this$0.jsCallBacks.promptResult.cancel();
                        }
                    }
                } else {
                    this.this$0.jsCallBacks.promptResult.cancel();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionLastLoginType extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionLastLoginType(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("lastLoginType", SapiUtils.getLastLoginType());
                    jSONObject.put("errno", 0);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionListenIsForbidRecord extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionListenIsForbidRecord(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks == null) {
                    return null;
                }
                try {
                    String str = command.getActionParams().get(0);
                    if (this.this$0.jsCallBacks.isForbidRecordCallBack != null) {
                        this.this$0.jsCallBacks.isForbidRecordCallBack.onForbidRecord(Boolean.valueOf("1".equals(str)));
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionLoginStatusChange extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionLoginStatusChange(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.loginStatusChangeCallback != null) {
                    this.this$0.jsCallBacks.loginStatusChangeCallback.onChange();
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionMakeVibrate extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionMakeVibrate(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.makeVibrateCallBack == null) {
                    this.this$0.jsCallBacks.promptResult.cancel();
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    JSONArray optJSONArray = jSONObject.optJSONArray("pattern");
                    int optInt = jSONObject.optInt("repeat", -1);
                    String optString = jSONObject.optString("broadcastText");
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        this.this$0.jsCallBacks.makeVibrateCallBack.presetVibrate(optString);
                        return null;
                    }
                    long[] jArr = new long[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        jArr[i] = optJSONArray.getLong(i);
                    }
                    this.this$0.jsCallBacks.makeVibrateCallBack.vibrate(jArr, optInt, optString);
                    return null;
                } catch (JSONException e2) {
                    Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                    if (this.this$0.jsCallBacks == null || this.this$0.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    this.this$0.jsCallBacks.promptResult.cancel();
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionMiniDi extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionMiniDi(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONArray optJSONArray = new JSONObject(command.getActionParams().get(0)).optJSONArray("di_keys");
                    if (optJSONArray == null) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                    return SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionPasteboardSet extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionPasteboardSet(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    ((ClipboardManager) this.this$0.context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("address", new JSONObject(command.getActionParams().get(0)).optString("content")));
                    jSONObject.put("errno", 0);
                    return jSONObject.toString();
                } catch (Exception e2) {
                    Log.e(e2);
                    return jSONObject.toString();
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionPickDate extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionPickDate(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                String str = command.getActionParams().get(0);
                Calendar calendar = Calendar.getInstance();
                Date time = calendar.getTime();
                try {
                    calendar.setTime(new SimpleDateFormat("yyyyMMdd").parse(str));
                } catch (Exception e2) {
                    Log.e(e2);
                }
                int i = calendar.get(1);
                int i2 = calendar.get(2);
                int i3 = calendar.get(5);
                calendar.setTime(time);
                int i4 = calendar.get(1);
                int i5 = calendar.get(2);
                int i6 = calendar.get(5);
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.this$0.context, 3, new DatePickerDialog.OnDateSetListener(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiActionPickDate this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // android.app.DatePickerDialog.OnDateSetListener
                    public void onDateSet(DatePicker datePicker, int i7, int i8, int i9) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIII(1048576, this, datePicker, i7, i8, i9) == null) {
                            this.this$1.this$0.jsCallBacks.promptResult.confirm(i7 + String.format("%02d", Integer.valueOf(i8 + 1)) + String.format("%02d", Integer.valueOf(i9)) + "");
                        }
                    }
                }, i, i2, i3);
                datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickDate.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiActionPickDate this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i7 = newInitContext.flag;
                            if ((i7 & 1) != 0) {
                                int i8 = i7 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.this$1.this$0.jsCallBacks.promptResult.confirm("");
                        }
                    }
                });
                datePickerDialog.setTitle("");
                calendar.set(i4, i5, i6, 23, 59, 59);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                calendar.set(i4 - 100, i5, i6, 0, 0, 0);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.show();
                datePickerDialog.setCustomTitle(null);
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionPickImage extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionPickImage(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                int i = 0;
                try {
                    i = Integer.parseInt(command.getActionParams().get(0));
                } catch (Exception e2) {
                    Log.e(e2);
                }
                int i2 = 512;
                int i3 = 1;
                if (command.getActionParams().size() > 1) {
                    try {
                        JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                        i3 = jSONObject.optInt("sence", 1);
                        i2 = jSONObject.optInt("size", 512);
                    } catch (JSONException e3) {
                        Log.e(e3);
                    }
                }
                this.this$0.jsCallBacks.pickPhotoCallback.onPickImage(i, i3, i2, new SapiWebView.PickPhotoResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionPickImage.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiActionPickImage this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.PickPhotoResult
                    public void setImageData(String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.this$1.this$0.jsCallBacks.promptResult == null) {
                            return;
                        }
                        this.this$1.this$0.jsCallBacks.promptResult.confirm(str);
                    }
                });
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionQrLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionQrLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    if (this.this$0.jsCallBacks.qrLoginCallback != null) {
                        int optInt = jSONObject.optInt("relogin", -1);
                        if (optInt == 1) {
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            String optString = jSONObject.optString("bduss");
                            String optString2 = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                            if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                currentAccount.bduss = optString;
                                currentAccount.ptoken = optString2;
                                currentAccount.deleteStokens();
                                SapiAccountManager.getInstance().validate(currentAccount);
                            }
                        }
                        this.this$0.jsCallBacks.qrLoginCallback.loginStatusChange(optInt == 1);
                    }
                    if (this.this$0.jsCallBacks.finishPage) {
                        this.this$0.sapiWebView.finish();
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionRealname extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionRealname(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                    int optInt = jSONObject.optInt("status");
                    accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                    if (this.this$0.jsCallBacks.realNameStatusCallback != null) {
                        if (optInt == 1) {
                            accountRealNameResult.juniorRealNameSuc = true;
                        } else if (optInt == 2) {
                            accountRealNameResult.seniorRealNameSuc = true;
                        }
                        this.this$0.jsCallBacks.realNameStatusCallback.onFinish(accountRealNameResult);
                        return null;
                    }
                    return null;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionScAppCheck extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionScAppCheck(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    jSONObject.optString("action");
                    String optString = jSONObject.optString("minver");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("state", new SapiScheme().getInvokeScState(this.this$0.context, optString, this.this$0.jsCallBacks.invokeScAppCallback));
                    return jSONObject2.toString();
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionScAppInvoke extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionScAppInvoke(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString = jSONObject.optString("action");
                    String optString2 = jSONObject.optString("minver");
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!next.equals("action")) {
                            arrayList.add(new PassNameValuePair(next, jSONObject.optString(next)));
                        }
                    }
                    this.this$0.jsCallBacks.invokeScAppCallback.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiActionScAppInvoke.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiActionScAppInvoke this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.baidu.sapi2.SapiWebView.InvokeScAppCallback.InvokeScAppResult
                        public void setInvokeResult(String str) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                                this.this$1.this$0.jsCallBacks.promptResult.confirm(str);
                            }
                        }
                    });
                    return null;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionSwitchAccount extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionSwitchAccount(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.switchAccountCallback != null) {
                    List<String> actionParams = command.getActionParams();
                    SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                    if (actionParams != null && actionParams.size() > 0) {
                        if (actionParams.size() > 1) {
                            try {
                                JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                                result.extraJson = jSONObject.optString("extrajson");
                                result.displayName = jSONObject.optString("displayname");
                                result.encryptedUid = jSONObject.optString("uid");
                                result.loginType = jSONObject.optInt("type");
                                result.switchAccountType = 2;
                                this.this$0.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                                return null;
                            } catch (JSONException e2) {
                                Log.e(e2);
                            }
                        } else {
                            result.userName = actionParams.get(0);
                            result.switchAccountType = 1;
                            this.this$0.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                            return null;
                        }
                    }
                    result.switchAccountType = 0;
                    this.this$0.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionThirdInstalledInfo extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionThirdInstalledInfo(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errno", "0");
                    JSONArray jSONArray = new JSONArray();
                    if (ThirdPartyUtil.isWeixinAvilible(this.this$0.context)) {
                        jSONArray.put(ThirdPartyUtil.TYPE_WEIXIN);
                    }
                    if (ThirdPartyUtil.isQQClientAvailable(this.this$0.context)) {
                        jSONArray.put("qzone");
                    }
                    if (ThirdPartyUtil.isSinaInstalled(this.this$0.context)) {
                        jSONArray.put("tsina");
                    }
                    jSONObject.put("types", jSONArray);
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionThirdSafetyVerification extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionThirdSafetyVerification(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.socialVerificationHandler != null) {
                    try {
                        this.this$0.jsCallBacks.socialVerificationHandler.sendMessage(ThirdPartyUtil.getVerificationMsg(new JSONObject(command.getActionParams().get(0)).optString("type")));
                        return null;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        if (this.this$0.jsCallBacks == null || this.this$0.jsCallBacks.promptResult == null) {
                            return null;
                        }
                        this.this$0.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                }
                this.this$0.jsCallBacks.promptResult.cancel();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionUpdateNavigator extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionUpdateNavigator(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                int parseInt = Integer.parseInt(command.getActionParams().get(0));
                if (this.this$0.jsCallBacks.pageStateCallback != null) {
                    this.this$0.jsCallBacks.pageStateCallback.pageState(parseInt);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiActionUpsms extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiActionUpsms(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(command.getActionParams().get(0));
                SapiUtils.sendSms(this.this$0.context, command.getActionParams().get(1), arrayList);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", "0");
                } catch (JSONException unused) {
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiBiometricsIdentification extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiBiometricsIdentification(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentification.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiBiometricsIdentification this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                    public void setIdentifyToken(String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.this$1.this$0.jsCallBacks.promptResult == null) {
                            return;
                        }
                        this.this$1.this$0.jsCallBacks.promptResult.confirm(str);
                    }
                };
                biometricsIdentifyResult.biometricType = Integer.parseInt(command.getActionParams().get(0));
                biometricsIdentifyResult.livenessRecogType = "bduss";
                biometricsIdentifyResult.recordVideo = 0;
                biometricsIdentifyResult.subPro = "pp";
                if (command.getActionParams().size() > 1) {
                    biometricsIdentifyResult.recordVideo = Integer.parseInt(command.getActionParams().get(1));
                }
                if (command.getActionParams().size() > 2) {
                    biometricsIdentifyResult.subPro = command.getActionParams().get(2).toString();
                }
                if (command.getActionParams().size() > 3) {
                    try {
                        biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(3)).optInt("hideGuidePage", 0);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
                biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
                if (this.this$0.jsCallBacks.biometricsIdentifyCallback != null) {
                    this.this$0.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiBiometricsIdentificationLive extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiBiometricsIdentificationLive(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.biometricsIdentificationLiveCallBack == null) {
                    this.this$0.jsCallBacks.promptResult.cancel();
                    return null;
                }
                try {
                    this.this$0.jsCallBacks.biometricsIdentificationLiveCallBack.getLiveImage((int) (Float.parseFloat(new JSONObject(command.getActionParams().get(0)).optString(AnimationProperty.SCALE)) * 100.0f), new PassFaceRecogCallback(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationLive.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiBiometricsIdentificationLive this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, passFaceRecogResult) == null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("errno", 0);
                                    jSONObject.put("businessno", passFaceRecogResult.getResultCode());
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    this.this$1.this$0.jsCallBacks.promptResult.cancel();
                                }
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.pass.biometrics.base.callback.PassBiometricCallback
                        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048579, this, passFaceRecogResult) == null) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("errno", 0);
                                    jSONObject.put("originalimage", passFaceRecogResult.originalImage);
                                    jSONObject.put("credentialKey", passFaceRecogResult.callbackkey);
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                                } catch (JSONException e2) {
                                    Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                                    this.this$1.this$0.jsCallBacks.promptResult.cancel();
                                }
                            }
                        }
                    });
                    return null;
                } catch (JSONException e2) {
                    Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                    if (this.this$0.jsCallBacks == null || this.this$0.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    this.this$0.jsCallBacks.promptResult.cancel();
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiBiometricsIdentificationNoBduss extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiBiometricsIdentificationNoBduss(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationNoBduss.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiBiometricsIdentificationNoBduss this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                    public void setIdentifyToken(String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.this$1.this$0.jsCallBacks.promptResult == null) {
                            return;
                        }
                        this.this$1.this$0.jsCallBacks.promptResult.confirm(str);
                    }
                };
                biometricsIdentifyResult.biometricType = Integer.parseInt(command.getActionParams().get(0));
                biometricsIdentifyResult.livenessRecogType = "certinfo";
                biometricsIdentifyResult.realName = command.getActionParams().get(1);
                biometricsIdentifyResult.idCardNum = command.getActionParams().get(2);
                biometricsIdentifyResult.recordVideo = 0;
                biometricsIdentifyResult.phoneNum = "";
                if (command.getActionParams().size() > 3) {
                    biometricsIdentifyResult.recordVideo = Integer.parseInt(command.getActionParams().get(3));
                }
                if (command.getActionParams().size() > 4) {
                    biometricsIdentifyResult.phoneNum = command.getActionParams().get(4);
                }
                biometricsIdentifyResult.subPro = "pp";
                if (command.getActionParams().size() > 5) {
                    biometricsIdentifyResult.subPro = command.getActionParams().get(5);
                }
                if (command.getActionParams().size() > 6) {
                    try {
                        biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(6)).optInt("hideGuidePage", 0);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
                biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
                if (this.this$0.jsCallBacks.biometricsIdentifyCallback != null) {
                    this.this$0.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiBiometricsIdentificationWithAuthtoken extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiBiometricsIdentificationWithAuthtoken(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiWebView.BiometricsIdentifyResult biometricsIdentifyResult = new SapiWebView.BiometricsIdentifyResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithAuthtoken.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiBiometricsIdentificationWithAuthtoken this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.BiometricsIdentifyResult
                    public void setIdentifyToken(String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.this$1.this$0.jsCallBacks.promptResult == null) {
                            return;
                        }
                        this.this$1.this$0.jsCallBacks.promptResult.confirm(str);
                    }
                };
                biometricsIdentifyResult.biometricType = Integer.parseInt(command.getActionParams().get(0));
                biometricsIdentifyResult.livenessRecogType = "authtoken";
                biometricsIdentifyResult.authToken = command.getActionParams().get(1);
                biometricsIdentifyResult.recordVideo = 0;
                biometricsIdentifyResult.subPro = "pp";
                if (command.getActionParams().size() > 2) {
                    biometricsIdentifyResult.recordVideo = Integer.parseInt(command.getActionParams().get(2));
                }
                if (command.getActionParams().size() > 3) {
                    biometricsIdentifyResult.subPro = command.getActionParams().get(3).toString();
                }
                if (command.getActionParams().size() > 4) {
                    try {
                        biometricsIdentifyResult.showGuidePage = 1 - new JSONObject(command.getActionParams().get(4)).optInt("hideGuidePage", 0);
                    } catch (JSONException e2) {
                        Log.e(e2);
                    }
                }
                biometricsIdentifyResult.subPro = TextUtils.isEmpty(biometricsIdentifyResult.subPro) ? "pp" : biometricsIdentifyResult.subPro;
                if (this.this$0.jsCallBacks.biometricsIdentifyCallback != null) {
                    this.this$0.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(biometricsIdentifyResult);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiBiometricsIdentificationWithUid(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.bioScanFaceCallback == null) {
                    return null;
                }
                SapiWebView.BioScanFaceCallback.BioScanFaceResult bioScanFaceResult = new SapiWebView.BioScanFaceCallback.BioScanFaceResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiBiometricsIdentificationWithUid.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiBiometricsIdentificationWithUid this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.BioScanFaceCallback.BioScanFaceResult
                    public void setScanFaceIdentifyResult(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.this$1.this$0.jsCallBacks.promptResult.confirm(str);
                        }
                    }
                };
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    bioScanFaceResult.uid = jSONObject.optString("uid");
                    bioScanFaceResult.type = jSONObject.optInt("type");
                    bioScanFaceResult.subpro = jSONObject.optString("subpro");
                    bioScanFaceResult.showGuidePage = 1 - jSONObject.optInt("hideGuidePage", 0);
                    if (TextUtils.isEmpty(bioScanFaceResult.subpro)) {
                        bioScanFaceResult.subpro = "pp";
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            bioScanFaceResult.transParamsMap.put(next, optJSONObject.optString(next));
                        }
                    }
                    this.this$0.jsCallBacks.bioScanFaceCallback.onBioScanFace(bioScanFaceResult);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiClientHistoryLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiClientHistoryLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    jSONObject = new JSONObject(command.getActionParams().get(0));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    LoginHistoryModel loginHistoryModel = new LoginHistoryModel();
                    loginHistoryModel.bduss = jSONObject.optString("bduss");
                    SapiAccountManager.getInstance().loadHistoryActionLoginFromWap(loginHistoryModel, new LoginHistoryCallback(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiClientHistoryLogin.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiClientHistoryLogin this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                        public void onLoginFailure() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("errno", -1);
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject2.toString());
                                } catch (JSONException e3) {
                                    e3.printStackTrace();
                                }
                            }
                        }

                        @Override // com.baidu.sapi2.callback.inner.LoginHistoryCallback
                        public void onLoginSuccess(SapiAccount sapiAccount) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiAccount) == null) || this.this$1.this$0.jsCallBacks.historyLoginCallback == null) {
                                return;
                            }
                            this.this$1.this$0.sapiWebView.handleLoginHistoryLogin(sapiAccount);
                            this.this$1.this$0.jsCallBacks.historyLoginCallback.onSuccess();
                        }
                    });
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiGoBack extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiGoBack(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.sapiWebView.canGoBack()) {
                    this.this$0.sapiWebView.goBack();
                    return null;
                }
                this.this$0.sapiWebView.finish();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiIdcardOcrImage extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiIdcardOcrImage(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.idcardOcrImageCallBack == null) {
                    this.this$0.jsCallBacks.promptResult.cancel();
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    this.this$0.jsCallBacks.idcardOcrImageCallBack.getIdcardImage(jSONObject.optString("way"), jSONObject.optString("type"), new IdcardOcrImageCallback(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiIdcardOcrImage.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiIdcardOcrImage this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                        }

                        @Override // com.baidu.sapi2.callback.IdcardOcrImageCallback
                        public void onFailure(IdcardOcrImageRusult idcardOcrImageRusult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, idcardOcrImageRusult) == null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("errno", idcardOcrImageRusult.getResultCode());
                                    jSONObject2.put("errmsg", idcardOcrImageRusult.getResultMsg());
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject2.toString());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    this.this$1.this$0.jsCallBacks.promptResult.cancel();
                                }
                            }
                        }

                        @Override // com.baidu.sapi2.callback.IdcardOcrImageCallback
                        public void onSuccess(IdcardOcrImageRusult idcardOcrImageRusult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, idcardOcrImageRusult) == null) {
                                try {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("errno", idcardOcrImageRusult.getResultCode());
                                    jSONObject2.put("errmsg", idcardOcrImageRusult.getResultMsg());
                                    jSONObject2.put("type", idcardOcrImageRusult.type);
                                    jSONObject2.put("image", idcardOcrImageRusult.image);
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject2.toString());
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                    this.this$1.this$0.jsCallBacks.promptResult.cancel();
                                }
                            }
                        }
                    });
                    return null;
                } catch (JSONException e2) {
                    Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                    if (this.this$0.jsCallBacks == null || this.this$0.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    this.this$0.jsCallBacks.promptResult.cancel();
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiOnekeyOauthToken extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiOnekeyOauthToken(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                new OneKeyLoginSdkCall().getMobileOauthToken(this.this$0.configuration, new OneKeyLoginSdkCall.TokenListener(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SapiOnekeyOauthToken.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiOnekeyOauthToken this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.TokenListener
                    public void onGetTokenComplete(JSONObject jSONObject) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                            Log.d(OneKeyLoginSdkCall.TAG, "SapiOnekeyOauthToken onGetTokenComplete result=" + jSONObject.toString());
                            this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        }
                    }
                });
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiRemoveLoginHistory extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiRemoveLoginHistory(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = null;
                try {
                    jSONObject2.put("errno", 0);
                    jSONObject = new JSONObject(command.getActionParams().get(0));
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    String optString = jSONObject.optString("portraitSign");
                    if (!TextUtils.isEmpty(optString)) {
                        SapiContext.getInstance().removeTouchidAccountByPortrait(optString);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray(FaceLoginService.KEY_FACE_LOGIN_LIVINGUNAMES);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        SapiContext.getInstance().markAsDeleteFaceLogin(optJSONArray);
                    }
                    String optString2 = jSONObject.optString("portrait");
                    if (!TextUtils.isEmpty(optString2)) {
                        String[] split = optString2.split("/");
                        String str = split[split.length - 1];
                        if (str.contains(".")) {
                            str = str.substring(0, str.lastIndexOf("."));
                        }
                        ShareUtils.markAsDeleteShareLogin(str);
                    }
                } catch (Exception e3) {
                    e = e3;
                    jSONObject3 = jSONObject;
                    Log.e(e);
                    jSONObject = jSONObject3;
                    if (jSONObject != null) {
                    }
                    return jSONObject2.toString();
                }
                if (jSONObject != null) {
                    try {
                        if (TextUtils.equals(jSONObject.optString("loginType"), "history")) {
                            LoginHistoryLoginModel.delBdussLoginHistoryInfo(jSONObject.optString("bduss"));
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return jSONObject2.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SapiShareAccountClick extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SapiShareAccountClick(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            String optString;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (System.currentTimeMillis() - this.this$0.preShareClickTime > 1000) {
                    this.this$0.preShareClickTime = System.currentTimeMillis();
                    try {
                        JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                        String optString2 = jSONObject.optString("pkg");
                        String optString3 = jSONObject.optString("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                        if (ShareUtils.SHARE_ACCOUNT_CLOUND_VERSION.equals(optString3)) {
                            optString = jSONObject.optString("portrait");
                        } else {
                            optString = jSONObject.optString("url");
                        }
                        String optString4 = jSONObject.optString("trace_id");
                        String optString5 = jSONObject.optString("session_id");
                        this.this$0.jsCallBacks.promptResult.confirm("finish");
                        ShareLoginStat.MakeShareLoginStat.sValueSence = "in";
                        this.this$0.jsCallBacks.shareAccountClickCallback.onClick(optString2, optString, optString4, optString5, optString3);
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SpeechRecognitionGetContent extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SpeechRecognitionGetContent(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                this.this$0.jsCallBacks.speechRecognitionCallback.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.SpeechRecognitionGetContent.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SpeechRecognitionGetContent this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiJsCallBacks.SpeechRecognitionResult
                    public void setSpeechData(int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) || this.this$1.this$0.jsCallBacks.promptResult == null) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i);
                            jSONObject.put("text", str);
                            this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e2) {
                            Log.e(e2);
                        }
                    }
                });
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SwitchAccountGetAccounts extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchAccountGetAccounts(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                List<SapiAccount> arrayList = new ArrayList<>();
                if (this.this$0.configuration.supportMultipleAccounts) {
                    arrayList = SapiContext.getInstance().getLoginAccounts();
                } else {
                    arrayList.add(SapiContext.getInstance().getCurrentAccount());
                }
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.SWITCH;
                JSONArray jSONArray = new JSONArray();
                try {
                    for (SapiAccount sapiAccount : arrayList) {
                        JSONObject jSONObject2 = sapiAccount.toJSONObject();
                        jSONObject2.put("portrait", sapiAccount.getCompletePortrait());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("errno", 0);
                    jSONObject.put("accountList", jSONArray);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SwitchAccountGetConfig extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchAccountGetConfig(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    jSONObject.put("showSwitchAccount", this.this$0.sapiWebView.showSwitchAccount ? 1 : 0);
                    jSONObject.put("showLinkAccount", this.this$0.sapiWebView.showLinkAccount ? 1 : 0);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SwitchAccountRemoveAccount extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchAccountRemoveAccount(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    String optString = new JSONObject(command.getActionParams().get(0)).optString("uid");
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    for (SapiAccount sapiAccount : SapiContext.getInstance().getLoginAccounts()) {
                        if (optString.equals(sapiAccount.uid)) {
                            SapiAccountManager.getInstance().removeLoginAccount(sapiAccount);
                            jSONObject.put("errno", 0);
                            return jSONObject.toString();
                        }
                    }
                    return null;
                } catch (Exception e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SwitchStyleForCloseBtnAndStatusBar extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchStyleForCloseBtnAndStatusBar(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                if (this.this$0.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack != null) {
                    try {
                        this.this$0.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack.switchStyle(new JSONObject(command.getActionParams().get(0)).optString("styleType"));
                        return null;
                    } catch (Exception e2) {
                        Log.e(e2);
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class TouchidChangeStatus extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchidChangeStatus(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errno", 0);
                    jSONObject.put("status", 0);
                    JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                    str = jSONObject2.optString("handle");
                    try {
                        str2 = jSONObject2.optString("portrait");
                        try {
                            str3 = jSONObject2.optString("portraitSign");
                        } catch (JSONException e2) {
                            e = e2;
                            Log.e(e);
                            str3 = null;
                            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                            currentAccount.phone = str2;
                            if (!"open".equals(str)) {
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str2 = null;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str = null;
                    str2 = null;
                }
                SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
                currentAccount2.phone = str2;
                if (!"open".equals(str)) {
                    currentAccount2.email = str3;
                    SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult(this, jSONObject, currentAccount2) { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidChangeStatus.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TouchidChangeStatus this$1;
                        public final /* synthetic */ SapiAccount val$currentAccount;
                        public final /* synthetic */ JSONObject val$json;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, jSONObject, currentAccount2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$json = jSONObject;
                            this.val$currentAccount = currentAccount2;
                        }

                        @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                        public void setResult(int i) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                                try {
                                    this.val$json.put("status", i);
                                    if (i == 0) {
                                        SapiContext.getInstance().addTouchidAccounts(this.val$currentAccount);
                                    }
                                    this.this$1.this$0.jsCallBacks.promptResult.confirm(this.val$json.toString());
                                } catch (Exception e5) {
                                    Log.e(e5);
                                }
                            }
                        }
                    };
                    if (this.this$0.jsCallBacks.fingerprintCallback != null) {
                        this.this$0.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
                    }
                    return null;
                }
                currentAccount2.email = "";
                SapiContext.getInstance().addTouchidAccounts(currentAccount2);
                this.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class TouchidCheckGuideStatus extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchidCheckGuideStatus(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    String optString = new JSONObject(command.getActionParams().get(0)).optString("portraitSign");
                    int fingerPrintState = FingerprintUtil.getFingerPrintState(this.this$0.configuration);
                    boolean contains = SapiContext.getInstance().getTouchidLoginRecord().contains(optString);
                    List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                    if (touchidAccounts != null) {
                        for (SapiAccount sapiAccount : touchidAccounts) {
                            if (sapiAccount != null && sapiAccount.email != null && sapiAccount.email.equals(optString)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    int i = (fingerPrintState != 0 || TextUtils.isEmpty(optString) || contains) ? 0 : 1;
                    if (!this.this$0.sapiWebView.supportTouchGuide) {
                        i = 0;
                    }
                    if (z) {
                        i = 0;
                    }
                    jSONObject.put("errno", 0);
                    jSONObject.put("guide", i);
                    if (TextUtils.isEmpty(optString)) {
                        str = "100";
                    } else if (fingerPrintState == 101 || fingerPrintState == 102) {
                        str = fingerPrintState + "";
                    } else if (contains) {
                        str = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
                    } else if (!this.this$0.sapiWebView.supportTouchGuide) {
                        str = TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT;
                    } else if (z) {
                        str = TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP;
                    } else {
                        str = fingerPrintState + "";
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(1);
                    linkedHashMap.put(TouchidLoginStat.VALUE_PAGE, str);
                    StatService.onEventAutoStatistic(linkedHashMap);
                    TouchidLoginStat.sValue = str;
                    TouchidLoginStat.upload();
                    if (i == 1) {
                        SapiContext.getInstance().addTouchidLoginRecord(optString);
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class TouchidGetStatus extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchidGetStatus(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i = 1;
                    if (FingerprintUtil.getFingerPrintState(this.this$0.configuration) == 0) {
                        List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        Iterator<SapiAccount> it = touchidAccounts.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            SapiAccount next = it.next();
                            if (next.equals(currentAccount) && !TextUtils.isEmpty(next.email)) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            i = 2;
                        }
                    } else {
                        i = 0;
                    }
                    jSONObject.put("errno", 0);
                    jSONObject.put("status", i);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return jSONObject.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class TouchidLogin extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchidLogin(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult(this) { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidLogin.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TouchidLogin this$1;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                    }

                    @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                    public void setResult(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                                jSONObject.put("status", i);
                                this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (Exception e2) {
                                Log.e(e2);
                            }
                        }
                    }
                };
                SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.TOUCHID;
                fingerprintResult.authType = 3;
                if (this.this$0.jsCallBacks.fingerprintCallback != null) {
                    this.this$0.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class TouchidOpenGuide extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TouchidOpenGuide(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                SapiJsCallBacks.FingerprintResult fingerprintResult = new SapiJsCallBacks.FingerprintResult(this, command) { // from class: com.baidu.sapi2.SapiJsInterpreters.TouchidOpenGuide.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TouchidOpenGuide this$1;
                    public final /* synthetic */ SapiWebView.Command val$command;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, command};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$command = command;
                    }

                    @Override // com.baidu.sapi2.SapiJsCallBacks.FingerprintResult
                    public void setResult(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                                jSONObject.put("status", i);
                                this.this$1.this$0.jsCallBacks.promptResult.confirm(jSONObject.toString());
                                if (i == 0) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(this.val$command.getActionParams().get(0));
                                        String optString = jSONObject2.optString("portrait");
                                        String optString2 = jSONObject2.optString("portraitSign");
                                        if (TextUtils.isEmpty(optString)) {
                                            String[] strArr = this.this$1.this$0.jsCallBacks.touchidPortraitAndSign;
                                            strArr[0] = this.this$1.this$0.configuration.environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
                                            String[] strArr2 = this.this$1.this$0.sapiWebView.touchidPortraitAndSign;
                                            strArr2[0] = this.this$1.this$0.configuration.environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
                                        } else {
                                            this.this$1.this$0.jsCallBacks.touchidPortraitAndSign[0] = optString;
                                            this.this$1.this$0.sapiWebView.touchidPortraitAndSign[0] = optString;
                                        }
                                        this.this$1.this$0.jsCallBacks.touchidPortraitAndSign[1] = optString2;
                                        this.this$1.this$0.sapiWebView.touchidPortraitAndSign[1] = optString2;
                                    } catch (Exception e2) {
                                        Log.e(e2);
                                    }
                                }
                            } catch (Exception e3) {
                                Log.e(e3);
                            }
                        }
                    }
                };
                if (this.this$0.jsCallBacks.fingerprintCallback != null) {
                    this.this$0.jsCallBacks.fingerprintCallback.onCallback(fingerprintResult);
                    return null;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class UniteVerifyResult extends AbstractInterpreter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SapiJsInterpreters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UniteVerifyResult(SapiJsInterpreters sapiJsInterpreters) {
            super(sapiJsInterpreters);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sapiJsInterpreters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((SapiJsInterpreters) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = sapiJsInterpreters;
        }

        @Override // com.baidu.sapi2.SapiJsInterpreters.AbstractInterpreter
        public String interpret(SapiWebView.Command command) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, command)) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString = jSONObject.optString("info");
                    String optString2 = jSONObject.optString("u");
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = jSONObject.optString("passuid");
                    sapiAccount.username = jSONObject.optString("username");
                    sapiAccount.displayname = jSONObject.optString("displayname");
                    sapiAccount.bduss = jSONObject.optString("bduss");
                    sapiAccount.ptoken = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                    sapiAccount.stoken = jSONObject.optString("stoken");
                    if (TextUtils.isEmpty(optString) || !SapiAccount.isValidAccount(sapiAccount) || this.this$0.jsCallBacks.uniteVerifyCallback == null) {
                        return null;
                    }
                    this.this$0.jsCallBacks.uniteVerifyCallback.onSuccess(optString, optString2, sapiAccount);
                    return null;
                } catch (JSONException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public SapiJsInterpreters(SapiWebView sapiWebView, SapiJsCallBacks.CallBacks callBacks) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sapiWebView, callBacks};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.interpreterHashMap = new HashMap<>();
        this.sapiWebView = sapiWebView;
        this.context = sapiWebView.getContext();
        this.jsCallBacks = callBacks;
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    private AbstractInterpreter buidInterpreterByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (AbstractInterpreter) Class.forName(interpreterNameToClassFullName(str)).getDeclaredConstructor(getClass()).newInstance(this);
            } catch (Exception e2) {
                Log.e(e2);
                return null;
            }
        }
        return (AbstractInterpreter) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String interpreterNameToClassFullName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            String[] split = str.split("_");
            StringBuilder sb = new StringBuilder();
            sb.append("com.baidu.sapi2.SapiJsInterpreters$");
            for (String str2 : split) {
                char[] charArray = str2.toCharArray();
                if (charArray[0] >= 'a' && charArray[0] <= 'z') {
                    charArray[0] = (char) (charArray[0] - ' ');
                }
                sb.append(new String(charArray));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public AbstractInterpreter getInterpreter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            AbstractInterpreter abstractInterpreter = this.interpreterHashMap.get(str);
            if (abstractInterpreter == null && (abstractInterpreter = buidInterpreterByName(str)) != null) {
                this.interpreterHashMap.put(str, abstractInterpreter);
            }
            return abstractInterpreter;
        }
        return (AbstractInterpreter) invokeL.objValue;
    }
}
