package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId Wz = BdUniqueId.gen();
    public String UJ;
    public String UK;
    public int Um;
    public String WA;
    public String WB;
    public String WC;
    public List<String> WD;
    public String WE;
    public String WF;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WA = recommendBook.recommend_text;
            this.WB = recommendBook.suggest_text;
            this.WC = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Um = recommendBook.book_type.intValue();
            this.UK = recommendBook.book_cover;
            this.UJ = recommendBook.book_title;
            this.WD = recommendBook.book_tips;
            this.WE = recommendBook.botton_text;
            this.WF = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Wz;
    }
}
