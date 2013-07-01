package com.baidu.mapapi;

import android.os.Bundle;
import android.util.Log;
import java.net.ServerSocket;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;

    /* renamed from: a  reason: collision with root package name */
    private Bundle f512a = null;

    private boolean a() {
        if (Mj.f != null) {
            return true;
        }
        try {
            Mj.f = new ServerSocket(51232);
            return true;
        } catch (Exception e) {
            Log.d("baidumap", e.getMessage());
            return false;
        }
    }

    public ArrayList getAllUpdateInfo() {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16010400);
        if (Mj.sendBundle(this.f512a) == 0) {
            return null;
        }
        String[] stringArray = this.f512a.getStringArray("name");
        int[] intArray = this.f512a.getIntArray("id");
        int[] intArray2 = this.f512a.getIntArray("size");
        int[] intArray3 = this.f512a.getIntArray("ratio");
        int[] intArray4 = this.f512a.getIntArray("cityptx");
        int[] intArray5 = this.f512a.getIntArray("citypty");
        int[] intArray6 = this.f512a.getIntArray("serversize");
        int[] intArray7 = this.f512a.getIntArray("download");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
            mKOLUpdateElement.cityName = stringArray[i];
            mKOLUpdateElement.cityID = intArray[i];
            mKOLUpdateElement.size = intArray2[i];
            mKOLUpdateElement.ratio = intArray3[i];
            if (mKOLUpdateElement.ratio == 10000) {
                mKOLUpdateElement.ratio = 100;
            }
            mKOLUpdateElement.geoPt = new GeoPoint(intArray5[i], intArray4[i]);
            mKOLUpdateElement.status = intArray7[i];
            mKOLUpdateElement.serversize = intArray6[i];
            arrayList.add(mKOLUpdateElement);
        }
        return arrayList;
    }

    public ArrayList getHotCityList() {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16011000);
        if (Mj.sendBundle(this.f512a) == 0) {
            return null;
        }
        String[] stringArray = this.f512a.getStringArray("name");
        int[] intArray = this.f512a.getIntArray("id");
        int[] intArray2 = this.f512a.getIntArray("size");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
            mKOLSearchRecord.cityName = stringArray[i];
            mKOLSearchRecord.cityID = intArray[i];
            mKOLSearchRecord.size = intArray2[i];
            arrayList.add(mKOLSearchRecord);
        }
        return arrayList;
    }

    public ArrayList getOfflineCityList() {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16011100);
        if (Mj.sendBundle(this.f512a) == 0) {
            return null;
        }
        String[] stringArray = this.f512a.getStringArray("name");
        int[] intArray = this.f512a.getIntArray("id");
        int[] intArray2 = this.f512a.getIntArray("size");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
            mKOLSearchRecord.cityName = stringArray[i];
            mKOLSearchRecord.cityID = intArray[i];
            mKOLSearchRecord.size = intArray2[i];
            arrayList.add(mKOLSearchRecord);
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16010500);
        this.f512a.putInt("opt", i);
        if (Mj.sendBundle(this.f512a) == 0) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityName = this.f512a.getString("name");
        mKOLUpdateElement.cityID = this.f512a.getInt("id");
        mKOLUpdateElement.size = this.f512a.getInt("size");
        mKOLUpdateElement.ratio = this.f512a.getInt("ratio");
        if (mKOLUpdateElement.ratio == 10000) {
            mKOLUpdateElement.ratio = 100;
        }
        mKOLUpdateElement.geoPt = new GeoPoint(this.f512a.getInt("citypty"), this.f512a.getInt("cityptx"));
        mKOLUpdateElement.serversize = this.f512a.getInt("serversize");
        mKOLUpdateElement.status = this.f512a.getInt("state");
        return mKOLUpdateElement;
    }

    public boolean init(BMapManager bMapManager, MKOfflineMapListener mKOfflineMapListener) {
        if (bMapManager != null && a()) {
            if (mKOfflineMapListener != null) {
                bMapManager.f501a.a(mKOfflineMapListener);
            }
            return Mj.initOfflineCC() == 1;
        }
        return false;
    }

    public boolean pause(int i) {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16010200);
        this.f512a.putInt("opt", i);
        return Mj.sendBundle(this.f512a) != 0;
    }

    public boolean remove(int i) {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16010300);
        this.f512a.putInt("opt", i);
        return Mj.sendBundle(this.f512a) != 0;
    }

    public int scan() {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16011500);
        if (Mj.sendBundle(this.f512a) == 0) {
            return 0;
        }
        return this.f512a.getInt("num");
    }

    public ArrayList searchCity(String str) {
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16011100);
        this.f512a.putString("key", str);
        if (Mj.sendBundle(this.f512a) == 0) {
            return null;
        }
        String[] stringArray = this.f512a.getStringArray("name");
        int[] intArray = this.f512a.getIntArray("id");
        int[] intArray2 = this.f512a.getIntArray("size");
        if (stringArray == null || intArray == null || intArray2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stringArray.length; i++) {
            MKOLSearchRecord mKOLSearchRecord = new MKOLSearchRecord();
            mKOLSearchRecord.cityName = stringArray[i];
            mKOLSearchRecord.cityID = intArray[i];
            mKOLSearchRecord.size = intArray2[i];
            arrayList.add(mKOLSearchRecord);
        }
        return arrayList;
    }

    public boolean start(int i) {
        int sendBundle;
        if (this.f512a == null) {
            this.f512a = new Bundle();
        } else {
            this.f512a.clear();
        }
        this.f512a.putInt("act", 16010500);
        this.f512a.putInt("opt", i);
        if (Mj.sendBundle(this.f512a) != 0) {
            switch (this.f512a.getInt("state")) {
                case 1:
                case 2:
                    this.f512a.clear();
                    this.f512a.putInt("act", 16011400);
                    Mj.sendBundle(this.f512a);
                    return true;
                case 3:
                    sendBundle = 2;
                    break;
                default:
                    sendBundle = 0;
                    break;
            }
        } else {
            this.f512a.clear();
            this.f512a.putInt("act", 16011300);
            this.f512a.putInt("opt", i);
            sendBundle = Mj.sendBundle(this.f512a);
        }
        if (sendBundle != 0) {
            this.f512a.clear();
            if (sendBundle == 1) {
                this.f512a.putInt("opt", 11010108);
                this.f512a.putInt("act", 11010203);
                this.f512a.putInt("cityid", i);
            } else {
                this.f512a.putInt("act", 16010100);
                this.f512a.putInt("opt", i);
            }
            return Mj.sendBundle(this.f512a) != 0;
        }
        return false;
    }
}
