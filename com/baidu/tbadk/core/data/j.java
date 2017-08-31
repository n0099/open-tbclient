package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String UH;
    public String UI;
    public int UJ;
    public String UK;
    public int UL = -1;
    public int UM;
    public int UN;
    public int UO;
    public long UQ;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.UH = bookInfo.cover_img;
            this.UI = bookInfo.cartoon_name;
            this.UJ = bookInfo.total_chapter.intValue();
            this.UK = bookInfo.first_chapter_id;
            this.UM = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
