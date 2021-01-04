package com.baidu.live.talentshow.components.waitpanel;

import com.baidu.live.talentshow.components.waitpanel.a;
import com.baidu.live.talentshow.components.waitpanel.c;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b extends com.baidu.live.tieba.pb.interactionpopupwindow.a<c, LiveVideoBCPanelData> implements a {
    private a.InterfaceC0210a bFk;

    public b(TbPageContext tbPageContext, LiveVideoBCPanelData liveVideoBCPanelData) {
        super(tbPageContext, new c(tbPageContext), liveVideoBCPanelData);
        ((c) this.bKA).a(this);
        gp(80);
        da(true);
        db(true);
        ((c) this.bKA).a(new c.a() { // from class: com.baidu.live.talentshow.components.waitpanel.b.1
            @Override // com.baidu.live.talentshow.components.waitpanel.c.a
            public void c(LiveVideoBCPanelData liveVideoBCPanelData2) {
                if (b.this.bFk != null) {
                    b.this.bFk.a(liveVideoBCPanelData2);
                }
            }
        });
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean UD() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public boolean UE() {
        return true;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.c
    public int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a
    public void show() {
        super.show();
        ((c) this.bKA).startLoading();
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.a, com.baidu.live.tieba.pb.interactionpopupwindow.c
    public void dismiss() {
        super.dismiss();
        ((c) this.bKA).stopLoading();
    }

    public void b(LiveVideoBCPanelData liveVideoBCPanelData) {
        a((b) liveVideoBCPanelData);
        show();
    }

    public void a(a.InterfaceC0210a interfaceC0210a) {
        this.bFk = interfaceC0210a;
    }
}
