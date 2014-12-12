package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    String Nd;
    String Ne;
    String mTitle;

    private ab() {
    }

    public static ab ci(int i) {
        return cU(TbadkCoreApplication.m255getInst().getResources().getString(i));
    }

    public static ab t(int i, int i2) {
        return Z(TbadkCoreApplication.m255getInst().getResources().getString(i), TbadkCoreApplication.m255getInst().getResources().getString(i2));
    }

    public static ab cU(String str) {
        ab abVar = new ab();
        abVar.Nd = str;
        return abVar;
    }

    public static ab Z(String str, String str2) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.Nd = str;
        return abVar;
    }

    public static ab m(String str, String str2, String str3) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.Nd = str;
        abVar.Ne = str3;
        return abVar;
    }
}
