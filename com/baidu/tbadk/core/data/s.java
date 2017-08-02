package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String UL;
    private String UM;
    private String UN;
    private String UO;
    private String UQ;
    private String UR;
    private long US;
    private long UT;
    private long UU;
    private long UV;
    private long UW;
    private long UX;
    private int Uo;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pF() {
        return this.Uo;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Uo = forumBookInfo.book_type.intValue();
            this.UL = forumBookInfo.book_title;
            this.UM = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.UN = forumBookInfo.forum_pic;
            this.UO = forumBookInfo.show_chapter_id;
            this.UQ = forumBookInfo.show_chapter_no;
            this.UR = forumBookInfo.show_chapter_title;
            this.US = forumBookInfo.history_page_id.longValue();
            this.UT = forumBookInfo.history_paragraph_id.longValue();
            this.UU = forumBookInfo.history_word_id.longValue();
            this.UV = forumBookInfo.history_percent.longValue();
            this.UW = forumBookInfo.show_page_id.longValue();
            this.UX = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
