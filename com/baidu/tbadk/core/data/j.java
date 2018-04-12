package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String WJ;
    public String WK;
    public int WL;
    public String WM;
    public int WN = -1;
    public int WO;
    public int WP;
    public int WQ;
    public long WR;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.WJ = bookInfo.cover_img;
            this.WK = bookInfo.cartoon_name;
            this.WL = bookInfo.total_chapter.intValue();
            this.WM = bookInfo.first_chapter_id;
            this.WO = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
