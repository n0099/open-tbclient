package com.baidu.live.business.view.banner;

import android.os.Parcel;
import android.os.Parcelable;
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
/* loaded from: classes2.dex */
public class BannerEntity implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BannerEntity> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String bannerId;
    public List<LiveBannerEntity> mBannerList;
    public double mBannerWH;
    public int mBroadcastInterval;
    public String mLogExt;
    public int mSelected;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<BannerEntity> {
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
        public BannerEntity createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new BannerEntity(parcel);
            }
            return (BannerEntity) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BannerEntity[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new BannerEntity[i];
            }
            return (BannerEntity[]) invokeI.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSelected = 0;
        this.mBannerList = new ArrayList();
        this.mBroadcastInterval = 1000;
    }

    public BannerEntity(Parcel parcel) {
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            parcel.writeInt(this.mSelected);
            parcel.writeList(this.mBannerList);
            parcel.writeInt(this.mBroadcastInterval);
            parcel.writeString(this.mLogExt);
            parcel.writeString(this.bannerId);
            parcel.writeDouble(this.mBannerWH);
        }
    }
}
