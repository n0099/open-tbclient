package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class y extends bg {
    public static final BdUniqueId Rn = BdUniqueId.gen();
    public String Ql;
    public int Ro;
    public List<String> Rp;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Ro = recommendBook.type.intValue();
            this.Ql = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Rp = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Rn;
    }
}
