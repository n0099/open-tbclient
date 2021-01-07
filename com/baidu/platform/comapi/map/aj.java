package com.baidu.platform.comapi.map;
/* loaded from: classes3.dex */
public class aj extends InnerOverlay {
    public aj() {
        super(30);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(2, 0, MapController.STREETPOPUP_LAYER_TAG);
        if (this.mLayerID != 0) {
            this.mBaseMap.SetLayersClickable(this.mLayerID, true);
            this.mBaseMap.ShowLayers(this.mLayerID, false);
            return true;
        }
        return false;
    }
}
