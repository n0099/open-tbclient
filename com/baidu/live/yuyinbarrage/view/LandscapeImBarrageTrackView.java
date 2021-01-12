package com.baidu.live.yuyinbarrage.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aCk;
    private int aCl;
    private boolean aCm;
    private List<View> aCx;
    private a bTK;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bTK = aVar;
    }

    public void setCanAddNext() {
        this.aCm = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aCx = new ArrayList();
        this.aCk = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aCl = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
