package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aod = BdUniqueId.gen();
    public int amc;
    public String amo;
    public String amp;
    public String amq;
    public String aoe;
    public String aof;
    public String aog;
    public List<String> aoh;
    public String aoi;
    public String aoj;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aoe = recommendBook.recommend_text;
            this.aof = recommendBook.suggest_text;
            this.aog = recommendBook.suggest_url;
            this.amo = recommendBook.book_id;
            this.amc = recommendBook.book_type.intValue();
            this.amq = recommendBook.book_cover;
            this.amp = recommendBook.book_title;
            this.aoh = recommendBook.book_tips;
            this.aoi = recommendBook.botton_text;
            this.aoj = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.amo)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aod;
    }
}
