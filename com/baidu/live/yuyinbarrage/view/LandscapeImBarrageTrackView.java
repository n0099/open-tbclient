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
    private int aEa;
    private int aEb;
    private boolean aEc;
    private List<View> aEn;
    private a bNJ;

    /* loaded from: classes4.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bNJ = aVar;
    }

    public void setCanAddNext() {
        this.aEc = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aEn = new ArrayList();
        this.aEa = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aEb = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
