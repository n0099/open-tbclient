package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes3.dex */
public class z extends bg {
    public static final BdUniqueId bFY = BdUniqueId.gen();
    public String bEW;
    public int bFZ;
    public List<String> bGa;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bFZ = recommendBook.type.intValue();
            this.bEW = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.bGa = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bFY;
    }
}
