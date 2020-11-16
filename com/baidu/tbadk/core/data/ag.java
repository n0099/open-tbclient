package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ag extends bx {
    public static final BdUniqueId ezx = BdUniqueId.gen();
    public String eyj;
    public int ezy;
    public List<String> ezz;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ezy = recommendBook.type.intValue();
            this.eyj = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.ezz = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ezx;
    }
}
