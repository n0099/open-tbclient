package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String UJ;
    public String UK;
    public int UL;
    public String UM;
    public int UN = -1;
    public int UO;
    public int UQ;
    public int UR;
    public long US;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.UJ = bookInfo.cover_img;
            this.UK = bookInfo.cartoon_name;
            this.UL = bookInfo.total_chapter.intValue();
            this.UM = bookInfo.first_chapter_id;
            this.UO = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
