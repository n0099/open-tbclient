package com.baidu.live.talentshow.components.waitpanel;

import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.talentshow.components.waitpanel.c;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, LiveVideoBCPanelData> implements a {
    private a.InterfaceC0212a bAx;

    public b(TbPageContext tbPageContext, LiveVideoBCPanelData liveVideoBCPanelData) {
        super(tbPageContext, new c(tbPageContext), liveVideoBCPanelData);
        ((c) this.bFM).a(this);
        gn(80);
        cX(true);
        cY(true);
        ((c) this.bFM).a(new c.a() { // from class: com.baidu.live.talentshow.components.waitpanel.b.1
            @Override // com.baidu.live.talentshow.components.waitpanel.c.a
            public void c(LiveVideoBCPanelData liveVideoBCPanelData2) {
                if (b.this.bAx != null) {
                    b.this.bAx.a(liveVideoBCPanelData2);
                }
            }
        });
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Ty() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean Tz() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        ((c) this.bFM).startLoading();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a, com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        super.dismiss();
        ((c) this.bFM).stopLoading();
    }

    public void b(LiveVideoBCPanelData liveVideoBCPanelData) {
        a((b) liveVideoBCPanelData);
        show();
    }

    public void a(a.InterfaceC0212a interfaceC0212a) {
        this.bAx = interfaceC0212a;
    }
}
