package com.baidu.platform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class OverlayItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALIGN_BOTTON = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALING_CENTER = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public GeoPoint a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public Drawable g;
    public String h;
    public CoordType i;
    public float j;
    public float k;
    public ArrayList<Bundle> l;
    public Bundle m;
    public Bundle n;
    public float o;
    public byte[] p;
    public float q;
    public int r;
    public int s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class AnimEffect {
        public static final /* synthetic */ AnimEffect[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AnimEffect ALPHA;
        public static final AnimEffect ANCHOR_GROUTH;
        public static final AnimEffect FADE_IN;
        public static final AnimEffect FADE_OUT;
        public static final AnimEffect GROWTH;
        public static final AnimEffect GROWTH_FADE_IN;
        public static final AnimEffect GROWTH_REBOUND;
        public static final AnimEffect NONE;
        public static final AnimEffect ROTATE;
        public static final AnimEffect SHRINK;
        public static final AnimEffect SHRINK_FADE_OUT;
        public static final AnimEffect WAVE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2141343005, "Lcom/baidu/platform/comapi/map/OverlayItem$AnimEffect;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2141343005, "Lcom/baidu/platform/comapi/map/OverlayItem$AnimEffect;");
                    return;
                }
            }
            NONE = new AnimEffect(HlsPlaylistParser.METHOD_NONE, 0);
            GROWTH = new AnimEffect("GROWTH", 1);
            WAVE = new AnimEffect("WAVE", 2);
            SHRINK = new AnimEffect("SHRINK", 3);
            FADE_OUT = new AnimEffect("FADE_OUT", 4);
            FADE_IN = new AnimEffect("FADE_IN", 5);
            GROWTH_FADE_IN = new AnimEffect("GROWTH_FADE_IN", 6);
            SHRINK_FADE_OUT = new AnimEffect("SHRINK_FADE_OUT", 7);
            GROWTH_REBOUND = new AnimEffect("GROWTH_REBOUND", 8);
            ALPHA = new AnimEffect("ALPHA", 9);
            ANCHOR_GROUTH = new AnimEffect("ANCHOR_GROUTH", 10);
            AnimEffect animEffect = new AnimEffect("ROTATE", 11);
            ROTATE = animEffect;
            $VALUES = new AnimEffect[]{NONE, GROWTH, WAVE, SHRINK, FADE_OUT, FADE_IN, GROWTH_FADE_IN, SHRINK_FADE_OUT, GROWTH_REBOUND, ALPHA, ANCHOR_GROUTH, animEffect};
        }

        public AnimEffect(String str, int i) {
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

        public static AnimEffect valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AnimEffect) Enum.valueOf(AnimEffect.class, str);
            }
            return (AnimEffect) invokeL.objValue;
        }

        public static AnimEffect[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AnimEffect[]) $VALUES.clone();
            }
            return (AnimEffect[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class AnimationSubType {
        public static final /* synthetic */ AnimationSubType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AnimationSubType NONE;
        public static final AnimationSubType RADAR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1791510057, "Lcom/baidu/platform/comapi/map/OverlayItem$AnimationSubType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1791510057, "Lcom/baidu/platform/comapi/map/OverlayItem$AnimationSubType;");
                    return;
                }
            }
            NONE = new AnimationSubType(HlsPlaylistParser.METHOD_NONE, 0);
            AnimationSubType animationSubType = new AnimationSubType("RADAR", 1);
            RADAR = animationSubType;
            $VALUES = new AnimationSubType[]{NONE, animationSubType};
        }

        public AnimationSubType(String str, int i) {
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

        public static AnimationSubType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AnimationSubType) Enum.valueOf(AnimationSubType.class, str);
            }
            return (AnimationSubType) invokeL.objValue;
        }

        public static AnimationSubType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AnimationSubType[]) $VALUES.clone();
            }
            return (AnimationSubType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class CoordType {
        public static final /* synthetic */ CoordType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CoordType CoordType_BD09;
        public static final CoordType CoordType_BD09LL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-220301784, "Lcom/baidu/platform/comapi/map/OverlayItem$CoordType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-220301784, "Lcom/baidu/platform/comapi/map/OverlayItem$CoordType;");
                    return;
                }
            }
            CoordType_BD09LL = new CoordType("CoordType_BD09LL", 0);
            CoordType coordType = new CoordType("CoordType_BD09", 1);
            CoordType_BD09 = coordType;
            $VALUES = new CoordType[]{CoordType_BD09LL, coordType};
        }

        public CoordType(String str, int i) {
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

        public static CoordType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CoordType) Enum.valueOf(CoordType.class, str);
            }
            return (CoordType) invokeL.objValue;
        }

        public static CoordType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CoordType[]) $VALUES.clone();
            }
            return (CoordType[]) invokeV.objValue;
        }
    }

    public OverlayItem(GeoPoint geoPoint, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {geoPoint, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = CoordType.CoordType_BD09;
        this.a = geoPoint;
        this.b = str;
        this.c = str2;
        this.g = null;
        this.r = 0;
        this.d = 2;
        this.h = "";
        this.j = 0.5f;
        this.k = 1.0f;
        this.l = new ArrayList<>();
    }

    public void addClickRect(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (this.l == null) {
                this.l = new ArrayList<>();
            }
            this.l.add(bundle);
        }
    }

    public void setAnchor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        setAnchor(0.5f, 0.0f);
                        return;
                    }
                    return;
                }
                setAnchor(0.5f, 1.0f);
                return;
            }
            setAnchor(0.5f, 0.5f);
        }
    }

    public void setAnimate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            this.m = bundle;
        }
    }

    public void setAnimateDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (this.m == null) {
                this.m = new Bundle();
            }
            this.m.putInt("dur", i);
        }
    }

    public void setBound(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.d = i;
        }
    }

    public void setClickRect(ArrayList<Bundle> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, arrayList) == null) {
            this.l = arrayList;
        }
    }

    public void setCoordType(CoordType coordType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, coordType) == null) {
            this.i = coordType;
        }
    }

    public void setDelay(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            this.n = bundle;
        }
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, geoPoint) == null) {
            this.a = geoPoint;
        }
    }

    public void setGeoZ(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f) == null) {
            this.o = f;
        }
    }

    public void setGifData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bArr) == null) {
            this.p = bArr;
        }
    }

    public void setId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.h = str;
        }
    }

    public void setIndoorPoi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.s = i;
        }
    }

    public void setLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.e = i;
        }
    }

    public void setMarker(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, drawable) == null) {
            this.g = drawable;
        }
    }

    public void setMask(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.f = i;
        }
    }

    public void setMultiplyDpi(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.r = i;
        }
    }

    public void setScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048617, this, f) == null) {
            this.q = f;
        }
    }

    public void setSnippet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.c = str;
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.b = str;
        }
    }

    public float getAnchorX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    public float getAnchorY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.floatValue;
    }

    public Bundle getAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return (Bundle) invokeV.objValue;
    }

    public int getBound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public ArrayList<Bundle> getClickRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (ArrayList) invokeV.objValue;
    }

    public CoordType getCoordType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (CoordType) invokeV.objValue;
    }

    public Bundle getDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (Bundle) invokeV.objValue;
    }

    public float getGeoZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return invokeV.floatValue;
    }

    public byte[] getGifData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return (byte[]) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public int getIndoorPoi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public int getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final Drawable getMarker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public float getMultiplyDpi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.r;
        }
        return invokeV.floatValue;
    }

    public GeoPoint getPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a;
        }
        return (GeoPoint) invokeV.objValue;
    }

    public int getResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getMarker() == null) {
                return -1;
            }
            return getMarker().hashCode();
        }
        return invokeV.intValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.q;
        }
        return invokeV.floatValue;
    }

    public String getSnippet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void setAnchor(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.j = f;
            this.k = f2;
        }
    }

    public void setAnimateEndSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i, i2) == null) {
            if (this.m == null) {
                this.m = new Bundle();
            }
            this.m.putInt("en_w", i);
            this.m.putInt("en_h", i2);
        }
    }

    public void setAnimateStartSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) {
            if (this.m == null) {
                this.m = new Bundle();
            }
            this.m.putInt("st_w", i);
            this.m.putInt("st_h", i2);
        }
    }

    public void setAnimateEffect(AnimEffect animEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, animEffect) == null) {
            if (this.m == null) {
                this.m = new Bundle();
            }
            switch (ad.a[animEffect.ordinal()]) {
                case 1:
                    this.m.putInt("type", 1);
                    return;
                case 2:
                    this.m.putInt("type", 2);
                    return;
                case 3:
                    this.m.putInt("type", 3);
                    return;
                case 4:
                    this.m.putInt("type", 4);
                    return;
                case 5:
                    this.m.putInt("type", 5);
                    return;
                case 6:
                    this.m.putInt("type", 6);
                    return;
                case 7:
                    this.m.putInt("type", 7);
                    return;
                case 8:
                    this.m.putInt("type", 8);
                    return;
                case 9:
                    this.m.putInt("type", 9);
                    return;
                case 10:
                    this.m.putInt("type", 10);
                    return;
                case 11:
                    this.m.putInt("type", 11);
                    return;
                default:
                    this.m.putInt("type", 0);
                    return;
            }
        }
    }

    public void setSubAnimateEffect(AnimationSubType animationSubType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, animationSubType) == null) {
            if (this.m == null) {
                this.m = new Bundle();
            }
            if (ad.b[animationSubType.ordinal()] != 1) {
                this.m.putInt("sub_type", 0);
            } else {
                this.m.putInt("sub_type", 1);
            }
        }
    }
}
