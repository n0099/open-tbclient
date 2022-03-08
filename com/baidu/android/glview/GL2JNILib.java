package com.baidu.android.glview;

import android.view.Surface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class GL2JNILib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GL2JNILib() {
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

    public static native void close(int i2);

    public static native int create();

    public static native int getSTMatrixHandle(int i2);

    public static native void init(int i2, GL2RenderJNIView gL2RenderJNIView);

    public static native void ratio(int i2, int i3);

    public static native void render(int i2);

    public static native void setSurfaceTex(int i2, Surface surface, int i3);

    public static native void setviewport(int i2, int i3, int i4);

    public static native void stretch(int i2, int i3);

    public static native void transform(int i2, float f2, float f3, float f4, float f5, int i3);
}
