package com.baidu.searchbox.track;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.track.ui.EvictingDeque;
import com.baidu.searchbox.track.ui.OnFragmentTraceListener;
import com.baidu.searchbox.track.ui.TraceManager;
import com.baidu.searchbox.track.ui.TrackUI;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class Track {
    public static final int UI_TRACK_CAPACITY = 20;
    public Object mLockListener;
    public Object mLockTrackUI;
    public EvictingDeque<TrackUI> mTrackUIDeque;
    public LinkedList<OnTrackUIListener> mTrackUIListeners;

    /* loaded from: classes2.dex */
    public interface OnTrackUIListener {
        void onAddTrackUI(TrackUI trackUI);
    }

    /* loaded from: classes2.dex */
    public static final class TrackCreator {
        public static final Track mTrace = new Track();
    }

    public static Track getInstance() {
        return TrackCreator.mTrace;
    }

    public void addTrackUI(@NonNull TrackUI trackUI) {
        if (trackUI != null) {
            synchronized (this.mLockTrackUI) {
                this.mTrackUIDeque.offerLast(trackUI);
            }
            return;
        }
        throw new NullPointerException("trackUI should not be null");
    }

    public void addTrackUIListener(@NonNull OnTrackUIListener onTrackUIListener) {
        synchronized (this.mLockListener) {
            if (!this.mTrackUIListeners.contains(onTrackUIListener)) {
                this.mTrackUIListeners.add(onTrackUIListener);
            }
        }
    }

    public LinkedList<TrackUI> getAllTrackUIs() {
        LinkedList<TrackUI> linkedList;
        synchronized (this.mLockTrackUI) {
            linkedList = new LinkedList<>(this.mTrackUIDeque.getElements());
        }
        return linkedList;
    }

    @Nullable
    public TrackUI getLastTrackUI() {
        TrackUI peekLast;
        synchronized (this.mLockTrackUI) {
            peekLast = this.mTrackUIDeque.peekLast();
        }
        return peekLast;
    }

    public LinkedList<OnTrackUIListener> getTrackUIListeners() {
        return this.mTrackUIListeners;
    }

    public boolean isForeground() {
        return BdBoxActivityManager.isForeground();
    }

    public void removeTrackUIListener(@NonNull OnTrackUIListener onTrackUIListener) {
        synchronized (this.mLockListener) {
            this.mTrackUIListeners.remove(onTrackUIListener);
        }
    }

    public void setOnFragmentTraceListener(@Nullable OnFragmentTraceListener onFragmentTraceListener) {
        TraceManager.getInstance().setOnFragmentListener(onFragmentTraceListener);
    }

    public void setTrackUICapacity(int i2) {
        if (i2 >= 0) {
            this.mTrackUIDeque.setCapacity(i2);
            return;
        }
        throw new IllegalArgumentException("capacity should not < 0");
    }

    public void startTrack(Context context) {
        if (TraceManager.getInstance().isRegistered()) {
            return;
        }
        TraceManager.getInstance().register(context);
    }

    public Track() {
        this.mLockTrackUI = new Object();
        this.mLockListener = new Object();
        this.mTrackUIDeque = EvictingDeque.create(20);
        this.mTrackUIListeners = new LinkedList<>();
    }
}
