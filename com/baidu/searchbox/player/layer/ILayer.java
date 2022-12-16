package com.baidu.searchbox.player.layer;

import android.view.View;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes3.dex */
public interface ILayer extends INeuron {
    View getContentView();

    LayerContainer getLayerContainer();

    void initLayer();

    void onContainerDetach();

    void onLayerDetach();

    void onLayerRelease();
}
