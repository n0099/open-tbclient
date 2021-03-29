package com.baidu.platform.comapi.walknavi.fsm;

import android.util.Log;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class FSMTable {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f10048a = new byte[0];
    public static HashMap<String, HashMap<String, String>> dictFSM;
    public static HashMap<String, String> dictStateBrowseMap;
    public static HashMap<String, String> dictStateCar3D;
    public static HashMap<String, String> dictStateEntry;
    public static HashMap<String, String> dictStateNorth2D;
    public static HashMap<String, String> dictStateOverview;
    public static HashMap<String, String> dictStateSeg;
    public static HashMap<String, String> dictStateSegEntry;

    public static void initDictFSM() {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        dictFSM = hashMap;
        hashMap.clear();
        dictFSM.put("Entry", dictStateEntry);
        dictFSM.put("SegEntry", dictStateSegEntry);
        dictFSM.put("North2D", dictStateNorth2D);
        dictFSM.put("Car3D", dictStateCar3D);
        dictFSM.put("BrowseMap", dictStateBrowseMap);
        dictFSM.put("Overview", dictStateOverview);
        dictFSM.put("Seg", dictStateSeg);
    }

    public static void initTransBrowseMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateBrowseMap = hashMap;
        hashMap.clear();
        dictStateBrowseMap.put("强诱导转到分段", "Seg");
        dictStateBrowseMap.put("[3D车头向上]按钮点击", "Car3D");
        dictStateBrowseMap.put("[查看全览]按钮点击", "Overview");
        dictStateBrowseMap.put("[回车位]按钮点击", "Car3D");
        dictStateBrowseMap.put("指南针点击", "BACK");
        dictStateBrowseMap.put("拖动地图", "BrowseMap");
        dictStateBrowseMap.put("触碰地图", "BrowseMap");
        dictStateBrowseMap.put("收到偏航算路成功消息", "BACK");
        dictStateBrowseMap.put("收到自动回车位消息", "BACK");
    }

    public static void initTransCar3D() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateCar3D = hashMap;
        hashMap.clear();
        dictStateCar3D.put("强诱导转到分段", "Seg");
        dictStateCar3D.put("[查看全览]按钮点击", "Overview");
        dictStateCar3D.put("[3D车头向上]按钮点击", "North2D");
        dictStateCar3D.put("指南针点击", "North2D");
        dictStateCar3D.put("拖动地图", "BrowseMap");
        dictStateCar3D.put("触碰地图", "Car3D");
        dictStateCar3D.put("收到偏航算路成功消息", "Car3D");
        dictStateCar3D.put("[2D正北]按钮点击", "North2D");
    }

    public static void initTransEntry() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateEntry = hashMap;
        hashMap.clear();
        dictStateEntry.put("[查看全览]按钮点击", "Overview");
        dictStateEntry.put("[3D车头向上]按钮点击", "Car3D");
        dictStateEntry.put("指南针点击", "North2D");
        dictStateEntry.put("拖动地图", "BrowseMap");
        dictStateEntry.put("触碰地图", "Car3D");
        dictStateEntry.put("收到偏航算路成功消息", "Car3D");
        dictStateEntry.put("[2D正北]按钮点击", "North2D");
    }

    public static void initTransNorth2D() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateNorth2D = hashMap;
        hashMap.clear();
        dictStateNorth2D.put("强诱导转到分段", "Seg");
        dictStateNorth2D.put("[查看全览]按钮点击", "Overview");
        dictStateNorth2D.put("[2D正北]按钮点击", "Car3D");
        dictStateNorth2D.put("[3D车头向上]按钮点击", "Car3D");
        dictStateNorth2D.put("指南针点击", "Car3D");
        dictStateNorth2D.put("拖动地图", "BrowseMap");
        dictStateNorth2D.put("触碰地图", "North2D");
        dictStateNorth2D.put("收到偏航算路成功消息", "North2D");
    }

    public static void initTransOverview() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateOverview = hashMap;
        hashMap.clear();
        dictStateOverview.put("强诱导转到分段", "Seg");
        dictStateOverview.put("[查看全览]按钮点击", "Overview");
        dictStateOverview.put("[3D车头向上]按钮点击", "Car3D");
        dictStateOverview.put("[回车位]按钮点击", "Car3D");
        dictStateOverview.put("指南针点击", "North2D");
        dictStateOverview.put("拖动地图", "BrowseMap");
        dictStateOverview.put("触碰地图", "BrowseMap");
        dictStateOverview.put("收到偏航算路成功消息", "Car3D");
        dictStateOverview.put("收到自动回车位消息", "Car3D");
    }

    public static void initTransSeg() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateSeg = hashMap;
        hashMap.clear();
        dictStateSeg.put("强诱导转到分段", "Seg");
        dictStateSeg.put("[查看全览]按钮点击", "Overview");
        dictStateSeg.put("[3D车头向上]按钮点击", "Car3D");
        dictStateSeg.put("[回车位]按钮点击", "Car3D");
        dictStateSeg.put("指南针点击", "North2D");
        dictStateSeg.put("拖动地图", "BrowseMap");
        dictStateSeg.put("触碰地图", "BrowseMap");
        dictStateSeg.put("收到偏航算路成功消息", "Car3D");
        dictStateSeg.put("收到自动回车位消息", "Car3D");
    }

    public static void initTransSegEntry() {
        HashMap<String, String> hashMap = new HashMap<>();
        dictStateSegEntry = hashMap;
        hashMap.clear();
        dictStateSegEntry.put("[查看全览]按钮点击", "Overview");
        dictStateSegEntry.put("[3D车头向上]按钮点击", "Car3D");
        dictStateSegEntry.put("[回车位]按钮点击", "Car3D");
        dictStateSegEntry.put("指南针点击", "North2D");
        dictStateSegEntry.put("拖动地图", "BrowseMap");
        dictStateSegEntry.put("触碰地图", "Car3D");
        dictStateSegEntry.put("收到偏航算路成功消息", "Car3D");
    }

    public static void initTransition() {
        initTransEntry();
        initTransSegEntry();
        initTransNorth2D();
        initTransCar3D();
        initTransBrowseMap();
        initTransOverview();
        initTransSeg();
        initDictFSM();
    }

    public static String queryDestState(String str, String str2) {
        synchronized (f10048a) {
            new HashMap();
            HashMap<String, String> hashMap = dictFSM.get(str);
            if (hashMap == null) {
                Log.e(FSMTable.class.getSimpleName(), "不存在该状态对应的状态机，请完善逻辑!");
                return null;
            }
            String str3 = hashMap.get(str2);
            if (str3 == null) {
                String simpleName = FSMTable.class.getSimpleName();
                Log.e(simpleName, "处于状态 (" + str + ")时， 不存在执行event = " + str2 + " 的跳转，请考虑是否完善逻辑!");
                return null;
            }
            return str3;
        }
    }

    public static void release() {
        HashMap<String, HashMap<String, String>> hashMap = dictFSM;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, String> hashMap2 = dictStateEntry;
        if (hashMap2 != null) {
            hashMap2.clear();
            dictStateEntry = null;
        }
        HashMap<String, String> hashMap3 = dictStateSegEntry;
        if (hashMap3 != null) {
            hashMap3.clear();
            dictStateSegEntry = null;
        }
        HashMap<String, String> hashMap4 = dictStateNorth2D;
        if (hashMap4 != null) {
            hashMap4.clear();
            dictStateNorth2D = null;
        }
        HashMap<String, String> hashMap5 = dictStateCar3D;
        if (hashMap5 != null) {
            hashMap5.clear();
            dictStateCar3D = null;
        }
        HashMap<String, String> hashMap6 = dictStateBrowseMap;
        if (hashMap6 != null) {
            hashMap6.clear();
            dictStateBrowseMap = null;
        }
        HashMap<String, String> hashMap7 = dictStateOverview;
        if (hashMap7 != null) {
            hashMap7.clear();
            dictStateOverview = null;
        }
        HashMap<String, String> hashMap8 = dictStateSeg;
        if (hashMap8 != null) {
            hashMap8.clear();
            dictStateSeg = null;
        }
    }
}
