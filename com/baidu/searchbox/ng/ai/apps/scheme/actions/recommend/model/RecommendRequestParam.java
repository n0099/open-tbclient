package com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.utils.AiAppsRecommendUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RecommendRequestParam {
    private static final String ANDROID_ID_EMPTY = "0";
    public static final int COOR_TYPE_BD = 3;
    public static final int COOR_TYPE_BDMKT = 0;
    public static final int COOR_TYPE_GCJ = 1;
    public static final int COOR_TYPE_UNKNOWN = -1;
    public static final int COOR_TYPE_WGS84 = 2;
    private static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    private static final String DEVICE_MODEL_EMPTY = "NUL";
    private static final int DEVICE_TYPE_PAD = 3;
    private static final int DEVICE_TYPE_PHONE = 2;
    private static final int DEVICE_TYPE_UNKNOWN = 0;
    private static final String DEVICE_VENDOR_EMPTY = "NUL";
    private static final String IMEI_EMPTY = "0";
    private static final int OS_TYPE_ANDROID = 2;
    private static final int OS_TYPE_IOS = 1;
    private static final int OS_TYPE_UNKNOWN = 0;
    public String appId;
    public JSONObject data;
    public Device device;
    public Network network;
    public UserInfo userinfo;

    /* loaded from: classes2.dex */
    public static class Device {
        public String androidid;
        public String deviceModel;
        public int deviceType;
        public String deviceVendor;
        public String deviceid;
        public String mac;
        public int osType;
        public int screenHeight;
        public int screenWidth;
    }

    /* loaded from: classes2.dex */
    public static class Network {
        public int network;
        public int operator;
    }

    /* loaded from: classes2.dex */
    public static class UserInfo {
        public int coordType;
        public double latitude;
        public double longitude;
    }

    public RecommendRequestParam(@NonNull Context context, @NonNull JSONObject jSONObject) {
        Device device = new Device();
        UserInfo userInfo = new UserInfo();
        Network network = new Network();
        String aiAppId = AiApp.getAiAppId();
        this.appId = TextUtils.isEmpty(aiAppId) ? "" : aiAppId;
        this.device = device;
        this.userinfo = userInfo;
        this.network = network;
        this.data = jSONObject;
        String imei = AiAppsRuntime.getAiAppAccountRuntime().getIMEI();
        device.deviceid = "0".equals(imei) ? "" : imei;
        String androidId = AiAppsRuntime.getAiAppAccountRuntime().getAndroidId();
        device.androidid = "0".equals(androidId) ? "" : androidId;
        device.osType = 2;
        device.deviceType = AiAppsRecommendUtils.isPad(context) ? 3 : 2;
        String manufacturer = AiAppsRuntime.getAiAppAccountRuntime().getManufacturer();
        device.deviceVendor = "NUL".equals(manufacturer) ? "" : manufacturer;
        String model = AiAppsRuntime.getAiAppAccountRuntime().getModel();
        device.deviceModel = "NUL".equals(model) ? "" : model;
        device.screenHeight = AiAppsUIUtils.getDisplayHeight(context);
        device.screenWidth = AiAppsUIUtils.getDisplayWidth(context);
        String wifiInfo = AiAppsRuntime.getAiAppAccountRuntime().getWifiInfo();
        device.mac = (TextUtils.isEmpty(wifiInfo) || "02:00:00:00:00:00".equals(wifiInfo)) ? "" : "";
        network.network = AiAppsRecommendUtils.getNetType();
        network.operator = AiAppsRecommendUtils.getSimOperator(context);
    }

    @NonNull
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(HttpConstants.HTTP_APP_ID, this.appId);
            jSONObject2.put("deviceid", this.device.deviceid);
            jSONObject2.put("androidid", this.device.androidid);
            jSONObject2.put("os_type", this.device.osType);
            jSONObject2.put(StatisticConstants.DEVICE_TYPE, this.device.deviceType);
            jSONObject2.put("device_vendor", this.device.deviceVendor);
            jSONObject2.put("device_model", this.device.deviceModel);
            jSONObject2.put("screen_height", this.device.screenHeight);
            jSONObject2.put("screen_width", this.device.screenWidth);
            jSONObject2.put("mac", this.device.mac);
            jSONObject.put(Config.DEVICE_PART, jSONObject2);
            jSONObject3.put("coord_type", this.userinfo.coordType);
            jSONObject3.put(CoordinateModel.LATITUDE, this.userinfo.latitude);
            jSONObject3.put(CoordinateModel.LONGITUDE, this.userinfo.longitude);
            jSONObject.put("userinfo", jSONObject3);
            jSONObject4.put("network", this.network.network);
            jSONObject4.put("operator", this.network.operator);
            jSONObject.put("network", jSONObject4);
            jSONObject.put("data", this.data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }
}
