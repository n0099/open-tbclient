package com.baidu.searchbox.retrieve.debug.provider;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.retrieve.file.util.fetch.FetchTaskManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes3.dex */
public class FetchDebugConfigProvider extends DebugDataGroupProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String DEBUG_TITLE = "YaLog回捞上传测试";
    public static final String INTENT_START_DEBUG_ACTIVITY = "com.baidu.searchbox.retrieve.debug.provicer.DEBUG_YALOG_ACTIVITY";
    public static final String ITEM_YA_LOG_DEBUG_ACTIVITY = "进入YaLog文件上传Debug页面";
    public static final String TAG = "FetchLogProvider";
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener lcpOnlineListener;
    public View.OnClickListener mDebugActivityListener;

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DEBUG_TITLE : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(82549126, "Lcom/baidu/searchbox/retrieve/debug/provider/FetchDebugConfigProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(82549126, "Lcom/baidu/searchbox/retrieve/debug/provider/FetchDebugConfigProvider;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchDebugConfigProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.lcpOnlineListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.FetchDebugConfigProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FetchDebugConfigProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    if (FetchDebugConfigProvider.DEBUG) {
                        Log.d(FetchDebugConfigProvider.TAG, "switch to LCP online env");
                    }
                    Context context = view2.getContext();
                    boolean isDebug = FetchTaskManager.getInstance().isDebug();
                    FetchTaskManager.getInstance().setDebug(!isDebug);
                    StringBuilder sb = new StringBuilder();
                    sb.append("已切换至");
                    if (isDebug) {
                        str = "线上环境";
                    } else {
                        str = "线下环境";
                    }
                    sb.append(str);
                    sb.append(" 重启APP生效");
                    Toast.makeText(context, sb.toString(), 1).show();
                }
            }
        };
        this.mDebugActivityListener = new View.OnClickListener(this) { // from class: com.baidu.searchbox.retrieve.debug.provider.FetchDebugConfigProvider.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FetchDebugConfigProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), new Intent(FetchDebugConfigProvider.INTENT_START_DEBUG_ACTIVITY));
                }
            }
        };
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public List<DebugItemInfo> getChildItemList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getLcpOperationInfo();
        }
        return (List) invokeV.objValue;
    }

    private List<DebugItemInfo> getLcpOperationInfo() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (FetchTaskManager.getInstance().isDebug()) {
                str = "线下环境";
            } else {
                str = "线上环境";
            }
            arrayList.add(new TextItemInfo(null, str, this.lcpOnlineListener));
            arrayList.add(new TextItemInfo(null, ITEM_YA_LOG_DEBUG_ACTIVITY, this.mDebugActivityListener));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
