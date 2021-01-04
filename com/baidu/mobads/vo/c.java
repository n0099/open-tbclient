package com.baidu.mobads.vo;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements IXAdResponseInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f3559a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f3560b;
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private ArrayList<IXAdInstanceInfo> p;
    private long q = System.currentTimeMillis();

    public c(String str) {
        this.f3559a = 0;
        this.f3560b = false;
        this.i = -1;
        this.j = -1;
        this.p = new ArrayList<>();
        this.o = str;
        com.baidu.mobads.c.a.c = str;
        JSONObject jSONObject = new JSONObject(str);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(MapBundleKey.MapObjKey.OBJ_AD);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        this.p.add(new XAdInstanceInfo(jSONArray.getJSONObject(i)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Exception e2) {
            this.p = new ArrayList<>();
        }
        this.f3559a = jSONObject.optInt("n", 0);
        this.d = jSONObject.optInt("x", 0);
        this.e = jSONObject.optInt("y", 0);
        this.f3560b = Boolean.valueOf(jSONObject.optInt("m", 0) == 1);
        this.c = jSONObject.optString("u", "");
        this.f = jSONObject.optString("exp2", "{}");
        this.g = jSONObject.optString("ext_act", "{}");
        this.i = jSONObject.optInt("lunpan", -1);
        this.j = jSONObject.optInt("intIcon", -1);
        this.k = jSONObject.optString("ck", "");
        this.l = jSONObject.optString("req_id");
        this.m = jSONObject.optString("error_code", "");
        this.n = jSONObject.optString("error_msg", "");
        try {
            this.h = jSONObject.getString("theme");
        } catch (JSONException e3) {
        }
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        if (this.p.size() > 0) {
            return this.p.get(0);
        }
        return null;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getAdsNum() {
        return this.f3559a;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setAdsNum(int i) {
        this.f3559a = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public Boolean getOpenPointModeForWall() {
        return this.f3560b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setOpenPointModeForWall(Boolean bool) {
        this.f3560b = bool;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getPointUnitForWall() {
        return this.c;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setPointUnitForWall(String str) {
        this.c = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getLongitude() {
        return this.d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setLongitude(int i) {
        this.d = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getLatitude() {
        return this.e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setLatitude(int i) {
        this.e = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getExp2() {
        return this.f;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setExp2(String str) {
        this.f = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getExtentionActionExp() {
        return this.g;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setExtentionActionExp(String str) {
        this.g = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getDefaultFillInThemeForStaticAds() {
        return this.h;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setDefaultFillInThemeForStaticAds(String str) {
        this.h = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getLunpan() {
        return this.i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setLunpan(int i) {
        this.i = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public int getIntIcon() {
        return this.j;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setIntIcon(int i) {
        this.j = i;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getBaiduidOfCookie() {
        return this.k;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setBaiduidOfCookie(String str) {
        this.k = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getRequestId() {
        return this.l;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setRequestId(String str) {
        this.l = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getErrorCode() {
        return this.m;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setErrorCode(String str) {
        this.m = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getErrorMessage() {
        if (!TextUtils.isEmpty(this.n)) {
            return this.n;
        }
        String a2 = com.baidu.mobads.e.a.a(this.m);
        if (a2 != null) {
            this.n = a2;
        } else {
            this.n = "";
        }
        return this.n;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setErrorMessage(String str) {
        this.n = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public String getOriginResponseStr() {
        return this.o;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setOriginResponseStr(String str) {
        this.o = str;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        return this.p;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        this.p = arrayList;
    }

    @Override // com.baidu.mobads.interfaces.IXAdResponseInfo
    public long getTimeStamp() {
        return this.q;
    }
}
