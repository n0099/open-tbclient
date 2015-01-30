package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    String NA;
    String Nz;
    String mTitle;

    private ab() {
    }

    public static ab cp(int i) {
        return cT(TbadkCoreApplication.m255getInst().getResources().getString(i));
    }

    public static ab t(int i, int i2) {
        return ac(TbadkCoreApplication.m255getInst().getResources().getString(i), TbadkCoreApplication.m255getInst().getResources().getString(i2));
    }

    public static ab cT(String str) {
        ab abVar = new ab();
        abVar.Nz = str;
        return abVar;
    }

    public static ab ac(String str, String str2) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.Nz = str;
        return abVar;
    }

    public static ab m(String str, String str2, String str3) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.Nz = str;
        abVar.NA = str3;
        return abVar;
    }
}
