package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveFeedReserveWrapData implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LiveFeedReserveWrapData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveFeedReserveHeaderInfo headerInfo;
    public List<LiveRoomEntity> roomInfos;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-115021382, "Lcom/baidu/live/business/model/data/LiveFeedReserveWrapData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-115021382, "Lcom/baidu/live/business/model/data/LiveFeedReserveWrapData;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<LiveFeedReserveWrapData>() { // from class: com.baidu.live.business.model.data.LiveFeedReserveWrapData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LiveFeedReserveWrapData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new LiveFeedReserveWrapData(parcel);
                }
                return (LiveFeedReserveWrapData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LiveFeedReserveWrapData[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new LiveFeedReserveWrapData[i];
                }
                return (LiveFeedReserveWrapData[]) invokeI.objValue;
            }
        };
    }

    public LiveFeedReserveWrapData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean isValid() {
        InterceptResult invokeV;
        List<LiveRoomEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LiveFeedReserveHeaderInfo liveFeedReserveHeaderInfo = this.headerInfo;
            if (liveFeedReserveHeaderInfo != null && !TextUtils.isEmpty(liveFeedReserveHeaderInfo.tip) && (list = this.roomInfos) != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LiveFeedReserveWrapData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.headerInfo = (LiveFeedReserveHeaderInfo) parcel.readParcelable(LiveFeedReserveHeaderInfo.class.getClassLoader());
        this.roomInfos = parcel.createTypedArrayList(LiveRoomEntity.CREATOR);
    }

    public static LiveFeedReserveWrapData parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            LiveFeedReserveWrapData liveFeedReserveWrapData = new LiveFeedReserveWrapData();
            liveFeedReserveWrapData.headerInfo = LiveFeedReserveHeaderInfo.parseJson(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                liveFeedReserveWrapData.roomInfos = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                        liveRoomEntity.parserJson(optJSONObject);
                        liveRoomEntity.fromReserve = true;
                        liveFeedReserveWrapData.roomInfos.add(liveRoomEntity);
                    }
                }
            }
            return liveFeedReserveWrapData;
        }
        return (LiveFeedReserveWrapData) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeParcelable(this.headerInfo, i);
            parcel.writeTypedList(this.roomInfos);
        }
    }
}
