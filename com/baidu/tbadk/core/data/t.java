package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class t {
    private int TY;
    private long UB;
    private long UC;
    private long UD;
    private long UE;
    private long UF;
    private long UG;
    private String Uu;
    private String Uv;
    private String Uw;
    private String Ux;
    private String Uy;
    private String Uz;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pC() {
        return this.TY;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.TY = forumBookInfo.book_type.intValue();
            this.Uu = forumBookInfo.book_title;
            this.Uv = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Uw = forumBookInfo.forum_pic;
            this.Ux = forumBookInfo.show_chapter_id;
            this.Uy = forumBookInfo.show_chapter_no;
            this.Uz = forumBookInfo.show_chapter_title;
            this.UB = forumBookInfo.history_page_id.longValue();
            this.UC = forumBookInfo.history_paragraph_id.longValue();
            this.UD = forumBookInfo.history_word_id.longValue();
            this.UE = forumBookInfo.history_percent.longValue();
            this.UF = forumBookInfo.show_page_id.longValue();
            this.UG = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
