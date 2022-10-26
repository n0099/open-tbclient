package com.baidu.ala.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class AlaUserInfoData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int certify_status;
    public String description;
    public String live_id;
    public List live_mark_info_new;
    public String location;
    public AlaMarkCountInfoData mark_count;
    public String portrait;
    public String user_id;
    public String user_name;
    public String user_nickname;
    public long yy_level_exp;
    public int yy_level_id;
    public String yy_level_name;
    public String yy_level_next_name;
    public long yy_levelup_exp;

    public AlaUserInfoData() {
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
