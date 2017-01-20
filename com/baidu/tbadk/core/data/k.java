package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class k {
    public String Pl;
    public String Pm;
    public int Pn;
    public String Po;
    public int Pp = -1;
    public int Pq;
    public int Pr;
    public int Ps;
    public long Pt;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Pl = bookInfo.cover_img;
            this.Pm = bookInfo.cartoon_name;
            this.Pn = bookInfo.total_chapter.intValue();
            this.Po = bookInfo.first_chapter_id;
            this.Pq = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
