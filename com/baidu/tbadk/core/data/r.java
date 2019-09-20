package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private String bGL;
    private String bGM;
    private String bGN;
    private String bGO;
    private String bGP;
    private String bGQ;
    private String bGR;
    private long bGS;
    private long bGT;
    private long bGU;
    private long bGV;
    private long bGW;
    private long bGX;
    private int bGz;

    public String acS() {
        return this.bGL;
    }

    public int acT() {
        return this.bGz;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bGL = forumBookInfo.book_id;
            this.bGz = forumBookInfo.book_type.intValue();
            this.bGM = forumBookInfo.book_title;
            this.bGN = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bGO = forumBookInfo.forum_pic;
            this.bGP = forumBookInfo.show_chapter_id;
            this.bGQ = forumBookInfo.show_chapter_no;
            this.bGR = forumBookInfo.show_chapter_title;
            this.bGS = forumBookInfo.history_page_id.longValue();
            this.bGT = forumBookInfo.history_paragraph_id.longValue();
            this.bGU = forumBookInfo.history_word_id.longValue();
            this.bGV = forumBookInfo.history_percent.longValue();
            this.bGW = forumBookInfo.show_page_id.longValue();
            this.bGX = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
