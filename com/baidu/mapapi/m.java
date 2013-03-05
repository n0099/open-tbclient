package com.baidu.mapapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.browser.explorer.BdWebErrorView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements j {
    private MKSearchListener a;

    public m(MKSearchListener mKSearchListener) {
        this.a = mKSearchListener;
    }

    private int a(Bundle bundle, MKRouteAddrResult mKRouteAddrResult) {
        Parcelable[] parcelableArray = bundle.getParcelableArray("aryAddr");
        Bundle bundle2 = (Bundle) parcelableArray[0];
        if (bundle2 != null) {
            ArrayList arrayList = new ArrayList();
            a(bundle2, arrayList);
            mKRouteAddrResult.mStartPoiList = arrayList;
        }
        Bundle bundle3 = (Bundle) parcelableArray[1];
        if (bundle3 != null) {
            ArrayList arrayList2 = new ArrayList();
            b(bundle3, arrayList2);
            mKRouteAddrResult.mStartCityList = arrayList2;
        }
        Bundle bundle4 = (Bundle) parcelableArray[2];
        if (bundle4 != null) {
            ArrayList arrayList3 = new ArrayList();
            a(bundle4, arrayList3);
            mKRouteAddrResult.mEndPoiList = arrayList3;
        }
        Bundle bundle5 = (Bundle) parcelableArray[3];
        if (bundle5 != null) {
            ArrayList arrayList4 = new ArrayList();
            b(bundle5, arrayList4);
            mKRouteAddrResult.mEndCityList = arrayList4;
        }
        return bundle.getInt("type");
    }

    private void a(Bundle bundle, MKAddrInfo mKAddrInfo) {
        mKAddrInfo.strAddr = bundle.getString("addr");
        mKAddrInfo.geoPt = new GeoPoint(bundle.getInt("y"), bundle.getInt("x"));
    }

    private void a(Bundle bundle, MKAddrInfo mKAddrInfo, int i) {
        mKAddrInfo.strAddr = bundle.getString("addr");
        mKAddrInfo.strBusiness = bundle.getString("business");
        mKAddrInfo.addressComponents = new MKGeocoderAddressComponent();
        mKAddrInfo.addressComponents.streetNumber = bundle.getString("streetNumber");
        mKAddrInfo.addressComponents.street = bundle.getString("street");
        mKAddrInfo.addressComponents.district = bundle.getString("district");
        mKAddrInfo.addressComponents.city = bundle.getString("city");
        mKAddrInfo.addressComponents.province = bundle.getString("province");
        mKAddrInfo.geoPt = new GeoPoint(bundle.getInt("y"), bundle.getInt("x"));
        if (bundle.containsKey("aryCaption")) {
            String[] stringArray = bundle.getStringArray("aryCaption");
            String[] stringArray2 = bundle.getStringArray("aryAddr");
            String[] stringArray3 = bundle.getStringArray("aryTel");
            String[] stringArray4 = bundle.getStringArray("aryZip");
            int[] intArray = bundle.getIntArray("aryType");
            int[] intArray2 = bundle.getIntArray("aryX");
            int[] intArray3 = bundle.getIntArray("aryY");
            String string = bundle.getString("city");
            ArrayList arrayList = new ArrayList();
            int length = stringArray.length;
            for (int i2 = 0; i2 < length; i2++) {
                MKPoiInfo mKPoiInfo = new MKPoiInfo();
                mKPoiInfo.name = stringArray[i2];
                mKPoiInfo.address = stringArray2[i2];
                mKPoiInfo.city = string;
                mKPoiInfo.phoneNum = stringArray3[i2];
                mKPoiInfo.postCode = stringArray4[i2];
                mKPoiInfo.ePoiType = intArray[i2];
                mKPoiInfo.pt = new GeoPoint(intArray3[i2], intArray2[i2]);
                arrayList.add(mKPoiInfo);
            }
            mKAddrInfo.poiList = arrayList;
        }
    }

    private void a(Bundle bundle, MKDrivingRouteResult mKDrivingRouteResult, int i) {
        try {
            String string = bundle.getString("st_name");
            int i2 = bundle.getInt("st_pt_x");
            int i3 = bundle.getInt("st_pt_y");
            MKPlanNode mKPlanNode = new MKPlanNode();
            mKPlanNode.name = string;
            mKPlanNode.pt = new GeoPoint(i3, i2);
            mKDrivingRouteResult.a(mKPlanNode);
            String string2 = bundle.getString("en_name");
            int i4 = bundle.getInt("en_pt_x");
            int i5 = bundle.getInt("en_pt_y");
            MKPlanNode mKPlanNode2 = new MKPlanNode();
            mKPlanNode2.name = string2;
            mKPlanNode2.pt = new GeoPoint(i5, i4);
            mKDrivingRouteResult.b(mKPlanNode2);
            ArrayList arrayList = new ArrayList();
            if (bundle.getInt("planNum") > 0) {
                MKRoutePlan mKRoutePlan = new MKRoutePlan();
                mKRoutePlan.a(bundle.getInt("distance"));
                ArrayList arrayList2 = new ArrayList();
                for (Parcelable parcelable : bundle.getParcelableArray("aryRoute")) {
                    MKRoute mKRoute = new MKRoute();
                    Bundle bundle2 = (Bundle) parcelable;
                    mKRoute.a(bundle2.getInt("distance"));
                    mKRoute.b(1);
                    mKRoute.a(mKPlanNode.pt);
                    mKRoute.b(mKPlanNode2.pt);
                    if (bundle2.containsKey("link")) {
                        int i6 = bundle2.getInt("link");
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        for (int i7 = 0; i7 < i6; i7++) {
                            int[] intArray = bundle2.getIntArray(String.format("aryX%d", Integer.valueOf(i7)));
                            int[] intArray2 = bundle2.getIntArray(String.format("aryY%d", Integer.valueOf(i7)));
                            if (intArray != null) {
                                ArrayList arrayList5 = new ArrayList();
                                for (int i8 = 0; i8 < intArray.length; i8++) {
                                    if (i8 == 0 || intArray2[i8] != intArray2[i8 - 1] || intArray[i8] != intArray[i8 - 1]) {
                                        arrayList5.add(new GeoPoint(intArray2[i8], intArray[i8]));
                                    }
                                }
                                arrayList3.add(arrayList5);
                                int[] intArray3 = bundle2.getIntArray(String.format("aryMcX%d", Integer.valueOf(i7)));
                                int[] intArray4 = bundle2.getIntArray(String.format("aryMcY%d", Integer.valueOf(i7)));
                                if (intArray3 != null) {
                                    ArrayList arrayList6 = new ArrayList();
                                    for (int i9 = 0; i9 < intArray3.length; i9++) {
                                        if (i9 == 0 || intArray4[i9] != intArray4[i9 - 1] || intArray3[i9] != intArray3[i9 - 1]) {
                                            arrayList6.add(new GeoPoint(intArray4[i9], intArray3[i9]));
                                        }
                                    }
                                    arrayList4.add(arrayList6);
                                }
                            }
                        }
                        mKRoute.b(arrayList3);
                        mKRoute.a = arrayList4;
                    }
                    if (bundle2.containsKey("aryStep")) {
                        ArrayList arrayList7 = new ArrayList();
                        for (Parcelable parcelable2 : bundle2.getParcelableArray("aryStep")) {
                            Bundle bundle3 = (Bundle) parcelable2;
                            MKStep mKStep = new MKStep();
                            mKStep.a(new GeoPoint(bundle3.getInt("y"), bundle3.getInt("x")));
                            mKStep.a(bundle3.getInt("dir"));
                            mKStep.a(bundle3.getString("tip"));
                            arrayList7.add(mKStep);
                        }
                        mKRoute.a(arrayList7);
                    }
                    arrayList2.add(mKRoute);
                }
                mKRoutePlan.a(arrayList2);
                arrayList.add(mKRoutePlan);
            }
            mKDrivingRouteResult.a(arrayList);
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse DrivingRouteResult error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void a(Bundle bundle, MKPoiResult mKPoiResult, int i) {
        switch (i) {
            case 7:
                try {
                    String[] stringArray = bundle.getStringArray("aryCity");
                    int[] intArray = bundle.getIntArray("aryNum");
                    ArrayList arrayList = new ArrayList();
                    int length = stringArray.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        MKCityListInfo mKCityListInfo = new MKCityListInfo();
                        mKCityListInfo.city = stringArray[i2];
                        mKCityListInfo.num = intArray[i2];
                        arrayList.add(mKCityListInfo);
                    }
                    mKPoiResult.c(arrayList);
                    return;
                } catch (Exception e) {
                    Log.d("MKSearchNotifier", "parse PoiResult error!");
                    Log.d("MKSearchNotifier", e.getMessage());
                    return;
                }
            case 11:
            case 12:
            case 21:
                try {
                    int i3 = bundle.getInt("iTotal");
                    int i4 = bundle.getInt("iCurrNumPois");
                    int i5 = bundle.getInt("iPageIndex");
                    mKPoiResult.b(i3);
                    mKPoiResult.a(i4);
                    mKPoiResult.d(i5);
                    int poiPageCapacity = i3 / MKSearch.getPoiPageCapacity();
                    if (i3 % MKSearch.getPoiPageCapacity() > 0) {
                        poiPageCapacity++;
                    }
                    mKPoiResult.c(poiPageCapacity);
                    String[] stringArray2 = bundle.getStringArray("aryCaption");
                    String[] stringArray3 = bundle.getStringArray("aryUid");
                    String[] stringArray4 = bundle.getStringArray("aryAddr");
                    String[] stringArray5 = bundle.getStringArray("aryTel");
                    String[] stringArray6 = bundle.getStringArray("aryZip");
                    int[] intArray2 = bundle.getIntArray("aryType");
                    int[] intArray3 = bundle.getIntArray("aryX");
                    int[] intArray4 = bundle.getIntArray("aryY");
                    String[] stringArray7 = bundle.getStringArray("srcName");
                    String string = bundle.getString("city");
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = stringArray2.length;
                    for (int i6 = 0; i6 < length2; i6++) {
                        MKPoiInfo mKPoiInfo = new MKPoiInfo();
                        mKPoiInfo.name = stringArray2[i6];
                        mKPoiInfo.address = stringArray4[i6];
                        mKPoiInfo.uid = stringArray3[i6];
                        mKPoiInfo.city = string;
                        mKPoiInfo.phoneNum = stringArray5[i6];
                        mKPoiInfo.postCode = stringArray6[i6];
                        mKPoiInfo.ePoiType = intArray2[i6];
                        mKPoiInfo.hasCaterDetails = "cater".equals(stringArray7[i6]);
                        mKPoiInfo.pt = new GeoPoint(intArray4[i6], intArray3[i6]);
                        arrayList2.add(mKPoiInfo);
                    }
                    mKPoiResult.a(arrayList2);
                    return;
                } catch (Exception e2) {
                    Log.d("MKSearchNotifier", "parse PoiResult error!");
                    Log.d("MKSearchNotifier", e2.getMessage());
                    return;
                }
            case MKSearch.TYPE_AREA_MULTI_POI_LIST /* 45 */:
                Parcelable[] parcelableArray = bundle.getParcelableArray("aryMultiPoiList");
                if (parcelableArray != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Parcelable parcelable : parcelableArray) {
                        MKPoiResult mKPoiResult2 = new MKPoiResult();
                        Bundle bundle2 = (Bundle) parcelable;
                        if (bundle2 == null) {
                            arrayList3.add(mKPoiResult2);
                        } else {
                            ArrayList arrayList4 = new ArrayList();
                            int i7 = bundle2.getInt("iTotal");
                            int i8 = bundle2.getInt("iCurrNumPois");
                            int i9 = bundle.getInt("iPageIndex");
                            mKPoiResult2.b(i7);
                            mKPoiResult2.a(i8);
                            mKPoiResult2.d(i9);
                            int poiPageCapacity2 = i7 / MKSearch.getPoiPageCapacity();
                            if (i7 % MKSearch.getPoiPageCapacity() > 0) {
                                poiPageCapacity2++;
                            }
                            mKPoiResult2.c(poiPageCapacity2);
                            String[] stringArray8 = bundle2.getStringArray("aryCaption");
                            String[] stringArray9 = bundle2.getStringArray("aryAddr");
                            String[] stringArray10 = bundle2.getStringArray("aryTel");
                            String[] stringArray11 = bundle2.getStringArray("aryZip");
                            int[] intArray5 = bundle2.getIntArray("aryType");
                            int[] intArray6 = bundle2.getIntArray("aryX");
                            int[] intArray7 = bundle2.getIntArray("aryY");
                            String string2 = bundle2.getString("city");
                            int length3 = stringArray8.length;
                            for (int i10 = 0; i10 < length3; i10++) {
                                MKPoiInfo mKPoiInfo2 = new MKPoiInfo();
                                mKPoiInfo2.name = stringArray8[i10];
                                mKPoiInfo2.address = stringArray9[i10];
                                mKPoiInfo2.city = string2;
                                mKPoiInfo2.phoneNum = stringArray10[i10];
                                mKPoiInfo2.postCode = stringArray11[i10];
                                mKPoiInfo2.ePoiType = intArray5[i10];
                                mKPoiInfo2.pt = new GeoPoint(intArray7[i10], intArray6[i10]);
                                arrayList4.add(mKPoiInfo2);
                            }
                            mKPoiResult2.a(arrayList4);
                            arrayList3.add(mKPoiResult2);
                        }
                    }
                    mKPoiResult.b(arrayList3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(Bundle bundle, MKSuggestionResult mKSuggestionResult, int i) {
        try {
            String[] stringArray = bundle.getStringArray("aryPoiName");
            String[] stringArray2 = bundle.getStringArray("aryCityName");
            ArrayList arrayList = new ArrayList();
            int length = stringArray != null ? stringArray.length : 0;
            for (int i2 = 0; i2 < length; i2++) {
                MKSuggestionInfo mKSuggestionInfo = new MKSuggestionInfo();
                mKSuggestionInfo.city = stringArray2[i2];
                mKSuggestionInfo.key = stringArray[i2];
                arrayList.add(mKSuggestionInfo);
            }
            mKSuggestionResult.a(arrayList);
            mKSuggestionResult.getSuggestionNum();
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse SuggestionResult error!");
        }
    }

    private void a(Bundle bundle, MKTransitRouteResult mKTransitRouteResult, int i) {
        try {
            String string = bundle.getString("st_name");
            int i2 = bundle.getInt("st_pt_x");
            int i3 = bundle.getInt("st_pt_y");
            MKPlanNode mKPlanNode = new MKPlanNode();
            mKPlanNode.name = string;
            mKPlanNode.pt = new GeoPoint(i3, i2);
            mKTransitRouteResult.a(mKPlanNode);
            String string2 = bundle.getString("en_name");
            int i4 = bundle.getInt("en_pt_x");
            int i5 = bundle.getInt("en_pt_y");
            MKPlanNode mKPlanNode2 = new MKPlanNode();
            mKPlanNode2.name = string2;
            mKPlanNode2.pt = new GeoPoint(i5, i4);
            mKTransitRouteResult.b(mKPlanNode2);
            ArrayList arrayList = new ArrayList();
            Parcelable[] parcelableArray = bundle.getParcelableArray("aryPlan");
            if (parcelableArray == null) {
                mKTransitRouteResult.a(arrayList);
                return;
            }
            for (Parcelable parcelable : parcelableArray) {
                MKTransitRoutePlan mKTransitRoutePlan = new MKTransitRoutePlan();
                mKTransitRoutePlan.a(mKPlanNode.pt);
                mKTransitRoutePlan.b(mKPlanNode2.pt);
                Bundle bundle2 = (Bundle) parcelable;
                mKTransitRoutePlan.a(bundle2.getInt("distance"));
                ArrayList arrayList2 = new ArrayList();
                Parcelable[] parcelableArray2 = bundle2.getParcelableArray("aryLine");
                for (Parcelable parcelable2 : parcelableArray2 == null ? new Parcelable[0] : parcelableArray2) {
                    MKLine mKLine = new MKLine();
                    Bundle bundle3 = (Bundle) parcelable2;
                    mKLine.b(bundle3.getInt("distance"));
                    mKLine.c(bundle3.getInt("type"));
                    mKLine.a(bundle3.getInt("numStops"));
                    mKLine.b(bundle3.getString("title"));
                    mKLine.c(bundle3.getString("uid"));
                    mKLine.a(bundle3.getString("getOnTip"));
                    MKPoiInfo mKPoiInfo = new MKPoiInfo();
                    mKPoiInfo.name = bundle3.getString("getOnStopName");
                    if (bundle3.containsKey("getOnStopPtX")) {
                        mKPoiInfo.pt = new GeoPoint(bundle3.getInt("getOnStopPtY"), bundle3.getInt("getOnStopPtX"));
                    }
                    mKLine.a(mKPoiInfo);
                    MKPoiInfo mKPoiInfo2 = new MKPoiInfo();
                    mKPoiInfo2.name = bundle3.getString("getOffStopName");
                    if (bundle3.containsKey("getOffStopPtX")) {
                        mKPoiInfo2.pt = new GeoPoint(bundle3.getInt("getOffStopPtY"), bundle3.getInt("getOffStopPtX"));
                    }
                    mKLine.b(mKPoiInfo2);
                    int[] intArray = bundle3.getIntArray("aryX");
                    if (intArray != null) {
                        ArrayList arrayList3 = new ArrayList();
                        int[] intArray2 = bundle3.getIntArray("aryY");
                        for (int i6 = 0; i6 < intArray.length; i6++) {
                            if (i6 == 0 || intArray2[i6] != intArray2[i6 - 1] || intArray[i6] != intArray[i6 - 1]) {
                                arrayList3.add(new GeoPoint(intArray2[i6], intArray[i6]));
                            }
                        }
                        mKLine.a(arrayList3);
                    }
                    int[] intArray3 = bundle3.getIntArray("aryMcX");
                    if (intArray3 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int[] intArray4 = bundle3.getIntArray("aryMcY");
                        for (int i7 = 0; i7 < intArray3.length; i7++) {
                            if (i7 == 0 || intArray4[i7] != intArray4[i7 - 1] || intArray3[i7] != intArray3[i7 - 1]) {
                                arrayList4.add(new GeoPoint(intArray4[i7], intArray3[i7]));
                            }
                        }
                        mKLine.a = arrayList4;
                    }
                    arrayList2.add(mKLine);
                }
                mKTransitRoutePlan.setLine(arrayList2);
                ArrayList arrayList5 = new ArrayList();
                Parcelable[] parcelableArray3 = bundle2.getParcelableArray("aryRoute");
                for (Parcelable parcelable3 : parcelableArray3 == null ? new Parcelable[0] : parcelableArray3) {
                    MKRoute mKRoute = new MKRoute();
                    Bundle bundle4 = (Bundle) parcelable3;
                    mKRoute.a(bundle4.getInt("distance"));
                    mKRoute.b(2);
                    mKRoute.a(bundle4.getString("getOffTip"));
                    ArrayList arrayList6 = new ArrayList();
                    ArrayList arrayList7 = new ArrayList();
                    if (bundle4.containsKey("startX")) {
                        mKRoute.a(new GeoPoint(bundle4.getInt("startY"), bundle4.getInt("startX")));
                    }
                    if (bundle4.containsKey("aryX")) {
                        int[] intArray5 = bundle4.getIntArray("aryX");
                        int[] intArray6 = bundle4.getIntArray("aryY");
                        for (int i8 = 0; i8 < intArray5.length; i8++) {
                            if (i8 == 0 || intArray6[i8] != intArray6[i8 - 1] || intArray5[i8] != intArray5[i8 - 1]) {
                                arrayList6.add(new GeoPoint(intArray6[i8], intArray5[i8]));
                            }
                        }
                    }
                    if (bundle4.containsKey("aryMcX")) {
                        int[] intArray7 = bundle4.getIntArray("aryMcX");
                        int[] intArray8 = bundle4.getIntArray("aryMcY");
                        for (int i9 = 0; i9 < intArray7.length; i9++) {
                            if (i9 == 0 || intArray8[i9] != intArray8[i9 - 1] || intArray7[i9] != intArray7[i9 - 1]) {
                                arrayList7.add(new GeoPoint(intArray8[i9], intArray7[i9]));
                            }
                        }
                    }
                    if (bundle4.containsKey("endX")) {
                        mKRoute.b(new GeoPoint(bundle4.getInt("endY"), bundle4.getInt("endX")));
                    }
                    ArrayList arrayList8 = new ArrayList();
                    arrayList8.add(arrayList6);
                    mKRoute.b(arrayList8);
                    ArrayList arrayList9 = new ArrayList();
                    arrayList9.add(arrayList7);
                    mKRoute.a = arrayList9;
                    arrayList5.add(mKRoute);
                }
                mKTransitRoutePlan.a(arrayList5);
                arrayList.add(mKTransitRoutePlan);
            }
            mKTransitRouteResult.a(arrayList);
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse TransitRouteResult error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void a(Bundle bundle, MKWalkingRouteResult mKWalkingRouteResult, int i) {
        try {
            String string = bundle.getString("st_name");
            int i2 = bundle.getInt("st_pt_x");
            int i3 = bundle.getInt("st_pt_y");
            MKPlanNode mKPlanNode = new MKPlanNode();
            mKPlanNode.name = string;
            mKPlanNode.pt = new GeoPoint(i3, i2);
            mKWalkingRouteResult.a(mKPlanNode);
            String string2 = bundle.getString("en_name");
            int i4 = bundle.getInt("en_pt_x");
            int i5 = bundle.getInt("en_pt_y");
            MKPlanNode mKPlanNode2 = new MKPlanNode();
            mKPlanNode2.name = string2;
            mKPlanNode2.pt = new GeoPoint(i5, i4);
            mKWalkingRouteResult.b(mKPlanNode2);
            ArrayList arrayList = new ArrayList();
            if (bundle.getInt("planNum") > 0) {
                MKRoutePlan mKRoutePlan = new MKRoutePlan();
                mKRoutePlan.a(bundle.getInt("distance"));
                ArrayList arrayList2 = new ArrayList();
                for (Parcelable parcelable : bundle.getParcelableArray("aryRoute")) {
                    MKRoute mKRoute = new MKRoute();
                    Bundle bundle2 = (Bundle) parcelable;
                    mKRoute.a(bundle2.getInt("distance"));
                    mKRoute.b(2);
                    mKRoute.a(mKPlanNode.pt);
                    mKRoute.b(mKPlanNode2.pt);
                    if (bundle2.containsKey("link")) {
                        int i6 = bundle2.getInt("link");
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        for (int i7 = 0; i7 < i6; i7++) {
                            int[] intArray = bundle2.getIntArray(String.format("aryX%d", Integer.valueOf(i7)));
                            int[] intArray2 = bundle2.getIntArray(String.format("aryY%d", Integer.valueOf(i7)));
                            if (intArray != null) {
                                ArrayList arrayList5 = new ArrayList();
                                for (int i8 = 0; i8 < intArray.length; i8++) {
                                    if (i8 == 0 || intArray2[i8] != intArray2[i8 - 1] || intArray[i8] != intArray[i8 - 1]) {
                                        arrayList5.add(new GeoPoint(intArray2[i8], intArray[i8]));
                                    }
                                }
                                arrayList3.add(arrayList5);
                                int[] intArray3 = bundle2.getIntArray(String.format("aryMcX%d", Integer.valueOf(i7)));
                                int[] intArray4 = bundle2.getIntArray(String.format("aryMcY%d", Integer.valueOf(i7)));
                                if (intArray3 != null) {
                                    ArrayList arrayList6 = new ArrayList();
                                    for (int i9 = 0; i9 < intArray3.length; i9++) {
                                        if (i9 == 0 || intArray4[i9] != intArray4[i9 - 1] || intArray3[i9] != intArray3[i9 - 1]) {
                                            arrayList6.add(new GeoPoint(intArray4[i9], intArray3[i9]));
                                        }
                                    }
                                    arrayList4.add(arrayList6);
                                }
                            }
                        }
                        mKRoute.b(arrayList3);
                        mKRoute.a = arrayList4;
                    }
                    if (bundle2.containsKey("aryStep")) {
                        ArrayList arrayList7 = new ArrayList();
                        for (Parcelable parcelable2 : bundle2.getParcelableArray("aryStep")) {
                            Bundle bundle3 = (Bundle) parcelable2;
                            MKStep mKStep = new MKStep();
                            mKStep.a(new GeoPoint(bundle3.getInt("y"), bundle3.getInt("x")));
                            mKStep.a(bundle3.getInt("dir"));
                            mKStep.a(bundle3.getString("tip"));
                            arrayList7.add(mKStep);
                        }
                        mKRoute.a(arrayList7);
                    }
                    arrayList2.add(mKRoute);
                }
                mKRoutePlan.a(arrayList2);
                arrayList.add(mKRoutePlan);
            }
            mKWalkingRouteResult.a(arrayList);
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse WalkingRouteResult error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
    }

    private void a(Bundle bundle, ArrayList arrayList) {
        String[] stringArray = bundle.getStringArray("aryCaption");
        String[] stringArray2 = bundle.getStringArray("aryAddr");
        int[] intArray = bundle.getIntArray("aryX");
        int[] intArray2 = bundle.getIntArray("aryY");
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            MKPoiInfo mKPoiInfo = new MKPoiInfo();
            mKPoiInfo.name = stringArray[i];
            mKPoiInfo.address = stringArray2[i];
            mKPoiInfo.pt = new GeoPoint(intArray2[i], intArray[i]);
            arrayList.add(mKPoiInfo);
        }
    }

    private boolean a(Bundle bundle, MKBusLineResult mKBusLineResult) {
        MKRoute busRoute;
        ArrayList arrayList;
        ArrayList arrayList2;
        try {
            String string = bundle.getString("company");
            String string2 = bundle.getString("busName");
            String string3 = bundle.getString("startTime");
            String string4 = bundle.getString("endTime");
            mKBusLineResult.a(string, string2, bundle.getInt("monTicket"));
            mKBusLineResult.a(string3);
            mKBusLineResult.b(string4);
            busRoute = mKBusLineResult.getBusRoute();
            busRoute.b(3);
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
        } catch (Exception e) {
            Log.d("MKSearchNotifier", "parse BusDetail error!");
            Log.d("MKSearchNotifier", e.getMessage());
        }
        if (bundle.containsKey("link")) {
            int i = bundle.getInt("link");
            for (int i2 = 0; i2 < i; i2++) {
                int[] intArray = bundle.getIntArray(String.format("aryX%d", Integer.valueOf(i2)));
                int[] intArray2 = bundle.getIntArray(String.format("aryY%d", Integer.valueOf(i2)));
                if (intArray != null) {
                    ArrayList arrayList3 = new ArrayList();
                    int length = intArray.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if (i3 == 0 || intArray2[i3] != intArray2[i3 - 1] || intArray[i3] != intArray[i3 - 1]) {
                            arrayList3.add(new GeoPoint(intArray2[i3], intArray[i3]));
                        }
                    }
                    arrayList.add(arrayList3);
                    int[] intArray3 = bundle.getIntArray(String.format("aryMcX%d", Integer.valueOf(i2)));
                    int[] intArray4 = bundle.getIntArray(String.format("aryMcY%d", Integer.valueOf(i2)));
                    if (intArray3 != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int length2 = intArray3.length;
                        for (int i4 = 0; i4 < length2; i4++) {
                            if (i4 == 0 || intArray4[i4] != intArray4[i4 - 1] || intArray3[i4] != intArray3[i4 - 1]) {
                                arrayList4.add(new GeoPoint(intArray4[i4], intArray3[i4]));
                            }
                        }
                        arrayList2.add(arrayList4);
                    }
                }
            }
            busRoute.b(arrayList);
            busRoute.a = arrayList2;
            int i5 = bundle.getInt("stopSize");
            if (bundle.containsKey("aryStep")) {
                ArrayList arrayList5 = new ArrayList();
                Parcelable[] parcelableArray = bundle.getParcelableArray("aryStep");
                if (parcelableArray.length != i5) {
                    return false;
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    Bundle bundle2 = (Bundle) parcelableArray[i6];
                    MKStep mKStep = new MKStep();
                    mKStep.a(new GeoPoint(bundle2.getInt("y"), bundle2.getInt("x")));
                    mKStep.a(bundle2.getString("name"));
                    arrayList5.add(mKStep);
                }
                busRoute.a(arrayList5);
                busRoute.a(((MKStep) arrayList5.get(0)).getPoint());
                busRoute.b(((MKStep) arrayList5.get(i5 - 1)).getPoint());
                return true;
            }
            return false;
        }
        return false;
    }

    private void b(Bundle bundle, ArrayList arrayList) {
        String[] stringArray = bundle.getStringArray("aryCity");
        int[] intArray = bundle.getIntArray("aryNum");
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            MKCityListInfo mKCityListInfo = new MKCityListInfo();
            mKCityListInfo.city = stringArray[i];
            mKCityListInfo.num = intArray[i];
            arrayList.add(mKCityListInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    @Override // com.baidu.mapapi.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(MKEvent mKEvent) {
        switch (mKEvent.a) {
            case 1:
                if (mKEvent.b != 0) {
                    this.a.onGetPoiResult(null, 0, mKEvent.b);
                    return;
                }
                Bundle newBundle = Mj.getNewBundle(11010204, mKEvent.c, 0);
                if (newBundle == null) {
                    this.a.onGetPoiResult(null, 0, 100);
                    return;
                }
                MKPoiResult mKPoiResult = new MKPoiResult();
                a(newBundle, mKPoiResult, mKEvent.c);
                if (mKEvent.c != 45) {
                    this.a.onGetPoiResult(mKPoiResult, mKEvent.c, 0);
                    return;
                }
                ArrayList multiPoiResult = mKPoiResult.getMultiPoiResult();
                if (multiPoiResult != null) {
                    for (int i = 0; i < multiPoiResult.size(); i++) {
                        if (((MKPoiResult) multiPoiResult.get(i)).getAllPoi() != null) {
                            if (r4) {
                                this.a.onGetPoiResult(null, mKEvent.c, 100);
                                return;
                            } else {
                                this.a.onGetPoiResult(mKPoiResult, mKEvent.c, 0);
                                return;
                            }
                        }
                    }
                }
                r4 = false;
                if (r4) {
                }
            case 2:
                if (mKEvent.b != 0) {
                    this.a.onGetTransitRouteResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle2 = Mj.getNewBundle(11020204, mKEvent.c, 0);
                if (newBundle2 == null) {
                    this.a.onGetTransitRouteResult(null, 100);
                    return;
                }
                MKTransitRouteResult mKTransitRouteResult = new MKTransitRouteResult();
                a(newBundle2, mKTransitRouteResult, mKEvent.c);
                this.a.onGetTransitRouteResult(mKTransitRouteResult, 0);
                return;
            case 3:
                if (mKEvent.b != 0) {
                    this.a.onGetDrivingRouteResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle3 = Mj.getNewBundle(11020204, mKEvent.c, 0);
                if (newBundle3 == null) {
                    this.a.onGetDrivingRouteResult(null, 100);
                    return;
                }
                MKDrivingRouteResult mKDrivingRouteResult = new MKDrivingRouteResult();
                a(newBundle3, mKDrivingRouteResult, mKEvent.c);
                this.a.onGetDrivingRouteResult(mKDrivingRouteResult, 0);
                return;
            case 4:
                if (mKEvent.b != 0) {
                    this.a.onGetWalkingRouteResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle4 = Mj.getNewBundle(11020204, mKEvent.c, 0);
                if (newBundle4 == null) {
                    this.a.onGetWalkingRouteResult(null, 100);
                    return;
                }
                MKWalkingRouteResult mKWalkingRouteResult = new MKWalkingRouteResult();
                a(newBundle4, mKWalkingRouteResult, mKEvent.c);
                this.a.onGetWalkingRouteResult(mKWalkingRouteResult, 0);
                return;
            case 5:
            case 7:
            case 8:
            case 9:
            case 12:
            case BdWebErrorView.HTTP_NOT_MODIFIED /* 13 */:
            case 14:
            default:
                return;
            case 6:
                if (mKEvent.b != 0) {
                    this.a.onGetAddrResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle5 = Mj.getNewBundle(11010204, mKEvent.c, 0);
                if (newBundle5 == null) {
                    this.a.onGetAddrResult(null, 100);
                    return;
                }
                MKAddrInfo mKAddrInfo = new MKAddrInfo();
                mKAddrInfo.type = 1;
                a(newBundle5, mKAddrInfo, mKEvent.c);
                if (mKAddrInfo.strAddr == null || mKAddrInfo.strAddr.length() == 0) {
                    this.a.onGetAddrResult(null, 100);
                    return;
                } else {
                    this.a.onGetAddrResult(mKAddrInfo, 0);
                    return;
                }
            case 10:
                if (mKEvent.b != 0) {
                    this.a.onGetAddrResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle6 = Mj.getNewBundle(11010204, mKEvent.c, 0);
                if (newBundle6 == null) {
                    this.a.onGetAddrResult(null, 100);
                    return;
                }
                MKAddrInfo mKAddrInfo2 = new MKAddrInfo();
                mKAddrInfo2.type = 0;
                a(newBundle6, mKAddrInfo2);
                this.a.onGetAddrResult(mKAddrInfo2, 0);
                return;
            case 11:
                Bundle newBundle7 = Mj.getNewBundle(11020204, mKEvent.c, 0);
                MKRouteAddrResult mKRouteAddrResult = new MKRouteAddrResult();
                switch (a(newBundle7, mKRouteAddrResult)) {
                    case 0:
                        MKDrivingRouteResult mKDrivingRouteResult2 = new MKDrivingRouteResult();
                        mKDrivingRouteResult2.a(mKRouteAddrResult);
                        this.a.onGetDrivingRouteResult(mKDrivingRouteResult2, 4);
                        return;
                    case 1:
                        if (mKRouteAddrResult.mStartPoiList == null || mKRouteAddrResult.mEndPoiList == null) {
                            this.a.onGetTransitRouteResult(null, 100);
                            return;
                        }
                        MKTransitRouteResult mKTransitRouteResult2 = new MKTransitRouteResult();
                        mKTransitRouteResult2.a(mKRouteAddrResult);
                        this.a.onGetTransitRouteResult(mKTransitRouteResult2, 4);
                        return;
                    case 2:
                        MKWalkingRouteResult mKWalkingRouteResult2 = new MKWalkingRouteResult();
                        mKWalkingRouteResult2.a(mKRouteAddrResult);
                        this.a.onGetWalkingRouteResult(mKWalkingRouteResult2, 4);
                        return;
                    default:
                        return;
                }
            case 15:
                if (mKEvent.b != 0) {
                    this.a.onGetBusDetailResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle8 = Mj.getNewBundle(11020204, mKEvent.c, 0);
                if (newBundle8 == null) {
                    this.a.onGetBusDetailResult(null, 100);
                    return;
                }
                MKBusLineResult mKBusLineResult = new MKBusLineResult();
                this.a.onGetBusDetailResult(mKBusLineResult, a(newBundle8, mKBusLineResult) ? 0 : 100);
                return;
            case 16:
                if (mKEvent.b != 0) {
                    this.a.onGetSuggestionResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle9 = Mj.getNewBundle(11010107, mKEvent.c, 0);
                if (newBundle9 == null) {
                    this.a.onGetSuggestionResult(null, 100);
                    return;
                }
                MKSuggestionResult mKSuggestionResult = new MKSuggestionResult();
                a(newBundle9, mKSuggestionResult, mKEvent.c);
                if (mKEvent.c != 506) {
                    this.a.onGetSuggestionResult(mKSuggestionResult, 0);
                    return;
                }
                if (mKSuggestionResult.getSuggestionNum() > 0) {
                    this.a.onGetSuggestionResult(mKSuggestionResult, 0);
                    return;
                } else {
                    this.a.onGetSuggestionResult(null, 100);
                    return;
                }
            case 17:
                if (mKEvent.b != 0) {
                    this.a.onGetRGCShareUrlResult(null, mKEvent.b);
                    return;
                }
                Bundle newBundle10 = Mj.getNewBundle(11010110, mKEvent.c, 0);
                if (newBundle10 == null) {
                    this.a.onGetRGCShareUrlResult(null, 100);
                    return;
                }
                String string = newBundle10.getString("shortUrl");
                if (mKEvent.c != 500) {
                    this.a.onGetRGCShareUrlResult(string, 0);
                    return;
                }
                if ((string == null || string == "") ? false : true) {
                    this.a.onGetRGCShareUrlResult(string, 0);
                    return;
                } else {
                    this.a.onGetRGCShareUrlResult(null, 100);
                    return;
                }
            case 18:
                if (mKEvent.b != 0) {
                    this.a.onGetPoiDetailSearchResult(mKEvent.c, mKEvent.b);
                    return;
                }
                Bundle newBundle11 = Mj.getNewBundle(11010113, mKEvent.c, 0);
                if (newBundle11 == null) {
                    this.a.onGetPoiDetailSearchResult(mKEvent.c, mKEvent.b);
                    return;
                }
                Intent intent = new Intent(BMapManager.b, PlaceCaterActivity.class);
                intent.putExtras(newBundle11);
                intent.addFlags(268435456);
                BMapManager.b.startActivity(intent);
                this.a.onGetPoiDetailSearchResult(mKEvent.c, mKEvent.b);
                return;
        }
    }
}
