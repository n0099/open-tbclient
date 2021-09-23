package com.baidu.pass.biometrics.face.liveness.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.biometrics.face.liveness.enums.HeadPose;
import com.baidu.pass.face.platform.LivenessTypeEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44197a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-649944414, "Lcom/baidu/pass/biometrics/face/liveness/c/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-649944414, "Lcom/baidu/pass/biometrics/face/liveness/c/f$a;");
                    return;
                }
            }
            int[] iArr = new int[HeadPose.values().length];
            f44197a = iArr;
            try {
                iArr[HeadPose.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44197a[HeadPose.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44197a[HeadPose.MOUTH_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44197a[HeadPose.TURN_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44197a[HeadPose.TURN_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f44197a[HeadPose.EYES_BLINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f() {
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

    public static void a(List<LivenessTypeEnum> list, List<Integer> list2) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, list, list2) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            int size = list2.size() - 1;
            while (true) {
                boolean z = false;
                if (size <= 0) {
                    break;
                }
                Integer num = list2.get(size);
                if (num != null) {
                    if ((num.intValue() == HeadPose.EYES_BLINK.value || num.intValue() == HeadPose.DOWN.value || num.intValue() == HeadPose.UP.value || num.intValue() == HeadPose.TURN_LEFT.value || num.intValue() == HeadPose.TURN_RIGHT.value || num.intValue() == HeadPose.MOUTH_OPEN.value) ? true : true) {
                        int i5 = size - 1;
                        if (list2.get(i5) != null && num.equals(list2.get(i5))) {
                            list2.remove(num);
                        }
                    }
                }
                size--;
            }
            int size2 = list2.size();
            Boolean[] boolArr = new Boolean[size2];
            int size3 = list2.size();
            LivenessTypeEnum[] livenessTypeEnumArr = new LivenessTypeEnum[size3];
            for (int i6 = 0; i6 < list2.size(); i6++) {
                Integer num2 = list2.get(i6);
                if (num2 != null) {
                    boolArr[i6] = Boolean.valueOf(num2.intValue() == HeadPose.EYES_BLINK.value || num2.intValue() == HeadPose.DOWN.value || num2.intValue() == HeadPose.UP.value || num2.intValue() == HeadPose.TURN_LEFT.value || num2.intValue() == HeadPose.TURN_RIGHT.value || num2.intValue() == HeadPose.MOUTH_OPEN.value);
                    if (boolArr[i6].booleanValue()) {
                        livenessTypeEnumArr[i6] = a(HeadPose.getHeadPoseByValues(num2));
                    }
                }
            }
            for (int i7 = 0; i7 < size2; i7++) {
                if (!boolArr[i7].booleanValue()) {
                    Integer num3 = list2.get(i7);
                    ArrayList arrayList = new ArrayList();
                    a(arrayList, num3, HeadPose.EYES_BLINK);
                    a(arrayList, num3, HeadPose.DOWN);
                    a(arrayList, num3, HeadPose.UP);
                    a(arrayList, num3, HeadPose.TURN_LEFT);
                    a(arrayList, num3, HeadPose.TURN_RIGHT);
                    a(arrayList, num3, HeadPose.MOUTH_OPEN);
                    if (!arrayList.isEmpty()) {
                        if (a(list2)) {
                            for (int i8 = 0; i8 < size3; i8++) {
                                arrayList.remove(livenessTypeEnumArr[i8]);
                            }
                        } else if (i7 != 0 || (i4 = i7 + 1) >= size2) {
                            if (i7 != size2 - 1 || i7 - 1 <= 0) {
                                int i9 = i7 + 1;
                                if (i9 < size2 && i7 - 1 > 0) {
                                    if (boolArr[i9].booleanValue()) {
                                        arrayList.remove(livenessTypeEnumArr[i9]);
                                    }
                                    if (boolArr[i2].booleanValue()) {
                                        arrayList.remove(livenessTypeEnumArr[i2]);
                                    }
                                }
                            } else if (boolArr[i3].booleanValue()) {
                                arrayList.remove(livenessTypeEnumArr[i3]);
                            }
                        } else if (boolArr[i4].booleanValue()) {
                            arrayList.remove(livenessTypeEnumArr[i4]);
                        }
                        if (!arrayList.isEmpty()) {
                            livenessTypeEnumArr[i7] = (LivenessTypeEnum) arrayList.get(new Random().nextInt(arrayList.size()));
                            boolArr[i7] = Boolean.TRUE;
                        }
                    }
                }
            }
            list.addAll(Arrays.asList(livenessTypeEnumArr));
            while (list.contains(null)) {
                list.remove((Object) null);
            }
        }
    }

    public static void b(List<LivenessTypeEnum> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list) == null) {
            while (list.size() < 3) {
                LivenessTypeEnum a2 = a(HeadPose.getHeadPoseByIndex(Integer.valueOf(new Random().nextInt(6))));
                if (!list.contains(a2)) {
                    list.add(a2);
                }
            }
        }
    }

    public static void b(List<LivenessTypeEnum> list, List<HeadPose> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, list2) == null) {
            if (list == null) {
                list = new ArrayList<>();
            } else {
                list.clear();
            }
            for (HeadPose headPose : list2) {
                int i2 = a.f44197a[headPose.ordinal()];
                if (i2 == 1) {
                    list.add(LivenessTypeEnum.HeadUp);
                } else if (i2 == 2) {
                    list.add(LivenessTypeEnum.HeadDown);
                } else if (i2 == 3) {
                    list.add(LivenessTypeEnum.Mouth);
                } else if (i2 == 4) {
                    list.add(LivenessTypeEnum.HeadLeft);
                } else if (i2 != 5) {
                    list.add(LivenessTypeEnum.Eye);
                } else {
                    list.add(LivenessTypeEnum.HeadRight);
                }
            }
        }
    }

    public static boolean a(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            Integer num = list.get(0);
            for (Integer num2 : list) {
                if (num == null || !num.equals(num2) || num2.intValue() != 63) {
                    return false;
                }
                num = num2;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(List<LivenessTypeEnum> list, Integer num, HeadPose headPose) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, num, headPose) == null) || list == null) {
            return;
        }
        int intValue = num.intValue();
        int i2 = headPose.value;
        if ((intValue & i2) == i2) {
            list.add(a(headPose));
        }
    }

    public static LivenessTypeEnum a(HeadPose headPose) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, headPose)) == null) {
            int i2 = a.f44197a[headPose.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return LivenessTypeEnum.Eye;
                            }
                            return LivenessTypeEnum.HeadRight;
                        }
                        return LivenessTypeEnum.HeadLeft;
                    }
                    return LivenessTypeEnum.Mouth;
                }
                return LivenessTypeEnum.HeadDown;
            }
            return LivenessTypeEnum.HeadUp;
        }
        return (LivenessTypeEnum) invokeL.objValue;
    }
}
