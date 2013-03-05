package com.baidu.mapapi.cloud;

import android.os.Bundle;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.Mj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c {
    GeoSearchListener a;

    public b(GeoSearchListener geoSearchListener) {
        this.a = geoSearchListener;
    }

    @Override // com.baidu.mapapi.cloud.c
    public void a(a aVar) {
        switch (aVar.a) {
            case BdWebErrorView.ERROR_CODE_504 /* 504 */:
                Bundle newBundle = Mj.getNewBundle(11010207, aVar.c, 0);
                if (newBundle == null) {
                    this.a.onGetGeoResult(null, aVar.c, 100);
                    return;
                }
                GeoSearchResult geoSearchResult = new GeoSearchResult();
                geoSearchResult.status = newBundle.getInt("status");
                geoSearchResult.message = newBundle.getString("message");
                geoSearchResult.size = newBundle.getInt("size");
                geoSearchResult.total = newBundle.getInt("total");
                int i = newBundle.getInt("content_size");
                if (i > 0) {
                    geoSearchResult.poiList = new ArrayList(i);
                    String[] stringArray = newBundle.getStringArray("uid");
                    String[] stringArray2 = newBundle.getStringArray("databox_id");
                    String[] stringArray3 = newBundle.getStringArray("name");
                    String[] stringArray4 = newBundle.getStringArray("addr");
                    String[] stringArray5 = newBundle.getStringArray("tel");
                    String[] stringArray6 = newBundle.getStringArray("zip");
                    int[] intArray = newBundle.getIntArray("province_id");
                    int[] intArray2 = newBundle.getIntArray("city_id");
                    int[] intArray3 = newBundle.getIntArray("district_id");
                    String[] stringArray7 = newBundle.getStringArray("province");
                    String[] stringArray8 = newBundle.getStringArray("city");
                    String[] stringArray9 = newBundle.getStringArray("district");
                    float[] floatArray = newBundle.getFloatArray("latitude");
                    float[] floatArray2 = newBundle.getFloatArray("longitude");
                    String[] stringArray10 = newBundle.getStringArray("tag");
                    String[] stringArray11 = newBundle.getStringArray("ext");
                    for (int i2 = 0; i2 < i; i2++) {
                        CustomPoiInfo customPoiInfo = new CustomPoiInfo();
                        customPoiInfo.uid = Integer.valueOf(stringArray[i2]).intValue();
                        customPoiInfo.databoxId = Integer.valueOf(stringArray2[i2]).intValue();
                        customPoiInfo.name = stringArray3[i2];
                        customPoiInfo.address = stringArray4[i2];
                        customPoiInfo.telephone = stringArray5[i2];
                        customPoiInfo.postCode = stringArray6[i2];
                        customPoiInfo.provinceId = intArray[i2];
                        customPoiInfo.cityId = intArray2[i2];
                        customPoiInfo.districtId = intArray3[i2];
                        customPoiInfo.provinceName = stringArray7[i2];
                        customPoiInfo.cityName = stringArray8[i2];
                        customPoiInfo.districtName = stringArray9[i2];
                        customPoiInfo.latitude = floatArray[i2];
                        customPoiInfo.longitude = floatArray2[i2];
                        customPoiInfo.tag = stringArray10[i2];
                        String str = stringArray11[i2];
                        if (str != null && !"".equals(str)) {
                            customPoiInfo.poiExtend = new HashMap();
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    customPoiInfo.poiExtend.put(next, jSONObject.get(next));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        geoSearchResult.poiList.add(customPoiInfo);
                    }
                }
                if (geoSearchResult.poiList == null) {
                    this.a.onGetGeoResult(geoSearchResult, aVar.c, 100);
                    return;
                } else {
                    this.a.onGetGeoResult(geoSearchResult, aVar.c, aVar.b);
                    return;
                }
            case BdWebErrorView.ERROR_CODE_505 /* 505 */:
                Bundle newBundle2 = Mj.getNewBundle(11010207, aVar.c, 0);
                if (newBundle2 == null) {
                    this.a.onGetGeoDetailsResult(null, aVar.c, 100);
                    return;
                }
                DetailResult detailResult = new DetailResult();
                detailResult.status = newBundle2.getInt("status");
                detailResult.message = newBundle2.getString("message");
                int i3 = newBundle2.getInt("content_size");
                if (i3 == 1) {
                    detailResult.content = new CustomPoiInfo();
                    String[] stringArray12 = newBundle2.getStringArray("uid");
                    String[] stringArray13 = newBundle2.getStringArray("databox_id");
                    String[] stringArray14 = newBundle2.getStringArray("name");
                    String[] stringArray15 = newBundle2.getStringArray("addr");
                    String[] stringArray16 = newBundle2.getStringArray("tel");
                    String[] stringArray17 = newBundle2.getStringArray("zip");
                    int[] intArray4 = newBundle2.getIntArray("province_id");
                    int[] intArray5 = newBundle2.getIntArray("city_id");
                    int[] intArray6 = newBundle2.getIntArray("district_id");
                    String[] stringArray18 = newBundle2.getStringArray("province");
                    String[] stringArray19 = newBundle2.getStringArray("city");
                    String[] stringArray20 = newBundle2.getStringArray("district");
                    float[] floatArray3 = newBundle2.getFloatArray("latitude");
                    float[] floatArray4 = newBundle2.getFloatArray("longitude");
                    String[] stringArray21 = newBundle2.getStringArray("tag");
                    String[] stringArray22 = newBundle2.getStringArray("ext");
                    for (int i4 = 0; i4 < i3; i4++) {
                        detailResult.content.uid = Integer.valueOf(stringArray12[i4]).intValue();
                        detailResult.content.databoxId = Integer.valueOf(stringArray13[i4]).intValue();
                        detailResult.content.name = stringArray14[i4];
                        detailResult.content.address = stringArray15[i4];
                        detailResult.content.telephone = stringArray16[i4];
                        detailResult.content.postCode = stringArray17[i4];
                        detailResult.content.provinceId = intArray4[i4];
                        detailResult.content.cityId = intArray5[i4];
                        detailResult.content.districtId = intArray6[i4];
                        detailResult.content.provinceName = stringArray18[i4];
                        detailResult.content.cityName = stringArray19[i4];
                        detailResult.content.districtName = stringArray20[i4];
                        detailResult.content.latitude = floatArray3[i4];
                        detailResult.content.longitude = floatArray4[i4];
                        detailResult.content.tag = stringArray21[i4];
                        String str2 = stringArray22[i4];
                        if (str2 != null && !"".equals(str2)) {
                            detailResult.content.poiExtend = new HashMap();
                            try {
                                JSONObject jSONObject2 = new JSONObject(str2);
                                Iterator<String> keys2 = jSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    detailResult.content.poiExtend.put(next2, jSONObject2.get(next2));
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (detailResult.content == null) {
                    this.a.onGetGeoDetailsResult(detailResult, aVar.c, 100);
                    return;
                } else {
                    this.a.onGetGeoDetailsResult(detailResult, aVar.c, aVar.b);
                    return;
                }
            default:
                return;
        }
    }
}
