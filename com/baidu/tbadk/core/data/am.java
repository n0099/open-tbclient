package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId Pm = BdUniqueId.gen();
    public int NC;
    public String Pn;
    public String Po;
    public String Pp;
    public String Pq;
    public String Pr;
    public List<String> Ps;
    public String Pt;
    public String Pu;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Pn = recommendBook.recommend_text;
            this.Po = recommendBook.suggest_text;
            this.Pp = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.NC = recommendBook.book_type.intValue();
            this.Pq = recommendBook.book_cover;
            this.Pr = recommendBook.book_title;
            this.Ps = recommendBook.book_tips;
            this.Pt = recommendBook.botton_text;
            this.Pu = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pm;
    }
}
