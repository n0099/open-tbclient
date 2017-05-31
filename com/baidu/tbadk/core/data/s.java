package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int TZ;
    private String UB;
    private long UC;
    private long UD;
    private long UE;
    private long UF;
    private long UG;
    private long UH;
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

    public int pF() {
        return this.TZ;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.TZ = forumBookInfo.book_type.intValue();
            this.Uv = forumBookInfo.book_title;
            this.Uw = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Ux = forumBookInfo.forum_pic;
            this.Uy = forumBookInfo.show_chapter_id;
            this.Uz = forumBookInfo.show_chapter_no;
            this.UB = forumBookInfo.show_chapter_title;
            this.UC = forumBookInfo.history_page_id.longValue();
            this.UD = forumBookInfo.history_paragraph_id.longValue();
            this.UE = forumBookInfo.history_word_id.longValue();
            this.UF = forumBookInfo.history_percent.longValue();
            this.UG = forumBookInfo.show_page_id.longValue();
            this.UH = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
