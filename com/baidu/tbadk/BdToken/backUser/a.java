package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes eDl;
    public boolean eDm = false;

    public void a(DataRes dataRes) {
        this.eDl = dataRes;
        if (dataRes != null) {
            this.eDm = dataRes.is_back_user.intValue() == 1;
        }
    }
}
