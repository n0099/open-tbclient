package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ag extends bz {
    public static final BdUniqueId eLB = BdUniqueId.gen();
    public String eKo;
    public int eLC;
    public List<String> eLD;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eLC = recommendBook.type.intValue();
            this.eKo = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.eLD = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eLB;
    }
}
