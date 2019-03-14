package com.baidu.platform.core.d;

import android.net.http.Headers;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapapi.search.core.TransitResultNode;
import com.baidu.mapapi.search.route.MassTransitRouteLine;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.SuggestAddrInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.sapi2.share.face.FaceLoginModel;
import com.baidu.ubc.UBC;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h extends com.baidu.platform.base.d {
    private TransitResultNode a(int i, JSONObject jSONObject) {
        LatLng latLng = null;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(ActVideoSetting.WIFI_DISPLAY);
        String optString2 = jSONObject.optString("city_name");
        int optInt = i == 1 ? jSONObject.optInt("city_code") : jSONObject.optInt("city_id");
        JSONObject optJSONObject = jSONObject.optJSONObject(Headers.LOCATION);
        if (optJSONObject != null) {
            latLng = new LatLng(optJSONObject.optDouble("lat"), optJSONObject.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.baiduToGcj(latLng);
            }
        }
        return new TransitResultNode(optInt, optString2, latLng, optString);
    }

    private MassTransitRouteLine.TransitStep a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MassTransitRouteLine.TransitStep transitStep = new MassTransitRouteLine.TransitStep();
        transitStep.setDistance((int) jSONObject.optDouble("distance"));
        transitStep.setDuration((int) jSONObject.optDouble(UBC.CONTENT_KEY_DURATION));
        transitStep.setInstructions(jSONObject.optString("instructions"));
        transitStep.setPathString(jSONObject.optString("path"));
        transitStep.setTrafficConditions(b(jSONObject.optJSONArray("traffic_condition")));
        JSONObject optJSONObject = jSONObject.optJSONObject("start_location");
        if (optJSONObject != null) {
            LatLng latLng = new LatLng(optJSONObject.optDouble("lat"), optJSONObject.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.baiduToGcj(latLng);
            }
            transitStep.setStartLocation(latLng);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("end_location");
        if (optJSONObject2 != null) {
            LatLng latLng2 = new LatLng(optJSONObject2.optDouble("lat"), optJSONObject2.optDouble("lng"));
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.baiduToGcj(latLng2);
            }
            transitStep.setEndLocation(latLng2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("vehicle_info");
        if (optJSONObject3 != null) {
            int optInt = optJSONObject3.optInt("type");
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("detail");
            switch (optInt) {
                case 1:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_TRAIN);
                    if (optJSONObject4 != null) {
                        TrainInfo trainInfo = new TrainInfo();
                        trainInfo.setName(optJSONObject4.optString("name"));
                        trainInfo.a(optJSONObject4.optDouble("price"));
                        trainInfo.a(optJSONObject4.optString("booking"));
                        trainInfo.setDepartureStation(optJSONObject4.optString("departure_station"));
                        trainInfo.setArriveStation(optJSONObject4.optString("arrive_station"));
                        trainInfo.setDepartureTime(optJSONObject4.optString("departure_time"));
                        trainInfo.setArriveTime(optJSONObject4.optString("arrive_time"));
                        transitStep.setTrainInfo(trainInfo);
                        break;
                    }
                    break;
                case 2:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_PLANE);
                    if (optJSONObject4 != null) {
                        PlaneInfo planeInfo = new PlaneInfo();
                        planeInfo.setName(optJSONObject4.optString("name"));
                        planeInfo.setPrice(optJSONObject4.optDouble("price"));
                        planeInfo.setDiscount(optJSONObject4.optDouble("discount"));
                        planeInfo.setAirlines(optJSONObject4.optString("airlines"));
                        planeInfo.setBooking(optJSONObject4.optString("booking"));
                        planeInfo.setDepartureStation(optJSONObject4.optString("departure_station"));
                        planeInfo.setArriveStation(optJSONObject4.optString("arrive_station"));
                        planeInfo.setDepartureTime(optJSONObject4.optString("departure_time"));
                        planeInfo.setArriveTime(optJSONObject4.optString("arrive_time"));
                        transitStep.setPlaneInfo(planeInfo);
                        break;
                    }
                    break;
                case 3:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_BUS);
                    if (optJSONObject4 != null) {
                        BusInfo busInfo = new BusInfo();
                        busInfo.setName(optJSONObject4.optString("name"));
                        busInfo.setType(optJSONObject4.optInt("type"));
                        busInfo.setStopNum(optJSONObject4.optInt("stop_num"));
                        busInfo.setDepartureStation(optJSONObject4.optString("on_station"));
                        busInfo.setArriveStation(optJSONObject4.optString("off_station"));
                        busInfo.setDepartureTime(optJSONObject4.optString("first_time"));
                        busInfo.setArriveTime(optJSONObject4.optString(FaceLoginModel.KEY_LAST_LOGIN_TIME));
                        transitStep.setBusInfo(busInfo);
                        break;
                    }
                    break;
                case 4:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_DRIVING);
                    break;
                case 5:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_WALK);
                    break;
                case 6:
                    transitStep.setVehileType(MassTransitRouteLine.TransitStep.StepVehicleInfoType.ESTEP_COACH);
                    if (optJSONObject4 != null) {
                        CoachInfo coachInfo = new CoachInfo();
                        coachInfo.setName(optJSONObject4.optString("name"));
                        coachInfo.setPrice(optJSONObject4.optDouble("price"));
                        coachInfo.setBooking(optJSONObject4.optString("booking"));
                        coachInfo.setProviderName(optJSONObject4.optString("provider_name"));
                        coachInfo.setProviderUrl(optJSONObject4.optString("provider_url"));
                        coachInfo.setDepartureStation(optJSONObject4.optString("departure_station"));
                        coachInfo.setArriveStation(optJSONObject4.optString("arrive_station"));
                        coachInfo.setDepartureTime(optJSONObject4.optString("departure_time"));
                        coachInfo.setArriveTime(optJSONObject4.optString("arrive_time"));
                        transitStep.setCoachInfo(coachInfo);
                        break;
                    }
                    break;
            }
        }
        return transitStep;
    }

    private List<List<MassTransitRouteLine.TransitStep>> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() < 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList2.add(a(optJSONObject));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private TaxiInfo b(String str) {
        JSONObject jSONObject;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            TaxiInfo taxiInfo = new TaxiInfo();
            taxiInfo.setDesc(jSONObject.optString("remark"));
            taxiInfo.setDistance(jSONObject.optInt("distance"));
            taxiInfo.setDuration(jSONObject.optInt(UBC.CONTENT_KEY_DURATION));
            taxiInfo.setTotalPrice((float) jSONObject.optDouble("total_price"));
            taxiInfo.setStartPrice((float) jSONObject.optDouble("start_price"));
            taxiInfo.setPerKMPrice((float) jSONObject.optDouble("km_price"));
            return taxiInfo;
        }
        return null;
    }

    private SuggestAddrInfo b(JSONObject jSONObject) {
        SuggestAddrInfo suggestAddrInfo = new SuggestAddrInfo();
        suggestAddrInfo.setSuggestStartNode(d(jSONObject.optJSONArray("origin_list")));
        suggestAddrInfo.setSuggestEndNode(d(jSONObject.optJSONArray("destination_list")));
        return suggestAddrInfo;
    }

    private List<MassTransitRouteLine.TransitStep.TrafficCondition> b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                MassTransitRouteLine.TransitStep.TrafficCondition trafficCondition = new MassTransitRouteLine.TransitStep.TrafficCondition();
                trafficCondition.setTrafficStatus(optJSONObject.optInt("status"));
                trafficCondition.setTrafficGeoCnt(optJSONObject.optInt("geo_cnt"));
                arrayList.add(trafficCondition);
            }
        }
        return arrayList;
    }

    private List<PriceInfo> c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            PriceInfo priceInfo = new PriceInfo();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                priceInfo.setTicketType(optJSONObject.optInt("ticket_type"));
                priceInfo.setTicketPrice(optJSONObject.optDouble("ticket_price"));
            }
            arrayList.add(priceInfo);
        }
        return arrayList;
    }

    private List<PoiInfo> d(JSONArray jSONArray) {
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                if (jSONObject != null) {
                    PoiInfo poiInfo = new PoiInfo();
                    poiInfo.address = jSONObject.optString("address");
                    poiInfo.uid = jSONObject.optString("uid");
                    poiInfo.name = jSONObject.optString("name");
                    JSONObject optJSONObject = jSONObject.optJSONObject(Headers.LOCATION);
                    if (optJSONObject != null) {
                        poiInfo.location = new LatLng(optJSONObject.optDouble("lat"), optJSONObject.optDouble("lng"));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            poiInfo.location = CoordTrans.baiduToGcj(poiInfo.location);
                        }
                    }
                    arrayList.add(poiInfo);
                }
                i = i2 + 1;
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        MassTransitRouteResult massTransitRouteResult = new MassTransitRouteResult();
        if (str == null || str.equals("")) {
            massTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        massTransitRouteResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            massTransitRouteResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            massTransitRouteResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            massTransitRouteResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                    }
                }
                if (!a(str, massTransitRouteResult, false) && !a(str, massTransitRouteResult)) {
                    massTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                }
            } catch (Exception e) {
                massTransitRouteResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            }
        }
        return massTransitRouteResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetRoutePlanResultListener)) {
            return;
        }
        ((OnGetRoutePlanResultListener) obj).onGetMassTransitRouteResult((MassTransitRouteResult) searchResult);
    }

    public boolean a(String str, MassTransitRouteResult massTransitRouteResult) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                switch (jSONObject.optInt("status_sdk")) {
                    case 0:
                        int optInt = jSONObject.optInt("type");
                        JSONObject optJSONObject = jSONObject.optJSONObject("result");
                        if (optJSONObject != null) {
                            if (optInt == 1) {
                                massTransitRouteResult.setOrigin(a(optInt, optJSONObject.optJSONObject("origin_info")));
                                massTransitRouteResult.setDestination(a(optInt, optJSONObject.optJSONObject("destination_info")));
                                massTransitRouteResult.setSuggestAddrInfo(b(optJSONObject));
                                massTransitRouteResult.error = SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR;
                            } else if (optInt == 2) {
                                TransitResultNode a = a(optInt, optJSONObject.optJSONObject("origin"));
                                massTransitRouteResult.setOrigin(a);
                                TransitResultNode a2 = a(optInt, optJSONObject.optJSONObject("destination"));
                                massTransitRouteResult.setDestination(a2);
                                massTransitRouteResult.setTotal(optJSONObject.optInt("total"));
                                massTransitRouteResult.setTaxiInfo(b(optJSONObject.optString("taxi")));
                                JSONArray optJSONArray = optJSONObject.optJSONArray("routes");
                                if (optJSONArray == null || optJSONArray.length() <= 0) {
                                    return false;
                                }
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                    if (optJSONObject2 != null) {
                                        MassTransitRouteLine massTransitRouteLine = new MassTransitRouteLine();
                                        massTransitRouteLine.setDistance(optJSONObject2.optInt("distance"));
                                        massTransitRouteLine.setDuration(optJSONObject2.optInt(UBC.CONTENT_KEY_DURATION));
                                        massTransitRouteLine.setArriveTime(optJSONObject2.optString("arrive_time"));
                                        massTransitRouteLine.setPrice(optJSONObject2.optDouble("price"));
                                        massTransitRouteLine.setPriceInfo(c(optJSONObject2.optJSONArray("price_detail")));
                                        if (a != null) {
                                            RouteNode routeNode = new RouteNode();
                                            routeNode.setLocation(a.getLocation());
                                            massTransitRouteLine.setStarting(routeNode);
                                        }
                                        if (a2 != null) {
                                            RouteNode routeNode2 = new RouteNode();
                                            routeNode2.setLocation(a2.getLocation());
                                            massTransitRouteLine.setTerminal(routeNode2);
                                        }
                                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                            massTransitRouteLine.setNewSteps(a(optJSONArray2));
                                            arrayList.add(massTransitRouteLine);
                                        }
                                    }
                                }
                                massTransitRouteResult.setRoutelines(arrayList);
                                massTransitRouteResult.error = SearchResult.ERRORNO.NO_ERROR;
                            }
                            return true;
                        }
                        return false;
                    case 1:
                        massTransitRouteResult.error = SearchResult.ERRORNO.MASS_TRANSIT_SERVER_ERROR;
                        return true;
                    case 2:
                        massTransitRouteResult.error = SearchResult.ERRORNO.MASS_TRANSIT_OPTION_ERROR;
                        return true;
                    case 1002:
                        massTransitRouteResult.error = SearchResult.ERRORNO.MASS_TRANSIT_NO_POI_ERROR;
                        return true;
                    default:
                        return false;
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
