package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class x extends bd {
    public static final BdUniqueId aMA = BdUniqueId.gen();
    public String aLx;
    public int aMB;
    public List<String> aMC;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aMB = recommendBook.type.intValue();
            this.aLx = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.aMC = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMA;
    }
}
