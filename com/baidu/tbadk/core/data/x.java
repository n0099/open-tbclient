package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class x extends bi {
    public static final BdUniqueId QV = BdUniqueId.gen();
    public String PW;
    public int QW;
    public List<String> QX;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.QW = recommendBook.type.intValue();
            this.PW = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.QX = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return QV;
    }
}
