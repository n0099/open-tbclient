package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bzL = BdUniqueId.gen();
    public int bxM;
    public String bxY;
    public String bxZ;
    public String bya;
    public String bzM;
    public String bzN;
    public String bzO;
    public List<String> bzP;
    public String bzQ;
    public String bzR;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bzM = recommendBook.recommend_text;
            this.bzN = recommendBook.suggest_text;
            this.bzO = recommendBook.suggest_url;
            this.bxY = recommendBook.book_id;
            this.bxM = recommendBook.book_type.intValue();
            this.bya = recommendBook.book_cover;
            this.bxZ = recommendBook.book_title;
            this.bzP = recommendBook.book_tips;
            this.bzQ = recommendBook.botton_text;
            this.bzR = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bxY)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bzL;
    }
}
