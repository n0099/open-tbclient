package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int UT;
    private long VA;
    private String Vp;
    private String Vq;
    private String Vr;
    private String Vs;
    private String Vt;
    private String Vu;
    private long Vv;
    private long Vw;
    private long Vx;
    private long Vy;
    private long Vz;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int qk() {
        return this.UT;
    }

    public String ql() {
        return this.Vq;
    }

    public String qm() {
        return this.author;
    }

    public long qn() {
        return this.Vv;
    }

    public String qo() {
        return this.Vu;
    }

    public String qp() {
        return this.Vt;
    }

    public String qq() {
        return this.Vs;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.UT = forumBookInfo.book_type.intValue();
            this.Vp = forumBookInfo.book_title;
            this.Vq = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Vr = forumBookInfo.forum_pic;
            this.Vs = forumBookInfo.show_chapter_id;
            this.Vt = forumBookInfo.show_chapter_no;
            this.Vu = forumBookInfo.show_chapter_title;
            this.Vv = forumBookInfo.history_page_id.longValue();
            this.Vw = forumBookInfo.history_paragraph_id.longValue();
            this.Vx = forumBookInfo.history_word_id.longValue();
            this.Vy = forumBookInfo.history_percent.longValue();
            this.Vz = forumBookInfo.show_page_id.longValue();
            this.VA = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
