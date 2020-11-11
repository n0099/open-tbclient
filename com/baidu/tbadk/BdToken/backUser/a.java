package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes etl;
    public boolean etm = false;

    public void a(DataRes dataRes) {
        this.etl = dataRes;
        if (dataRes != null) {
            this.etm = dataRes.is_back_user.intValue() == 1;
        }
    }
}
