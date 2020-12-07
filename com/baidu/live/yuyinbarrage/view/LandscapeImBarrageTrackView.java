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
    private int aGG;
    private int aGH;
    private boolean aGI;
    private List<View> aGT;
    private a bSP;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bSP = aVar;
    }

    public void setCanAddNext() {
        this.aGI = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aGT = new ArrayList();
        this.aGG = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGH = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
