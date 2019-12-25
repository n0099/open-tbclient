package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId cLG = BdUniqueId.gen();
    public int cJM;
    public String cJY;
    public String cJZ;
    public String cKa;
    public String cLH;
    public String cLI;
    public String cLJ;
    public List<String> cLK;
    public String cLL;
    public String cLM;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cLH = recommendBook.recommend_text;
            this.cLI = recommendBook.suggest_text;
            this.cLJ = recommendBook.suggest_url;
            this.cJY = recommendBook.book_id;
            this.cJM = recommendBook.book_type.intValue();
            this.cKa = recommendBook.book_cover;
            this.cJZ = recommendBook.book_title;
            this.cLK = recommendBook.book_tips;
            this.cLL = recommendBook.botton_text;
            this.cLM = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.cJY)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cLG;
    }
}
