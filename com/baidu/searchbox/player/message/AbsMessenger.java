package com.baidu.searchbox.player.message;

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
/* loaded from: classes2.dex */
public abstract class AbsMessenger implements IMessenger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List mDispatcherList;
    public IVideoEventInterceptor mInterceptor;
    public List mInterceptorList;
    public final ConcurrentHashMap mSubscribers;

    public abstract void publishEventToQueue(VideoEvent videoEvent);

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
        this.mSubscribers = new ConcurrentHashMap();
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            List list = this.mDispatcherList;
            if (list != null) {
                list.clear();
                this.mDispatcherList = null;
            }
            this.mSubscribers.clear();
            this.mInterceptor = null;
            List list2 = this.mInterceptorList;
            if (list2 != null) {
                list2.clear();
                this.mInterceptorList = null;
            }
        }
    }

    private void internalDispatch(VideoEvent videoEvent) {
        List<InternalEventDispatcher> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, videoEvent) == null) && (list = this.mDispatcherList) != null) {
            for (InternalEventDispatcher internalEventDispatcher : list) {
                internalEventDispatcher.onVideoEventNotify(videoEvent);
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVideoEventInterceptor) == null) {
            List list = this.mInterceptorList;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            addInterceptor(size, iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInternalDispatcher(InternalEventDispatcher internalEventDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, internalEventDispatcher) == null) {
            performAddInternalDispatcher(internalEventDispatcher);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void removeInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, iVideoEventInterceptor) == null) && (list = this.mInterceptorList) != null) {
            list.remove(iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void removeInternalDispatcher(InternalEventDispatcher internalEventDispatcher) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, internalEventDispatcher) == null) && (list = this.mDispatcherList) != null) {
            list.remove(internalEventDispatcher);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    @Deprecated
    public void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iVideoEventInterceptor) == null) {
            this.mInterceptor = iVideoEventInterceptor;
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void unregister(INeuron iNeuron) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iNeuron) == null) {
            for (CopyOnWriteArrayList copyOnWriteArrayList : this.mSubscribers.values()) {
                copyOnWriteArrayList.remove(iNeuron);
            }
        }
    }

    private void performAddInternalDispatcher(InternalEventDispatcher internalEventDispatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, internalEventDispatcher) == null) {
            if (this.mDispatcherList == null) {
                this.mDispatcherList = new ArrayList();
            }
            if (!this.mDispatcherList.contains(internalEventDispatcher)) {
                int expectOrder = internalEventDispatcher.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            List list = this.mDispatcherList;
                            list.add(list.size(), internalEventDispatcher);
                            return;
                        }
                        return;
                    }
                    this.mDispatcherList.add(0, internalEventDispatcher);
                    return;
                }
                this.mDispatcherList.add(internalEventDispatcher);
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
    public void notifyEvent(VideoEvent videoEvent) {
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

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInterceptor(int i, IVideoEventInterceptor iVideoEventInterceptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, iVideoEventInterceptor) == null) {
            if (this.mInterceptorList == null) {
                this.mInterceptorList = new ArrayList();
            }
            this.mInterceptorList.add(i, iVideoEventInterceptor);
        }
    }

    public void dispatchEvent(VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) {
            printDispatchLog(videoEvent);
            internalDispatch(videoEvent);
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mSubscribers.get(Integer.valueOf(videoEvent.getType()));
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    INeuron iNeuron = (INeuron) it.next();
                    if (!videoEvent.filter(iNeuron)) {
                        switch (videoEvent.getType()) {
                            case -1:
                            case 6:
                                iNeuron.onVideoEventNotify(videoEvent);
                                continue;
                            case 1:
                                iNeuron.onSystemEventNotify(videoEvent);
                                continue;
                            case 2:
                                iNeuron.onControlEventNotify(videoEvent);
                                continue;
                            case 3:
                                iNeuron.onLayerEventNotify(videoEvent);
                                continue;
                            case 4:
                                iNeuron.onPlayerEventNotify(videoEvent);
                                continue;
                            case 5:
                                iNeuron.onPlayerStatusChanged((PlayerStatus) videoEvent.getExtra(2), (PlayerStatus) videoEvent.getExtra(1));
                                continue;
                            case 7:
                                if (iNeuron instanceof IPlugin) {
                                    ((IPlugin) iNeuron).onPluginEventNotify(videoEvent);
                                    break;
                                } else {
                                    iNeuron.onVideoEventNotify(videoEvent);
                                    continue;
                                }
                            case 8:
                                iNeuron.onInteractiveEventNotify(videoEvent);
                                continue;
                        }
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
    public void register(int i, INeuron iNeuron) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, iNeuron) == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.mSubscribers.get(Integer.valueOf(i));
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
            }
            if (!copyOnWriteArrayList.contains(iNeuron)) {
                int expectOrder = iNeuron.getExpectOrder();
                if (expectOrder != 0) {
                    if (expectOrder != 1) {
                        if (expectOrder == 2) {
                            copyOnWriteArrayList.add(copyOnWriteArrayList.size(), iNeuron);
                        }
                    } else {
                        copyOnWriteArrayList.add(0, iNeuron);
                    }
                } else {
                    copyOnWriteArrayList.add(iNeuron);
                }
            }
            this.mSubscribers.put(Integer.valueOf(i), copyOnWriteArrayList);
        }
    }
}
