package com.baidu.tbadk.BdToken.backUser;

import tbclient.BackUser.DataRes;
/* loaded from: classes.dex */
public class a {
    private DataRes eeT;
    public boolean eeU = false;

    public void a(DataRes dataRes) {
        this.eeT = dataRes;
        if (dataRes != null) {
            this.eeU = dataRes.is_back_user.intValue() == 1;
        }
    }
}
