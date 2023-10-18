package com.baidu.mobads.sdk.api;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ArticleInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHAPTER_NUM = "page_chptr_num";
    public static final String CONTENT_CATEGORY = "page_content_category";
    public static final String CONTENT_LABEL = "page_content_label";
    public static final String FAVORITE_BOOK = "fav_book";
    public static final String FIRST_LEVEL_CONTENTS = "page_ctnts_l1";
    public static final String PAGE_AUTHOR_ID = "page_author_id";
    public static final String PAGE_ID = "page_content_id";
    public static final String PAGE_SERIAL_STATUS = "page_series_stat";
    public static final String PAGE_TITLE = "page_title";
    public static final String[] PREDEFINED_KEYS;
    public static final String QUERY_WORD = "qw";
    public static final String SECOND_LEVEL_CONTENTS = "page_ctnts_l2";
    public static final String USER_SEX = "sex";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class ValidSexValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int FEMALE;
        public int MALE;
        public int UNKNOWN;
        public final /* synthetic */ ArticleInfo this$0;

        public ValidSexValue(ArticleInfo articleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {articleInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = articleInfo;
            this.UNKNOWN = 0;
            this.MALE = 1;
            this.FEMALE = 2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(667334738, "Lcom/baidu/mobads/sdk/api/ArticleInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(667334738, "Lcom/baidu/mobads/sdk/api/ArticleInfo;");
                return;
            }
        }
        PREDEFINED_KEYS = new String[]{"sex", PAGE_TITLE, PAGE_ID, CONTENT_CATEGORY, CONTENT_LABEL, FIRST_LEVEL_CONTENTS, FAVORITE_BOOK, PAGE_SERIAL_STATUS, CHAPTER_NUM, PAGE_AUTHOR_ID, SECOND_LEVEL_CONTENTS, QUERY_WORD};
    }

    public ArticleInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
