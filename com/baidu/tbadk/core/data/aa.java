package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bj {
    public static final BdUniqueId doy = BdUniqueId.gen();
    public String dnw;
    public List<String> doA;
    public int doz;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.doz = recommendBook.type.intValue();
            this.dnw = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.doA = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return doy;
    }
}
