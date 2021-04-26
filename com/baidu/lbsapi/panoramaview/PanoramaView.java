package com.baidu.lbsapi.panoramaview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.lbsapi.tools.CoordinateConverter;
import com.baidu.lbsapi.tools.Point;
import com.baidu.pano.platform.c.e;
import com.baidu.pano.platform.comapi.a.a;
import com.baidu.pano.platform.comapi.a.b;
import com.baidu.pano.platform.comapi.map.InnerPanoramaView;
import com.baidu.pano.platform.plugin.indooralbum.IndoorAlbumPlugin;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PanoramaView extends FrameLayout {
    public static final int COORDTYPE_BD09LL = 2;
    public static final int COORDTYPE_BD09MC = 3;
    public static final int COORDTYPE_GCJ02 = 1;
    public static final int COORDTYPE_WGS84 = 0;
    public static final int PANOTYPE_INTERIOR = 65537;
    public static final int PANOTYPE_STREET = 65538;

    /* renamed from: a  reason: collision with root package name */
    public InnerPanoramaView f6588a;

    /* renamed from: b  reason: collision with root package name */
    public PanoramaViewListener f6589b;

    /* loaded from: classes2.dex */
    public enum ImageDefinition {
        ImageDefinitionLow(3),
        ImageDefinitionMiddle(4),
        ImageDefinitionHigh(5);
        
        public int mValue;

        ImageDefinition(int i2) {
            this.mValue = i2;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public PanoramaView(Context context) {
        super(context, null);
        a(context);
    }

    public boolean addMarker(a aVar) {
        return this.f6588a.a(aVar);
    }

    public void destroy() {
        this.f6588a.d();
    }

    public void enableFastMove(boolean z) {
        this.f6588a.d(z);
    }

    public float getPanoramaHeading() {
        return this.f6588a.b();
    }

    @Deprecated
    public float getPanoramaLevel() {
        return this.f6588a.c();
    }

    public float getPanoramaPitch() {
        return this.f6588a.a();
    }

    public float getPanoramaZoomLevel() {
        return this.f6588a.c();
    }

    public void onPause() {
        this.f6588a.onPause();
    }

    public void onResume() {
        this.f6588a.onResume();
    }

    public void reloadPoiMarker(final String str, final String str2) {
        final Context context = getContext();
        if (e.c(context)) {
            new AsyncTask<String, Integer, String>() { // from class: com.baidu.lbsapi.panoramaview.PanoramaView.2
                @Override // android.os.AsyncTask
                public void onPreExecute() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public String doInBackground(String... strArr) {
                    return PanoramaRequest.getInstance(context).getPoiInfoByUidWithJson(strArr[0]);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str3) {
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        if (jSONObject.getJSONObject("result").optInt("error") != 0 || jSONObject.optString("content") == null || "".equals(jSONObject.optString("content"))) {
                            return;
                        }
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
                            PanoramaView.this.f6588a.a(str, optString, PanoramaView.this, bVar);
                            PanoramaView.this.setPanorama(str2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }.execute(str);
        }
    }

    public boolean removeAllMarker() {
        return this.f6588a.e();
    }

    public boolean removeMarker(a aVar) {
        return this.f6588a.b(aVar);
    }

    public void removePOIMarker() {
        this.f6588a.f();
    }

    public double[] screenPt2Mercator(float f2, float f3) {
        return this.f6588a.a(f2, f3);
    }

    public void setArrowTexture(Bitmap bitmap) {
        this.f6588a.b(bitmap);
    }

    public boolean setArrowTextureByBitmap(Bitmap bitmap) {
        return this.f6588a.a(bitmap);
    }

    public boolean setArrowTextureByUrl(String str) {
        return this.f6588a.c(str);
    }

    public void setCustomMarkerAnchor(String str, float f2, float f3) {
        InnerPanoramaView innerPanoramaView = this.f6588a;
        if (innerPanoramaView != null) {
            innerPanoramaView.a(str, f2, f3);
        }
    }

    public void setCustomMarkerShow(boolean z) {
        this.f6588a.b(z);
    }

    public void setIndoorAlbumGone() {
        IndoorAlbumPlugin.getInstance().setAlbumViewShow(false);
    }

    public void setIndoorAlbumVisible() {
        IndoorAlbumPlugin.getInstance().setAlbumViewShow(true);
    }

    public void setPanorama(String str) {
        this.f6588a.a(str);
    }

    public void setPanoramaByUid(final String str, final int i2) {
        final Context context = getContext();
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() { // from class: com.baidu.lbsapi.panoramaview.PanoramaView.1
            @Override // android.os.AsyncTask
            public void onPreExecute() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public String doInBackground(String... strArr) {
                return PanoramaRequest.getInstance(context).getPoiInfoByUidWithJson(strArr[0]);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str2) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.getJSONObject("result").optInt("error") == 0) {
                            if (jSONObject.optString("content") != null && !"".equals(jSONObject.optString("content"))) {
                                JSONObject jSONObject2 = jSONObject.getJSONArray("content").getJSONObject(0).getJSONObject("poiinfo");
                                boolean z = jSONObject2.optInt("hasinter") == 1;
                                String optString = jSONObject2.optString("IID");
                                String optString2 = jSONObject2.optString("PID");
                                String optString3 = jSONObject2.optString("name");
                                double optDouble = jSONObject2.optDouble("X");
                                double optDouble2 = jSONObject2.optDouble("Y");
                                switch (i2) {
                                    case PanoramaView.PANOTYPE_INTERIOR /* 65537 */:
                                        if (jSONObject2.has("interstartpid")) {
                                            String optString4 = jSONObject2.optString("interstartpid");
                                            if (!TextUtils.isEmpty(optString)) {
                                                if (IndoorAlbumPlugin.getInstance().hasPlugin()) {
                                                    PanoramaView.this.setPanorama(optString4);
                                                    break;
                                                } else {
                                                    PanoramaView.this.f6589b.onLoadPanoramaError(PanoramaView.this.f6588a.a(202));
                                                    break;
                                                }
                                            } else {
                                                PanoramaView.this.f6589b.onLoadPanoramaError(PanoramaView.this.f6588a.a(201));
                                                break;
                                            }
                                        } else {
                                            PanoramaView.this.f6589b.onLoadPanoramaError(PanoramaView.this.f6588a.a(201));
                                            break;
                                        }
                                    case PanoramaView.PANOTYPE_STREET /* 65538 */:
                                        IndoorAlbumPlugin.getInstance().onDestroyView();
                                        if (!TextUtils.isEmpty(optString2)) {
                                            b bVar = new b(PanoramaView.this.getContext(), z, optString3);
                                            bVar.setMarkerPosition(new Point(optDouble, optDouble2));
                                            bVar.setMarkerHeight(2.0f);
                                            PanoramaView.this.f6588a.a(str, optString2, PanoramaView.this, bVar);
                                            PanoramaView.this.f6588a.b(str);
                                            break;
                                        } else {
                                            PanoramaView.this.f6589b.onLoadPanoramaError(PanoramaView.this.f6588a.a(201));
                                            break;
                                        }
                                }
                            }
                        } else {
                            PanoramaView.this.f6589b.onLoadPanoramaError(PanoramaView.this.f6588a.a(201));
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                PanoramaView.this.f6589b.onLoadPanoramaError(PanoramaView.this.f6588a.a(201));
            }
        };
        asyncTask.execute(str, i2 + "");
    }

    public void setPanoramaHeading(float f2) {
        this.f6588a.b(f2);
    }

    public void setPanoramaImageLevel(ImageDefinition imageDefinition) {
        this.f6588a.a(imageDefinition);
    }

    @Deprecated
    public void setPanoramaLevel(int i2) {
        this.f6588a.b(i2);
    }

    public void setPanoramaPitch(float f2) {
        this.f6588a.a(f2);
    }

    public void setPanoramaViewListener(PanoramaViewListener panoramaViewListener) {
        this.f6589b = panoramaViewListener;
        this.f6588a.a(panoramaViewListener);
    }

    public void setPanoramaZoomLevel(int i2) {
        this.f6588a.b(i2);
    }

    public void setPoiEntranceBitMap(Bitmap bitmap) {
        com.baidu.pano.platform.b.a.f9310a = bitmap;
    }

    public void setPoiMarkerVisibility(boolean z) {
        this.f6588a.c(z);
    }

    public void setShowTopoLink(boolean z) {
        this.f6588a.a(z);
    }

    public void setStatisticsCallback(StatisticsCallback statisticsCallback) {
        this.f6588a.a(statisticsCallback);
    }

    private void a(Context context) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6588a = new InnerPanoramaView(context);
        addView(this.f6588a, new FrameLayout.LayoutParams(-1, -1));
        com.baidu.pano.platform.b.a.a(getContext());
    }

    public boolean addMarker(String str, double d2, double d3, double d4, Bitmap bitmap) {
        return this.f6588a.a(str, d2, d3, d4, bitmap);
    }

    public void setPanorama(int i2, int i3) {
        this.f6588a.a(i2, i3);
    }

    public PanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a(context);
    }

    public void setPanorama(double d2, double d3) {
        this.f6588a.a(d2, d3);
    }

    public void setPanorama(double d2, double d3, int i2) {
        if (i2 == 0) {
            Point converter = CoordinateConverter.converter(CoordinateConverter.COOR_TYPE.COOR_TYPE_WGS84, new Point(d2, d3));
            this.f6588a.a(converter.x, converter.y);
        } else if (i2 == 1) {
            Point converter2 = CoordinateConverter.converter(CoordinateConverter.COOR_TYPE.COOR_TYPE_GCJ02, new Point(d2, d3));
            this.f6588a.a(converter2.x, converter2.y);
        } else if (i2 == 2) {
            this.f6588a.a(d2, d3);
        } else if (i2 != 3) {
        } else {
            this.f6588a.a((int) d2, (int) d3);
        }
    }

    public PanoramaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
