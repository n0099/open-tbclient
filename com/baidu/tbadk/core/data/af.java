package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class af extends bw {
    public static final BdUniqueId evn = BdUniqueId.gen();
    public String eua;
    public int evo;
    public List<String> evp;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.evo = recommendBook.type.intValue();
            this.eua = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.evp = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return evn;
    }
}
