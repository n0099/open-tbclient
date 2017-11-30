package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String VJ;
    public String VK;
    public int VL;
    public String VM;
    public int VN = -1;
    public int VO;
    public int VP;
    public int VQ;
    public long VR;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.VJ = bookInfo.cover_img;
            this.VK = bookInfo.cartoon_name;
            this.VL = bookInfo.total_chapter.intValue();
            this.VM = bookInfo.first_chapter_id;
            this.VO = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
