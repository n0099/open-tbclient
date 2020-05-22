package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class z extends bk {
    public static final BdUniqueId dCy = BdUniqueId.gen();
    public String dBx;
    public List<String> dCA;
    public int dCz;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dCz = recommendBook.type.intValue();
            this.dBx = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.dCA = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return dCy;
    }
}
