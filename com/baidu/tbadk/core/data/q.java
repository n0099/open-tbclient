package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class q {
    private String afA;
    private String afB;
    private String afC;
    private String afD;
    private long afE;
    private long afF;
    private long afG;
    private long afH;
    private long afI;
    private long afJ;
    private int afl;
    private String afx;
    private String afy;
    private String afz;
    private String author;

    public String ub() {
        return this.afx;
    }

    public int getBookType() {
        return this.afl;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.afx = forumBookInfo.book_id;
            this.afl = forumBookInfo.book_type.intValue();
            this.afy = forumBookInfo.book_title;
            this.afz = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.afA = forumBookInfo.forum_pic;
            this.afB = forumBookInfo.show_chapter_id;
            this.afC = forumBookInfo.show_chapter_no;
            this.afD = forumBookInfo.show_chapter_title;
            this.afE = forumBookInfo.history_page_id.longValue();
            this.afF = forumBookInfo.history_paragraph_id.longValue();
            this.afG = forumBookInfo.history_word_id.longValue();
            this.afH = forumBookInfo.history_percent.longValue();
            this.afI = forumBookInfo.show_page_id.longValue();
            this.afJ = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
