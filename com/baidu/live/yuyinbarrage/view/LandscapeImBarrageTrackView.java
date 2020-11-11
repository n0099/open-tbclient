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
    private int aFL;
    private int aFM;
    private boolean aFN;
    private List<View> aFY;
    private a bPt;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bPt = aVar;
    }

    public void setCanAddNext() {
        this.aFN = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aFY = new ArrayList();
        this.aFL = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aFM = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
