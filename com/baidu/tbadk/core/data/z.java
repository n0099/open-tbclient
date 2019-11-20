package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes3.dex */
public class z extends bh {
    public static final BdUniqueId bYt = BdUniqueId.gen();
    public String bXr;
    public int bYu;
    public List<String> bYv;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bYu = recommendBook.type.intValue();
            this.bXr = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.bYv = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bYt;
    }
}
