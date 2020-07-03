package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ad extends bu {
    public static final BdUniqueId dIT = BdUniqueId.gen();
    public String dHQ;
    public int dIU;
    public List<String> dIV;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dIU = recommendBook.type.intValue();
            this.dHQ = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.dIV = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dIT;
    }
}
