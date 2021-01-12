package com.baidu.live.talentshow.components.waitpanel;

import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.talentshow.components.waitpanel.c;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, LiveVideoBCPanelData> implements a {
    private a.InterfaceC0201a bAy;

    public b(TbPageContext tbPageContext, LiveVideoBCPanelData liveVideoBCPanelData) {
        super(tbPageContext, new c(tbPageContext), liveVideoBCPanelData);
        ((c) this.bFO).a(this);
        eI(80);
        cW(true);
        cX(true);
        ((c) this.bFO).a(new c.a() { // from class: com.baidu.live.talentshow.components.waitpanel.b.1
            @Override // com.baidu.live.talentshow.components.waitpanel.c.a
            public void c(LiveVideoBCPanelData liveVideoBCPanelData2) {
                if (b.this.bAy != null) {
                    b.this.bAy.a(liveVideoBCPanelData2);
                }
            }
        });
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QI() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean QJ() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        ((c) this.bFO).startLoading();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a, com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        super.dismiss();
        ((c) this.bFO).stopLoading();
    }

    public void b(LiveVideoBCPanelData liveVideoBCPanelData) {
        a((b) liveVideoBCPanelData);
        show();
    }

    public void a(a.InterfaceC0201a interfaceC0201a) {
        this.bAy = interfaceC0201a;
    }
}
