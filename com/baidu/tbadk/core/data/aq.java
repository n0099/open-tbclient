package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bGZ = BdUniqueId.gen();
    public int bEZ;
    public String bFl;
    public String bFm;
    public String bFn;
    public String bHa;
    public String bHb;
    public String bHc;
    public List<String> bHd;
    public String bHe;
    public String bHf;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bHa = recommendBook.recommend_text;
            this.bHb = recommendBook.suggest_text;
            this.bHc = recommendBook.suggest_url;
            this.bFl = recommendBook.book_id;
            this.bEZ = recommendBook.book_type.intValue();
            this.bFn = recommendBook.book_cover;
            this.bFm = recommendBook.book_title;
            this.bHd = recommendBook.book_tips;
            this.bHe = recommendBook.botton_text;
            this.bHf = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bFl)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bGZ;
    }
}
