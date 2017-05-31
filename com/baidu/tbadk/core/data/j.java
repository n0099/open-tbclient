package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String TO;
    public String TP;
    public int TQ;
    public String TR;
    public int TS = -1;
    public int TT;
    public int TU;
    public int TV;
    public long TW;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.TO = bookInfo.cover_img;
            this.TP = bookInfo.cartoon_name;
            this.TQ = bookInfo.total_chapter.intValue();
            this.TR = bookInfo.first_chapter_id;
            this.TT = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
