package com.baidu.mobads.sdk.api;
/* loaded from: classes2.dex */
public class ArticleInfo {
    public static final String USER_SEX = "sex";
    public static final String FAVORITE_BOOK = "fav_book";
    public static final String PAGE_TITLE = "page_title";
    public static final String PAGE_ID = "page_content_id";
    public static final String CONTENT_CATEGORY = "page_content_category";
    public static final String CONTENT_LABEL = "page_content_label";
    public static final String QUERY_WORD = "qw";
    public static final String[] PREDEFINED_KEYS = {"sex", FAVORITE_BOOK, PAGE_TITLE, PAGE_ID, CONTENT_CATEGORY, CONTENT_LABEL, QUERY_WORD};

    /* loaded from: classes2.dex */
    public class ValidSexValue {
        public int UNKNOWN = 0;
        public int MALE = 1;
        public int FEMALE = 2;

        public ValidSexValue() {
        }
    }
}
