package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.NtSpreadInfo;
/* loaded from: classes.dex */
public class y extends bh {
    public static final BdUniqueId Qt = BdUniqueId.gen();
    public String Qu;
    public String Qv;
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
            this.Qu = ntSpreadInfo.user_avatar;
            this.tips = ntSpreadInfo.tips;
            this.type = ntSpreadInfo.type;
            this.title = ntSpreadInfo.title;
            this.pics = ntSpreadInfo.pics;
            this.linkUrl = ntSpreadInfo.link_url;
            this.position = ntSpreadInfo.position;
            this.Qv = ntSpreadInfo.publish_date;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Qt;
    }
}
