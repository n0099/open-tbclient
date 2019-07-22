package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes3.dex */
public class z extends bg {
    public static final BdUniqueId bHa = BdUniqueId.gen();
    public String bFY;
    public int bHb;
    public List<String> bHc;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bHb = recommendBook.type.intValue();
            this.bFY = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.bHc = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bHa;
    }
}
