package com.baidu.searchbox.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class LayerContainer extends FrameLayout {
    public ArrayList<AbsLayer> mLayers;
    public FrameLayout.LayoutParams mLayoutParams;
    public BDVideoPlayer mPlayer;

    public LayerContainer(@NonNull Context context) {
        super(context);
        init();
    }

    public void addLayer(@NonNull AbsLayer absLayer) {
        addLayer(absLayer, getContainerParams());
    }

    public void attachKernelLayer(@NonNull AbsLayer absLayer) {
        detachLayer(absLayer);
        absLayer.setLayerContainer(this);
        absLayer.attachMessenger(getBindPlayer().getMessenger());
        this.mLayers.add(0, absLayer);
        if (absLayer.getContentView() != null) {
            addView(absLayer.getContentView(), 0, this.mLayoutParams);
        }
    }

    public void attachLayerMessenger(@NonNull AbsLayer absLayer) {
        absLayer.attachMessenger(getBindPlayer().getMessenger());
    }

    public void bindPlayer(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    public void detachLayer(@NonNull AbsLayer absLayer) {
        detachLayer(absLayer, false);
    }

    public void detachLayerMessenger(@NonNull AbsLayer absLayer) {
        absLayer.detachMessenger();
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void detachLayer(@NonNull AbsLayer absLayer, boolean z) {
        if (absLayer instanceof BaseKernelLayer) {
            this.mPlayer.onKernelLayerPreDetach();
        }
        this.mLayers.remove(absLayer);
        absLayer.onLayerDetach();
        BdPlayerUtils.removeViewFromParent(absLayer.getContentView());
        if (z) {
            absLayer.detachMessenger();
        }
    }

    public void insertLayer(@NonNull AbsLayer absLayer, @IntRange(from = 0, to = 20) int i) {
        detachLayer(absLayer);
        if (i < this.mLayers.size()) {
            absLayer.setLayerContainer(this);
            absLayer.attachMessenger(getBindPlayer().getMessenger());
            this.mLayers.add(i, absLayer);
            addView(absLayer.getContentView(), i, getContainerParams());
        }
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mLayers = new ArrayList<>();
        this.mLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    }

    @NonNull
    public BDVideoPlayer getBindPlayer() {
        return this.mPlayer;
    }

    public FrameLayout.LayoutParams getContainerParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public ArrayList<AbsLayer> getLayerList() {
        return this.mLayers;
    }

    public void onContainerDetach() {
        ArrayList<AbsLayer> arrayList = this.mLayers;
        if (arrayList != null) {
            Iterator<AbsLayer> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onContainerDetach();
            }
        }
    }

    public void release() {
        int size = this.mLayers.size();
        for (int i = 0; i < size; i++) {
            this.mLayers.get(i).onLayerRelease();
        }
        this.mLayers.clear();
        removeAllViews();
    }

    public boolean addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        if (this.mLayers.contains(absLayer)) {
            return false;
        }
        absLayer.setLayerContainer(this);
        absLayer.initLayer();
        absLayer.attachMessenger(getBindPlayer().getMessenger());
        this.mLayers.add(absLayer);
        if (absLayer.getContentView() == null || absLayer.getContentView() == this) {
            return false;
        }
        addView(absLayer.getContentView(), layoutParams);
        return true;
    }

    public void insertLayer(@NonNull AbsLayer absLayer, @Nullable FrameLayout.LayoutParams layoutParams) {
        if (this.mLayers.contains(absLayer)) {
            return;
        }
        detachLayer(absLayer);
        absLayer.setLayerContainer(this);
        absLayer.attachMessenger(getBindPlayer().getMessenger());
        this.mLayers.add(absLayer);
        if (layoutParams == null) {
            layoutParams = getContainerParams();
        }
        if (absLayer.getContentView() != this) {
            addView(absLayer.getContentView(), layoutParams);
        }
    }

    @Deprecated
    public void detachLayer(@NonNull ILayer iLayer) {
        if (iLayer instanceof AbsLayer) {
            detachLayer((AbsLayer) iLayer, false);
        }
    }

    @Deprecated
    public void detachLayer(@NonNull ILayer iLayer, boolean z) {
        if (iLayer instanceof AbsLayer) {
            detachLayer((AbsLayer) iLayer, z);
        }
    }
}
