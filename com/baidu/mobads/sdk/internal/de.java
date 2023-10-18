package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class de implements ViewTreeObserver.OnWindowFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ RelativeLayout a;
    public final /* synthetic */ da b;

    public de(da daVar, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {daVar, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = daVar;
        this.a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.b.h);
            hashMap.put("banner_container", this.a);
            hashMap.put("entry", Integer.valueOf(this.b.D));
            hashMap.put("channelId", Integer.valueOf(this.b.E));
            hashMap.put("novel_id", this.b.F);
            hashMap.put("isnight", Boolean.valueOf(this.b.x()));
            this.b.a(da.u, hashMap);
        }
    }
}
