package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String VF;
    public String VG;
    public int VH;
    public String VI;
    public int VJ = -1;
    public int VK;
    public int VL;
    public int VM;
    public long VN;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.VF = bookInfo.cover_img;
            this.VG = bookInfo.cartoon_name;
            this.VH = bookInfo.total_chapter.intValue();
            this.VI = bookInfo.first_chapter_id;
            this.VK = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
