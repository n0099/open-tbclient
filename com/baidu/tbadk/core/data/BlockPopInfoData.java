package com.baidu.tbadk.core.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class BlockPopInfoData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_CAN_NOT_POST = 1;
    public static final int TYPE_CAN_POST = 0;
    public static final int TYPE_JUMP_TO_H5 = 2;
    public static final int TYPE_SHOW_DIALOG = 1;
    public static final long serialVersionUID = -9216537902294235110L;
    public transient /* synthetic */ FieldHolder $fh;
    public String ahead_info;
    public Integer ahead_type;
    public String ahead_url;
    public String appeal_msg;
    public int appeal_status;
    public String block_id_code;
    public String block_info;
    public Integer can_post;
    public String ok_info;
    public String sub_block_info;
    public int win_type;

    public BlockPopInfoData() {
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

    public boolean canPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.can_post.intValue() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
