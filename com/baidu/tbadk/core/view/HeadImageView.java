package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class HeadImageView extends TbClipImageView {
    public String A0;
    public String B0;
    public String C0;
    public String D0;
    public String E0;
    public String K0;
    public int L0;
    public int M0;
    public int N0;
    public int O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public AlaInfoData U0;
    public int V0;
    public int x0;
    public int y0;
    public boolean z0;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    private void G() {
        this.y0 = l.g(getContext(), R.dimen.tbds36);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.N0);
        setDefaultResource(this.M0);
        setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        setBorderColor(SkinManager.getColor(R.color.black_alpha8));
        setBorderSurroundContent(true);
        setConrers(15);
    }

    public void d0(Canvas canvas) {
        if (!this.z0 || this.y0 <= 0) {
            return;
        }
        int i2 = this.R0;
        if (i2 != 0) {
            Drawable drawable = SkinManager.getDrawable(i2);
            if (drawable == null) {
                return;
            }
            int i3 = this.S0;
            int i4 = this.y0;
            int i5 = this.x0;
            int i6 = this.T0;
            drawable.setBounds((i3 - i4) - i5, (i6 - i4) - i5, i3 - i5, i6 - i5);
            drawable.draw(canvas);
            return;
        }
        int i7 = this.Q0;
        if (i7 != 0) {
            Drawable bjhBigVIconDrawable = UtilHelper.getBjhBigVIconDrawable(i7);
            if (bjhBigVIconDrawable == null) {
                return;
            }
            int i8 = this.S0;
            int i9 = this.y0;
            int i10 = this.x0;
            int i11 = this.T0;
            bjhBigVIconDrawable.setBounds((i8 - i9) - i10, (i11 - i9) - i10, i8 - i10, i11 - i10);
            bjhBigVIconDrawable.draw(canvas);
            return;
        }
        int i12 = this.P0;
        if (i12 != 0) {
            Drawable drawable2 = SkinManager.getDrawable(i12);
            if (drawable2 == null) {
                return;
            }
            int i13 = this.S0;
            int i14 = this.y0;
            int i15 = this.x0;
            int i16 = this.T0;
            drawable2.setBounds((i13 - i14) - i15, (i16 - i14) - i15, i13 - i15, i16 - i15);
            drawable2.draw(canvas);
            return;
        }
        Drawable bjhBigVIconDrawable2 = UtilHelper.getBjhBigVIconDrawable(this.O0);
        if (bjhBigVIconDrawable2 == null) {
            return;
        }
        int i17 = this.S0;
        int i18 = this.y0;
        int i19 = this.x0;
        int i20 = this.T0;
        bjhBigVIconDrawable2.setBounds((i17 - i18) - i19, (i20 - i18) - i19, i17 - i19, i20 - i19);
        bjhBigVIconDrawable2.draw(canvas);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas == null) {
            return;
        }
        d0(canvas);
    }

    public AlaInfoData getAlaInfo() {
        return this.U0;
    }

    public String getFName() {
        return this.K0;
    }

    public String getFid() {
        return this.C0;
    }

    public int getFloor() {
        return this.L0;
    }

    public int getLiveStatus() {
        return this.V0;
    }

    public String getTid() {
        return this.D0;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.E0;
    }

    public String getUserId() {
        return this.A0;
    }

    public String getUserName() {
        return this.B0;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.S0 = getWidth();
        this.T0 = getHeight();
    }

    public void setAlaInfo(AlaInfoData alaInfoData) {
        this.U0 = alaInfoData;
    }

    public void setBazhuIconRes(int i2) {
        this.P0 = i2;
    }

    public void setBjhAuthIconRes(int i2) {
        this.Q0 = i2;
    }

    public void setFName(String str) {
        this.K0 = str;
    }

    public void setFid(String str) {
        this.C0 = str;
    }

    public void setFloor(int i2) {
        this.L0 = i2;
    }

    public void setGodIconMargin(int i2) {
        setIsRound(true);
        if (i2 > 0) {
            this.x0 = l.g(getContext(), i2);
        }
        invalidate();
    }

    public void setGodIconResId(int i2) {
        this.O0 = i2;
    }

    public void setGodIconWidth(int i2) {
        if (i2 > 0) {
            this.y0 = l.g(getContext(), i2);
        }
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.z0 = z;
    }

    public void setIsGod(boolean z) {
        this.z0 = z;
        if (z) {
            setGodIconMargin(0);
            return;
        }
        setIsRound(true);
        this.x0 = 0;
        invalidate();
    }

    public void setLiveStatus(int i2) {
        this.V0 = i2;
    }

    public void setOfficialIconResId(int i2) {
        this.R0 = i2;
    }

    public void setShowV(boolean z) {
        this.z0 = z;
    }

    public void setTid(String str) {
        this.D0 = str;
    }

    public void setUrl(String str) {
        this.E0 = str;
    }

    public void setUserId(String str) {
        this.A0 = str;
    }

    public void setUserName(String str) {
        setUserName(str, str + getResources().getString(R.string.somebodys_portrait));
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUserName(String str, String str2) {
        this.B0 = str;
        setContentDescription(str2);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x0 = 0;
        this.y0 = 0;
        this.z0 = false;
        this.A0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.K0 = null;
        this.M0 = R.drawable.transparent_bg;
        this.N0 = R.color.CAM_X0209;
        this.O0 = R.drawable.ic_icon_mask_shen20_n;
        this.P0 = 0;
        this.V0 = -1;
        G();
    }
}
