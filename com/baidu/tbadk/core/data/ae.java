package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ae extends bv {
    public static final BdUniqueId dPe = BdUniqueId.gen();
    public String dOb;
    public int dPf;
    public List<String> dPg;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dPf = recommendBook.type.intValue();
            this.dOb = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.dPg = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dPe;
    }
}
