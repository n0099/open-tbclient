package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int UV;
    private long VA;
    private long VB;
    private long VC;
    private String Vr;
    private String Vs;
    private String Vt;
    private String Vu;
    private String Vv;
    private String Vw;
    private long Vx;
    private long Vy;
    private long Vz;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int qk() {
        return this.UV;
    }

    public String ql() {
        return this.Vs;
    }

    public String qm() {
        return this.author;
    }

    public long qn() {
        return this.Vx;
    }

    public String qo() {
        return this.Vw;
    }

    public String qp() {
        return this.Vv;
    }

    public String qq() {
        return this.Vu;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.UV = forumBookInfo.book_type.intValue();
            this.Vr = forumBookInfo.book_title;
            this.Vs = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Vt = forumBookInfo.forum_pic;
            this.Vu = forumBookInfo.show_chapter_id;
            this.Vv = forumBookInfo.show_chapter_no;
            this.Vw = forumBookInfo.show_chapter_title;
            this.Vx = forumBookInfo.history_page_id.longValue();
            this.Vy = forumBookInfo.history_paragraph_id.longValue();
            this.Vz = forumBookInfo.history_word_id.longValue();
            this.VA = forumBookInfo.history_percent.longValue();
            this.VB = forumBookInfo.show_page_id.longValue();
            this.VC = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
