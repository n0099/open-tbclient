package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class au extends PostData {
    public static final BdUniqueId Xr = BdUniqueId.gen();
    public int UT;
    public String Vp;
    public String Vq;
    public String Vr;
    public String Xs;
    public String Xt;
    public String Xu;
    public List<String> Xv;
    public String Xw;
    public String Xx;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.Xs = recommendBook.recommend_text;
            this.Xt = recommendBook.suggest_text;
            this.Xu = recommendBook.suggest_url;
            this.Vp = recommendBook.book_id;
            this.UT = recommendBook.book_type.intValue();
            this.Vr = recommendBook.book_cover;
            this.Vq = recommendBook.book_title;
            this.Xv = recommendBook.book_tips;
            this.Xw = recommendBook.botton_text;
            this.Xx = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.Vp)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Xr;
    }
}
