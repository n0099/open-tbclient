package com.baidu.mapapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.Toast;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PoiOverlay extends ItemizedOverlay {

    /* renamed from: a  reason: collision with root package name */
    private MapView f537a;
    private Context b;
    private int c;
    private MKSearch d;
    public ArrayList mList;
    public boolean mUseToast;

    public PoiOverlay(Activity activity, MapView mapView) {
        super(null);
        this.mList = null;
        this.f537a = null;
        this.b = null;
        this.c = 1;
        this.mUseToast = true;
        this.b = activity;
        this.f537a = mapView;
        activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (Mj.i <= 120) {
            this.c = 0;
        } else if (Mj.i <= 180) {
            this.c = 1;
        } else {
            this.c = 2;
        }
    }

    public PoiOverlay(Activity activity, MapView mapView, MKSearch mKSearch) {
        this(activity, mapView);
        this.d = mKSearch;
    }

    public void animateTo() {
        if (size() > 0) {
            onTap(0);
        }
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    protected OverlayItem createItem(int i) {
        char[] cArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        char[] cArr2 = {'l', 'm', 'h'};
        MKPoiInfo mKPoiInfo = (MKPoiInfo) this.mList.get(i);
        OverlayItem overlayItem = new OverlayItem(mKPoiInfo.pt, mKPoiInfo.name, mKPoiInfo.address);
        Drawable drawable = null;
        if (i < 10) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("icon_mark").append(cArr[i]).append('_').append(cArr2[this.c]).append(".png");
            drawable = n.a(this.b, sb.toString());
        }
        overlayItem.setMarker(boundCenterBottom(drawable));
        return overlayItem;
    }

    public MKPoiInfo getPoi(int i) {
        if (this.mList == null) {
            return null;
        }
        return (MKPoiInfo) this.mList.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.ItemizedOverlay
    public boolean onTap(int i) {
        OverlayItem item = getItem(i);
        this.f537a.getController().animateTo(item.mPoint);
        if (this.mUseToast && item.mTitle != null) {
            MKPoiInfo poi = getPoi(i);
            if (poi.hasCaterDetails) {
                this.d.poiDetailSearch(poi.uid);
            }
            Toast.makeText(this.b, item.mTitle, 1).show();
        }
        super.onTap(i);
        return true;
    }

    public void setData(ArrayList arrayList) {
        if (arrayList != null) {
            this.mList = arrayList;
            super.populate();
        }
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    public int size() {
        if (this.mList == null) {
            return 0;
        }
        if (this.mList.size() <= 10) {
            return this.mList.size();
        }
        return 10;
    }
}
