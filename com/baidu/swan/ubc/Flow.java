package com.baidu.swan.ubc;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.ek4;
import com.baidu.tieba.kj4;
import com.baidu.tieba.nf1;
import com.baidu.tieba.rj4;
import com.baidu.tieba.tj4;
import com.baidu.tieba.xj4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes3.dex */
public class Flow implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<Flow> CREATOR;
    public static final boolean DEBUG = false;
    public static final int INVALID_HANDLE = -1;
    public static final String TAG = "UBCFlow";
    public transient /* synthetic */ FieldHolder $fh;
    public int mHandle;
    public String mId;
    public boolean mIsSampled;
    public int mOption;
    public HashMap<String, Slot> mSlotMaps;
    public long mStartTime;
    public rj4 mUbcContext;
    public boolean mValid;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<Flow> {
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
        public Flow createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new Flow(parcel, null);
            }
            return (Flow) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Flow[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new Flow[i];
            }
            return (Flow[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(746337380, "Lcom/baidu/swan/ubc/Flow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(746337380, "Lcom/baidu/swan/ubc/Flow;");
                return;
            }
        }
        CREATOR = new a();
    }

    public int getHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mHandle;
        }
        return invokeV.intValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mId;
        }
        return (String) invokeV.objValue;
    }

    public int getOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mOption;
        }
        return invokeV.intValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mStartTime;
        }
        return invokeV.longValue;
    }

    public boolean getValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mValid;
        }
        return invokeV.booleanValue;
    }

    public boolean isSampled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mIsSampled;
        }
        return invokeV.booleanValue;
    }

    public Flow() {
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
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = kj4.g();
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    public Flow(Parcel parcel) {
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
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = kj4.g();
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mValid = z;
        this.mIsSampled = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public /* synthetic */ Flow(Parcel parcel, a aVar) {
        this(parcel);
    }

    public Flow(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = kj4.g();
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    public final void addEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            addEvent(str, null);
        }
    }

    public void setSampled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsSampled = z;
        }
    }

    public void setValid(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mValid = z;
        }
    }

    public final void addEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || !this.mValid) {
            return;
        }
        if (nf1.g()) {
            if (ek4.a()) {
                tj4.f().m(this.mId, str, this.mHandle, str2, this.mOption);
            }
            rj4 rj4Var = this.mUbcContext;
            if (rj4Var != null && !this.mIsSampled) {
                rj4Var.g(this.mId, str, this.mHandle, str2, this.mOption);
                return;
            }
            return;
        }
        try {
            kj4.f().flowAddEvent(this, str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void addEvent(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j)}) != null) || !this.mValid) {
            return;
        }
        if (nf1.g()) {
            if (ek4.a()) {
                tj4.f().n(this.mId, str, this.mHandle, str2, j, this.mOption);
            }
            rj4 rj4Var = this.mUbcContext;
            if (rj4Var != null && !this.mIsSampled) {
                rj4Var.n(this.mId, str, this.mHandle, str2, j, this.mOption);
                return;
            }
            return;
        }
        try {
            kj4.f().flowAddEventWithTime(this, str, str2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.mValid) {
            return;
        }
        if (nf1.g()) {
            if (ek4.a()) {
                tj4.f().c(this.mId, this.mHandle);
            }
            rj4 rj4Var = this.mUbcContext;
            if (rj4Var != null && !this.mIsSampled) {
                rj4Var.f(this.mId, this.mHandle);
                return;
            }
            return;
        }
        try {
            kj4.f().flowCancel(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void end() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.mValid) {
            return;
        }
        if (nf1.g()) {
            JSONArray jSONArray = new JSONArray();
            HashMap<String, Slot> hashMap = this.mSlotMaps;
            if (hashMap != null && (r1 = hashMap.entrySet().iterator()) != null) {
                for (Map.Entry<String, Slot> entry : hashMap.entrySet()) {
                    Slot value = entry.getValue();
                    if (value.isBegin() && !value.isEnded()) {
                        value.setEnd(System.currentTimeMillis());
                    }
                    JSONObject jSONObject = entry.getValue().getJSONObject();
                    if (jSONObject != null) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (ek4.a()) {
                tj4.f().e(this.mId, this.mHandle, jSONArray);
            }
            rj4 rj4Var = this.mUbcContext;
            if (rj4Var != null && !this.mIsSampled) {
                rj4Var.e(this.mId, this.mHandle, jSONArray);
                return;
            }
            return;
        }
        try {
            kj4.f().flowEnd(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void endSlot(String str) {
        Slot slot;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && this.mValid && !TextUtils.isEmpty(str) && (slot = this.mSlotMaps.get(str)) != null && slot.isBegin()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    public void setValue(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
            }
            setValue(jSONObject.toString());
        }
    }

    public final void setValue(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || !this.mValid) {
            return;
        }
        if (nf1.g()) {
            if (ek4.a()) {
                tj4.f().p(this.mId, this.mHandle, str);
            }
            rj4 rj4Var = this.mUbcContext;
            if (rj4Var != null && !this.mIsSampled) {
                rj4Var.i(this.mId, this.mHandle, str);
                return;
            }
            return;
        }
        try {
            kj4.f().flowSetValue(this, xj4.b(str));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setValueWithDuration(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, str) != null) || !this.mValid) {
            return;
        }
        if (nf1.g()) {
            JSONObject jSONObject = new JSONObject();
            try {
                float currentTimeMillis = ((float) (System.currentTimeMillis() - this.mStartTime)) / 1000.0f;
                if (currentTimeMillis < 0.0f) {
                    currentTimeMillis = 0.0f;
                }
                jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis)));
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    if (jSONObject2.has(DI.APP_INFO_NAME)) {
                        jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2.optJSONObject(DI.APP_INFO_NAME));
                        jSONObject2.remove(DI.APP_INFO_NAME);
                    }
                    jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, jSONObject2.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (ek4.a()) {
                tj4.f().p(this.mId, this.mHandle, jSONObject.toString());
            }
            rj4 rj4Var = this.mUbcContext;
            if (rj4Var != null && !this.mIsSampled) {
                rj4Var.i(this.mId, this.mHandle, jSONObject.toString());
                return;
            }
            return;
        }
        try {
            kj4.f().flowSetValueWithDuration(this, xj4.b(str));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void startSlot(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, jSONObject) == null) && this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.mSlotMaps.get(str);
            if (slot == null) {
                this.mSlotMaps.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.setOption(jSONObject);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, parcel, i) == null) {
            parcel.writeString(this.mId);
            parcel.writeInt(this.mHandle);
            parcel.writeInt(this.mOption);
            parcel.writeLong(this.mStartTime);
            parcel.writeByte(this.mValid ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.mIsSampled ? (byte) 1 : (byte) 0);
            parcel.writeMap(this.mSlotMaps);
        }
    }
}
