package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String aLo;
    public String aLp;
    public int aLq;
    public String aLr;
    public int aLs = -1;
    public int aLt;
    public int aLu;
    public int aLv;
    public long aLw;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aLo = bookInfo.cover_img;
            this.aLp = bookInfo.cartoon_name;
            this.aLq = bookInfo.total_chapter.intValue();
            this.aLr = bookInfo.first_chapter_id;
            this.aLt = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
