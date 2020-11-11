package com.baidu.sapi2.result;
/* loaded from: classes5.dex */
public class OneKeyLoginResult extends SapiResult {
    public static final int ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT = -109;
    public static final int ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL = -106;
    public static final int ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL = -108;
    public static final int ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT = -112;
    public static final int ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL = -107;
    public static final int ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL = -105;
    public static final int ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL = -102;
    public static final int ONE_KEY_LOGIN_CODE_HIT_RISK_MANAGEMENT = -111;
    public static final int ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS = -104;
    public static final int ONE_KEY_LOGIN_CODE_IS_LOGIN_WHEN_SECOND_PRE_PHONE = -110;
    public static final int ONE_KEY_LOGIN_CODE_LOGIN_FAIL = -103;
    public static final int ONE_KEY_LOGIN_CODE_UNKNOW = -100;
    public static final int ONE_KEY_LOGIN_CODE_UNSUPPORT = -101;

    /* renamed from: a  reason: collision with root package name */
    private static final String f3490a = "未知错误";
    private static final String b = "不支持一键登录";
    private static final String c = "获取token失败";
    private static final String d = "一键登录失败";
    private static final String e = "进行引导流程中";
    private static final String f = "获取JS代码失败";
    private static final String g = "JS代码校验失败";
    private static final String h = "执行JS代码失败";
    private static final String i = "sign签名校验失败";
    private static final String j = "Android版本低于KITKAT";
    private static final String k = "冷启预取号失败，二次取号时已登录";
    private static final String l = "一键登录命中风控，登录失败";
    private static final String m = "请求超时";
    public static String secondJsCode;
    public boolean enable;
    public String encryptPhoneNum;
    public boolean hasHistory;
    public String operator;
    public String sign;

    public OneKeyLoginResult() {
        this.msgMap.put(-100, f3490a);
        this.msgMap.put(-101, b);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_GET_TOKEN_FAIL, c);
        this.msgMap.put(-103, d);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_IN_GUIDE_PROCESS, e);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_GET_JS_CODE_FAIL, f);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_CHECK_JS_FAIL, g);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_EXECUTE_JS_FAIL, h);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_CHECK_SIGN_FAIL, i);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT, j);
        this.msgMap.put(-110, k);
        this.msgMap.put(-111, l);
        this.msgMap.put(ONE_KEY_LOGIN_CODE_CONNECTION_TIMEOUT, m);
    }
}
