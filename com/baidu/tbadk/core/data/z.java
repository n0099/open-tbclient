package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes3.dex */
public class z extends bh {
    public static final BdUniqueId bHb = BdUniqueId.gen();
    public String bFZ;
    public int bHc;
    public List<String> bHd;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bHc = recommendBook.type.intValue();
            this.bFZ = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.bHd = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bHb;
    }
}
