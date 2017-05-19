package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String UJ;
    private String UK;
    private String UL;
    private String UM;
    private String UN;
    private String UO;
    private long UQ;
    private long UR;
    private long US;
    private long UT;
    private long UU;
    private long UV;
    private int Um;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pN() {
        return this.Um;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.Um = forumBookInfo.book_type.intValue();
            this.UJ = forumBookInfo.book_title;
            this.UK = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.UL = forumBookInfo.forum_pic;
            this.UM = forumBookInfo.show_chapter_id;
            this.UN = forumBookInfo.show_chapter_no;
            this.UO = forumBookInfo.show_chapter_title;
            this.UQ = forumBookInfo.history_page_id.longValue();
            this.UR = forumBookInfo.history_paragraph_id.longValue();
            this.US = forumBookInfo.history_word_id.longValue();
            this.UT = forumBookInfo.history_percent.longValue();
            this.UU = forumBookInfo.show_page_id.longValue();
            this.UV = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
