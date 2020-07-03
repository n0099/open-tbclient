package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class HeadImageView extends TbClipImageView {
    private int XA;
    private AlaInfoData alaInfo;
    private int dZN;
    private int dZO;
    private int dZP;
    private float dZQ;
    private float dZR;
    private String fName;
    private String fid;
    private int height;
    private int iconMargin;
    private boolean isShowV;
    private int liveStatus;
    private int mDefaultBgId;
    private int mDefaultId;
    private int mIconWidth;
    private int mMaskColor;
    private Paint mPaint;
    private String mUrl;
    private String tid;
    private String user_id;
    private String user_name;
    private int width;

    public HeadImageView(Context context) {
        this(context, null, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iconMargin = 0;
        this.mIconWidth = 0;
        this.isShowV = false;
        this.mMaskColor = 0;
        this.user_id = null;
        this.user_name = null;
        this.fid = null;
        this.tid = null;
        this.mUrl = null;
        this.fName = null;
        this.mDefaultId = R.drawable.transparent_bg;
        this.mDefaultBgId = R.color.cp_bg_line_j;
        this.dZN = R.drawable.ic_icon_mask_shen20_n;
        this.dZO = 0;
        this.liveStatus = -1;
        init();
    }

    private void init() {
        this.mIconWidth = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds36);
        setDrawerType(1);
        setGifIconSupport(false);
        setDrawBorder(true);
        setDefaultBgResource(this.mDefaultBgId);
        setDefaultResource(this.mDefaultId);
        setDefaultErrorResource(R.drawable.icon_default_avatar100);
        setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        setBorderColor(an.getColor(R.color.black_alpha8));
        setBorderSurroundContent(true);
        setConrers(15);
        this.mPaint = new Paint();
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public String getUrl() {
        return this.mUrl;
    }

    public void setUserId(String str) {
        this.user_id = str;
    }

    public String getUserId() {
        return this.user_id;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public String getFid() {
        return this.fid;
    }

    public String getTid() {
        return this.tid;
    }

    public void setTid(String str) {
        this.tid = str;
    }

    public void setUserName(String str) {
        setUserName(str, str + getResources().getString(R.string.somebodys_portrait));
    }

    public void setUserName(String str, String str2) {
        this.user_name = str;
        setContentDescription(str2);
    }

    public String getUserName() {
        return this.user_name;
    }

    public void setAlaInfo(AlaInfoData alaInfoData) {
        this.alaInfo = alaInfoData;
    }

    public AlaInfoData getAlaInfo() {
        return this.alaInfo;
    }

    public void setLiveStatus(int i) {
        this.liveStatus = i;
    }

    public int getLiveStatus() {
        return this.liveStatus;
    }

    public void setFName(String str) {
        this.fName = str;
    }

    public String getFName() {
        return this.fName;
    }

    public void setFloor(int i) {
        this.XA = i;
    }

    public int getFloor() {
        return this.XA;
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void startLogPerf() {
        if (!this.canLogPerf) {
            this.canLogPerf = true;
        } else if (this.eGp != null && this.eGp.eAN) {
            this.eGp.bhK();
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            if (this.mMaskColor != 0) {
                this.mPaint.setColor(this.mMaskColor);
                canvas.drawCircle(this.dZQ, this.dZR, this.dZQ, this.mPaint);
            }
            updateVIcon(canvas);
        }
    }

    public void setBjhAuthIconRes(int i) {
        this.dZP = i;
    }

    public void setBazhuIconRes(int i) {
        this.dZO = i;
    }

    public void setGodIconResId(int i) {
        this.dZN = i;
    }

    public void setGodIconWidth(int i) {
        if (i > 0) {
            this.mIconWidth = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        invalidate();
    }

    public void setGodIconMargin(int i) {
        setIsRound(true);
        if (i > 0) {
            this.iconMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), i);
        }
        invalidate();
    }

    public void setIsGod(boolean z) {
        this.isShowV = z;
        if (z) {
            setGodIconMargin(0);
            return;
        }
        setIsRound(true);
        this.iconMargin = 0;
        invalidate();
    }

    public void setIsBigV(boolean z) {
        this.isShowV = z;
    }

    public void setShowV(boolean z) {
        this.isShowV = z;
    }

    public void setMaskColor(int i) {
        this.mMaskColor = i;
    }

    public void updateVIcon(Canvas canvas) {
        Drawable bjhBigVIconDrawable;
        if (this.isShowV && this.dZP != 0 && this.mIconWidth > 0) {
            Drawable bjhBigVIconDrawable2 = UtilHelper.getBjhBigVIconDrawable(this.dZP);
            if (bjhBigVIconDrawable2 != null) {
                bjhBigVIconDrawable2.setBounds((this.width - this.mIconWidth) - this.iconMargin, (this.height - this.mIconWidth) - this.iconMargin, this.width - this.iconMargin, this.height - this.iconMargin);
                bjhBigVIconDrawable2.draw(canvas);
            }
        } else if (this.isShowV && this.dZO != 0 && this.mIconWidth > 0) {
            Drawable drawable = an.getDrawable(this.dZO);
            if (drawable != null) {
                drawable.setBounds((this.width - this.mIconWidth) - this.iconMargin, (this.height - this.mIconWidth) - this.iconMargin, this.width - this.iconMargin, this.height - this.iconMargin);
                drawable.draw(canvas);
            }
        } else if (this.isShowV && this.mIconWidth > 0 && (bjhBigVIconDrawable = UtilHelper.getBjhBigVIconDrawable(this.dZN)) != null) {
            bjhBigVIconDrawable.setBounds((this.width - this.mIconWidth) - this.iconMargin, (this.height - this.mIconWidth) - this.iconMargin, this.width - this.iconMargin, this.height - this.iconMargin);
            bjhBigVIconDrawable.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
        this.dZQ = this.width / 2.0f;
        this.dZR = this.height / 2.0f;
    }
}
