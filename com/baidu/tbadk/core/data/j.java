package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String Qf;
    public String Qg;
    public int Qh;
    public String Qi;
    public int Qj = -1;
    public int Qk;
    public int Ql;
    public int Qm;
    public long Qn;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Qf = bookInfo.cover_img;
            this.Qg = bookInfo.cartoon_name;
            this.Qh = bookInfo.total_chapter.intValue();
            this.Qi = bookInfo.first_chapter_id;
            this.Qk = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
