package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class MemberExchangeActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DESC_STR = "desc_str";
    public static final String DUE_DATE = "due_date";
    public static final String MEMBER_IMAGE = "member_image";
    public static final String MEMBER_LEVEL_IMAGE = "member_level_image";
    public static final String MEMBER_NAME = "member_name";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class MemberInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String dueDate;
        public String memberImage;
        public String memberLevelIcon;
        public String memberName;
        public final /* synthetic */ MemberExchangeActivityConfig this$0;

        public MemberInfo(MemberExchangeActivityConfig memberExchangeActivityConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberExchangeActivityConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = memberExchangeActivityConfig;
        }
    }

    /* loaded from: classes6.dex */
    public class VipRecommendData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int dayCounts;
        public String descStr;
        public String expire;
        public String nextLevelStr;
        public final /* synthetic */ MemberExchangeActivityConfig this$0;
        public int vipDays;

        public VipRecommendData(MemberExchangeActivityConfig memberExchangeActivityConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberExchangeActivityConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = memberExchangeActivityConfig;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberExchangeActivityConfig(Context context, String str, String str2, String str3, String str4, String str5) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(MEMBER_IMAGE, str);
        getIntent().putExtra(MEMBER_NAME, str2);
        getIntent().putExtra(MEMBER_LEVEL_IMAGE, str3);
        getIntent().putExtra(DUE_DATE, str4);
        getIntent().putExtra(DESC_STR, str5);
    }
}
