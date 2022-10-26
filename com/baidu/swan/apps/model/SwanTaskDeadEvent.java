package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanTaskDeadEvent implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator CREATOR;
    public static final char SEPARATOR = '#';
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public SparseArray historyCache;
    public String pageScheme;
    public ArrayList stackList;
    public int taskId;

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
    public final class a implements Parcelable.Creator {
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
        public SwanTaskDeadEvent createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new SwanTaskDeadEvent(parcel);
            }
            return (SwanTaskDeadEvent) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanTaskDeadEvent[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new SwanTaskDeadEvent[i];
            }
            return (SwanTaskDeadEvent[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2018881294, "Lcom/baidu/swan/apps/model/SwanTaskDeadEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2018881294, "Lcom/baidu/swan/apps/model/SwanTaskDeadEvent;");
                return;
            }
        }
        CREATOR = new a();
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.appId;
        }
        return (String) invokeV.objValue;
    }

    public String getPageScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.pageScheme;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList getStackList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.stackList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.taskId;
        }
        return invokeV.intValue;
    }

    public SwanTaskDeadEvent(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.appId = parcel.readString();
        this.taskId = parcel.readInt();
        this.pageScheme = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.stackList = arrayList;
        parcel.readList(arrayList, Integer.class.getClassLoader());
        this.historyCache = parcel.readSparseArray(String[].class.getClassLoader());
    }

    public static SwanTaskDeadEvent restoreObject(String[] strArr) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                ArrayList arrayList = new ArrayList();
                if (strArr[2] != null) {
                    for (String str : strArr[2].split(String.valueOf('#'))) {
                        if (str != null && TextUtils.isDigitsOnly(str)) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    }
                }
                return new SwanTaskDeadEvent(strArr[0], -1, strArr[1], arrayList);
            }
            return null;
        }
        return (SwanTaskDeadEvent) invokeL.objValue;
    }

    public SwanTaskDeadEvent(String str, int i, String str2, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, arrayList};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.appId = str;
        this.taskId = i;
        this.pageScheme = str2;
        this.stackList = arrayList;
    }

    private String[] transformToArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = this.stackList;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append(this.stackList.get(i));
                    if (i < size - 1) {
                        sb.append('#');
                    }
                }
            }
            return new String[]{getAppId(), getPageScheme(), sb.toString()};
        }
        return (String[]) invokeV.objValue;
    }

    public SparseArray getHistoryCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.historyCache == null) {
                return null;
            }
            SparseArray sparseArray = new SparseArray();
            for (int i = 0; i < this.historyCache.size(); i++) {
                sparseArray.put(this.historyCache.keyAt(i), restoreObject((String[]) this.historyCache.valueAt(i)));
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void setHistoryCache(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sparseArray) == null) {
            SparseArray sparseArray2 = new SparseArray();
            if (sparseArray != null) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    if (sparseArray.valueAt(i) != null) {
                        sparseArray2.put(sparseArray.keyAt(i), ((SwanTaskDeadEvent) sparseArray.valueAt(i)).transformToArray());
                    }
                }
            }
            this.historyCache = sparseArray2;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.taskId);
            parcel.writeString(this.pageScheme);
            parcel.writeList(this.stackList);
            parcel.writeSparseArray(this.historyCache);
        }
    }
}
