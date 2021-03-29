package com.baidu.mobads.vo;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.AppActivityImp;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements IXAdResponseInfo {

    /* renamed from: a  reason: collision with root package name */
    public int f8617a;

    /* renamed from: b  reason: collision with root package name */
    public Boolean f8618b;

    /* renamed from: c  reason: collision with root package name */
    public String f8619c;

    /* renamed from: d  reason: collision with root package name */
    public int f8620d;

    /* renamed from: e  reason: collision with root package name */
    public int f8621e;

    /* renamed from: f  reason: collision with root package name */
    public String f8622f;

    /* renamed from: g  reason: collision with root package name */
    public String f8623g;

    /* renamed from: h  reason: collision with root package name */
    public String f8624h;
    public int i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public ArrayList<IXAdInstanceInfo> p;
    public long q = System.currentTimeMillis();

    public c(String str) {
        this.f8617a = 0;
        this.f8618b = Boolean.FALSE;
        this.i = -1;
        this.j = -1;
        this.p = new ArrayList<>();
        this.o = str;
        com.baidu.mobads.b.a.f8165c = str;
        JSONObject jSONObject = new JSONObject(str);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("ad");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        this.p.add(new XAdInstanceInfo(jSONArray.getJSONObject(i)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Exception unused2) {
            this.p = new ArrayList<>();
        }
        this.f8617a = jSONObject.optInt("n", 0);
        this.f8620d = jSONObject.optInt("x", 0);
        this.f8621e = jSONObject.optInt("y", 0);
        this.f8618b = Boolean.valueOf(jSONObject.optInt("m", 0) == 1);
        this.f8619c = jSONObject.optString("u", "");
        this.f8622f = jSONObject.optString("exp2", StringUtil.EMPTY_ARRAY);
        this.f8623g = jSONObject.optString("ext_act", StringUtil.EMPTY_ARRAY);
        this.i = jSONObject.optInt("lunpan", -1);
        this.j = jSONObject.optInt("intIcon", -1);
        this.k = jSONObject.optString("ck", "");
        this.l = jSONObject.optString("req_id");
        this.m = jSONObject.optString("error_code", "");
        this.n = jSONObject.optString("error_msg", "");
        try {
            this.f8624h = jSONObject.getString(AppActivityImp.EXTRA_LP_THEME);
        } catch (JSONException unused3) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        return this.p;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getAdsNum() {
        return this.f8617a;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getBaiduidOfCookie() {
        return this.k;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getDefaultFillInThemeForStaticAds() {
        return this.f8624h;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getErrorCode() {
        return com.baidu.mobads.d.a.b(this.m);
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getErrorMessage() {
        if (!TextUtils.isEmpty(this.n)) {
            return this.n;
        }
        String a2 = com.baidu.mobads.d.a.a(this.m);
        if (a2 != null) {
            this.n = a2;
        } else {
            this.n = "";
        }
        return this.n;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getExp2() {
        return this.f8622f;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getExtentionActionExp() {
        return this.f8623g;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getIntIcon() {
        return this.j;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getLatitude() {
        return this.f8621e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getLongitude() {
        return this.f8620d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getLunpan() {
        return this.i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public Boolean getOpenPointModeForWall() {
        return this.f8618b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getOriginResponseStr() {
        return this.o;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getPointUnitForWall() {
        return this.f8619c;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        if (this.p.size() > 0) {
            return this.p.get(0);
        }
        return null;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getRequestId() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public long getTimeStamp() {
        return this.q;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        this.p = arrayList;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setAdsNum(int i) {
        this.f8617a = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setBaiduidOfCookie(String str) {
        this.k = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setDefaultFillInThemeForStaticAds(String str) {
        this.f8624h = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setErrorCode(String str) {
        this.m = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setErrorMessage(String str) {
        this.n = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setExp2(String str) {
        this.f8622f = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setExtentionActionExp(String str) {
        this.f8623g = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setIntIcon(int i) {
        this.j = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setLatitude(int i) {
        this.f8621e = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setLongitude(int i) {
        this.f8620d = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setLunpan(int i) {
        this.i = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setOpenPointModeForWall(Boolean bool) {
        this.f8618b = bool;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setOriginResponseStr(String str) {
        this.o = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setPointUnitForWall(String str) {
        this.f8619c = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setRequestId(String str) {
        this.l = str;
    }
}
