package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes eGT;
    public boolean eGU = false;

    public void a(DataRes dataRes) {
        this.eGT = dataRes;
        if (dataRes != null) {
            this.eGU = dataRes.is_back_user.intValue() == 1;
        }
    }
}
