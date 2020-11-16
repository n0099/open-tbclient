package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ba extends PostData {
    public static final BdUniqueId eAr = BdUniqueId.gen();
    public String eAs;
    public String eAt;
    public String eAu;
    public List<String> eAv;
    public String eAw;
    public String eAx;
    public String eyK;
    public String eyL;
    public String eyM;
    public int eyl;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eAs = recommendBook.recommend_text;
            this.eAt = recommendBook.suggest_text;
            this.eAu = recommendBook.suggest_url;
            this.eyK = recommendBook.book_id;
            this.eyl = recommendBook.book_type.intValue();
            this.eyM = recommendBook.book_cover;
            this.eyL = recommendBook.book_title;
            this.eAv = recommendBook.book_tips;
            this.eAw = recommendBook.botton_text;
            this.eAx = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.eyK)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAr;
    }
}
