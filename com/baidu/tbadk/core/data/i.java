package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String PO;
    public String PP;
    public int PQ;
    public String PR;
    public int PT = -1;
    public int PU;
    public int PV;
    public int PW;
    public long PX;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.PO = bookInfo.cover_img;
            this.PP = bookInfo.cartoon_name;
            this.PQ = bookInfo.total_chapter.intValue();
            this.PR = bookInfo.first_chapter_id;
            this.PU = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
