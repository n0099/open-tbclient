package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.Map;
/* loaded from: classes2.dex */
public class XErrorCode {
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MESSAGE = "error_message";
    public static volatile XErrorCode shareInstance;
    public final XAdLogger mAdLogger = XAdLogger.getInstance();

    public static XErrorCode getInstance() {
        if (shareInstance == null) {
            synchronized (XErrorCode.class) {
                if (shareInstance == null) {
                    shareInstance = new XErrorCode();
                }
            }
        }
        return shareInstance;
    }

    public String genCompleteErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        if (xAdErrorCode == null) {
            return "";
        }
        return genCompleteErrorMessage(xAdErrorCode.getCode() + "", xAdErrorCode.getMessage(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0026 -> B:11:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getMessage(Map<String, Object> map) {
        String str;
        if (map != null) {
            try {
                if (map.containsKey("msg")) {
                    str = genCompleteErrorMessage((XAdErrorCode) map.get("msg"), "");
                } else if (map.containsKey("error_message")) {
                    str = (String) map.get("error_message");
                }
            } catch (Exception unused) {
            }
            return str != null ? "" : str;
        }
        str = "";
        if (str != null) {
        }
    }

    public String genCompleteErrorMessage(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }
}
