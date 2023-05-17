package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0003J\u0018\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010'\u001a\u00020(J\b\u0010-\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\u0004¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "", "jsonString", "", "(Ljava/lang/String;)V", "()V", "androidId", "getAndroidId", "()Ljava/lang/String;", "setAndroidId", "enUid", "getEnUid", "setEnUid", "harmonyVersion", "getHarmonyVersion", "setHarmonyVersion", "imei", "getImei", "setImei", "macAddress", "getMacAddress", "setMacAddress", HttpConstants.HTTP_MANUFACTURER, "getManufacturer", "setManufacturer", "model", "getModel", "setModel", "oaid", "getOaid", "setOaid", "operator", "getOperator", "setOperator", "osVersion", "getOsVersion", "setOsVersion", "isDeviceInfoSyncMapping", "", "deviceFlag", "", "newDeviceValue", "setDeviceInfo", "", "newValue", "toString", "Companion", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheDeviceInfo {
    public static final Companion Companion = new Companion(null);
    public static final String JSON_KEY_ANDROID_ID = "ai";
    public static final String JSON_KEY_HARMONY_VERSION = "hv";
    public static final String JSON_KEY_IMEI = "im";
    public static final String JSON_KEY_MAC = "ma";
    public static final String JSON_KEY_MANUFACTURER = "mn";
    public static final String JSON_KEY_MODEL = "mo";
    public static final String JSON_KEY_OAID = "oa";
    public static final String JSON_KEY_OPERATOR = "op";
    public static final String JSON_KEY_OS_VERSION = "ov";
    public static final String JSON_KEY_UID = "u";
    public String androidId;
    public String enUid;
    public String harmonyVersion;
    public String imei;
    public String macAddress;
    public String manufacturer;
    public String model;
    public String oaid;
    public String operator;
    public String osVersion;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/common/security/CacheDeviceInfo$Companion;", "", "()V", "JSON_KEY_ANDROID_ID", "", "JSON_KEY_HARMONY_VERSION", "JSON_KEY_IMEI", "JSON_KEY_MAC", "JSON_KEY_MANUFACTURER", "JSON_KEY_MODEL", "JSON_KEY_OAID", "JSON_KEY_OPERATOR", "JSON_KEY_OS_VERSION", "JSON_KEY_UID", "lib-security-framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public CacheDeviceInfo() {
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final String getEnUid() {
        return this.enUid;
    }

    public final String getHarmonyVersion() {
        return this.harmonyVersion;
    }

    public final String getImei() {
        return this.imei;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOaid() {
        return this.oaid;
    }

    public final String getOperator() {
        return this.operator;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CacheDeviceInfo(String jsonString) {
        this();
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        this.macAddress = jSONObject.optString("ma", null);
        this.imei = jSONObject.optString("im", null);
        this.androidId = jSONObject.optString(JSON_KEY_ANDROID_ID, null);
        this.oaid = jSONObject.optString(JSON_KEY_OAID, null);
        this.model = jSONObject.optString(JSON_KEY_MODEL, null);
        this.osVersion = jSONObject.optString("ov", null);
        this.operator = jSONObject.optString("op", null);
        this.harmonyVersion = jSONObject.optString(JSON_KEY_HARMONY_VERSION, null);
        this.manufacturer = jSONObject.optString(JSON_KEY_MANUFACTURER, null);
        this.enUid = jSONObject.optString("u", null);
    }

    public final boolean isDeviceInfoSyncMapping(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 64) {
                                    if (i != 128) {
                                        if (i != 256) {
                                            return false;
                                        }
                                        return TextUtils.equals(this.manufacturer, str);
                                    }
                                    return TextUtils.equals(this.harmonyVersion, str);
                                }
                                return TextUtils.equals(this.operator, str);
                            }
                            return TextUtils.equals(this.osVersion, str);
                        }
                        return TextUtils.equals(this.model, str);
                    }
                    String str2 = this.oaid;
                    Intrinsics.checkNotNull(str);
                    return TextUtils.equals(str2, DeviceInfoUtilKt.crcSign(str));
                }
                String str3 = this.androidId;
                Intrinsics.checkNotNull(str);
                return TextUtils.equals(str3, DeviceInfoUtilKt.crcSign(str));
            }
            String str4 = this.imei;
            Intrinsics.checkNotNull(str);
            return TextUtils.equals(str4, DeviceInfoUtilKt.crcSign(str));
        }
        String str5 = this.macAddress;
        Intrinsics.checkNotNull(str);
        return TextUtils.equals(str5, DeviceInfoUtilKt.crcSign(str));
    }

    public final void setDeviceInfo(String str, int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 64) {
                                    if (i != 128) {
                                        if (i == 256) {
                                            this.manufacturer = str;
                                            return;
                                        }
                                        return;
                                    }
                                    this.harmonyVersion = str;
                                    return;
                                }
                                this.operator = str;
                                return;
                            }
                            this.osVersion = str;
                            return;
                        }
                        this.model = str;
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        Intrinsics.checkNotNull(str);
                        str = DeviceInfoUtilKt.crcSign(str);
                    }
                    this.oaid = str;
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    Intrinsics.checkNotNull(str);
                    str = DeviceInfoUtilKt.crcSign(str);
                }
                this.androidId = str;
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                str = DeviceInfoUtilKt.crcSign(str);
            }
            this.imei = str;
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkNotNull(str);
            str = DeviceInfoUtilKt.crcSign(str);
        }
        this.macAddress = str;
    }

    public final void setAndroidId(String str) {
        this.androidId = str;
    }

    public final void setEnUid(String str) {
        this.enUid = str;
    }

    public final void setHarmonyVersion(String str) {
        this.harmonyVersion = str;
    }

    public final void setImei(String str) {
        this.imei = str;
    }

    public final void setMacAddress(String str) {
        this.macAddress = str;
    }

    public final void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final void setOaid(String str) {
        this.oaid = str;
    }

    public final void setOperator(String str) {
        this.operator = str;
    }

    public final void setOsVersion(String str) {
        this.osVersion = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ma", this.macAddress);
        jSONObject.put("im", this.imei);
        jSONObject.put(JSON_KEY_ANDROID_ID, this.androidId);
        jSONObject.put(JSON_KEY_OAID, this.oaid);
        jSONObject.put(JSON_KEY_MODEL, this.model);
        jSONObject.put("ov", this.osVersion);
        jSONObject.put("op", this.operator);
        jSONObject.put(JSON_KEY_HARMONY_VERSION, this.harmonyVersion);
        jSONObject.put(JSON_KEY_MANUFACTURER, this.manufacturer);
        jSONObject.put("u", this.enUid);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
