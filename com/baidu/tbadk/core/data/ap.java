package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ap extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId Se = BdUniqueId.gen();
    public int PY;
    public String Qk;
    public String Ql;
    public String Sf;
    public String Sg;
    public String Sh;
    public List<String> Si;
    public String Sj;
    public String Sk;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Sf = recommendBook.recommend_text;
            this.Sg = recommendBook.suggest_text;
            this.Sh = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.PY = recommendBook.book_type.intValue();
            this.Ql = recommendBook.book_cover;
            this.Qk = recommendBook.book_title;
            this.Si = recommendBook.book_tips;
            this.Sj = recommendBook.botton_text;
            this.Sk = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Se;
    }
}
