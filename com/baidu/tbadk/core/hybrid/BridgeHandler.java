package com.baidu.tbadk.core.hybrid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.k35;
import com.baidu.tieba.n35;
import com.baidu.tieba.p35;
import com.baidu.tieba.t35;
import com.baidu.tieba.u35;
import com.baidu.tieba.v35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class BridgeHandler implements p35 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t35 bridge;
    public final HashMap<String, Method> methods;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tbadk.core.hybrid.BridgeHandler */
    /* JADX WARN: Multi-variable type inference failed */
    public BridgeHandler(t35 t35Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t35Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bridge = t35Var;
        this.methods = new HashMap<>();
        loadMethods(getClass());
        if (!this.methods.isEmpty()) {
            return;
        }
        throw new IllegalStateException("No native methods found!");
    }

    private void loadMethods(Class<? extends BridgeHandler> cls) {
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, cls) == null) {
            for (Method method : cls.getDeclaredMethods()) {
                String str = null;
                v35 v35Var = (v35) method.getAnnotation(v35.class);
                if (v35Var != null) {
                    String value = v35Var.value();
                    if (!TextUtils.isEmpty(value)) {
                        str = value;
                    }
                    if (v35Var.isAsync() && !Void.TYPE.equals(method.getReturnType())) {
                        throw new IllegalArgumentException("Method with async flag should return void.");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = method.getName();
                    }
                    method.setAccessible(true);
                    this.methods.put(str, method);
                }
            }
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null && superclass != cls) {
                loadMethods(superclass);
            }
        }
    }

    private void unknownMethod(String str, JSONObject jSONObject, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, this, str, jSONObject, str2, str3) == null) {
            String optString = jSONObject.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                n35.a("method " + str + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_MSG, str3);
            this.bridge.c(u35.k(optString, hashMap));
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bridge.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p35
    public void handle(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, jSONObject2) == null) {
            Method method = this.methods.get(str);
            if (method != null) {
                v35 v35Var = (v35) method.getAnnotation(v35.class);
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                try {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!v35Var.isAsync()) {
                        if (parameterTypes.length == 2) {
                            invoke = method.invoke(this, optString, jSONObject);
                        } else if (parameterTypes.length == 1) {
                            invoke = method.invoke(this, jSONObject);
                        } else if (parameterTypes.length == 0) {
                            n35.a("native method " + getClass().getSimpleName() + ":" + v35Var.value() + " ignored all parameters.");
                            invoke = method.invoke(this, new Object[0]);
                        } else {
                            unknownMethod(str, jSONObject2, "500", "parameters too much!");
                            return;
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            sendResponseToJS(optString, (JSONObject) invoke);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 2) {
                        method.invoke(this, optString, jSONObject);
                        return;
                    } else if (parameterTypes.length == 1) {
                        method.invoke(this, jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            sendResponseToJS(optString, null);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 0) {
                        n35.a("native method " + getClass().getSimpleName() + ":" + v35Var.value() + " ignored all parameters.");
                        method.invoke(this, new Object[0]);
                        if (!TextUtils.isEmpty(optString)) {
                            sendResponseToJS(optString, null);
                            return;
                        }
                        return;
                    } else {
                        unknownMethod(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                } catch (IllegalAccessException e) {
                    n35.a("native method call error:" + e.getMessage());
                    unknownMethod(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT, "IllegalAccessException:" + e.getMessage());
                    return;
                } catch (InvocationTargetException e2) {
                    n35.a("native method call error:" + e2.getMessage());
                    unknownMethod(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC, "InvocationTargetException:" + e2.getMessage());
                    return;
                } catch (Exception e3) {
                    n35.a("native method call error:" + e3.getMessage());
                    unknownMethod(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_OFFLINE_DEBUG, "Native call exception:" + e3.getMessage());
                    return;
                }
            }
            unknownMethod(str, jSONObject2, "403", "method " + str + " not exists");
        }
    }

    public void sendMessage(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            k35.a(message);
        }
    }

    public void sendMessageAsync(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, message) == null) {
            k35.b(message);
        }
    }

    public void sendResponseToJS(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                n35.a("sendResponseToJS got empty callbackId.");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "0");
            hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "success");
            if (jSONObject != null) {
                hashMap.put("data", jSONObject);
            }
            this.bridge.c(u35.k(str, hashMap));
        }
    }
}
