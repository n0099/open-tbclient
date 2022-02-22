package com.baidu.adp.newwidget.ImageView;

import android.graphics.Matrix;
import c.a.d.h.a.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DrawerArgs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31435b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31436c;

    /* renamed from: d  reason: collision with root package name */
    public int f31437d;

    /* renamed from: e  reason: collision with root package name */
    public int f31438e;

    /* renamed from: f  reason: collision with root package name */
    public SkinType f31439f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31440g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31441h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f31442i;

    /* renamed from: j  reason: collision with root package name */
    public int f31443j;
    public float k;
    public Matrix l;
    public int m;
    public boolean n;
    public boolean o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

        public SkinType(String str, int i2) {
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

        public static SkinType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SkinType) Enum.valueOf(SkinType.class, str) : (SkinType) invokeL.objValue;
        }

        public static SkinType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SkinType[]) $VALUES.clone() : (SkinType[]) invokeV.objValue;
        }
    }

    public DrawerArgs() {
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
        this.a = new float[8];
        this.f31439f = SkinType.DAY;
        this.f31441h = false;
        this.f31442i = true;
        this.f31443j = b.a;
        this.k = 1.0f;
        this.o = false;
    }
}
