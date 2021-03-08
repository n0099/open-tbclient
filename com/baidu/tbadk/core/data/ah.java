package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ah extends cb {
    public static final BdUniqueId ePo = BdUniqueId.gen();
    public String eOb;
    public int ePp;
    public List<String> ePq;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ePp = recommendBook.type.intValue();
            this.eOb = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.ePq = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ePo;
    }
}
