package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId WR = BdUniqueId.gen();
    public String UW;
    public String UX;
    public int Uy;
    public String WS;
    public String WT;
    public String WU;
    public List<String> WV;
    public String WW;
    public String WX;
    public String bookId;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.WS = recommendBook.recommend_text;
            this.WT = recommendBook.suggest_text;
            this.WU = recommendBook.suggest_url;
            this.bookId = recommendBook.book_id;
            this.Uy = recommendBook.book_type.intValue();
            this.UX = recommendBook.book_cover;
            this.UW = recommendBook.book_title;
            this.WV = recommendBook.book_tips;
            this.WW = recommendBook.botton_text;
            this.WX = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bookId)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return WR;
    }
}
