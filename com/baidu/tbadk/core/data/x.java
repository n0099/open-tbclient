package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class x extends bd {
    public static final BdUniqueId aLn = BdUniqueId.gen();
    public String aKk;
    public int aLo;
    public List<String> aLp;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aLo = recommendBook.type.intValue();
            this.aKk = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.aLp = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aLn;
    }
}
