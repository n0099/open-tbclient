package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String Vc;
    public String Vd;
    public int Ve;
    public String Vf;
    public int Vg = -1;
    public int Vh;
    public int Vi;
    public int Vj;
    public long Vk;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Vc = bookInfo.cover_img;
            this.Vd = bookInfo.cartoon_name;
            this.Ve = bookInfo.total_chapter.intValue();
            this.Vf = bookInfo.first_chapter_id;
            this.Vh = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
