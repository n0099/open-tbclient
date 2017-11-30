package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ao extends PostData {
    public static final BdUniqueId XQ = BdUniqueId.gen();
    public int VU;
    public String Wg;
    public String Wh;
    public String Wi;
    public String XR;
    public String XS;
    public String XT;
    public List<String> XU;
    public String XV;
    public String XW;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.XR = recommendBook.recommend_text;
            this.XS = recommendBook.suggest_text;
            this.XT = recommendBook.suggest_url;
            this.Wg = recommendBook.book_id;
            this.VU = recommendBook.book_type.intValue();
            this.Wi = recommendBook.book_cover;
            this.Wh = recommendBook.book_title;
            this.XU = recommendBook.book_tips;
            this.XV = recommendBook.botton_text;
            this.XW = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.Wg)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XQ;
    }
}
