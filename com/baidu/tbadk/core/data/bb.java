package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class bb extends PostData {
    public static final BdUniqueId eMw = BdUniqueId.gen();
    public String eKO;
    public String eKP;
    public String eKQ;
    public int eKq;
    public List<String> eMA;
    public String eMB;
    public String eMC;
    public String eMx;
    public String eMy;
    public String eMz;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eMx = recommendBook.recommend_text;
            this.eMy = recommendBook.suggest_text;
            this.eMz = recommendBook.suggest_url;
            this.eKO = recommendBook.book_id;
            this.eKq = recommendBook.book_type.intValue();
            this.eKQ = recommendBook.book_cover;
            this.eKP = recommendBook.book_title;
            this.eMA = recommendBook.book_tips;
            this.eMB = recommendBook.botton_text;
            this.eMC = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.eKO)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eMw;
    }
}
