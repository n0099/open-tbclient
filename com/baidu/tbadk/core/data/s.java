package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int UV;
    private long VA;
    private long VB;
    private long VC;
    private long VD;
    private String Vr;
    private String Vs;
    private String Vt;
    private String Vu;
    private String Vv;
    private String Vw;
    private String Vx;
    private long Vy;
    private long Vz;
    private String author;

    public String pE() {
        return this.Vr;
    }

    public int pF() {
        return this.UV;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Vr = forumBookInfo.book_id;
            this.UV = forumBookInfo.book_type.intValue();
            this.Vs = forumBookInfo.book_title;
            this.Vt = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Vu = forumBookInfo.forum_pic;
            this.Vv = forumBookInfo.show_chapter_id;
            this.Vw = forumBookInfo.show_chapter_no;
            this.Vx = forumBookInfo.show_chapter_title;
            this.Vy = forumBookInfo.history_page_id.longValue();
            this.Vz = forumBookInfo.history_paragraph_id.longValue();
            this.VA = forumBookInfo.history_word_id.longValue();
            this.VB = forumBookInfo.history_percent.longValue();
            this.VC = forumBookInfo.show_page_id.longValue();
            this.VD = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
