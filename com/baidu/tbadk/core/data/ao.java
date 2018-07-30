package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId agI = BdUniqueId.gen();
    public int aeF;
    public String aeR;
    public String aeS;
    public String aeT;
    public String agJ;
    public String agK;
    public String agL;
    public List<String> agM;
    public String agN;
    public String agO;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.agJ = recommendBook.recommend_text;
            this.agK = recommendBook.suggest_text;
            this.agL = recommendBook.suggest_url;
            this.aeR = recommendBook.book_id;
            this.aeF = recommendBook.book_type.intValue();
            this.aeT = recommendBook.book_cover;
            this.aeS = recommendBook.book_title;
            this.agM = recommendBook.book_tips;
            this.agN = recommendBook.botton_text;
            this.agO = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aeR)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return agI;
    }
}
