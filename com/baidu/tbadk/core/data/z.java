package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class z extends bh {
    public static final BdUniqueId Qw = BdUniqueId.gen();
    public String Pu;
    public int Qx;
    public List<String> Qy;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Qx = recommendBook.type.intValue();
            this.Pu = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Qy = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Qw;
    }
}
