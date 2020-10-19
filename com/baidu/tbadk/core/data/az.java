package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class az extends PostData {
    public static final BdUniqueId enJ = BdUniqueId.gen();
    public int elC;
    public String ema;
    public String emb;
    public String emc;
    public String enK;
    public String enL;
    public String enM;
    public List<String> enN;
    public String enO;
    public String enP;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.enK = recommendBook.recommend_text;
            this.enL = recommendBook.suggest_text;
            this.enM = recommendBook.suggest_url;
            this.ema = recommendBook.book_id;
            this.elC = recommendBook.book_type.intValue();
            this.emc = recommendBook.book_cover;
            this.emb = recommendBook.book_title;
            this.enN = recommendBook.book_tips;
            this.enO = recommendBook.botton_text;
            this.enP = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.ema)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return enJ;
    }
}
