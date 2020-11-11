package com.baidu.mobads.vo;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements IXAdProdInfo {

    /* renamed from: a  reason: collision with root package name */
    private d f2454a;
    private IXAdConstants4PDK.SlotType b;
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
        return this.f2454a.getApt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isMsspTagAvailable() {
        return false;
    }

    public b(d dVar, IXAdConstants4PDK.SlotType slotType) {
        this.f2454a = dVar;
        this.b = slotType;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdWidth() {
        return this.f2454a.getW();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdHeight() {
        return this.f2454a.getH();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdPlacementId() {
        return this.f2454a.getApid();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getProdType() {
        return this.f2454a.getProd();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public IXAdConstants4PDK.SlotType getType() {
        return this.b;
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
        return this.f2454a.b();
    }
}
