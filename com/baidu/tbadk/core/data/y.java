package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class y extends bd {
    public static final BdUniqueId XW = BdUniqueId.gen();
    public String WT;
    public int XX;
    public List<String> XY;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.XX = recommendBook.type.intValue();
            this.WT = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.XY = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return XW;
    }
}
