package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private int VQ;
    private String Wl;
    private String Wm;
    private String Wn;
    private String Wo;
    private String Wp;
    private String Wq;
    private long Wr;
    private long Ws;
    private long Wt;
    private long Wu;
    private long Wv;
    private long Ww;
    private String author;
    private String bookId;

    public String getBookId() {
        return this.bookId;
    }

    public int pQ() {
        return this.VQ;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.bookId = forumBookInfo.book_id;
            this.VQ = forumBookInfo.book_type.intValue();
            this.Wl = forumBookInfo.book_title;
            this.Wm = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Wn = forumBookInfo.forum_pic;
            this.Wo = forumBookInfo.show_chapter_id;
            this.Wp = forumBookInfo.show_chapter_no;
            this.Wq = forumBookInfo.show_chapter_title;
            this.Wr = forumBookInfo.history_page_id.longValue();
            this.Ws = forumBookInfo.history_paragraph_id.longValue();
            this.Wt = forumBookInfo.history_word_id.longValue();
            this.Wu = forumBookInfo.history_percent.longValue();
            this.Wv = forumBookInfo.show_page_id.longValue();
            this.Ww = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
