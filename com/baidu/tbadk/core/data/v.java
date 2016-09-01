package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
import tbclient.FrsPage.RecommendBook;
/* loaded from: classes.dex */
public class v extends bg {
    public static final BdUniqueId QO = BdUniqueId.gen();
    public String PY;
    public int QP;
    public List<String> QR;
    public String image;
    public String linkUrl;
    public String title;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.QP = recommendBook.type.intValue();
            this.PY = recommendBook.book_id;
            this.title = recommendBook.title;
            this.image = recommendBook.image;
            this.QR = recommendBook.desc;
            this.linkUrl = recommendBook.link_url;
        }
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return QO;
    }
}
