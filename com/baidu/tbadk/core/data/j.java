package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class j {
    public String VC;
    public String VD;
    public int VE;
    public String VF;
    public int VG = -1;
    public int VH;
    public int VI;
    public int VJ;
    public long VK;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.VC = bookInfo.cover_img;
            this.VD = bookInfo.cartoon_name;
            this.VE = bookInfo.total_chapter.intValue();
            this.VF = bookInfo.first_chapter_id;
            this.VH = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
