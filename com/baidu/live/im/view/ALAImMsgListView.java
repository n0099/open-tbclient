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
import com.baidu.live.im.h;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import java.util.List;
/* loaded from: classes6.dex */
public class ALAImMsgListView extends BdTypeListView implements h {
    private boolean agG;
    private int agh;
    private com.baidu.live.im.a.a ahC;
    private boolean ahD;
    private boolean ahE;
    private Paint ahF;
    private int ahG;
    private boolean ahH;
    private a ahI;
    private boolean ahJ;
    private boolean isScrolling;
    private int mLastMotionY;

    /* loaded from: classes6.dex */
    public interface a {
        void tC();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.ahD = true;
        this.ahE = false;
        this.ahH = false;
        this.ahJ = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.ahD = true;
        this.ahE = false;
        this.ahH = false;
        this.ahJ = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.ahD = true;
        this.ahE = false;
        this.ahH = false;
        this.ahJ = false;
        init();
    }

    public void setMode(boolean z) {
        this.ahC.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.ahC == null) {
            this.ahC = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.e.sdk_ds10));
        setSelector(17170445);
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.im.view.ALAImMsgListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                View childAt;
                if (i == 0 && !ALAImMsgListView.this.ahH && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.ahH = true;
                }
                if (i == 1) {
                    ALAImMsgListView.this.ahJ = true;
                } else if (i == 0 && ALAImMsgListView.this.ahJ) {
                    ALAImMsgListView.this.ahJ = false;
                    ALAImMsgListView.this.tz();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.ahC != null) {
            this.ahC.setDatas(list);
            this.ahC.notifyDataSetChanged();
        }
    }

    public boolean ty() {
        return this.ahE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.ahE = false;
            if (this.ahI != null) {
                this.ahI.tC();
            }
        } else {
            this.ahE = true;
        }
        this.ahD = this.ahE ? false : true;
    }

    public void tA() {
        this.isScrolling = false;
        this.ahD = true;
        this.ahE = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.h
    public void sD() {
        if (!this.isScrolling && this.ahD) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void sX() {
        this.ahH = false;
        this.ahE = false;
        if (this.ahC != null) {
            this.ahC.sX();
        }
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        if (this.ahC != null) {
            this.ahC.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.ahG = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.ahF = new Paint();
            this.ahF.setStyle(Paint.Style.FILL_AND_STROKE);
            this.ahF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.ahF.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.ahG, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.ahG = 0;
            this.ahF = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void tB() {
        this.ahE = false;
        this.ahD = true;
        if (this.ahC != null) {
            this.ahC.release();
        }
    }

    @Override // com.baidu.live.im.h
    public View getView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ahF != null && this.ahH) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.ahG, this.ahF);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.agh = x;
            this.mLastMotionY = y;
            this.ahD = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.agh - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.ahD = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            tz();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.agG = z;
        if (this.ahC != null) {
            this.ahC.setFromMaster(this.agG);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.ahI = aVar;
    }
}
