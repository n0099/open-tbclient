package com.baidu.mapapi.map;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.List;
/* loaded from: classes2.dex */
public class GradientLineOptions extends OverlayOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<LatLng> a;
    public List<Integer> b;
    public List<Integer> c;
    public int d;
    public boolean e;
    public LineDirectionCross180 f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class LineDirectionCross180 {
        public static /* synthetic */ Interceptable $ic;
        public static final LineDirectionCross180 FROM_EAST_TO_WEST;
        public static final LineDirectionCross180 FROM_WEST_TO_EAST;
        public static final LineDirectionCross180 NONE;
        public static final /* synthetic */ LineDirectionCross180[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1875611047, "Lcom/baidu/mapapi/map/GradientLineOptions$LineDirectionCross180;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1875611047, "Lcom/baidu/mapapi/map/GradientLineOptions$LineDirectionCross180;");
                    return;
                }
            }
            NONE = new LineDirectionCross180(HlsPlaylistParser.METHOD_NONE, 0);
            FROM_EAST_TO_WEST = new LineDirectionCross180("FROM_EAST_TO_WEST", 1);
            LineDirectionCross180 lineDirectionCross180 = new LineDirectionCross180("FROM_WEST_TO_EAST", 2);
            FROM_WEST_TO_EAST = lineDirectionCross180;
            a = new LineDirectionCross180[]{NONE, FROM_EAST_TO_WEST, lineDirectionCross180};
        }

        public LineDirectionCross180(String str, int i) {
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

        public static LineDirectionCross180 valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (LineDirectionCross180) Enum.valueOf(LineDirectionCross180.class, str);
            }
            return (LineDirectionCross180) invokeL.objValue;
        }

        public static LineDirectionCross180[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (LineDirectionCross180[]) a.clone();
            }
            return (LineDirectionCross180[]) invokeV.objValue;
        }
    }

    public GradientLineOptions() {
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
        this.d = 5;
        this.e = true;
        this.f = LineDirectionCross180.NONE;
    }

    public List<Integer> getColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public List<Integer> getIndexs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public LineDirectionCross180 getLineDirectionCross180() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (LineDirectionCross180) invokeV.objValue;
    }

    public List<LatLng> getPoints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GradientLine gradientLine = new GradientLine();
            gradientLine.d = this.d;
            gradientLine.H = this.e;
            gradientLine.e = this.f;
            List<LatLng> list = this.a;
            if (list != null && list.size() >= 2) {
                gradientLine.a = this.a;
                List<Integer> list2 = this.c;
                if (list2 != null) {
                    if (list2.size() != 0) {
                        int[] iArr = new int[this.c.size()];
                        int i = 0;
                        int i2 = 0;
                        for (Integer num : this.c) {
                            iArr[i2] = num.intValue();
                            i2++;
                        }
                        gradientLine.c = iArr;
                        List<Integer> list3 = this.b;
                        if (list3 != null) {
                            if (list3.size() != 0) {
                                int[] iArr2 = new int[this.b.size()];
                                for (Integer num2 : this.b) {
                                    iArr2[i] = num2.intValue();
                                    i++;
                                }
                                gradientLine.b = iArr2;
                                return gradientLine;
                            }
                            throw new IllegalStateException("BDMapSDKException: Indexs list size can not be Equal to zero");
                        }
                        throw new IllegalStateException("BDMapSDKException: Indexs list can not be null");
                    }
                    throw new IllegalStateException("BDMapSDKException: colors list size can not be Equal to zero");
                }
                throw new IllegalStateException("BDMapSDKException: colors list can not be null");
            }
            throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
        }
        return (Overlay) invokeV.objValue;
    }

    public GradientLineOptions setColorIndex(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, list)) == null) {
            if (list != null) {
                if (!list.contains(null)) {
                    if (list.size() != 0) {
                        this.b = list;
                        return this;
                    }
                    throw new IllegalStateException("BDMapSDKException: indexs list size can not be Equal to zero");
                }
                throw new IllegalArgumentException("BDMapSDKException: indexs list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        return (GradientLineOptions) invokeL.objValue;
    }

    public GradientLineOptions setColorsValues(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            if (list != null) {
                if (!list.contains(null)) {
                    if (list.size() != 0) {
                        this.c = list;
                        return this;
                    }
                    throw new IllegalStateException("BDMapSDKException: colors list list size can not be Equal to zero");
                }
                throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        return (GradientLineOptions) invokeL.objValue;
    }

    public GradientLineOptions setPoints(List<LatLng> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, list)) == null) {
            if (list != null) {
                if (list.size() >= 2) {
                    if (!list.contains(null)) {
                        this.a = list;
                        return this;
                    }
                    throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
                }
                throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
            }
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        return (GradientLineOptions) invokeL.objValue;
    }

    public GradientLineOptions setLineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, lineDirectionCross180)) == null) {
            this.f = lineDirectionCross180;
            return this;
        }
        return (GradientLineOptions) invokeL.objValue;
    }

    public GradientLineOptions setWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (i > 0) {
                this.d = i;
            }
            return this;
        }
        return (GradientLineOptions) invokeI.objValue;
    }

    public GradientLineOptions visible(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.e = z;
            return this;
        }
        return (GradientLineOptions) invokeZ.objValue;
    }
}
