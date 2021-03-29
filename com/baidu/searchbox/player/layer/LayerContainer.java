package com.baidu.searchbox.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class LayerContainer extends FrameLayout {
    public ArrayList<ILayer> mLayers;
    public FrameLayout.LayoutParams mLayoutParams;
    public BDVideoPlayer mPlayer;

    public LayerContainer(@NonNull Context context) {
        super(context);
        init();
    }

    private void init() {
        this.mLayers = new ArrayList<>();
        this.mLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        addLayer(absLayer, this.mLayoutParams);
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull AbsLayer absLayer) {
        detachLayer(absLayer);
        absLayer.setLayerContainer(this);
        this.mLayers.add(0, absLayer);
        if (absLayer.getContentView() != null) {
            addView(absLayer.getContentView(), 0, this.mLayoutParams);
        }
    }

    public void bindPlayer(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    @PublicMethod
    public void detachLayer(@NonNull ILayer iLayer) {
        detachLayer(iLayer, false);
    }

    @NonNull
    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        return this.mPlayer;
    }

    @PublicMethod
    public ArrayList<ILayer> getLayerList() {
        return this.mLayers;
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer, @IntRange(from = 0, to = 20) int i) {
        detachLayer(absLayer);
        if (i < this.mLayers.size()) {
            absLayer.setLayerContainer(this);
            this.mLayers.add(i, absLayer);
            addView(absLayer.getContentView(), i, this.mLayoutParams);
        }
    }

    public void onContainerDetach() {
        ArrayList<ILayer> arrayList = this.mLayers;
        if (arrayList != null) {
            Iterator<ILayer> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onContainerDetach();
            }
        }
    }

    @PublicMethod
    public void release() {
        int size = this.mLayers.size();
        for (int i = 0; i < size; i++) {
            this.mLayers.get(i).onLayerRelease();
        }
        this.mLayers.clear();
        removeAllViews();
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        if (this.mLayers.contains(absLayer)) {
            return;
        }
        absLayer.setLayerContainer(this);
        absLayer.initLayer();
        this.mLayers.add(absLayer);
        if (absLayer.getContentView() == null || absLayer.getContentView() == this) {
            return;
        }
        addView(absLayer.getContentView(), layoutParams);
    }

    @PublicMethod
    public void detachLayer(@NonNull ILayer iLayer, boolean z) {
        BDVideoPlayer bDVideoPlayer;
        ViewGroup viewGroup;
        this.mLayers.remove(iLayer);
        iLayer.onLayerDetach();
        if (iLayer.getContentView() != null && (viewGroup = (ViewGroup) iLayer.getContentView().getParent()) != null) {
            viewGroup.removeView(iLayer.getContentView());
        }
        if (!z || (bDVideoPlayer = this.mPlayer) == null) {
            return;
        }
        bDVideoPlayer.getVideoSession().unregisterLayer(iLayer);
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LayerContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer, @Nullable FrameLayout.LayoutParams layoutParams) {
        if (this.mLayers.contains(absLayer)) {
            return;
        }
        absLayer.setLayerContainer(this);
        this.mLayers.add(absLayer);
        if (layoutParams == null) {
            layoutParams = this.mLayoutParams;
        }
        if (absLayer.getContentView() != this) {
            addView(absLayer.getContentView(), layoutParams);
        }
    }
}
