package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes2.dex */
public class p {
    private long ahA;
    private long ahB;
    private long ahC;
    private long ahD;
    private long ahE;
    private int ahg;
    private String ahs;
    private String aht;
    private String ahu;
    private String ahv;
    private String ahw;
    private String ahx;
    private String ahy;
    private long ahz;
    private String author;

    public String uP() {
        return this.ahs;
    }

    public int uQ() {
        return this.ahg;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.ahs = forumBookInfo.book_id;
            this.ahg = forumBookInfo.book_type.intValue();
            this.aht = forumBookInfo.book_title;
            this.ahu = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.ahv = forumBookInfo.forum_pic;
            this.ahw = forumBookInfo.show_chapter_id;
            this.ahx = forumBookInfo.show_chapter_no;
            this.ahy = forumBookInfo.show_chapter_title;
            this.ahz = forumBookInfo.history_page_id.longValue();
            this.ahA = forumBookInfo.history_paragraph_id.longValue();
            this.ahB = forumBookInfo.history_word_id.longValue();
            this.ahC = forumBookInfo.history_percent.longValue();
            this.ahD = forumBookInfo.show_page_id.longValue();
            this.ahE = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
