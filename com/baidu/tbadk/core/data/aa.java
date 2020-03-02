package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes8.dex */
public class aa extends bj {
    public static final BdUniqueId cPa = BdUniqueId.gen();
    public String cNZ;
    public int cPb;
    public List<String> cPc;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cPb = recommendBook.type.intValue();
            this.cNZ = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.cPc = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPa;
    }
}
