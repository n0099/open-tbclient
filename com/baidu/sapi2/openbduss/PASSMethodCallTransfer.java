package com.baidu.sapi2.openbduss;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes3.dex */
public class PASSMethodCallTransfer implements NoProguard {

    /* loaded from: classes3.dex */
    public static abstract class DynamicCallbak {
        public static final int ERROR_CODE_NOT_FIND_CALL_METHOD = -1002;
        public static final int ERROR_CODE_NOT_LOGIN = -1001;
        public static final int ERROR_CODE_PARAMS_ERROR = -1003;
        public static final String ERROR_MSG_NOT_FIND_CALL_METHOD = "未找到反射方法";
        public static final String ERROR_MSG_NOT_LOGIN = "未登录";
        public static final String ERROR_MSG_PARAMS_ERROR = "参数错误";

        public abstract void onFailure(int i, String str);
    }

    /* loaded from: classes3.dex */
    public static class ParamsWap {
        public static String BDUSS = "2";
        public static String UID = "1";
        public Map<String, String> attributes;
        public Object param;
    }

    private Object[] buildParams(Object[] objArr, SapiAccount sapiAccount) {
        Object[] objArr2 = new Object[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof ParamsWap)) {
                objArr2[i] = obj;
            } else {
                ParamsWap paramsWap = (ParamsWap) obj;
                Map<String, String> map = paramsWap.attributes;
                if (map == null) {
                    objArr2[i] = paramsWap.param;
                } else {
                    for (String str : map.keySet()) {
                        Object obj2 = null;
                        if (ParamsWap.UID.equals(str)) {
                            obj2 = setObjectValue(paramsWap.param, paramsWap.attributes.get(str), sapiAccount.uid);
                        } else if (ParamsWap.BDUSS.equals(str)) {
                            obj2 = setObjectValue(paramsWap.param, paramsWap.attributes.get(str), sapiAccount.bduss);
                        }
                        objArr2[i] = obj2;
                    }
                }
            }
        }
        return objArr2;
    }

    private Object setObjectValue(Object obj, String str, String str2) {
        if (obj != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (obj instanceof String) {
                return str2;
            }
            if (obj instanceof Map) {
                ((Map) obj).put(str, str2);
                return obj;
            } else if (obj.getClass().isArray()) {
                ((Object[]) obj)[Integer.valueOf(str).intValue()] = str2;
                return obj;
            } else {
                try {
                    Field field = obj.getClass().getField(str);
                    field.setAccessible(true);
                    field.set(str, str2);
                    return obj;
                } catch (Exception e) {
                    Log.e(e);
                    return obj;
                }
            }
        }
        return obj;
    }

    public Object dynamicCallMethod(Object obj, Object[] objArr, String str, DynamicCallbak dynamicCallbak, Class<?>... clsArr) {
        Class<?> cls;
        SapiUtils.notNull(dynamicCallbak, "DynamicCallbak can't be null");
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            dynamicCallbak.onFailure(-1001, "未登录");
            return null;
        } else if (obj != null && !TextUtils.isEmpty(str) && clsArr != null) {
            Object[] buildParams = buildParams(objArr, currentAccount);
            boolean z = obj instanceof Class;
            if (z) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            if (z) {
                obj = null;
            }
            try {
                return cls.getDeclaredMethod(str, clsArr).invoke(obj, buildParams);
            } catch (Exception e) {
                Log.e(e);
                dynamicCallbak.onFailure(-1002, DynamicCallbak.ERROR_MSG_NOT_FIND_CALL_METHOD);
                return null;
            }
        } else {
            dynamicCallbak.onFailure(-1003, "参数错误");
            return null;
        }
    }
}
