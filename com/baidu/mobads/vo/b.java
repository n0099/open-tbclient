package com.baidu.mobads.vo;

import android.view.View;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements IXAdProdInfo {

    /* renamed from: a  reason: collision with root package name */
    public d f8612a;

    /* renamed from: b  reason: collision with root package name */
    public IXAdConstants4PDK.SlotType f8613b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f8614c;

    /* renamed from: d  reason: collision with root package name */
    public View f8615d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8616e = false;

    public b(d dVar, IXAdConstants4PDK.SlotType slotType) {
        this.f8612a = dVar;
        this.f8613b = slotType;
    }

    public void a(boolean z) {
        this.f8616e = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdPlacementId() {
        return this.f8612a.getApid();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdRequestURL() {
        return this.f8612a.b();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getApt() {
        return this.f8612a.getApt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public JSONObject getAttribute() {
        JSONObject jSONObject = this.f8614c;
        return jSONObject != null ? jSONObject : AdSettings.getAttr();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public View getClickView() {
        return this.f8615d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getInstanceCount() {
        return 0;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getProdType() {
        return this.f8612a.getProd();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdHeight() {
        return this.f8612a.getH();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdWidth() {
        return this.f8612a.getW();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public IXAdConstants4PDK.SlotType getType() {
        return this.f8613b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isAutoPlay() {
        return this.f8616e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isMsspTagAvailable() {
        return false;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public void setClickView(View view) {
        this.f8615d = view;
    }

    public void a(JSONObject jSONObject) {
        this.f8614c = jSONObject;
    }
}
