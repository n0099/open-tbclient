package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId aNt = BdUniqueId.gen();
    public String aLL;
    public String aLM;
    public String aLN;
    public int aLz;
    public String aNu;
    public String aNv;
    public String aNw;
    public List<String> aNx;
    public String aNy;
    public String aNz;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.aNu = recommendBook.recommend_text;
            this.aNv = recommendBook.suggest_text;
            this.aNw = recommendBook.suggest_url;
            this.aLL = recommendBook.book_id;
            this.aLz = recommendBook.book_type.intValue();
            this.aLN = recommendBook.book_cover;
            this.aLM = recommendBook.book_title;
            this.aNx = recommendBook.book_tips;
            this.aNy = recommendBook.botton_text;
            this.aNz = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.aLL)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aNt;
    }
}
