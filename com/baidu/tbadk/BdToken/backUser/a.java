package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes enq;
    public boolean enr = false;

    public void a(DataRes dataRes) {
        this.enq = dataRes;
        if (dataRes != null) {
            this.enr = dataRes.is_back_user.intValue() == 1;
        }
    }
}
