package com.baidu.mobads.container.landingpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class XAdRemoteCommandExtraInfo implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adid;
    public String appsec;
    public String appsid;
    public Boolean autoOpen;
    public boolean autoPlayNonWifi;
    public Boolean canCancel;
    public String canDelete;
    public String iconfrom;
    public XAdInstanceInfoExt mAdInstanceInfo;
    public int mIntTesting4LM;
    public String mProdType;
    public String mStringTesting4LM;
    public boolean noticeDLNonWifi;
    public String packageName;
    public String packageNameOfPubliser;
    public Boolean popNotif;
    public String qk;
    public String sn;
    public String url;
    public String v;

    public XAdRemoteCommandExtraInfo(String str, XAdInstanceInfoExt xAdInstanceInfoExt) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, xAdInstanceInfoExt};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appsec = "";
        this.appsid = "";
        this.packageNameOfPubliser = "";
        this.noticeDLNonWifi = false;
        this.autoPlayNonWifi = true;
        this.adid = "-1";
        this.packageName = "";
        this.qk = "";
        Boolean bool = Boolean.TRUE;
        this.autoOpen = bool;
        this.v = "";
        this.sn = "";
        this.iconfrom = "";
        this.canCancel = bool;
        this.canDelete = "";
        this.popNotif = bool;
        this.mIntTesting4LM = 999;
        this.mStringTesting4LM = "this is the test string";
        this.mProdType = str;
        this.mAdInstanceInfo = xAdInstanceInfoExt;
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

    public IXAdInstanceInfo getAdInstanceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAdInstanceInfo : (IXAdInstanceInfo) invokeV.objValue;
    }

    public Boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Boolean.valueOf("-1".equalsIgnoreCase(this.adid)) : (Boolean) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeParcelable(this.mAdInstanceInfo, i2);
            parcel.writeString(this.mProdType);
            parcel.writeInt(this.mIntTesting4LM);
            parcel.writeString(this.mStringTesting4LM);
        }
    }

    public XAdRemoteCommandExtraInfo(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.appsec = "";
        this.appsid = "";
        this.packageNameOfPubliser = "";
        this.noticeDLNonWifi = false;
        this.autoPlayNonWifi = true;
        this.adid = "-1";
        this.packageName = "";
        this.qk = "";
        Boolean bool = Boolean.TRUE;
        this.autoOpen = bool;
        this.v = "";
        this.sn = "";
        this.iconfrom = "";
        this.canCancel = bool;
        this.canDelete = "";
        this.popNotif = bool;
        this.mAdInstanceInfo = (XAdInstanceInfoExt) parcel.readParcelable(XAdInstanceInfoExt.class.getClassLoader());
        this.mProdType = parcel.readString();
        this.mIntTesting4LM = parcel.readInt();
        this.mStringTesting4LM = parcel.readString();
    }
}
