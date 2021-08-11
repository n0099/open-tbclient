package com.baidu.tbadk.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import c.a.e.k.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class TransmitForumData implements n, Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<TransmitForumData> CREATOR;
    public static final BdUniqueId ID_TRANSMIT_SELECT_DATA;
    public static final int TYPE_RECOMMEND = 1;
    public static final int TYPE_SELF_SELECT = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public boolean checked;
    public long forumId;
    public String forumName;
    public boolean isCurForum;
    public ArrayList<FrsTabItemData> tabItemDatas;
    public int type;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<TransmitForumData> {
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
        public TransmitForumData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new TransmitForumData(parcel) : (TransmitForumData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TransmitForumData[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new TransmitForumData[i2] : (TransmitForumData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(406245944, "Lcom/baidu/tbadk/core/data/TransmitForumData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(406245944, "Lcom/baidu/tbadk/core/data/TransmitForumData;");
                return;
            }
        }
        ID_TRANSMIT_SELECT_DATA = BdUniqueId.gen();
        CREATOR = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransmitForumData(long j2, String str, boolean z, int i2) {
        this(j2, str, z, i2, "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), str, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue(), (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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

    @Override // c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ID_TRANSMIT_SELECT_DATA : (BdUniqueId) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            parcel.writeString(this.forumName);
            parcel.writeLong(this.forumId);
            parcel.writeByte(this.checked ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.type);
            parcel.writeString(this.avatar);
            parcel.writeByte(this.isCurForum ? (byte) 1 : (byte) 0);
            parcel.writeArray(this.tabItemDatas.toArray());
        }
    }

    public TransmitForumData(long j2, String str, boolean z, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), str, Boolean.valueOf(z), Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.isCurForum = false;
        this.forumName = str;
        this.checked = z;
        this.forumId = j2;
        this.type = i2;
        this.avatar = str2;
    }

    public TransmitForumData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.isCurForum = false;
        this.forumName = parcel.readString();
        this.forumId = parcel.readLong();
        this.checked = parcel.readByte() != 0;
        this.type = parcel.readInt();
        this.avatar = parcel.readString();
        this.isCurForum = parcel.readByte() != 0;
        this.tabItemDatas = parcel.readArrayList(FrsTabItemData.class.getClassLoader());
    }
}
