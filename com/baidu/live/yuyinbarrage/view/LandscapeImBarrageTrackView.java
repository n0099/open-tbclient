package com.baidu.live.yuyinbarrage.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class LandscapeImBarrageTrackView extends FrameLayout {
    private int aDX;
    private int aDY;
    private boolean aDZ;
    private List<View> aEk;
    private a bXJ;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bXJ = aVar;
    }

    public void setCanAddNext() {
        this.aDZ = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aEk = new ArrayList();
        this.aDX = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aDY = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
