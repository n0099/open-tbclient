package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String VE;
    public String VF;
    public int VG;
    public String VH;
    public int VI = -1;
    public int VJ;
    public int VK;
    public int VL;
    public long VM;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.VE = bookInfo.cover_img;
            this.VF = bookInfo.cartoon_name;
            this.VG = bookInfo.total_chapter.intValue();
            this.VH = bookInfo.first_chapter_id;
            this.VJ = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
