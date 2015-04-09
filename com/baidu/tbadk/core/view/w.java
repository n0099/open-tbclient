package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class w {
    String YH;
    String YI;
    String mTitle;

    private w() {
    }

    public static w cq(int i) {
        return cZ(TbadkCoreApplication.m411getInst().getResources().getString(i));
    }

    public static w r(int i, int i2) {
        return ac(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
    }

    public static w cZ(String str) {
        w wVar = new w();
        wVar.YH = str;
        return wVar;
    }

    public static w ac(String str, String str2) {
        w wVar = new w();
        wVar.mTitle = str2;
        wVar.YH = str;
        return wVar;
    }

    public static w k(String str, String str2, String str3) {
        w wVar = new w();
        wVar.mTitle = str2;
        wVar.YH = str;
        wVar.YI = str3;
        return wVar;
    }
}
