package com.baidu.android.imsdk.chatmessage.request.params;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.IGetPaInfoListener;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FetchMsgParam extends BaseRequestParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FetchMsgParam";
    public transient /* synthetic */ FieldHolder $fh;
    public long beginMsgId;
    public int category;
    public long contacterBduid;
    public long contacterPa;
    public long contacterUk;
    public int contacterUserType;
    public int count;
    public long endMsgId;
    public BIMValueCallBack<FetchMsgResponse> fetchMsgRequestCallback;
    public int fetchTriggerReason;
    public long lastMsgId;
    public long lastMsgRowId;
    public PaInfo paInfo;
    public String screenKey;
    public long to;
    public int triggerReason;

    /* loaded from: classes.dex */
    public interface FetchMsgParamConstruct {
        void construct(FetchMsgParam fetchMsgParam);
    }

    public FetchMsgParam() {
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
        this.beginMsgId = 0L;
        this.fetchTriggerReason = 0;
        this.screenKey = "";
    }

    public long getBeginMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.beginMsgId;
        }
        return invokeV.longValue;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.category;
        }
        return invokeV.intValue;
    }

    public long getContacterBduid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.contacterBduid;
        }
        return invokeV.longValue;
    }

    public long getContacterPa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.contacterPa;
        }
        return invokeV.longValue;
    }

    public long getContacterUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.contacterUk;
        }
        return invokeV.longValue;
    }

    public int getContacterUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.contacterUserType;
        }
        return invokeV.intValue;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.count;
        }
        return invokeV.intValue;
    }

    public long getEndMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.endMsgId;
        }
        return invokeV.longValue;
    }

    public int getFetchTriggerReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.fetchTriggerReason;
        }
        return invokeV.intValue;
    }

    public long getLastMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.lastMsgId;
        }
        return invokeV.longValue;
    }

    public long getLastMsgRowId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.lastMsgRowId;
        }
        return invokeV.longValue;
    }

    public PaInfo getPaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.paInfo;
        }
        return (PaInfo) invokeV.objValue;
    }

    public BIMValueCallBack<FetchMsgResponse> getRequestCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.fetchMsgRequestCallback;
        }
        return (BIMValueCallBack) invokeV.objValue;
    }

    public String getScreenKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.screenKey;
        }
        return (String) invokeV.objValue;
    }

    public long getTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.to;
        }
        return invokeV.longValue;
    }

    public int getTriggerReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.triggerReason;
        }
        return invokeV.intValue;
    }

    public static void constructParamByPainfo(FetchMsgParam fetchMsgParam, PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, fetchMsgParam, paInfo) == null) && fetchMsgParam != null && paInfo != null) {
            fetchMsgParam.setContacterBduid(paInfo.getBduid());
            fetchMsgParam.setContacterUk(paInfo.getImUk());
        }
    }

    public static FetchMsgParam newInstance(@NonNull Context context, long j, long j2, int i, int i2, @NonNull long j3, long j4, long j5, long j6, BIMValueCallBack<FetchMsgResponse> bIMValueCallBack) {
        InterceptResult invokeCommon;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), bIMValueCallBack})) == null) {
            if (context != null && j4 > 0 && j5 > 0 && j6 > 0) {
                FetchMsgParam fetchMsgParam = new FetchMsgParam();
                fetchMsgParam.setCategory(i2);
                fetchMsgParam.setTo(j3);
                fetchMsgParam.setContacterPa(j5);
                fetchMsgParam.setContacterUk(j4);
                fetchMsgParam.setContacterBduid(j6);
                if (i3 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                fetchMsgParam.setContacterUserType(RequestParamManager.getUserType(z));
                fetchMsgParam.setBeginMsgId(j);
                fetchMsgParam.setEndMsgId(j2);
                fetchMsgParam.setCount(i);
                fetchMsgParam.setRequestCallBack(bIMValueCallBack);
                return fetchMsgParam;
            }
            LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
            return null;
        }
        return (FetchMsgParam) invokeCommon.objValue;
    }

    public static void newInstance(@NonNull Context context, long j, long j2, int i, int i2, long j3, long j4, PaInfo paInfo, String str, BIMValueCallBack<FetchMsgResponse> bIMValueCallBack, FetchMsgParamConstruct fetchMsgParamConstruct) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), paInfo, str, bIMValueCallBack, fetchMsgParamConstruct}) == null) {
            if (context != null && (j3 != 0 || j4 != 0)) {
                if (j4 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                FetchMsgParam fetchMsgParam = new FetchMsgParam();
                fetchMsgParam.setCategory(i2);
                if (z) {
                    fetchMsgParam.setTo(j4);
                    fetchMsgParam.setContacterPa(j4);
                } else {
                    fetchMsgParam.setTo(j3);
                    fetchMsgParam.setContacterUk(j3);
                }
                fetchMsgParam.setContacterUserType(RequestParamManager.getUserType(z));
                fetchMsgParam.setBeginMsgId(j);
                fetchMsgParam.setEndMsgId(j2);
                fetchMsgParam.setCount(i);
                fetchMsgParam.setRequestCallBack(bIMValueCallBack);
                fetchMsgParam.setScreenKey(str);
                if (z) {
                    LogUtils.d(TAG, "FetchMsgParamConstruct pa :" + paInfo);
                    if (paInfo == null) {
                        PaInfo paInfoSync = IMBoxManager.getPaInfoSync(context, j4);
                        if (paInfoSync == null) {
                            IMBoxManager.getPaInfo(context, j4, new IGetPaInfoListener(fetchMsgParam, fetchMsgParamConstruct) { // from class: com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ FetchMsgParam val$fetchMsgParam;
                                public final /* synthetic */ FetchMsgParamConstruct val$paramConstruct;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {fetchMsgParam, fetchMsgParamConstruct};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$fetchMsgParam = fetchMsgParam;
                                    this.val$paramConstruct = fetchMsgParamConstruct;
                                }

                                @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                                public void onGetPaInfoResult(int i3, String str2, PaInfo paInfo2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str2, paInfo2) == null) {
                                        if (paInfo2 != null) {
                                            FetchMsgParam.constructParamByPainfo(this.val$fetchMsgParam, paInfo2);
                                        } else {
                                            LogUtils.e(FetchMsgParam.TAG, "getSendMsgParam paUid invalid");
                                        }
                                        this.val$paramConstruct.construct(this.val$fetchMsgParam);
                                    }
                                }
                            });
                            return;
                        }
                        constructParamByPainfo(fetchMsgParam, paInfoSync);
                        fetchMsgParamConstruct.construct(fetchMsgParam);
                        return;
                    }
                    constructParamByPainfo(fetchMsgParam, paInfo);
                    fetchMsgParamConstruct.construct(fetchMsgParam);
                    return;
                }
                ChatUserManagerImpl.getInstance(context).getUser(j3, 0, new IGetUserListener(fetchMsgParam, fetchMsgParamConstruct) { // from class: com.baidu.android.imsdk.chatmessage.request.params.FetchMsgParam.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FetchMsgParam val$fetchMsgParam;
                    public final /* synthetic */ FetchMsgParamConstruct val$paramConstruct;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {fetchMsgParam, fetchMsgParamConstruct};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$fetchMsgParam = fetchMsgParam;
                        this.val$paramConstruct = fetchMsgParamConstruct;
                    }

                    @Override // com.baidu.android.imsdk.chatuser.IGetUserListener
                    public void onGetUserResult(int i3, long j5, ChatUser chatUser) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), Long.valueOf(j5), chatUser}) == null) {
                            if (chatUser != null) {
                                this.val$fetchMsgParam.setContacterBduid(chatUser.getBuid());
                            }
                            this.val$paramConstruct.construct(this.val$fetchMsgParam);
                        }
                    }
                });
                return;
            }
            LogUtils.d(TAG, "getFetchMsgParam failed, param invalid :" + context + ", contacterUk :" + j3 + ", contacterPaUid :" + j4);
            fetchMsgParamConstruct.construct(null);
            bIMValueCallBack.onResult(1005, "param error", new FetchMsgResponse());
        }
    }

    public static void newInstance(@NonNull Context context, long j, long j2, int i, int i2, long j3, long j4, String str, BIMValueCallBack<FetchMsgResponse> bIMValueCallBack, FetchMsgParamConstruct fetchMsgParamConstruct) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), str, bIMValueCallBack, fetchMsgParamConstruct}) == null) {
            newInstance(context, j, j2, i, i2, j3, j4, null, str, bIMValueCallBack, fetchMsgParamConstruct);
        }
    }

    public static void newInstanceByPa(@NonNull Context context, long j, long j2, int i, int i2, long j3, PaInfo paInfo, String str, BIMValueCallBack<FetchMsgResponse> bIMValueCallBack, FetchMsgParamConstruct fetchMsgParamConstruct) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), paInfo, str, bIMValueCallBack, fetchMsgParamConstruct}) == null) {
            if (context != null && j3 > 0) {
                newInstance(context, j, j2, i, i2, 0L, j3, paInfo, str, bIMValueCallBack, fetchMsgParamConstruct);
                return;
            }
            LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
            fetchMsgParamConstruct.construct(null);
        }
    }

    public static void newInstanceByPa(@NonNull Context context, long j, long j2, int i, int i2, long j3, String str, BIMValueCallBack<FetchMsgResponse> bIMValueCallBack, FetchMsgParamConstruct fetchMsgParamConstruct) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), str, bIMValueCallBack, fetchMsgParamConstruct}) == null) {
            newInstance(context, j, j2, i, i2, 0L, j3, null, str, bIMValueCallBack, fetchMsgParamConstruct);
        }
    }

    public static void newInstanceByUk(@NonNull Context context, long j, long j2, int i, int i2, long j3, String str, BIMValueCallBack<FetchMsgResponse> bIMValueCallBack, FetchMsgParamConstruct fetchMsgParamConstruct) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), str, bIMValueCallBack, fetchMsgParamConstruct}) == null) {
            if (j3 <= 0) {
                LogUtils.d(TAG, "getSendMsgParam failed, param invalid");
                fetchMsgParamConstruct.construct(null);
                return;
            }
            newInstance(context, j, j2, i, i2, j3, 0L, str, bIMValueCallBack, fetchMsgParamConstruct);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.params.BaseRequestParam
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if ((super.isValid() && getBeginMsgId() >= 0) || (getEndMsgId() >= 0 && getCategory() >= 0)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onRequestResult(int i, String str, FetchMsgResponse fetchMsgResponse) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048593, this, i, str, fetchMsgResponse) == null) && getRequestCallBack() != null) {
            getRequestCallBack().onResult(i, str, fetchMsgResponse);
        }
    }

    public void setBeginMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.beginMsgId = j;
        }
    }

    public void setCategory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.category = i;
        }
    }

    public void setContacterBduid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.contacterBduid = j;
        }
    }

    public void setContacterPa(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.contacterPa = j;
        }
    }

    public void setContacterUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.contacterUk = j;
        }
    }

    public void setContacterUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.contacterUserType = i;
        }
    }

    public void setCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.count = i;
        }
    }

    public void setEndMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.endMsgId = j;
        }
    }

    public void setFetchTriggerReason(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.fetchTriggerReason = i;
        }
    }

    public void setLastMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.lastMsgId = j;
        }
    }

    public void setLastMsgRowId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.lastMsgRowId = j;
        }
    }

    public void setPaInfo(PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, paInfo) == null) {
            this.paInfo = paInfo;
        }
    }

    public void setRequestCallBack(BIMValueCallBack<FetchMsgResponse> bIMValueCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bIMValueCallBack) == null) {
            this.fetchMsgRequestCallback = bIMValueCallBack;
        }
    }

    public void setScreenKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.screenKey = str;
        }
    }

    public void setTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.to = j;
        }
    }

    public void setTriggerReason(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.triggerReason = i;
        }
    }
}
