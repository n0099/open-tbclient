package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes2.dex */
public class x extends bb {
    public static final BdUniqueId aih = BdUniqueId.gen();
    public String ahe;
    public int aii;
    public List<String> aij;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aii = recommendBook.type.intValue();
            this.ahe = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.aij = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aih;
    }
}
