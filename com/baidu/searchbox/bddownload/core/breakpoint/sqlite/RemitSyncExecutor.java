package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class RemitSyncExecutor implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RemitSyncExecutor";
    public static final int WHAT_REMOVE_FREE_BUNCH_ID = -1;
    public static final int WHAT_REMOVE_FREE_ID = -2;
    public static final int WHAT_REMOVE_INFO = -3;
    public static final int WHAT_SYNC_BUNCH_ID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemitAgent agent;
    public final Set freeToDBIdList;
    public final Handler handler;

    /* loaded from: classes2.dex */
    public interface RemitAgent {
        void removeInfo(int i);

        void syncCacheToDB(int i) throws IOException;

        void syncCacheToDB(List list) throws IOException;
    }

    public RemitSyncExecutor(RemitAgent remitAgent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitAgent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.agent = remitAgent;
        this.freeToDBIdList = new HashSet();
        HandlerThread handlerThread = new HandlerThread("BdDownload RemitHandoverToDB");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    public RemitSyncExecutor(RemitAgent remitAgent, Handler handler, Set set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitAgent, handler, set};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.agent = remitAgent;
        this.handler = handler;
        this.freeToDBIdList = set;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            int i = message.what;
            if (i != -3) {
                if (i != -2) {
                    if (i != -1) {
                        if (i != 0) {
                            try {
                                this.agent.syncCacheToDB(i);
                                this.freeToDBIdList.add(Integer.valueOf(i));
                                Util.d(TAG, "sync info with id: " + i);
                                return true;
                            } catch (IOException unused) {
                                Util.w(TAG, "sync cache to db failed for id: " + i);
                                return true;
                            }
                        }
                        List list = (List) message.obj;
                        try {
                            this.agent.syncCacheToDB(list);
                            this.freeToDBIdList.addAll(list);
                            Util.d(TAG, "sync bunch info with ids: " + list);
                            return true;
                        } catch (IOException unused2) {
                            Util.w(TAG, "sync info to db failed for ids: " + list);
                            return true;
                        }
                    }
                    List list2 = (List) message.obj;
                    this.freeToDBIdList.removeAll(list2);
                    Util.d(TAG, "remove free bunch ids " + list2);
                    return true;
                }
                int i2 = message.arg1;
                this.freeToDBIdList.remove(Integer.valueOf(i2));
                Util.d(TAG, "remove free bunch id " + i2);
                return true;
            }
            int i3 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i3));
            this.agent.removeInfo(i3);
            Util.d(TAG, "remove info " + i3);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isFreeToDatabase(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.freeToDBIdList.contains(Integer.valueOf(i));
        }
        return invokeI.booleanValue;
    }

    public void postRemoveFreeId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            Message obtainMessage = this.handler.obtainMessage(-2);
            obtainMessage.arg1 = i;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postRemoveFreeIds(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            Message obtainMessage = this.handler.obtainMessage(-1);
            obtainMessage.obj = list;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postRemoveInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            Message obtainMessage = this.handler.obtainMessage(-3);
            obtainMessage.arg1 = i;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postSync(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.handler.sendEmptyMessage(i);
        }
    }

    public void removePostWithId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.handler.removeMessages(i);
        }
    }

    public void removePostWithIds(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iArr) == null) {
            for (int i : iArr) {
                this.handler.removeMessages(i);
            }
        }
    }

    public void postSync(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Message obtainMessage = this.handler.obtainMessage(0);
            obtainMessage.obj = list;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postSyncInfoDelay(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.handler.sendEmptyMessageDelayed(i, j);
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.handler.getLooper().quit();
        }
    }
}
