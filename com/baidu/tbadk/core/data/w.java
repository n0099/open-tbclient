package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class w extends bd {
    public static final BdUniqueId WO = BdUniqueId.gen();
    public String VM;
    public int WP;
    public List<String> WQ;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WP = recommendBook.type.intValue();
            this.VM = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.WQ = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return WO;
    }
}
