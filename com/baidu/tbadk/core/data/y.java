package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class y extends bd {
    public static final BdUniqueId XV = BdUniqueId.gen();
    public String WS;
    public int XW;
    public List<String> XX;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.XW = recommendBook.type.intValue();
            this.WS = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.XX = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return XV;
    }
}
