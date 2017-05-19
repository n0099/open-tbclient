package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String Ub;
    public String Uc;
    public int Ud;
    public String Ue;
    public int Uf = -1;
    public int Ug;
    public int Uh;
    public int Ui;
    public long Uj;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Ub = bookInfo.cover_img;
            this.Uc = bookInfo.cartoon_name;
            this.Ud = bookInfo.total_chapter.intValue();
            this.Ue = bookInfo.first_chapter_id;
            this.Ug = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
