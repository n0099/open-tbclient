package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x.b.f.c;
import c.a.x.g.g.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveFeedWrapData implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<LiveFeedWrapData> CREATOR;
    public static final String LIVE_FEED_PAGE_FEED_CACHE_KEY = "live_feed_page_feed_cache_key";
    public static final String LIVE_FEED_PAGE_FEED_CACHE_TIME = "live_feed_page_feed_cache_time";
    public transient /* synthetic */ FieldHolder $fh;
    public long cacheTime;
    public int errCode;
    public String errMsg;
    public boolean hasMore;
    public boolean isCacheData;
    public int refreshIndex;
    public int refreshType;
    public String resource;
    public List<LiveRoomEntity> roomInfoList;
    public String sessionId;
    public String subTab;
    public String tab;

    /* loaded from: classes10.dex */
    public class a implements Parcelable.Creator<LiveFeedWrapData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LiveFeedWrapData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new LiveFeedWrapData(parcel) : (LiveFeedWrapData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LiveFeedWrapData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new LiveFeedWrapData[i2] : (LiveFeedWrapData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1999277288, "Lcom/baidu/live/business/model/data/LiveFeedWrapData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1999277288, "Lcom/baidu/live/business/model/data/LiveFeedWrapData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public LiveFeedWrapData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getFeedCacheKey(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            return "live_feed_page_feed_cache_key_" + str + "_" + str2;
        }
        return (String) invokeLL.objValue;
    }

    private void parseJsonByResponse(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("inner_errno");
        this.errMsg = jSONObject.optString("inner_msg");
        this.sessionId = jSONObject.optString("session_id");
        this.tab = jSONObject.optString("tab");
        this.subTab = jSONObject.optString("subtab");
        this.refreshType = jSONObject.optInt("refresh_type");
        this.refreshIndex = jSONObject.optInt("refresh_index");
        this.cacheTime = jSONObject.optLong(LIVE_FEED_PAGE_FEED_CACHE_TIME);
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        boolean z = false;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.roomInfoList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    LiveRoomEntity liveRoomEntity = new LiveRoomEntity();
                    liveRoomEntity.parserJson(optJSONObject);
                    this.roomInfoList.add(liveRoomEntity);
                }
            }
        }
        this.hasMore = (this.errCode == 0 && d.c(this.roomInfoList)) ? true : true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean isBigRefresh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.refreshType == 0 : invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject, int i2) {
        List<LiveRoomEntity> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
            parseJsonByResponse(jSONObject);
            if (TextUtils.isEmpty(this.tab) || (list = this.roomInfoList) == null || list.isEmpty() || i2 != 0) {
                return;
            }
            try {
                jSONObject.put(LIVE_FEED_PAGE_FEED_CACHE_TIME, System.currentTimeMillis());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m("Feed 缓存记录时间失败 " + e2.getMessage());
            }
            c.f(getFeedCacheKey(this.tab, this.subTab), jSONObject.toString());
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeString(this.resource);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.errMsg);
            parcel.writeString(this.sessionId);
            parcel.writeString(this.tab);
            parcel.writeString(this.subTab);
            parcel.writeInt(this.refreshType);
            parcel.writeInt(this.refreshIndex);
            parcel.writeByte(this.hasMore ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.isCacheData ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.cacheTime);
            parcel.writeTypedList(this.roomInfoList);
        }
    }

    public LiveFeedWrapData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.resource = parcel.readString();
        this.errCode = parcel.readInt();
        this.errMsg = parcel.readString();
        this.sessionId = parcel.readString();
        this.tab = parcel.readString();
        this.subTab = parcel.readString();
        this.refreshType = parcel.readInt();
        this.refreshIndex = parcel.readInt();
        this.hasMore = parcel.readByte() != 0;
        this.isCacheData = parcel.readByte() != 0;
        this.cacheTime = parcel.readLong();
        this.roomInfoList = parcel.createTypedArrayList(LiveRoomEntity.CREATOR);
    }
}
