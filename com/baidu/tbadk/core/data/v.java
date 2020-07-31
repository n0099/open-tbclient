package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class v {
    private String author;
    private long dOA;
    private long dOB;
    private long dOC;
    private long dOD;
    private int dOd;
    private String dOr;
    private String dOs;
    private String dOt;
    private String dOu;
    private String dOv;
    private String dOw;
    private String dOx;
    private long dOy;
    private long dOz;

    public String aUr() {
        return this.dOr;
    }

    public int aUs() {
        return this.dOd;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.dOr = forumBookInfo.book_id;
            this.dOd = forumBookInfo.book_type.intValue();
            this.dOs = forumBookInfo.book_title;
            this.dOt = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.dOu = forumBookInfo.forum_pic;
            this.dOv = forumBookInfo.show_chapter_id;
            this.dOw = forumBookInfo.show_chapter_no;
            this.dOx = forumBookInfo.show_chapter_title;
            this.dOy = forumBookInfo.history_page_id.longValue();
            this.dOz = forumBookInfo.history_paragraph_id.longValue();
            this.dOA = forumBookInfo.history_word_id.longValue();
            this.dOB = forumBookInfo.history_percent.longValue();
            this.dOC = forumBookInfo.show_page_id.longValue();
            this.dOD = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
