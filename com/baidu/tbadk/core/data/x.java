package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes2.dex */
public class x extends bb {
    public static final BdUniqueId afG = BdUniqueId.gen();
    public String aeD;
    public int afH;
    public List<String> afI;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.afH = recommendBook.type.intValue();
            this.aeD = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.afI = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return afG;
    }
}
