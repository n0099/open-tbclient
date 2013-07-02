package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKAddrInfo {
    public static final int MK_GEOCODE = 0;
    public static final int MK_REVERSEGEOCODE = 1;
    public MKGeocoderAddressComponent addressComponents;
    public GeoPoint geoPt;
    public ArrayList poiList;
    public String strAddr;
    public String strBusiness;
    public int type;
}
