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
/* loaded from: classes3.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private boolean aUX;
    private int aUh;
    private com.baidu.live.im.a.a aWG;
    private boolean aWH;
    private boolean aWI;
    private Paint aWJ;
    private a aWK;
    private boolean aWL;
    private boolean isScrolling;
    private int mLastMotionY;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes3.dex */
    public interface a {
        void EF();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.aWH = true;
        this.aWI = false;
        this.showShadow = false;
        this.aWL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.aWH = true;
        this.aWI = false;
        this.showShadow = false;
        this.aWL = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.aWH = true;
        this.aWI = false;
        this.showShadow = false;
        this.aWL = false;
        init();
    }

    public void setMode(boolean z) {
        this.aWG.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.aWG == null) {
            this.aWG = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.aWL = true;
                } else if (i == 0 && ALAImMsgListView.this.aWL) {
                    ALAImMsgListView.this.aWL = false;
                    ALAImMsgListView.this.EC();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.aWG != null) {
            this.aWG.setDatas(list);
            this.aWG.notifyDataSetChanged();
        }
    }

    public boolean EB() {
        return this.aWI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.aWI = false;
            if (this.aWK != null) {
                this.aWK.EF();
            }
        } else {
            this.aWI = true;
        }
        this.aWH = this.aWI ? false : true;
    }

    public void ED() {
        this.isScrolling = false;
        this.aWH = true;
        this.aWI = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void CZ() {
        if (!this.isScrolling && this.aWH) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Dy() {
        this.showShadow = false;
        this.aWI = false;
        if (this.aWG != null) {
            this.aWG.Dy();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3) {
        if (this.aWG != null) {
            this.aWG.a(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.aWJ = new Paint();
            this.aWJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.aWJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.aWJ.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.aWJ = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void EE() {
        this.aWI = false;
        this.aWH = true;
        if (this.aWG != null) {
            this.aWG.release();
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
        if (this.aWJ != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.aWJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.aUh = x;
            this.mLastMotionY = y;
            this.aWH = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.aUh - x) > 20 || Math.abs(this.mLastMotionY - y) > 20) {
                this.aWH = false;
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            EC();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.aUX = z;
        if (this.aWG != null) {
            this.aWG.setFromMaster(this.aUX);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.aWK = aVar;
    }
}
