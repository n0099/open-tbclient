package com.baidu.searchbox.track.ui;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes2.dex */
public class TrackUI {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SEPERATOR = "\t";
    public static final String SEPERATOR_ARROR = "->";
    public static SimpleDateFormat simpleDateFormat;
    public transient /* synthetic */ FieldHolder $fh;
    public String mActivityPage;
    public String mActivityPageTag;
    public String mEvent;
    public String mFragmentPage;
    public String mFragmentPageTag;
    public String mPageName;
    public String mPageTag;
    public long mTimeStamp;
    public String mType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-978428487, "Lcom/baidu/searchbox/track/ui/TrackUI;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-978428487, "Lcom/baidu/searchbox/track/ui/TrackUI;");
                return;
            }
        }
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");
    }

    public TrackUI(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, long j, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Long.valueOf(j), str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mActivityPage = str;
        this.mActivityPageTag = str2;
        this.mFragmentPage = str3;
        this.mFragmentPageTag = str4;
        this.mTimeStamp = j;
        this.mEvent = str5;
    }

    public static String getTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? simpleDateFormat.format(new Date(j)) : (String) invokeJ.objValue;
    }

    @Nullable
    public static String[] parse(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (split = str.split("\t")) == null || split.length != 4) {
                return null;
            }
            return split;
        }
        return (String[]) invokeL.objValue;
    }

    public String getActivityPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mActivityPage : (String) invokeV.objValue;
    }

    public String getActivityPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mActivityPageTag : (String) invokeV.objValue;
    }

    public String getEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEvent : (String) invokeV.objValue;
    }

    public String getFragmentPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFragmentPage : (String) invokeV.objValue;
    }

    public String getFragmentPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFragmentPageTag : (String) invokeV.objValue;
    }

    public String getPageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPageName : (String) invokeV.objValue;
    }

    public String getPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPageTag : (String) invokeV.objValue;
    }

    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTimeStamp : invokeV.longValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mType : (String) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder(getTime(this.mTimeStamp));
            sb.append("\t");
            sb.append(this.mTimeStamp);
            sb.append("\t");
            sb.append(this.mActivityPage);
            sb.append(this.mActivityPageTag);
            if (!TextUtils.isEmpty(this.mFragmentPage)) {
                sb.append("->");
                sb.append(this.mFragmentPage);
                if (!TextUtils.isEmpty(this.mFragmentPageTag)) {
                    sb.append(this.mFragmentPageTag);
                }
            }
            sb.append("\t");
            sb.append(this.mEvent);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public String toStringPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.mActivityPage)) {
                sb.append(this.mActivityPage);
                sb.append(this.mActivityPageTag);
            }
            if (!TextUtils.isEmpty(this.mFragmentPage)) {
                sb.append("->");
                sb.append(this.mFragmentPage);
                sb.append(this.mFragmentPageTag);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public TrackUI(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j, @NonNull String str8) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7, Long.valueOf(j), str8};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mActivityPage = str;
        this.mActivityPageTag = str2;
        this.mFragmentPage = str3;
        this.mFragmentPageTag = str4;
        this.mPageName = str5;
        this.mPageTag = str6;
        this.mType = str7;
        this.mTimeStamp = j;
        this.mEvent = str8;
    }
}
