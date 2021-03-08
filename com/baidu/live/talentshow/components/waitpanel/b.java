package com.baidu.live.talentshow.components.waitpanel;

import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.talentshow.components.waitpanel.c;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, LiveVideoBCPanelData> implements a {
    private a.InterfaceC0209a bFE;

    public b(TbPageContext tbPageContext, LiveVideoBCPanelData liveVideoBCPanelData) {
        super(tbPageContext, new c(tbPageContext), liveVideoBCPanelData);
        ((c) this.bKY).a(this);
        eN(80);
        de(true);
        df(true);
        ((c) this.bKY).a(new c.a() { // from class: com.baidu.live.talentshow.components.waitpanel.b.1
            @Override // com.baidu.live.talentshow.components.waitpanel.c.a
            public void c(LiveVideoBCPanelData liveVideoBCPanelData2) {
                if (b.this.bFE != null) {
                    b.this.bFE.a(liveVideoBCPanelData2);
                }
            }
        });
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Sv() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Sw() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        ((c) this.bKY).startLoading();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a, com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        super.dismiss();
        ((c) this.bKY).stopLoading();
    }

    public void b(LiveVideoBCPanelData liveVideoBCPanelData) {
        a((b) liveVideoBCPanelData);
        show();
    }

    public void a(a.InterfaceC0209a interfaceC0209a) {
        this.bFE = interfaceC0209a;
    }
}
