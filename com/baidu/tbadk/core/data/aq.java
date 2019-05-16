package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bGY = BdUniqueId.gen();
    public int bEY;
    public String bFk;
    public String bFl;
    public String bFm;
    public String bGZ;
    public String bHa;
    public String bHb;
    public List<String> bHc;
    public String bHd;
    public String bHe;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bGZ = recommendBook.recommend_text;
            this.bHa = recommendBook.suggest_text;
            this.bHb = recommendBook.suggest_url;
            this.bFk = recommendBook.book_id;
            this.bEY = recommendBook.book_type.intValue();
            this.bFm = recommendBook.book_cover;
            this.bFl = recommendBook.book_title;
            this.bHc = recommendBook.book_tips;
            this.bHd = recommendBook.botton_text;
            this.bHe = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bFk)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bGY;
    }
}
