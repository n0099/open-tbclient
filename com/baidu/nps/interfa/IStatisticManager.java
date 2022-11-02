package com.baidu.nps.interfa;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public interface IStatisticManager {
    void onPatchResult(int i, String str, int i2, String str2, StatisticExtendInfo statisticExtendInfo);

    void onUninstallResult(int i, String str, int i2, String str2, StatisticExtendInfo statisticExtendInfo);

    void recordDownloadResult(int i, String str, int i2, String str2, StatisticExtendInfo statisticExtendInfo);

    void recordException(int i, String str, String str2);

    void recordInstallResult(int i, String str, int i2, String str2, StatisticExtendInfo statisticExtendInfo);

    void recordInvokeResult(int i, String str, int i2, String str2, StatisticExtendInfo statisticExtendInfo);

    void recordPeriod(long j, long j2);

    void recordResult(long j, int i, String str);

    /* loaded from: classes2.dex */
    public static class StatisticExtendInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long costTime;
        public String ext;
        public String source;

        public StatisticExtendInfo() {
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
}
