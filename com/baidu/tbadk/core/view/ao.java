package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ UserLikeButton ahP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(UserLikeButton userLikeButton) {
        this.ahP = userLikeButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.c.a aVar;
        View.OnClickListener onClickListener;
        Context context;
        bi biVar;
        bi biVar2;
        int i;
        boolean hadConcerned;
        com.baidu.tbadk.coreExtra.d.a aVar2;
        String str;
        BdUniqueId bdUniqueId;
        String str2;
        View.OnClickListener onClickListener2;
        Context context2;
        Context context3;
        com.baidu.tbadk.c.a aVar3;
        aVar = this.ahP.ahM;
        if (aVar != null) {
            aVar3 = this.ahP.ahM;
            if (aVar3.w(view)) {
                return;
            }
        }
        if (!com.baidu.adp.lib.util.i.fZ()) {
            context2 = this.ahP.mContext;
            if (context2 != null) {
                context3 = this.ahP.mContext;
                com.baidu.adp.lib.util.k.showToast(context3, r.j.network_ungeilivable);
            }
        }
        onClickListener = this.ahP.adX;
        if (onClickListener != null) {
            onClickListener2 = this.ahP.adX;
            onClickListener2.onClick(this.ahP);
        }
        context = this.ahP.mContext;
        if (bm.ak(context)) {
            biVar = this.ahP.adW;
            if (biVar != null) {
                biVar2 = this.ahP.adW;
                MetaData author = biVar2.getAuthor();
                if (author != null && author.getGodUserData() != null) {
                    GodUserData godUserData = author.getGodUserData();
                    i = this.ahP.es;
                    if (i == 1) {
                        hadConcerned = godUserData.getFollowed() == 1;
                    } else {
                        hadConcerned = author.hadConcerned();
                    }
                    boolean z = godUserData.getType() == 2;
                    aVar2 = this.ahP.ahJ;
                    boolean z2 = hadConcerned ? false : true;
                    String portrait = author.getPortrait();
                    String userId = author.getUserId();
                    str = this.ahP.ahK;
                    bdUniqueId = this.ahP.ahL;
                    str2 = this.ahP.mForumId;
                    aVar2.a(z2, portrait, userId, z, str, bdUniqueId, str2);
                }
            }
        }
    }
}
