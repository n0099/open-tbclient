package com.baidu.pass.biometrics.face.liveness.c;

import androidx.core.view.InputDeviceCompat;
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
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[HeadPose.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HeadPose.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[HeadPose.MOUTH_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[HeadPose.TURN_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[HeadPose.TURN_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[HeadPose.EYES_BLINK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static LivenessTypeEnum a(HeadPose headPose) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, headPose)) == null) {
            int i = a.a[headPose.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
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

    public static void b(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, list) == null) {
            while (list.size() < 3) {
                LivenessTypeEnum a2 = a(HeadPose.getHeadPoseByIndex(Integer.valueOf(new Random().nextInt(6))));
                if (!list.contains(a2)) {
                    list.add(a2);
                }
            }
        }
    }

    public static void a(List list, Integer num, HeadPose headPose) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, num, headPose) != null) || list == null) {
            return;
        }
        int intValue = num.intValue();
        int i = headPose.value;
        if ((intValue & i) == i) {
            list.add(a(headPose));
        }
    }

    public static void a(List list, List list2) {
        int i;
        int i2;
        int i3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, list, list2) == null) {
            if (list == null) {
                list = new ArrayList();
            }
            int size = list2.size() - 1;
            while (true) {
                boolean z2 = false;
                if (size <= 0) {
                    break;
                }
                Integer num = (Integer) list2.get(size);
                if (num != null) {
                    if ((num.intValue() == HeadPose.EYES_BLINK.value || num.intValue() == HeadPose.DOWN.value || num.intValue() == HeadPose.UP.value || num.intValue() == HeadPose.TURN_LEFT.value || num.intValue() == HeadPose.TURN_RIGHT.value || num.intValue() == HeadPose.MOUTH_OPEN.value) ? true : true) {
                        int i4 = size - 1;
                        if (list2.get(i4) != null && num.equals(list2.get(i4))) {
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
            for (int i5 = 0; i5 < list2.size(); i5++) {
                Integer num2 = (Integer) list2.get(i5);
                if (num2 != null) {
                    if (num2.intValue() != HeadPose.EYES_BLINK.value && num2.intValue() != HeadPose.DOWN.value && num2.intValue() != HeadPose.UP.value && num2.intValue() != HeadPose.TURN_LEFT.value && num2.intValue() != HeadPose.TURN_RIGHT.value && num2.intValue() != HeadPose.MOUTH_OPEN.value) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolArr[i5] = Boolean.valueOf(z);
                    if (boolArr[i5].booleanValue()) {
                        livenessTypeEnumArr[i5] = a(HeadPose.getHeadPoseByValues(num2));
                    }
                }
            }
            for (int i6 = 0; i6 < size2; i6++) {
                if (!boolArr[i6].booleanValue()) {
                    Integer num3 = (Integer) list2.get(i6);
                    ArrayList arrayList = new ArrayList();
                    a(arrayList, num3, HeadPose.EYES_BLINK);
                    a(arrayList, num3, HeadPose.DOWN);
                    a(arrayList, num3, HeadPose.UP);
                    a(arrayList, num3, HeadPose.TURN_LEFT);
                    a(arrayList, num3, HeadPose.TURN_RIGHT);
                    a(arrayList, num3, HeadPose.MOUTH_OPEN);
                    if (!arrayList.isEmpty()) {
                        if (a(list2)) {
                            for (int i7 = 0; i7 < size3; i7++) {
                                arrayList.remove(livenessTypeEnumArr[i7]);
                            }
                        } else if (i6 == 0 && (i3 = i6 + 1) < size2) {
                            if (boolArr[i3].booleanValue()) {
                                arrayList.remove(livenessTypeEnumArr[i3]);
                            }
                        } else if (i6 == size2 - 1 && i6 - 1 > 0) {
                            if (boolArr[i2].booleanValue()) {
                                arrayList.remove(livenessTypeEnumArr[i2]);
                            }
                        } else {
                            int i8 = i6 + 1;
                            if (i8 < size2 && i6 - 1 > 0) {
                                if (boolArr[i8].booleanValue()) {
                                    arrayList.remove(livenessTypeEnumArr[i8]);
                                }
                                if (boolArr[i].booleanValue()) {
                                    arrayList.remove(livenessTypeEnumArr[i]);
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            livenessTypeEnumArr[i6] = (LivenessTypeEnum) arrayList.get(new Random().nextInt(arrayList.size()));
                            boolArr[i6] = Boolean.TRUE;
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

    public static boolean a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            Integer num = (Integer) list.get(0);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer num2 = (Integer) it.next();
                if (num == null || !num.equals(num2) || num2.intValue() != 63) {
                    return false;
                }
                num = num2;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void b(List list, List list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, list2) == null) {
            if (list == null) {
                list = new ArrayList();
            } else {
                list.clear();
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                int i = a.a[((HeadPose) it.next()).ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    list.add(LivenessTypeEnum.Eye);
                                } else {
                                    list.add(LivenessTypeEnum.HeadRight);
                                }
                            } else {
                                list.add(LivenessTypeEnum.HeadLeft);
                            }
                        } else {
                            list.add(LivenessTypeEnum.Mouth);
                        }
                    } else {
                        list.add(LivenessTypeEnum.HeadDown);
                    }
                } else {
                    list.add(LivenessTypeEnum.HeadUp);
                }
            }
        }
    }
}
