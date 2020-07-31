package com.baidu.lbsapi.panoramaview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.lbsapi.tools.CoordinateConverter;
import com.baidu.lbsapi.tools.Point;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.pano.platform.b.a;
import com.baidu.pano.platform.c.e;
import com.baidu.pano.platform.comapi.a.b;
import com.baidu.pano.platform.comapi.map.InnerPanoramaView;
import com.baidu.pano.platform.plugin.indooralbum.IndoorAlbumPlugin;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PanoramaView extends FrameLayout {
    public static final int COORDTYPE_BD09LL = 2;
    public static final int COORDTYPE_BD09MC = 3;
    public static final int COORDTYPE_GCJ02 = 1;
    public static final int COORDTYPE_WGS84 = 0;
    public static final int PANOTYPE_INTERIOR = 65537;
    public static final int PANOTYPE_STREET = 65538;
    private InnerPanoramaView a;
    private PanoramaViewListener b;

    public PanoramaView(Context context) {
        super(context, null);
        a(context);
    }

    public PanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a(context);
    }

    public PanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(Context context) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a = new InnerPanoramaView(context);
        addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        a.a(getContext());
    }

    public void setPoiEntranceBitMap(Bitmap bitmap) {
        a.a = bitmap;
    }

    public void setPanorama(String str) {
        this.a.a(str);
    }

    public void setPanorama(int i, int i2) {
        this.a.a(i, i2);
    }

    public void setPanorama(double d, double d2) {
        this.a.a(d, d2);
    }

    public void setPanorama(double d, double d2, int i) {
        switch (i) {
            case 0:
                Point converter = CoordinateConverter.converter(CoordinateConverter.COOR_TYPE.COOR_TYPE_WGS84, new Point(d, d2));
                this.a.a(converter.x, converter.y);
                return;
            case 1:
                Point converter2 = CoordinateConverter.converter(CoordinateConverter.COOR_TYPE.COOR_TYPE_GCJ02, new Point(d, d2));
                this.a.a(converter2.x, converter2.y);
                return;
            case 2:
                this.a.a(d, d2);
                return;
            case 3:
                this.a.a((int) d, (int) d2);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.lbsapi.panoramaview.PanoramaView$1] */
    public void setPanoramaByUid(final String str, final int i) {
        final Context context = getContext();
        new AsyncTask<String, Integer, String>() { // from class: com.baidu.lbsapi.panoramaview.PanoramaView.1
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(String... strArr) {
                return PanoramaRequest.getInstance(context).getPoiInfoByUidWithJson(strArr[0]);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.getJSONObject("result").optInt(BdStatsConstant.StatsType.ERROR) == 0) {
                            if (jSONObject.optString("content") != null && !"".equals(jSONObject.optString("content"))) {
                                JSONObject jSONObject2 = jSONObject.getJSONArray("content").getJSONObject(0).getJSONObject("poiinfo");
                                boolean z = jSONObject2.optInt("hasinter") == 1;
                                String optString = jSONObject2.optString("IID");
                                String optString2 = jSONObject2.optString("PID");
                                String optString3 = jSONObject2.optString("name");
                                double optDouble = jSONObject2.optDouble("X");
                                double optDouble2 = jSONObject2.optDouble("Y");
                                switch (i) {
                                    case PanoramaView.PANOTYPE_INTERIOR /* 65537 */:
                                        if (jSONObject2.has("interstartpid")) {
                                            String optString4 = jSONObject2.optString("interstartpid");
                                            if (!TextUtils.isEmpty(optString)) {
                                                if (IndoorAlbumPlugin.getInstance().hasPlugin()) {
                                                    PanoramaView.this.setPanorama(optString4);
                                                    break;
                                                } else {
                                                    PanoramaView.this.b.onLoadPanoramaError(PanoramaView.this.a.a(202));
                                                    break;
                                                }
                                            } else {
                                                PanoramaView.this.b.onLoadPanoramaError(PanoramaView.this.a.a(201));
                                                break;
                                            }
                                        } else {
                                            PanoramaView.this.b.onLoadPanoramaError(PanoramaView.this.a.a(201));
                                            break;
                                        }
                                    case PanoramaView.PANOTYPE_STREET /* 65538 */:
                                        IndoorAlbumPlugin.getInstance().onDestroyView();
                                        if (!TextUtils.isEmpty(optString2)) {
                                            b bVar = new b(PanoramaView.this.getContext(), z, optString3);
                                            bVar.setMarkerPosition(new Point(optDouble, optDouble2));
                                            bVar.setMarkerHeight(2.0f);
                                            PanoramaView.this.a.a(str, optString2, PanoramaView.this, bVar);
                                            PanoramaView.this.a.b(str);
                                            break;
                                        } else {
                                            PanoramaView.this.b.onLoadPanoramaError(PanoramaView.this.a.a(201));
                                            break;
                                        }
                                }
                            }
                        } else {
                            PanoramaView.this.b.onLoadPanoramaError(PanoramaView.this.a.a(201));
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                PanoramaView.this.b.onLoadPanoramaError(PanoramaView.this.a.a(201));
            }
        }.execute(str, i + "");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.lbsapi.panoramaview.PanoramaView$2] */
    public void reloadPoiMarker(final String str, final String str2) {
        final Context context = getContext();
        if (e.c(context)) {
            new AsyncTask<String, Integer, String>() { // from class: com.baidu.lbsapi.panoramaview.PanoramaView.2
                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public String doInBackground(String... strArr) {
                    return PanoramaRequest.getInstance(context).getPoiInfoByUidWithJson(strArr[0]);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str3) {
                    if (!TextUtils.isEmpty(str3)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            if (jSONObject.getJSONObject("result").optInt(BdStatsConstant.StatsType.ERROR) == 0 && jSONObject.optString("content") != null && !"".equals(jSONObject.optString("content"))) {
                                JSONObject jSONObject2 = jSONObject.getJSONArray("content").getJSONObject(0).getJSONObject("poiinfo");
                                boolean z = jSONObject2.optInt("hasinter") == 1;
                                String optString = jSONObject2.optString("PID");
                                String optString2 = jSONObject2.optString("name");
                                double optDouble = jSONObject2.optDouble("X");
                                double optDouble2 = jSONObject2.optDouble("Y");
                                if (jSONObject2.has("interstartpid")) {
                                    b bVar = new b(PanoramaView.this.getContext(), z, optString2);
                                    bVar.setMarkerPosition(new Point(optDouble, optDouble2));
                                    bVar.setMarkerHeight(2.0f);
                                    PanoramaView.this.a.a(str, optString, PanoramaView.this, bVar);
                                    PanoramaView.this.setPanorama(str2);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.execute(str);
        }
    }

    public void setIndoorAlbumGone() {
        IndoorAlbumPlugin.getInstance().setAlbumViewShow(false);
    }

    public void setIndoorAlbumVisible() {
        IndoorAlbumPlugin.getInstance().setAlbumViewShow(true);
    }

    public void setPanoramaPitch(float f) {
        this.a.a(f);
    }

    public float getPanoramaPitch() {
        return this.a.a();
    }

    public void setPanoramaHeading(float f) {
        this.a.b(f);
    }

    public float getPanoramaHeading() {
        return this.a.b();
    }

    @Deprecated
    public void setPanoramaLevel(int i) {
        this.a.b(i);
    }

    public void setPanoramaZoomLevel(int i) {
        this.a.b(i);
    }

    @Deprecated
    public float getPanoramaLevel() {
        return this.a.c();
    }

    public float getPanoramaZoomLevel() {
        return this.a.c();
    }

    public void setPanoramaImageLevel(ImageDefinition imageDefinition) {
        this.a.a(imageDefinition);
    }

    public boolean setArrowTextureByBitmap(Bitmap bitmap) {
        return this.a.a(bitmap);
    }

    public boolean setArrowTextureByUrl(String str) {
        return this.a.c(str);
    }

    public void setShowTopoLink(boolean z) {
        this.a.a(z);
    }

    public void setArrowTexture(Bitmap bitmap) {
        this.a.b(bitmap);
    }

    public void destroy() {
        this.a.d();
    }

    public void setCustomMarkerShow(boolean z) {
        this.a.b(z);
    }

    public boolean addMarker(com.baidu.pano.platform.comapi.a.a aVar) {
        return this.a.a(aVar);
    }

    public boolean addMarker(String str, double d, double d2, double d3, Bitmap bitmap) {
        return this.a.a(str, d, d2, d3, bitmap);
    }

    public void setCustomMarkerAnchor(String str, float f, float f2) {
        if (this.a != null) {
            this.a.a(str, f, f2);
        }
    }

    public boolean removeMarker(com.baidu.pano.platform.comapi.a.a aVar) {
        return this.a.b(aVar);
    }

    public boolean removeAllMarker() {
        return this.a.e();
    }

    public void setPoiMarkerVisibility(boolean z) {
        this.a.c(z);
    }

    public void removePOIMarker() {
        this.a.f();
    }

    public void enableFastMove(boolean z) {
        this.a.d(z);
    }

    public double[] screenPt2Mercator(float f, float f2) {
        return this.a.a(f, f2);
    }

    public void setPanoramaViewListener(PanoramaViewListener panoramaViewListener) {
        this.b = panoramaViewListener;
        this.a.a(this.b);
    }

    /* loaded from: classes10.dex */
    public enum ImageDefinition {
        ImageDefinitionLow(3),
        ImageDefinitionMiddle(4),
        ImageDefinitionHigh(5);
        
        private int mValue;

        ImageDefinition(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public void onResume() {
        this.a.onResume();
    }

    public void onPause() {
        this.a.onPause();
    }

    public void setStatisticsCallback(StatisticsCallback statisticsCallback) {
        this.a.a(statisticsCallback);
    }
}
