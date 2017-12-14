package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String VD;
    public String VE;
    public int VF;
    public String VG;
    public int VH = -1;
    public int VI;
    public int VJ;
    public int VK;
    public long VL;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.VD = bookInfo.cover_img;
            this.VE = bookInfo.cartoon_name;
            this.VF = bookInfo.total_chapter.intValue();
            this.VG = bookInfo.first_chapter_id;
            this.VI = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
