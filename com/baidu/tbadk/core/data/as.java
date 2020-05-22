package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class as extends PostData {
    public static final BdUniqueId dDq = BdUniqueId.gen();
    public String dBL;
    public String dBM;
    public String dBN;
    public int dBz;
    public String dDr;
    public String dDs;
    public String dDt;
    public List<String> dDu;
    public String dDv;
    public String dDw;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dDr = recommendBook.recommend_text;
            this.dDs = recommendBook.suggest_text;
            this.dDt = recommendBook.suggest_url;
            this.dBL = recommendBook.book_id;
            this.dBz = recommendBook.book_type.intValue();
            this.dBN = recommendBook.book_cover;
            this.dBM = recommendBook.book_title;
            this.dDu = recommendBook.book_tips;
            this.dDv = recommendBook.botton_text;
            this.dDw = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dBL)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return dDq;
    }
}
