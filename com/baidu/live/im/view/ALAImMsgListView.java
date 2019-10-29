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
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class ALAImMsgListView extends BdTypeListView implements h {
    private boolean agY;
    private int agz;
    private com.baidu.live.im.a.a ahU;
    private boolean ahV;
    private boolean ahW;
    private Paint ahX;
    private int ahY;
    private boolean ahZ;
    private a aia;
    private boolean aib;
    private boolean isScrolling;
    private int mLastMotionY;

    /* loaded from: classes6.dex */
    public interface a {
        void tB();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.ahV = true;
        this.ahW = false;
        this.ahZ = false;
        this.aib = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.ahV = true;
        this.ahW = false;
        this.ahZ = false;
        this.aib = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.ahV = true;
        this.ahW = false;
        this.ahZ = false;
        this.aib = false;
        init();
    }

    public void setMode(boolean z) {
        this.ahU.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.ahU == null) {
            this.ahU = new com.baidu.live.im.a.a(tbPageContext, this);
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
                if (i == 0 && !ALAImMsgListView.this.ahZ && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() < 0) {
                    ALAImMsgListView.this.ahZ = true;
                }
                if (i == 1) {
                    ALAImMsgListView.this.aib = true;
                } else if (i == 0 && ALAImMsgListView.this.aib) {
                    ALAImMsgListView.this.aib = false;
                    ALAImMsgListView.this.ty();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.h
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        LinkedList linkedList = new LinkedList(list);
        if (this.ahU != null) {
            this.ahU.setDatas(linkedList);
            this.ahU.notifyDataSetChanged();
        }
    }

    public boolean tx() {
        return this.ahW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ty() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.ahW = false;
            if (this.aia != null) {
                this.aia.tB();
            }
        } else {
            this.ahW = true;
        }
        this.ahV = this.ahW ? false : true;
    }

    public void tz() {
        this.isScrolling = false;
        this.ahV = true;
        this.ahW = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.h
    public void sC() {
        if (!this.isScrolling && this.ahV) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void sW() {
        this.ahZ = false;
        this.ahW = false;
        if (this.ahU != null) {
            this.ahU.sW();
        }
    }

    @Override // com.baidu.live.im.h
    public void a(String str, String str2, boolean z, String str3) {
        if (this.ahU != null) {
            this.ahU.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.h
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.ahY = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.ahX = new Paint();
            this.ahX.setStyle(Paint.Style.FILL_AND_STROKE);
            this.ahX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.ahX.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.ahY, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.ahY = 0;
            this.ahX = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.h
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void tA() {
        this.ahW = false;
        this.ahV = true;
        if (this.ahU != null) {
            this.ahU.release();
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
        if (this.ahX != null && this.ahZ) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.ahY, this.ahX);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.agz = x;
            this.mLastMotionY = y;
            this.ahV = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.agz - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.ahV = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            ty();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.agY = z;
        if (this.ahU != null) {
            this.ahU.setFromMaster(this.agY);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.aia = aVar;
    }
}
