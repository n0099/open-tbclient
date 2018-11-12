package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes6.dex */
public class x extends bb {
    public static final BdUniqueId anP = BdUniqueId.gen();
    public String amN;
    public int anQ;
    public List<String> anR;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.anQ = recommendBook.type.intValue();
            this.amN = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.anR = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return anP;
    }
}
