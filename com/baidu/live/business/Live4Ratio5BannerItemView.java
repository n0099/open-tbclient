package com.baidu.live.business;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.tieba.R;
import com.baidu.tieba.g60;
import com.baidu.tieba.i80;
import java.util.List;
/* loaded from: classes3.dex */
public class Live4Ratio5BannerItemView extends LiveBaseItemView {
    public FrameLayout h;
    public BannerView i;
    public boolean j;
    public Context k;

    /* loaded from: classes3.dex */
    public interface c {
        void a(LiveBannerEntity liveBannerEntity);

        void b(LiveBannerEntity liveBannerEntity);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
    }

    /* loaded from: classes3.dex */
    public class a implements BannerView.g {
        public a() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.g
        public void a(LiveBannerEntity liveBannerEntity) {
            if (Live4Ratio5BannerItemView.this.e != null && liveBannerEntity != null) {
                Live4Ratio5BannerItemView.this.e.b(liveBannerEntity);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BannerView.i {
        public b() {
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public void onBannerShow(LiveBannerEntity liveBannerEntity) {
            if (Live4Ratio5BannerItemView.this.e != null && liveBannerEntity != null) {
                Live4Ratio5BannerItemView.this.e.a(liveBannerEntity);
            }
        }
    }

    public Live4Ratio5BannerItemView(Context context) {
        super(context);
        this.j = false;
        k(context);
    }

    public final void k(Context context) {
        setNeedRatio(true);
        setAspectRatio(1.25f);
        this.k = context;
        this.h = (FrameLayout) RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d05f1, this).findViewById(R.id.obfuscated_res_0x7f09169c);
        j();
    }

    public Live4Ratio5BannerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        k(context);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        l(liveRoomEntity.bannerList);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        super.a();
        i();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        super.b();
        h();
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        super.c();
        h();
    }

    public final void h() {
        BannerView bannerView = this.i;
        if (bannerView != null) {
            bannerView.w();
        }
    }

    public final void i() {
        BannerView bannerView = this.i;
        if (bannerView != null && this.j) {
            bannerView.x();
        }
    }

    public final void j() {
        BannerView bannerView = new BannerView(this.k);
        this.i = bannerView;
        bannerView.setShowRoundPicture(true, 10);
        this.i.setIndicatorGravity(81);
        this.i.setIndicatorMargin(0, 0, 0, (int) g60.c(this.k.getResources(), 7.0f));
        this.i.setLargeIndicatorItemSize((int) g60.c(this.k.getResources(), 4.0f));
        this.i.setSmallIndicatorItemSize((int) g60.c(this.k.getResources(), 4.0f));
        this.i.setIndicatorInterval((int) g60.c(this.k.getResources(), 6.0f));
        this.i.setAspectRatio(1.25f);
        this.i.setScene(this.c);
        this.i.setOnBannerClickListener(new a());
        this.i.setOnBannerShowListener(new b());
        this.h.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void l(List<LiveBannerEntity> list) {
        if (this.i != null && this.h != null) {
            int i = 8;
            if (!i80.c(list)) {
                if (this.i.r(list)) {
                    BannerEntity bannerEntity = new BannerEntity();
                    bannerEntity.mBannerList = list;
                    bannerEntity.mBroadcastInterval = 5000;
                    this.i.setBannerEntity(bannerEntity);
                }
                this.i.setVisibility(0);
                this.j = true;
            } else {
                this.j = false;
                this.i.setVisibility(8);
            }
            FrameLayout frameLayout = this.h;
            if (this.i.getVisibility() == 0) {
                i = 0;
            }
            frameLayout.setVisibility(i);
        }
    }
}
