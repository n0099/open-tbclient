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
    private boolean biV;
    private Paint bkA;
    private a bkB;
    private boolean bkC;
    private boolean bkD;
    private float bkv;
    private float bkw;
    private com.baidu.live.im.a.a bkx;
    private boolean bky;
    private boolean bkz;
    private int direction;
    private boolean isScrolling;
    private int mShadowHeight;
    private boolean showShadow;

    /* loaded from: classes4.dex */
    public interface a {
        void Mo();
    }

    public ALAImMsgListView(Context context) {
        super(context);
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        this.showShadow = false;
        this.bkC = false;
        this.bkD = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        this.showShadow = false;
        this.bkC = false;
        this.bkD = false;
        init();
    }

    public ALAImMsgListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        this.showShadow = false;
        this.bkC = false;
        this.bkD = false;
        init();
    }

    public void setMode(boolean z) {
        this.bkx.setMode(z);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        if (this.bkx == null) {
            this.bkx = new com.baidu.live.im.a.a(tbPageContext, this);
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
                    ALAImMsgListView.this.bkC = true;
                } else if (i == 0 && ALAImMsgListView.this.bkC) {
                    ALAImMsgListView.this.bkC = false;
                    ALAImMsgListView.this.Ml();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_LIVE_IS_MIX), Boolean.class);
        if (runTask != null && runTask.getData() != null) {
            this.bkD = ((Boolean) runTask.getData()).booleanValue();
        }
    }

    @Override // com.baidu.live.im.j
    public void setMsgData(List<com.baidu.live.im.data.a> list) {
        if (this.bkx != null) {
            this.bkx.setDatas(list);
            this.bkx.notifyDataSetChanged();
        }
    }

    public boolean Mk() {
        return this.bkz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ml() {
        if (getLastVisiblePosition() + 1 == getCount()) {
            this.bkz = false;
            if (this.bkB != null) {
                this.bkB.Mo();
            }
        } else {
            this.bkz = true;
        }
        this.bky = this.bkz ? false : true;
    }

    public void Mm() {
        this.isScrolling = false;
        this.bky = true;
        this.bkz = false;
        smoothScrollToPosition(getBottom());
    }

    @Override // com.baidu.live.im.j
    public void KZ() {
        if (!this.isScrolling && this.bky) {
            post(new Runnable() { // from class: com.baidu.live.im.view.ALAImMsgListView.2
                @Override // java.lang.Runnable
                public void run() {
                    ALAImMsgListView.this.smoothScrollToPosition(ALAImMsgListView.this.getBottom());
                }
            });
        }
    }

    public void Kj() {
        this.showShadow = false;
        this.bkz = false;
        if (this.bkx != null) {
            this.bkx.Kj();
        }
    }

    @Override // com.baidu.live.im.j
    public void b(String str, String str2, boolean z, String str3) {
        if (this.bkx != null) {
            this.bkx.b(str, str2, z, str3);
        }
    }

    @Override // com.baidu.live.im.j
    public void setNeedTopAlphaShade(boolean z) {
        if (z) {
            this.mShadowHeight = getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.bkA = new Paint();
            this.bkA.setStyle(Paint.Style.FILL_AND_STROKE);
            this.bkA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
            this.bkA.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, this.mShadowHeight, getResources().getColor(a.c.sdk_white_alpha0), getResources().getColor(a.c.sdk_white_alpha100), Shader.TileMode.CLAMP));
        } else {
            this.mShadowHeight = 0;
            this.bkA = null;
        }
        invalidate();
    }

    @Override // com.baidu.live.im.j
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    public void setLogData(String str, String str2) {
    }

    public void Mn() {
        this.bkz = false;
        this.bky = true;
        if (this.bkx != null) {
            this.bkx.release();
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
        if (this.bkA != null && this.showShadow) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.mShadowHeight, this.bkA);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.bkv = motionEvent.getX();
            this.bkw = motionEvent.getY();
            this.direction = 0;
            this.bky = false;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 2) {
            if (Math.abs(this.bkv - x) > 20.0f || Math.abs(this.bkw - y) > 20.0f) {
                this.bky = false;
            }
            if (this.bkD && this.direction == 0 && (Math.abs(x - this.bkv) > ViewConfiguration.get(getContext()).getScaledTouchSlop() || Math.abs(y - this.bkw) > ViewConfiguration.get(getContext()).getScaledTouchSlop())) {
                if (Math.abs(y - this.bkw) * 0.5f > Math.abs(x - this.bkv)) {
                    this.direction = 1;
                    if (y > this.bkw) {
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
            Ml();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setFromMaster(boolean z) {
        this.biV = z;
        if (this.bkx != null) {
            this.bkx.setFromMaster(this.biV);
        }
    }

    public void setOnUserMoveToBottomIMCallBack(a aVar) {
        this.bkB = aVar;
    }
}
