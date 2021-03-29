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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class HeadPendantView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f13366e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f13367f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13368g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f13369h;
    public HeadImageView i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;

    public HeadPendantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = l.g(TbadkApplication.getInst(), R.dimen.tbds36);
        this.n = 0;
        this.p = true;
        this.f13366e = context;
        d();
    }

    public final void a() {
        ImageView imageView = new ImageView(this.f13366e);
        this.f13369h = imageView;
        imageView.setImageDrawable(null);
        int i = this.m;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(11, -1);
        this.f13369h.setLayoutParams(layoutParams);
        this.f13369h.setVisibility(8);
        addView(this.f13369h);
    }

    public final void b() {
        HeadImageView headImageView = new HeadImageView(this.f13366e);
        this.i = headImageView;
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i.setPlaceHolder(1);
        this.i.setDefaultResource(R.color.CAM_X0205);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        this.i.setLayoutParams(layoutParams);
        addView(this.i);
    }

    public final void c() {
        TbImageView tbImageView = new TbImageView(this.f13366e);
        this.f13368g = tbImageView;
        tbImageView.setPageId(this.f13367f);
        this.f13368g.setDefaultBgResource(0);
        this.f13368g.setDefaultResource(0);
        this.f13368g.setImageDrawable(null);
        this.f13368g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f13368g.setVisibility(8);
        addView(this.f13368g);
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
        if (this.m <= 0 || (imageView = this.f13369h) == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        int i = this.m;
        layoutParams.width = i;
        layoutParams.height = i;
        this.f13369h.setLayoutParams(layoutParams);
    }

    public final void f(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        if (this.o) {
            this.f13369h.setVisibility(8);
            return;
        }
        this.i.setShowV(false);
        if (UtilHelper.showOfficialIcon(this.f13369h, metaData)) {
            return;
        }
        if (metaData.isNewGod()) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f13369h, R.drawable.icon_mask_shen_liang20_svg, SvgManager.SvgResourceStateType.NORMAL);
            g(true);
            return;
        }
        g(false);
        if (this.l || !UtilHelper.showHeadBazhuIcon(this.f13369h, metaData, this.p)) {
            UtilHelper.showHeadBjhBigVIcon(this.f13369h, metaData, this.n);
        }
    }

    public void g(boolean z) {
        ImageView imageView = this.f13369h;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public ImageView getBigVIconView() {
        return this.f13369h;
    }

    public HeadImageView getHeadView() {
        return this.i;
    }

    public TbImageView getPendantView() {
        return this.f13368g;
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

    public void i(MetaData metaData, int i) {
        if (metaData == null) {
            return;
        }
        this.n = i;
        h(metaData);
    }

    public void j(String str, int i, boolean z) {
        this.i.T(str, i, 0, 0, z);
    }

    public void k(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        String headPortraitFilter = HeadIconRefreshHelper.headPortraitFilter(str);
        this.i.setImageBitmap(null);
        this.i.setUrl(headPortraitFilter);
        if (headPortraitFilter.startsWith("http")) {
            j(headPortraitFilter, 10, false);
        } else {
            j(headPortraitFilter, 25, false);
        }
    }

    public void l(String str) {
        if (this.f13368g == null) {
            return;
        }
        if (this.j && !StringUtils.isNull(str)) {
            this.f13368g.setVisibility(0);
            this.f13368g.setImageDrawable(null);
            this.f13368g.W(str, 10, false);
            return;
        }
        this.f13368g.setVisibility(8);
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
    public void onMeasure(int i, int i2) {
        if (this.j) {
            int size = View.MeasureSpec.getSize(i);
            int i3 = (int) (size * 0.13f);
            int size2 = (int) (View.MeasureSpec.getSize(i2) * 0.13f);
            ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).setMargins(i3, size2, i3, size2);
            ImageView imageView = this.f13369h;
            if (imageView != null) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(i3, size2, i3, size2);
            }
        }
        if (this.k) {
            ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).setMargins(0, 0, 0, 0);
            ImageView imageView2 = this.f13369h;
            if (imageView2 != null) {
                ((RelativeLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setAuthIconType(int i) {
        this.n = i;
    }

    public void setAutoChangeStyle(boolean z) {
        this.f13368g.setAutoChangeStyle(z);
        this.i.setAutoChangeStyle(z);
    }

    public void setBigVDimenSize(int i) {
        if (i > 0) {
            this.m = l.g(getContext(), i);
        }
        e();
    }

    public void setBigVIconResId(int i) {
    }

    public void setBjhPbFirstFloor(boolean z) {
        this.k = z;
    }

    public void setDefalutResid(int i) {
        this.i.setDefaultResource(i);
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
        this.f13367f = bdUniqueId;
        HeadImageView headImageView = this.i;
        if (headImageView != null) {
            headImageView.setPageId(bdUniqueId);
        }
        TbImageView tbImageView = this.f13368g;
        if (tbImageView != null) {
            tbImageView.setPageId(bdUniqueId);
        }
    }

    public void setShowSimpleIcon(boolean z) {
        this.p = z;
    }

    public void setUrl(String str) {
        this.i.setUrl(str);
    }

    public void setHasPendantStyle(boolean z) {
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (this.j && !z && (headImageView2 = this.i) != null) {
            ((RelativeLayout.LayoutParams) headImageView2.getLayoutParams()).setMargins(0, 0, 0, 0);
            ImageView imageView = this.f13369h;
            if (imageView != null) {
                ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).setMargins(0, 0, 0, 0);
            }
            TbImageView tbImageView = this.f13368g;
            if (tbImageView != null) {
                tbImageView.setVisibility(8);
            }
            invalidate();
        } else if (!this.j && z && (headImageView = this.i) != null) {
            int width = (int) (this.i.getWidth() * 0.13f);
            int height = (int) (this.i.getHeight() * 0.13f);
            ((RelativeLayout.LayoutParams) headImageView.getLayoutParams()).setMargins(width, height, width, height);
            ImageView imageView2 = this.f13369h;
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
        this.f13366e = context;
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
        this.f13366e = context;
        d();
    }
}
