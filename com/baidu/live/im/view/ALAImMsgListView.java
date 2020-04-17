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
    private int aLv;
    private boolean aMl;
    private com.baidu.live.im.a.a aNM;
    private boolean aNN;
    private boolean aNO;
    private Paint aNP;
    private a aNQ;
    private boolean aNR;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes3.dex */
    public interface a {
        void CH();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.aNN = true;
        this.aNO = false;
        this.showShadow = false;
        this.aNR = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.aNN = true;
        this.aNO = false;
        this.showShadow = false;
        this.aNR = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.aNN = true;
        this.aNO = false;
        this.showShadow = false;
        this.aNR = false;
        init();
    }

    public void setMode(boolean z) {
        this.aNM.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.aNM == null) {
            this.aNM = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.aNR = true;
                } else if (i == 0 && ALAImMsgListView.this.aNR) {
                    ALAImMsgListView.this.aNR = false;
                    ALAImMsgListView.this.CE();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.aNM != null) {
            this.aNM.setDatas(list);
            this.aNM.notifyDataSetChanged();
        }
    }

    public boolean CD() {
        return this.aNO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CE() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.aNO = false;
            if (this.aNQ != null) {
                this.aNQ.CH();
            }
        } else {
            this.aNO = true;
        }
        this.aNN = this.aNO ? false : true;
    }

    public void CF() {
        this.isScrolling = false;
        this.aNN = true;
        this.aNO = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Be() {
        if (!this.isScrolling && this.aNN) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void BB() {
        this.showShadow = false;
        this.aNO = false;
        if (this.aNM != null) {
            this.aNM.BB();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        if (this.aNM != null) {
            this.aNM.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.aNP = new Paint();
            this.aNP.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aNP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aNP.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.aNP = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void CG() {
        this.aNO = false;
        this.aNN = true;
        if (this.aNM != null) {
            this.aNM.release();
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
        if (this.aNP != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.aNP);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aLv = x;
            this.mLastMotionY = y;
            this.aNN = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.aLv - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aNN = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            CE();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.aMl = z;
        if (this.aNM != null) {
            this.aNM.setFromMaster(this.aMl);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.aNQ = aVar;
    }
}
