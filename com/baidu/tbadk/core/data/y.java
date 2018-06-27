package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class y extends bc {
    public static final BdUniqueId agn = BdUniqueId.gen();
    public String afj;
    public int ago;
    public List<String> agp;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ago = recommendBook.type.intValue();
            this.afj = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.agp = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bc, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return agn;
    }
}
