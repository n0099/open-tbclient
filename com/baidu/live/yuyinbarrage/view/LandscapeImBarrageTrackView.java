package com.baidu.live.yuyinbarrage.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aEV;
    private int aEW;
    private boolean aEX;
    private List<View> aFi;
    private a bJN;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bJN = aVar;
    }

    public void setCanAddNext() {
        this.aEX = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aFi = new ArrayList();
        this.aEV = getResources().getDimensionPixelOffset(a.e.sdk_ds110);
        this.aEW = getResources().getDimensionPixelOffset(a.e.sdk_ds120);
    }
}
