package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bEY;
    private String bFk;
    private String bFl;
    private String bFm;
    private String bFn;
    private String bFo;
    private String bFp;
    private String bFq;
    private long bFr;
    private long bFs;
    private long bFt;
    private long bFu;
    private long bFv;
    private long bFw;

    public String abL() {
        return this.bFk;
    }

    public int abM() {
        return this.bEY;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bFk = forumBookInfo.book_id;
            this.bEY = forumBookInfo.book_type.intValue();
            this.bFl = forumBookInfo.book_title;
            this.bFm = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bFn = forumBookInfo.forum_pic;
            this.bFo = forumBookInfo.show_chapter_id;
            this.bFp = forumBookInfo.show_chapter_no;
            this.bFq = forumBookInfo.show_chapter_title;
            this.bFr = forumBookInfo.history_page_id.longValue();
            this.bFs = forumBookInfo.history_paragraph_id.longValue();
            this.bFt = forumBookInfo.history_word_id.longValue();
            this.bFu = forumBookInfo.history_percent.longValue();
            this.bFv = forumBookInfo.show_page_id.longValue();
            this.bFw = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
