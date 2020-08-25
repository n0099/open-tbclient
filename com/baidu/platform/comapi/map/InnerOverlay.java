package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
/* loaded from: classes20.dex */
public abstract class InnerOverlay extends Overlay {
    protected String a;
    protected Bundle b;
    private boolean c;
    public AppBaseMap mBaseMap;

    public InnerOverlay() {
        this.mBaseMap = null;
        this.a = null;
        this.b = null;
        this.c = true;
    }

    public InnerOverlay(int i) {
        this.mBaseMap = null;
        this.a = null;
        this.b = null;
        this.c = true;
        setType(i);
    }

    public InnerOverlay(int i, AppBaseMap appBaseMap) {
        this.mBaseMap = null;
        this.a = null;
        this.b = null;
        this.c = true;
        setType(i);
        this.mBaseMap = appBaseMap;
    }

    public boolean IsOverlayShow() {
        return (this.mLayerID == 0 || this.mBaseMap == null || this.mBaseMap.GetId() == 0 || !this.mBaseMap.LayersIsShow(this.mLayerID)) ? false : true;
    }

    public void SetMapParam(long j, AppBaseMap appBaseMap) {
        this.mLayerID = j;
        this.mBaseMap = appBaseMap;
    }

    public void SetOverlayShow(boolean z) {
        if (this.mLayerID == 0 || this.mBaseMap == null || this.mBaseMap.GetId() == 0) {
            return;
        }
        long currentTimeMillis = w.a ? System.currentTimeMillis() : 0L;
        this.mBaseMap.ShowLayers(this.mLayerID, z);
        if (w.a) {
            w.a("InnerOverlay", "ShowLayer:" + this.mLayerID + ":" + z + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
        }
    }

    public void UpdateOverlay() {
        if (this.mLayerID == 0 || this.mBaseMap == null || this.mBaseMap.GetId() == 0) {
            return;
        }
        long currentTimeMillis = w.a ? System.currentTimeMillis() : 0L;
        this.mBaseMap.UpdateLayers(this.mLayerID);
        if (w.a) {
            w.a("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
        }
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null || this.mBaseMap.GetId() == 0) {
            return false;
        }
        long currentTimeMillis = w.a ? System.currentTimeMillis() : 0L;
        this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
        if (w.a) {
            w.a("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
        }
        if (this.mLayerID != 0) {
            this.mBaseMap.SetLayersClickable(this.mLayerID, this.c);
            SetOverlayShow(getDefaultShowStatus());
            return true;
        }
        return false;
    }

    public void clear() {
        long currentTimeMillis = w.a ? System.currentTimeMillis() : 0L;
        if (!TextUtils.isEmpty(this.a)) {
            this.a = null;
            if (this.mBaseMap != null) {
                this.mBaseMap.ClearLayer(this.mLayerID);
            }
        }
        if (w.a) {
            w.a("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - currentTimeMillis) + "ms]");
        }
    }

    public String getData() {
        return this.a;
    }

    public boolean getDefaultShowStatus() {
        return false;
    }

    public String getLayerTag() {
        return "default";
    }

    public Bundle getParam() {
        return null;
    }

    public int getType() {
        return this.mType;
    }

    public int getUpdateTimeInterval() {
        return 0;
    }

    public int getUpdateType() {
        return 0;
    }

    public void setClickAble(boolean z) {
        this.c = z;
        if (this.mBaseMap == null || this.mBaseMap.GetId() == 0 || this.mLayerID == 0) {
            return;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, z);
    }

    public void setData(String str) {
        if (str != null) {
            this.a = str;
        }
    }

    public void setFocus(int i, boolean z) {
        setFocus(i, z, null);
    }

    public void setFocus(int i, boolean z, String str) {
        if (this.mBaseMap == null || this.mBaseMap.GetId() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("uid", str);
        }
        this.mBaseMap.SetFocus(this.mLayerID, i, z, bundle);
    }

    public void setParam(Bundle bundle) {
        this.b = bundle;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
