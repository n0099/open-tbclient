package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class au extends PostData {
    public static final BdUniqueId WK = BdUniqueId.gen();
    public String UL;
    public String UM;
    public int Uo;
    public String WL;
    public String WM;
    public String WN;
    public List<String> WO;
    public String WP;
    public String WQ;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WL = recommendBook.recommend_text;
            this.WM = recommendBook.suggest_text;
            this.WN = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Uo = recommendBook.book_type.intValue();
            this.UM = recommendBook.book_cover;
            this.UL = recommendBook.book_title;
            this.WO = recommendBook.book_tips;
            this.WP = recommendBook.botton_text;
            this.WQ = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return WK;
    }
}
