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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes4.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private int bdp;
    private boolean bed;
    private com.baidu.live.im.a.a bfG;
    private boolean bfH;
    private boolean bfI;
    private Paint bfJ;
    private a bfK;
    private boolean bfL;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void KY();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bfH = true;
        this.bfI = false;
        this.showShadow = false;
        this.bfL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bfH = true;
        this.bfI = false;
        this.showShadow = false;
        this.bfL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bfH = true;
        this.bfI = false;
        this.showShadow = false;
        this.bfL = false;
        init();
    }

    public void setMode(boolean z) {
        this.bfG.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bfG == null) {
            this.bfG = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.invalidate();
                }
                if (i == 1) {
                    ALAImMsgListView.this.bfL = true;
                } else if (i == 0 && ALAImMsgListView.this.bfL) {
                    ALAImMsgListView.this.bfL = false;
                    ALAImMsgListView.this.KV();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bfG != null) {
            this.bfG.setDatas(list);
            this.bfG.notifyDataSetChanged();
        }
    }

    public boolean KU() {
        return this.bfI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KV() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bfI = false;
            if (this.bfK != null) {
                this.bfK.KY();
            }
        } else {
            this.bfI = true;
        }
        this.bfH = this.bfI ? false : true;
    }

    public void KW() {
        this.isScrolling = false;
        this.bfH = true;
        this.bfI = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void JI() {
        if (!this.isScrolling && this.bfH) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void JY() {
        this.showShadow = false;
        this.bfI = false;
        if (this.bfG != null) {
            this.bfG.JY();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bfG != null) {
            this.bfG.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.bfJ = new Paint();
            this.bfJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bfJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bfJ.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bfJ = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void KX() {
        this.bfI = false;
        this.bfH = true;
        if (this.bfG != null) {
            this.bfG.release();
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
        if (this.bfJ != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bfJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bdp = x;
            this.mLastMotionY = y;
            this.bfH = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bdp - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.bfH = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            KV();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bed = z;
        if (this.bfG != null) {
            this.bfG.setFromMaster(this.bed);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bfK = aVar;
    }
}
