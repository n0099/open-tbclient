package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class ab extends bm {
    public static final BdUniqueId Vi = BdUniqueId.gen();
    public String TW;
    public int Vj;
    public List<String> Vk;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Vj = recommendBook.type.intValue();
            this.TW = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Vk = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Vi;
    }
}
