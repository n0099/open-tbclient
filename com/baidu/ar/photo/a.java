package com.baidu.ar.photo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.renderer.TakePictureCallback;
import com.baidu.ar.arrender.l;
import com.baidu.ar.h.i;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class a implements TakePictureCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String tB;
    public PhotoCallback tC;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(l lVar, String str, PhotoCallback photoCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, lVar, str, photoCallback) == null) || lVar == null || TextUtils.isEmpty(str) || photoCallback == null) {
            return;
        }
        this.tB = str;
        this.tC = photoCallback;
        lVar.a(this);
    }

    @Override // com.baidu.ar.arplay.core.renderer.TakePictureCallback
    public void onPictureTake(boolean z, Bitmap bitmap, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), bitmap, Long.valueOf(j)}) == null) || this.tC == null || TextUtils.isEmpty(this.tB)) {
            return;
        }
        i.d(new File(this.tB));
        i.a(this.tB, bitmap, 100);
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.tC.onPictureTake(z, this.tB);
    }
}
