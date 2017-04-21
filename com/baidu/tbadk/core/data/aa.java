package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bi {
    public static final BdUniqueId Wc = BdUniqueId.gen();
    public String UT;
    public int Wd;
    public List<String> We;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Wd = recommendBook.type.intValue();
            this.UT = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.We = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Wc;
    }
}
