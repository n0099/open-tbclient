package com.baidu.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Configuration implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static Parcelable.Creator<Configuration> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAlpha;
    public boolean mAutoDismiss;
    public int mEnterAnimationId;
    public int mExitAnimationId;
    public int mFullingColorId;
    public int mFullingViewId;
    public boolean mOutsideTouchable;
    public boolean mOverlayTarget;
    public boolean mShowCloseButton;
    public View mTargetView;
    public int mTargetViewId;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<Configuration> {
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
        public Configuration createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                Configuration configuration = new Configuration();
                configuration.mAlpha = parcel.readInt();
                configuration.mFullingViewId = parcel.readInt();
                configuration.mTargetViewId = parcel.readInt();
                configuration.mFullingColorId = parcel.readInt();
                configuration.mAutoDismiss = parcel.readByte() == 1;
                configuration.mOverlayTarget = parcel.readByte() == 1;
                return configuration;
            }
            return (Configuration) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Configuration[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new Configuration[i] : (Configuration[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(59171858, "Lcom/baidu/adp/lib/guide/Configuration;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(59171858, "Lcom/baidu/adp/lib/guide/Configuration;");
                return;
            }
        }
        CREATOR = new a();
    }

    public Configuration() {
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
        this.mTargetView = null;
        this.mAlpha = 255;
        this.mFullingViewId = -1;
        this.mTargetViewId = -1;
        this.mFullingColorId = 17170444;
        this.mAutoDismiss = true;
        this.mOverlayTarget = false;
        this.mShowCloseButton = false;
        this.mEnterAnimationId = -1;
        this.mExitAnimationId = -1;
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
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            parcel.writeInt(this.mAlpha);
            parcel.writeInt(this.mFullingViewId);
            parcel.writeInt(this.mTargetViewId);
            parcel.writeInt(this.mFullingColorId);
            parcel.writeByte(this.mAutoDismiss ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mOverlayTarget ? (byte) 1 : (byte) 0);
        }
    }
}
