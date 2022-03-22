package com.baidu.searchbox.player.message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.plugin.IPlugin;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public abstract class AbsMessenger implements IMessenger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public List<InternalEventDispatcher> mDispatcherList;
    @Nullable
    public IVideoEventInterceptor mInterceptor;
    @Nullable
    public List<IVideoEventInterceptor> mInterceptorList;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<INeuron>> mSubscribers;

    public AbsMessenger() {
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
        this.mSubscribers = new ConcurrentHashMap<>();
    }

    private void internalDispatch(VideoEvent videoEvent) {
        List<InternalEventDispatcher> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, videoEvent) == null) || (list = this.mDispatcherList) == null) {
            return;
        }
        for (InternalEventDispatcher internalEventDispatcher : list) {
            internalEventDispatcher.onVideoEventNotify(videoEvent);
        }
    }

    private void performAddInternalDispatcher(InternalEventDispatcher internalEventDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, internalEventDispatcher) == null) {
            if (this.mDispatcherList == null) {
                this.mDispatcherList = new ArrayList();
            }
            if (this.mDispatcherList.contains(internalEventDispatcher)) {
                return;
            }
            int expectOrder = internalEventDispatcher.getExpectOrder();
            if (expectOrder == 0) {
                this.mDispatcherList.add(internalEventDispatcher);
            } else if (expectOrder == 1) {
                this.mDispatcherList.add(0, internalEventDispatcher);
            } else if (expectOrder != 2) {
            } else {
                List<InternalEventDispatcher> list = this.mDispatcherList;
                list.add(list.size(), internalEventDispatcher);
            }
        }
    }

    private void printDispatchLog(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, videoEvent) == null) {
            if (videoEvent.getLogLevel() == 0) {
                String type = getType();
                BdVideoLog.d(type, System.identityHashCode(this) + ": dispatch event :" + videoEvent);
                return;
            }
            String type2 = getType();
            BdVideoLog.v(type2, System.identityHashCode(this) + ": dispatch event :" + videoEvent);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVideoEventInterceptor) == null) {
            List<IVideoEventInterceptor> list = this.mInterceptorList;
            addInterceptor(list == null ? 0 : list.size(), iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInternalDispatcher(@NonNull InternalEventDispatcher internalEventDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, internalEventDispatcher) == null) {
            performAddInternalDispatcher(internalEventDispatcher);
        }
    }

    public void dispatchEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) {
            printDispatchLog(videoEvent);
            internalDispatch(videoEvent);
            CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(videoEvent.getType()));
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator<INeuron> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                INeuron next = it.next();
                if (!videoEvent.filter(next)) {
                    switch (videoEvent.getType()) {
                        case -1:
                        case 6:
                            next.onVideoEventNotify(videoEvent);
                            continue;
                        case 1:
                            next.onSystemEventNotify(videoEvent);
                            continue;
                        case 2:
                            next.onControlEventNotify(videoEvent);
                            continue;
                        case 3:
                            next.onLayerEventNotify(videoEvent);
                            continue;
                        case 4:
                            next.onPlayerEventNotify(videoEvent);
                            continue;
                        case 5:
                            next.onPlayerStatusChanged((PlayerStatus) videoEvent.getExtra(2), (PlayerStatus) videoEvent.getExtra(1));
                            continue;
                        case 7:
                            if (next instanceof IPlugin) {
                                ((IPlugin) next).onPluginEventNotify(videoEvent);
                                break;
                            } else {
                                next.onVideoEventNotify(videoEvent);
                                continue;
                            }
                        case 8:
                            next.onInteractiveEventNotify(videoEvent);
                            continue;
                    }
                }
            }
        }
    }

    public boolean isNeedIntercept(VideoEvent videoEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, videoEvent)) == null) {
            IVideoEventInterceptor iVideoEventInterceptor = this.mInterceptor;
            if (iVideoEventInterceptor != null && iVideoEventInterceptor.getInterceptorLayer() != videoEvent.getSender() && this.mInterceptor.onInterceptorEvent(videoEvent)) {
                BdVideoLog.d("AbsMessenger", "isNeedIntercept() = true, event = " + videoEvent);
                videoEvent.recycle();
                return true;
            }
            List<IVideoEventInterceptor> list = this.mInterceptorList;
            if (list != null) {
                for (IVideoEventInterceptor iVideoEventInterceptor2 : list) {
                    if (iVideoEventInterceptor2.getInterceptorLayer() != videoEvent.getSender() && iVideoEventInterceptor2.onInterceptorEvent(videoEvent)) {
                        BdVideoLog.d("AbsMessenger", "isNeedIntercept() = true, event = " + videoEvent);
                        videoEvent.recycle();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void notifyEvent(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoEvent) == null) {
            String type = getType();
            BdVideoLog.v(type, System.identityHashCode(this) + " notifyEvent " + videoEvent);
            if (videoEvent.getPriority() == 1) {
                if (isNeedIntercept(videoEvent)) {
                    return;
                }
                dispatchEvent(videoEvent);
                videoEvent.recycle();
                return;
            }
            publishEventToQueue(videoEvent);
        }
    }

    public abstract void publishEventToQueue(@NonNull VideoEvent videoEvent);

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void register(int i, @NonNull INeuron iNeuron) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, iNeuron) == null) {
            CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(iNeuron)) {
                int expectOrder = iNeuron.getExpectOrder();
                if (expectOrder == 0) {
                    copyOnWriteArrayList.add(iNeuron);
                } else if (expectOrder == 1) {
                    copyOnWriteArrayList.add(0, iNeuron);
                } else if (expectOrder == 2) {
                    copyOnWriteArrayList.add(copyOnWriteArrayList.size(), iNeuron);
                }
            }
            this.mSubscribers.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List<InternalEventDispatcher> list = this.mDispatcherList;
            if (list != null) {
                list.clear();
                this.mDispatcherList = null;
            }
            this.mSubscribers.clear();
            this.mInterceptor = null;
            List<IVideoEventInterceptor> list2 = this.mInterceptorList;
            if (list2 != null) {
                list2.clear();
                this.mInterceptorList = null;
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        List<IVideoEventInterceptor> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, iVideoEventInterceptor) == null) || (list = this.mInterceptorList) == null) {
            return;
        }
        list.remove(iVideoEventInterceptor);
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void removeInternalDispatcher(@NonNull InternalEventDispatcher internalEventDispatcher) {
        List<InternalEventDispatcher> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, internalEventDispatcher) == null) || (list = this.mDispatcherList) == null) {
            return;
        }
        list.remove(internalEventDispatcher);
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    @Deprecated
    public void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iVideoEventInterceptor) == null) {
            this.mInterceptor = iVideoEventInterceptor;
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void unregister(INeuron iNeuron) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iNeuron) == null) {
            for (CopyOnWriteArrayList<INeuron> copyOnWriteArrayList : this.mSubscribers.values()) {
                copyOnWriteArrayList.remove(iNeuron);
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInterceptor(int i, @NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, iVideoEventInterceptor) == null) {
            if (this.mInterceptorList == null) {
                this.mInterceptorList = new ArrayList();
            }
            this.mInterceptorList.add(i, iVideoEventInterceptor);
        }
    }
}
