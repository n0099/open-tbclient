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
/* loaded from: classes5.dex */
public class Track {
    private static final int UI_TRACK_CAPACITY = 20;
    private Object mLockListener;
    private Object mLockTrackUI;
    private EvictingDeque<TrackUI> mTrackUIDeque;
    private LinkedList<OnTrackUIListener> mTrackUIListeners;

    /* loaded from: classes5.dex */
    public interface OnTrackUIListener {
        void onAddTrackUI(TrackUI trackUI);
    }

    private Track() {
        this.mLockTrackUI = new Object();
        this.mLockListener = new Object();
        this.mTrackUIDeque = EvictingDeque.create(20);
        this.mTrackUIListeners = new LinkedList<>();
    }

    public static Track getInstance() {
        return TrackCreator.mTrace;
    }

    public void startTrack(Context context) {
        if (!TraceManager.getInstance().isRegistered()) {
            TraceManager.getInstance().register(context);
        }
    }

    public void setOnFragmentTraceListener(@Nullable OnFragmentTraceListener onFragmentTraceListener) {
        TraceManager.getInstance().setOnFragmentListener(onFragmentTraceListener);
    }

    public void setTrackUICapacity(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity should not < 0");
        }
        this.mTrackUIDeque.setCapacity(i);
    }

    public LinkedList<TrackUI> getAllTrackUIs() {
        LinkedList<TrackUI> linkedList;
        synchronized (this.mLockTrackUI) {
            linkedList = new LinkedList<>(this.mTrackUIDeque.getElements());
        }
        return linkedList;
    }

    public void addTrackUI(@NonNull TrackUI trackUI) {
        if (trackUI == null) {
            throw new NullPointerException("trackUI should not be null");
        }
        synchronized (this.mLockTrackUI) {
            this.mTrackUIDeque.offerLast(trackUI);
        }
    }

    @Nullable
    public TrackUI getLastTrackUI() {
        TrackUI peekLast;
        synchronized (this.mLockTrackUI) {
            peekLast = this.mTrackUIDeque.peekLast();
        }
        return peekLast;
    }

    public boolean isForeground() {
        return BdBoxActivityManager.isForeground();
    }

    public void addTrackUIListener(@NonNull OnTrackUIListener onTrackUIListener) {
        synchronized (this.mLockListener) {
            if (!this.mTrackUIListeners.contains(onTrackUIListener)) {
                this.mTrackUIListeners.add(onTrackUIListener);
            }
        }
    }

    public void removeTrackUIListener(@NonNull OnTrackUIListener onTrackUIListener) {
        synchronized (this.mLockListener) {
            this.mTrackUIListeners.remove(onTrackUIListener);
        }
    }

    public LinkedList<OnTrackUIListener> getTrackUIListeners() {
        return this.mTrackUIListeners;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class TrackCreator {
        private static final Track mTrace = new Track();

        private TrackCreator() {
        }
    }
}
