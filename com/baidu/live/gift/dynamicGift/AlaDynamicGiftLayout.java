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
    private d XG;
    private com.baidu.live.gift.biggift.b abO;
    private AlaBigGiftExtraInfoView abP;
    private AlaDynamicGiftAnimationView abQ;
    public com.baidu.live.gift.d abR;
    private boolean abS;
    private a abT;
    private boolean aba;
    private int abw;
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
        this.abS = false;
        this.aba = true;
        this.abT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bs(i);
                if (AlaDynamicGiftLayout.this.abO != null) {
                    AlaDynamicGiftLayout.this.abO.ba(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.abP != null) {
                    AlaDynamicGiftLayout.this.abP.end();
                }
                AlaDynamicGiftLayout.this.abS = false;
                if (AlaDynamicGiftLayout.this.abO != null) {
                    AlaDynamicGiftLayout.this.abO.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abS = false;
        this.aba = true;
        this.abT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i) {
                AlaDynamicGiftLayout.this.bs(i);
                if (AlaDynamicGiftLayout.this.abO != null) {
                    AlaDynamicGiftLayout.this.abO.ba(i);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.abP != null) {
                    AlaDynamicGiftLayout.this.abP.end();
                }
                AlaDynamicGiftLayout.this.abS = false;
                if (AlaDynamicGiftLayout.this.abO != null) {
                    AlaDynamicGiftLayout.this.abO.onEnd();
                }
            }
        };
        init(context);
    }

    public AlaDynamicGiftLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abS = false;
        this.aba = true;
        this.abT = new a() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.2
            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameStart() {
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameUpdate(int i2) {
                AlaDynamicGiftLayout.this.bs(i2);
                if (AlaDynamicGiftLayout.this.abO != null) {
                    AlaDynamicGiftLayout.this.abO.ba(i2);
                }
            }

            @Override // com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.a
            public void onFrameEnd() {
                if (AlaDynamicGiftLayout.this.abP != null) {
                    AlaDynamicGiftLayout.this.abP.end();
                }
                AlaDynamicGiftLayout.this.abS = false;
                if (AlaDynamicGiftLayout.this.abO != null) {
                    AlaDynamicGiftLayout.this.abO.onEnd();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(a.h.ala_dynamic_gift_frame_layout, (ViewGroup) this, true);
        this.abQ = (AlaDynamicGiftAnimationView) findViewById(a.g.ala_dynamic_gift_animation_view);
        this.abQ.setFrameCallback(this.abT);
        this.abP = (AlaBigGiftExtraInfoView) findViewById(a.g.ala_big_gift_extra_view);
        this.abP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaDynamicGiftLayout.this.pS();
            }
        });
        this.aba = true;
    }

    public void setData(com.baidu.live.gift.c cVar, d dVar) {
        setData(cVar, dVar, 0, 0);
    }

    public void setData(com.baidu.live.gift.c cVar, d dVar, int i, int i2) {
        if (cVar != null && cVar.Wm != null && cVar.Wm.Wl != null) {
            this.XG = dVar;
            if (i > 0 && i2 > 0) {
                q(i, i2);
            } else {
                qS();
            }
            this.abR = cVar.Wm.Wl;
            this.mFrameCount = this.abR.frame_count;
            if (this.abP != null) {
                if (!dVar.qH()) {
                    this.abP.setVisibility(8);
                    this.aba = false;
                } else {
                    this.abP.setVisibility(0);
                    this.abP.setData(dVar);
                    this.aba = true;
                }
            }
            if (this.abQ != null) {
                this.abQ.setScreen(this.abw, this.mScreenHeight);
                this.abQ.setData(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.XG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(getContext(), String.valueOf(this.XG.userId), this.XG.userName, this.XG.portrait, this.XG.sex, this.XG.aaT, this.XG.location, this.XG.description, 0L, this.XG.aaV, this.XG.aaU, this.XG.userStatus, this.XG.liveId, this.XG.groupId, this.XG.aaY, this.XG.aaZ, this.XG.appId, this.XG.userName, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(int i) {
        if (this.abP != null && this.aba) {
            if (i == ((int) (this.mFrameCount * 0.07f))) {
                this.abP.pP();
            } else if (i == ((int) (this.mFrameCount * 0.87f))) {
                this.abP.pQ();
            }
        }
    }

    public void startAnim() {
        if (!this.abS && this.abQ != null) {
            this.abQ.startAnim();
            this.abS = true;
            if (this.abO != null) {
                this.abO.onStart();
            }
        }
    }

    public void stopAnim() {
        if (this.abS) {
            if (this.abQ != null) {
                this.abQ.stopAnim();
            }
            if (this.abP != null) {
                this.abP.end();
            }
        }
    }

    public void setBigGiftCallBack(com.baidu.live.gift.biggift.b bVar) {
        this.abO = bVar;
    }

    public void onDestroy() {
        if (this.abQ != null) {
            this.abQ.onDestroy();
        }
        if (this.abP != null) {
            this.abP.onDestroy();
        }
    }

    public void at(boolean z) {
        qS();
        if (this.abQ != null) {
            this.abQ.setScreen(this.abw, this.mScreenHeight);
        }
        this.abS = false;
        stopAnim();
        if (this.abO != null) {
            this.abO.onEnd();
        }
    }

    private void qS() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext);
        this.abw = screenDimensions[0];
        this.mScreenHeight = screenDimensions[1];
    }

    private void q(int i, int i2) {
        this.abw = i;
        this.mScreenHeight = i2;
    }
}
