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
    private Bundle a = null;

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
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16010400);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray("name");
        int[] intArray = this.a.getIntArray("id");
        int[] intArray2 = this.a.getIntArray("size");
        int[] intArray3 = this.a.getIntArray("ratio");
        int[] intArray4 = this.a.getIntArray("cityptx");
        int[] intArray5 = this.a.getIntArray("citypty");
        int[] intArray6 = this.a.getIntArray("serversize");
        int[] intArray7 = this.a.getIntArray("download");
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
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16011000);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray("name");
        int[] intArray = this.a.getIntArray("id");
        int[] intArray2 = this.a.getIntArray("size");
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
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16011100);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray("name");
        int[] intArray = this.a.getIntArray("id");
        int[] intArray2 = this.a.getIntArray("size");
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
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16010500);
        this.a.putInt("opt", i);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        MKOLUpdateElement mKOLUpdateElement = new MKOLUpdateElement();
        mKOLUpdateElement.cityName = this.a.getString("name");
        mKOLUpdateElement.cityID = this.a.getInt("id");
        mKOLUpdateElement.size = this.a.getInt("size");
        mKOLUpdateElement.ratio = this.a.getInt("ratio");
        if (mKOLUpdateElement.ratio == 10000) {
            mKOLUpdateElement.ratio = 100;
        }
        mKOLUpdateElement.geoPt = new GeoPoint(this.a.getInt("citypty"), this.a.getInt("cityptx"));
        mKOLUpdateElement.serversize = this.a.getInt("serversize");
        mKOLUpdateElement.status = this.a.getInt("state");
        return mKOLUpdateElement;
    }

    public boolean init(BMapManager bMapManager, MKOfflineMapListener mKOfflineMapListener) {
        if (bMapManager != null && a()) {
            if (mKOfflineMapListener != null) {
                bMapManager.a.a(mKOfflineMapListener);
            }
            return Mj.initOfflineCC() == 1;
        }
        return false;
    }

    public boolean pause(int i) {
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16010200);
        this.a.putInt("opt", i);
        return Mj.sendBundle(this.a) != 0;
    }

    public boolean remove(int i) {
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16010300);
        this.a.putInt("opt", i);
        return Mj.sendBundle(this.a) != 0;
    }

    public int scan() {
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16011500);
        if (Mj.sendBundle(this.a) == 0) {
            return 0;
        }
        return this.a.getInt("num");
    }

    public ArrayList searchCity(String str) {
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16011100);
        this.a.putString("key", str);
        if (Mj.sendBundle(this.a) == 0) {
            return null;
        }
        String[] stringArray = this.a.getStringArray("name");
        int[] intArray = this.a.getIntArray("id");
        int[] intArray2 = this.a.getIntArray("size");
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
        if (this.a == null) {
            this.a = new Bundle();
        } else {
            this.a.clear();
        }
        this.a.putInt("act", 16010500);
        this.a.putInt("opt", i);
        if (Mj.sendBundle(this.a) != 0) {
            switch (this.a.getInt("state")) {
                case 1:
                case 2:
                    this.a.clear();
                    this.a.putInt("act", 16011400);
                    Mj.sendBundle(this.a);
                    return true;
                case 3:
                    sendBundle = 2;
                    break;
                default:
                    sendBundle = 0;
                    break;
            }
        } else {
            this.a.clear();
            this.a.putInt("act", 16011300);
            this.a.putInt("opt", i);
            sendBundle = Mj.sendBundle(this.a);
        }
        if (sendBundle != 0) {
            this.a.clear();
            if (sendBundle == 1) {
                this.a.putInt("opt", 11010108);
                this.a.putInt("act", 11010203);
                this.a.putInt("cityid", i);
            } else {
                this.a.putInt("act", 16010100);
                this.a.putInt("opt", i);
            }
            return Mj.sendBundle(this.a) != 0;
        }
        return false;
    }
}
