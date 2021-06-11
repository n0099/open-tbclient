package com.baidu.location.c;

import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
/* loaded from: classes2.dex */
public final class d {
    public static String a(int i2) {
        if (i.i()) {
            return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return com.baidu.apollon.statistics.g.f3985b;
            case 13:
                return "4G";
            default:
                return "unknown";
        }
    }
}
