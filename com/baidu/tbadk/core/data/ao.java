package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId XN = BdUniqueId.gen();
    public int VR;
    public String Wd;
    public String We;
    public String Wf;
    public String XO;
    public String XP;
    public String XQ;
    public List<String> XR;
    public String XS;
    public String XT;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.XO = recommendBook.recommend_text;
            this.XP = recommendBook.suggest_text;
            this.XQ = recommendBook.suggest_url;
            this.Wd = recommendBook.book_id;
            this.VR = recommendBook.book_type.intValue();
            this.Wf = recommendBook.book_cover;
            this.We = recommendBook.book_title;
            this.XR = recommendBook.book_tips;
            this.XS = recommendBook.botton_text;
            this.XT = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.Wd)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XN;
    }
}
