package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class GroupAddressEditActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_GROUP_ADDRESS_ISHIDDEN = "HiddenAddress";
    public static final String INTENT_GROUP_ADRESS_LIST = "GroupAdressList";
    public static final String INTENT_GROUP_SELECTEDINDEX = "IntentSelectedIndex";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAddressEditActivityConfig(Context context, int i, List<String> list, int i2, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), list, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String[] strArr = new String[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            strArr[i5] = list.get(i5);
        }
        getIntent().putExtra(INTENT_GROUP_ADRESS_LIST, strArr);
        getIntent().putExtra(INTENT_GROUP_ADDRESS_ISHIDDEN, z);
        getIntent().putExtra(INTENT_GROUP_SELECTEDINDEX, i2);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
