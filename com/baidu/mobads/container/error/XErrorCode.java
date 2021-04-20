package com.baidu.mobads.container.error;

import android.text.TextUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.util.Map;
/* loaded from: classes2.dex */
public class XErrorCode {
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MESSAGE = "error_message";
    public final RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();

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

    public void printErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        this.mAdLogger.e(genCompleteErrorMessage(xAdErrorCode, str));
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

    public void printErrorMessage(String str, String str2, String str3) {
        this.mAdLogger.e(genCompleteErrorMessage(str, str2, str3));
    }
}
