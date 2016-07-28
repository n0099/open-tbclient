package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ UserLikeButton afm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserLikeButton userLikeButton) {
        this.afm = userLikeButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Context context;
        be beVar;
        be beVar2;
        int i;
        boolean hadConcerned;
        com.baidu.tbadk.coreExtra.d.a aVar;
        String str;
        BdUniqueId bdUniqueId;
        View.OnClickListener onClickListener2;
        Context context2;
        Context context3;
        if (!com.baidu.adp.lib.util.i.fe()) {
            context2 = this.afm.mContext;
            if (context2 != null) {
                context3 = this.afm.mContext;
                com.baidu.adp.lib.util.k.showToast(context3, u.j.network_ungeilivable);
            }
        }
        onClickListener = this.afm.abc;
        if (onClickListener != null) {
            onClickListener2 = this.afm.abc;
            onClickListener2.onClick(this.afm);
        }
        context = this.afm.mContext;
        if (bn.ab(context)) {
            beVar = this.afm.abb;
            if (beVar != null) {
                beVar2 = this.afm.abb;
                MetaData author = beVar2.getAuthor();
                if (author != null && author.getGodUserData() != null) {
                    GodUserData godUserData = author.getGodUserData();
                    i = this.afm.afj;
                    if (i == 1) {
                        hadConcerned = godUserData.getFollowed() == 1;
                    } else {
                        hadConcerned = author.hadConcerned();
                    }
                    boolean z = godUserData.getType() == 2;
                    aVar = this.afm.afg;
                    boolean z2 = hadConcerned ? false : true;
                    String portrait = author.getPortrait();
                    String userId = author.getUserId();
                    str = this.afm.afh;
                    bdUniqueId = this.afm.afi;
                    aVar.a(z2, portrait, userId, z, str, bdUniqueId);
                }
            }
        }
    }
}
