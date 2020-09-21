package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class az extends PostData {
    public static final BdUniqueId ebF = BdUniqueId.gen();
    public int dZA;
    public String dZY;
    public String dZZ;
    public String eaa;
    public String ebG;
    public String ebH;
    public String ebI;
    public List<String> ebJ;
    public String ebK;
    public String ebL;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ebG = recommendBook.recommend_text;
            this.ebH = recommendBook.suggest_text;
            this.ebI = recommendBook.suggest_url;
            this.dZY = recommendBook.book_id;
            this.dZA = recommendBook.book_type.intValue();
            this.eaa = recommendBook.book_cover;
            this.dZZ = recommendBook.book_title;
            this.ebJ = recommendBook.book_tips;
            this.ebK = recommendBook.botton_text;
            this.ebL = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dZY)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ebF;
    }
}
