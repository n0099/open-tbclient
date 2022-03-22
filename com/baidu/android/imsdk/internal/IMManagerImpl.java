package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class IMManagerImpl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile IMManagerImpl mInstance;
    public static Object mLock;
    public static Context sContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1397885219, "Lcom/baidu/android/imsdk/internal/IMManagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1397885219, "Lcom/baidu/android/imsdk/internal/IMManagerImpl;");
                return;
            }
        }
        mLock = new Object();
    }

    public IMManagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        loadClasses();
    }

    private List<Integer> getIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            int i = 1;
            arrayList.add(1);
            for (int i2 = 0; i2 <= 29; i2++) {
                if ((536870937 & i) != 0) {
                    arrayList.add(Integer.valueOf(i2 + 2));
                }
                i <<= 1;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static IMManagerImpl getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (mInstance == null) {
                synchronized (mLock) {
                    if (mInstance == null) {
                        sContext = context;
                        mInstance = new IMManagerImpl();
                    }
                }
            }
            return mInstance;
        }
        return (IMManagerImpl) invokeL.objValue;
    }

    public static String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(sContext)) : (String) invokeV.objValue;
    }

    private boolean isKickOffMsg(ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, chatMsg)) == null) ? chatMsg.getMsgType() == 3 && chatMsg.getNotifyCmd() == 50 : invokeL.booleanValue;
    }

    private void loadClassForName(String str) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null || (method = cls.getMethod("init", Context.class)) == null) {
                    return;
                }
                method.invoke(cls, sContext);
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(sContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    private void loadClasses() {
        List<Integer> index;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (index = getIndex()) == null) {
            return;
        }
        String[] strArr = {"com.baidu.android.imsdk.account.AccountManager", "com.baidu.android.imsdk.chatmessage.ChatMsgManager", "com.baidu.android.imsdk.chatuser.ChatUserManager", "com.baidu.android.imsdk.friend.FriendManager", "com.baidu.android.imsdk.group.GroupManager", "com.baidu.android.imsdk.pubaccount.PaManager"};
        for (int i = 0; i < index.size() && index.get(i).intValue() < 6; i++) {
            loadClassForName(strArr[index.get(i).intValue()]);
        }
    }

    public ChatMsg checkKickOffMsg(ArrayList<ChatMsg> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, arrayList)) == null) {
            if (arrayList == null) {
                return null;
            }
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (isKickOffMsg(next)) {
                    return next;
                }
            }
            return null;
        }
        return (ChatMsg) invokeL.objValue;
    }

    public boolean setProductLine(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? IMConfigInternal.getInstance().setProductLine(sContext, i) : invokeI.booleanValue;
    }

    public void start(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Utility.startIMService(context);
        }
    }

    public void stop(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
        }
    }
}
