package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes8.dex */
public class aa extends bj {
    public static final BdUniqueId cPb = BdUniqueId.gen();
    public String cOa;
    public int cPc;
    public List<String> cPd;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cPc = recommendBook.type.intValue();
            this.cOa = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.cPd = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPb;
    }
}
