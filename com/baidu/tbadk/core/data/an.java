package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class an extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId RY = BdUniqueId.gen();
    public int Qa;
    public String Qm;
    public String Qn;
    public String RZ;
    public String Sa;
    public String Sb;
    public List<String> Sc;
    public String Sd;
    public String Se;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.RZ = recommendBook.recommend_text;
            this.Sa = recommendBook.suggest_text;
            this.Sb = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Qa = recommendBook.book_type.intValue();
            this.Qn = recommendBook.book_cover;
            this.Qm = recommendBook.book_title;
            this.Sc = recommendBook.book_tips;
            this.Sd = recommendBook.botton_text;
            this.Se = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RY;
    }
}
