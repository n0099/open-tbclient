package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class u extends be {
    public static final BdUniqueId Od = BdUniqueId.gen();
    public String NA;
    public int Oe;
    public List<String> Of;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Oe = recommendBook.type.intValue();
            this.NA = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Of = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Od;
    }
}
