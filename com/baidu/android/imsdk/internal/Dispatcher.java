package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class Dispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL = 0;
    public static final int NORMAL = -1;
    public static final int NORMAL_CATEGORY = -1;
    public static final String TAG = "Dispatcher";
    public static List<MsgListener> allMsgListeners;
    public static Map<Pair<Integer, Long>, ArrayList<MsgListener>> listenerMap;
    public static List<MsgListener> normalALL;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Event {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int category;
        public long contacter;
        public int type;

        public Event() {
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

        public int getCategory() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.category : invokeV.intValue;
        }

        public long getContacter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contacter : invokeV.longValue;
        }

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type : invokeV.intValue;
        }

        public void setCategory(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.category = i;
            }
        }

        public void setContacter(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.contacter = j;
            }
        }

        public void setType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.type = i;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class MsgListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        public MsgListener() {
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
            this.type = 0;
        }

        public abstract void dealMessage(int i, ChatMsg chatMsg);

        public abstract void dealMessage(int i, ArrayList<ChatMsg> arrayList);

        public int getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.type : invokeV.intValue;
        }

        public void setType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.type = i;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1292377847, "Lcom/baidu/android/imsdk/internal/Dispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1292377847, "Lcom/baidu/android/imsdk/internal/Dispatcher;");
                return;
            }
        }
        listenerMap = Collections.synchronizedMap(new HashMap());
        allMsgListeners = Collections.synchronizedList(new ArrayList());
        normalALL = Collections.synchronizedList(new ArrayList());
    }

    public Dispatcher() {
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

    public static void dispatchMesageToCentain(int i, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i, arrayList) == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("start dispatchMesageToCentain");
            sb.append(arrayList == null ? StringUtil.NULL_STRING : Integer.valueOf(arrayList.size()));
            LogUtils.d(str, sb.toString());
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                ArrayList arrayList2 = (ArrayList) hashMap.get(new Pair(Integer.valueOf(next.getCategory()), Long.valueOf(next.getContacter())));
                if (arrayList2 != null) {
                    arrayList2.add(next);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(next);
                    hashMap.put(new Pair(Integer.valueOf(next.getCategory()), Long.valueOf(next.getContacter())), arrayList3);
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                dispatchMesageToCentainType(i, listenerMap.get(entry.getKey()), (ArrayList) hashMap.get(entry.getKey()));
            }
        }
    }

    public static void dispatchMesageToCentainType(int i, ArrayList<MsgListener> arrayList, ArrayList<ChatMsg> arrayList2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, null, i, arrayList, arrayList2) == null) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("start dispatchMesageToCentain");
            if (arrayList2 == null) {
                str = " is null";
            } else {
                str = "size is" + arrayList2.size();
            }
            sb.append(str);
            LogUtils.d(str2, sb.toString());
            if (arrayList2 == null || arrayList2.size() == 0) {
                return;
            }
            if (arrayList == null) {
                LogUtils.d(TAG, ": dispatchMesageToCentain listeners = null");
                return;
            }
            Iterator<MsgListener> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgListener next = it.next();
                Iterator<ChatMsg> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ChatMsg next2 = it2.next();
                    if (next2.getCategory() != 0 && next2.getCategory() != 1 && next2.getNotifyCmd() == next.getType()) {
                        next.dealMessage(i, next2);
                    }
                }
                if (arrayList2.get(0).getCategory() == 0 || arrayList2.get(0).getCategory() == 1) {
                    next.dealMessage(i, arrayList2);
                }
            }
        }
    }

    public static void dispatchMessage(Context context, int i, ArrayList<ChatMsg> arrayList) {
        List<MsgListener> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, arrayList) == null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("start dispatchMessage ");
            sb.append(arrayList == null ? StringUtil.NULL_STRING : Integer.valueOf(arrayList.size()));
            LogUtils.d(str, sb.toString());
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            List<MsgListener> list2 = allMsgListeners;
            if (list2 != null && list2.size() > 0) {
                for (MsgListener msgListener : allMsgListeners) {
                    LogUtils.d(TAG, "deal allMsgListeners message");
                    msgListener.dealMessage(i, arrayList);
                }
            }
            ArrayList<ChatMsg> arrayList2 = new ArrayList<>();
            long j = 0;
            Iterator<ChatMsg> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (next.getCategory() != 0 && next.getCategory() != 1) {
                    if (next.getCategory() == 2 && j < next.getMsgId()) {
                        j = next.getMsgId();
                    }
                } else {
                    arrayList2.add(next);
                }
            }
            String str2 = TAG;
            LogUtils.d(str2, "normalAll dispatcher : msgs2.size() : " + arrayList2.size());
            if (arrayList2.size() > 0 && (list = normalALL) != null && list.size() > 0) {
                for (MsgListener msgListener2 : normalALL) {
                    msgListener2.dealMessage(i, arrayList2);
                }
            }
            dispatchMesageToCentain(i, arrayList);
        }
    }

    public static void registerListener(Event event, MsgListener msgListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, event, msgListener) == null) {
            if (event.getType() == 0) {
                allMsgListeners.add(msgListener);
            } else if (event.getCategory() == -1 && event.getType() == -1) {
                normalALL.add(msgListener);
            } else {
                msgListener.setType(event.getType());
                ArrayList<MsgListener> arrayList = listenerMap.get(new Pair(Integer.valueOf(event.getCategory()), Long.valueOf(event.getContacter())));
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    arrayList.add(msgListener);
                } else {
                    arrayList.add(msgListener);
                }
                listenerMap.put(new Pair<>(Integer.valueOf(event.getCategory()), Long.valueOf(event.getContacter())), arrayList);
            }
        }
    }
}
