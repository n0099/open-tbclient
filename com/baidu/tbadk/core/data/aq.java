package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId caf = BdUniqueId.gen();
    public int bYk;
    public String bYw;
    public String bYx;
    public String bYy;
    public String cag;
    public String cah;
    public String cai;
    public List<String> caj;
    public String cak;
    public String cal;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cag = recommendBook.recommend_text;
            this.cah = recommendBook.suggest_text;
            this.cai = recommendBook.suggest_url;
            this.bYw = recommendBook.book_id;
            this.bYk = recommendBook.book_type.intValue();
            this.bYy = recommendBook.book_cover;
            this.bYx = recommendBook.book_title;
            this.caj = recommendBook.book_tips;
            this.cak = recommendBook.botton_text;
            this.cal = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bYw)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return caf;
    }
}
