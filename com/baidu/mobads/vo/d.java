package com.baidu.mobads.vo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class d implements IXAdRequestInfo {
    protected Context d;
    protected Activity e;
    protected IXAdConstants4PDK.SlotType f;
    protected IXAdProdInfo g;
    private int k;
    private int l;
    private int p;
    private int r;
    protected String c = "TODO";

    /* renamed from: a  reason: collision with root package name */
    private String f2454a = "android";
    private String j = "";
    private int m = XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage();
    private String n = "LP,DL";
    private String o = "";
    private int q = 0;
    private boolean s = true;
    private long t = System.currentTimeMillis();
    protected String b = "";
    protected IXAdConstants h = XAdSDKFoundationFacade.getInstance().getAdConstants();
    protected IXAdURIUitls i = XAdSDKFoundationFacade.getInstance().getURIUitls();

    protected abstract HashMap<String, String> a();

    public d(Context context, Activity activity, IXAdConstants4PDK.SlotType slotType) {
        Activity activity2 = context instanceof Activity ? (Activity) context : null;
        this.e = activity2;
        this.d = activity2 == null ? context : activity2.getApplicationContext();
        if (this.e == null && activity != null) {
            this.e = activity;
        }
        this.f = slotType;
        this.g = new b(this, this.f);
        c(this.f.getValue());
        a(context);
    }

    public IXAdProdInfo d() {
        return this.g;
    }

    @TargetApi(4)
    protected HashMap<String, String> e() {
        String str;
        String str2;
        String str3;
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("net", "" + systemUtils.getNetworkCatagory(this.d));
            hashMap.put("n", "" + getN());
            hashMap.put("at", "" + getAt());
            hashMap.put("v", f() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30");
            hashMap.put(IXAdRequestInfo.CS, "");
            hashMap.put("pk", commonUtils.getAppPackage(this.d));
            hashMap.put(IXAdRequestInfo.SDK_VALID, "sdk_8.8146");
            String appId = commonUtils.getAppId(this.d);
            hashMap.put(IXAdRequestInfo.COST_NAME, appId + "_cpr");
            hashMap.put("appid", appId);
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, Build.MODEL);
            hashMap.put(IXAdRequestInfo.BRAND, systemUtils.getPhoneOSBrand());
            DisplayMetrics displayMetrics = commonUtils.getDisplayMetrics(this.d);
            hashMap.put(IXAdRequestInfo.DENSITY, "" + displayMetrics.density);
            hashMap.put("w", "" + getW());
            hashMap.put("h", "" + getH());
            Rect screenRect = commonUtils.getScreenRect(this.d);
            hashMap.put("sw", "" + screenRect.width());
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + screenRect.height());
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(getW() / displayMetrics.density)));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(getH() / displayMetrics.density)));
            hashMap.put(IXAdRequestInfo.SN, systemUtils.getSn(this.d));
            try {
                str = "";
                List<String[]> cell = systemUtils.getCell(this.d);
                if (cell.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < cell.size(); i++) {
                        String[] strArr = cell.get(i);
                        sb.append(String.format("%s_%s_%s|", strArr[0], strArr[1], strArr[2]));
                    }
                    str = sb.substring(0, sb.length() - 1);
                }
            } catch (Exception e) {
                str = "";
            }
            hashMap.put(IXAdRequestInfo.CELL_ID, str);
            hashMap.put(IXAdRequestInfo.NETWORK_OPERATOR, systemUtils.getNetworkOperator(this.d));
            hashMap.put("im", commonUtils.getSubscriberId(this.d));
            try {
                double[] gps = systemUtils.getGPS(this.d);
                String str4 = "";
                if (gps != null) {
                    System.currentTimeMillis();
                    str4 = String.format("%s_%s_%s", Double.valueOf(gps[0]), Double.valueOf(gps[1]), Double.valueOf(gps[2]));
                }
                str2 = str4;
            } catch (Exception e2) {
                str2 = "";
            }
            hashMap.put(IXAdRequestInfo.GPS, str2);
            try {
                str2 = "";
                List<String[]> wifi = systemUtils.getWIFI(this.d);
                if (wifi.size() <= 0) {
                    str3 = "";
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < wifi.size(); i2++) {
                        String[] strArr2 = wifi.get(i2);
                        sb2.append(String.format("%s_%s|", strArr2[0], strArr2[1]));
                    }
                    str3 = sb2.substring(0, sb2.length() - 1);
                }
            } catch (Exception e3) {
                str3 = str2;
            }
            hashMap.put(IXAdRequestInfo.WIFI, str3);
            hashMap.put("swi", "" + ("wifi".equals(systemUtils.getNetworkType(this.d)) ? 1 : 0));
            hashMap.put("tab", systemUtils.isTablet(this.d) ? "1" : "0");
            hashMap.put("sdc", systemUtils.getAppSDC() + Constants.ACCEPT_TIME_SEPARATOR_SP + systemUtils.getMem());
            hashMap.put("act", getAct());
            hashMap.put("prod", getProd());
            hashMap.put("os", "android");
            hashMap.put(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
            hashMap.put(IXAdRequestInfo.BDR, "" + Build.VERSION.SDK_INT);
            hashMap.put("apinfo", commonUtils.getBaiduMapsInfo(this.d));
            hashMap.put("apid", getApid());
            hashMap.put("chid", commonUtils.getChannelId());
            hashMap.put("apt", "0");
            hashMap.put("ap", "" + getAp());
            hashMap.put("nt", systemUtils.getNetType(this.d));
            hashMap.put("udid", "");
            hashMap.put("ses", "" + getSes());
            hashMap.put("android_id", systemUtils.getAndroidId(this.d));
            hashMap.put("imei", systemUtils.getIMEI(this.d));
            hashMap.put("mac", systemUtils.getMacAddress(this.d));
            hashMap.put("cuid", systemUtils.getCUID(this.d));
            hashMap.put("snfrom", systemUtils.getSnFrom(this.d));
            hashMap.put(IXAdRequestInfo.P_VER, "8.8146");
            hashMap.put("req_id", commonUtils.createRequestId(this.d, getApid()));
            hashMap.put("cssid", systemUtils.isWifiConnected(this.d).booleanValue() ? systemUtils.getWifiConnected(this.d) : "");
            if (AdSettings.getSupportHttps().equals(AdSettings.b.HTTPS_PROTOCOL_TYPE.a())) {
                hashMap.put("rpt", String.valueOf(AdSettings.b.HTTPS_PROTOCOL_TYPE.a()));
            }
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, "" + b(this.d));
        } catch (Exception e4) {
        }
        return hashMap;
    }

    public String b() {
        HashMap<String, String> e = e();
        e.putAll(a());
        return XAdSDKFoundationFacade.getInstance().getURIUitls().getRequestAdUrl(this.b, e);
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public boolean isCanClick() {
        return this.s;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public String f() {
        return this.f2454a;
    }

    public void a(String str) {
        this.f2454a = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getW() {
        return this.k;
    }

    public void d(int i) {
        this.k = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getH() {
        return this.l;
    }

    public void e(int i) {
        this.l = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getAct() {
        return this.n;
    }

    public void b(String str) {
        this.n = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getProd() {
        return this.o;
    }

    public void c(String str) {
        this.o = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getApt() {
        return this.p;
    }

    public void f(int i) {
        this.p = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getN() {
        return this.r;
    }

    public void g(int i) {
        this.r = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getUk() {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getSex() {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getZip() {
        return "";
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public long getSes() {
        return this.t;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getAp() {
        return this.q;
    }

    public void h(int i) {
        this.q = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public String getApid() {
        return this.j;
    }

    public void d(String str) {
        this.j = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdRequestInfo
    public int getAt() {
        return this.m;
    }

    public void i(int i) {
        this.m = i;
    }

    private void a(Context context) {
        if ("0.0".equals(com.baidu.mobads.a.a.c)) {
            double b = g.b(context);
            if (b > 0.0d) {
                com.baidu.mobads.a.a.c = String.valueOf(b);
            }
        }
    }

    private String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
