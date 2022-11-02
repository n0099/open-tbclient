package com.baidu.live.business.model.data;

import android.os.Parcel;
import android.os.Parcelable;
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
public class LiveTabEntity implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<LiveTabEntity> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String channelId;
    public int id;
    public String name;
    public boolean selected;
    public List<TabLabelInfo> subTabList;
    public String type;

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
    public static class TabLabelInfo implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<TabLabelInfo> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public String name;
        public boolean selected;
        public String type;

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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2145992945, "Lcom/baidu/live/business/model/data/LiveTabEntity$TabLabelInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2145992945, "Lcom/baidu/live/business/model/data/LiveTabEntity$TabLabelInfo;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<TabLabelInfo>() { // from class: com.baidu.live.business.model.data.LiveTabEntity.TabLabelInfo.1
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
                public TabLabelInfo createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new TabLabelInfo(parcel);
                    }
                    return (TabLabelInfo) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public TabLabelInfo[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new TabLabelInfo[i];
                    }
                    return (TabLabelInfo[]) invokeI.objValue;
                }
            };
        }

        public TabLabelInfo() {
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

        public TabLabelInfo(Parcel parcel) {
            boolean z;
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
            this.id = parcel.readInt();
            this.type = parcel.readString();
            this.name = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.selected = z;
        }

        public void parserJson(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
                return;
            }
            this.id = jSONObject.optInt("id");
            this.type = jSONObject.optString("type");
            this.name = jSONObject.optString("name");
            this.selected = jSONObject.optBoolean("selected");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
                parcel.writeInt(this.id);
                parcel.writeString(this.type);
                parcel.writeString(this.name);
                parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(202119764, "Lcom/baidu/live/business/model/data/LiveTabEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(202119764, "Lcom/baidu/live/business/model/data/LiveTabEntity;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<LiveTabEntity>() { // from class: com.baidu.live.business.model.data.LiveTabEntity.1
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
            public LiveTabEntity createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new LiveTabEntity(parcel);
                }
                return (LiveTabEntity) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LiveTabEntity[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new LiveTabEntity[i];
                }
                return (LiveTabEntity[]) invokeI.objValue;
            }
        };
    }

    public LiveTabEntity() {
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

    public LiveTabEntity(Parcel parcel) {
        boolean z;
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
        this.id = parcel.readInt();
        this.type = parcel.readString();
        this.channelId = parcel.readString();
        this.name = parcel.readString();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.selected = z;
        this.subTabList = parcel.createTypedArrayList(TabLabelInfo.CREATOR);
    }

    public void parserJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        this.id = jSONObject.optInt("id");
        this.type = jSONObject.optString("type");
        this.channelId = jSONObject.optString("channel_id");
        this.name = jSONObject.optString("name");
        this.selected = jSONObject.optBoolean("selected");
        JSONArray optJSONArray = jSONObject.optJSONArray("tab_list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.subTabList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    TabLabelInfo tabLabelInfo = new TabLabelInfo();
                    tabLabelInfo.parserJson(optJSONObject);
                    this.subTabList.add(tabLabelInfo);
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeInt(this.id);
            parcel.writeString(this.type);
            parcel.writeString(this.channelId);
            parcel.writeString(this.name);
            parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
            parcel.writeTypedList(this.subTabList);
        }
    }
}
