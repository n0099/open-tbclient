package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import d.a.c.e.p.j;
/* loaded from: classes3.dex */
public class NetWorkCoreFacotry {
    public static int INTERVAL_TIME = 300000;
    public static int MAX_ERROR_COUNT = 10;
    public static final int NetWorkCore_Type_BdHttp = 1;
    public static final int NetWorkCore_Type_Old = 0;
    public static int currentType;
    public static volatile int errorTime;
    public static NetWorkCoreFacotry instance;
    public static long lastTime;

    public NetWorkCoreFacotry() {
        currentType = TbadkCoreApplication.getInst().getNetWorkCoreType();
    }

    public static synchronized void addError() {
        synchronized (NetWorkCoreFacotry.class) {
            if (currentType == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - lastTime < INTERVAL_TIME) {
                    errorTime++;
                    if (errorTime > MAX_ERROR_COUNT) {
                        currentType = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkCoreApplication.getInst().setNetWorkCoreType(currentType);
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "network_core", "current Net：" + j.J() + ", TelType:" + j.f() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    errorTime = 0;
                    lastTime = currentTimeMillis;
                }
            }
        }
    }

    public static synchronized NetWorkCoreFacotry getInstance() {
        NetWorkCoreFacotry netWorkCoreFacotry;
        synchronized (NetWorkCoreFacotry.class) {
            if (instance == null) {
                instance = new NetWorkCoreFacotry();
            }
            netWorkCoreFacotry = instance;
        }
        return netWorkCoreFacotry;
    }

    public static String getNetType() {
        try {
            if (j.z()) {
                if (j.H()) {
                    return "wifi";
                }
                String c2 = j.c();
                if (c2 != null) {
                    if (c2.length() > 0) {
                        return "wap";
                    }
                }
                return "net";
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setNetType(int i2) {
        currentType = i2;
    }

    public INetWorkCore createINetWorkCore(HttpNetContext httpNetContext) {
        return new NetWorkCoreByBdHttp(httpNetContext);
    }
}
