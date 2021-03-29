package com.baidu.mobads.vo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.t;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class d implements IXAdRequestInfo {

    /* renamed from: d  reason: collision with root package name */
    public Context f8628d;

    /* renamed from: e  reason: collision with root package name */
    public Activity f8629e;

    /* renamed from: f  reason: collision with root package name */
    public IXAdConstants4PDK.SlotType f8630f;

    /* renamed from: g  reason: collision with root package name */
    public IXAdProdInfo f8631g;
    public boolean j;
    public int m;
    public int n;
    public int r;
    public int t;

    /* renamed from: c  reason: collision with root package name */
    public String f8627c = "TODO";

    /* renamed from: a  reason: collision with root package name */
    public String f8625a = "android";
    public String l = "";
    public int o = XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage();
    public String p = "LP,DL";
    public String q = "";
    public int s = 0;
    public boolean u = true;
    public long v = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public String f8626b = "";

    /* renamed from: h  reason: collision with root package name */
    public IXAdConstants f8632h = XAdSDKFoundationFacade.getInstance().getAdConstants();
    public IXAdURIUitls i = XAdSDKFoundationFacade.getInstance().getURIUitls();
    public IXAdActivityUtils k = XAdSDKFoundationFacade.getInstance().getActivityUtils();

    public d(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        Activity activity2 = context instanceof Activity ? (Activity) context : null;
        this.f8629e = activity2;
        this.f8628d = activity2 == null ? context : activity2.getApplicationContext();
        if (this.f8629e == null && activity != null) {
            this.f8629e = activity;
        }
        this.j = this.k.webviewMultiProcess(this.f8629e);
        this.f8630f = slotType;
        this.f8631g = new b(this, slotType);
        c(this.f8630f.getValue());
        a(context);
    }

    public abstract HashMap<String, String> a();

    public void a(boolean z) {
        this.u = z;
    }

    public String b() {
        HashMap<String, String> e2 = e();
        e2.putAll(a());
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getRequestAdUrl(this.f8626b, e2);
    }

    public void c(String str) {
        this.q = str;
    }

    public IXAdProdInfo d() {
        return this.f8631g;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:1|(4:2|3|4|(2:5|6))|(29:8|(2:11|9)|12|13|14|15|16|(21:18|19|20|21|(19:23|(2:26|24)|27|28|29|(1:31)(1:54)|32|33|(1:35)(1:53)|36|(1:38)(1:52)|39|(1:41)|42|(1:44)|45|(1:47)|48|49)|56|29|(0)(0)|32|33|(0)(0)|36|(0)(0)|39|(0)|42|(0)|45|(0)|48|49)|59|19|20|21|(0)|56|29|(0)(0)|32|33|(0)(0)|36|(0)(0)|39|(0)|42|(0)|45|(0)|48|49)|62|14|15|16|(0)|59|19|20|21|(0)|56|29|(0)(0)|32|33|(0)(0)|36|(0)(0)|39|(0)|42|(0)|45|(0)|48|49) */
    /* JADX WARN: Can't wrap try/catch for region: R(33:1|2|3|4|5|6|(29:8|(2:11|9)|12|13|14|15|16|(21:18|19|20|21|(19:23|(2:26|24)|27|28|29|(1:31)(1:54)|32|33|(1:35)(1:53)|36|(1:38)(1:52)|39|(1:41)|42|(1:44)|45|(1:47)|48|49)|56|29|(0)(0)|32|33|(0)(0)|36|(0)(0)|39|(0)|42|(0)|45|(0)|48|49)|59|19|20|21|(0)|56|29|(0)(0)|32|33|(0)(0)|36|(0)(0)|39|(0)|42|(0)|45|(0)|48|49)|62|14|15|16|(0)|59|19|20|21|(0)|56|29|(0)(0)|32|33|(0)(0)|36|(0)(0)|39|(0)|42|(0)|45|(0)|48|49) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01f9 A[Catch: Exception -> 0x021d, TRY_LEAVE, TryCatch #0 {Exception -> 0x021d, blocks: (B:15:0x01f1, B:17:0x01f9), top: B:58:0x01f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x022f A[Catch: Exception -> 0x0261, TryCatch #3 {Exception -> 0x0261, blocks: (B:21:0x0223, B:23:0x022f, B:24:0x0235, B:26:0x023b, B:27:0x0257), top: B:64:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03b8 A[Catch: Exception -> 0x0449, TryCatch #1 {Exception -> 0x0449, blocks: (B:3:0x001d, B:14:0x01d6, B:20:0x021e, B:30:0x0262, B:34:0x0285, B:39:0x02a0, B:41:0x03b8, B:43:0x03c0, B:45:0x03dc, B:46:0x0405, B:48:0x040f, B:49:0x041a, B:51:0x0424, B:52:0x042b), top: B:60:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03dc A[Catch: Exception -> 0x0449, TryCatch #1 {Exception -> 0x0449, blocks: (B:3:0x001d, B:14:0x01d6, B:20:0x021e, B:30:0x0262, B:34:0x0285, B:39:0x02a0, B:41:0x03b8, B:43:0x03c0, B:45:0x03dc, B:46:0x0405, B:48:0x040f, B:49:0x041a, B:51:0x0424, B:52:0x042b), top: B:60:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x040f A[Catch: Exception -> 0x0449, TryCatch #1 {Exception -> 0x0449, blocks: (B:3:0x001d, B:14:0x01d6, B:20:0x021e, B:30:0x0262, B:34:0x0285, B:39:0x02a0, B:41:0x03b8, B:43:0x03c0, B:45:0x03dc, B:46:0x0405, B:48:0x040f, B:49:0x041a, B:51:0x0424, B:52:0x042b), top: B:60:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0424 A[Catch: Exception -> 0x0449, TryCatch #1 {Exception -> 0x0449, blocks: (B:3:0x001d, B:14:0x01d6, B:20:0x021e, B:30:0x0262, B:34:0x0285, B:39:0x02a0, B:41:0x03b8, B:43:0x03c0, B:45:0x03dc, B:46:0x0405, B:48:0x040f, B:49:0x041a, B:51:0x0424, B:52:0x042b), top: B:60:0x001d }] */
    @TargetApi(4)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<String, String> e() {
        String str;
        String str2;
        String str3;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        List<String[]> wifi;
        double[] gps;
        List<String[]> cell;
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("net", "" + systemUtils.getNetworkCatagory(this.f8628d));
            hashMap.put("n", "" + getN());
            hashMap.put("at", "" + getAt());
            hashMap.put("v", f() + "_" + com.baidu.mobads.constants.a.f8206c + "_4.1.30");
            hashMap.put(IXAdRequestInfo.CS, "");
            hashMap.put("pk", commonUtils.getAppPackage(this.f8628d));
            hashMap.put(IXAdRequestInfo.SDK_VALID, "sdk_8.8448");
            String appId = commonUtils.getAppId(this.f8628d);
            hashMap.put(IXAdRequestInfo.COST_NAME, appId + "_cpr");
            hashMap.put("appid", appId);
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, Build.MODEL);
            hashMap.put(IXAdRequestInfo.BRAND, systemUtils.getPhoneOSBrand());
            DisplayMetrics displayMetrics = commonUtils.getDisplayMetrics(this.f8628d);
            hashMap.put(IXAdRequestInfo.DENSITY, "" + displayMetrics.density);
            hashMap.put("w", "" + getW());
            hashMap.put("h", "" + getH());
            Rect screenRect = commonUtils.getScreenRect(this.f8628d);
            hashMap.put("sw", "" + screenRect.width());
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + screenRect.height());
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(((float) getW()) / displayMetrics.density)));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(((float) getH()) / displayMetrics.density)));
            hashMap.put(IXAdRequestInfo.SN, systemUtils.getSn(this.f8628d));
            try {
                cell = systemUtils.getCell(this.f8628d);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
        if (cell.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cell.size(); i++) {
                String[] strArr = cell.get(i);
                sb.append(String.format("%s_%s_%s|", strArr[0], strArr[1], strArr[2]));
            }
            str = sb.substring(0, sb.length() - 1);
            hashMap.put(IXAdRequestInfo.CELL_ID, str);
            hashMap.put(IXAdRequestInfo.NETWORK_OPERATOR, systemUtils.getNetworkOperator(this.f8628d));
            hashMap.put("im", commonUtils.getSubscriberId(this.f8628d));
            gps = systemUtils.getGPS(this.f8628d);
            if (gps != null) {
                System.currentTimeMillis();
                str2 = String.format("%s_%s_%s", Double.valueOf(gps[0]), Double.valueOf(gps[1]), Double.valueOf(gps[2]));
                hashMap.put("g", str2);
                wifi = systemUtils.getWIFI(this.f8628d);
                if (wifi.size() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < wifi.size(); i2++) {
                        String[] strArr2 = wifi.get(i2);
                        sb2.append(String.format("%s_%s|", strArr2[0], strArr2[1]));
                    }
                    str3 = sb2.substring(0, sb2.length() - 1);
                    hashMap.put(IXAdRequestInfo.WIFI, str3);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("");
                    sb3.append(!"wifi".equals(systemUtils.getNetworkType(this.f8628d)) ? 1 : 0);
                    hashMap.put("swi", sb3.toString());
                    hashMap.put(BaiduWalletServiceProviderMap.PLUGIN_TAB, !systemUtils.isTablet(this.f8628d) ? "1" : "0");
                    hashMap.put("sdc", systemUtils.getAppSDC() + "," + systemUtils.getMem());
                    hashMap.put("act", getAct());
                    hashMap.put("prod", getProd());
                    hashMap.put(IXAdRequestInfo.OS, "android");
                    hashMap.put(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
                    hashMap.put(IXAdRequestInfo.BDR, "" + Build.VERSION.SDK_INT);
                    hashMap.put("apinfo", commonUtils.getBaiduMapsInfo(this.f8628d));
                    hashMap.put("apid", getApid());
                    hashMap.put("chid", commonUtils.getChannelId());
                    hashMap.put("apt", "0");
                    hashMap.put("ap", "" + getAp());
                    hashMap.put("nt", systemUtils.getNetType(this.f8628d));
                    hashMap.put("udid", "");
                    hashMap.put("ses", "" + getSes());
                    hashMap.put("android_id", systemUtils.getAndroidId(this.f8628d));
                    hashMap.put("imei", systemUtils.getIMEI(this.f8628d));
                    hashMap.put("mac", systemUtils.getMacAddress(this.f8628d));
                    hashMap.put("cuid", systemUtils.getCUID(this.f8628d));
                    hashMap.put("snfrom", systemUtils.getSnFrom(this.f8628d));
                    hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
                    hashMap.put("req_id", commonUtils.createRequestId(this.f8628d, getApid()));
                    hashMap.put("cssid", !systemUtils.isWifiConnected(this.f8628d).booleanValue() ? systemUtils.getWifiConnected(this.f8628d) : "");
                    hashMap.put("msa", String.valueOf(1));
                    if (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a())) {
                        hashMap.put("rpt", String.valueOf(AdSettings.b.HTTPS_PROTOCOL_TYPE.a()));
                        hashMap.put("app_ver", "" + b(this.f8628d));
                    }
                    sharedPreferences = this.f8628d.getSharedPreferences("mobads_aplist_status", 0);
                    if (sharedPreferences != null) {
                        hashMap.put(AdExtParam.KEY_IADEX, sharedPreferences.getString("n_iad_sniff_result", ""));
                    }
                    sharedPreferences2 = this.f8628d.getSharedPreferences("mobads_uniqueidentifier", 0);
                    if (sharedPreferences2 != null) {
                        hashMap.put("oaid", sharedPreferences2.getString("oaid", ""));
                    }
                    hashMap.put("imei2", "" + t.a().a(this.f8628d));
                    return hashMap;
                }
                str3 = "";
                hashMap.put(IXAdRequestInfo.WIFI, str3);
                StringBuilder sb32 = new StringBuilder();
                sb32.append("");
                sb32.append(!"wifi".equals(systemUtils.getNetworkType(this.f8628d)) ? 1 : 0);
                hashMap.put("swi", sb32.toString());
                hashMap.put(BaiduWalletServiceProviderMap.PLUGIN_TAB, !systemUtils.isTablet(this.f8628d) ? "1" : "0");
                hashMap.put("sdc", systemUtils.getAppSDC() + "," + systemUtils.getMem());
                hashMap.put("act", getAct());
                hashMap.put("prod", getProd());
                hashMap.put(IXAdRequestInfo.OS, "android");
                hashMap.put(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
                hashMap.put(IXAdRequestInfo.BDR, "" + Build.VERSION.SDK_INT);
                hashMap.put("apinfo", commonUtils.getBaiduMapsInfo(this.f8628d));
                hashMap.put("apid", getApid());
                hashMap.put("chid", commonUtils.getChannelId());
                hashMap.put("apt", "0");
                hashMap.put("ap", "" + getAp());
                hashMap.put("nt", systemUtils.getNetType(this.f8628d));
                hashMap.put("udid", "");
                hashMap.put("ses", "" + getSes());
                hashMap.put("android_id", systemUtils.getAndroidId(this.f8628d));
                hashMap.put("imei", systemUtils.getIMEI(this.f8628d));
                hashMap.put("mac", systemUtils.getMacAddress(this.f8628d));
                hashMap.put("cuid", systemUtils.getCUID(this.f8628d));
                hashMap.put("snfrom", systemUtils.getSnFrom(this.f8628d));
                hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
                hashMap.put("req_id", commonUtils.createRequestId(this.f8628d, getApid()));
                hashMap.put("cssid", !systemUtils.isWifiConnected(this.f8628d).booleanValue() ? systemUtils.getWifiConnected(this.f8628d) : "");
                hashMap.put("msa", String.valueOf(1));
                if (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a())) {
                }
                sharedPreferences = this.f8628d.getSharedPreferences("mobads_aplist_status", 0);
                if (sharedPreferences != null) {
                }
                sharedPreferences2 = this.f8628d.getSharedPreferences("mobads_uniqueidentifier", 0);
                if (sharedPreferences2 != null) {
                }
                hashMap.put("imei2", "" + t.a().a(this.f8628d));
                return hashMap;
            }
            str2 = "";
            hashMap.put("g", str2);
            wifi = systemUtils.getWIFI(this.f8628d);
            if (wifi.size() > 0) {
            }
            str3 = "";
            hashMap.put(IXAdRequestInfo.WIFI, str3);
            StringBuilder sb322 = new StringBuilder();
            sb322.append("");
            sb322.append(!"wifi".equals(systemUtils.getNetworkType(this.f8628d)) ? 1 : 0);
            hashMap.put("swi", sb322.toString());
            hashMap.put(BaiduWalletServiceProviderMap.PLUGIN_TAB, !systemUtils.isTablet(this.f8628d) ? "1" : "0");
            hashMap.put("sdc", systemUtils.getAppSDC() + "," + systemUtils.getMem());
            hashMap.put("act", getAct());
            hashMap.put("prod", getProd());
            hashMap.put(IXAdRequestInfo.OS, "android");
            hashMap.put(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
            hashMap.put(IXAdRequestInfo.BDR, "" + Build.VERSION.SDK_INT);
            hashMap.put("apinfo", commonUtils.getBaiduMapsInfo(this.f8628d));
            hashMap.put("apid", getApid());
            hashMap.put("chid", commonUtils.getChannelId());
            hashMap.put("apt", "0");
            hashMap.put("ap", "" + getAp());
            hashMap.put("nt", systemUtils.getNetType(this.f8628d));
            hashMap.put("udid", "");
            hashMap.put("ses", "" + getSes());
            hashMap.put("android_id", systemUtils.getAndroidId(this.f8628d));
            hashMap.put("imei", systemUtils.getIMEI(this.f8628d));
            hashMap.put("mac", systemUtils.getMacAddress(this.f8628d));
            hashMap.put("cuid", systemUtils.getCUID(this.f8628d));
            hashMap.put("snfrom", systemUtils.getSnFrom(this.f8628d));
            hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
            hashMap.put("req_id", commonUtils.createRequestId(this.f8628d, getApid()));
            hashMap.put("cssid", !systemUtils.isWifiConnected(this.f8628d).booleanValue() ? systemUtils.getWifiConnected(this.f8628d) : "");
            hashMap.put("msa", String.valueOf(1));
            if (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a())) {
            }
            sharedPreferences = this.f8628d.getSharedPreferences("mobads_aplist_status", 0);
            if (sharedPreferences != null) {
            }
            sharedPreferences2 = this.f8628d.getSharedPreferences("mobads_uniqueidentifier", 0);
            if (sharedPreferences2 != null) {
            }
            hashMap.put("imei2", "" + t.a().a(this.f8628d));
            return hashMap;
        }
        str = "";
        hashMap.put(IXAdRequestInfo.CELL_ID, str);
        hashMap.put(IXAdRequestInfo.NETWORK_OPERATOR, systemUtils.getNetworkOperator(this.f8628d));
        hashMap.put("im", commonUtils.getSubscriberId(this.f8628d));
        gps = systemUtils.getGPS(this.f8628d);
        if (gps != null) {
        }
        str2 = "";
        hashMap.put("g", str2);
        wifi = systemUtils.getWIFI(this.f8628d);
        if (wifi.size() > 0) {
        }
        str3 = "";
        hashMap.put(IXAdRequestInfo.WIFI, str3);
        StringBuilder sb3222 = new StringBuilder();
        sb3222.append("");
        sb3222.append(!"wifi".equals(systemUtils.getNetworkType(this.f8628d)) ? 1 : 0);
        hashMap.put("swi", sb3222.toString());
        hashMap.put(BaiduWalletServiceProviderMap.PLUGIN_TAB, !systemUtils.isTablet(this.f8628d) ? "1" : "0");
        hashMap.put("sdc", systemUtils.getAppSDC() + "," + systemUtils.getMem());
        hashMap.put("act", getAct());
        hashMap.put("prod", getProd());
        hashMap.put(IXAdRequestInfo.OS, "android");
        hashMap.put(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
        hashMap.put(IXAdRequestInfo.BDR, "" + Build.VERSION.SDK_INT);
        hashMap.put("apinfo", commonUtils.getBaiduMapsInfo(this.f8628d));
        hashMap.put("apid", getApid());
        hashMap.put("chid", commonUtils.getChannelId());
        hashMap.put("apt", "0");
        hashMap.put("ap", "" + getAp());
        hashMap.put("nt", systemUtils.getNetType(this.f8628d));
        hashMap.put("udid", "");
        hashMap.put("ses", "" + getSes());
        hashMap.put("android_id", systemUtils.getAndroidId(this.f8628d));
        hashMap.put("imei", systemUtils.getIMEI(this.f8628d));
        hashMap.put("mac", systemUtils.getMacAddress(this.f8628d));
        hashMap.put("cuid", systemUtils.getCUID(this.f8628d));
        hashMap.put("snfrom", systemUtils.getSnFrom(this.f8628d));
        hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
        hashMap.put("req_id", commonUtils.createRequestId(this.f8628d, getApid()));
        hashMap.put("cssid", !systemUtils.isWifiConnected(this.f8628d).booleanValue() ? systemUtils.getWifiConnected(this.f8628d) : "");
        hashMap.put("msa", String.valueOf(1));
        if (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a())) {
        }
        sharedPreferences = this.f8628d.getSharedPreferences("mobads_aplist_status", 0);
        if (sharedPreferences != null) {
        }
        sharedPreferences2 = this.f8628d.getSharedPreferences("mobads_uniqueidentifier", 0);
        if (sharedPreferences2 != null) {
        }
        hashMap.put("imei2", "" + t.a().a(this.f8628d));
        return hashMap;
    }

    public String f() {
        return this.f8625a;
    }

    public void g(int i) {
        this.t = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getAct() {
        return this.p;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getAp() {
        return this.s;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getApid() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getApt() {
        return this.r;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getAt() {
        return this.o;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getH() {
        return this.n;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getN() {
        return this.t;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getProd() {
        return this.q;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public long getSes() {
        return this.v;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getSex() {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getUk() {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getW() {
        return this.m;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getZip() {
        return "";
    }

    public void h(int i) {
        this.s = i;
    }

    public void i(int i) {
        this.o = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public boolean isCanClick() {
        return this.u;
    }

    public void a(String str) {
        this.f8625a = str;
    }

    public void d(int i) {
        this.m = i;
    }

    public void f(int i) {
        this.r = i;
    }

    private void a(Context context) {
        if ("0.0".equals(com.baidu.mobads.constants.a.f8206c)) {
            double b2 = g.b(context);
            if (b2 > 0.0d) {
                com.baidu.mobads.constants.a.f8206c = String.valueOf(b2);
            }
        }
    }

    public void d(String str) {
        this.l = str;
    }

    public void b(String str) {
        this.p = str;
    }

    private String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void e(int i) {
        this.n = i;
    }
}
