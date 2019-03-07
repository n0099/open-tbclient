package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bzG = BdUniqueId.gen();
    public int bxH;
    public String bxT;
    public String bxU;
    public String bxV;
    public String bzH;
    public String bzI;
    public String bzJ;
    public List<String> bzK;
    public String bzL;
    public String bzM;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bzH = recommendBook.recommend_text;
            this.bzI = recommendBook.suggest_text;
            this.bzJ = recommendBook.suggest_url;
            this.bxT = recommendBook.book_id;
            this.bxH = recommendBook.book_type.intValue();
            this.bxV = recommendBook.book_cover;
            this.bxU = recommendBook.book_title;
            this.bzK = recommendBook.book_tips;
            this.bzL = recommendBook.botton_text;
            this.bzM = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bxT)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bzG;
    }
}
