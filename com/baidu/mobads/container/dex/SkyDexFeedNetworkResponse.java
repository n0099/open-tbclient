package com.baidu.mobads.container.dex;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.sdk.internal.ISecurityInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class SkyDexFeedNetworkResponse {
    public Class<?> class1;
    public Object mAdInstanceInfo = null;
    public Object response;

    /* loaded from: classes2.dex */
    public enum MaterialType {
        NORMAL("normal"),
        VIDEO("video"),
        HTML("html"),
        GIF("gif");
        
        public final String value;

        MaterialType(String str) {
            this.value = str;
        }

        public static MaterialType parse(String str) {
            MaterialType[] values;
            for (MaterialType materialType : values()) {
                if (materialType.value.equalsIgnoreCase(str)) {
                    return materialType;
                }
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }
    }

    public SkyDexFeedNetworkResponse(Object obj) {
        this.class1 = null;
        this.response = null;
        this.class1 = obj.getClass();
        this.response = obj;
    }

    private int getIntegerByReflect(String str, Object... objArr) {
        try {
            return ((Integer) SkyReflectionUtil.invoke(this.response, str, objArr)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    private long getLongByReflect(String str, Object... objArr) {
        try {
            return ((Long) SkyReflectionUtil.invoke(this.response, str, objArr)).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    private String getStringByReflect(String str, Object... objArr) {
        try {
            return (String) SkyReflectionUtil.invoke(this.response, str, objArr);
        } catch (Exception unused) {
            return "";
        }
    }

    public String getActionText(Context context) {
        String appPackage = getAppPackage();
        if (isDownloadApp()) {
            return (TextUtils.isEmpty(appPackage) || RemoteReflectInterface.getDownloadStatus(appPackage) != 101) ? "立即下载" : "点击安装";
        }
        IXAdInstanceInfo adInstanceInfo = getAdInstanceInfo();
        if (adInstanceInfo != null) {
            int actionType = adInstanceInfo.getActionType();
            return ((actionType == 2 || actionType == 512) && AdDownloadApkUtils.isInstalled(context, appPackage)) ? "去看看" : "查看详情";
        }
        return "查看详情";
    }

    public int getActionType() {
        return getIntegerByReflect("getActionType", new Object[0]);
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        Field[] declaredFields;
        try {
            if (this.mAdInstanceInfo == null) {
                for (Field field : this.response.getClass().getDeclaredFields()) {
                    if (field.getType() == IXAdInstanceInfo.class) {
                        field.setAccessible(true);
                        this.mAdInstanceInfo = field.get(this.response);
                    }
                }
            }
            if (this.mAdInstanceInfo instanceof IXAdInstanceInfo) {
                return (IXAdInstanceInfo) this.mAdInstanceInfo;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAdLogoUrl() {
        return getStringByReflect("getAdLogoUrl", new Object[0]);
    }

    public String getAppPackage() {
        return getStringByReflect("getAppPackage", new Object[0]);
    }

    public long getAppSize() {
        return getLongByReflect("getAppSize", new Object[0]);
    }

    public String getBrandName() {
        return getStringByReflect("getBrandName", new Object[0]);
    }

    public int getContainerHeight() {
        return getIntegerByReflect("getContainerHeight", new Object[0]);
    }

    public int getContainerSizeType() {
        return getIntegerByReflect("getContainerSizeType", new Object[0]);
    }

    public int getContainerWidth() {
        return getIntegerByReflect("getContainerWidth", new Object[0]);
    }

    public String getDesc() {
        return getStringByReflect("getDesc", new Object[0]);
    }

    public int getDuration() {
        return getIntegerByReflect("getDuration", new Object[0]);
    }

    public Map<String, String> getExtras() {
        try {
            return (Map) SkyReflectionUtil.invoke(this.response, "getExtras", new Object[0]);
        } catch (Exception unused) {
            return new HashMap();
        }
    }

    public String getHtmlSnippet() {
        return getStringByReflect("getHtmlSnippet", new Object[0]);
    }

    public String getIconUrl() {
        return getStringByReflect("getIconUrl", new Object[0]);
    }

    public String getImageUrl() {
        return getStringByReflect("getImageUrl", new Object[0]);
    }

    public String getLogoUrl() {
        return getStringByReflect("getLogoUrl", new Object[0]);
    }

    public int getMainPicHeight() {
        return getIntegerByReflect("getMainPicHeight", new Object[0]);
    }

    public int getMainPicWidth() {
        return getIntegerByReflect("getMainPicWidth", new Object[0]);
    }

    public String getMarketingDesc() {
        return getStringByReflect("getMarketingDesc", new Object[0]);
    }

    public String getMarketingICONUrl() {
        return getStringByReflect("getMarketingICONUrl", new Object[0]);
    }

    public MaterialType getMaterialType() {
        try {
            if (this.response != null) {
                return MaterialType.parse((String) SkyReflectionUtil.invoke(this.response, SkyDex.getMaterialType, new Object[0]));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<String> getMultiPicUrls() {
        try {
            return (List) SkyReflectionUtil.invoke(this.response, "getMultiPicUrls", new Object[0]);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public boolean getMute() {
        String stringByReflect = getStringByReflect("getMute", new Object[0]);
        return TextUtils.isEmpty(stringByReflect) || "true".equalsIgnoreCase(stringByReflect);
    }

    public Object getNativeResonse() {
        return this.response;
    }

    public String getPowerUrl() {
        return getStringByReflect("getAppPermissionLink", new Object[0]);
    }

    public String getPrivacyUrl() {
        return getStringByReflect("getAppPrivacyLink", new Object[0]);
    }

    public String getPublisher() {
        return getStringByReflect("getPublisher", new Object[0]);
    }

    public int getStyleType() {
        return getIntegerByReflect("getStyleType", new Object[0]);
    }

    public String getTitle() {
        return getStringByReflect("getTitle", new Object[0]);
    }

    public String getVersion() {
        return getStringByReflect("getAppVersion", new Object[0]);
    }

    public String getVideoUrl() {
        return getStringByReflect("getVideoUrl", new Object[0]);
    }

    public WebView getWebView() {
        try {
            return (WebView) SkyReflectionUtil.invoke(this.response, "getWebView", new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public void handleClick(View view) {
        try {
            SkyReflectionUtil.invoke(this.response, "handleClick", new Class[]{View.class}, new Object[]{view});
        } catch (Exception unused) {
        }
    }

    public Object invoke(String str, Object... objArr) {
        return SkyReflectionUtil.invoke(this.response, str, objArr);
    }

    public boolean isAdAvailable(Context context) {
        try {
            return ((Boolean) SkyReflectionUtil.invoke(this.response, "isAdAvailable", new Class[]{Context.class}, new Object[]{context})).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isAutoPlay() {
        try {
            Object invoke = SkyReflectionUtil.invoke(this.response, "isAutoPlay", new Object[0]);
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isDownloadApp() {
        return ((Boolean) SkyReflectionUtil.invoke(this.response, "isNeedDownloadApp", new Object[0])).booleanValue();
    }

    public boolean isNonWifiAutoPlay() {
        Field[] declaredFields;
        try {
            if (this.mAdInstanceInfo == null) {
                for (Field field : this.response.getClass().getDeclaredFields()) {
                    if (field.getType() == IXAdInstanceInfo.class) {
                        field.setAccessible(true);
                        this.mAdInstanceInfo = field.get(this.response);
                    }
                }
            }
            if (this.mAdInstanceInfo instanceof IXAdInstanceInfo) {
                return ((IXAdInstanceInfo) this.mAdInstanceInfo).getOriginJsonObject().optInt("auto_play_non_wifi", 1) == 1;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public boolean isVideoMuted() {
        try {
            Object invoke = SkyReflectionUtil.invoke(this.response, "isVideoMuted", new Object[0]);
            if (invoke != null) {
                return ((Boolean) invoke).booleanValue();
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public void onClickAd(Context context) {
        SkyReflectionUtil.invoke(this.response, "onClickAd", new Class[]{Context.class}, new Object[]{context});
    }

    public void onClose(Context context, int i2) {
        SkyReflectionUtil.invoke(this.response, "onClose", new Class[]{Context.class, Integer.TYPE}, new Object[]{context, Integer.valueOf(i2)});
    }

    public void onComplete(Context context) {
        SkyReflectionUtil.invoke(this.response, "onComplete", new Class[]{Context.class}, new Object[]{context});
    }

    public void onError(Context context, int i2, int i3) {
        SkyReflectionUtil.invoke(this.response, "onError", new Class[]{Context.class}, new Object[]{context});
    }

    public void onFullScreen(Context context, int i2) {
        SkyReflectionUtil.invoke(this.response, "onFullScreen", new Class[]{Context.class, Integer.TYPE}, new Object[]{context, Integer.valueOf(i2)});
    }

    public void onStart(Context context) {
        SkyReflectionUtil.invoke(this.response, MissionEvent.MESSAGE_START, new Class[]{Context.class}, new Object[]{context});
    }

    public void recordImpression(View view) {
        SkyReflectionUtil.invoke(this.response, "recordImpression", new Class[]{View.class}, new Object[]{view});
    }

    public void unionLogoClick() {
        try {
            SkyReflectionUtil.invoke(this.response, ISecurityInfo.UNION_LOGO_CLICK, new Class[0], new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void handleClick(View view, boolean z) {
        try {
            SkyReflectionUtil.invoke(this.response, "handleClick", new Class[]{View.class, Boolean.TYPE}, new Object[]{view, Boolean.valueOf(z)});
        } catch (Exception unused) {
        }
    }

    public void handleClick(View view, int i2) {
        try {
            SkyReflectionUtil.invoke(this.response, "handleClick", new Class[]{View.class, Integer.TYPE}, new Object[]{view, Integer.valueOf(i2)});
        } catch (Exception unused) {
        }
    }
}
