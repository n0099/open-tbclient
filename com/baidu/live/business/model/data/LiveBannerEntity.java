package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xb0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveBannerEntity implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<LiveBannerEntity> CREATOR;
    public static final int TYPE_LIVE = 1;
    public static final int TYPE_OTHER = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int audienceCount;
    public int bannerType;
    public b cmdInfo;
    public long endTime;
    public LiveHostInfo hostInfo;
    public LeftLableInfo leftLabel;
    public int liveStatus;
    public String materialId;
    public String name;
    public boolean needLogShow;
    public String nid;
    public String pic;
    public int position;
    public String roomId;
    public long startTime;
    public LiveStatInfo statInfo;

    /* loaded from: classes2.dex */
    public class a implements Parcelable.Creator<LiveBannerEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LiveBannerEntity createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new LiveBannerEntity(parcel) : (LiveBannerEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LiveBannerEntity[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new LiveBannerEntity[i] : (LiveBannerEntity[]) invokeI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public b(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveBannerEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            jSONObject.optInt("type");
            this.a = jSONObject.optString("action");
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-927372453, "Lcom/baidu/live/business/model/data/LiveBannerEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-927372453, "Lcom/baidu/live/business/model/data/LiveBannerEntity;");
                return;
            }
        }
        CREATOR = new a();
    }

    public LiveBannerEntity() {
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
        this.needLogShow = true;
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

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !xb0.a(this.pic) : invokeV.booleanValue;
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.name = jSONObject.optString("name");
        this.pic = jSONObject.optString("pic");
        this.nid = jSONObject.optString("nid");
        this.roomId = jSONObject.optString("room_Id");
        this.audienceCount = jSONObject.optInt("audience_count");
        this.materialId = jSONObject.optString("material_id");
        this.liveStatus = jSONObject.optInt(IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS);
        this.startTime = jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
        this.endTime = jSONObject.optLong("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("host");
        if (optJSONObject != null) {
            LiveHostInfo liveHostInfo = new LiveHostInfo();
            this.hostInfo = liveHostInfo;
            liveHostInfo.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cmd");
        if (optJSONObject2 != null) {
            b bVar = new b(this);
            this.cmdInfo = bVar;
            bVar.a(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("left_label");
        if (optJSONObject3 != null) {
            LeftLableInfo leftLableInfo = new LeftLableInfo();
            this.leftLabel = leftLableInfo;
            leftLableInfo.parserJson(optJSONObject3);
        }
        this.bannerType = jSONObject.optInt("banner_type");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("stat");
        if (optJSONObject4 != null) {
            LiveStatInfo liveStatInfo = new LiveStatInfo();
            this.statInfo = liveStatInfo;
            liveStatInfo.parserJson(optJSONObject4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeString(this.name);
            parcel.writeString(this.pic);
            parcel.writeString(this.nid);
            parcel.writeString(this.roomId);
            parcel.writeInt(this.audienceCount);
            parcel.writeInt(this.liveStatus);
            parcel.writeLong(this.startTime);
            parcel.writeLong(this.endTime);
            parcel.writeParcelable(this.hostInfo, i);
            parcel.writeParcelable(this.leftLabel, i);
            parcel.writeInt(this.bannerType);
            parcel.writeParcelable(this.statInfo, i);
            parcel.writeInt(this.position);
            parcel.writeByte(this.needLogShow ? (byte) 1 : (byte) 0);
        }
    }

    public LiveBannerEntity(Parcel parcel) {
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
        this.needLogShow = true;
        this.name = parcel.readString();
        this.pic = parcel.readString();
        this.nid = parcel.readString();
        this.roomId = parcel.readString();
        this.audienceCount = parcel.readInt();
        this.liveStatus = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.hostInfo = (LiveHostInfo) parcel.readParcelable(LiveHostInfo.class.getClassLoader());
        this.leftLabel = (LeftLableInfo) parcel.readParcelable(LeftLableInfo.class.getClassLoader());
        this.bannerType = parcel.readInt();
        this.statInfo = (LiveStatInfo) parcel.readParcelable(LiveStatInfo.class.getClassLoader());
        this.position = parcel.readInt();
        this.needLogShow = parcel.readByte() != 0;
    }
}
