package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String aKe;
    public String aKf;
    public int aKg;
    public String aKh;
    public int aKi = -1;
    public int aKj;
    public int aKk;
    public int aKl;
    public long aKm;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aKe = bookInfo.cover_img;
            this.aKf = bookInfo.cartoon_name;
            this.aKg = bookInfo.total_chapter.intValue();
            this.aKh = bookInfo.first_chapter_id;
            this.aKj = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
