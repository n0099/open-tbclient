package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ UserLikeButton aey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UserLikeButton userLikeButton) {
        this.aey = userLikeButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Context context;
        az azVar;
        az azVar2;
        int i;
        boolean hadConcerned;
        com.baidu.tbadk.coreExtra.d.a aVar;
        String str;
        BdUniqueId bdUniqueId;
        View.OnClickListener onClickListener2;
        Context context2;
        Context context3;
        if (!com.baidu.adp.lib.util.i.ff()) {
            context2 = this.aey.mContext;
            if (context2 != null) {
                context3 = this.aey.mContext;
                com.baidu.adp.lib.util.k.showToast(context3, u.j.network_ungeilivable);
            }
        }
        onClickListener = this.aey.aat;
        if (onClickListener != null) {
            onClickListener2 = this.aey.aat;
            onClickListener2.onClick(this.aey);
        }
        context = this.aey.mContext;
        if (bn.ab(context)) {
            azVar = this.aey.aas;
            if (azVar != null) {
                azVar2 = this.aey.aas;
                MetaData author = azVar2.getAuthor();
                if (author != null && author.getGodUserData() != null) {
                    GodUserData godUserData = author.getGodUserData();
                    i = this.aey.aev;
                    if (i == 1) {
                        hadConcerned = godUserData.getFollowed() == 1;
                    } else {
                        hadConcerned = author.hadConcerned();
                    }
                    boolean z = godUserData.getType() == 2;
                    aVar = this.aey.aes;
                    boolean z2 = hadConcerned ? false : true;
                    String portrait = author.getPortrait();
                    String userId = author.getUserId();
                    str = this.aey.aet;
                    bdUniqueId = this.aey.aeu;
                    aVar.a(z2, portrait, userId, z, str, bdUniqueId);
                }
            }
        }
    }
}
