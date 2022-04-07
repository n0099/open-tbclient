package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
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
    public EvaluateRelevanceItemSelectedMessage(String str, String str2, String str3, double d, double d2, int i, List<String> list) {
        super(2921516);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.item_id = str;
        this.item_name = str2;
        this.icon_url = str3;
        this.score = d;
        this.icon_size = d2;
        this.star = i;
        this.tags = list;
    }
}
