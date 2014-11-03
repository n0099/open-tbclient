package com.baidu.tbadk.core.view;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class s {
    String Ik;
    String Il;
    String mTitle;

    private s() {
    }

    public static s bL(int i) {
        return cc(TbadkApplication.m251getInst().getResources().getString(i));
    }

    public static s q(int i, int i2) {
        return O(TbadkApplication.m251getInst().getResources().getString(i), TbadkApplication.m251getInst().getResources().getString(i2));
    }

    public static s cc(String str) {
        s sVar = new s();
        sVar.Ik = str;
        return sVar;
    }

    public static s O(String str, String str2) {
        s sVar = new s();
        sVar.mTitle = str2;
        sVar.Ik = str;
        return sVar;
    }

    public static s j(String str, String str2, String str3) {
        s sVar = new s();
        sVar.mTitle = str2;
        sVar.Ik = str;
        sVar.Il = str3;
        return sVar;
    }
}
