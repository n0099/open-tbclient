package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int VP;
    private String Wk;
    private String Wl;
    private String Wm;
    private String Wn;
    private String Wo;
    private String Wp;
    private long Wq;
    private long Wr;
    private long Ws;
    private long Wt;
    private long Wu;
    private long Wv;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pP() {
        return this.VP;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.VP = forumBookInfo.book_type.intValue();
            this.Wk = forumBookInfo.book_title;
            this.Wl = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Wm = forumBookInfo.forum_pic;
            this.Wn = forumBookInfo.show_chapter_id;
            this.Wo = forumBookInfo.show_chapter_no;
            this.Wp = forumBookInfo.show_chapter_title;
            this.Wq = forumBookInfo.history_page_id.longValue();
            this.Wr = forumBookInfo.history_paragraph_id.longValue();
            this.Ws = forumBookInfo.history_word_id.longValue();
            this.Wt = forumBookInfo.history_percent.longValue();
            this.Wu = forumBookInfo.show_page_id.longValue();
            this.Wv = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
