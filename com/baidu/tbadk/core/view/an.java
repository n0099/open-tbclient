package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ UserLikeButton aia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(UserLikeButton userLikeButton) {
        this.aia = userLikeButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Context context;
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.coreExtra.d.a aVar;
        View.OnClickListener onClickListener2;
        Context context2;
        Context context3;
        if (!com.baidu.adp.lib.util.i.iT()) {
            context2 = this.aia.mContext;
            if (context2 != null) {
                context3 = this.aia.mContext;
                com.baidu.adp.lib.util.k.showToast(context3, t.j.network_ungeilivable);
            }
        }
        onClickListener = this.aia.aeD;
        if (onClickListener != null) {
            onClickListener2 = this.aia.aeD;
            onClickListener2.onClick(this.aia);
        }
        context = this.aia.mContext;
        if (bl.ad(context)) {
            asVar = this.aia.aeC;
            if (asVar != null) {
                asVar2 = this.aia.aeC;
                MetaData author = asVar2.getAuthor();
                if (author != null && author.getGodUserData() != null) {
                    boolean z = author.getGodUserData().getFollowed() == 1;
                    aVar = this.aia.ahY;
                    aVar.a(z ? false : true, author.getPortrait(), author.getUserId());
                }
            }
        }
    }
}
