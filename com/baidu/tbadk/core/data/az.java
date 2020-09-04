package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class az extends PostData {
    public static final BdUniqueId dZv = BdUniqueId.gen();
    public String dXO;
    public String dXP;
    public String dXQ;
    public int dXq;
    public String dZA;
    public String dZB;
    public String dZw;
    public String dZx;
    public String dZy;
    public List<String> dZz;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dZw = recommendBook.recommend_text;
            this.dZx = recommendBook.suggest_text;
            this.dZy = recommendBook.suggest_url;
            this.dXO = recommendBook.book_id;
            this.dXq = recommendBook.book_type.intValue();
            this.dXQ = recommendBook.book_cover;
            this.dXP = recommendBook.book_title;
            this.dZz = recommendBook.book_tips;
            this.dZA = recommendBook.botton_text;
            this.dZB = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dXO)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZv;
    }
}
