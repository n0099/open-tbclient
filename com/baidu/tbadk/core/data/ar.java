package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ar extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId Sz = BdUniqueId.gen();
    public String QC;
    public String QD;
    public int Qq;
    public String SA;
    public String SB;
    public String SC;
    public List<String> SD;
    public String SE;
    public String SF;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.SA = recommendBook.recommend_text;
            this.SB = recommendBook.suggest_text;
            this.SC = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Qq = recommendBook.book_type.intValue();
            this.QD = recommendBook.book_cover;
            this.QC = recommendBook.book_title;
            this.SD = recommendBook.book_tips;
            this.SE = recommendBook.botton_text;
            this.SF = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Sz;
    }
}
