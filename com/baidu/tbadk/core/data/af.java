package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes2.dex */
public class af extends bw {
    public static final BdUniqueId dYx = BdUniqueId.gen();
    public String dXk;
    public int dYy;
    public List<String> dYz;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dYy = recommendBook.type.intValue();
            this.dXk = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.dYz = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dYx;
    }
}
