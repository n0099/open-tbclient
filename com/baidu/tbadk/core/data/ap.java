package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbPage.RecommendBook;
/* loaded from: classes.dex */
public class ap extends PostData {
    public static final BdUniqueId aho = BdUniqueId.gen();
    public int afl;
    public String afx;
    public String afy;
    public String afz;
    public String ahp;
    public String ahq;
    public String ahr;
    public List<String> ahs;
    public String aht;
    public String ahu;

    public void a(RecommendBook recommendBook) {
        if (recommendBook != null) {
            this.ahp = recommendBook.recommend_text;
            this.ahq = recommendBook.suggest_text;
            this.ahr = recommendBook.suggest_url;
            this.afx = recommendBook.book_id;
            this.afl = recommendBook.book_type.intValue();
            this.afz = recommendBook.book_cover;
            this.afy = recommendBook.book_title;
            this.ahs = recommendBook.book_tips;
            this.aht = recommendBook.botton_text;
            this.ahu = recommendBook.subscript_icon;
        }
    }

    public boolean hasData() {
        return (this == null || StringUtils.isNull(this.afx)) ? false : true;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aho;
    }
}
