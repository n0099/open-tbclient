package com.baidu.live.business.view.banner;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveBannerEntity;
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
public class BannerEntity implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BannerEntity> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String bannerId;
    public boolean hasPreLoad;
    public List<LiveBannerEntity> mBannerList;
    public double mBannerWH;
    public int mBroadcastInterval;
    public String mLogExt;
    public int mSelected;

    /* loaded from: classes10.dex */
    public class a implements Parcelable.Creator<BannerEntity> {
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
        public BannerEntity createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new BannerEntity(parcel) : (BannerEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BannerEntity[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new BannerEntity[i2] : (BannerEntity[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1271417095, "Lcom/baidu/live/business/view/banner/BannerEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1271417095, "Lcom/baidu/live/business/view/banner/BannerEntity;");
                return;
            }
        }
        CREATOR = new a();
    }

    public BannerEntity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSelected = 0;
        this.mBannerList = new ArrayList();
        this.mBroadcastInterval = 1000;
    }

    public static BannerEntity parseBannerEntity(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.bannerId = jSONObject.optString("banner_id", "1234567890");
            bannerEntity.mBannerWH = jSONObject.optDouble("banner_wh", 5.223d);
            try {
                bannerEntity.mBroadcastInterval = Integer.parseInt(jSONObject.getString("broadcast_interval")) * 1000;
            } catch (Exception e2) {
                bannerEntity.mBroadcastInterval = 1000;
                e2.printStackTrace();
            }
            JSONArray jSONArray = jSONObject.getJSONArray("banner_list");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                liveBannerEntity.parserJson(jSONObject2);
                bannerEntity.mBannerList.add(liveBannerEntity);
            }
            bannerEntity.mSelected = bannerEntity.mBannerList.size() * 1000;
            bannerEntity.mLogExt = jSONObject.optString("log_ext", StringUtil.EMPTY_ARRAY);
            return bannerEntity;
        }
        return (BannerEntity) invokeL.objValue;
    }

    public static BannerEntity parseMineBannerEntity(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.bannerId = jSONObject.optString("banner_id", "1234567890");
            bannerEntity.mBannerWH = jSONObject.optDouble("banner_wh", 5.223d);
            try {
                bannerEntity.mBroadcastInterval = Integer.parseInt(jSONObject.getString("broadcast_interval")) * 1000;
            } catch (Exception e2) {
                bannerEntity.mBroadcastInterval = 1000;
                e2.printStackTrace();
            }
            JSONArray jSONArray = jSONObject.getJSONArray("banner_list");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                LiveBannerEntity liveBannerEntity = new LiveBannerEntity();
                liveBannerEntity.parserJson(jSONObject2);
                bannerEntity.mBannerList.add(liveBannerEntity);
            }
            bannerEntity.mSelected = bannerEntity.mBannerList.size() * 1000;
            bannerEntity.mLogExt = jSONObject.optString("log_ext", StringUtil.EMPTY_ARRAY);
            return bannerEntity;
        }
        return (BannerEntity) invokeL.objValue;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
            parcel.writeInt(this.mSelected);
            parcel.writeList(this.mBannerList);
            parcel.writeInt(this.mBroadcastInterval);
            parcel.writeString(this.mLogExt);
            parcel.writeString(this.bannerId);
            parcel.writeDouble(this.mBannerWH);
        }
    }

    public BannerEntity(Parcel parcel) {
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
        this.mSelected = 0;
        this.mBannerList = new ArrayList();
        this.mBroadcastInterval = 1000;
        this.mSelected = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        this.mBannerList = arrayList;
        parcel.readList(arrayList, LiveBannerEntity.class.getClassLoader());
        this.mBroadcastInterval = parcel.readInt();
        this.mLogExt = parcel.readString();
        this.bannerId = parcel.readString();
        this.mBannerWH = parcel.readDouble();
    }
}
