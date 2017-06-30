package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class k {
    public String TM;
    public String TO;
    public int TP;
    public String TQ;
    public int TR = -1;
    public int TS;
    public int TT;
    public int TU;
    public long TV;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.TM = bookInfo.cover_img;
            this.TO = bookInfo.cartoon_name;
            this.TP = bookInfo.total_chapter.intValue();
            this.TQ = bookInfo.first_chapter_id;
            this.TS = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
