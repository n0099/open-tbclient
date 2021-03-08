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
    private List<View> aFK;
    private int aFx;
    private int aFy;
    private boolean aFz;
    private a bZj;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bZj = aVar;
    }

    public void setCanAddNext() {
        this.aFz = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aFK = new ArrayList();
        this.aFx = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aFy = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
