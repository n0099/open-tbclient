package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ag extends by {
    public static final BdUniqueId eGw = BdUniqueId.gen();
    public String eFj;
    public int eGx;
    public List<String> eGy;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eGx = recommendBook.type.intValue();
            this.eFj = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.eGy = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eGw;
    }
}
