package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class x extends bd {
    public static final BdUniqueId aMK = BdUniqueId.gen();
    public String aLH;
    public int aML;
    public List<String> aMM;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aML = recommendBook.type.intValue();
            this.aLH = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.aMM = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMK;
    }
}
