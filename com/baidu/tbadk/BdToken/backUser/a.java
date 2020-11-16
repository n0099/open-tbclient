package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes erF;
    public boolean erG = false;

    public void a(DataRes dataRes) {
        this.erF = dataRes;
        if (dataRes != null) {
            this.erG = dataRes.is_back_user.intValue() == 1;
        }
    }
}
