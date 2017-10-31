package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bh {
    public static final BdUniqueId WA = BdUniqueId.gen();
    public String Vl;
    public int WB;
    public List<String> WC;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WB = recommendBook.type.intValue();
            this.Vl = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.WC = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return WA;
    }
}
