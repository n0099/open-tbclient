package com.baidu.mobads.vo;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b implements IXAdProdInfo {

    /* renamed from: a  reason: collision with root package name */
    private d f3520a;

    /* renamed from: b  reason: collision with root package name */
    private IXAdConstants4PDK.SlotType f3521b;
    private JSONObject c;
    private boolean d = false;

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isAutoPlay() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getApt() {
        return this.f3520a.getApt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isMsspTagAvailable() {
        return false;
    }

    public b(d dVar, IXAdConstants4PDK.SlotType slotType) {
        this.f3520a = dVar;
        this.f3521b = slotType;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdWidth() {
        return this.f3520a.getW();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdHeight() {
        return this.f3520a.getH();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdPlacementId() {
        return this.f3520a.getApid();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getProdType() {
        return this.f3520a.getProd();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public IXAdConstants4PDK.SlotType getType() {
        return this.f3521b;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public JSONObject getAttribute() {
        return this.c != null ? this.c : AdSettings.getAttr();
    }

    public void a(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getInstanceCount() {
        return 0;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdRequestURL() {
        return this.f3520a.b();
    }
}
