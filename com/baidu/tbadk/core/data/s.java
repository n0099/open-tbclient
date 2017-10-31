package com.baidu.tbadk.core.data;

import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes.dex */
public class s {
    private String VJ;
    private String VK;
    private String VL;
    private String VM;
    private String VN;
    private String VO;
    private String VP;
    private long VQ;
    private long VR;
    private long VS;
    private long VT;
    private long VU;
    private long VV;
    private int Vn;
    private String author;

    public String pJ() {
        return this.VJ;
    }

    public int pK() {
        return this.Vn;
    }

    public void a(ForumBookInfo forumBookInfo) {
        if (forumBookInfo != null) {
            this.VJ = forumBookInfo.book_id;
            this.Vn = forumBookInfo.book_type.intValue();
            this.VK = forumBookInfo.book_title;
            this.VL = forumBookInfo.book_cover;
            this.author = forumBookInfo.author;
            this.VM = forumBookInfo.forum_pic;
            this.VN = forumBookInfo.show_chapter_id;
            this.VO = forumBookInfo.show_chapter_no;
            this.VP = forumBookInfo.show_chapter_title;
            this.VQ = forumBookInfo.history_page_id.longValue();
            this.VR = forumBookInfo.history_paragraph_id.longValue();
            this.VS = forumBookInfo.history_word_id.longValue();
            this.VT = forumBookInfo.history_percent.longValue();
            this.VU = forumBookInfo.show_page_id.longValue();
            this.VV = forumBookInfo.show_paragraph_id.longValue();
        }
    }
}
