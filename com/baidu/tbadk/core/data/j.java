package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String afa;
    public String afb;
    public int afc;
    public String afd;
    public int afe = -1;
    public int aff;
    public int afg;
    public int afh;
    public long afi;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.afa = bookInfo.cover_img;
            this.afb = bookInfo.cartoon_name;
            this.afc = bookInfo.total_chapter.intValue();
            this.afd = bookInfo.first_chapter_id;
            this.aff = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
