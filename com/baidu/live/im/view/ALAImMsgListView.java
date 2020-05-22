package com.baidu.live.im.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.im.j;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
import java.util.List;
/* loaded from: classes3.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private int aRB;
    private boolean aSr;
    private com.baidu.live.im.a.a aTZ;
    private boolean aUa;
    private boolean aUb;
    private Paint aUc;
    private a aUd;
    private boolean aUe;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes3.dex */
    public interface a {
        void Ed();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.aUa = true;
        this.aUb = false;
        this.showShadow = false;
        this.aUe = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.aUa = true;
        this.aUb = false;
        this.showShadow = false;
        this.aUe = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.aUa = true;
        this.aUb = false;
        this.showShadow = false;
        this.aUe = false;
        init();
    }

    public void setMode(boolean z) {
        this.aTZ.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.aTZ == null) {
            this.aTZ = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.e.sdk_ds8));
        setSelector(17170445);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.im.view.ALAImMsgListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View childAt;
                if (i == 0 && !ALAImMsgListView.this.showShadow && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.showShadow = true;
                }
                if (i == 1) {
                    ALAImMsgListView.this.aUe = true;
                } else if (i == 0 && ALAImMsgListView.this.aUe) {
                    ALAImMsgListView.this.aUe = false;
                    ALAImMsgListView.this.Ea();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.aTZ != null) {
            this.aTZ.setDatas(list);
            this.aTZ.notifyDataSetChanged();
        }
    }

    public boolean DZ() {
        return this.aUb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.aUb = false;
            if (this.aUd != null) {
                this.aUd.Ed();
            }
        } else {
            this.aUb = true;
        }
        this.aUa = this.aUb ? false : true;
    }

    public void Eb() {
        this.isScrolling = false;
        this.aUa = true;
        this.aUb = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Cz() {
        if (!this.isScrolling && this.aUa) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void CX() {
        this.showShadow = false;
        this.aUb = false;
        if (this.aTZ != null) {
            this.aTZ.CX();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        if (this.aTZ != null) {
            this.aTZ.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.aUc = new Paint();
            this.aUc.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aUc.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aUc.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.aUc = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Ec() {
        this.aUb = false;
        this.aUa = true;
        if (this.aTZ != null) {
            this.aTZ.release();
        }
    }

    @Override // com.baidu.live.im.j
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.aUc != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.aUc);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aRB = x;
            this.mLastMotionY = y;
            this.aUa = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.aRB - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aUa = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            Ea();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.aSr = z;
        if (this.aTZ != null) {
            this.aTZ.setFromMaster(this.aSr);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.aUd = aVar;
    }
}
