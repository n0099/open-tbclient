package com.baidu.mobads.d;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements IXAdErrorCode {

    /* renamed from: a  reason: collision with root package name */
    public final IXAdLogger f8213a;

    public b(IXAdLogger iXAdLogger) {
        this.f8213a = iXAdLogger;
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
    public String genCompleteErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        if (xAdErrorCode == null) {
            return "";
        }
        return a(xAdErrorCode.getCode() + "", xAdErrorCode.getMessage(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002e -> B:11:0x002e). Please submit an issue!!! */
    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getMessage(Map<String, Object> map) {
        String str;
        if (map != null) {
            try {
                if (map.containsKey("msg")) {
                    str = XAdSDKFoundationFacade.getInstance().getErrorCode().genCompleteErrorMessage((XAdErrorCode) map.get("msg"), "");
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

    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    public void printErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        this.f8213a.e(genCompleteErrorMessage(xAdErrorCode, str));
    }

    @Override // com.baidu.mobads.interfaces.error.IXAdErrorCode
    public void printErrorMessage(String str, String str2, String str3) {
        this.f8213a.e(a(str, str2, str3));
    }
}
