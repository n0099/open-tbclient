package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bzM = BdUniqueId.gen();
    public int bxN;
    public String bxZ;
    public String bya;
    public String byb;
    public String bzN;
    public String bzO;
    public String bzP;
    public List<String> bzQ;
    public String bzR;
    public String bzS;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bzN = recommendBook.recommend_text;
            this.bzO = recommendBook.suggest_text;
            this.bzP = recommendBook.suggest_url;
            this.bxZ = recommendBook.book_id;
            this.bxN = recommendBook.book_type.intValue();
            this.byb = recommendBook.book_cover;
            this.bya = recommendBook.book_title;
            this.bzQ = recommendBook.book_tips;
            this.bzR = recommendBook.botton_text;
            this.bzS = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bxZ)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bzM;
    }
}
