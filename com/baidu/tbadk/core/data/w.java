package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes2.dex */
public class w {
    private String author;
    private String dXK;
    private String dXL;
    private String dXM;
    private String dXN;
    private String dXO;
    private String dXP;
    private String dXQ;
    private long dXR;
    private long dXS;
    private long dXT;
    private long dXU;
    private long dXV;
    private long dXW;
    private int dXm;

    public String bcK() {
        return this.dXK;
    }

    public int bcL() {
        return this.dXm;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dXK = forumBookInfo.book_id;
            this.dXm = forumBookInfo.book_type.intValue();
            this.dXL = forumBookInfo.book_title;
            this.dXM = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dXN = forumBookInfo.forum_pic;
            this.dXO = forumBookInfo.show_chapter_id;
            this.dXP = forumBookInfo.show_chapter_no;
            this.dXQ = forumBookInfo.show_chapter_title;
            this.dXR = forumBookInfo.history_page_id.longValue();
            this.dXS = forumBookInfo.history_paragraph_id.longValue();
            this.dXT = forumBookInfo.history_word_id.longValue();
            this.dXU = forumBookInfo.history_percent.longValue();
            this.dXV = forumBookInfo.show_page_id.longValue();
            this.dXW = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
