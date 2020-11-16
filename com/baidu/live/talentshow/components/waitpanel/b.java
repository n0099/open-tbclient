package com.baidu.live.talentshow.components.waitpanel;

import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.talentshow.components.waitpanel.c;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, LiveVideoBCPanelData> implements a {
    private a.InterfaceC0202a bvn;

    public b(TbPageContext tbPageContext, LiveVideoBCPanelData liveVideoBCPanelData) {
        super(tbPageContext, new c(tbPageContext), liveVideoBCPanelData);
        ((c) this.bAE).a(this);
        fP(80);
        cJ(true);
        cK(true);
        ((c) this.bAE).a(new c.a() { // from class: com.baidu.live.talentshow.components.waitpanel.b.1
            @Override // com.baidu.live.talentshow.components.waitpanel.c.a
            public void c(LiveVideoBCPanelData liveVideoBCPanelData2) {
                if (b.this.bvn != null) {
                    b.this.bvn.a(liveVideoBCPanelData2);
                }
            }
        });
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ra() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Rb() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        ((c) this.bAE).startLoading();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a, com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        super.dismiss();
        ((c) this.bAE).stopLoading();
    }

    public void b(LiveVideoBCPanelData liveVideoBCPanelData) {
        a((b) liveVideoBCPanelData);
        show();
    }

    public void a(a.InterfaceC0202a interfaceC0202a) {
        this.bvn = interfaceC0202a;
    }
}
