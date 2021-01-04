package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class bb extends PostData {
    public static final BdUniqueId eRh = BdUniqueId.gen();
    public String ePA;
    public String ePB;
    public int ePb;
    public String ePz;
    public String eRi;
    public String eRj;
    public String eRk;
    public List<String> eRl;
    public String eRm;
    public String eRn;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.eRi = recommendBook.recommend_text;
            this.eRj = recommendBook.suggest_text;
            this.eRk = recommendBook.suggest_url;
            this.ePz = recommendBook.book_id;
            this.ePb = recommendBook.book_type.intValue();
            this.ePB = recommendBook.book_cover;
            this.ePA = recommendBook.book_title;
            this.eRl = recommendBook.book_tips;
            this.eRm = recommendBook.botton_text;
            this.eRn = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.ePz)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eRh;
    }
}
