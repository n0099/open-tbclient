package com.baidu.mobads.container.info;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobads.container.util.oaid.UniqueIdUtils;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XDeviceInfo {
    public static final String ABILITY_BANNER_CLOSE = "BANNER_CLOSE";
    public static final String ABILITY_PAUSE = "PAUSE";
    public static final String ABILITY_UNLIMITED_BANNER_SIZE = "UNLIMITED_BANNER_SIZE";
    public static final String APO = "APO2";
    public static final String DL = "DL";
    public static final String LP = "LP";
    public static final String MAI = "MAI";
    public static final String MAP = "MAP";
    public static final String PH = "PH";
    public static final String RM = "RM";
    public static final String SMS = "SMS";
    public static final String VD = "VD";
    public RemoteXAdLogger logger = RemoteXAdLogger.getInstance();
    public XAdContainerContext mAdContainerCxt;

    public XDeviceInfo(XAdContainerContext xAdContainerContext) {
        this.mAdContainerCxt = xAdContainerContext;
    }

    private JSONObject getAttr() {
        JSONObject adReqParam = this.mAdContainerCxt.getAdReqParam();
        String optString = adReqParam != null ? adReqParam.optString("ABILITY") : "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("KEY", new JSONArray());
            jSONObject.putOpt("RPT", Integer.valueOf(AppConfigImp.getInstance().isSupportHttps() ? 2 : 1));
            jSONObject.put("ABILITY", optString);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public JSONObject getConfs() {
        Context appContext = this.mAdContainerCxt.getAppContext();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("PACK", AppUtils.getAppPackage(appContext));
            jSONObject.putOpt("CS", "");
            jSONObject.putOpt("WRAPPER_VER", "9.041");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                jSONObject.putOpt("DENSITY", Float.valueOf(displayMetrics.density));
            } catch (Exception e2) {
                this.logger.d(e2);
            }
            jSONObject.putOpt("MODEL", Build.MODEL);
            jSONObject.putOpt("BRAND", DeviceUtils.getInstance().getPhoneOSBrand());
            jSONObject.putOpt("OS", 1);
            jSONObject.putOpt("BDR", DeviceUtils.getInstance().getPhoneOSBuildVersionSdk());
            jSONObject.putOpt("OSV", Build.VERSION.RELEASE);
            jSONObject.putOpt("AP", Boolean.valueOf(this.mAdContainerCxt.getAdReqParam().optBoolean("AP", false)));
            jSONObject.putOpt("MAC", "");
            jSONObject.putOpt("SN", DeviceUtils.getInstance().getSn(appContext));
            try {
                jSONObject.putOpt("ISP", NetworkInfoUtils.getNetworkOperator(appContext));
            } catch (Throwable unused) {
            }
            try {
                jSONObject.putOpt("IMSI", DeviceUtils.getInstance().getSubscriberId(appContext));
            } catch (Throwable unused2) {
            }
            try {
                jSONObject.putOpt("IMEI", DeviceUtils.getInstance().getIMEI(appContext));
            } catch (Throwable unused3) {
            }
            try {
                String cuid = DeviceUtils.getInstance().getCUID(this.mAdContainerCxt.getAppContext());
                if (TextUtils.isEmpty(cuid)) {
                    cuid = PluginLoader.getCuidFromGalaxy(this.mAdContainerCxt.getAppContext());
                }
                jSONObject.putOpt(SearchJsBridge.CUID, cuid);
            } catch (Throwable unused4) {
            }
            try {
                jSONObject.putOpt("OAID", UniqueIdUtils.getMiidOAID(this.mAdContainerCxt.getAppContext()));
            } catch (Throwable unused5) {
            }
            try {
                jSONObject.putOpt("TDID", PluginLoader.getTdid(this.mAdContainerCxt.getAppContext()));
            } catch (Throwable unused6) {
            }
            jSONObject.putOpt("SMS", Boolean.TRUE);
            jSONObject.putOpt(MAI, Boolean.FALSE);
            jSONObject.putOpt("MAP", Boolean.TRUE);
            jSONObject.putOpt("DL", Boolean.valueOf(AppUtils.supportDl(appContext)));
            jSONObject.putOpt("LP", Boolean.TRUE);
            jSONObject.putOpt(PH, Boolean.TRUE);
            jSONObject.putOpt(VD, Boolean.FALSE);
            jSONObject.putOpt("RM", Boolean.FALSE);
            jSONObject.putOpt(APO, Boolean.TRUE);
            jSONObject.putOpt("APP_VER", Integer.valueOf(AppUtils.getAppVersion(appContext)));
            jSONObject.putOpt("TAB", Boolean.valueOf(DeviceUtils.getInstance().isTablet(appContext)));
            try {
                jSONObject.putOpt("CPU", 0);
            } catch (Exception e3) {
                this.logger.d(e3);
            }
            try {
                jSONObject.putOpt("SDC", SdcardUtils.getAppSDC(appContext) + "," + SdcardUtils.getMem(appContext));
            } catch (Exception e4) {
                this.logger.d(e4);
            }
            jSONObject.putOpt("MEM", "0,0");
            jSONObject.putOpt("P_VER", AppConfigImp.getInstance().getProxyVersion());
            jSONObject.putOpt("PS", getAttr());
            jSONObject.putOpt("CHID", DeviceUtils.getInstance().getChannelId());
            jSONObject.putOpt("FET", new JSONObject());
            jSONObject.putOpt("ANDROID_ID", DeviceUtils.getInstance().getAndroidId(appContext));
            jSONObject.putOpt("APPSID", this.mAdContainerCxt.getAppsid());
            jSONObject.putOpt("APPSEC", this.mAdContainerCxt.getAppSec());
            jSONObject.putOpt("N", 1);
            jSONObject.putOpt("APID", this.mAdContainerCxt.getAdPlacementId());
            jSONObject.putOpt("PROD", this.mAdContainerCxt.getAdProd());
        } catch (Exception unused7) {
            this.logger.d("JsInterface.doGetConfs: static Confs not Complete!!");
        }
        try {
            if (this.mAdContainerCxt.getActivity() != null) {
                String str = null;
                String uri = this.mAdContainerCxt.getActivity().getIntent().toUri(0);
                if (uri.length() > 500) {
                    String[] split = uri.split(";");
                    if (split[0] != null && split[1] != null) {
                        str = split[0] + ";" + split[1] + ";ignoreparameters;end";
                    }
                    uri = str;
                }
                this.logger.d("res is " + uri);
                if (uri != null) {
                    jSONObject.putOpt("INTENT", AdURIUtils.encodeURIComponent(uri));
                }
            } else {
                this.logger.d("can not obtain intent info");
            }
        } catch (Exception e5) {
            this.logger.d(e5);
        }
        try {
            Rect screenRect = ScreenUtils.getScreenRect(appContext);
            jSONObject.putOpt("SW", Integer.valueOf(screenRect.width()));
            jSONObject.putOpt("SH", Integer.valueOf(screenRect.height()));
            jSONObject.putOpt("LW", Integer.valueOf(ScreenUtils.getLogicalPixel(appContext, this.mAdContainerCxt.getAdWidth())));
            jSONObject.putOpt("LH", Integer.valueOf(ScreenUtils.getLogicalPixel(appContext, this.mAdContainerCxt.getAdHeight())));
            jSONObject.putOpt("NT", NetworkInfoUtils.getNetType(appContext));
            jSONObject.putOpt("NET", Integer.valueOf(NetworkInfoUtils.getNetworkCatagory(appContext)));
            jSONObject.putOpt("SWI", Boolean.valueOf(NetworkInfoUtils.isWifiConnected(appContext).booleanValue()));
            try {
                jSONObject.putOpt(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, DeviceUtils.getInstance().getWifiScans(appContext));
                jSONObject.putOpt("CSSID", "");
            } catch (Exception e6) {
                this.logger.d(e6);
            }
            try {
                jSONObject.putOpt("GPS", DeviceUtils.getInstance().getGPS(appContext));
            } catch (Exception e7) {
                this.logger.d(e7);
            }
            try {
                jSONObject.putOpt("REQ_ID", DeviceUtils.getInstance().createRequestId(appContext, this.mAdContainerCxt.getAdPlacementId()));
            } catch (Exception unused8) {
            }
            jSONObject.putOpt("APINFO", DeviceUtils.getInstance().getBaiduMapsInfo(appContext));
            jSONObject.putOpt("APT", Integer.valueOf(this.mAdContainerCxt.getAdReqParam().optInt("APT")));
        } catch (Exception e8) {
            this.logger.d(e8);
        }
        return jSONObject;
    }

    public void handleAbility(JSONObject jSONObject) {
        try {
            JSONObject adReqParam = this.mAdContainerCxt.getAdReqParam();
            if (adReqParam != null) {
                String optString = adReqParam.optString("ABILITY");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(optString.split(",")));
                if (arrayList.contains("BANNER_CLOSE")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("ABILITY");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    optJSONObject.put("BANNER_CLOSE", true);
                    jSONObject.put("ABILITY", optJSONObject);
                }
                if (arrayList.contains(ABILITY_PAUSE)) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("ABILITY");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    optJSONObject2.put(ABILITY_PAUSE, true);
                    jSONObject.put("ABILITY", optJSONObject2);
                }
                if (arrayList.contains(ABILITY_UNLIMITED_BANNER_SIZE)) {
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("ABILITY");
                    if (optJSONObject3 == null) {
                        optJSONObject3 = new JSONObject();
                    }
                    optJSONObject3.put(ABILITY_UNLIMITED_BANNER_SIZE, true);
                    jSONObject.put("ABILITY", optJSONObject3);
                }
            }
        } catch (Exception e2) {
            this.logger.d(e2);
        }
    }
}
