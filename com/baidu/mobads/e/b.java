package com.baidu.mobads.e;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.Map;
/* loaded from: classes10.dex */
public class b implements IXAdErrorCode {
    protected final IXAdLogger a;

    public b(IXAdLogger iXAdLogger) {
        this.a = iXAdLogger;
    }

    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    public void printErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        this.a.e(genCompleteErrorMessage(xAdErrorCode, str));
    }

    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    public void printErrorMessage(String str, String str2, String str3) {
        this.a.e(a(str, str2, str3));
    }

    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    public String genCompleteErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        return xAdErrorCode == null ? "" : a(xAdErrorCode.getCode() + "", xAdErrorCode.getMessage(), str);
    }

    public String a(String str, String str2, String str3) {
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

    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    public String getMessage(Map<String, Object> map) {
        String str = "";
        if (map != null) {
            try {
                if (map.containsKey("msg")) {
                    str = XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage((XAdErrorCode) map.get("msg"), "");
                } else if (map.containsKey("error_message")) {
                    str = (String) map.get("error_message");
                }
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
