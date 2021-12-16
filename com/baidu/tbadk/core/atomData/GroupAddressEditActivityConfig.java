package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class GroupAddressEditActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTENT_GROUP_ADDRESS_ISHIDDEN = "HiddenAddress";
    public static final String INTENT_GROUP_ADRESS_LIST = "GroupAdressList";
    public static final String INTENT_GROUP_SELECTEDINDEX = "IntentSelectedIndex";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAddressEditActivityConfig(Context context, int i2, List<String> list, int i3, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), list, Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String[] strArr = new String[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            strArr[i6] = list.get(i6);
        }
        getIntent().putExtra(INTENT_GROUP_ADRESS_LIST, strArr);
        getIntent().putExtra(INTENT_GROUP_ADDRESS_ISHIDDEN, z);
        getIntent().putExtra(INTENT_GROUP_SELECTEDINDEX, i3);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
