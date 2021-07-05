package com.baidu.swan.apps.performance;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UbcFlowEvent {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11204g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f11205a;

    /* renamed from: b  reason: collision with root package name */
    public long f11206b;

    /* renamed from: c  reason: collision with root package name */
    public String f11207c;

    /* renamed from: d  reason: collision with root package name */
    public String f11208d;

    /* renamed from: e  reason: collision with root package name */
    public RecordType f11209e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11210f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class RecordType {
        public static final /* synthetic */ RecordType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RecordType KEEP;
        public static final RecordType UPDATE;
        public static final RecordType UPDATE_EARLIER;
        public static final RecordType UPDATE_RECENT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-639910898, "Lcom/baidu/swan/apps/performance/UbcFlowEvent$RecordType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-639910898, "Lcom/baidu/swan/apps/performance/UbcFlowEvent$RecordType;");
                    return;
                }
            }
            KEEP = new RecordType("KEEP", 0);
            UPDATE = new RecordType("UPDATE", 1);
            UPDATE_RECENT = new RecordType("UPDATE_RECENT", 2);
            RecordType recordType = new RecordType("UPDATE_EARLIER", 3);
            UPDATE_EARLIER = recordType;
            $VALUES = new RecordType[]{KEEP, UPDATE, UPDATE_RECENT, recordType};
        }

        public RecordType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RecordType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RecordType) Enum.valueOf(RecordType.class, str) : (RecordType) invokeL.objValue;
        }

        public static RecordType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RecordType[]) $VALUES.clone() : (RecordType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-205841127, "Lcom/baidu/swan/apps/performance/UbcFlowEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-205841127, "Lcom/baidu/swan/apps/performance/UbcFlowEvent;");
                return;
            }
        }
        f11204g = k.f49133a;
    }

    public UbcFlowEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11206b = System.currentTimeMillis();
        this.f11207c = "";
        this.f11208d = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
        this.f11209e = RecordType.KEEP;
        this.f11210f = false;
        this.f11205a = str;
    }

    public UbcFlowEvent a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f11210f = z;
            return this;
        }
        return (UbcFlowEvent) invokeZ.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11210f : invokeV.booleanValue;
    }

    public RecordType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11209e : (RecordType) invokeV.objValue;
    }

    public UbcFlowEvent d(RecordType recordType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, recordType)) == null) {
            this.f11209e = recordType;
            return this;
        }
        return (UbcFlowEvent) invokeL.objValue;
    }

    public UbcFlowEvent e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f11208d = str;
            return this;
        }
        return (UbcFlowEvent) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11208d : (String) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f11206b : invokeV.longValue;
    }

    public UbcFlowEvent h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            if (j < 0) {
                j = 0;
            }
            this.f11206b = j;
            return this;
        }
        return (UbcFlowEvent) invokeJ.objValue;
    }

    public JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f11205a);
                jSONObject.put("value", this.f11207c);
                jSONObject.put("ts", this.f11206b);
            } catch (JSONException e2) {
                if (f11204g) {
                    Log.w("UbcFlowEvent", "UbcFlowEvent to JSON exception", e2);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f11207c : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(g());
            objArr[1] = this.f11205a;
            objArr[2] = b() ? "(justLocalRecord)" : "";
            return String.format(locale, "Event at %d id = %s %s", objArr);
        }
        return (String) invokeV.objValue;
    }
}
