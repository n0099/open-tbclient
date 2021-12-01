package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class EvaluateRelevanceItemSelectedMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double icon_size;
    public String icon_url;
    public String item_id;
    public String item_name;
    public double score;
    public int star;
    public List<String> tags;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EvaluateRelevanceItemSelectedMessage(String str, String str2, String str3, double d2, double d3, int i2, List<String> list) {
        super(2921516);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Double.valueOf(d2), Double.valueOf(d3), Integer.valueOf(i2), list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.item_id = str;
        this.item_name = str2;
        this.icon_url = str3;
        this.score = d2;
        this.icon_size = d3;
        this.star = i2;
        this.tags = list;
    }
}
