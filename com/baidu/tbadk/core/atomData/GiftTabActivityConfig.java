package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GiftTabActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACCOUNT_TYPE = "account_type";
    public static final String FROM = "from";
    public static final String FROM_LIVE_ROOM = "android_live_room";
    public static final String FROM_PB = "android_pb";
    public static final String FROM_PERSON_CENTER = "android_person_center";
    public static final String FROM_PERSON_CHAT = "android_person_chat";
    public static final String FROM_PHOTO_LIVE = "android_photo_live";
    public static final String GIFT_POST_ID = "gift_post_id";
    public static final String GIFT_RECEIVER_ID = "gift_receiver_id";
    public static final String GIFT_RECEIVER_NAME = "gift_receiver_name";
    public static final String GIFT_RECEIVER_NAME_SHOW = "gift_receiver_name_show";
    public static final String GIFT_THREAD_ID = "gift_thread_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GiftTabActivityConfig(Context context, long j, String str, String str2) {
        this(context, j, str, str2, FROM_PERSON_CENTER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Long) objArr2[1]).longValue(), (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setReferPageAndClickZone(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            getIntent().putExtra(MemberPayStatistic.REFER_PAGE, str);
            getIntent().putExtra(MemberPayStatistic.CLICK_ZONE, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftTabActivityConfig(Context context, long j, String str, String str2, String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("gift_receiver_id", j);
        getIntent().putExtra(GIFT_RECEIVER_NAME, str);
        getIntent().putExtra(GIFT_RECEIVER_NAME_SHOW, str2);
        getIntent().putExtra("from", str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftTabActivityConfig(Context context, long j, String str, String str2, String str3, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), str, str2, str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra("gift_receiver_id", j);
        getIntent().putExtra(GIFT_RECEIVER_NAME, str);
        getIntent().putExtra(GIFT_RECEIVER_NAME_SHOW, str2);
        getIntent().putExtra("from", str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftTabActivityConfig(Context context, long j, String str, String str2, String str3, long j2, long j3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, Long.valueOf(j), str, str2, str3, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("gift_receiver_id", j);
        getIntent().putExtra(GIFT_RECEIVER_NAME, str);
        getIntent().putExtra(GIFT_RECEIVER_NAME_SHOW, str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra(GIFT_THREAD_ID, j2);
        getIntent().putExtra(GIFT_POST_ID, j3);
    }
}
