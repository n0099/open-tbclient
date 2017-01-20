package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ar extends com.baidu.tieba.tbadkCore.data.p {
    public static final BdUniqueId RD = BdUniqueId.gen();
    public String PJ;
    public String PK;
    public int Pw;
    public String RE;
    public String RF;
    public String RG;
    public List<String> RH;
    public String RI;
    public String RJ;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.RE = recommendBook.recommend_text;
            this.RF = recommendBook.suggest_text;
            this.RG = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Pw = recommendBook.book_type.intValue();
            this.PK = recommendBook.book_cover;
            this.PJ = recommendBook.book_title;
            this.RH = recommendBook.book_tips;
            this.RI = recommendBook.botton_text;
            this.RJ = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RD;
    }
}
