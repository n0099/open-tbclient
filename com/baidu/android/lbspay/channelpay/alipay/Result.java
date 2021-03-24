package com.baidu.android.lbspay.channelpay.alipay;

import com.alipay.sdk.util.l;
/* loaded from: classes2.dex */
public class Result {
    public static final String RESULT_CANCLE = "6001";
    public static final String RESULT_ERROR = "9999";
    public static final String RESULT_FAILED = "4000";
    public static final String RESULT_NETWROK_ERROR = "6002";
    public static final String RESULT_PAYING = "8000";
    public static final String RESULT_SUCCESS = "9000";
    public String memo;
    public String result;
    public String resultStatus;

    public Result(String str) {
        String[] split;
        try {
            for (String str2 : str.split(";")) {
                if (str2.startsWith(l.f1992a)) {
                    this.resultStatus = gatValue(str2, l.f1992a);
                }
                if (str2.startsWith("result")) {
                    this.result = gatValue(str2, "result");
                }
                if (str2.startsWith(l.f1993b)) {
                    this.memo = gatValue(str2, l.f1993b);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String gatValue(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.indexOf("}"));
    }

    public String toString() {
        return "resultStatus : " + this.resultStatus + ", result = " + this.result + ", memo = " + this.memo;
    }
}
