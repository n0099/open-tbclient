package com.baidu.mobads.vo;

import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements IXAdProdInfo {
    private d a;
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
        return this.a.getApt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isMsspTagAvailable() {
        return false;
    }

    public b(d dVar, IXAdConstants4PDK.SlotType slotType) {
        this.a = dVar;
        this.b = slotType;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdWidth() {
        return this.a.getW();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdHeight() {
        return this.a.getH();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdPlacementId() {
        return this.a.getApid();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getProdType() {
        return this.a.getProd();
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
        return this.a.b();
    }
}
