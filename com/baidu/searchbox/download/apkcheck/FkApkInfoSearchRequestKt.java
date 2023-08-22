package com.baidu.searchbox.download.apkcheck;

import com.baidu.android.common.util.CommonParam;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.apkcheck.FkApkInfoSearchRequestKt;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\u001a1\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020 0$\u001a%\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\"2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010,H\u0002¢\u0006\u0002\u0010-\u001a3\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00032!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020 0$H\u0002\u001a\u0012\u00101\u001a\u0004\u0018\u00010\u00032\u0006\u00102\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"AUTHORITY_FAIL", "", "COM", "", "EXTRA_KEY_ORIGINALURI", "EXTRA_KEY_REFER", "FK_URL", "KEY_CODE", "KEY_SUB_CODE", "PARAMS_KEY_APP_NAME", "PARAMS_KEY_COM", "PARAMS_KEY_CUID", "PARAMS_KEY_DATA", "PARAMS_KEY_DLURL", "PARAMS_KEY_FILE_MD5", "PARAMS_KEY_PKG_NAME", "PARAMS_KEY_REFERER", "PARAMS_KEY_SIGN", "PARAMS_KEY_SIGN_MD5", "PARAMS_KEY_TS", "PARAMS_KEY_VERSION", "REQ_TIMEOUT_MS", "RESULT_CODE_BLACK", "RESULT_CODE_GRAY", "RESULT_CODE_UNKNOWN", "RESULT_CODE_WHITE", "RESULT_SUB_CODE_FAKE", "RESULT_SUB_CODE_GAMBLE", "RESULT_SUB_CODE_TRASHY", "RESULT_SUB_CODE_UNKNOWN", "SECRET", "checkApkStatus", "", "data", "Lcom/baidu/searchbox/download/model/CategoryInfoData;", "apkCheckCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isBlackApk", "generateParams", "categoryInfoData", "apkInfo", "", "(Lcom/baidu/searchbox/download/model/CategoryInfoData;[Ljava/lang/String;)Ljava/lang/String;", "reqApkStatus", "params", "isBlackApp", "stringToMD5", EMABTest.TYPE_STRING, "lib-download_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FkApkInfoSearchRequestKt {
    public static final int AUTHORITY_FAIL = 401;
    public static final String COM = "5685747711";
    public static final String EXTRA_KEY_ORIGINALURI = "originalUri";
    public static final String EXTRA_KEY_REFER = "refer";
    public static final String FK_URL = "https://safebrowsing.baidu.com/fk/pkginfo/search/v3";
    public static final String KEY_CODE = "code";
    public static final String KEY_SUB_CODE = "sub_code";
    public static final String PARAMS_KEY_APP_NAME = "app_name";
    public static final String PARAMS_KEY_COM = "com";
    public static final String PARAMS_KEY_CUID = "cuid";
    public static final String PARAMS_KEY_DATA = "data";
    public static final String PARAMS_KEY_DLURL = "dlUrl";
    public static final String PARAMS_KEY_FILE_MD5 = "file_md5";
    public static final String PARAMS_KEY_PKG_NAME = "pkg_name";
    public static final String PARAMS_KEY_REFERER = "referer";
    public static final String PARAMS_KEY_SIGN = "sign";
    public static final String PARAMS_KEY_SIGN_MD5 = "sign_md5";
    public static final String PARAMS_KEY_TS = "ts";
    public static final String PARAMS_KEY_VERSION = "version";
    public static final int REQ_TIMEOUT_MS = 3000;
    public static final int RESULT_CODE_BLACK = 1;
    public static final int RESULT_CODE_GRAY = 2;
    public static final int RESULT_CODE_UNKNOWN = -1;
    public static final int RESULT_CODE_WHITE = 0;
    public static final int RESULT_SUB_CODE_FAKE = 0;
    public static final int RESULT_SUB_CODE_GAMBLE = 2;
    public static final int RESULT_SUB_CODE_TRASHY = 1;
    public static final int RESULT_SUB_CODE_UNKNOWN = -1;
    public static final String SECRET = "9ibTzkf6g4SiTyzZTsqsJm";

    public static final void checkApkStatus(final CategoryInfoData data, final Function1<? super Boolean, Unit> apkCheckCallback) {
        final String[] strArr;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(apkCheckCallback, "apkCheckCallback");
        try {
            strArr = ApkUtil.parsePackageInfo(AppRuntime.getAppContext(), data.mDownloadPath);
        } catch (Throwable unused) {
            strArr = null;
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.tieba.en1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    FkApkInfoSearchRequestKt.m77checkApkStatus$lambda1(CategoryInfoData.this, strArr, apkCheckCallback);
                }
            }
        }, "checkApkStatus", 2);
    }

    /* renamed from: reqApkStatus$lambda-5$lambda-4  reason: not valid java name */
    public static final void m81reqApkStatus$lambda5$lambda4(Function1 apkCheckCallback, boolean z) {
        Intrinsics.checkNotNullParameter(apkCheckCallback, "$apkCheckCallback");
        apkCheckCallback.invoke(Boolean.valueOf(z));
    }

    /* renamed from: checkApkStatus$lambda-1  reason: not valid java name */
    public static final void m77checkApkStatus$lambda1(CategoryInfoData data, String[] strArr, final Function1 apkCheckCallback) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(apkCheckCallback, "$apkCheckCallback");
        try {
            reqApkStatus(generateParams(data, strArr), apkCheckCallback);
        } catch (Exception unused) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.bn1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        FkApkInfoSearchRequestKt.m78checkApkStatus$lambda1$lambda0(Function1.this);
                    }
                }
            });
        }
    }

    /* renamed from: checkApkStatus$lambda-1$lambda-0  reason: not valid java name */
    public static final void m78checkApkStatus$lambda1$lambda0(Function1 apkCheckCallback) {
        Intrinsics.checkNotNullParameter(apkCheckCallback, "$apkCheckCallback");
        apkCheckCallback.invoke(Boolean.FALSE);
    }

    /* renamed from: reqApkStatus$lambda-2  reason: not valid java name */
    public static final void m79reqApkStatus$lambda2(Function1 apkCheckCallback) {
        Intrinsics.checkNotNullParameter(apkCheckCallback, "$apkCheckCallback");
        apkCheckCallback.invoke(Boolean.FALSE);
    }

    /* renamed from: reqApkStatus$lambda-3  reason: not valid java name */
    public static final void m80reqApkStatus$lambda3(Function1 apkCheckCallback) {
        Intrinsics.checkNotNullParameter(apkCheckCallback, "$apkCheckCallback");
        apkCheckCallback.invoke(Boolean.FALSE);
    }

    /* renamed from: reqApkStatus$lambda-6  reason: not valid java name */
    public static final void m82reqApkStatus$lambda6(Function1 apkCheckCallback) {
        Intrinsics.checkNotNullParameter(apkCheckCallback, "$apkCheckCallback");
        apkCheckCallback.invoke(Boolean.FALSE);
    }

    public static final String generateParams(CategoryInfoData categoryInfoData, String[] strArr) {
        String str = categoryInfoData.mDownloadPath;
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PARAMS_KEY_COM, COM);
        jSONObject.put("ts", valueOf);
        jSONObject.put("sign", stringToMD5("9ibTzkf6g4SiTyzZTsqsJmcom5685747711ts" + valueOf + SECRET));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("data", jSONObject2);
        jSONObject2.put("cuid", CommonParam.getCUID(AppRuntime.getApplication()));
        jSONObject2.put(PARAMS_KEY_FILE_MD5, new BigInteger(1, ApkUtil.toMd5(str)).toString(16));
        String str2 = "";
        jSONObject2.put("pkg_name", (strArr == null || (r4 = (String) ArraysKt___ArraysKt.getOrNull(strArr, 1)) == null) ? "" : "");
        jSONObject2.put("app_name", (strArr == null || (r4 = (String) ArraysKt___ArraysKt.getOrNull(strArr, 0)) == null) ? "" : "");
        jSONObject2.put("version", (strArr == null || (r7 = (String) ArraysKt___ArraysKt.getOrNull(strArr, 3)) == null) ? "" : "");
        try {
            String apkMd5Signatures = ApkUtil.getApkMd5Signatures(str);
            if (apkMd5Signatures != null) {
                str2 = apkMd5Signatures;
            }
            jSONObject2.put(PARAMS_KEY_SIGN_MD5, str2);
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
        try {
            JSONObject jSONObject3 = new JSONObject(categoryInfoData.mExtraInfo);
            jSONObject2.put("referer", jSONObject3.optString("refer"));
            jSONObject2.put(PARAMS_KEY_DLURL, jSONObject3.optString("originalUri"));
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        String jSONObject4 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "json.toString()");
        return jSONObject4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
        if (r4.length() != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b8, code lost:
        r6 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void reqApkStatus(String str, final Function1<? super Boolean, Unit> function1) {
        String str2;
        ResponseBody body;
        final boolean z = false;
        CookieManager cookieManager = HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(false, false);
        int i = DownloadSharedPrefsUtils.getInstance().getInt(DownloadCenterUtils.SHOW_APK_CHECK_REQUEST_INTERVAL, 3000);
        try {
            Response executeSync = ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postRequest().requestBody(RequestBody.create(MediaType.parse("application/json"), str)).url(FK_URL)).cookieManager(cookieManager)).autoRetry(false)).readTimeout(i)).connectionTimeout(i)).writeTimeout(i)).enableStat(true)).requestFrom(10)).requestSubFrom(1022)).build().executeSync();
            Integer num = null;
            if (executeSync != null && (body = executeSync.body()) != null) {
                str2 = body.string();
            } else {
                str2 = null;
            }
            if (executeSync != null) {
                num = Integer.valueOf(executeSync.code());
            }
            if (num != null && num.intValue() == 401) {
                ApkCheckUBCManagerKt.apkCheckExceptionEvent("identity");
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.cn1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            FkApkInfoSearchRequestKt.m79reqApkStatus$lambda2(Function1.this);
                        }
                    }
                });
                return;
            }
            boolean z2 = true;
            if (z2) {
                ApkCheckUBCManagerKt.apkCheckExceptionEvent("other");
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.dn1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            FkApkInfoSearchRequestKt.m80reqApkStatus$lambda3(Function1.this);
                        }
                    }
                });
                return;
            }
            if (new JSONObject(str2).optInt("code", -1) == 1) {
                z = true;
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.jn1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        FkApkInfoSearchRequestKt.m81reqApkStatus$lambda5$lambda4(Function1.this, z);
                    }
                }
            });
        } catch (Exception e) {
            if (e instanceof SocketTimeoutException) {
                ApkCheckUBCManagerKt.apkCheckExceptionEvent(ApkCheckUBCManagerKt.SOURCE_OVERTIME);
            } else {
                ApkCheckUBCManagerKt.apkCheckExceptionEvent("other");
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.gn1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        FkApkInfoSearchRequestKt.m82reqApkStatus$lambda6(Function1.this);
                    }
                }
            });
        }
    }

    public static final String stringToMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] digest = messageDigest.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "{\n        MessageDigest.…ardCharsets.UTF_8))\n    }");
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
