package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class x extends be {
    public static final BdUniqueId aLp = BdUniqueId.gen();
    public String aKm;
    public int aLq;
    public List<String> aLr;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aLq = recommendBook.type.intValue();
            this.aKm = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.aLr = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aLp;
    }
}
