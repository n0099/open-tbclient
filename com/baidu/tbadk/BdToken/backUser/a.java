package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes eyI;
    public boolean eyJ = false;

    public void a(DataRes dataRes) {
        this.eyI = dataRes;
        if (dataRes != null) {
            this.eyJ = dataRes.is_back_user.intValue() == 1;
        }
    }
}
