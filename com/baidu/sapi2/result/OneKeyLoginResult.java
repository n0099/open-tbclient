package com.baidu.sapi2.result;
/* loaded from: classes3.dex */
public class OneKeyLoginResult extends SapiResult {
    public static final int ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT = -109;
    public static final int ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL = -106;
    public static final int ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL = -108;
    public static final int ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT = -112;
    public static final int ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL = -107;
    public static final int ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL = -105;
    public static final int ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL = -102;
    public static final int ONE_KEY_LOGIN_CODE_HIT_RISK_MANAGEMENT = -111;
    public static final int ONE_KEY_LOGIN_CODE_INVALID_OPERATOR = -115;
    public static final int ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS = -104;
    public static final int ONE_KEY_LOGIN_CODE_IS_LOGIN_WHEN_SECOND_PRE_PHONE = -110;
    public static final int ONE_KEY_LOGIN_CODE_JSON_ERROR = -113;
    public static final int ONE_KEY_LOGIN_CODE_LOGIN_FAIL = -103;
    public static final int ONE_KEY_LOGIN_CODE_NET_ERROR = -114;
    public static final int ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY = -121;
    public static final int ONE_KEY_LOGIN_CODE_UNKNOW = -100;
    public static final int ONE_KEY_LOGIN_CODE_UNSUPPORT = -101;
    public static final String ONE_KEY_LOGIN_MSG_ANDROID_VERSION_BELOW_KITKAT = "Android版本低于KITKAT";
    public static final String ONE_KEY_LOGIN_MSG_CHECK_JS_FAIL = "JS代码校验失败";
    public static final String ONE_KEY_LOGIN_MSG_CHECK_SIGN_FAIL = "sign签名校验失败";
    public static final String ONE_KEY_LOGIN_MSG_CONNECTION_TIMEOUT = "请求超时";
    public static final String ONE_KEY_LOGIN_MSG_EXECUTE_JS_FAIL = "执行JS代码失败";
    public static final String ONE_KEY_LOGIN_MSG_GET_JS_CODE_FAIL = "获取JS代码失败";
    public static final String ONE_KEY_LOGIN_MSG_GET_TOKEN_FAIL = "获取token失败";
    public static final String ONE_KEY_LOGIN_MSG_HIT_RISK_MANAGEMENT = "一键登录命中风控，登录失败";
    public static final String ONE_KEY_LOGIN_MSG_INVALID_OPERATOR = "非法的运营商信息";
    public static final String ONE_KEY_LOGIN_MSG_IN_GUIDE_PROCESS = "进行引导流程中";
    public static final String ONE_KEY_LOGIN_MSG_IS_LOGIN_WHEN_SECOND_PRE_PHONE = "冷启预取号失败，二次取号时已登录";
    public static final String ONE_KEY_LOGIN_MSG_LOGIN_FAIL = "一键登录失败";
    public static final String ONE_KEY_LOGIN_MSG_NOT_MEET_GRAY = "该TPL的运营商服务暂停";
    public static final String ONE_KEY_LOGIN_MSG_UNKNOW = "未知错误";
    public static final String ONE_KEY_LOGIN_MSG_UNSUPPORT = "不支持一键登录";
    public static String secondJsCode;
    public boolean enable;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public String mobile;
    public String operator;
    public String sign;

    public OneKeyLoginResult() {
        this.msgMap.put(-100, "未知错误");
        this.msgMap.put(-101, ONE_KEY_LOGIN_MSG_UNSUPPORT);
        this.msgMap.put(-102, ONE_KEY_LOGIN_MSG_GET_TOKEN_FAIL);
        this.msgMap.put(-103, ONE_KEY_LOGIN_MSG_LOGIN_FAIL);
        this.msgMap.put(-104, ONE_KEY_LOGIN_MSG_IN_GUIDE_PROCESS);
        this.msgMap.put(-105, ONE_KEY_LOGIN_MSG_GET_JS_CODE_FAIL);
        this.msgMap.put(-106, ONE_KEY_LOGIN_MSG_CHECK_JS_FAIL);
        this.msgMap.put(-107, ONE_KEY_LOGIN_MSG_EXECUTE_JS_FAIL);
        this.msgMap.put(-108, ONE_KEY_LOGIN_MSG_CHECK_SIGN_FAIL);
        this.msgMap.put(-109, ONE_KEY_LOGIN_MSG_ANDROID_VERSION_BELOW_KITKAT);
        this.msgMap.put(-110, ONE_KEY_LOGIN_MSG_IS_LOGIN_WHEN_SECOND_PRE_PHONE);
        this.msgMap.put(-111, ONE_KEY_LOGIN_MSG_HIT_RISK_MANAGEMENT);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, ONE_KEY_LOGIN_MSG_CONNECTION_TIMEOUT);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY, ONE_KEY_LOGIN_MSG_NOT_MEET_GRAY);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_INVALID_OPERATOR, ONE_KEY_LOGIN_MSG_INVALID_OPERATOR);
    }
}
