package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ay extends PostData {
    public static final BdUniqueId dPY = BdUniqueId.gen();
    public int dOd;
    public String dOr;
    public String dOs;
    public String dOt;
    public String dPZ;
    public String dQa;
    public String dQb;
    public List<String> dQc;
    public String dQd;
    public String dQe;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dPZ = recommendBook.recommend_text;
            this.dQa = recommendBook.suggest_text;
            this.dQb = recommendBook.suggest_url;
            this.dOr = recommendBook.book_id;
            this.dOd = recommendBook.book_type.intValue();
            this.dOt = recommendBook.book_cover;
            this.dOs = recommendBook.book_title;
            this.dQc = recommendBook.book_tips;
            this.dQd = recommendBook.botton_text;
            this.dQe = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dOr)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dPY;
    }
}
