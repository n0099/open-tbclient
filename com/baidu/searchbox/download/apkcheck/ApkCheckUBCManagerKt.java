package com.baidu.searchbox.download.apkcheck;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0006\u0010\u0012\u001a\u00020\u0011\u001a\u0006\u0010\u0013\u001a\u00020\u0011\u001a\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0006\u0010\u0016\u001a\u00020\u0011\u001a\u0006\u0010\u0017\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"FROM", "", "PAGE", "SOURCE_CLOSE", "SOURCE_DELETE", "SOURCE_IDENTITY", "SOURCE_OTHER", "SOURCE_OVERTIME", "TYPE_ABNORMAL", "TYPE_CLICK", "TYPE_IN", "TYPE_SHOW", "TYPE_SUCCESS", "UBC_ID", "VALUE_INSTALL", "VALUE_WINDOW", "apkCheckCloseDialogEvent", "", "apkCheckDelEvent", "apkCheckDialogShowEvent", "apkCheckExceptionEvent", "source", "apkCheckInstallEvent", "startApkCheckEvent", "lib-download_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApkCheckUBCManagerKt {
    public static final String FROM = "tool";
    public static final String PAGE = "check";
    public static final String SOURCE_CLOSE = "close";
    public static final String SOURCE_DELETE = "delete";
    public static final String SOURCE_IDENTITY = "identity";
    public static final String SOURCE_OTHER = "other";
    public static final String SOURCE_OVERTIME = "overtime";
    public static final String TYPE_ABNORMAL = "abnormal";
    public static final String TYPE_CLICK = "click";
    public static final String TYPE_IN = "in";
    public static final String TYPE_SHOW = "show";
    public static final String TYPE_SUCCESS = "success";
    public static final String UBC_ID = "4087";
    public static final String VALUE_INSTALL = "install";
    public static final String VALUE_WINDOW = "window";

    public static final void apkCheckCloseDialogEvent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "click");
            jSONObject.put("from", "tool");
            jSONObject.put("page", PAGE);
            jSONObject.put("value", VALUE_WINDOW);
            jSONObject.put("source", "close");
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(UBC_ID, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static final void apkCheckDelEvent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "click");
            jSONObject.put("from", "tool");
            jSONObject.put("page", PAGE);
            jSONObject.put("value", VALUE_WINDOW);
            jSONObject.put("source", "delete");
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(UBC_ID, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static final void apkCheckDialogShowEvent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "show");
            jSONObject.put("from", "tool");
            jSONObject.put("page", PAGE);
            jSONObject.put("value", VALUE_WINDOW);
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(UBC_ID, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static final void apkCheckInstallEvent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "success");
            jSONObject.put("from", "tool");
            jSONObject.put("page", PAGE);
            jSONObject.put("value", "install");
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(UBC_ID, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static final void apkCheckExceptionEvent(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", TYPE_ABNORMAL);
            jSONObject.put("from", "tool");
            jSONObject.put("page", PAGE);
            jSONObject.put("source", source);
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(UBC_ID, jSONObject);
        } catch (JSONException unused) {
        }
    }

    public static final void startApkCheckEvent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "in");
            jSONObject.put("from", "tool");
            jSONObject.put("page", PAGE);
            Object service = ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            Intrinsics.checkNotNullExpressionValue(service, "getService(UBCManager.SERVICE_REFERENCE)");
            ((UBCManager) service).onEvent(UBC_ID, jSONObject);
        } catch (JSONException unused) {
        }
    }
}
