package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.l;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class CpuChannelListManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CpuChannelListManager";
    public transient /* synthetic */ FieldHolder $fh;
    public l mCPUChannelListProd;
    public CpuChannelListListener mChannelIdListListener;

    /* loaded from: classes3.dex */
    public interface CpuChannelListListener {
        void onChannelListError(String str, int i);

        void onChannelListLoaded(List<CpuChannelResponse> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1445012638, "Lcom/baidu/mobads/sdk/api/CpuChannelListManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1445012638, "Lcom/baidu/mobads/sdk/api/CpuChannelListManager;");
        }
    }

    public CpuChannelListManager(Context context, CpuChannelListListener cpuChannelListListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cpuChannelListListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l lVar = new l(context);
        this.mCPUChannelListProd = lVar;
        this.mChannelIdListListener = cpuChannelListListener;
        lVar.a(cpuChannelListListener);
    }

    public void loadChannelList(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                br.a().c(TAG, "SubChannelId is null!");
                CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
                if (cpuChannelListListener != null) {
                    cpuChannelListListener.onChannelListError("SubChannelId is null.", bn.a.b());
                }
            } else if (TextUtils.isEmpty(str)) {
                br.a().c(TAG, "appsid is null!");
                CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
                if (cpuChannelListListener2 != null) {
                    cpuChannelListListener2.onChannelListError("appsid is null.", bn.a.b());
                }
            } else {
                try {
                    int parseInt = Integer.parseInt(str2);
                    l lVar = this.mCPUChannelListProd;
                    if (lVar != null) {
                        lVar.a(str, parseInt);
                        this.mCPUChannelListProd.a();
                    }
                } catch (Exception unused) {
                    br.a().c(TAG, "SubChannelId is not Integer!");
                    CpuChannelListListener cpuChannelListListener3 = this.mChannelIdListListener;
                    if (cpuChannelListListener3 != null) {
                        cpuChannelListListener3.onChannelListError("SubChannelId is not Integer!", bn.a.b());
                    }
                }
            }
        }
    }
}
