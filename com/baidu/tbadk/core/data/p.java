package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class p {
    private int VR;
    private String Wd;
    private String We;
    private String Wf;
    private String Wg;
    private String Wh;
    private String Wi;
    private String Wj;
    private long Wk;
    private long Wl;
    private long Wm;
    private long Wn;
    private long Wo;
    private long Wp;
    private String author;

    public String pK() {
        return this.Wd;
    }

    public int pL() {
        return this.VR;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.Wd = forumBookInfo.book_id;
            this.VR = forumBookInfo.book_type.intValue();
            this.We = forumBookInfo.book_title;
            this.Wf = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.Wg = forumBookInfo.forum_pic;
            this.Wh = forumBookInfo.show_chapter_id;
            this.Wi = forumBookInfo.show_chapter_no;
            this.Wj = forumBookInfo.show_chapter_title;
            this.Wk = forumBookInfo.history_page_id.longValue();
            this.Wl = forumBookInfo.history_paragraph_id.longValue();
            this.Wm = forumBookInfo.history_word_id.longValue();
            this.Wn = forumBookInfo.history_percent.longValue();
            this.Wo = forumBookInfo.show_page_id.longValue();
            this.Wp = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
