package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class HeadPendantView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f12303e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f12304f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f12305g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f12306h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f12307i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f12303e = context;
        d();
    }

    public final void a() {
        ImageView imageView = new ImageView(this.f12303e);
        this.f12306h = imageView;
        imageView.setImageDrawable(null);
        int i2 = this.m;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.f12306h.setLayoutParams(layoutParams);
        this.f12306h.setVisibility(8);
        addView(this.f12306h);
    }

    public final void b() {
        HeadImageView headImageView = new HeadImageView(this.f12303e);
        this.f12307i = headImageView;
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f12307i.setPlaceHolder(1);
        this.f12307i.setDefaultResource(R.color.CAM_X0205);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.f12307i.setLayoutParams(layoutParams);
        addView(this.f12307i);
    }

    public final void c() {
        TbImageView tbImageView = new TbImageView(this.f12303e);
        this.f12305g = tbImageView;
        tbImageView.setPageId(this.f12304f);
        this.f12305g.setDefaultBgResource(0);
        this.f12305g.setDefaultResource(0);
        this.f12305g.setImageDrawable(null);
        this.f12305g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f12305g.setVisibility(8);
        addView(this.f12305g);
    }

    public void d() {
        this.m = l.g(getContext(), R.dimen.tbds42);
        b();
        c();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public final void e() {
        ImageView imageView;
        if (this.m <= 0 || (imageView = this.f12306h) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i2 = this.m;
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f12306h.setLayoutParams(layoutParams);
    }

    public final void f(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        if (this.o) {
            this.f12306h.setVisibility(8);
            return;
        }
        this.f12307i.setShowV(false);
        if (UtilHelper.showOfficialIcon(this.f12306h, metaData)) {
            return;
        }
        if (metaData.isNewGod()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f12306h, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            g(true);
            return;
        }
        g(false);
        if (this.l || !UtilHelper.showHeadBazhuIcon(this.f12306h, metaData, this.p)) {
            UtilHelper.showHeadBjhBigVIcon(this.f12306h, metaData, this.n);
        }
    }

    public void g(boolean z) {
        ImageView imageView = this.f12306h;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public ImageView getBigVIconView() {
        return this.f12306h;
    }

    public HeadImageView getHeadView() {
        return this.f12307i;
    }

    public TbImageView getPendantView() {
        return this.f12305g;
    }

    public void h(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        if (metaData.getPendantData() != null) {
            l(metaData.getPendantData().a());
        } else {
            l(null);
        }
        f(metaData);
    }

    public void i(MetaData metaData, int i2) {
        if (metaData == null) {
            return;
        }
        this.n = i2;
        h(metaData);
    }

    public void j(String str, int i2, boolean z) {
        this.f12307i.R(str, i2, 0, 0, z);
    }

    public void k(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(str);
        this.f12307i.setImageBitmap(null);
        this.f12307i.setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            j(headPortraitFilter, 10, false);
        } else {
            j(headPortraitFilter, 25, false);
        }
    }

    public void l(String str) {
        if (this.f12305g == null) {
            return;
        }
        if (this.j && !StringUtils.isNull(str)) {
            this.f12305g.setVisibility(0);
            this.f12305g.setImageDrawable(null);
            this.f12305g.V(str, 10, false);
            return;
        }
        this.f12305g.setVisibility(8);
    }

    public void m(MetaData metaData) {
        if (metaData == null || TextUtils.isEmpty(metaData.getPortrait())) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(metaData.getAvater());
        setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            j(headPortraitFilter, 10, false);
        } else {
            j(headPortraitFilter, 25, false);
        }
        h(metaData);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.j) {
            int size = View.MeasureSpec.getSize(i2);
            int i4 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i3) * 0.13f);
            ((RelativeLayout.LayoutParams) this.f12307i.getLayoutParams()).setMargins(i4, size2, i4, size2);
            ImageView imageView = this.f12306h;
            if (imageView != null) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i4, size2, i4, size2);
            }
        }
        if (this.k) {
            ((RelativeLayout.LayoutParams) this.f12307i.getLayoutParams()).setMargins(0, 0, 0, 0);
            ImageView imageView2 = this.f12306h;
            if (imageView2 != null) {
                ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setAuthIconType(int i2) {
        this.n = i2;
    }

    public void setAutoChangeStyle(boolean z) {
        this.f12305g.setAutoChangeStyle(z);
        this.f12307i.setAutoChangeStyle(z);
    }

    public void setBigVDimenSize(int i2) {
        if (i2 > 0) {
            this.m = l.g(getContext(), i2);
        }
        e();
    }

    public void setBigVIconResId(int i2) {
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.k = z;
    }

    public void setDefalutResid(int i2) {
        this.f12307i.setDefaultResource(i2);
    }

    public void setHasPendantStyle() {
        this.j = true;
    }

    public void setIsHomePage(boolean z) {
        this.l = z;
    }

    public void setIsclearmode(boolean z) {
        this.o = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.f12304f = bdUniqueId;
        HeadImageView headImageView = this.f12307i;
        if (headImageView != null) {
            headImageView.setPageId(bdUniqueId);
        }
        TbImageView tbImageView = this.f12305g;
        if (tbImageView != null) {
            tbImageView.setPageId(bdUniqueId);
        }
    }

    public void setShowSimpleIcon(boolean z) {
        this.p = z;
    }

    public void setUrl(String str) {
        this.f12307i.setUrl(str);
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (this.j && !z && (headImageView2 = this.f12307i) != null) {
            ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
            ImageView imageView = this.f12306h;
            if (imageView != null) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            TbImageView tbImageView = this.f12305g;
            if (tbImageView != null) {
                tbImageView.setVisibility(8);
            }
            invalidate();
        } else if (!this.j && z && (headImageView = this.f12307i) != null) {
            int width = (int) (this.f12307i.getWidth() * 0.13f);
            int height = (int) (this.f12307i.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
            ImageView imageView2 = this.f12306h;
            if (imageView2 != null) {
                ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(width, height, width, height);
            }
            invalidate();
        }
        this.j = z;
    }

    public HeadPendantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f12303e = context;
        d();
    }

    public HeadPendantView(Context context) {
        super(context);
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f12303e = context;
        d();
    }
}
