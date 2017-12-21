package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class w extends bd {
    public static final BdUniqueId WR = BdUniqueId.gen();
    public String VP;
    public int WS;
    public List<String> WT;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WS = recommendBook.type.intValue();
            this.VP = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.WT = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return WR;
    }
}
