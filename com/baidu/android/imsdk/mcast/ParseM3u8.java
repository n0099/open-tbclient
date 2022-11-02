package com.baidu.android.imsdk.mcast;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ParseM3u8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ParseM3u8";
    public transient /* synthetic */ FieldHolder $fh;
    public int mDuration;
    public boolean mIsend;
    public ArrayList<TS> mTslist;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1841970295, "Lcom/baidu/android/imsdk/mcast/ParseM3u8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1841970295, "Lcom/baidu/android/imsdk/mcast/ParseM3u8;");
        }
    }

    /* loaded from: classes.dex */
    public class TS {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double duration;
        public long relativetime;
        public String stime;
        public final /* synthetic */ ParseM3u8 this$0;
        public long time;
        public String tsfile;

        public TS(ParseM3u8 parseM3u8) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parseM3u8};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = parseM3u8;
        }
    }

    public ParseM3u8() {
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
        this.mTslist = new ArrayList<>();
        this.mIsend = false;
    }

    public long getMaxTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mTslist.size() > 0) {
                ArrayList<TS> arrayList = this.mTslist;
                return arrayList.get(arrayList.size() - 1).time;
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public int getTsSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mTslist.size();
        }
        return invokeV.intValue;
    }

    public ArrayList<TS> getTslist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTslist;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mIsend;
        }
        return invokeV.booleanValue;
    }

    public static long dateToLong(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, date)) == null) {
            return date.getTime();
        }
        return invokeL.longValue;
    }

    private void parseTSattr(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, str2, str3) == null) {
            String str4 = TAG;
            LogUtils.d(str4, "parseTSline attr:   " + str + GlideException.IndentedAppendable.INDENT + str2 + GlideException.IndentedAppendable.INDENT + str3);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                TS ts = new TS(this);
                String trim = str.substring(str.indexOf(":") + 1).replace(ExifInterface.GPS_DIRECTION_TRUE, " ").trim();
                ts.stime = trim;
                if (trim.length() >= 20) {
                    try {
                        ts.time = stringToLong(trim.substring(0, 19), "yyyy-MM-dd HH:mm:ss");
                    } catch (ParseException e) {
                        e.printStackTrace();
                        LogUtils.e(TAG, "stringToLong execption");
                    }
                    int indexOf = str2.indexOf(":") + 1;
                    if (str2.length() > indexOf) {
                        String replace = str2.substring(indexOf).trim().replace(",", "");
                        try {
                            ts.duration = Double.valueOf(replace).doubleValue();
                        } catch (Exception unused) {
                            String str5 = TAG;
                            LogUtils.e(str5, " String to double execption " + replace);
                        }
                        ts.tsfile = str3.trim();
                        String str6 = TAG;
                        LogUtils.d(str6, " parseTSline: " + ts.tsfile);
                        if (this.mTslist.size() == 0) {
                            ts.relativetime = 0L;
                        } else {
                            ts.relativetime = (ts.time - this.mTslist.get(0).time) / 1000;
                        }
                        String str7 = TAG;
                        LogUtils.d(str7, "  parseTSline attr:   " + ts.time + " " + ts.relativetime + GlideException.IndentedAppendable.INDENT + ts.duration + GlideException.IndentedAppendable.INDENT + str3);
                        this.mTslist.add(ts);
                        return;
                    }
                    LogUtils.e(TAG, "parseTSattr exception 2.");
                    return;
                }
                LogUtils.e(TAG, "parseTSattr exception 2.");
            }
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public static Date stringToDate(String str, String str2) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            return new SimpleDateFormat(str2).parse(str);
        }
        return (Date) invokeLL.objValue;
    }

    public static long stringToLong(String str, String str2) throws ParseException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            Date stringToDate = stringToDate(str, str2);
            if (stringToDate == null) {
                return 0L;
            }
            return dateToLong(stringToDate);
        }
        return invokeLL.longValue;
    }

    public List<TS> getLatestTS(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            Iterator<TS> it = this.mTslist.iterator();
            int i = -1;
            while (true) {
                if (it.hasNext()) {
                    i++;
                    if (it.next().time == j) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z && this.mTslist.size() > i) {
                ArrayList<TS> arrayList = this.mTslist;
                return arrayList.subList(i, arrayList.size());
            }
            return null;
        }
        return (List) invokeJ.objValue;
    }

    public List<TS> getNewAppendTS(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            Iterator<TS> it = this.mTslist.iterator();
            boolean z = false;
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i++;
                if (it.next().time == j) {
                    z = true;
                    break;
                }
            }
            if (z && this.mTslist.size() > i) {
                ArrayList<TS> arrayList = this.mTslist;
                return arrayList.subList(i, arrayList.size());
            }
            return null;
        }
        return (List) invokeJ.objValue;
    }

    public List<TS> getTslist(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            Iterator<TS> it = this.mTslist.iterator();
            int i2 = -1;
            while (true) {
                if (it.hasNext()) {
                    i2++;
                    if (it.next().relativetime >= i) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                ArrayList<TS> arrayList = this.mTslist;
                return arrayList.subList(i2, arrayList.size());
            }
            return null;
        }
        return (List) invokeI.objValue;
    }

    public void readByte(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.matches("#EXT-X-TARGETDURATION(.*)")) {
                        String[] split = readLine.split(":");
                        if (split.length == 2) {
                            try {
                                this.mDuration = Integer.valueOf(split[1]).intValue();
                            } catch (NumberFormatException unused) {
                                this.mDuration = 0;
                            }
                        }
                    } else if (readLine.matches("#EXT-X-PROGRAM-DATE-TIME(.*)")) {
                        parseTSattr(readLine, bufferedReader.readLine(), bufferedReader.readLine());
                    } else if (readLine.matches("#EXT-X-ENDLIST(.*)")) {
                        this.mIsend = true;
                    }
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    byteArrayInputStream.close();
                    return;
                }
            }
        }
    }
}
