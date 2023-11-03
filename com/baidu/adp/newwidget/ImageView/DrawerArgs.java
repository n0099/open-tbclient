package com.baidu.adp.newwidget.ImageView;

import android.graphics.Matrix;
import com.baidu.tieba.rf;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DrawerArgs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public SkinType f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public float k;
    public Matrix l;
    public int m;
    public boolean n;
    public boolean o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class SkinType {
        public static final /* synthetic */ SkinType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SkinType DARK;
        public static final SkinType DAY;
        public static final SkinType NIGHT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1994085880, "Lcom/baidu/adp/newwidget/ImageView/DrawerArgs$SkinType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1994085880, "Lcom/baidu/adp/newwidget/ImageView/DrawerArgs$SkinType;");
                    return;
                }
            }
            DAY = new SkinType("DAY", 0);
            NIGHT = new SkinType("NIGHT", 1);
            SkinType skinType = new SkinType("DARK", 2);
            DARK = skinType;
            $VALUES = new SkinType[]{DAY, NIGHT, skinType};
        }

        public SkinType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SkinType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (SkinType) Enum.valueOf(SkinType.class, str);
            }
            return (SkinType) invokeL.objValue;
        }

        public static SkinType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (SkinType[]) $VALUES.clone();
            }
            return (SkinType[]) invokeV.objValue;
        }
    }

    public DrawerArgs() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new float[8];
        this.f = SkinType.DAY;
        this.h = false;
        this.i = true;
        this.j = rf.a;
        this.k = 1.0f;
        this.o = false;
    }
}
