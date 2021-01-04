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
    private int aGX;
    private int aGY;
    private boolean aGZ;
    private List<View> aHk;
    private a bYw;

    /* loaded from: classes11.dex */
    public interface a {
    }

    public LandscapeImBarrageTrackView(@NonNull Context context) {
        super(context);
        init();
    }

    public void setCallback(a aVar) {
        this.bYw = aVar;
    }

    public void setCanAddNext() {
        this.aGZ = true;
    }

    private void init() {
        setBackgroundColor(0);
        this.aHk = new ArrayList();
        this.aGX = getResources().getDimensionPixelOffset(a.d.sdk_ds110);
        this.aGY = getResources().getDimensionPixelOffset(a.d.sdk_ds120);
    }
}
