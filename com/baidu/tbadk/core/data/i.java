package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String aLn;
    public String aLo;
    public int aLp;
    public String aLq;
    public int aLr = -1;
    public int aLs;
    public int aLt;
    public int aLu;
    public long aLv;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aLn = bookInfo.cover_img;
            this.aLo = bookInfo.cartoon_name;
            this.aLp = bookInfo.total_chapter.intValue();
            this.aLq = bookInfo.first_chapter_id;
            this.aLs = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
