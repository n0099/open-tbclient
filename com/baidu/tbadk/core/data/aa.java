package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bh {
    public static final BdUniqueId Wi = BdUniqueId.gen();
    public String UT;
    public int Wj;
    public List<String> Wk;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Wj = recommendBook.type.intValue();
            this.UT = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Wk = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Wi;
    }
}
