package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String aeL;
    public String aeM;
    public int aeN;
    public String aeO;
    public int aeP = -1;
    public int aeQ;
    public int aeR;
    public int aeS;
    public long aeT;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.aeL = bookInfo.cover_img;
            this.aeM = bookInfo.cartoon_name;
            this.aeN = bookInfo.total_chapter.intValue();
            this.aeO = bookInfo.first_chapter_id;
            this.aeQ = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
