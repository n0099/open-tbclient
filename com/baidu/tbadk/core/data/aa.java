package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bj {
    public static final BdUniqueId VJ = BdUniqueId.gen();
    public String Uw;
    public int VK;
    public List<String> VL;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.VK = recommendBook.type.intValue();
            this.Uw = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.VL = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return VJ;
    }
}
