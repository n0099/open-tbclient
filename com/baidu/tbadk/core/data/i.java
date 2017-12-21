package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String VG;
    public String VH;
    public int VI;
    public String VJ;
    public int VK = -1;
    public int VL;
    public int VM;
    public int VN;
    public long VO;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.VG = bookInfo.cover_img;
            this.VH = bookInfo.cartoon_name;
            this.VI = bookInfo.total_chapter.intValue();
            this.VJ = bookInfo.first_chapter_id;
            this.VL = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
