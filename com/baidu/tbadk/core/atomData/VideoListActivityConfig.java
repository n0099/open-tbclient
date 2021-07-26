package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
/* loaded from: classes3.dex */
public class VideoListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FORUM_ID = "KEY_FORUM_ID";
    public static final String KEY_SOURCE = "KEY_SOURCE";
    public static final String KEY_THREAD_ID = "KEY_THREAD_ID";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoListActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.mContext = context;
    }

    public VideoListActivityConfig createNormalCfg(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3)) == null) {
            if (str2 == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra(KEY_FORUM_ID, str);
            intent.putExtra(KEY_THREAD_ID, str2);
            if (!k.isEmpty(str3)) {
                intent.putExtra(KEY_SOURCE, str3);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            return this;
        }
        return (VideoListActivityConfig) invokeLLL.objValue;
    }

    public VideoListActivityConfig createNormalCfg(long j, String str) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, str)) == null) {
            Intent intent = getIntent();
            intent.putExtra("user_id", j);
            if (!k.isEmpty(str)) {
                intent.putExtra(KEY_SOURCE, str);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            return this;
        }
        return (VideoListActivityConfig) invokeJL.objValue;
    }
}
