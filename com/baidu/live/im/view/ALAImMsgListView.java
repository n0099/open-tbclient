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
/* loaded from: classes10.dex */
public class ALAImMsgListView extends BdTypeListView implements j {
    private boolean bgo;
    private boolean bpa;
    private float brB;
    private float brC;
    private com.baidu.live.im.a.a brD;
    private boolean brE;
    private boolean brF;
    private Paint brG;
    private int brH;
    private a brI;
    private boolean brJ;
    private int direction;
    private boolean isScrolling;
    private boolean showShadow;

    /* loaded from: classes10.dex */
    public interface a {
        void LU();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.brE = true;
        this.brF = false;
        this.showShadow = false;
        this.brJ = false;
        this.bgo = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.brE = true;
        this.brF = false;
        this.showShadow = false;
        this.brJ = false;
        this.bgo = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.brE = true;
        this.brF = false;
        this.showShadow = false;
        this.brJ = false;
        this.bgo = false;
        init();
    }

    public void setMode(boolean z) {
        this.brD.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.brD == null) {
            this.brD = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.brJ = true;
                } else if (i == 0 && ALAImMsgListView.this.brJ) {
                    ALAImMsgListView.this.brJ = false;
                    ALAImMsgListView.this.LS();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bgo = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.b> list) {
        if (this.brD != null) {
            this.brD.setDatas(list);
            this.brD.notifyDataSetChanged();
        }
    }

    public boolean LR() {
        return this.brF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.brF = false;
            if (this.brI != null) {
                this.brI.LU();
            }
        } else {
            this.brF = true;
        }
        this.brE = this.brF ? false : true;
    }

    public void LT() {
        this.isScrolling = false;
        this.brE = true;
        this.brF = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void Kf() {
        if (!this.isScrolling && this.brE) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Jj() {
        this.showShadow = false;
        this.brF = false;
        if (this.brD != null) {
            this.brD.Jj();
        }
    }

    @Override // com.baidu.live.im.j
    public void a(String str, String str2, boolean z, String str3, String str4) {
        if (this.brD != null) {
            this.brD.a(str, str2, z, str3, str4);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.brH = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.brG = new Paint();
            this.brG.setStyle(Paint.Style.FILL_AND_STROKE);
            this.brG.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.brG.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.brH, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.brH = 0;
            this.brG = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void KM() {
        this.brF = false;
        this.brE = true;
        if (this.brD != null) {
            this.brD.release();
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
        if (this.brG != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.brH, this.brG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.brB = motionEvent.getX();
            this.brC = motionEvent.getY();
            this.direction = 0;
            this.brE = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.brB - x) > 20.0f || Math.abs(this.brC - y) > 20.0f) {
                this.brE = false;
            }
            if (this.direction == 0 && (Math.abs(x - this.brB) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.brC) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.brC) * 0.5f > Math.abs(x - this.brB)) {
                    this.direction = 1;
                    if (y > this.brC) {
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
            LS();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.bpa = z;
        if (this.brD != null) {
            this.brD.setFromMaster(this.bpa);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.brI = aVar;
    }

    public com.baidu.live.im.a.a getAdapterManager() {
        return this.brD;
    }
}
