package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class y extends bd {
    public static final BdUniqueId afX = BdUniqueId.gen();
    public String aeU;
    public int afY;
    public List<String> afZ;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.afY = recommendBook.type.intValue();
            this.aeU = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.afZ = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return afX;
    }
}
