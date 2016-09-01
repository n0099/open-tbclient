package com.baidu.tbadk.core.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ UserLikeButton aih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UserLikeButton userLikeButton) {
        this.aih = userLikeButton;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.c.a aVar;
        View.OnClickListener onClickListener;
        Context context;
        bg bgVar;
        bg bgVar2;
        int i;
        boolean hadConcerned;
        com.baidu.tbadk.coreExtra.d.a aVar2;
        String str;
        BdUniqueId bdUniqueId;
        View.OnClickListener onClickListener2;
        Context context2;
        Context context3;
        com.baidu.tbadk.c.a aVar3;
        aVar = this.aih.aie;
        if (aVar != null) {
            aVar3 = this.aih.aie;
            if (aVar3.w(view)) {
                return;
            }
        }
        if (!com.baidu.adp.lib.util.i.fZ()) {
            context2 = this.aih.mContext;
            if (context2 != null) {
                context3 = this.aih.mContext;
                com.baidu.adp.lib.util.k.showToast(context3, t.j.network_ungeilivable);
            }
        }
        onClickListener = this.aih.adM;
        if (onClickListener != null) {
            onClickListener2 = this.aih.adM;
            onClickListener2.onClick(this.aih);
        }
        context = this.aih.mContext;
        if (bn.al(context)) {
            bgVar = this.aih.adL;
            if (bgVar != null) {
                bgVar2 = this.aih.adL;
                MetaData author = bgVar2.getAuthor();
                if (author != null && author.getGodUserData() != null) {
                    GodUserData godUserData = author.getGodUserData();
                    i = this.aih.es;
                    if (i == 1) {
                        hadConcerned = godUserData.getFollowed() == 1;
                    } else {
                        hadConcerned = author.hadConcerned();
                    }
                    boolean z = godUserData.getType() == 2;
                    aVar2 = this.aih.aib;
                    boolean z2 = hadConcerned ? false : true;
                    String portrait = author.getPortrait();
                    String userId = author.getUserId();
                    str = this.aih.aic;
                    bdUniqueId = this.aih.aid;
                    aVar2.a(z2, portrait, userId, z, str, bdUniqueId);
                }
            }
        }
    }
}
