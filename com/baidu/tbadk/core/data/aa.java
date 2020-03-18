package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bj {
    public static final BdUniqueId cPo = BdUniqueId.gen();
    public String cOn;
    public int cPp;
    public List<String> cPq;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cPp = recommendBook.type.intValue();
            this.cOn = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.cPq = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPo;
    }
}
