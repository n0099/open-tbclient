package com.baidu.platform.comjni.base.longlink;

import android.util.Log;
import com.baidu.platform.comapi.b;
import com.baidu.platform.comapi.longlink.ELongLinkStatus;
import com.baidu.platform.comapi.longlink.LongLinkDataCallback;
import com.baidu.platform.comapi.longlink.LongLinkFileData;
import com.baidu.platform.comjni.JNIBaseApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class NALongLink extends JNIBaseApi {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Integer, LinkedList<Object>> a;
    public static ELongLinkStatus[] b;
    public transient /* synthetic */ FieldHolder $fh;

    public static native long nativeCreate();

    public static native boolean nativeInit(long j, String str, String str2);

    public static native boolean nativeRegister(long j, int i);

    public static native int nativeRelease(long j);

    public static native int nativeSendData(long j, int i, int i2, byte[] bArr);

    public static native int nativeSendFileData(long j, int i, int i2, String str, ArrayList<LongLinkFileData> arrayList);

    public static native boolean nativeStart(long j);

    public static native boolean nativeStop(long j);

    public static native boolean nativeUnRegister(long j, int i);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1294864038, "Lcom/baidu/platform/comjni/base/longlink/NALongLink;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1294864038, "Lcom/baidu/platform/comjni/base/longlink/NALongLink;");
                return;
            }
        }
        a = new ConcurrentHashMap();
        b = new ELongLinkStatus[]{ELongLinkStatus.OK, ELongLinkStatus.SendFormatError, ELongLinkStatus.SendUnRegistered, ELongLinkStatus.SendLimited, ELongLinkStatus.SendDataLenLimited, ELongLinkStatus.SendInvalidReqID, ELongLinkStatus.ResultConnectError, ELongLinkStatus.ResultSendError, ELongLinkStatus.ResultTimeout, ELongLinkStatus.ResultServerError, ELongLinkStatus.CloudStop, ELongLinkStatus.CloudRestart};
    }

    public NALongLink() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static long create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return nativeCreate();
        }
        return invokeV.longValue;
    }

    public static boolean init(long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), str, str2})) == null) {
            return nativeInit(j, str, str2);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean onJNILongLinkDataCallback(int i, int i2, int i3, byte[] bArr, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bArr, Boolean.valueOf(z)})) == null) {
            Log.e("JNILongLink", "onJNILongLinkDataCallback:" + i + " status:" + i2 + " reqId:" + i3 + " isPush:" + z);
            if (i2 >= 0 && i2 < b.length) {
                if (bArr == null || bArr.length <= 0) {
                    bArr = new byte[0];
                }
                LinkedList linkedList = null;
                synchronized (NALongLink.class) {
                    LinkedList<Object> linkedList2 = a.get(Integer.valueOf(i));
                    if (linkedList2 != null) {
                        linkedList = new LinkedList(linkedList2);
                    }
                }
                if (linkedList != null && linkedList.size() > 0) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            try {
                                if (next instanceof LongLinkDataCallback) {
                                    ELongLinkStatus eLongLinkStatus = b[i2];
                                    eLongLinkStatus.setRequestId(i3);
                                    String name = next.getClass().getName();
                                    Log.d("JNILongLink", "className = " + name);
                                    ((LongLinkDataCallback) next).onReceiveData(eLongLinkStatus, i3, bArr, z);
                                    Log.d("JNILongLink", "className = " + name + "done");
                                }
                            } catch (Exception e) {
                                Log.e("JNILongLink", "className = " + next.getClass().getName() + ",exception = " + e.toString());
                                if (b.e()) {
                                    throw e;
                                }
                            }
                        }
                    }
                    return true;
                }
                return true;
            }
            Log.e("JNILongLink", "invalid status = " + i2);
            if (!b.e()) {
                return false;
            }
            throw new IndexOutOfBoundsException();
        }
        return invokeCommon.booleanValue;
    }

    public static boolean register(long j, int i, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), obj})) == null) {
            if (obj != null) {
                Log.e("JNILongLink", "register moduleId = " + i + ", callback = " + obj.getClass().getName());
            } else {
                Log.e("JNILongLink", "register moduleId = " + i + ", callback = " + obj);
            }
            boolean z = false;
            synchronized (NALongLink.class) {
                LinkedList<Object> linkedList = a.get(Integer.valueOf(i));
                if (linkedList == null) {
                    LinkedList<Object> linkedList2 = new LinkedList<>();
                    linkedList2.add(obj);
                    a.put(Integer.valueOf(i), linkedList2);
                    z = true;
                } else if (!linkedList.contains(obj)) {
                    linkedList.add(obj);
                    a.put(Integer.valueOf(i), linkedList);
                }
            }
            if (!z) {
                return true;
            }
            return nativeRegister(j, i);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean unRegister(long j, int i, Object obj) {
        InterceptResult invokeCommon;
        LinkedList<Object> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), obj})) == null) {
            if (obj != null) {
                Log.e("JNILongLink", "unegister moduleId = " + i + ", callback = " + obj.getClass().getName());
            } else {
                Log.e("JNILongLink", "unregister moduleId = " + i + ", callback = " + obj);
            }
            synchronized (NALongLink.class) {
                linkedList = a.get(Integer.valueOf(i));
                if (linkedList != null) {
                    if (obj != null) {
                        linkedList.remove(obj);
                    }
                    if (linkedList.isEmpty()) {
                        a.remove(Integer.valueOf(i));
                    }
                }
            }
            if (linkedList != null) {
                if (linkedList.isEmpty()) {
                    return nativeUnRegister(j, i);
                }
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static int release(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, null, j)) == null) {
            return nativeRelease(j);
        }
        return invokeJ.intValue;
    }

    public static boolean start(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65554, null, j)) == null) {
            return nativeStart(j);
        }
        return invokeJ.booleanValue;
    }

    public static boolean stop(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65555, null, j)) == null) {
            return nativeStop(j);
        }
        return invokeJ.booleanValue;
    }

    public static int sendData(long j, int i, int i2, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), bArr})) == null) {
            return nativeSendData(j, i, i2, bArr);
        }
        return invokeCommon.intValue;
    }

    public static int sendFileData(long j, int i, int i2, String str, ArrayList<LongLinkFileData> arrayList) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, arrayList})) == null) {
            return nativeSendFileData(j, i, i2, str, arrayList);
        }
        return invokeCommon.intValue;
    }
}
