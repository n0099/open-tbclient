package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId cPV = BdUniqueId.gen();
    public int cOc;
    public String cOo;
    public String cOp;
    public String cOq;
    public String cPW;
    public String cPX;
    public String cPY;
    public List<String> cPZ;
    public String cQa;
    public String cQb;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cPW = recommendBook.recommend_text;
            this.cPX = recommendBook.suggest_text;
            this.cPY = recommendBook.suggest_url;
            this.cOo = recommendBook.book_id;
            this.cOc = recommendBook.book_type.intValue();
            this.cOq = recommendBook.book_cover;
            this.cOp = recommendBook.book_title;
            this.cPZ = recommendBook.book_tips;
            this.cQa = recommendBook.botton_text;
            this.cQb = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.cOo)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cPV;
    }
}
