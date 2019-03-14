package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class aq extends PostData {
    public static final BdUniqueId bzI = BdUniqueId.gen();
    public int bxJ;
    public String bxV;
    public String bxW;
    public String bxX;
    public String bzJ;
    public String bzK;
    public String bzL;
    public List<String> bzM;
    public String bzN;
    public String bzO;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.bzJ = recommendBook.recommend_text;
            this.bzK = recommendBook.suggest_text;
            this.bzL = recommendBook.suggest_url;
            this.bxV = recommendBook.book_id;
            this.bxJ = recommendBook.book_type.intValue();
            this.bxX = recommendBook.book_cover;
            this.bxW = recommendBook.book_title;
            this.bzM = recommendBook.book_tips;
            this.bzN = recommendBook.botton_text;
            this.bzO = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.bxV)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bzI;
    }
}
