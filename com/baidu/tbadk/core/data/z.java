package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class z extends bk {
    public static final BdUniqueId Rq = BdUniqueId.gen();
    public String Qo;
    public int Rr;
    public List<String> Rs;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Rr = recommendBook.type.intValue();
            this.Qo = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Rs = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Rq;
    }
}
