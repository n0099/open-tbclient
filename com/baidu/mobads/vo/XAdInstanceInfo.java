package com.baidu.mobads.vo;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class XAdInstanceInfo implements Parcelable, IXAdInstanceInfo, Cloneable {
    public static final Parcelable.Creator<XAdInstanceInfo> CREATOR = new a();
    public static final String TAG = "XAdInstanceInfo";
    private int A;
    private int B;
    @Deprecated
    private String C;
    private Set<String> D;
    private Set<String> E;
    private Set<String> F;
    private Set<String> G;
    private Set<String> H;
    private Set<String> I;
    private Set<String> J;
    private Set<String> K;
    private Set<String> L;
    private Set<String> M;
    private Set<String> N;
    private Set<String> O;
    private Set<String> P;
    private int Q;
    private int R;
    private int S;
    private String T;
    private String U;
    private String V;
    private boolean W;
    private String X;
    private String Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    private String f2502a;
    private int aA;
    private int aB;
    private int aC;
    private int aD;
    private boolean aE;
    private String aF;
    private String aa;
    private String ab;
    private long ac;
    private int ad;
    private String ae;
    private int af;
    private boolean ag;
    private long ah;
    private IXAdInstanceInfo.CreativeType ai;
    private String aj;
    private int ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private String at;
    private String au;
    private String av;
    private JSONArray aw;
    private boolean ax;
    private String ay;
    private boolean az;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private String m;
    private String n;
    private boolean o;
    private int p;
    private String q;
    private String r;
    private int s;
    private int t;
    @Deprecated
    private boolean u;
    @Deprecated
    private int v;
    private String w;
    private String x;
    private JSONObject y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ XAdInstanceInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getAdContainerWidth() {
        return this.aA;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAdContainerWidth(int i) {
        this.aA = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getAdContainerHeight() {
        return this.aB;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAdContainerHeight(int i) {
        this.aB = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getAdContainerSizeType() {
        return this.aC;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAdContainerSizeType(int i) {
        this.aC = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getFeedAdStyleType() {
        return this.aD;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setFeedAdStyleType(int i) {
        this.aD = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getUrl() {
        return this.aj;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setUrl(String str) {
        this.aj = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getDlTunnel() {
        return this.ak;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setDlTunnel(int i) {
        this.ak = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isInapp() {
        return this.al;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setInapp(boolean z) {
        this.al = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isClose() {
        return this.am;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setClose(boolean z) {
        this.am = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isAutoOpen() {
        return this.an;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAutoOpen(boolean z) {
        this.an = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isPopNotif() {
        return this.ao;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setPopNotif(boolean z) {
        this.ao = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isWifiTargeted() {
        return this.ap;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setWifiTargeted(boolean z) {
        this.ap = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isTooLarge() {
        return this.aq;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setTooLarge(boolean z) {
        this.aq = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isCanCancel() {
        return this.ar;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCanCancel(boolean z) {
        this.ar = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isCanDelete() {
        return this.as;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCanDelete(boolean z) {
        this.as = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public IXAdInstanceInfo.CreativeType getCreativeType() {
        return this.ai;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCreativeType(IXAdInstanceInfo.CreativeType creativeType) {
        this.ai = creativeType;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getFwt() {
        return this.f2502a;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setFwt(String str) {
        this.f2502a = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getAdId() {
        return this.b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAdId(String str) {
        this.b = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public Boolean isValid() {
        return Boolean.valueOf(!"-1".equalsIgnoreCase(getAdId()));
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getAdSource() {
        return this.c;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAdSource(String str) {
        this.c = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getTitle() {
        return this.d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setTitle(String str) {
        this.d = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getDescription() {
        return this.e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setDescription(String str) {
        this.e = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getSponsorUrl() {
        return this.f;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setSponsorUrl(String str) {
        this.f = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getMaterialType() {
        return this.g;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setMaterialType(String str) {
        this.g = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getPhoneNumber() {
        return this.h;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setPhoneNumber(String str) {
        this.h = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getMainPictureUrl() {
        return this.i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setMainPictureUrl(String str) {
        this.i = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getIconUrl() {
        return this.j;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setIconUrl(String str) {
        this.j = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getExp2ForSingleAd() {
        return this.k;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setExp2ForSingleAd(String str) {
        this.k = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getAntiTag() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAntiTag(int i) {
        this.l = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getLocalCreativeURL() {
        return this.m;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setLocalCreativeURL(String str) {
        this.m = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getVideoUrl() {
        return this.n;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setVideoUrl(String str) {
        this.n = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isVideoMuted() {
        return this.o;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setVideoMuted(boolean z) {
        this.o = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getVideoDuration() {
        return this.p;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setVideoDuration(int i) {
        this.p = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isIconVisibleForImageType() {
        return this.u;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setIconVisibleForImageType(boolean z) {
        this.u = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getHoursInADayToShowAd() {
        return this.v;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setHoursInADayToShowAd(int i) {
        this.v = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getClickThroughUrl() {
        return this.w;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setClickThroughUrl(String str) {
        this.w = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getOriginClickUrl() {
        return this.x;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setOriginClickUrl(String str) {
        this.x = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getHtmlSnippet() {
        return this.z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setHtmlSnippet(String str) {
        this.z = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getMainMaterialWidth() {
        return this.A;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setMainMaterialWidth(int i) {
        this.A = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getMainMaterialHeight() {
        return this.B;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setMainMaterialHeight(int i) {
        this.B = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getPhoneForLocalBranding() {
        return this.C;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setPhoneForLocalBranding(String str) {
        this.C = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public Set<String> getImpressionUrls() {
        return this.D;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setImpressionUrls(Set<String> set) {
        this.D = set;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getThirdImpressionTrackingUrls() {
        return new ArrayList(this.E);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setThirdImpressionTrackingUrls(Set<String> set) {
        this.E = set;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getThirdClickTrackingUrls() {
        return new ArrayList(this.F);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setThirdClickTrackingUrls(Set<String> set) {
        this.F = set;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getActionType() {
        return this.Q;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setActionType(int i) {
        this.Q = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isActionOnlyWifi() {
        return this.W;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setActionOnlyWifi(boolean z) {
        this.W = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getConfirmBorderPercent() {
        return this.X;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setConfirmBorderPercent(String str) {
        this.X = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getQueryKey() {
        return this.Y;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setQueryKey(String str) {
        this.Y = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getAppPackageName() {
        return this.aa;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAppPackageName(String str) {
        this.aa = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getAppName() {
        return this.ab;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAppName(String str) {
        this.ab = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public long getAppSize() {
        return this.ac;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAppSize(long j) {
        this.ac = j;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getSwitchButton() {
        return this.ad;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setSwitchButton(int i) {
        this.ad = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getAppOpenStrs() {
        return this.ae;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAppOpenStrs(String str) {
        this.ae = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getPointsForWall() {
        return this.af;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setPointsForWall(int i) {
        this.af = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isTaskDoneForWall() {
        return this.ag;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setTaskDoneForWall(boolean z) {
        this.ag = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public JSONObject getOriginJsonObject() {
        return this.y;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getVurl() {
        return this.at;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setVurl(String str) {
        this.at = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getClklogurl() {
        return this.au;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setClklogurl(String str) {
        this.au = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getWinurl() {
        return this.av;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setWinurl(String str) {
        this.av = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public JSONArray getNwinurl() {
        return this.aw;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setNwinurl(JSONArray jSONArray) {
        this.aw = jSONArray;
    }

    @SuppressLint({"DefaultLocale"})
    public XAdInstanceInfo(JSONObject jSONObject) {
        this.b = "-1";
        this.q = "";
        this.r = "";
        this.s = 0;
        this.t = 0;
        this.D = new HashSet();
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.J = new HashSet();
        this.K = new HashSet();
        this.L = new HashSet();
        this.M = new HashSet();
        this.N = new HashSet();
        this.O = new HashSet();
        this.P = new HashSet();
        this.W = true;
        this.ai = IXAdInstanceInfo.CreativeType.NONE;
        this.al = true;
        this.an = true;
        this.ao = true;
        this.ax = false;
        this.aE = false;
        this.aF = null;
        this.y = jSONObject;
        try {
            this.ah = System.currentTimeMillis();
            this.Q = jSONObject.optInt("act");
            this.z = jSONObject.optString("html", null);
            this.b = jSONObject.optString("id", "-1");
            this.c = jSONObject.optString(UserAccountActionItem.KEY_SRC, "");
            this.d = jSONObject.optString("tit", "");
            this.e = jSONObject.optString("desc", "");
            this.f = jSONObject.optString("surl", "");
            this.h = jSONObject.optString("phone", "");
            this.i = jSONObject.optString("w_picurl", "");
            this.j = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON, "");
            this.k = jSONObject.optString("exp2", "{}");
            this.l = jSONObject.optInt("anti_tag");
            this.n = jSONObject.optString("vurl", "");
            this.p = jSONObject.optInt("duration", 0);
            this.o = jSONObject.optInt("sound", 0) != 1;
            this.u = jSONObject.optInt("iv", 0) == 1;
            this.v = jSONObject.optInt("dur", 0);
            this.w = jSONObject.optString("curl", "");
            this.x = jSONObject.optString("ori_curl", "");
            this.R = jSONObject.optInt("closetype");
            this.S = jSONObject.optInt("expiration");
            this.T = jSONObject.optString("mute");
            JSONObject optJSONObject = jSONObject.optJSONObject("ad_html");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("banner_snippet")) {
                        this.U = optJSONObject.optString(next);
                    } else if (next.equals("int_snippet")) {
                        this.V = optJSONObject.optString(next);
                    }
                }
            }
            this.g = jSONObject.optString("type");
            if (this.z != null && this.z.length() > 0) {
                this.ai = IXAdInstanceInfo.CreativeType.HTML;
            } else if (this.g != null) {
                if (this.g.equals("text")) {
                    this.ai = IXAdInstanceInfo.CreativeType.TEXT;
                } else if (this.g.equals("image")) {
                    if (this.i != null && !this.i.equals("")) {
                        int lastIndexOf = this.i.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                        if ((lastIndexOf >= 0 ? this.i.toLowerCase(Locale.getDefault()).substring(lastIndexOf) : "").equals(".gif")) {
                            this.ai = IXAdInstanceInfo.CreativeType.GIF;
                        } else {
                            this.ai = IXAdInstanceInfo.CreativeType.STATIC_IMAGE;
                        }
                    }
                } else if (this.g.equals("rm")) {
                    this.ai = IXAdInstanceInfo.CreativeType.RM;
                } else if (this.g.equals("video")) {
                    this.ai = IXAdInstanceInfo.CreativeType.VIDEO;
                }
            }
            this.A = jSONObject.optInt("w");
            this.B = jSONObject.optInt("h");
            this.C = jSONObject.optString("lb_phone", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("nwinurl");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.D.add(optJSONArray.getString(i));
                }
            } else {
                String optString = jSONObject.optString("winurl", "");
                if (!optString.equals("")) {
                    this.D.add(optString);
                }
            }
            String optString2 = jSONObject.optString("clklogurl", "");
            if (!optString2.equals("")) {
                this.D.add(optString2);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(BdStatsConstant.FILE_MON);
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    String optString3 = jSONObject2.optString("s", "");
                    String optString4 = jSONObject2.optString("c", "");
                    a(optString3);
                    b(optString4);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("monitors");
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (next2.equals("s")) {
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray(next2);
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            a(optJSONArray3.optString(i3));
                        }
                    } else if (next2.equals("vskip")) {
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray(next2);
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            addSkipMonitorTrackers(optJSONArray4.optString(i4));
                        }
                    } else if (next2.equals("scard")) {
                        JSONArray optJSONArray5 = optJSONObject2.optJSONArray(next2);
                        for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                            addScardMonitorTrackers(optJSONArray5.optString(i5));
                        }
                    } else if (next2.equals("ccard")) {
                        JSONArray optJSONArray6 = optJSONObject2.optJSONArray(next2);
                        for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                            addCcardMonitorTrackers(optJSONArray6.optString(i6));
                        }
                    } else if (next2.equals("vstart")) {
                        JSONArray optJSONArray7 = optJSONObject2.optJSONArray(next2);
                        for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                            addStartMonitorTrackers(optJSONArray7.optString(i7));
                        }
                    } else if (next2.equals("vfullscreen")) {
                        JSONArray optJSONArray8 = optJSONObject2.optJSONArray(next2);
                        for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                            addFullScreenMonitorTrackers(optJSONArray8.optString(i8));
                        }
                    } else if (next2.equals("vclose")) {
                        JSONArray optJSONArray9 = optJSONObject2.optJSONArray(next2);
                        for (int i9 = 0; i9 < optJSONArray9.length(); i9++) {
                            addCloseMonitorTrackers(optJSONArray9.optString(i9));
                        }
                    } else if (next2.equals("cstartcard")) {
                        JSONArray optJSONArray10 = optJSONObject2.optJSONArray(next2);
                        for (int i10 = 0; i10 < optJSONArray10.length(); i10++) {
                            addCstartcardMonitorTrackers(optJSONArray10.optString(i10));
                        }
                    } else if (next2.equals("c")) {
                        JSONArray optJSONArray11 = optJSONObject2.optJSONArray(next2);
                        for (int i11 = 0; i11 < optJSONArray11.length(); i11++) {
                            b(optJSONArray11.optString(i11));
                        }
                    } else if (next2.equals("vcache_succ")) {
                        JSONArray optJSONArray12 = optJSONObject2.optJSONArray(next2);
                        for (int i12 = 0; i12 < optJSONArray12.length(); i12++) {
                            c(optJSONArray12.optString(i12));
                        }
                    } else if (next2.equals("vcache_fail")) {
                        JSONArray optJSONArray13 = optJSONObject2.optJSONArray(next2);
                        for (int i13 = 0; i13 < optJSONArray13.length(); i13++) {
                            d(optJSONArray13.optString(i13));
                        }
                    } else if (next2.equals("vcache_expire")) {
                        JSONArray optJSONArray14 = optJSONObject2.optJSONArray(next2);
                        for (int i14 = 0; i14 < optJSONArray14.length(); i14++) {
                            e(optJSONArray14.optString(i14));
                        }
                    }
                }
            }
            this.W = true;
            this.X = jSONObject.optString("cf", "");
            this.Y = jSONObject.optString("qk", "");
            this.Z = this.Y + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + new Random().nextLong() + System.currentTimeMillis() + "|";
            this.ab = jSONObject.optString("appname", "");
            this.aa = jSONObject.optString("pk", "");
            this.ac = jSONObject.optLong("sz", 0L);
            this.ad = jSONObject.optInt("sb", 0);
            this.ae = jSONObject.optString("apo", "");
            this.af = jSONObject.optInt("po", 0);
            this.ag = jSONObject.optInt("st", 0) == 1;
            this.r = jSONObject.optString("murl", "");
            if (this.g.equals("video") && this.r.length() > 0) {
                this.s = jSONObject.optInt("w", 0);
                this.t = jSONObject.optInt("h", 0);
                this.q = "video";
                if (this.Q == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeLandingPage()) {
                    this.r = this.w;
                }
            }
            this.aA = jSONObject.optInt("container_width");
            this.aB = jSONObject.optInt("container_height");
            this.aC = jSONObject.optInt("size_type");
            this.aD = jSONObject.optInt("style_type");
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(TAG, e.getMessage());
        }
    }

    final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.E.add(str);
        }
    }

    final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.F.add(str);
        }
    }

    final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.N.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getCacheSuccTrackers() {
        return new ArrayList(this.N);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCacheSuccTrackers(List<String> list) {
        try {
            this.N.clear();
            this.N.addAll(list);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getCacheFailTrackers() {
        return new ArrayList(this.O);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCacheFailTrackers(List<String> list) {
        try {
            this.O.clear();
            this.O.addAll(list);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    final void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.P.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getCacheExpireTrackers() {
        return new ArrayList(this.P);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCacheExpireTrackers(List<String> list) {
        try {
            this.P.clear();
            this.P.addAll(list);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public void addStartMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.G.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getStartTrackers() {
        return new ArrayList(this.G);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setStartTrackers(List<String> list) {
        try {
            this.G.clear();
            this.G.addAll(list);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public void addSkipMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.H.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getSkipTrackers() {
        return new ArrayList(this.H);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setSkipTrackers(List<String> list) {
        this.H.addAll(list);
    }

    public void addScardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.I.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getScardTrackers() {
        return new ArrayList(this.I);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setScardTrackers(List<String> list) {
        this.I.addAll(list);
    }

    public void addCcardMonitorTrackers(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.J.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getCcardTrackers() {
        return new ArrayList(this.J);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCcardTrackers(List<String> list) {
        this.J.addAll(list);
    }

    public void addFullScreenMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.K.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getFullScreenTrackers() {
        return new ArrayList(this.K);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setFullScreenTrackers(List<String> list) {
        this.K.addAll(list);
    }

    public void addCloseMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.L.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getCloseTrackers() {
        return new ArrayList(this.L);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCstartcardTrackers(List<String> list) {
        this.M.clear();
        this.M.addAll(list);
    }

    public void addCstartcardMonitorTrackers(String str) {
        if (str != null && !str.equals("")) {
            this.M.add(str);
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public List<String> getCstartcardTrackers() {
        return new ArrayList(this.M);
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCloseTrackers(List<String> list) {
        try {
            this.L.clear();
            this.L.addAll(list);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    public Object clone() {
        return super.clone();
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public long getCreateTime() {
        return this.ah;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCreateTime(long j) {
        this.ah = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.ab);
        parcel.writeString(this.ae);
        parcel.writeString(this.aa);
        parcel.writeString(this.w);
        parcel.writeString(this.au);
        parcel.writeString(this.X);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeString(this.k);
        parcel.writeString(this.f2502a);
        parcel.writeString(this.z);
        parcel.writeString(this.j);
        parcel.writeString(this.i);
        parcel.writeString(this.g);
        parcel.writeInt(this.B);
        parcel.writeInt(this.A);
        parcel.writeString(this.x);
        parcel.writeString(this.C);
        parcel.writeString(this.h);
        parcel.writeString(this.Y);
        parcel.writeString(this.f);
        parcel.writeString(this.aj);
        parcel.writeString(this.n);
        parcel.writeInt(this.p);
        parcel.writeString(this.at);
        parcel.writeString(this.av);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeString(this.T);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeStringList(getStartTrackers());
        parcel.writeStringList(getCloseTrackers());
        parcel.writeString(this.y.toString());
        parcel.writeInt(this.Q);
        parcel.writeInt(this.aA);
        parcel.writeInt(this.aB);
        parcel.writeInt(this.aC);
        parcel.writeInt(this.aD);
    }

    private XAdInstanceInfo(Parcel parcel) {
        this.b = "-1";
        this.q = "";
        this.r = "";
        this.s = 0;
        this.t = 0;
        this.D = new HashSet();
        this.E = new HashSet();
        this.F = new HashSet();
        this.G = new HashSet();
        this.H = new HashSet();
        this.I = new HashSet();
        this.J = new HashSet();
        this.K = new HashSet();
        this.L = new HashSet();
        this.M = new HashSet();
        this.N = new HashSet();
        this.O = new HashSet();
        this.P = new HashSet();
        this.W = true;
        this.ai = IXAdInstanceInfo.CreativeType.NONE;
        this.al = true;
        this.an = true;
        this.ao = true;
        this.ax = false;
        this.aE = false;
        this.aF = null;
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.ab = parcel.readString();
        this.ae = parcel.readString();
        this.aa = parcel.readString();
        this.w = parcel.readString();
        this.au = parcel.readString();
        this.X = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.k = parcel.readString();
        this.f2502a = parcel.readString();
        this.z = parcel.readString();
        this.j = parcel.readString();
        this.i = parcel.readString();
        this.g = parcel.readString();
        this.B = parcel.readInt();
        this.A = parcel.readInt();
        this.x = parcel.readString();
        this.C = parcel.readString();
        this.h = parcel.readString();
        this.Y = parcel.readString();
        this.f = parcel.readString();
        this.aj = parcel.readString();
        this.n = parcel.readString();
        this.p = parcel.readInt();
        this.at = parcel.readString();
        this.av = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        setStartTrackers(arrayList);
        ArrayList arrayList2 = new ArrayList();
        parcel.readStringList(arrayList2);
        setCloseTrackers(arrayList2);
        try {
            this.y = new JSONObject(parcel.readString());
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(TAG, e.getMessage());
        }
        this.Q = parcel.readInt();
        this.aA = parcel.readInt();
        this.aB = parcel.readInt();
        this.aC = parcel.readInt();
        this.aD = parcel.readInt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getUniqueId() {
        return this.Z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean isSecondConfirmed() {
        return this.ax;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setSecondConfirmed(boolean z) {
        this.ax = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean getAPOOpen() {
        return this.aE;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAPOOpen(boolean z) {
        this.aE = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getPage() {
        return this.aF;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setPage(String str) {
        this.aF = str;
    }

    public void setSplash3DLocalUrl(String str) {
        this.ay = str;
    }

    public String getSplash3DLocalUrl() {
        return this.ay;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getVideoWidth() {
        return this.s;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setVideoWidth(int i) {
        this.s = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getVideoHeight() {
        return this.t;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setVideoHeight(int i) {
        this.t = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAction(String str) {
        this.q = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getAction() {
        return this.q;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getWebUrl() {
        return this.r;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setWebUrl(String str) {
        this.r = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getCloseType() {
        return this.R;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setCloseType(int i) {
        this.R = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public int getExpiration() {
        return this.S;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setExpiration(int i) {
        this.S = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getMute() {
        return this.T;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setMute(String str) {
        this.T = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getBannerHtmlSnippet() {
        return this.U;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setBannerHtmlSnippet(String str) {
        this.U = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public String getIntHtmlSnippet() {
        return this.V;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setIntHtmlSnippet(String str) {
        this.V = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public void setAdHasDisplayed(boolean z) {
        this.az = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdInstanceInfo
    public boolean getAdHasDisplayed() {
        return this.az;
    }
}
