package com.baidu.location.e;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j {
    private static final String[] a = {"CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription"};

    /* loaded from: classes.dex */
    static final class a {
        final BDLocation MY;
        final LinkedHashMap<String, Integer> MZ;
        final String a;
        final String b;
        final boolean c;
        final boolean d;
        final boolean e;
        final int f;
        final boolean h;

        public a(String[] strArr) {
            boolean z;
            if (strArr == null) {
                this.a = null;
                this.b = null;
                this.MZ = null;
                this.c = false;
                this.d = false;
                this.e = false;
                this.MY = null;
                this.h = false;
                this.f = 8;
                return;
            }
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
            int i = 8;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            BDLocation bDLocation = null;
            String str = null;
            String str2 = null;
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                try {
                    if (strArr[i2].equals("-loc")) {
                        str2 = strArr[i2 + 1];
                        String[] split = str2.split("&");
                        for (int i3 = 0; i3 < split.length; i3++) {
                            if (split[i3].startsWith("cl=")) {
                                str = split[i3].substring(3);
                            } else if (split[i3].startsWith("wf=")) {
                                for (String str3 : split[i3].substring(3).split("\\|")) {
                                    String[] split2 = str3.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                                    if (split2.length >= 2) {
                                        linkedHashMap.put(split2[0], Integer.valueOf(split2[1]));
                                    }
                                }
                            }
                        }
                    } else if (strArr[i2].equals("-com")) {
                        String[] split3 = strArr[i2 + 1].split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        if (split3.length > 0) {
                            BDLocation bDLocation2 = new BDLocation();
                            try {
                                bDLocation2.setLatitude(Double.valueOf(split3[0]).doubleValue());
                                bDLocation2.setLongitude(Double.valueOf(split3[1]).doubleValue());
                                bDLocation2.setLocType(Integer.valueOf(split3[2]).intValue());
                                bDLocation2.setNetworkLocationType(split3[3]);
                                bDLocation = bDLocation2;
                            } catch (Exception e) {
                                bDLocation = bDLocation2;
                                z = false;
                                this.a = str2;
                                this.b = str;
                                this.MZ = linkedHashMap;
                                this.c = z;
                                this.d = z4;
                                this.e = z3;
                                this.f = i;
                                this.MY = bDLocation;
                                this.h = z2;
                            }
                        } else {
                            continue;
                        }
                    } else if (strArr[i2].equals("-log")) {
                        if (strArr[i2 + 1].equals("true")) {
                            z5 = true;
                        }
                    } else if (strArr[i2].equals("-rgc")) {
                        if (strArr[i2 + 1].equals("true")) {
                            z3 = true;
                        }
                    } else if (strArr[i2].equals("-poi")) {
                        if (strArr[i2 + 1].equals("true")) {
                            z4 = true;
                        }
                    } else if (strArr[i2].equals("-minap")) {
                        try {
                            i = Integer.valueOf(strArr[i2 + 1]).intValue();
                        } catch (Exception e2) {
                        }
                    } else if (strArr[i2].equals("-des") && strArr[i2 + 1].equals("true")) {
                        z2 = true;
                    }
                } catch (Exception e3) {
                }
            }
            str2 = z5 ? str2 : null;
            z = true;
            this.a = str2;
            this.b = str;
            this.MZ = linkedHashMap;
            this.c = z;
            this.d = z4;
            this.e = z3;
            this.f = i;
            this.MY = bDLocation;
            this.h = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(BDLocation bDLocation, BDLocation bDLocation2, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bDLocation2 == null) {
            stringBuffer.append("&ofcl=0");
        } else {
            stringBuffer.append(String.format(Locale.US, "&ofcl=1|%f|%f|%d", Double.valueOf(bDLocation2.getLongitude()), Double.valueOf(bDLocation2.getLatitude()), Integer.valueOf((int) bDLocation2.getRadius())));
        }
        if (bDLocation == null) {
            stringBuffer.append("&ofwf=0");
        } else {
            stringBuffer.append(String.format(Locale.US, "&ofwf=1|%f|%f|%d", Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())));
        }
        if (aVar == null || !aVar.e) {
            stringBuffer.append("&rgcn=0");
        } else {
            stringBuffer.append("&rgcn=1");
        }
        if (aVar == null || !aVar.d) {
            stringBuffer.append("&poin=0");
        } else {
            stringBuffer.append("&poin=1");
        }
        if (aVar == null || !aVar.h) {
            stringBuffer.append("&desc=0");
        } else {
            stringBuffer.append("&desc=1");
        }
        if (aVar != null) {
            stringBuffer.append(String.format(Locale.US, "&aps=%d", Integer.valueOf(aVar.f)));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] a(com.baidu.location.f.a aVar, com.baidu.location.f.i iVar, BDLocation bDLocation, String str, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(com.baidu.location.f.b.mF().g(aVar));
        }
        if (iVar != null) {
            stringBuffer.append(iVar.a(30));
        }
        if (stringBuffer.length() > 0) {
            if (str != null) {
                stringBuffer.append(str);
            }
            arrayList.add("-loc");
            arrayList.add(stringBuffer.toString());
        }
        if (bDLocation != null) {
            String format = String.format(Locale.US, "%f;%f;%d;%s", Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Integer.valueOf(bDLocation.getLocType()), bDLocation.getNetworkLocationType());
            arrayList.add("-com");
            arrayList.add(format);
        }
        if (z) {
            arrayList.add("-log");
            arrayList.add("true");
        }
        if (com.baidu.location.h.i.f.equals("all")) {
            arrayList.add("-rgc");
            arrayList.add("true");
        }
        if (com.baidu.location.h.i.h) {
            arrayList.add("-poi");
            arrayList.add("true");
        }
        if (com.baidu.location.h.i.g) {
            arrayList.add("-des");
            arrayList.add("true");
        }
        arrayList.add("-minap");
        arrayList.add(Integer.toString(i));
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(BDLocation bDLocation, int i) {
        if (bDLocation == null || bDLocation.getLocType() == 67) {
            return String.format(Locale.CHINA, "&ofl=%s|%d", "1", Integer.valueOf(i));
        }
        String format = String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", "1", Integer.valueOf(i), Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius()));
        String str = bDLocation.getAddress() != null ? format + "&ofaddr=" + bDLocation.getAddress().address : format;
        if (bDLocation.getPoiList() != null && bDLocation.getPoiList().size() > 0) {
            Poi poi = bDLocation.getPoiList().get(0);
            str = str + String.format(Locale.US, "&ofpoi=%s|%s", poi.getId(), poi.getName());
        }
        return com.baidu.location.h.c.c != null ? str + String.format(Locale.US, "&pack=%s&sdk=%.3f", com.baidu.location.h.c.c, Float.valueOf(6.23f)) : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cursor c(BDLocation bDLocation) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        MatrixCursor matrixCursor = new MatrixCursor(a);
        Object[] objArr = new Object[a.length];
        objArr[matrixCursor.getColumnIndex("CoorType")] = "gcj02";
        objArr[matrixCursor.getColumnIndex("Time")] = format;
        objArr[matrixCursor.getColumnIndex("LocType")] = Integer.valueOf(bDLocation.getLocType());
        objArr[matrixCursor.getColumnIndex("Longitude")] = Double.valueOf(bDLocation.getLongitude());
        objArr[matrixCursor.getColumnIndex("Latitude")] = Double.valueOf(bDLocation.getLatitude());
        objArr[matrixCursor.getColumnIndex("Radius")] = Float.valueOf(bDLocation.getRadius());
        objArr[matrixCursor.getColumnIndex("NetworkLocationType")] = bDLocation.getNetworkLocationType();
        Address address = bDLocation.getAddress();
        if (address != null) {
            str8 = address.country;
            str7 = address.countryCode;
            str6 = address.province;
            str5 = address.city;
            str4 = address.cityCode;
            str3 = address.district;
            str2 = address.street;
            str = address.streetNumber;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        objArr[matrixCursor.getColumnIndex("Country")] = str8;
        objArr[matrixCursor.getColumnIndex("CountryCode")] = str7;
        objArr[matrixCursor.getColumnIndex("Province")] = str6;
        objArr[matrixCursor.getColumnIndex("City")] = str5;
        objArr[matrixCursor.getColumnIndex("CityCode")] = str4;
        objArr[matrixCursor.getColumnIndex("District")] = str3;
        objArr[matrixCursor.getColumnIndex("Street")] = str2;
        objArr[matrixCursor.getColumnIndex("StreetNumber")] = str;
        List<Poi> poiList = bDLocation.getPoiList();
        if (poiList == null) {
            objArr[matrixCursor.getColumnIndex("PoiList")] = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= poiList.size()) {
                    break;
                }
                Poi poi = poiList.get(i2);
                stringBuffer.append(poi.getId()).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR).append(poi.getName()).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR).append(poi.getRank()).append(";|");
                i = i2 + 1;
            }
            objArr[matrixCursor.getColumnIndex("PoiList")] = stringBuffer.toString();
        }
        objArr[matrixCursor.getColumnIndex("LocationDescription")] = bDLocation.getLocationDescribe();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static BDLocation f(Cursor cursor) {
        BDLocation bDLocation = new BDLocation();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            bDLocation.setLocType(67);
        } else {
            int i = cursor.getColumnIndex("LocType") != -1 ? cursor.getInt(cursor.getColumnIndex("LocType")) : 0;
            double d = cursor.getColumnIndex("Latitude") != -1 ? cursor.getDouble(cursor.getColumnIndex("Latitude")) : 0.0d;
            double d2 = cursor.getColumnIndex("Longitude") != -1 ? cursor.getDouble(cursor.getColumnIndex("Longitude")) : 0.0d;
            String string = cursor.getColumnIndex("CoorType") != -1 ? cursor.getString(cursor.getColumnIndex("CoorType")) : null;
            String string2 = cursor.getColumnIndex("NetworkLocationType") != -1 ? cursor.getString(cursor.getColumnIndex("NetworkLocationType")) : null;
            float f = cursor.getColumnIndex("Radius") != -1 ? cursor.getFloat(cursor.getColumnIndex("Radius")) : 0.0f;
            String string3 = cursor.getColumnIndex("Time") != -1 ? cursor.getString(cursor.getColumnIndex("Time")) : null;
            String string4 = cursor.getColumnIndex("Country") != -1 ? cursor.getString(cursor.getColumnIndex("Country")) : null;
            String string5 = cursor.getColumnIndex("CountryCode") != -1 ? cursor.getString(cursor.getColumnIndex("CountryCode")) : null;
            String string6 = cursor.getColumnIndex("Province") != -1 ? cursor.getString(cursor.getColumnIndex("Province")) : null;
            String string7 = cursor.getColumnIndex("City") != -1 ? cursor.getString(cursor.getColumnIndex("City")) : null;
            Address build = new Address.Builder().country(string4).countryCode(string5).province(string6).city(string7).cityCode(cursor.getColumnIndex("CityCode") != -1 ? cursor.getString(cursor.getColumnIndex("CityCode")) : null).district(cursor.getColumnIndex("District") != -1 ? cursor.getString(cursor.getColumnIndex("District")) : null).street(cursor.getColumnIndex("Street") != -1 ? cursor.getString(cursor.getColumnIndex("Street")) : null).streetNumber(cursor.getColumnIndex("StreetNumber") != -1 ? cursor.getString(cursor.getColumnIndex("StreetNumber")) : null).build();
            ArrayList arrayList = null;
            if (cursor.getColumnIndex("PoiList") != -1) {
                arrayList = new ArrayList();
                String string8 = cursor.getString(cursor.getColumnIndex("PoiList"));
                if (string8 != null) {
                    try {
                        String[] split = string8.split("\\|");
                        for (String str : split) {
                            String[] split2 = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                            if (split2.length >= 3) {
                                arrayList.add(new Poi(split2[0], split2[1], Double.valueOf(split2[2]).doubleValue()));
                            }
                        }
                    } catch (Exception e) {
                        if (arrayList.size() == 0) {
                            arrayList = null;
                        }
                    } catch (Throwable th) {
                        if (arrayList.size() == 0) {
                        }
                        throw th;
                    }
                }
                if (arrayList.size() == 0) {
                    arrayList = null;
                }
            }
            String string9 = cursor.getColumnIndex("LocationDescription") != -1 ? cursor.getString(cursor.getColumnIndex("LocationDescription")) : null;
            bDLocation.setTime(string3);
            bDLocation.setRadius(f);
            bDLocation.setLocType(i);
            bDLocation.setCoorType(string);
            bDLocation.setLatitude(d);
            bDLocation.setLongitude(d2);
            bDLocation.setNetworkLocationType(string2);
            bDLocation.setAddr(build);
            bDLocation.setPoiList(arrayList);
            bDLocation.setLocationDescribe(string9);
        }
        return bDLocation;
    }
}
