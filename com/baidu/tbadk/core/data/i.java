package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String PM;
    public String PN;
    public int PO;
    public String PP;
    public int PQ = -1;
    public int PR;
    public int PT;
    public int PU;
    public long PV;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.PM = bookInfo.cover_img;
            this.PN = bookInfo.cartoon_name;
            this.PO = bookInfo.total_chapter.intValue();
            this.PP = bookInfo.first_chapter_id;
            this.PR = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
