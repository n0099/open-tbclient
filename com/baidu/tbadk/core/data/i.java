package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String aKb;
    public String aKc;
    public int aKd;
    public String aKe;
    public int aKf = -1;
    public int aKg;
    public int aKh;
    public int aKi;
    public long aKj;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aKb = bookInfo.cover_img;
            this.aKc = bookInfo.cartoon_name;
            this.aKd = bookInfo.total_chapter.intValue();
            this.aKe = bookInfo.first_chapter_id;
            this.aKg = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
