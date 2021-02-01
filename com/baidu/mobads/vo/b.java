package com.baidu.mobads.vo;

import android.view.View;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements IXAdProdInfo {

    /* renamed from: a  reason: collision with root package name */
    private d f3524a;

    /* renamed from: b  reason: collision with root package name */
    private IXAdConstants4PDK.SlotType f3525b;
    private JSONObject c;
    private View d;
    private boolean e = false;

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isAutoPlay() {
        return this.e;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public void setClickView(View view) {
        this.d = view;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public View getClickView() {
        return this.d;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getApt() {
        return this.f3524a.getApt();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public boolean isMsspTagAvailable() {
        return false;
    }

    public b(d dVar, IXAdConstants4PDK.SlotType slotType) {
        this.f3524a = dVar;
        this.f3525b = slotType;
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdWidth() {
        return this.f3524a.getW();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public int getRequestAdHeight() {
        return this.f3524a.getH();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getAdPlacementId() {
        return this.f3524a.getApid();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public String getProdType() {
        return this.f3524a.getProd();
    }

    @Override // com.baidu.mobads.interfaces.IXAdProdInfo
    public IXAdConstants4PDK.SlotType getType() {
        return this.f3525b;
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
        return this.f3524a.b();
    }
}
