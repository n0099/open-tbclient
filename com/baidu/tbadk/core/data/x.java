package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.NtSpreadInfo;
/* loaded from: classes.dex */
public class x extends bg {
    public static final BdUniqueId Rk = BdUniqueId.gen();
    public String Rl;
    public String Rm;
    public String linkUrl;
    public List<String> pics;
    public Integer position;
    public String tips;
    public String title;
    public String type;
    public String userName;

    public void a(NtSpreadInfo ntSpreadInfo) {
        if (ntSpreadInfo != null) {
            this.userName = ntSpreadInfo.user_name;
            this.Rl = ntSpreadInfo.user_avatar;
            this.tips = ntSpreadInfo.tips;
            this.type = ntSpreadInfo.type;
            this.title = ntSpreadInfo.title;
            this.pics = ntSpreadInfo.pics;
            this.linkUrl = ntSpreadInfo.link_url;
            this.position = ntSpreadInfo.position;
            this.Rm = ntSpreadInfo.publish_date;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Rk;
    }
}
