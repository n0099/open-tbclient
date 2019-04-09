package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes3.dex */
public class z extends bg {
    public static final BdUniqueId byN = BdUniqueId.gen();
    public String bxL;
    public int byO;
    public List<String> byP;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.byO = recommendBook.type.intValue();
            this.bxL = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.byP = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return byN;
    }
}
