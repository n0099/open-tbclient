package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class bd extends PostData {
    public static final BdUniqueId eQj = BdUniqueId.gen();
    public String eOB;
    public String eOC;
    public String eOD;
    public int eOd;
    public String eQk;
    public String eQl;
    public String eQm;
    public List<String> eQn;
    public String eQo;
    public String eQp;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eQk = recommendBook.recommend_text;
            this.eQl = recommendBook.suggest_text;
            this.eQm = recommendBook.suggest_url;
            this.eOB = recommendBook.book_id;
            this.eOd = recommendBook.book_type.intValue();
            this.eOD = recommendBook.book_cover;
            this.eOC = recommendBook.book_title;
            this.eQn = recommendBook.book_tips;
            this.eQo = recommendBook.botton_text;
            this.eQp = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.eOB)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eQj;
    }
}
