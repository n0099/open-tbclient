package com.baidu.tbadk.core.data;

import java.io.Serializable;
import tbclient.ActiveConfig.DataRes;
/* loaded from: classes2.dex */
public class NewUserRedPackageData implements Serializable {
    public String clickUrl;
    public String money;
    public String topPicUrl;

    public void parseProto(DataRes dataRes) {
        this.topPicUrl = dataRes.newuser_pop_top;
        this.money = dataRes.newuser_pop_money;
        this.clickUrl = dataRes.newuser_pop_clickurl;
    }
}
