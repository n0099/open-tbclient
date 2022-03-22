package com.baidu.searchbox.launch.stats;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public final class AppBeforeCreateSpeedStats extends AbstractSpeedStats {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APP_ATTACH = "appAttach";
    public static final String APP_RUNTIME_INIT = "appRuntimeInit";
    public static final String INSTALL_CONTENT_PROVIDER = "installContentProvider";
    public static final String MULTIDEX_INSTALL = "multidexInstall";
    public static final String NPS_INIT = "npsInit";
    public static final String TITAN_DETAILS = "titan";
    public static final String TITAN_INIT = "titanInit";
    public transient /* synthetic */ FieldHolder $fh;
    public long mAiappsRuntimeEndTimeStamp;
    public long mAppAttachContextEndTimeStamp;
    public long mAppCreateStartTime;
    public long mAppRuntimeInitEndTimeStamp;
    public long mAttachBaseContextStartTimeStamp;
    public long mMultiDexinstallEndTimeStamp;
    public long mNpsInitEndTimeStamp;
    public long mTiTanInitEndTimeStamp;
    public Map mTitanDetailsMap;

    public AppBeforeCreateSpeedStats() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAttachBaseContextStartTimeStamp = -1L;
        this.mMultiDexinstallEndTimeStamp = -1L;
        this.mAppRuntimeInitEndTimeStamp = -1L;
        this.mAppAttachContextEndTimeStamp = -1L;
        this.mAiappsRuntimeEndTimeStamp = -1L;
        this.mNpsInitEndTimeStamp = -1L;
        this.mTiTanInitEndTimeStamp = -1L;
        this.mAppCreateStartTime = -1L;
        this.mTitanDetailsMap = null;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsMap(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) {
            super.addStatsMap(str, map);
            if (((str.hashCode() == 110371084 && str.equals(TITAN_DETAILS)) ? (char) 0 : (char) 65535) != 0) {
                return;
            }
            this.mTitanDetailsMap = map;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            addStatsTimeStamp(i, System.currentTimeMillis());
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsEndTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppCreateStartTime : invokeV.longValue;
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public long getStatsStartTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp() : invokeV.longValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:44:0x00c4
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public boolean packData(org.json.JSONObject r23) {
        /*
            r22 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.launch.stats.AppBeforeCreateSpeedStats.$ic
            if (r0 != 0) goto L102
        L4:
            r1 = r22
            r2 = r23
            super.packData(r23)
            r3 = 1
            if (r2 != 0) goto Lf
            return r3
        Lf:
            com.baidu.searchbox.launch.stats.SpeedStatsManager r0 = com.baidu.searchbox.launch.stats.SpeedStatsManager.getInstance()
            long r4 = r0.getAppLaunchStartTimeStamp()
            long r6 = r1.mAppCreateStartTime
            long r8 = r6 - r4
            long r10 = r1.mAttachBaseContextStartTimeStamp
            long r4 = r10 - r4
            long r12 = r1.mMultiDexinstallEndTimeStamp
            long r14 = r12 - r10
            r16 = r4
            long r3 = r1.mAiappsRuntimeEndTimeStamp
            long r12 = r3 - r12
            r18 = r12
            long r12 = r1.mNpsInitEndTimeStamp
            long r3 = r12 - r3
            r20 = r3
            long r2 = r1.mTiTanInitEndTimeStamp
            long r2 = r2 - r12
            long r4 = r1.mAppAttachContextEndTimeStamp
            long r10 = r4 - r10
            long r6 = r6 - r4
            r4 = 0
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            r12 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 > 0) goto L100
            int r0 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            int r0 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r0 > 0) goto L100
            int r0 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            int r0 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r0 > 0) goto L100
            int r0 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            int r0 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r0 > 0) goto L100
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 > 0) goto L100
            int r0 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            int r0 = (r20 > r12 ? 1 : (r20 == r12 ? 0 : -1))
            if (r0 > 0) goto L100
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 < 0) goto L100
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 <= 0) goto L78
            goto L100
        L78:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r4 = java.lang.String.valueOf(r10)
            java.lang.String r5 = "appAttach"
            r0.put(r5, r4)
            java.lang.String r4 = java.lang.String.valueOf(r14)
            java.lang.String r12 = "multidexInstall"
            r0.put(r12, r4)
            java.lang.String r4 = java.lang.String.valueOf(r18)
            java.lang.String r12 = "appRuntimeInit"
            r0.put(r12, r4)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "titanInit"
            r0.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r20)
            java.lang.String r3 = "npsInit"
            r0.put(r3, r2)
            java.lang.String r2 = java.lang.String.valueOf(r6)
            java.lang.String r3 = "installContentProvider"
            r0.put(r3, r2)
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r8, r0)
            if (r0 == 0) goto Ld1
            java.lang.String r2 = "beforeAppCreate"
            r4 = r23
            r4.put(r2, r0)     // Catch: org.json.JSONException -> Lc2
            goto Ld3
        Lc2:
            r0 = move-exception
            goto Lc7
        Lc4:
            r0 = move-exception
            r4 = r23
        Lc7:
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto Ld3
            r0.printStackTrace()
            goto Ld3
        Ld1:
            r4 = r23
        Ld3:
            r2 = 0
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r10, r2)
            if (r0 == 0) goto Le9
            r4.put(r5, r0)     // Catch: org.json.JSONException -> Lde
            goto Le9
        Lde:
            r0 = move-exception
            r5 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto Le9
            r5.printStackTrace()
        Le9:
            org.json.JSONObject r0 = com.baidu.searchbox.launch.utils.SpeedStatsUtils.getJsonData(r6, r2)
            if (r0 == 0) goto Lfe
            r4.put(r3, r0)     // Catch: org.json.JSONException -> Lf3
            goto Lfe
        Lf3:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r0 == 0) goto Lfe
            r2.printStackTrace()
        Lfe:
            r2 = 1
            return r2
        L100:
            r0 = 0
            return r0
        L102:
            r20 = r0
            r21 = 1048581(0x100005, float:1.469375E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r20.invokeL(r21, r22, r23)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.launch.stats.AppBeforeCreateSpeedStats.packData(org.json.JSONObject):boolean");
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mAttachBaseContextStartTimeStamp = -1L;
            this.mMultiDexinstallEndTimeStamp = -1L;
            this.mAppRuntimeInitEndTimeStamp = -1L;
            this.mAppAttachContextEndTimeStamp = -1L;
            this.mAiappsRuntimeEndTimeStamp = -1L;
            this.mNpsInitEndTimeStamp = -1L;
            this.mNpsInitEndTimeStamp = -1L;
            this.mTitanDetailsMap = null;
        }
    }

    @Override // com.baidu.searchbox.launch.stats.AbstractSpeedStats
    public void addStatsTimeStamp(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            super.addStatsTimeStamp(i, j);
            if (i != 2000) {
                switch (i) {
                    case 1002:
                        this.mAttachBaseContextStartTimeStamp = j;
                        return;
                    case 1003:
                        this.mMultiDexinstallEndTimeStamp = j;
                        return;
                    case 1004:
                        this.mAiappsRuntimeEndTimeStamp = j;
                        return;
                    default:
                        switch (i) {
                            case 1010:
                                this.mAppAttachContextEndTimeStamp = j;
                                return;
                            case 1011:
                                this.mNpsInitEndTimeStamp = j;
                                return;
                            case 1012:
                                this.mTiTanInitEndTimeStamp = j;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.mAppCreateStartTime = j;
        }
    }
}
