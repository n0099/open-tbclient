package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bk {
    public static final BdUniqueId Vv = BdUniqueId.gen();
    public String Uk;
    public int Vw;
    public List<String> Vx;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Vw = recommendBook.type.intValue();
            this.Uk = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.Vx = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Vv;
    }
}
