package com.baidu.prologue.a.c;

import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class i {
    private static final Pattern bKp = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    public static boolean fZ(int i) {
        com.baidu.prologue.service.network.g gVar = new com.baidu.prologue.service.network.g(com.baidu.prologue.a.b.a.bKm.get().UK());
        if (gVar.isWifi()) {
            return true;
        }
        if (gVar.isMobileNet()) {
            return i == 0;
        }
        return false;
    }
}
