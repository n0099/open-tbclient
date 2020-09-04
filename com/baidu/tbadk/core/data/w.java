package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class w {
    private String author;
    private String dXO;
    private String dXP;
    private String dXQ;
    private String dXR;
    private String dXS;
    private String dXT;
    private String dXU;
    private long dXV;
    private long dXW;
    private long dXX;
    private long dXY;
    private long dXZ;
    private int dXq;
    private long dYa;

    public String bcK() {
        return this.dXO;
    }

    public int bcL() {
        return this.dXq;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dXO = forumBookInfo.book_id;
            this.dXq = forumBookInfo.book_type.intValue();
            this.dXP = forumBookInfo.book_title;
            this.dXQ = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dXR = forumBookInfo.forum_pic;
            this.dXS = forumBookInfo.show_chapter_id;
            this.dXT = forumBookInfo.show_chapter_no;
            this.dXU = forumBookInfo.show_chapter_title;
            this.dXV = forumBookInfo.history_page_id.longValue();
            this.dXW = forumBookInfo.history_paragraph_id.longValue();
            this.dXX = forumBookInfo.history_word_id.longValue();
            this.dXY = forumBookInfo.history_percent.longValue();
            this.dXZ = forumBookInfo.show_page_id.longValue();
            this.dYa = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
