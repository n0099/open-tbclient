package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    String Nw;
    String Nx;
    String mTitle;

    private ab() {
    }

    public static ab cp(int i) {
        return cQ(TbadkCoreApplication.m255getInst().getResources().getString(i));
    }

    public static ab t(int i, int i2) {
        return ac(TbadkCoreApplication.m255getInst().getResources().getString(i), TbadkCoreApplication.m255getInst().getResources().getString(i2));
    }

    public static ab cQ(String str) {
        ab abVar = new ab();
        abVar.Nw = str;
        return abVar;
    }

    public static ab ac(String str, String str2) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.Nw = str;
        return abVar;
    }

    public static ab m(String str, String str2, String str3) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.Nw = str;
        abVar.Nx = str3;
        return abVar;
    }
}
