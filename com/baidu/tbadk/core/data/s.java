package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int UT;
    private long VA;
    private long VB;
    private String Vp;
    private String Vq;
    private String Vr;
    private String Vs;
    private String Vt;
    private String Vu;
    private String Vv;
    private long Vw;
    private long Vx;
    private long Vy;
    private long Vz;
    private String author;

    public String pK() {
        return this.Vp;
    }

    public int pL() {
        return this.UT;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Vp = forumBookInfo.book_id;
            this.UT = forumBookInfo.book_type.intValue();
            this.Vq = forumBookInfo.book_title;
            this.Vr = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Vs = forumBookInfo.forum_pic;
            this.Vt = forumBookInfo.show_chapter_id;
            this.Vu = forumBookInfo.show_chapter_no;
            this.Vv = forumBookInfo.show_chapter_title;
            this.Vw = forumBookInfo.history_page_id.longValue();
            this.Vx = forumBookInfo.history_paragraph_id.longValue();
            this.Vy = forumBookInfo.history_word_id.longValue();
            this.Vz = forumBookInfo.history_percent.longValue();
            this.VA = forumBookInfo.show_page_id.longValue();
            this.VB = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
