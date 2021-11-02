package com.baidu.mobads.container.landingpage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class XAdRemoteLandingPageExtraInfo extends XAdRemoteCommandExtraInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<XAdRemoteLandingPageExtraInfo> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int e75;
    public int from;
    public boolean isFullScreen;
    public String lpMurl;
    public String lpStyle;
    public String mLpMultiProcess;
    public int orientation;
    public int os;
    public String prodType;
    public String sn;
    public String title;
    public String v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1206363210, "Lcom/baidu/mobads/container/landingpage/XAdRemoteLandingPageExtraInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1206363210, "Lcom/baidu/mobads/container/landingpage/XAdRemoteLandingPageExtraInfo;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<XAdRemoteLandingPageExtraInfo>() { // from class: com.baidu.mobads.container.landingpage.XAdRemoteLandingPageExtraInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public XAdRemoteLandingPageExtraInfo createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new XAdRemoteLandingPageExtraInfo(parcel) : (XAdRemoteLandingPageExtraInfo) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public XAdRemoteLandingPageExtraInfo[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new XAdRemoteLandingPageExtraInfo[i2] : (XAdRemoteLandingPageExtraInfo[]) invokeI.objValue;
            }
        };
    }

    public String getCompositeV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "android_9.042_4.0.0" : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.landingpage.XAdRemoteCommandExtraInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.url);
            parcel.writeByte(this.isFullScreen ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.orientation);
            parcel.writeInt(this.e75);
            parcel.writeInt(this.from);
            parcel.writeString(this.adid);
            parcel.writeString(this.qk);
            parcel.writeString(this.packageNameOfPubliser);
            parcel.writeString(this.appsid);
            parcel.writeString(this.appsec);
            parcel.writeInt(1);
            parcel.writeString(this.mProdType);
            parcel.writeString(getCompositeV());
            String str = TextUtils.isEmpty(this.title) ? "" : this.title;
            this.title = str;
            parcel.writeString(str);
            parcel.writeString(this.lpStyle);
            parcel.writeString(this.lpMurl);
            parcel.writeString(this.mLpMultiProcess);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdRemoteLandingPageExtraInfo(String str, XAdInstanceInfoExt xAdInstanceInfoExt) {
        super(str, xAdInstanceInfoExt);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, xAdInstanceInfoExt};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (XAdInstanceInfoExt) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
        this.lpStyle = "";
        this.lpMurl = "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XAdRemoteLandingPageExtraInfo(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isFullScreen = false;
        this.orientation = 1;
        this.e75 = 1;
        this.from = 0;
        this.os = 1;
        this.lpStyle = "";
        this.lpMurl = "";
        this.url = parcel.readString();
        this.isFullScreen = parcel.readByte() != 0;
        this.orientation = parcel.readInt();
        this.e75 = parcel.readInt();
        this.from = parcel.readInt();
        this.adid = parcel.readString();
        this.qk = parcel.readString();
        this.packageNameOfPubliser = parcel.readString();
        this.appsid = parcel.readString();
        this.appsec = parcel.readString();
        this.os = parcel.readInt();
        this.prodType = parcel.readString();
        this.v = parcel.readString();
        this.title = parcel.readString();
        this.lpStyle = parcel.readString();
        this.lpMurl = parcel.readString();
        this.mLpMultiProcess = parcel.readString();
    }
}
