package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aNs = BdUniqueId.gen();
    public String aLK;
    public String aLL;
    public String aLM;
    public int aLy;
    public String aNt;
    public String aNu;
    public String aNv;
    public List<String> aNw;
    public String aNx;
    public String aNy;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aNt = recommendBook.recommend_text;
            this.aNu = recommendBook.suggest_text;
            this.aNv = recommendBook.suggest_url;
            this.aLK = recommendBook.book_id;
            this.aLy = recommendBook.book_type.intValue();
            this.aLM = recommendBook.book_cover;
            this.aLL = recommendBook.book_title;
            this.aNw = recommendBook.book_tips;
            this.aNx = recommendBook.botton_text;
            this.aNy = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aLK)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aNs;
    }
}
