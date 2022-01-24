package com.baidu.ar.lua;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LuaMsgListener cc;

    /* renamed from: f  reason: collision with root package name */
    public b f32865f;
    public c rN;
    public DefinedLuaListener sX;

    public e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bVar == null) {
            return;
        }
        this.f32865f = bVar;
        fl();
        if (this.cc == null) {
            this.cc = new LuaMsgListener(this) { // from class: com.baidu.ar.lua.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e sY;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.sY = this;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Arrays.asList("id", "event_name") : (List) invokeV.objValue;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) || this.sY.sX == null || this.sY.j(hashMap)) {
                        return;
                    }
                    this.sY.k(hashMap);
                }
            };
        }
        if (bVar.fk() != null) {
            bVar.fk().addLuaMsgListener(this.cc);
        }
    }

    private void fl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            c cVar = new c(this) { // from class: com.baidu.ar.lua.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e sY;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.sY = this;
                }

                @Override // com.baidu.ar.lua.c
                public void a(int i2, int i3, HashMap<String, Object> hashMap) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, hashMap) == null) && i2 == 1301 && this.sY.sX != null) {
                        int intValue = ((Integer) hashMap.get("type")).intValue();
                        this.sY.sX.onOpenUrl((String) hashMap.get("url"), intValue, hashMap);
                    }
                }

                @Override // com.baidu.ar.lua.c
                public List<Integer> n() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Arrays.asList(1301) : (List) invokeV.objValue;
                }
            };
            this.rN = cVar;
            this.f32865f.c(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, hashMap)) == null) {
            String str = (String) hashMap.get("event_name");
            if (TextUtils.isEmpty(str) || !"camera_switch".equals(str)) {
                return false;
            }
            String str2 = (String) hashMap.get("camera_action");
            String str3 = "swichCameraByEvent cameraFace = " + str2;
            if ("front".equals(str2)) {
                this.sX.onRequireSwitchCamera(1);
            } else if (com.alipay.sdk.widget.d.u.equals(str2)) {
                this.sX.onRequireSwitchCamera(0);
            } else {
                this.sX.onRequireSwitchCamera(-1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, hashMap)) == null) {
            int a = com.baidu.ar.arplay.c.c.a(hashMap.get("id"), -1);
            String str = "switchCameraById id = " + a;
            if (a == 10202) {
                this.sX.onRequireSwitchCamera(-1);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b bVar = this.f32865f;
            if (bVar != null) {
                if (this.cc != null) {
                    bVar.fk().removeLuaMsgListener(this.cc);
                    this.cc = null;
                }
                c cVar = this.rN;
                if (cVar != null) {
                    this.f32865f.d(cVar);
                    this.rN = null;
                }
                this.f32865f = null;
            }
            this.sX = null;
        }
    }

    public void setDefinedLuaListener(DefinedLuaListener definedLuaListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, definedLuaListener) == null) {
            this.sX = definedLuaListener;
        }
    }
}
