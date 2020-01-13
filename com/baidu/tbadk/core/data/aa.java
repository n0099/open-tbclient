package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes6.dex */
public class aa extends bj {
    public static final BdUniqueId cKW = BdUniqueId.gen();
    public String cJV;
    public int cKX;
    public List<String> cKY;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cKX = recommendBook.type.intValue();
            this.cJV = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.cKY = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cKW;
    }
}
