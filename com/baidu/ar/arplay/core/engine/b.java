package com.baidu.ar.arplay.core.engine;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean fA;
    public boolean fB;
    public boolean fC;
    public boolean fD;
    public boolean fE;
    public ARPMessage.MessageHandler fv;
    public boolean fw;
    public boolean fx;
    public boolean fy;
    public boolean fz;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fw = false;
        this.fx = false;
        this.fy = false;
        this.fz = false;
        this.fA = false;
        this.fB = false;
        this.fC = false;
        this.fD = false;
        this.fE = false;
        aV();
    }

    private void aV() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.fv = new ARPMessage.MessageHandler(this) { // from class: com.baidu.ar.arplay.core.engine.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b fF;

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
                    this.fF = this;
                }

                @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
                public void handleMessage(int i2, int i3, HashMap<String, Object> hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, hashMap) == null) || hashMap == null) {
                        return;
                    }
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            this.fF.fw = true;
                        } else {
                            this.fF.fw = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            this.fF.fx = true;
                        } else {
                            this.fF.fx = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            this.fF.fy = true;
                        } else {
                            this.fF.fy = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            this.fF.fz = true;
                        } else {
                            this.fF.fz = false;
                        }
                    }
                    if (hashMap.get("disable_swipe") != null) {
                        if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                            this.fF.fA = true;
                        } else {
                            this.fF.fA = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            this.fF.fB = true;
                        } else {
                            this.fF.fB = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            this.fF.fC = true;
                        } else {
                            this.fF.fC = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            this.fF.fD = true;
                        } else {
                            this.fF.fD = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_rotate") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                            this.fF.fE = true;
                        } else {
                            this.fF.fE = false;
                        }
                    }
                }
            };
        }
    }

    public boolean aW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.fw || this.fx) ? false : true : invokeV.booleanValue;
    }

    public boolean aX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.fw || this.fy) ? false : true : invokeV.booleanValue;
    }

    public boolean aY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.fw || this.fz) ? false : true : invokeV.booleanValue;
    }

    public boolean aZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.fw || this.fB) ? false : true : invokeV.booleanValue;
    }

    public boolean ba() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.fw || this.fC) ? false : true : invokeV.booleanValue;
    }

    public boolean bb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.fw || this.fA) ? false : true : invokeV.booleanValue;
    }

    public boolean bc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.fw || this.fD) ? false : true : invokeV.booleanValue;
    }

    public boolean bd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (this.fw || this.fE) ? false : true : invokeV.booleanValue;
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ARPMessage.getInstance().removeMessageHandeler(this.fv);
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ARPMessage.getInstance().registerMessageHandler(11, this.fv);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.fv = null;
        }
    }
}
