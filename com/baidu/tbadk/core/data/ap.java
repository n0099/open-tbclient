package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ap extends PostData {
    public static final BdUniqueId YU = BdUniqueId.gen();
    public int WV;
    public String Xh;
    public String Xi;
    public String Xj;
    public String YV;
    public String YW;
    public String YX;
    public List<String> YY;
    public String YZ;
    public String Za;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.YV = recommendBook.recommend_text;
            this.YW = recommendBook.suggest_text;
            this.YX = recommendBook.suggest_url;
            this.Xh = recommendBook.book_id;
            this.WV = recommendBook.book_type.intValue();
            this.Xj = recommendBook.book_cover;
            this.Xi = recommendBook.book_title;
            this.YY = recommendBook.book_tips;
            this.YZ = recommendBook.botton_text;
            this.Za = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.Xh)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return YU;
    }
}
