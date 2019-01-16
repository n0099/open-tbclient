package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes6.dex */
public class x extends bb {
    public static final BdUniqueId arS = BdUniqueId.gen();
    public String aqQ;
    public int arT;
    public List<String> arU;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.arT = recommendBook.type.intValue();
            this.aqQ = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.arU = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return arS;
    }
}
