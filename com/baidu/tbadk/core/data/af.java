package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class af extends bw {
    public static final BdUniqueId eaL = BdUniqueId.gen();
    public String dZy;
    public int eaM;
    public List<String> eaN;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eaM = recommendBook.type.intValue();
            this.dZy = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.eaN = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eaL;
    }
}
