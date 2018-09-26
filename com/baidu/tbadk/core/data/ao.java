package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aji = BdUniqueId.gen();
    public int ahg;
    public String ahs;
    public String aht;
    public String ahu;
    public String ajj;
    public String ajk;
    public String ajl;
    public List<String> ajm;
    public String ajn;
    public String ajo;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ajj = recommendBook.recommend_text;
            this.ajk = recommendBook.suggest_text;
            this.ajl = recommendBook.suggest_url;
            this.ahs = recommendBook.book_id;
            this.ahg = recommendBook.book_type.intValue();
            this.ahu = recommendBook.book_cover;
            this.aht = recommendBook.book_title;
            this.ajm = recommendBook.book_tips;
            this.ajn = recommendBook.botton_text;
            this.ajo = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.ahs)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aji;
    }
}
