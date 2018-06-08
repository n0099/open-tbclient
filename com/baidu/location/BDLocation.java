package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.location.Address;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final Parcelable.Creator<BDLocation> CREATOR = new a();
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerError = 167;
    private String buildingid;
    private String floor;
    private boolean indoorLocMode;
    private boolean isCellChangeFlag;
    private Address mAddr;
    private String mAddrStr;
    private double mAltitude;
    private String mBuildingName;
    private String mCoorType;
    private String mCu;
    private float mDerect;
    private boolean mHasAddr;
    private boolean mHasAltitude;
    private boolean mHasRadius;
    private boolean mHasSateNumber;
    private boolean mHasSpeed;
    private double mLatitude;
    private int mLocType;
    private int mLocationWhere;
    private double mLongitude;
    private int mOperators;
    private int mParkState;
    private List<Poi> mPoiList;
    private float mRadius;
    private int mSatelliteNumber;
    private String mSemaAptag;
    private String mSemaPoiRegion;
    private String mSemaRegular;
    private float mSpeed;
    private String mTime;
    private String netWorkLocationType;

    public BDLocation() {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Address.Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mPoiList = null;
    }

    private BDLocation(Parcel parcel) {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Address.Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mPoiList = null;
        this.mLocType = parcel.readInt();
        this.mTime = parcel.readString();
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
        this.mAltitude = parcel.readDouble();
        this.mSpeed = parcel.readFloat();
        this.mRadius = parcel.readFloat();
        this.mSatelliteNumber = parcel.readInt();
        this.mDerect = parcel.readFloat();
        this.floor = parcel.readString();
        this.mParkState = parcel.readInt();
        this.buildingid = parcel.readString();
        this.mBuildingName = parcel.readString();
        this.netWorkLocationType = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        this.mAddr = new Address.Builder().country(readString7).countryCode(parcel.readString()).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).build();
        boolean[] zArr = new boolean[7];
        this.mOperators = parcel.readInt();
        this.mCu = parcel.readString();
        this.mSemaAptag = parcel.readString();
        this.mSemaPoiRegion = parcel.readString();
        this.mSemaRegular = parcel.readString();
        this.mLocationWhere = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.mHasAltitude = zArr[0];
            this.mHasSpeed = zArr[1];
            this.mHasRadius = zArr[2];
            this.mHasSateNumber = zArr[3];
            this.mHasAddr = zArr[4];
            this.isCellChangeFlag = zArr[5];
            this.indoorLocMode = zArr[6];
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.mPoiList = null;
        } else {
            this.mPoiList = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BDLocation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        int i = 0;
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Address.Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mPoiList = null;
        this.mLocType = bDLocation.mLocType;
        this.mTime = bDLocation.mTime;
        this.mLatitude = bDLocation.mLatitude;
        this.mLongitude = bDLocation.mLongitude;
        this.mHasAltitude = bDLocation.mHasAltitude;
        this.mAltitude = bDLocation.mAltitude;
        this.mHasSpeed = bDLocation.mHasSpeed;
        this.mSpeed = bDLocation.mSpeed;
        this.mHasRadius = bDLocation.mHasRadius;
        this.mRadius = bDLocation.mRadius;
        this.mHasSateNumber = bDLocation.mHasSateNumber;
        this.mSatelliteNumber = bDLocation.mSatelliteNumber;
        this.mDerect = bDLocation.mDerect;
        this.mCoorType = bDLocation.mCoorType;
        this.mHasAddr = bDLocation.mHasAddr;
        this.mAddrStr = bDLocation.mAddrStr;
        this.isCellChangeFlag = bDLocation.isCellChangeFlag;
        this.mAddr = new Address.Builder().country(bDLocation.mAddr.country).countryCode(bDLocation.mAddr.countryCode).province(bDLocation.mAddr.province).city(bDLocation.mAddr.city).cityCode(bDLocation.mAddr.cityCode).district(bDLocation.mAddr.district).street(bDLocation.mAddr.street).streetNumber(bDLocation.mAddr.streetNumber).build();
        this.floor = bDLocation.floor;
        this.buildingid = bDLocation.buildingid;
        this.mBuildingName = bDLocation.mBuildingName;
        this.mLocationWhere = bDLocation.mLocationWhere;
        this.mParkState = bDLocation.mParkState;
        this.indoorLocMode = bDLocation.indoorLocMode;
        this.netWorkLocationType = bDLocation.netWorkLocationType;
        this.mOperators = bDLocation.mOperators;
        this.mCu = bDLocation.mCu;
        this.mSemaAptag = bDLocation.mSemaAptag;
        this.mSemaPoiRegion = bDLocation.mSemaPoiRegion;
        this.mSemaRegular = bDLocation.mSemaRegular;
        if (bDLocation.mPoiList == null) {
            this.mPoiList = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i;
            if (i2 >= bDLocation.mPoiList.size()) {
                this.mPoiList = arrayList;
                return;
            }
            Poi poi = bDLocation.mPoiList.get(i2);
            arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            i = i2 + 1;
        }
    }

    public BDLocation(String str) {
        this.mLocType = 0;
        this.mTime = null;
        this.mLatitude = Double.MIN_VALUE;
        this.mLongitude = Double.MIN_VALUE;
        this.mHasAltitude = false;
        this.mAltitude = Double.MIN_VALUE;
        this.mHasSpeed = false;
        this.mSpeed = 0.0f;
        this.mHasRadius = false;
        this.mRadius = 0.0f;
        this.mHasSateNumber = false;
        this.mSatelliteNumber = -1;
        this.mDerect = -1.0f;
        this.mCoorType = null;
        this.mHasAddr = false;
        this.mAddrStr = null;
        this.mSemaAptag = null;
        this.mSemaPoiRegion = null;
        this.mSemaRegular = null;
        this.isCellChangeFlag = false;
        this.mAddr = new Address.Builder().build();
        this.floor = null;
        this.buildingid = null;
        this.mBuildingName = null;
        this.indoorLocMode = false;
        this.mParkState = 0;
        this.mLocationWhere = 1;
        this.netWorkLocationType = null;
        this.mCu = "";
        this.mPoiList = null;
        if (str == null || str.equals("")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("result");
            int parseInt = Integer.parseInt(jSONObject2.getString("error"));
            setLocType(parseInt);
            setTime(jSONObject2.getString("time"));
            if (parseInt == 61) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                JSONObject jSONObject4 = jSONObject3.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject4.getString("y")));
                setLongitude(Double.parseDouble(jSONObject4.getString("x")));
                setRadius(Float.parseFloat(jSONObject3.getString("radius")));
                setSpeed(Float.parseFloat(jSONObject3.getString(NotifyType.SOUND)));
                setDirection(Float.parseFloat(jSONObject3.getString("d")));
                setSatelliteNumber(Integer.parseInt(jSONObject3.getString("n")));
                if (jSONObject3.has("h")) {
                    try {
                        setAltitude(jSONObject3.getDouble("h"));
                    } catch (Exception e) {
                    }
                }
                try {
                    if (jSONObject3.has("in_cn")) {
                        setLocationWhere(Integer.parseInt(jSONObject3.getString("in_cn")));
                    } else {
                        setLocationWhere(1);
                    }
                } catch (Exception e2) {
                }
                if (this.mLocationWhere == 0) {
                    setCoorType("wgs84");
                } else {
                    setCoorType("gcj02");
                }
            } else if (parseInt != 161) {
                if (parseInt != 66 && parseInt != 68) {
                    if (parseInt == 167) {
                        setLocationWhere(2);
                        return;
                    }
                    return;
                }
                JSONObject jSONObject5 = jSONObject.getJSONObject("content");
                JSONObject jSONObject6 = jSONObject5.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject6.getString("y")));
                setLongitude(Double.parseDouble(jSONObject6.getString("x")));
                setRadius(Float.parseFloat(jSONObject5.getString("radius")));
                setCellChangeFlag(Boolean.valueOf(Boolean.parseBoolean(jSONObject5.getString("isCellChanged"))));
                setCoorType("gcj02");
            } else {
                JSONObject jSONObject7 = jSONObject.getJSONObject("content");
                JSONObject jSONObject8 = jSONObject7.getJSONObject("point");
                setLatitude(Double.parseDouble(jSONObject8.getString("y")));
                setLongitude(Double.parseDouble(jSONObject8.getString("x")));
                setRadius(Float.parseFloat(jSONObject7.getString("radius")));
                if (jSONObject7.has("sema")) {
                    JSONObject jSONObject9 = jSONObject7.getJSONObject("sema");
                    if (jSONObject9.has("aptag")) {
                        String string = jSONObject9.getString("aptag");
                        if (TextUtils.isEmpty(string)) {
                            this.mSemaAptag = "";
                        } else {
                            this.mSemaAptag = string;
                        }
                    }
                    if (jSONObject9.has("aptagd")) {
                        JSONArray jSONArray = jSONObject9.getJSONObject("aptagd").getJSONArray("pois");
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject10 = jSONArray.getJSONObject(i);
                            arrayList.add(new Poi(jSONObject10.getString(Info.kBaiduPIDKey), jSONObject10.getString("pname"), jSONObject10.getDouble("pr")));
                        }
                        this.mPoiList = arrayList;
                    }
                    if (jSONObject9.has("poiregion")) {
                        String string2 = jSONObject9.getString("poiregion");
                        if (!TextUtils.isEmpty(string2)) {
                            this.mSemaPoiRegion = string2;
                        }
                    }
                    if (jSONObject9.has("regular")) {
                        String string3 = jSONObject9.getString("regular");
                        if (!TextUtils.isEmpty(string3)) {
                            this.mSemaRegular = string3;
                        }
                    }
                }
                if (jSONObject7.has("addr")) {
                    String[] split = jSONObject7.getString("addr").split(",");
                    int length = split.length;
                    String str2 = length > 0 ? split[0] : null;
                    String str3 = length > 1 ? split[1] : null;
                    String str4 = length > 2 ? split[2] : null;
                    this.mAddr = new Address.Builder().country(length > 6 ? split[6] : null).countryCode(length > 7 ? split[7] : null).province(str2).city(str3).cityCode(length > 5 ? split[5] : null).district(str4).street(length > 3 ? split[3] : null).streetNumber(length > 4 ? split[4] : null).build();
                    this.mHasAddr = true;
                } else {
                    this.mHasAddr = false;
                    setAddrStr(null);
                }
                if (jSONObject7.has("floor")) {
                    this.floor = jSONObject7.getString("floor");
                    if (TextUtils.isEmpty(this.floor)) {
                        this.floor = null;
                    }
                }
                if (jSONObject7.has("loctp")) {
                    this.netWorkLocationType = jSONObject7.getString("loctp");
                    if (TextUtils.isEmpty(this.netWorkLocationType)) {
                        this.netWorkLocationType = null;
                    }
                }
                if (jSONObject7.has("bldgid")) {
                    this.buildingid = jSONObject7.getString("bldgid");
                    if (TextUtils.isEmpty(this.buildingid)) {
                        this.buildingid = null;
                    }
                }
                if (jSONObject7.has("bldg")) {
                    this.mBuildingName = jSONObject7.getString("bldg");
                    if (TextUtils.isEmpty(this.mBuildingName)) {
                        this.mBuildingName = null;
                    }
                }
                if (jSONObject7.has("ibav")) {
                    String string4 = jSONObject7.getString("ibav");
                    if (TextUtils.isEmpty(string4)) {
                        this.mParkState = 0;
                    } else if (string4.equals("0")) {
                        this.mParkState = 0;
                    } else {
                        this.mParkState = Integer.valueOf(string4).intValue();
                    }
                }
                try {
                    if (jSONObject7.has("in_cn")) {
                        setLocationWhere(Integer.parseInt(jSONObject7.getString("in_cn")));
                    } else {
                        setLocationWhere(1);
                    }
                } catch (Exception e3) {
                }
                if (this.mLocationWhere == 0) {
                    setCoorType("wgs84");
                } else {
                    setCoorType("gcj02");
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            this.mLocType = 0;
            this.mHasAddr = false;
        }
    }

    private String getCuid() {
        return this.mCu;
    }

    private static String getModel() {
        return Build.MODEL;
    }

    private String getSemaPoiRegion() {
        return this.mSemaPoiRegion;
    }

    private String getSemaRegular() {
        return this.mSemaRegular;
    }

    private void setCellChangeFlag(Boolean bool) {
        this.isCellChangeFlag = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdUrl(String str) {
        String valueOf = String.valueOf(this.mLatitude);
        String valueOf2 = String.valueOf(this.mLongitude);
        String cuid = getCuid();
        return "http://lba.baidu.com/?a=" + Jni.Encrypt("ak=" + str + "&lat=" + valueOf + "&lng=" + valueOf2 + "&cu=" + cuid + "&mb=" + getModel());
    }

    public String getAddrStr() {
        return this.mAddr.address;
    }

    public Address getAddress() {
        return this.mAddr;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public String getBuildingID() {
        return this.buildingid;
    }

    public String getBuildingName() {
        return this.mBuildingName;
    }

    public String getCity() {
        return this.mAddr.city;
    }

    public String getCityCode() {
        return this.mAddr.cityCode;
    }

    public String getCoorType() {
        return this.mCoorType;
    }

    public String getCountry() {
        return this.mAddr.country;
    }

    public String getCountryCode() {
        return this.mAddr.countryCode;
    }

    public float getDerect() {
        return this.mDerect;
    }

    public float getDirection() {
        return this.mDerect;
    }

    public String getDistrict() {
        return this.mAddr.district;
    }

    public String getFloor() {
        return this.floor;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public int getLocType() {
        return this.mLocType;
    }

    public String getLocationDescribe() {
        return this.mSemaAptag;
    }

    public int getLocationWhere() {
        return this.mLocationWhere;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public String getNetworkLocationType() {
        return this.netWorkLocationType;
    }

    public int getOperators() {
        return this.mOperators;
    }

    public List<Poi> getPoiList() {
        return this.mPoiList;
    }

    public String getProvince() {
        return this.mAddr.province;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public int getSatelliteNumber() {
        this.mHasSateNumber = true;
        return this.mSatelliteNumber;
    }

    public String getSemaAptag() {
        return this.mSemaAptag;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public String getStreet() {
        return this.mAddr.street;
    }

    public String getStreetNumber() {
        return this.mAddr.streetNumber;
    }

    public String getTime() {
        return this.mTime;
    }

    public boolean hasAddr() {
        return this.mHasAddr;
    }

    public boolean hasAltitude() {
        return this.mHasAltitude;
    }

    public boolean hasRadius() {
        return this.mHasRadius;
    }

    public boolean hasSateNumber() {
        return this.mHasSateNumber;
    }

    public boolean hasSpeed() {
        return this.mHasSpeed;
    }

    public void internalSet(int i, String str) {
        if (str != null && i == 0) {
            this.mCu = str;
        }
    }

    public boolean isCellChangeFlag() {
        return this.isCellChangeFlag;
    }

    public boolean isIndoorLocMode() {
        return this.indoorLocMode;
    }

    public int isParkAvailable() {
        return this.mParkState;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.mAddr = address;
            this.mHasAddr = true;
        }
    }

    public void setAddrStr(String str) {
        this.mAddrStr = str;
        if (str == null) {
            this.mHasAddr = false;
        } else {
            this.mHasAddr = true;
        }
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
        this.mHasAltitude = true;
    }

    public void setBuildingID(String str) {
        this.buildingid = str;
    }

    public void setBuildingName(String str) {
        this.mBuildingName = str;
    }

    public void setCoorType(String str) {
        this.mCoorType = str;
    }

    public void setDirection(float f) {
        this.mDerect = f;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setIndoorLocMode(boolean z) {
        this.indoorLocMode = z;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLocType(int i) {
        this.mLocType = i;
    }

    public void setLocationDescribe(String str) {
        this.mSemaAptag = str;
    }

    public void setLocationWhere(int i) {
        this.mLocationWhere = i;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setNetworkLocationType(String str) {
        this.netWorkLocationType = str;
    }

    public void setOperators(int i) {
        this.mOperators = i;
    }

    public void setParkAvailable(int i) {
        this.mParkState = i;
    }

    public void setPoiList(List<Poi> list) {
        this.mPoiList = list;
    }

    public void setRadius(float f) {
        this.mRadius = f;
        this.mHasRadius = true;
    }

    public void setSatelliteNumber(int i) {
        this.mSatelliteNumber = i;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        this.mHasSpeed = true;
    }

    public void setTime(String str) {
        this.mTime = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLocType);
        parcel.writeString(this.mTime);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
        parcel.writeDouble(this.mAltitude);
        parcel.writeFloat(this.mSpeed);
        parcel.writeFloat(this.mRadius);
        parcel.writeInt(this.mSatelliteNumber);
        parcel.writeFloat(this.mDerect);
        parcel.writeString(this.floor);
        parcel.writeInt(this.mParkState);
        parcel.writeString(this.buildingid);
        parcel.writeString(this.mBuildingName);
        parcel.writeString(this.netWorkLocationType);
        parcel.writeString(this.mAddr.province);
        parcel.writeString(this.mAddr.city);
        parcel.writeString(this.mAddr.district);
        parcel.writeString(this.mAddr.street);
        parcel.writeString(this.mAddr.streetNumber);
        parcel.writeString(this.mAddr.cityCode);
        parcel.writeString(this.mAddr.address);
        parcel.writeString(this.mAddr.country);
        parcel.writeString(this.mAddr.countryCode);
        parcel.writeInt(this.mOperators);
        parcel.writeString(this.mCu);
        parcel.writeString(this.mSemaAptag);
        parcel.writeString(this.mSemaPoiRegion);
        parcel.writeString(this.mSemaRegular);
        parcel.writeInt(this.mLocationWhere);
        parcel.writeBooleanArray(new boolean[]{this.mHasAltitude, this.mHasSpeed, this.mHasRadius, this.mHasSateNumber, this.mHasAddr, this.isCellChangeFlag, this.indoorLocMode});
        parcel.writeList(this.mPoiList);
    }
}
