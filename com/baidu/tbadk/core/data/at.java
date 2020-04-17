package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId dpo = BdUniqueId.gen();
    public String dnG;
    public String dnH;
    public String dnI;
    public int dnu;
    public String dpp;
    public String dpq;
    public String dpr;
    public List<String> dps;
    public String dpt;
    public String dpu;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.dpp = recommendBook.recommend_text;
            this.dpq = recommendBook.suggest_text;
            this.dpr = recommendBook.suggest_url;
            this.dnG = recommendBook.book_id;
            this.dnu = recommendBook.book_type.intValue();
            this.dnI = recommendBook.book_cover;
            this.dnH = recommendBook.book_title;
            this.dps = recommendBook.book_tips;
            this.dpt = recommendBook.botton_text;
            this.dpu = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.dnG)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return dpo;
    }
}
