package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class az extends PostData {
    public static final BdUniqueId ewh = BdUniqueId.gen();
    public String euA;
    public String euB;
    public String euC;
    public int euc;
    public String ewi;
    public String ewj;
    public String ewk;
    public List<String> ewl;
    public String ewm;
    public String ewn;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ewi = recommendBook.recommend_text;
            this.ewj = recommendBook.suggest_text;
            this.ewk = recommendBook.suggest_url;
            this.euA = recommendBook.book_id;
            this.euc = recommendBook.book_type.intValue();
            this.euC = recommendBook.book_cover;
            this.euB = recommendBook.book_title;
            this.ewl = recommendBook.book_tips;
            this.ewm = recommendBook.botton_text;
            this.ewn = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.euA)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ewh;
    }
}
