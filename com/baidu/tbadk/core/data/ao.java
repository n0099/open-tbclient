package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId XK = BdUniqueId.gen();
    public int VO;
    public String Wa;
    public String Wb;
    public String Wc;
    public String XL;
    public String XM;
    public String XN;
    public List<String> XO;
    public String XP;
    public String XQ;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.XL = recommendBook.recommend_text;
            this.XM = recommendBook.suggest_text;
            this.XN = recommendBook.suggest_url;
            this.Wa = recommendBook.book_id;
            this.VO = recommendBook.book_type.intValue();
            this.Wc = recommendBook.book_cover;
            this.Wb = recommendBook.book_title;
            this.XO = recommendBook.book_tips;
            this.XP = recommendBook.botton_text;
            this.XQ = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.Wa)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XK;
    }
}
