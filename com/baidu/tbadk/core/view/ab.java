package com.baidu.tbadk.core.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ab {
    String ZH;
    String ZI;
    int ZJ = -1;
    String mTitle;

    private ab() {
    }

    public static ab r(int i, int i2) {
        ab abVar = new ab();
        abVar.ZH = TbadkCoreApplication.m411getInst().getResources().getString(i);
        abVar.ZJ = i2;
        return abVar;
    }

    public static ab cv(int i) {
        return dq(TbadkCoreApplication.m411getInst().getResources().getString(i));
    }

    public static ab s(int i, int i2) {
        return ah(TbadkCoreApplication.m411getInst().getResources().getString(i), TbadkCoreApplication.m411getInst().getResources().getString(i2));
    }

    public static ab dq(String str) {
        ab abVar = new ab();
        abVar.ZH = str;
        return abVar;
    }

    public static ab ah(String str, String str2) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.ZH = str;
        return abVar;
    }

    public static ab k(String str, String str2, String str3) {
        ab abVar = new ab();
        abVar.mTitle = str2;
        abVar.ZH = str;
        abVar.ZI = str3;
        return abVar;
    }
}
