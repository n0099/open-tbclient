package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String Ud;
    public String Ue;
    public int Uf;
    public String Ug;
    public int Uh = -1;
    public int Ui;
    public int Uj;
    public int Uk;
    public long Ul;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Ud = bookInfo.cover_img;
            this.Ue = bookInfo.cartoon_name;
            this.Uf = bookInfo.total_chapter.intValue();
            this.Ug = bookInfo.first_chapter_id;
            this.Ui = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
