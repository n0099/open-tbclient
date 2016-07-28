package com.baidu.tbadk.core.data;

import tbclient.GetMyShelf.BookInfo;
/* loaded from: classes.dex */
public class i {
    public String Nr;
    public String Ns;
    public int Nt;
    public String Nu;
    public int Nv = -1;
    public int Nw;
    public int Nx;
    public int Ny;
    public long Nz;
    public String authorName;
    public long cartoonId;
    public long forumId;

    public void a(BookInfo bookInfo) {
        if (bookInfo != null) {
            this.forumId = bookInfo.forum_id.longValue();
            this.cartoonId = bookInfo.cartoon_id.longValue();
            this.Nr = bookInfo.cover_img;
            this.Ns = bookInfo.cartoon_name;
            this.Nt = bookInfo.total_chapter.intValue();
            this.Nu = bookInfo.first_chapter_id;
            this.Nw = bookInfo.is_finish.intValue();
            this.authorName = bookInfo.author_name;
        }
    }
}
