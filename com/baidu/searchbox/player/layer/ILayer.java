package com.baidu.searchbox.player.layer;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes4.dex */
public interface ILayer extends INeuron {
    View getContentView();

    @Nullable
    LayerContainer getLayerContainer();

    void initLayer();

    void onContainerDetach();

    void onLayerDetach();

    void onLayerRelease();
}
