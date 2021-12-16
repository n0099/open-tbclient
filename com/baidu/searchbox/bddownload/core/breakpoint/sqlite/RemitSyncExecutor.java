package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes10.dex */
public class RemitSyncExecutor implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RemitSyncExecutor";
    public static final int WHAT_REMOVE_FREE_BUNCH_ID = -1;
    public static final int WHAT_REMOVE_FREE_ID = -2;
    public static final int WHAT_REMOVE_INFO = -3;
    public static final int WHAT_SYNC_BUNCH_ID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RemitAgent agent;
    @NonNull
    public final Set<Integer> freeToDBIdList;
    @NonNull
    public final Handler handler;

    /* loaded from: classes10.dex */
    public interface RemitAgent {
        void removeInfo(int i2);

        void syncCacheToDB(int i2) throws IOException;

        void syncCacheToDB(List<Integer> list) throws IOException;
    }

    public RemitSyncExecutor(@NonNull RemitAgent remitAgent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitAgent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            int i2 = message.what;
            if (i2 == -3) {
                int i3 = message.arg1;
                this.freeToDBIdList.remove(Integer.valueOf(i3));
                this.agent.removeInfo(i3);
                Util.d(TAG, "remove info " + i3);
                return true;
            } else if (i2 == -2) {
                int i4 = message.arg1;
                this.freeToDBIdList.remove(Integer.valueOf(i4));
                Util.d(TAG, "remove free bunch id " + i4);
                return true;
            } else if (i2 == -1) {
                List list = (List) message.obj;
                this.freeToDBIdList.removeAll(list);
                Util.d(TAG, "remove free bunch ids " + list);
                return true;
            } else if (i2 != 0) {
                try {
                    this.agent.syncCacheToDB(i2);
                    this.freeToDBIdList.add(Integer.valueOf(i2));
                    Util.d(TAG, "sync info with id: " + i2);
                    return true;
                } catch (IOException unused) {
                    Util.w(TAG, "sync cache to db failed for id: " + i2);
                    return true;
                }
            } else {
                List<Integer> list2 = (List) message.obj;
                try {
                    this.agent.syncCacheToDB(list2);
                    this.freeToDBIdList.addAll(list2);
                    Util.d(TAG, "sync bunch info with ids: " + list2);
                    return true;
                } catch (IOException unused2) {
                    Util.w(TAG, "sync info to db failed for ids: " + list2);
                    return true;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public boolean isFreeToDatabase(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.freeToDBIdList.contains(Integer.valueOf(i2)) : invokeI.booleanValue;
    }

    public void postRemoveFreeId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            Message obtainMessage = this.handler.obtainMessage(-2);
            obtainMessage.arg1 = i2;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postRemoveFreeIds(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            Message obtainMessage = this.handler.obtainMessage(-1);
            obtainMessage.obj = list;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postRemoveInfo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            Message obtainMessage = this.handler.obtainMessage(-3);
            obtainMessage.arg1 = i2;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public void postSync(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.handler.sendEmptyMessage(i2);
        }
    }

    public void postSyncInfoDelay(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            this.handler.sendEmptyMessageDelayed(i2, j2);
        }
    }

    public void removePostWithId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.handler.removeMessages(i2);
        }
    }

    public void removePostWithIds(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iArr) == null) {
            for (int i2 : iArr) {
                this.handler.removeMessages(i2);
            }
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.handler.getLooper().quit();
        }
    }

    public void postSync(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            Message obtainMessage = this.handler.obtainMessage(0);
            obtainMessage.obj = list;
            this.handler.sendMessage(obtainMessage);
        }
    }

    public RemitSyncExecutor(@NonNull RemitAgent remitAgent, @Nullable Handler handler, @NonNull Set<Integer> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remitAgent, handler, set};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.agent = remitAgent;
        this.handler = handler;
        this.freeToDBIdList = set;
    }
}
