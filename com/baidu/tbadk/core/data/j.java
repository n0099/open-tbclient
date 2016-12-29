package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String Qc;
    public String Qd;
    public int Qe;
    public String Qf;
    public int Qg = -1;
    public int Qh;
    public int Qi;
    public int Qj;
    public long Qk;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Qc = bookInfo.cover_img;
            this.Qd = bookInfo.cartoon_name;
            this.Qe = bookInfo.total_chapter.intValue();
            this.Qf = bookInfo.first_chapter_id;
            this.Qh = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
