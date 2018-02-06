package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public int aLA;
    public String aLB;
    public int aLC = -1;
    public int aLD;
    public int aLE;
    public int aLF;
    public long aLG;
    public String aLy;
    public String aLz;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aLy = bookInfo.cover_img;
            this.aLz = bookInfo.cartoon_name;
            this.aLA = bookInfo.total_chapter.intValue();
            this.aLB = bookInfo.first_chapter_id;
            this.aLD = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
