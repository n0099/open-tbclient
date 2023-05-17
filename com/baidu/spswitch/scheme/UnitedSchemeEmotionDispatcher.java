package com.baidu.spswitch.scheme;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.view.EmotionEffectView;
import com.baidu.spswitch.utils.EmotionEffectUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
@Service
/* loaded from: classes4.dex */
public class UnitedSchemeEmotionDispatcher extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_TYPE_SHOW_EFFECT = "showeffect";
    public static final boolean DEBUG;
    public static final String KEY_PARAMS = "params";
    public static final String MODULE_EMOTION = "emoticon";
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? MODULE_EMOTION : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1149904507, "Lcom/baidu/spswitch/scheme/UnitedSchemeEmotionDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1149904507, "Lcom/baidu/spswitch/scheme/UnitedSchemeEmotionDispatcher;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        TAG = UnitedSchemeEmotionDispatcher.class.getSimpleName();
    }

    public UnitedSchemeEmotionDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private boolean doShowEffect(Context context, HashMap<String, String> hashMap, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, context, hashMap, callbackHandler, unitedSchemeEntity)) == null) {
            if ((context instanceof Activity) && hashMap != null && unitedSchemeEntity != null) {
                try {
                    UiThreadUtils.runOnUiThread(new Runnable(this, (Activity) context, new JSONObject(hashMap.get("params")), callbackHandler, unitedSchemeEntity) { // from class: com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ UnitedSchemeEmotionDispatcher this$0;
                        public final /* synthetic */ JSONObject val$contextParam;
                        public final /* synthetic */ UnitedSchemeEntity val$entity;
                        public final /* synthetic */ CallbackHandler val$handler;
                        public final /* synthetic */ Activity val$mAttachedActivity;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, r8, callbackHandler, unitedSchemeEntity};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$mAttachedActivity = r7;
                            this.val$contextParam = r8;
                            this.val$handler = callbackHandler;
                            this.val$entity = unitedSchemeEntity;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                EmotionEffectUtils.play((ViewGroup) this.val$mAttachedActivity.getWindow().getDecorView(), this.val$contextParam.optString("text"), NightModeHelper.isNightMode(), Integer.valueOf(EmotionEffectUtils.getGravityType(this.val$contextParam.optString("alignment"))), 0, new EmotionEffectView.OnEmotionEffectListener(this) { // from class: com.baidu.spswitch.scheme.UnitedSchemeEmotionDispatcher.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    @Override // com.baidu.spswitch.emotion.view.EmotionEffectView.OnEmotionEffectListener
                                    public void onStart() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                        }
                                    }

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.spswitch.emotion.view.EmotionEffectView.OnEmotionEffectListener
                                    public void onEnd(boolean z) {
                                        AnonymousClass1 anonymousClass1;
                                        CallbackHandler callbackHandler2;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) && (callbackHandler2 = (anonymousClass1 = this.this$1).val$handler) != null) {
                                            String optString = anonymousClass1.val$contextParam.optString("event_callback");
                                            callbackHandler2.handleSchemeDispatchCallback(optString, z + "");
                                        }
                                    }
                                });
                                UnitedSchemeEntity unitedSchemeEntity2 = this.val$entity;
                                unitedSchemeEntity2.result = UnitedSchemeUtility.callCallback(this.val$handler, unitedSchemeEntity2, 0);
                            }
                        }
                    });
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    if (!unitedSchemeEntity.isOnlyVerify()) {
                        UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(unitedSchemeEntity.getSource(), unitedSchemeEntity.getUri());
                        return true;
                    }
                    return true;
                } catch (Exception e) {
                    if (DEBUG) {
                        e.printStackTrace();
                        Log.i(TAG, e.toString());
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
            }
            if (unitedSchemeEntity != null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            String path = unitedSchemeEntity.getPath(false);
            if (TextUtils.isEmpty(path)) {
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
                }
                if (DEBUG) {
                    Log.w(TAG, "Uri action is null");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            } else if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            } else {
                HashMap<String, String> params = unitedSchemeEntity.getParams();
                if (TextUtils.equals(path.toLowerCase(Locale.getDefault()), ACTION_TYPE_SHOW_EFFECT)) {
                    return doShowEffect(context, params, callbackHandler, unitedSchemeEntity);
                }
                if (!unitedSchemeEntity.isOnlyVerify()) {
                    UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unkown action");
                }
                if (DEBUG) {
                    Log.w(TAG, "Uri action is unkown");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
