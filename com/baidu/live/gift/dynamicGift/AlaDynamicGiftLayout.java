package com.baidu.live.gift.dynamicGift;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.biggift.AlaBigGiftExtraInfoView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes6.dex */
public class AlaDynamicGiftLayout extends RelativeLayout implements com.baidu.live.gift.biggift.c {
    private d Xo;
    private boolean aaI;
    private boolean abA;
    private a abB;
    private int abd;
    private com.baidu.live.gift.biggift.b abw;
    private AlaBigGiftExtraInfoView abx;
    private AlaDynamicGiftAnimationView aby;
    public com.baidu.live.gift.d abz;
    private Context mContext;
    private int mFrameCount;
    private int mScreenHeight;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void onFrameEnd();

        void onFrameStart();

        void onFrameUpdate(int i);
    }

    public AlaDynamicGiftLayout(Context context) {
        super(context);
        this.abA = false;
        this.aaI = true;
        this.abB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bs(i);
                if (AlaDynamicGiftLayout.this.abw != null) {
                    AlaDynamicGiftLayout.this.abw.ba(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.abx != null) {
                    AlaDynamicGiftLayout.this.abx.end();
                }
                AlaDynamicGiftLayout.this.abA = false;
                if (AlaDynamicGiftLayout.this.abw != null) {
                    AlaDynamicGiftLayout.this.abw.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abA = false;
        this.aaI = true;
        this.abB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bs(i);
                if (AlaDynamicGiftLayout.this.abw != null) {
                    AlaDynamicGiftLayout.this.abw.ba(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.abx != null) {
                    AlaDynamicGiftLayout.this.abx.end();
                }
                AlaDynamicGiftLayout.this.abA = false;
                if (AlaDynamicGiftLayout.this.abw != null) {
                    AlaDynamicGiftLayout.this.abw.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abA = false;
        this.aaI = true;
        this.abB = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.bs(i2);
                if (AlaDynamicGiftLayout.this.abw != null) {
                    AlaDynamicGiftLayout.this.abw.ba(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.abx != null) {
                    AlaDynamicGiftLayout.this.abx.end();
                }
                AlaDynamicGiftLayout.this.abA = false;
                if (AlaDynamicGiftLayout.this.abw != null) {
                    AlaDynamicGiftLayout.this.abw.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.aby = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.aby.setFrameCallback(this.abB);
        this.abx = (AlaBigGiftExtraInfoView) findViewById(a.g.ala_big_gift_extra_view);
        this.abx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.pS();
            }
        });
        this.aaI = true;
    }

    public void setData(com.baidu.live.gift.c cVar, d dVar) {
        setData(cVar, dVar, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, d dVar, int i, int i2) {
        if (cVar != null && cVar.VT != null && cVar.VT.VS != null) {
            this.Xo = dVar;
            if (i > 0 && i2 > 0) {
                o(i, i2);
            } else {
                qT();
            }
            this.abz = cVar.VT.VS;
            this.mFrameCount = this.abz.frame_count;
            if (this.abx != null) {
                if (!dVar.qI()) {
                    this.abx.setVisibility(8);
                    this.aaI = false;
                } else {
                    this.abx.setVisibility(0);
                    this.abx.setData(dVar);
                    this.aaI = true;
                }
            }
            if (this.aby != null) {
                this.aby.setScreen(this.abd, this.mScreenHeight);
                this.aby.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.Xo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.Xo.userId), this.Xo.userName, this.Xo.portrait, this.Xo.sex, this.Xo.aaB, this.Xo.location, this.Xo.description, 0L, this.Xo.aaD, this.Xo.aaC, this.Xo.userStatus, this.Xo.liveId, this.Xo.groupId, this.Xo.aaG, this.Xo.aaH, this.Xo.appId, this.Xo.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(int i) {
        if (this.abx != null && this.aaI) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.abx.pP();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.abx.pQ();
            }
        }
    }

    public void startAnim() {
        if (!this.abA && this.aby != null) {
            this.aby.startAnim();
            this.abA = true;
            if (this.abw != null) {
                this.abw.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.abA) {
            if (this.aby != null) {
                this.aby.stopAnim();
            }
            if (this.abx != null) {
                this.abx.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.abw = bVar;
    }

    public void onDestroy() {
        if (this.aby != null) {
            this.aby.onDestroy();
        }
        if (this.abx != null) {
            this.abx.onDestroy();
        }
    }

    public void at(boolean z) {
        qT();
        if (this.aby != null) {
            this.aby.setScreen(this.abd, this.mScreenHeight);
        }
        this.abA = false;
        stopAnim();
        if (this.abw != null) {
            this.abw.onEnd();
        }
    }

    private void qT() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.abd = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void o(int i, int i2) {
        this.abd = i;
        this.mScreenHeight = i2;
    }
}
