package com.baidu.minivideo.plugin.capture.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BaseDraftManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DB_ADD = 1;
    public static final int DB_ADD_DRAFT_BACKUP = 7;
    public static final int DB_DELETE = 2;
    public static final int DB_DELETE_ALL = 6;
    public static final int DB_DELETE_DRAFT = 8;
    public static final int DB_QUERY = 4;
    public static final int DB_QUERY_ALL = 5;
    public static final int DB_QUERY_BY_DRAFT_NAME = 10;
    public static final int DB_REVERT = 9;
    public static final int DB_UPDATE = 3;
    public static final int FORM_ALBUM = 1;
    public static final int FORM_CAPTURE = 0;
    public static final int RESUME_PAGE_CAPTURE = 0;
    public static final int RESUME_PAGE_EDIT = 1;
    public static final int TAG_DRAFT_NAME = 1;
    public static final int TAG_MUSIC_PATH = 4;
    public static final int TAG_RESUME_ROUTE = 6;
    public static final int TAG_USER_ID = 2;
    public static final int TAG_VIDEO_TEMP_PATH = 3;
    public static final int TAG_VISIBILITY = 5;
    public static final int VISIBLE_NO = 0;
    public static final int VISIBLE_YES = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public BaseDraftManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
