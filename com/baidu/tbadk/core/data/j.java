package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String Un;
    public String Uo;
    public int Up;
    public String Uq;
    public int Ur = -1;
    public int Us;
    public int Ut;
    public int Uu;
    public long Uv;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Un = bookInfo.cover_img;
            this.Uo = bookInfo.cartoon_name;
            this.Up = bookInfo.total_chapter.intValue();
            this.Uq = bookInfo.first_chapter_id;
            this.Us = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
