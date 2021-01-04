package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes eHW;
    public boolean eHX = false;

    public void a(DataRes dataRes) {
        this.eHW = dataRes;
        if (dataRes != null) {
            this.eHX = dataRes.is_back_user.intValue() == 1;
        }
    }
}
