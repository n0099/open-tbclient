package com.baidu.searchbox.cloudcommand.dao;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CloudCommandTable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CREATE_TABLE = "create table cloudcommand(msgId text primary key,type text ,dispatched integer,version text,timestamp integer)";
    public static final String DISPATCHED = "dispatched";
    public static final int IS_DISPATCHED = 1;
    public static final String MSG_ID = "msgId";
    public static final String TABLE_NAME = "cloudcommand";
    public static final String TIMESTAMP = "timestamp";
    public static final String TYPE = "type";
    public static final String VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    public CloudCommandTable() {
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
