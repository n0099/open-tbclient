package com.baidu.searchbox.player.layer;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes2.dex */
public interface ILayer extends INeuron {
    View getContentView();

    @NonNull
    LayerContainer getLayerContainer();

    void initLayer();

    void onContainerDetach();

    void onLayerDetach();

    void onLayerRelease();
}
