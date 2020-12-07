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
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.im.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.List;
/* loaded from: classes4.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private boolean bnn;
    private float bpE;
    private float bpF;
    private com.baidu.live.im.a.a bpG;
    private boolean bpH;
    private boolean bpI;
    private Paint bpJ;
    private a bpK;
    private boolean bpL;
    private boolean bpM;
    private int direction;
    private boolean isScrolling;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void OJ();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        this.showShadow = false;
        this.bpL = false;
        this.bpM = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        this.showShadow = false;
        this.bpL = false;
        this.bpM = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        this.showShadow = false;
        this.bpL = false;
        this.bpM = false;
        init();
    }

    public void setMode(boolean z) {
        this.bpG.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bpG == null) {
            this.bpG = new com.baidu.live.im.a.a(tbPageContext, this);
        }
    }

    private void init() {
        setLayerType(1, null);
        setCacheColorHint(0);
        setDivider(new ColorDrawable(getResources().getColor(17170445)));
        setDividerHeight(getResources().getDimensionPixelSize(a.d.sdk_ds8));
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
                    ALAImMsgListView.this.bpL = true;
                } else if (i == 0 && ALAImMsgListView.this.bpL) {
                    ALAImMsgListView.this.bpL = false;
                    ALAImMsgListView.this.OG();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bpM = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.b> list) {
        if (this.bpG != null) {
            this.bpG.setDatas(list);
            this.bpG.notifyDataSetChanged();
        }
    }

    public boolean OF() {
        return this.bpI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OG() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bpI = false;
            if (this.bpK != null) {
                this.bpK.OJ();
            }
        } else {
            this.bpI = true;
        }
        this.bpH = this.bpI ? false : true;
    }

    public void OH() {
        this.isScrolling = false;
        this.bpH = true;
        this.bpI = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Nc() {
        if (!this.isScrolling && this.bpH) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Ml() {
        this.showShadow = false;
        this.bpI = false;
        if (this.bpG != null) {
            this.bpG.Ml();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        if (this.bpG != null) {
            this.bpG.a(str, str2, z, str3, str4);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bpJ = new Paint();
            this.bpJ.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bpJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bpJ.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bpJ = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void OI() {
        this.bpI = false;
        this.bpH = true;
        if (this.bpG != null) {
            this.bpG.release();
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
        if (this.bpJ != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bpJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bpE = motionEvent.getX();
            this.bpF = motionEvent.getY();
            this.direction = 0;
            this.bpH = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bpE - x) > 20.0f || Math.abs(this.bpF - y) > 20.0f) {
                this.bpH = false;
            }
            if (this.direction == 0 && (Math.abs(x - this.bpE) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bpF) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bpF) * 0.5f > Math.abs(x - this.bpE)) {
                    this.direction = 1;
                    if (y > this.bpF) {
                        if (!canScrollVertically(-1)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            return false;
                        }
                    } else if (!canScrollVertically(1)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                } else {
                    this.direction = 2;
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            OG();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bnn = z;
        if (this.bpG != null) {
            this.bpG.setFromMaster(this.bnn);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bpK = aVar;
    }

    public com.baidu.live.im.a.a getAdapterManager() {
        return this.bpG;
    }
}
