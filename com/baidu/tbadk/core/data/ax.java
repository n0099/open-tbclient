package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ax extends PostData {
    public static final BdUniqueId dJM = BdUniqueId.gen();
    public int dHS;
    public String dIg;
    public String dIh;
    public String dIi;
    public String dJN;
    public String dJO;
    public String dJP;
    public List<String> dJQ;
    public String dJR;
    public String dJS;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dJN = recommendBook.recommend_text;
            this.dJO = recommendBook.suggest_text;
            this.dJP = recommendBook.suggest_url;
            this.dIg = recommendBook.book_id;
            this.dHS = recommendBook.book_type.intValue();
            this.dIi = recommendBook.book_cover;
            this.dIh = recommendBook.book_title;
            this.dJQ = recommendBook.book_tips;
            this.dJR = recommendBook.botton_text;
            this.dJS = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dIg)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dJM;
    }
}
