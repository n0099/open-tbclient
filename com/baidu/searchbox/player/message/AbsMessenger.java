package com.baidu.searchbox.player.message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.plugin.IPlugin;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public abstract class AbsMessenger implements IMessenger {
    @Nullable
    public List<InternalEventDispatcher> mDispatcherList;
    @Nullable
    public IVideoEventInterceptor mInterceptor;
    @Nullable
    public List<IVideoEventInterceptor> mInterceptorList;
    public final ConcurrentHashMap<Integer, CopyOnWriteArrayList<INeuron>> mSubscribers = new ConcurrentHashMap<>();

    public abstract void publishEventToQueue(@NonNull VideoEvent videoEvent);

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void release() {
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

    private void internalDispatch(VideoEvent videoEvent) {
        List<InternalEventDispatcher> list = this.mDispatcherList;
        if (list != null) {
            for (InternalEventDispatcher internalEventDispatcher : list) {
                internalEventDispatcher.onVideoEventNotify(videoEvent);
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        int size;
        List<IVideoEventInterceptor> list = this.mInterceptorList;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        addInterceptor(size, iVideoEventInterceptor);
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInternalDispatcher(@NonNull InternalEventDispatcher internalEventDispatcher) {
        performAddInternalDispatcher(internalEventDispatcher);
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        List<IVideoEventInterceptor> list = this.mInterceptorList;
        if (list != null) {
            list.remove(iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void removeInternalDispatcher(@NonNull InternalEventDispatcher internalEventDispatcher) {
        List<InternalEventDispatcher> list = this.mDispatcherList;
        if (list != null) {
            list.remove(internalEventDispatcher);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    @Deprecated
    public void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
        this.mInterceptor = iVideoEventInterceptor;
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void unregister(INeuron iNeuron) {
        for (CopyOnWriteArrayList<INeuron> copyOnWriteArrayList : this.mSubscribers.values()) {
            copyOnWriteArrayList.remove(iNeuron);
        }
    }

    private void performAddInternalDispatcher(InternalEventDispatcher internalEventDispatcher) {
        if (this.mDispatcherList == null) {
            this.mDispatcherList = new ArrayList();
        }
        if (!this.mDispatcherList.contains(internalEventDispatcher)) {
            int expectOrder = internalEventDispatcher.getExpectOrder();
            if (expectOrder != 0) {
                if (expectOrder != 1) {
                    if (expectOrder == 2) {
                        List<InternalEventDispatcher> list = this.mDispatcherList;
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

    private void printDispatchLog(VideoEvent videoEvent) {
        if (videoEvent.getLogLevel() == 0) {
            String type = getType();
            BdVideoLog.d(type, System.identityHashCode(this) + ": dispatch event :" + videoEvent);
            return;
        }
        String type2 = getType();
        BdVideoLog.v(type2, System.identityHashCode(this) + ": dispatch event :" + videoEvent);
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void notifyEvent(@NonNull VideoEvent videoEvent) {
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

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void addInterceptor(int i, @NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        if (this.mInterceptorList == null) {
            this.mInterceptorList = new ArrayList();
        }
        this.mInterceptorList.add(i, iVideoEventInterceptor);
    }

    public void dispatchEvent(VideoEvent videoEvent) {
        printDispatchLog(videoEvent);
        internalDispatch(videoEvent);
        CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(videoEvent.getType()));
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
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

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void register(int i, @NonNull INeuron iNeuron) {
        CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(i));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
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
