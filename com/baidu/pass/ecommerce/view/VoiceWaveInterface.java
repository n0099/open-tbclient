package com.baidu.pass.ecommerce.view;

import android.view.ViewGroup;
/* loaded from: classes2.dex */
public interface VoiceWaveInterface {
    void changeVolume(float f);

    void removeFromParent();

    void reset();

    void showInParentView(ViewGroup viewGroup);

    void start();

    void stop();
}
