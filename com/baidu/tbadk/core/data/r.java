package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes3.dex */
public class r {
    private String author;
    private int bEZ;
    private String bFl;
    private String bFm;
    private String bFn;
    private String bFo;
    private String bFp;
    private String bFq;
    private String bFr;
    private long bFs;
    private long bFt;
    private long bFu;
    private long bFv;
    private long bFw;
    private long bFx;

    public String abL() {
        return this.bFl;
    }

    public int abM() {
        return this.bEZ;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bFl = forumBookInfo.book_id;
            this.bEZ = forumBookInfo.book_type.intValue();
            this.bFm = forumBookInfo.book_title;
            this.bFn = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.bFo = forumBookInfo.forum_pic;
            this.bFp = forumBookInfo.show_chapter_id;
            this.bFq = forumBookInfo.show_chapter_no;
            this.bFr = forumBookInfo.show_chapter_title;
            this.bFs = forumBookInfo.history_page_id.longValue();
            this.bFt = forumBookInfo.history_paragraph_id.longValue();
            this.bFu = forumBookInfo.history_word_id.longValue();
            this.bFv = forumBookInfo.history_percent.longValue();
            this.bFw = forumBookInfo.show_page_id.longValue();
            this.bFx = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
