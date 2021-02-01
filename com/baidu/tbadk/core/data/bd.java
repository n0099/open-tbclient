package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class bd extends PostData {
    public static final BdUniqueId eOI = BdUniqueId.gen();
    public int eMC;
    public String eNa;
    public String eNb;
    public String eNc;
    public String eOJ;
    public String eOK;
    public String eOL;
    public List<String> eOM;
    public String eON;
    public String eOO;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eOJ = recommendBook.recommend_text;
            this.eOK = recommendBook.suggest_text;
            this.eOL = recommendBook.suggest_url;
            this.eNa = recommendBook.book_id;
            this.eMC = recommendBook.book_type.intValue();
            this.eNc = recommendBook.book_cover;
            this.eNb = recommendBook.book_title;
            this.eOM = recommendBook.book_tips;
            this.eON = recommendBook.botton_text;
            this.eOO = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.eNa)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eOI;
    }
}
