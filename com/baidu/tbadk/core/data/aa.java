package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bh {
    public static final BdUniqueId Wu = BdUniqueId.gen();
    public String Vf;
    public int Wv;
    public List<String> Ww;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Wv = recommendBook.type.intValue();
            this.Vf = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Ww = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Wu;
    }
}
