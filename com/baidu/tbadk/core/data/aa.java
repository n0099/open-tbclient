package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bj {
    public static final BdUniqueId Wg = BdUniqueId.gen();
    public String UR;
    public int Wh;
    public List<String> Wi;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Wh = recommendBook.type.intValue();
            this.UR = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Wi = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Wg;
    }
}
