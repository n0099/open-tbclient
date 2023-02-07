package com.baidu.searchbox.net.update;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class UpdateConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DETAIL_KEY = "detail";
    public static final String POST_DATA_DATA = "data";
    public static final String POST_DATA_PUBDATA = "pubdata";
    public static final String POST_DATA_VERSION = "version";
    public static final String PRODUCT_KEY = "product";
    public static final String RECEIVE_TS_KEY = "receive_timestamp";
    public static final String SUCCESS_COUNT_KEY = "successCount";
    public static final String TOTAL_COUNT_KEY = "totalCount";
    public static final String TRACE_ID = "trace_id";
    public static final String UBC_BUSINESS_KEY = "business";
    public static final String UBC_COUNT_KEY = "count";
    public static final String UBC_ITEMS_KEY = "items";
    public static final String UBC_ITEM_KEY = "item";
    public static final String UBC_SPEND_KEY = "spend";
    public static final String UBC_STATE_KEY = "state";
    public static final String VALID_KEY = "valid";
    public static final String VERSION_FILTER_COUNT_KEY = "versionFilterCount";
    public static final String VERSION_KEY = "version";
    public transient /* synthetic */ FieldHolder $fh;

    public UpdateConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
