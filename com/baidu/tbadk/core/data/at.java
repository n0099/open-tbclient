package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class at extends PostData {
    public static final BdUniqueId cQi = BdUniqueId.gen();
    public String cOB;
    public String cOC;
    public String cOD;
    public int cOp;
    public String cQj;
    public String cQk;
    public String cQl;
    public List<String> cQm;
    public String cQn;
    public String cQo;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.cQj = recommendBook.recommend_text;
            this.cQk = recommendBook.suggest_text;
            this.cQl = recommendBook.suggest_url;
            this.cOB = recommendBook.book_id;
            this.cOp = recommendBook.book_type.intValue();
            this.cOD = recommendBook.book_cover;
            this.cOC = recommendBook.book_title;
            this.cQm = recommendBook.book_tips;
            this.cQn = recommendBook.botton_text;
            this.cQo = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.cOB)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cQi;
    }
}
