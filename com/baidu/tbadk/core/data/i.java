package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String aKd;
    public String aKe;
    public int aKf;
    public String aKg;
    public int aKh = -1;
    public int aKi;
    public int aKj;
    public int aKk;
    public long aKl;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aKd = bookInfo.cover_img;
            this.aKe = bookInfo.cartoon_name;
            this.aKf = bookInfo.total_chapter.intValue();
            this.aKg = bookInfo.first_chapter_id;
            this.aKi = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
