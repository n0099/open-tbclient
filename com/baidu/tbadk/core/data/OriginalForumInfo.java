package com.baidu.tbadk.core.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.OriForumInfo;
/* loaded from: classes3.dex */
public class OriginalForumInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String id;
    public String ori_avatar;
    public String ori_fname;
    public long ori_member_num;

    public OriginalForumInfo() {
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

    public static OriginalForumInfo parser(OriForumInfo oriForumInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, oriForumInfo)) == null) {
            if (oriForumInfo == null) {
                return null;
            }
            OriginalForumInfo originalForumInfo = new OriginalForumInfo();
            originalForumInfo.id = String.valueOf(oriForumInfo.ori_fid);
            originalForumInfo.ori_fname = oriForumInfo.ori_fname;
            originalForumInfo.ori_avatar = oriForumInfo.ori_avatar;
            originalForumInfo.ori_member_num = oriForumInfo.ori_member_num.longValue();
            return originalForumInfo;
        }
        return (OriginalForumInfo) invokeL.objValue;
    }
}
