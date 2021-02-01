package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes eFs;
    public boolean eFt = false;

    public void a(DataRes dataRes) {
        this.eFs = dataRes;
        if (dataRes != null) {
            this.eFt = dataRes.is_back_user.intValue() == 1;
        }
    }
}
