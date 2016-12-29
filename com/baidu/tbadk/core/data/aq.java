package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId Su = BdUniqueId.gen();
    public String QA;
    public int Qn;
    public String Qz;
    public String SA;
    public String Sv;
    public String Sw;
    public String Sx;
    public List<String> Sy;
    public String Sz;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Sv = recommendBook.recommend_text;
            this.Sw = recommendBook.suggest_text;
            this.Sx = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Qn = recommendBook.book_type.intValue();
            this.QA = recommendBook.book_cover;
            this.Qz = recommendBook.book_title;
            this.Sy = recommendBook.book_tips;
            this.Sz = recommendBook.botton_text;
            this.SA = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Su;
    }
}
