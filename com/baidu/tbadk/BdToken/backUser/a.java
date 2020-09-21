package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes dSS;
    public boolean dST = false;

    public void a(DataRes dataRes) {
        this.dSS = dataRes;
        if (dataRes != null) {
            this.dST = dataRes.is_back_user.intValue() == 1;
        }
    }
}
