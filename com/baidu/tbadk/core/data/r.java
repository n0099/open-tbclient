package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private String bXF;
    private String bXG;
    private String bXH;
    private String bXI;
    private String bXJ;
    private String bXK;
    private String bXL;
    private long bXM;
    private long bXN;
    private long bXO;
    private long bXP;
    private long bXQ;
    private long bXR;
    private int bXt;

    public String agW() {
        return this.bXF;
    }

    public int agX() {
        return this.bXt;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bXF = forumBookInfo.book_id;
            this.bXt = forumBookInfo.book_type.intValue();
            this.bXG = forumBookInfo.book_title;
            this.bXH = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bXI = forumBookInfo.forum_pic;
            this.bXJ = forumBookInfo.show_chapter_id;
            this.bXK = forumBookInfo.show_chapter_no;
            this.bXL = forumBookInfo.show_chapter_title;
            this.bXM = forumBookInfo.history_page_id.longValue();
            this.bXN = forumBookInfo.history_paragraph_id.longValue();
            this.bXO = forumBookInfo.history_word_id.longValue();
            this.bXP = forumBookInfo.history_percent.longValue();
            this.bXQ = forumBookInfo.show_page_id.longValue();
            this.bXR = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
