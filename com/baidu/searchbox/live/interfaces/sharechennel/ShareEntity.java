package com.baidu.searchbox.live.interfaces.sharechennel;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ShareEntity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SHARE_TYPE_QQ = 4;
    public static final int SHARE_TYPE_SINA_WEIBO = 1;
    public static final int SHARE_TYPE_WEIXIN = 2;
    public static final int SHARE_TYPE_WEIXIN_CIRCLE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public String imageUrl;
    public String linkUrl;
    public long liveId;
    public String title;
    public long userId;

    public ShareEntity() {
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
