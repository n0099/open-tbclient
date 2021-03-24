package com.baidu.mobads.vo;

import android.view.View;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements IXAdProdInfo {

    /* renamed from: a  reason: collision with root package name */
    public d f8611a;

    /* renamed from: b  reason: collision with root package name */
    public IXAdConstants4PDK.SlotType f8612b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f8613c;

    /* renamed from: d  reason: collision with root package name */
    public View f8614d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8615e = false;

    public b(d dVar, IXAdConstants4PDK.SlotType slotType) {
        this.f8611a = dVar;
        this.f8612b = slotType;
    }

    public void a(boolean z) {
        this.f8615e = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdPlacementId() {
        return this.f8611a.getApid();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdRequestURL() {
        return this.f8611a.b();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getApt() {
        return this.f8611a.getApt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public JSONObject getAttribute() {
        JSONObject jSONObject = this.f8613c;
        return jSONObject != null ? jSONObject : AdSettings.getAttr();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public View getClickView() {
        return this.f8614d;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getInstanceCount() {
        return 0;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getProdType() {
        return this.f8611a.getProd();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdHeight() {
        return this.f8611a.getH();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdWidth() {
        return this.f8611a.getW();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public IXAdConstants4PDK.SlotType getType() {
        return this.f8612b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isAutoPlay() {
        return this.f8615e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isMsspTagAvailable() {
        return false;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public void setClickView(View view) {
        this.f8614d = view;
    }

    public void a(JSONObject jSONObject) {
        this.f8613c = jSONObject;
    }
}
