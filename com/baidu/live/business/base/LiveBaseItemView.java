package com.baidu.live.business.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.Live4Ratio5BannerItemView;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveRoomEntity;
/* loaded from: classes2.dex */
public abstract class LiveBaseItemView extends RelativeLayout {
    public boolean a;
    public float b;
    public String c;
    public LiveFeedConfig d;
    public Live4Ratio5BannerItemView.c e;
    public a f;
    public b g;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i);

        void b(int i);
    }

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public abstract void setData(LiveRoomEntity liveRoomEntity, int i);

    public abstract void setIsCurViewing(boolean z);

    public void setUiMode(String str) {
    }

    public LiveBaseItemView(Context context) {
        super(context);
        this.a = false;
        this.b = 1.0f;
        this.c = LiveFeedPageSdk.HOST_LIVE_TAB;
    }

    public void setAspectRatio(float f) {
        this.b = f;
    }

    public void setBannerClickListener(Live4Ratio5BannerItemView.c cVar) {
        this.e = cVar;
    }

    public void setFeedConfig(LiveFeedConfig liveFeedConfig) {
        this.d = liveFeedConfig;
    }

    public void setNeedRatio(boolean z) {
        this.a = z;
    }

    public void setOnLabelClickListener(a aVar) {
        this.f = aVar;
    }

    public void setOnTopicItemClickListener(b bVar) {
        this.g = bVar;
    }

    public void setScene(String str) {
        this.c = str;
    }

    public LiveBaseItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.b = 1.0f;
        this.c = LiveFeedPageSdk.HOST_LIVE_TAB;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.a) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.b), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public LiveBaseItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
        this.b = 1.0f;
        this.c = LiveFeedPageSdk.HOST_LIVE_TAB;
    }
}
