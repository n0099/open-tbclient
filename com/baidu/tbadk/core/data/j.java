package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String WK;
    public String WL;
    public int WM;
    public String WN;
    public int WO = -1;
    public int WP;
    public int WQ;
    public int WR;
    public long WS;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.WK = bookInfo.cover_img;
            this.WL = bookInfo.cartoon_name;
            this.WM = bookInfo.total_chapter.intValue();
            this.WN = bookInfo.first_chapter_id;
            this.WP = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
