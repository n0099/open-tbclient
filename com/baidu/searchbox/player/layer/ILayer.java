package com.baidu.searchbox.player.layer;

import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes11.dex */
public interface ILayer extends INeuron {
    View getContentView();

    @NonNull
    LayerContainer getLayerContainer();

    void initLayer();

    void onContainerDetach();

    void onLayerDetach();

    void onLayerRelease();
}
