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
    private boolean bjm;
    private float bkM;
    private float bkN;
    private com.baidu.live.im.a.a bkO;
    private boolean bkP;
    private boolean bkQ;
    private Paint bkR;
    private a bkS;
    private boolean bkT;
    private boolean bkU;
    private int direction;
    private boolean isScrolling;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void Mx();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bkP = true;
        this.bkQ = false;
        this.showShadow = false;
        this.bkT = false;
        this.bkU = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bkP = true;
        this.bkQ = false;
        this.showShadow = false;
        this.bkT = false;
        this.bkU = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bkP = true;
        this.bkQ = false;
        this.showShadow = false;
        this.bkT = false;
        this.bkU = false;
        init();
    }

    public void setMode(boolean z) {
        this.bkO.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bkO == null) {
            this.bkO = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bkT = true;
                } else if (i == 0 && ALAImMsgListView.this.bkT) {
                    ALAImMsgListView.this.bkT = false;
                    ALAImMsgListView.this.Mu();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bkU = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bkO != null) {
            this.bkO.setDatas(list);
            this.bkO.notifyDataSetChanged();
        }
    }

    public boolean Mt() {
        return this.bkQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mu() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bkQ = false;
            if (this.bkS != null) {
                this.bkS.Mx();
            }
        } else {
            this.bkQ = true;
        }
        this.bkP = this.bkQ ? false : true;
    }

    public void Mv() {
        this.isScrolling = false;
        this.bkP = true;
        this.bkQ = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Li() {
        if (!this.isScrolling && this.bkP) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Ks() {
        this.showShadow = false;
        this.bkQ = false;
        if (this.bkO != null) {
            this.bkO.Ks();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bkO != null) {
            this.bkO.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.bkR = new Paint();
            this.bkR.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bkR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bkR.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.d.sdk_white_alpha0), getResources().getColor(a.d.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bkR = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Mw() {
        this.bkQ = false;
        this.bkP = true;
        if (this.bkO != null) {
            this.bkO.release();
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
        if (this.bkR != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bkR);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bkM = motionEvent.getX();
            this.bkN = motionEvent.getY();
            this.direction = 0;
            this.bkP = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bkM - x) > 20.0f || Math.abs(this.bkN - y) > 20.0f) {
                this.bkP = false;
            }
            if (this.bkU && this.direction == 0 && (Math.abs(x - this.bkM) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bkN) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bkN) * 0.5f > Math.abs(x - this.bkM)) {
                    this.direction = 1;
                    if (y > this.bkN) {
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
            Mu();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bjm = z;
        if (this.bkO != null) {
            this.bkO.setFromMaster(this.bjm);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bkS = aVar;
    }
}
