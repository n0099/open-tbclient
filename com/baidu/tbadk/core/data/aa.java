package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class aa extends bl {
    public static final BdUniqueId WX = BdUniqueId.gen();
    public String VO;
    public int WY;
    public List<String> WZ;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WY = recommendBook.type.intValue();
            this.VO = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.WZ = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return WX;
    }
}
