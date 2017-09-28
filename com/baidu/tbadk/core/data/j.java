package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String UW;
    public String UX;
    public int UY;
    public String UZ;
    public int Va = -1;
    public int Vb;
    public int Vc;
    public int Vd;
    public long Ve;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.UW = bookInfo.cover_img;
            this.UX = bookInfo.cartoon_name;
            this.UY = bookInfo.total_chapter.intValue();
            this.UZ = bookInfo.first_chapter_id;
            this.Vb = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
